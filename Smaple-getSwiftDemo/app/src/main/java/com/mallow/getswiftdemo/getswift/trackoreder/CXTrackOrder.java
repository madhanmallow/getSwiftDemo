
package com.mallow.getswiftdemo.getswift.trackoreder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class CXTrackOrder {

    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("pickupLocation")
    @Expose
    private CXTrackOrderPickupLocation pickupLocation;
    @SerializedName("dropoffLocation")
    @Expose
    private CXTrackOrderDropoffLocation dropoffLocation;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    @SerializedName("currentStatus")
    @Expose
    private String currentStatus;
    @SerializedName("driver")
    @Expose
    private Object driver;
    @SerializedName("items")
    @Expose
    private List<Object> items = new ArrayList<Object>();
    @SerializedName("pickupTime")
    @Expose
    private Object pickupTime;
    @SerializedName("dropoffTime")
    @Expose
    private CXTrackOrderDropoffTime dropoffTime;
    @SerializedName("deliveryInstructions")
    @Expose
    private String deliveryInstructions;
    @SerializedName("customerReference")
    @Expose
    private Object customerReference;
    @SerializedName("trackingUrls")
    @Expose
    private CXTrackOrderTrackingUrls trackingUrls;

    /**
     * @return The created
     */
    public String getCreated() {
        return created;
    }

    /**
     * @param created The created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference The reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return The pickupLocation
     */
    public CXTrackOrderPickupLocation getPickupLocation() {
        return pickupLocation;
    }

    /**
     * @param pickupLocation The pickupLocation
     */
    public void setPickupLocation(CXTrackOrderPickupLocation pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    /**
     * @return The dropoffLocation
     */
    public CXTrackOrderDropoffLocation getDropoffLocation() {
        return dropoffLocation;
    }

    /**
     * @param dropoffLocation The dropoffLocation
     */
    public void setDropoffLocation(CXTrackOrderDropoffLocation dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    /**
     * @return The lastUpdated
     */
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated The lastUpdated
     */
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return The currentStatus
     */
    public String getCurrentStatus() {
        return currentStatus;
    }

    /**
     * @param currentStatus The currentStatus
     */
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    /**
     * @return The driver
     */
    public Object getDriver() {
        return driver;
    }

    /**
     * @param driver The driver
     */
    public void setDriver(Object driver) {
        this.driver = driver;
    }

    /**
     * @return The items
     */
    public List<Object> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Object> items) {
        this.items = items;
    }

    /**
     * @return The pickupTime
     */
    public Object getPickupTime() {
        return pickupTime;
    }

    /**
     * @param pickupTime The pickupTime
     */
    public void setPickupTime(Object pickupTime) {
        this.pickupTime = pickupTime;
    }

    /**
     * @return The dropoffTime
     */
    public CXTrackOrderDropoffTime getDropoffTime() {
        return dropoffTime;
    }

    /**
     * @param dropoffTime The dropoffTime
     */
    public void setDropoffTime(CXTrackOrderDropoffTime dropoffTime) {
        this.dropoffTime = dropoffTime;
    }

    /**
     * @return The deliveryInstructions
     */
    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    /**
     * @param deliveryInstructions The deliveryInstructions
     */
    public void setDeliveryInstructions(String deliveryInstructions) {
        this.deliveryInstructions = deliveryInstructions;
    }

    /**
     * @return The customerReference
     */
    public Object getCustomerReference() {
        return customerReference;
    }

    /**
     * @param customerReference The customerReference
     */
    public void setCustomerReference(Object customerReference) {
        this.customerReference = customerReference;
    }

    /**
     * @return The trackingUrls
     */
    public CXTrackOrderTrackingUrls getTrackingUrls() {
        return trackingUrls;
    }

    /**
     * @param trackingUrls The trackingUrls
     */
    public void setTrackingUrls(CXTrackOrderTrackingUrls trackingUrls) {
        this.trackingUrls = trackingUrls;
    }

}
