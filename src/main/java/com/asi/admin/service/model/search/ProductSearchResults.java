package com.asi.admin.service.model.search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSearchResults {
    
    @JsonProperty("ProductSearch")
    private List<ProductSearch> productSearchResults;

    /**
     * @return the productSearchResults
     */
    public List<ProductSearch> getProductSearchResults() {
        return productSearchResults;
    }

    /**
     * @param productSearchResults the productSearchResults to set
     */
    public void setProductSearchResults(List<ProductSearch> productSearchResults) {
        this.productSearchResults = productSearchResults;
    }

}
