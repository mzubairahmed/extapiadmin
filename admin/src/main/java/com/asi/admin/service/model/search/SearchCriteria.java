package com.asi.admin.service.model.search;

public class SearchCriteria {
    
    private Long companyID;
    private Integer pageSize;

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
