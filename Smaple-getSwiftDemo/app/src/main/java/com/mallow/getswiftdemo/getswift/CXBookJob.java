
package com.mallow.getswiftdemo.getswift;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class CXBookJob {

    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;
    @SerializedName("firstPageUrl")
    @Expose
    private String firstPageUrl;
    @SerializedName("previousPageUrl")
    @Expose
    private String previousPageUrl;
    @SerializedName("nextPageUrl")
    @Expose
    private String nextPageUrl;
    @SerializedName("lastPageUrl")
    @Expose
    private String lastPageUrl;
    @SerializedName("data")
    @Expose
    private ArrayList<CXDatum> data = new ArrayList<CXDatum>();

    /**
     * @return The currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage The currentPage
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return The pageCount
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount The pageCount
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return The pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize The pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return The totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount The totalCount
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return The firstPageUrl
     */
    public String getFirstPageUrl() {
        return firstPageUrl;
    }

    /**
     * @param firstPageUrl The firstPageUrl
     */
    public void setFirstPageUrl(String firstPageUrl) {
        this.firstPageUrl = firstPageUrl;
    }

    /**
     * @return The previousPageUrl
     */
    public String getPreviousPageUrl() {
        return previousPageUrl;
    }

    /**
     * @param previousPageUrl The previousPageUrl
     */
    public void setPreviousPageUrl(String previousPageUrl) {
        this.previousPageUrl = previousPageUrl;
    }

    /**
     * @return The nextPageUrl
     */
    public String getNextPageUrl() {
        return nextPageUrl;
    }

    /**
     * @param nextPageUrl The nextPageUrl
     */
    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    /**
     * @return The lastPageUrl
     */
    public String getLastPageUrl() {
        return lastPageUrl;
    }

    /**
     * @param lastPageUrl The lastPageUrl
     */
    public void setLastPageUrl(String lastPageUrl) {
        this.lastPageUrl = lastPageUrl;
    }

    /**
     * @return The data
     */
    public ArrayList<CXDatum> getData() {
        return data;
    }

    /**
     * @param data The data
     */
    public void setData(ArrayList<CXDatum> data) {
        this.data = data;
    }

}
