package com.asi.service.login.sso.vo;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id", "sign_in_id", "username", "first_name", "last_name", "middle_name", "created", "updated", "asi_number",
        "company_name", "email", "company_id" })
public class SSOBean {

    @JsonProperty("id")
    private Long                id;
    @JsonProperty("sign_in_id")
    private Long                signInId;
    @JsonProperty("username")
    private String              username;
    @JsonProperty("first_name")
    private String              firstName;
    @JsonProperty("last_name")
    private String              lastName;
    @JsonProperty("middle_name")
    private String              middleName;
    @JsonProperty("created")
    private String              created;
    @JsonProperty("updated")
    private String              updated;
    @JsonProperty("asi_number")
    private String              asiNumber;
    @JsonProperty("company_name")
    private String              companyName;
    @JsonProperty("email")
    private String              email;
    @JsonProperty("company_id")
    private Long                companyId;
    @JsonIgnore
    private String              ipAddress;

    /**
     * 
     * @return
     *         The id
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     *            The id
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *         The signInId
     */
    @JsonProperty("sign_in_id")
    public Long getSignInId() {
        return signInId;
    }

    /**
     * 
     * @param signInId
     *            The sign_in_id
     */
    @JsonProperty("sign_in_id")
    public void setSignInId(Long signInId) {
        this.signInId = signInId;
    }

    /**
     * 
     * @return
     *         The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *            The username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *         The firstName
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *            The first_name
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *         The lastName
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *            The last_name
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *         The middleName
     */
    @JsonProperty("middle_name")
    public String getMiddleName() {
        return middleName;
    }

    /**
     * 
     * @param middleName
     *            The middle_name
     */
    @JsonProperty("middle_name")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * 
     * @return
     *         The created
     */
    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *            The created
     */
    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *         The updated
     */
    @JsonProperty("updated")
    public String getUpdated() {
        return updated;
    }

    /**
     * 
     * @param updated
     *            The updated
     */
    @JsonProperty("updated")
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * 
     * @return
     *         The asiNumber
     */
    @JsonProperty("asi_number")
    public String getAsiNumber() {
        return asiNumber;
    }

    /**
     * 
     * @param asiNumber
     *            The asi_number
     */
    @JsonProperty("asi_number")
    public void setAsiNumber(String asiNumber) {
        this.asiNumber = asiNumber;
    }

    /**
     * 
     * @return
     *         The companyName
     */
    @JsonProperty("company_name")
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     * @param companyName
     *            The company_name
     */
    @JsonProperty("company_name")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 
     * @return
     *         The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *            The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *         The companyId
     */
    @JsonProperty("company_id")
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 
     * @param companyId
     *            The company_id
     */
    @JsonProperty("company_id")
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}