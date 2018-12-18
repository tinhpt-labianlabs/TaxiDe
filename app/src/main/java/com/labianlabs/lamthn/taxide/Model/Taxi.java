package com.labianlabs.lamthn.taxide.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class Taxi {
    private String name;
    private String phoneNumber;
    private String description;
    private HashMap<PriceType,Double> price;
    private String price4;
    private String price7;

    public Taxi(){

    }

    public Taxi(String name, String phoneNumber, String description, HashMap<PriceType, Double> price) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.price = price;
        this.price4 = "0";
        this.price7 = "0";
    }

    //region GET
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice(PriceType type) {
        return price.get(type);
    }

    public String getPrice4() {
        return price4;
    }

    public String getPrice7() {
        return price7;
    }
    //endregion

    //region SET
    public void setPrice4(String price4) {
        this.price4 = price4;
    }

    public void setPrice7(String price7) {
        this.price7 = price7;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(HashMap<PriceType, Double> price) {
        this.price = price;
    }

    //endregion
    public String code(){
        return String.format("%s-%s-%s",this.name,this.phoneNumber,this.description);
    }

    public Taxi decode(String code){
        String[] data = code.split("-");
        Taxi taxi = new Taxi();
        taxi.setName(data[0]);
        taxi.setPhoneNumber(data[1]);
        taxi.setDescription(data[2]);
        return taxi;
    }

}

enum PriceType{
    OPEN,UNDER_20_KM,BELOW_20_KM,AIR_PORT
}
