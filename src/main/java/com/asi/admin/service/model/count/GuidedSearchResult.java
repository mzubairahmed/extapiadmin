package com.asi.admin.service.model.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "Products", "Facets", "PageNumber", "PageSize", "SearchTerm", "Filters", "SearchFilters", "SortBy", "SortOrder",
        "PageCount", "HasPreviousPage", "HasNextPage", "LPD", "HPD", "Total", "Selected", "ID", "showAllTerms", "MoreFilters" })
public class GuidedSearchResult {

    @JsonProperty("Products")
    private List<Object>        Products             = new ArrayList<Object>();
    @JsonProperty("Facets")
    private List<Object>        Facets               = new ArrayList<Object>();
    @JsonProperty("PageNumber")
    private Long                PageNumber;
    @JsonProperty("PageSize")
    private Long                PageSize;
    @JsonProperty("SearchTerm")
    private String              SearchTerm;
    @JsonProperty("Filters")
    private String              Filters;
    @JsonProperty("SearchFilters")
    private List<Object>        SearchFilters        = new ArrayList<Object>();
    @JsonProperty("SortBy")
    private String              SortBy;
    @JsonProperty("SortOrder")
    private Boolean             SortOrder;
    @JsonProperty("PageCount")
    private Long                PageCount;
    @JsonProperty("HasPreviousPage")
    private Boolean             HasPreviousPage;
    @JsonProperty("HasNextPage")
    private Boolean             HasNextPage;
    @JsonProperty("LPD")
    private Long                LPD;
    @JsonProperty("HPD")
    private Long                HPD;
    @JsonProperty("Total")
    private Long                Total;
    @JsonProperty("Selected")
    private Long                Selected;
    @JsonProperty("ID")
    private Long                ID;
    @JsonProperty("showAllTerms")
    private Boolean             showAllTerms;
    @JsonProperty("MoreFilters")
    private Boolean             MoreFilters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *         The Products
     */
    @JsonProperty("Products")
    public List<Object> getProducts() {
        return Products;
    }

    /**
     * 
     * @param Products
     *            The Products
     */
    @JsonProperty("Products")
    public void setProducts(List<Object> Products) {
        this.Products = Products;
    }

    /**
     * 
     * @return
     *         The Facets
     */
    @JsonProperty("Facets")
    public List<Object> getFacets() {
        return Facets;
    }

    /**
     * 
     * @param Facets
     *            The Facets
     */
    @JsonProperty("Facets")
    public void setFacets(List<Object> Facets) {
        this.Facets = Facets;
    }

    /**
     * 
     * @return
     *         The PageNumber
     */
    @JsonProperty("PageNumber")
    public Long getPageNumber() {
        return PageNumber;
    }

    /**
     * 
     * @param PageNumber
     *            The PageNumber
     */
    @JsonProperty("PageNumber")
    public void setPageNumber(Long PageNumber) {
        this.PageNumber = PageNumber;
    }

    /**
     * 
     * @return
     *         The PageSize
     */
    @JsonProperty("PageSize")
    public Long getPageSize() {
        return PageSize;
    }

    /**
     * 
     * @param PageSize
     *            The PageSize
     */
    @JsonProperty("PageSize")
    public void setPageSize(Long PageSize) {
        this.PageSize = PageSize;
    }

    /**
     * 
     * @return
     *         The SearchTerm
     */
    @JsonProperty("SearchTerm")
    public String getSearchTerm() {
        return SearchTerm;
    }

    /**
     * 
     * @param SearchTerm
     *            The SearchTerm
     */
    @JsonProperty("SearchTerm")
    public void setSearchTerm(String SearchTerm) {
        this.SearchTerm = SearchTerm;
    }

    /**
     * 
     * @return
     *         The Filters
     */
    @JsonProperty("Filters")
    public String getFilters() {
        return Filters;
    }

    /**
     * 
     * @param Filters
     *            The Filters
     */
    @JsonProperty("Filters")
    public void setFilters(String Filters) {
        this.Filters = Filters;
    }

    /**
     * 
     * @return
     *         The SearchFilters
     */
    @JsonProperty("SearchFilters")
    public List<Object> getSearchFilters() {
        return SearchFilters;
    }

    /**
     * 
     * @param SearchFilters
     *            The SearchFilters
     */
    @JsonProperty("SearchFilters")
    public void setSearchFilters(List<Object> SearchFilters) {
        this.SearchFilters = SearchFilters;
    }

    /**
     * 
     * @return
     *         The SortBy
     */
    @JsonProperty("SortBy")
    public String getSortBy() {
        return SortBy;
    }

    /**
     * 
     * @param SortBy
     *            The SortBy
     */
    @JsonProperty("SortBy")
    public void setSortBy(String SortBy) {
        this.SortBy = SortBy;
    }

    /**
     * 
     * @return
     *         The SortOrder
     */
    @JsonProperty("SortOrder")
    public Boolean getSortOrder() {
        return SortOrder;
    }

    /**
     * 
     * @param SortOrder
     *            The SortOrder
     */
    @JsonProperty("SortOrder")
    public void setSortOrder(Boolean SortOrder) {
        this.SortOrder = SortOrder;
    }

    /**
     * 
     * @return
     *         The PageCount
     */
    @JsonProperty("PageCount")
    public Long getPageCount() {
        return PageCount;
    }

    /**
     * 
     * @param PageCount
     *            The PageCount
     */
    @JsonProperty("PageCount")
    public void setPageCount(Long PageCount) {
        this.PageCount = PageCount;
    }

    /**
     * 
     * @return
     *         The HasPreviousPage
     */
    @JsonProperty("HasPreviousPage")
    public Boolean getHasPreviousPage() {
        return HasPreviousPage;
    }

    /**
     * 
     * @param HasPreviousPage
     *            The HasPreviousPage
     */
    @JsonProperty("HasPreviousPage")
    public void setHasPreviousPage(Boolean HasPreviousPage) {
        this.HasPreviousPage = HasPreviousPage;
    }

    /**
     * 
     * @return
     *         The HasNextPage
     */
    @JsonProperty("HasNextPage")
    public Boolean getHasNextPage() {
        return HasNextPage;
    }

    /**
     * 
     * @param HasNextPage
     *            The HasNextPage
     */
    @JsonProperty("HasNextPage")
    public void setHasNextPage(Boolean HasNextPage) {
        this.HasNextPage = HasNextPage;
    }

    /**
     * 
     * @return
     *         The LPD
     */
    @JsonProperty("LPD")
    public Long getLPD() {
        return LPD;
    }

    /**
     * 
     * @param LPD
     *            The LPD
     */
    @JsonProperty("LPD")
    public void setLPD(Long LPD) {
        this.LPD = LPD;
    }

    /**
     * 
     * @return
     *         The HPD
     */
    @JsonProperty("HPD")
    public Long getHPD() {
        return HPD;
    }

    /**
     * 
     * @param HPD
     *            The HPD
     */
    @JsonProperty("HPD")
    public void setHPD(Long HPD) {
        this.HPD = HPD;
    }

    /**
     * 
     * @return
     *         The Total
     */
    @JsonProperty("Total")
    public Long getTotal() {
        return Total;
    }

    /**
     * 
     * @param Total
     *            The Total
     */
    @JsonProperty("Total")
    public void setTotal(Long Total) {
        this.Total = Total;
    }

    /**
     * 
     * @return
     *         The Selected
     */
    @JsonProperty("Selected")
    public Long getSelected() {
        return Selected;
    }

    /**
     * 
     * @param Selected
     *            The Selected
     */
    @JsonProperty("Selected")
    public void setSelected(Long Selected) {
        this.Selected = Selected;
    }

    /**
     * 
     * @return
     *         The ID
     */
    @JsonProperty("ID")
    public Long getID() {
        return ID;
    }

    /**
     * 
     * @param ID
     *            The ID
     */
    @JsonProperty("ID")
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * 
     * @return
     *         The showAllTerms
     */
    @JsonProperty("showAllTerms")
    public Boolean getShowAllTerms() {
        return showAllTerms;
    }

    /**
     * 
     * @param showAllTerms
     *            The showAllTerms
     */
    @JsonProperty("showAllTerms")
    public void setShowAllTerms(Boolean showAllTerms) {
        this.showAllTerms = showAllTerms;
    }

    /**
     * 
     * @return
     *         The MoreFilters
     */
    @JsonProperty("MoreFilters")
    public Boolean getMoreFilters() {
        return MoreFilters;
    }

    /**
     * 
     * @param MoreFilters
     *            The MoreFilters
     */
    @JsonProperty("MoreFilters")
    public void setMoreFilters(Boolean MoreFilters) {
        this.MoreFilters = MoreFilters;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}