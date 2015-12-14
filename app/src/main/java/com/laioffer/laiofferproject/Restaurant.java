package com.laioffer.laiofferproject;

import android.graphics.Bitmap;
/**
 * Created by Neal on 10/27/15.
 */
public class Restaurant {
    private String businessId;
    private String name;
    private String address;
    private String type;
    private double lat;
    private double lng;
    private Bitmap thumbnail;
//    private Bitmap rating;

    /**
     * Constructor
     *
     * @param name name of the restaurant
     */
    public Restaurant(String businessId, String name, String address, String type, double lat, double lng,Bitmap thumbnail) {
        this.businessId = businessId;
        this.name = name;
        this.address = address;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.thumbnail = thumbnail;
//        this.rating = rating;
    }

    /**
     * Getters for private attributes of Restaurant class.
     */
    public String getBusinessId() { return this.businessId; }

    public String getName() { return this.name; }

    public String getAddress() { return this.address; }

    public String getType() { return this.type; }

    public double getLat() { return lat; }

    public double getLng() { return lng; }

    public Bitmap getThumbnail() { return thumbnail; }
//
//    public Bitmap getRating() { return rating; }

}
