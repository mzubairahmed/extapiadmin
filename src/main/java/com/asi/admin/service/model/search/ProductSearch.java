
package com.asi.admin.service.model.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ID",
    "CompanyId",
    "StatusCode",
    "WorkflowStatusCode",
    "WorkflowStatusStateCode",
    "Number",
    "Name",
    "Description",
    "Summary",
    "PublishDate",
    "PrimaryImageUrl",
    "IsWIP",
    "UnpublishDate",
    "Reason_CD",
    "XID",
    "LastUpdatedBy",
    "InReviewComment",
    "CanBlkPrcAdj",
    "CanBlkUpchAdj",
    "CanBlkConf",
    "CanBlkPblsh",
    "CanBlkUnPblsh",
    "CreateDate",
    "UpdateDate"
})
public class ProductSearch {

    @JsonProperty("ID")
    private Long ID;
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("CompanyId")
    private Long CompanyId;
    @JsonProperty("StatusCode")
    private String StatusCode;
    @JsonProperty("WorkflowStatusCode")
    private String WorkflowStatusCode;
    @JsonProperty("WorkflowStatusStateCode")
    private String WorkflowStatusStateCode;
    @JsonProperty("Number")
    private String Number;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("Summary")
    private String Summary;
    @JsonProperty("PublishDate")
    private String PublishDate;
    @JsonProperty("PrimaryImageUrl")
    private String PrimaryImageUrl;
    @JsonProperty("IsWIP")
    private Boolean IsWIP;
    @JsonProperty("UnpublishDate")
    private String UnpublishDate;
    @JsonProperty("CreateDate")
    private String CreateDate;
    @JsonProperty("UpdateDate")
    private String UpdateDate;
    @JsonProperty("Reason_CD")
    private String ReasonCD;
    @JsonProperty("XID")
    private String XID;
    
    @JsonProperty("LastUpdatedBy")
    private String LastUpdatedBy;
    @JsonProperty("InReviewComment")
    private String InReviewComment;
    @JsonProperty("CanBlkPrcAdj")
    private String CanBlkPrcAdj;
    @JsonProperty("CanBlkUpchAdj")
    private String CanBlkUpchAdj;
    @JsonProperty("CanBlkConf")
    private String CanBlkConf;
    @JsonProperty("CanBlkPblsh")
    private String CanBlkPblsh;
    @JsonProperty("CanBlkUnPblsh")
    private String CanBlkUnPblsh;


    /**
     * 
     * @return
     *     The ID
     */
    @JsonProperty("ID")
    public Long getID() {
        return ID;
    }

    /**
     * 
     * @param ID
     *     The ID
     */
    @JsonProperty("ID")
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * 
     * @return
     *     The Name
     */
    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    @JsonProperty("Name")
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @return
     *     The CompanyId
     */
    @JsonProperty("CompanyId")
    public Long getCompanyId() {
        return CompanyId;
    }

    /**
     * 
     * @param CompanyId
     *     The CompanyId
     */
    @JsonProperty("CompanyId")
    public void setCompanyId(Long CompanyId) {
        this.CompanyId = CompanyId;
    }

    /**
     * 
     * @return
     *     The StatusCode
     */
    @JsonProperty("StatusCode")
    public String getStatusCode() {
        return StatusCode;
    }

    /**
     * 
     * @param StatusCode
     *     The StatusCode
     */
    @JsonProperty("StatusCode")
    public void setStatusCode(String StatusCode) {
        this.StatusCode = StatusCode;
    }

    /**
     * 
     * @return
     *     The WorkflowStatusCode
     */
    @JsonProperty("WorkflowStatusCode")
    public String getWorkflowStatusCode() {
        return WorkflowStatusCode;
    }

    /**
     * 
     * @param WorkflowStatusCode
     *     The WorkflowStatusCode
     */
    @JsonProperty("WorkflowStatusCode")
    public void setWorkflowStatusCode(String WorkflowStatusCode) {
        this.WorkflowStatusCode = WorkflowStatusCode;
    }

    /**
     * 
     * @return
     *     The WorkflowStatusStateCode
     */
    @JsonProperty("WorkflowStatusStateCode")
    public String getWorkflowStatusStateCode() {
        return WorkflowStatusStateCode;
    }

    /**
     * 
     * @param WorkflowStatusStateCode
     *     The WorkflowStatusStateCode
     */
    @JsonProperty("WorkflowStatusStateCode")
    public void setWorkflowStatusStateCode(String WorkflowStatusStateCode) {
        this.WorkflowStatusStateCode = WorkflowStatusStateCode;
    }

    /**
     * 
     * @return
     *     The Number
     */
    @JsonProperty("Number")
    public String getNumber() {
        return Number;
    }

    /**
     * 
     * @param Number
     *     The Number
     */
    @JsonProperty("Number")
    public void setNumber(String Number) {
        this.Number = Number;
    }

    /**
     * 
     * @return
     *     The Description
     */
    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    /**
     * 
     * @param Description
     *     The Description
     */
    @JsonProperty("Description")
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * 
     * @return
     *     The Summary
     */
    @JsonProperty("Summary")
    public String getSummary() {
        return Summary;
    }

    /**
     * 
     * @param Summary
     *     The Summary
     */
    @JsonProperty("Summary")
    public void setSummary(String Summary) {
        this.Summary = Summary;
    }

    /**
     * 
     * @return
     *     The PublishDate
     */
    @JsonProperty("PublishDate")
    public String getPublishDate() {
        return PublishDate;
    }

    /**
     * 
     * @param PublishDate
     *     The PublishDate
     */
    @JsonProperty("PublishDate")
    public void setPublishDate(String PublishDate) {
        this.PublishDate = PublishDate;
    }

    /**
     * 
     * @return
     *     The PrimaryImageUrl
     */
    @JsonProperty("PrimaryImageUrl")
    public String getPrimaryImageUrl() {
        return PrimaryImageUrl;
    }

    /**
     * 
     * @param PrimaryImageUrl
     *     The PrimaryImageUrl
     */
    @JsonProperty("PrimaryImageUrl")
    public void setPrimaryImageUrl(String PrimaryImageUrl) {
        this.PrimaryImageUrl = PrimaryImageUrl;
    }

    /**
     * 
     * @return
     *     The IsWIP
     */
    @JsonProperty("IsWIP")
    public Boolean getIsWIP() {
        return IsWIP;
    }

    /**
     * 
     * @param IsWIP
     *     The IsWIP
     */
    @JsonProperty("IsWIP")
    public void setIsWIP(Boolean IsWIP) {
        this.IsWIP = IsWIP;
    }


    /**
     * @return the unpublishDate
     */
    public String getUnpublishDate() {
        return UnpublishDate;
    }

    /**
     * @param unpublishDate the unpublishDate to set
     */
    public void setUnpublishDate(String unpublishDate) {
        UnpublishDate = unpublishDate;
    }

    /**
     * 
     * @return
     *     The CreateDate
     */
    @JsonProperty("CreateDate")
    public String getCreateDate() {
        return CreateDate;
    }

    /**
     * 
     * @param CreateDate
     *     The CreateDate
     */
    @JsonProperty("CreateDate")
    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    /**
     * 
     * @return
     *     The UpdateDate
     */
    @JsonProperty("UpdateDate")
    public String getUpdateDate() {
        return UpdateDate;
    }

    /**
     * 
     * @param UpdateDate
     *     The UpdateDate
     */
    @JsonProperty("UpdateDate")
    public void setUpdateDate(String UpdateDate) {
        this.UpdateDate = UpdateDate;
    }

    /**
     * 
     * @return
     *     The ReasonCD
     */
    @JsonProperty("Reason_CD")
    public String getReasonCD() {
        return ReasonCD;
    }

    /**
     * 
     * @param ReasonCD
     *     The Reason_CD
     */
    @JsonProperty("Reason_CD")
    public void setReasonCD(String ReasonCD) {
        this.ReasonCD = ReasonCD;
    }

    /**
     * 
     * @return
     *     The XID
     */
    @JsonProperty("XID")
    public String getXID() {
        return XID;
    }

    /**
     * 
     * @param XID
     *     The XID
     */
    @JsonProperty("XID")
    public void setXID(String XID) {
        this.XID = XID;
    }

    /**
     * @return the lastUpdatedBy
     */
    public String getLastUpdatedBy() {
        return LastUpdatedBy;
    }

    /**
     * @param lastUpdatedBy the lastUpdatedBy to set
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        LastUpdatedBy = lastUpdatedBy;
    }

    /**
     * @return the inReviewComment
     */
    public String getInReviewComment() {
        return InReviewComment;
    }

    /**
     * @param inReviewComment the inReviewComment to set
     */
    public void setInReviewComment(String inReviewComment) {
        InReviewComment = inReviewComment;
    }

    /**
     * @return the canBlkPrcAdj
     */
    public String getCanBlkPrcAdj() {
        return CanBlkPrcAdj;
    }

    /**
     * @param canBlkPrcAdj the canBlkPrcAdj to set
     */
    public void setCanBlkPrcAdj(String canBlkPrcAdj) {
        CanBlkPrcAdj = canBlkPrcAdj;
    }

    /**
     * @return the canBlkUpchAdj
     */
    public String getCanBlkUpchAdj() {
        return CanBlkUpchAdj;
    }

    /**
     * @param canBlkUpchAdj the canBlkUpchAdj to set
     */
    public void setCanBlkUpchAdj(String canBlkUpchAdj) {
        CanBlkUpchAdj = canBlkUpchAdj;
    }

    /**
     * @return the canBlkConf
     */
    public String getCanBlkConf() {
        return CanBlkConf;
    }

    /**
     * @param canBlkConf the canBlkConf to set
     */
    public void setCanBlkConf(String canBlkConf) {
        CanBlkConf = canBlkConf;
    }

    /**
     * @return the canBlkPblsh
     */
    public String getCanBlkPblsh() {
        return CanBlkPblsh;
    }

    /**
     * @param canBlkPblsh the canBlkPblsh to set
     */
    public void setCanBlkPblsh(String canBlkPblsh) {
        CanBlkPblsh = canBlkPblsh;
    }

    /**
     * @return the canBlkUnPblsh
     */
    public String getCanBlkUnPblsh() {
        return CanBlkUnPblsh;
    }

    /**
     * @param canBlkUnPblsh the canBlkUnPblsh to set
     */
    public void setCanBlkUnPblsh(String canBlkUnPblsh) {
        CanBlkUnPblsh = canBlkUnPblsh;
    }


}
