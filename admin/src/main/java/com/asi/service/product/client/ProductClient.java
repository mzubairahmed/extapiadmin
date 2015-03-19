package com.asi.service.product.client;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.asi.service.product.exception.ExternalApiAuthenticationException;
import com.asi.service.product.exception.InvalidProductException;

import com.asi.service.resource.response.ExternalAPIResponse;


@Component
public class ProductClient {

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
    
}
