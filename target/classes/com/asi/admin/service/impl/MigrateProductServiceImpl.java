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

import com.asi.admin.service.model.search.ProductSearch;
import com.asi.admin.service.model.search.SearchCriteria;


public class MigrateProductServiceImpl {
    
    @Autowired
    private RestTemplate restTemplate;
    private String productSearchURL;
    private Integer pageSize;
    
    public List<ProductSearch> getProductsListByCompanyID(Long companyID, String authToken) {
        
        HttpHeaders header = new HttpHeaders();
        header.add("AuthToken", authToken);
        header.setContentType(MediaType.APPLICATION_JSON);
        
        SearchCriteria criteria = new SearchCriteria();
        criteria.setCompanyID(companyID);
        criteria.setPageSize(getPageSize());

        HttpEntity<SearchCriteria> requestEntity = new HttpEntity<SearchCriteria>(criteria, header);

        ResponseEntity<ProductSearch[]> searchResults = restTemplate.exchange(getProductSearchURL(), HttpMethod.POST, requestEntity, ProductSearch[].class);
        
        return Arrays.asList(searchResults.getBody());
        
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
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


}
