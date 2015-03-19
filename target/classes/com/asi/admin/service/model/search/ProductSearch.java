
package com.asi.admin.service.model.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ID",
    "Name",
    "CompanyId",
    "StatusCode",
    "WorkflowStatusCode",
    "WorkflowStatusStateCode",
    "Number",
    "Description",
    "Summary",
    "PublishDate",
    "PrimaryImageUrl",
    "IsWIP",
    "UnpublishDate",
    "CreateDate",
    "UpdateDate",
    "Reason_CD",
    "XID"
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
     * 
     * @return
     *     The UnpublishDate
     */
    @JsonProperty("UnpublishDate")
    public String getUnpublishDate() {
        return UnpublishDate;
    }

    /**
     * 
     * @param UnpublishDate
     *     The UnpublishDate
     */
    @JsonProperty("UnpublishDate")
    public void setUnpublishDate(String UnpublishDate) {
        this.UnpublishDate = UnpublishDate;
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


}
