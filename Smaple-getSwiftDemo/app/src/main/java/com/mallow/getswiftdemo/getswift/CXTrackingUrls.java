
package com.mallow.getswiftdemo.getswift;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CXTrackingUrls {

    @SerializedName("www")
    @Expose
    private String www;
    @SerializedName("api")
    @Expose
    private String api;

    /**
     * @return The www
     */
    public String getWww() {
        return www;
    }

    /**
     * @param www The www
     */
    public void setWww(String www) {
        this.www = www;
    }

    /**
     * @return The api
     */
    public String getApi() {
        return api;
    }

    /**
     * @param api The api
     */
    public void setApi(String api) {
        this.api = api;
    }

}
