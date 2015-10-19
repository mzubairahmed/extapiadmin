package com.asi.service.product.client;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.asi.service.product.exception.ExternalApiAuthenticationException;
import com.asi.service.product.exception.InvalidProductException;
import com.asi.service.resource.response.ExternalAPIResponse;


@Component
public class ProductClient {
    
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private Connection connection;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
     }

    public ExternalAPIResponse convertExceptionToResponseModel(Exception e) {

        if (e == null) {
            return getExternalAPIResponse("Bad Request", HttpStatus.BAD_REQUEST, null);
        } else if (e instanceof HttpClientErrorException) {
            if (((HttpClientErrorException) e).getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                return getExternalAPIResponse("Your session expired or is no longer valid", HttpStatus.UNAUTHORIZED, null);
            } else {
                return getExternalAPIResponse(((HttpClientErrorException) e).getResponseBodyAsString(), HttpStatus.BAD_REQUEST, null);
            }
        } else if (e instanceof ExternalApiAuthenticationException) { 
            if (((ExternalApiAuthenticationException) e).getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
                return getExternalAPIResponse("Your session expired or is no longer valid", HttpStatus.UNAUTHORIZED, null);
            } else {
                return getExternalAPIResponse(((ExternalApiAuthenticationException) e).getMessage(), HttpStatus.BAD_REQUEST, null);
            }
        } else if (e instanceof InvalidProductException) {
            return getExternalAPIResponse(e.getMessage(),
                    HttpStatus.BAD_REQUEST, null);
        } else {
            return getExternalAPIResponse("Unhandled Exception while processing request, failed to process product",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    private ExternalAPIResponse getExternalAPIResponse(String message, HttpStatus statusCode, Set<String> additionalInfo) {
        ExternalAPIResponse response = new ExternalAPIResponse();
        if (statusCode != null && message != null && message.toLowerCase().startsWith("{\"Message\":\"Not Valid".toLowerCase())) {
            response.setMessage("Product saved successfully but not active");
            response.setStatusCode(HttpStatus.OK);
        } else {
            response.setStatusCode(statusCode);
            response.setMessage(message);
        }
        response.setAdditionalInfo(additionalInfo);

        return response;
    }
    
    public boolean deleteProductsByCompany(String asiNumber, String ssoId, String ipAddress) {
        boolean status = false;
        StringBuilder deleteProc = new StringBuilder();
        deleteProc.append("exec PROD_Master.dbo.[spLOAD_DeleteProductByASI] ")
        .append("@ASINum = '").append(asiNumber).append("', ")
        .append("@XID = '', ")
        .append("@delimiter = ',', ")
        .append("@IPAddress = '").append(ipAddress).append("', ")
        .append("@Signon_ID = ").append(ssoId);
        
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection.prepareCall(deleteProc.toString());
//            callableStatement.setString(1, asiNumber);
//            callableStatement.setString(2, "");
//            callableStatement.setString(3, ",");
//            callableStatement.setString(4, ipAddress);
//            callableStatement.setInt(5, Integer.parseInt(ssoId));
            
            callableStatement.execute();
            status = true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    
}
