package com.asi.admin.service.model.search;

public class SearchCriteria {
    
    private Long companyID;
    private Long pageSize;
    private Boolean isDefaultSearch;

    /**
     * @return the companyID
     */
    public Long getCompanyID() {
        return companyID;
    }

    /**
     * @param companyID the companyID to set
     */
    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    /**
     * @return the pageSize
     */
    public Long getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getIsDefaultSearch() {
        return isDefaultSearch;
    }

    public void setIsDefaultSearch(Boolean isDefaultSearch) {
        this.isDefaultSearch = isDefaultSearch;
    }

}
