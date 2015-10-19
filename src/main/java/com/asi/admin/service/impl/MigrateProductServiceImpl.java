package com.asi.admin.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.asi.admin.service.model.count.GuidedSearchResult;
import com.asi.admin.service.model.search.ProductSearch;
import com.asi.admin.service.model.search.SearchCriteria;


public class MigrateProductServiceImpl {
    
    public static final String AUTH_TOKEN_KEY = "Authorization";
    public static final String AUTHENTICATION_SCHEME = "Bearer ";
    
    @Autowired
    private RestTemplate restTemplate;
    private String productSearchURL;
    private String productCountURL;
    
    public List<ProductSearch> getProductsListByCompanyID(Long companyID, Long count, String authToken) {
        
        HttpHeaders header = new HttpHeaders();
        header.add(AUTH_TOKEN_KEY, AUTHENTICATION_SCHEME + authToken);
        header.setContentType(MediaType.APPLICATION_JSON);
        
        SearchCriteria criteria = new SearchCriteria();
        criteria.setCompanyID(companyID);
        criteria.setPageSize(count);

        HttpEntity<SearchCriteria> requestEntity = new HttpEntity<SearchCriteria>(criteria, header);

        ResponseEntity<ProductSearch[]> searchResults = restTemplate.exchange(getProductSearchURL(), HttpMethod.POST, requestEntity, ProductSearch[].class);
        
        return Arrays.asList(searchResults.getBody());
        
    }
    
    public Long getProductCount(Long companyId, String authToken) {

        HttpHeaders header = new HttpHeaders();
        
        header.add(AUTH_TOKEN_KEY, AUTHENTICATION_SCHEME + authToken);
        header.setContentType(MediaType.APPLICATION_JSON);
        
        SearchCriteria criteria = new SearchCriteria();
        criteria.setCompanyID(companyId);
        criteria.setIsDefaultSearch(true);
        
        HttpEntity<SearchCriteria> requestEntity = new HttpEntity<SearchCriteria>(criteria, header);
        
        ResponseEntity<GuidedSearchResult> countResult = restTemplate.exchange(getProductCountURL(), HttpMethod.POST, requestEntity, GuidedSearchResult.class);
        
        return countResult.getBody().getTotal();

    }

    /**
     * @return the restTemplate
     */
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    /**
     * @param restTemplate the restTemplate to set
     */
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * @return the productSearchURL
     */
    public String getProductSearchURL() {
        return productSearchURL;
    }

    /**
     * @param productSearchURL the productSearchURL to set
     */
    public void setProductSearchURL(String productSearchURL) {
        this.productSearchURL = productSearchURL;
    }

    /**
     * @return the productCountURL
     */
    public String getProductCountURL() {
        return productCountURL;
    }

    /**
     * @param productCountURL the productCountURL to set
     */
    public void setProductCountURL(String productCountURL) {
        this.productCountURL = productCountURL;
    }


}
