
package com.mallow.getswiftdemo.getswift.trackoreder;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CXTrackOrderDropoffTime {

    @SerializedName("earliestTime")
    @Expose
    private String earliestTime;
    @SerializedName("latestTime")
    @Expose
    private String latestTime;

    /**
     * @return The earliestTime
     */
    public String getEarliestTime() {
        return earliestTime;
    }

    /**
     * @param earliestTime The earliestTime
     */
    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime;
    }

    /**
     * @return The latestTime
     */
    public String getLatestTime() {
        return latestTime;
    }

    /**
     * @param latestTime The latestTime
     */
    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

}
