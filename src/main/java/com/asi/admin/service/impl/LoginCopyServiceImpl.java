package com.asi.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.asi.admin.service.model.login.Credential;
import com.asi.service.login.client.vo.AccessData;
import com.asi.service.login.sso.vo.SSOBean;

public class LoginCopyServiceImpl {
    
    @Autowired
    private RestTemplate restTemplate;
    private String sourceLoginEndpoint;
    private String destinationLoginEndpoint;
    private String ssoEndpoint;
    
    public AccessData loginUser(Credential credentials, String loginEndpoint) throws RestClientException {
        
        return restTemplate.postForObject(loginEndpoint, credentials, AccessData.class);
        
    }
    
    
    public AccessData loginUserSourceLocation(Credential credentials) {
        
        return loginUser(credentials, sourceLoginEndpoint);
    }
    
    public AccessData loginUserDestinationLocation(Credential credentials) {
        
        return loginUser(credentials, destinationLoginEndpoint);
    }
    
    public SSOBean getSSOBeanFromAuthToken(String authToken) {
        String ssoURL = ssoEndpoint + authToken;
        return restTemplate.getForObject(ssoURL, SSOBean.class);
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
     * @return the sourceLoginEndpoint
     */
    public String getSourceLoginEndpoint() {
        return sourceLoginEndpoint;
    }


    /**
     * @param sourceLoginEndpoint the sourceLoginEndpoint to set
     */
    public void setSourceLoginEndpoint(String sourceLoginEndpoint) {
        this.sourceLoginEndpoint = sourceLoginEndpoint;
    }


    /**
     * @return the destinationLoginEndpoint
     */
    public String getDestinationLoginEndpoint() {
        return destinationLoginEndpoint;
    }


    /**
     * @param destinationLoginEndpoint the destinationLoginEndpoint to set
     */
    public void setDestinationLoginEndpoint(String destinationLoginEndpoint) {
        this.destinationLoginEndpoint = destinationLoginEndpoint;
    }


    /**
     * @return the ssoEndpoint
     */
    public String getSsoEndpoint() {
        return ssoEndpoint;
    }


    /**
     * @param ssoEndpoint the ssoEndpoint to set
     */
    public void setSsoEndpoint(String ssoEndpoint) {
        this.ssoEndpoint = ssoEndpoint;
    }

}
