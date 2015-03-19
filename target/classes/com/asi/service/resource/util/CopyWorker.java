package com.asi.service.resource.util;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;

import com.asi.admin.service.impl.CopyServiceImpl;
import com.asi.admin.service.impl.MigrateProductServiceImpl;
import com.asi.admin.service.model.Product;
import com.asi.admin.service.model.search.ProductSearch;
import com.asi.service.product.client.ProductClient;
import com.asi.service.resource.response.ExternalAPIResponse;

public class CopyWorker implements Runnable {
    
    private static final Logger _LOGGER = Logger.getLogger(CopyWorker.class.getName());
    
    private Long companyId;
    private String sourceAuthToken;
    private String destinationAuthToken;
    private String asiNumber;
    private String email;
    private Map<String, String> inProgress;
    
    private CopyServiceImpl copyService;

    private MigrateProductServiceImpl   migrationService;
    
    private ProductClient productClient;

    public void run() {
        
        StringBuilder htmlMessage = new StringBuilder();
        
        _LOGGER.debug("Getting list of products that needs to be imported");
        List<ProductSearch> products = getMigrationService().getProductsListByCompanyID(companyId, sourceAuthToken);
        
        _LOGGER.debug("Starting copying process...");
        _LOGGER.debug(products.size() + " will be imported to the destination");
        
        if(getInProgress().containsKey(asiNumber)) {
            copyService.sendInProgressEmail(email, asiNumber);
            return;
        } else {
            getInProgress().put(asiNumber, companyId.toString());
            copyService.sendStartProcessEMail(email, asiNumber);
        }
        
        Product sourceProduct;
        ResponseEntity<ExternalAPIResponse> sourceResponse;
        for (ProductSearch product : products) {

            try {
                sourceProduct = copyService.getSourceProduct(sourceAuthToken, product.getXID());
                if (sourceProduct != null && !StringUtils.isEmpty(sourceProduct.getName())) {
                    sourceResponse = copyService.postProductToDestination(destinationAuthToken, sourceProduct);

                    if (sourceResponse.getStatusCode().equals(HttpStatus.OK)) {
                        htmlMessage.append(getResponse(sourceProduct.getExternalProductId(), "Success", sourceResponse.getBody()));
                    } else {
                        htmlMessage.append(getResponse(sourceProduct.getExternalProductId(), "Failed", sourceResponse.getBody()));
                    }

                }
            } catch (RestClientException e) {
                e.printStackTrace();
                ExternalAPIResponse extResponse = getProductClient().convertExceptionToResponseModel(e);
                try {
                    extResponse = prepareResponse(extResponse.getMessage());
                    htmlMessage.append(getResponse(product.getXID(), "Failed", extResponse));
                } catch (Exception ioe) {
                    _LOGGER.error(ioe);
                }
                
            } catch (Exception e) {
                _LOGGER.error(e);
            }

        }
        _LOGGER.info("Finished copying " + products.size() + " for asi/" + asiNumber);
        getInProgress().remove(asiNumber);
        copyService.sendStatusReportEmail(email, asiNumber, htmlMessage.toString());
    }

    private synchronized ExternalAPIResponse prepareResponse(String jsonException) throws Exception {

        JSONObject json = new JSONObject(jsonException);
        
        ExternalAPIResponse response = new ExternalAPIResponse();
        response.setStatusCode(HttpStatus.BAD_REQUEST);
        response.setMessage(json.getString("Message"));
        
        if(json.get("AdditionalInfo") != null) {
            
            Set<String> additionalInfos = new HashSet<String>();
            JSONArray additionalInfo = json.getJSONArray("AdditionalInfo");
            
            for(int i = 0; i < additionalInfo.length(); i++) {
                additionalInfos.add(additionalInfo.getString(i));
            }
            response.setAdditionalInfo(additionalInfos);
            
        }
        return response;
        
    }
    
    private synchronized String getResponse(String XID, String status, ExternalAPIResponse apiResponse) {
        
        StringBuilder response = new StringBuilder();
        response.append("<tr>").append("<td>").append(XID).append("</td>");
        response.append("<td>").append(status).append("</td>");
        response.append("<td>").append(prepareResponseMessage(apiResponse)).append("</td>");
        response.append("</tr>");
        
        return response.toString();
        
    }
    
    private synchronized String prepareResponseMessage(ExternalAPIResponse response) {
        StringBuilder message = new StringBuilder();
        message.append(response.getMessage());
        
        if(response.getAdditionalInfo() != null && !response.getAdditionalInfo().isEmpty()) {
            message.append("<br>Following errors occurred:");
            for(String additionalInfo : response.getAdditionalInfo()) {
                message.append("<li>").append(additionalInfo).append("</li>");
            }
        }
        
        return message.toString();
    }

    
    public synchronized Long getCompanyId() {
        return companyId;
    }

    public synchronized void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public synchronized String getSourceAuthToken() {
        return sourceAuthToken;
    }

    public synchronized void setSourceAuthToken(String sourceAuthToken) {
        this.sourceAuthToken = sourceAuthToken;
    }

    public synchronized String getDestinationAuthToken() {
        return destinationAuthToken;
    }

    public synchronized void setDestinationAuthToken(String destinationAuthToken) {
        this.destinationAuthToken = destinationAuthToken;
    }

    public synchronized String getAsiNumber() {
        return asiNumber;
    }

    public synchronized void setAsiNumber(String asiNumber) {
        this.asiNumber = asiNumber;
    }

    public synchronized String getEmail() {
        return email;
    }

    public synchronized void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the copyService
     */
    public synchronized CopyServiceImpl getCopyService() {
        return copyService;
    }

    /**
     * @param copyService the copyService to set
     */
    public synchronized void setCopyService(CopyServiceImpl copyService) {
        this.copyService = copyService;
    }

    /**
     * @return the migrationService
     */
    public synchronized MigrateProductServiceImpl getMigrationService() {
        return migrationService;
    }

    /**
     * @param migrationService the migrationService to set
     */
    public synchronized void setMigrationService(MigrateProductServiceImpl migrationService) {
        this.migrationService = migrationService;
    }

    /**
     * @return the productClient
     */
    public synchronized ProductClient getProductClient() {
        return productClient;
    }

    /**
     * @param productClient the productClient to set
     */
    public synchronized void setProductClient(ProductClient productClient) {
        this.productClient = productClient;
    }

    /**
     * @return the inProgress
     */
    public synchronized Map<String, String> getInProgress() {
        return inProgress;
    }

    /**
     * @param inProgress the inProgress to set
     */
    public synchronized void setInProgress(Map<String, String> inProgress) {
        this.inProgress = inProgress;
    }

}
