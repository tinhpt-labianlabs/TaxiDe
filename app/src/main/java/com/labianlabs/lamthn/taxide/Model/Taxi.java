package com.labianlabs.lamthn.taxide.Model;

import java.util.HashMap;

public class Taxi {
    private String name;
    private String phoneNumber;
    private String description;
    private HashMap<PriceType, Double> price4;
    private HashMap<PriceType, Double> price7;


    public Taxi() {

    }

    public Taxi(String name, String phoneNumber, String description) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.description = description;
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

    public Double getPrice4With(PriceType type) {
        return price4.get(type);
    }

    public Double getPrice7With(PriceType type) {
        return price7.get(type);
    }

    public HashMap<PriceType, Double> getPrice4() {
        return price4;
    }

    public HashMap<PriceType, Double> getPrice7() {
        return price7;
    }
    //endregion

    //region SET


    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice4(HashMap<PriceType, Double> price4) {
        this.price4 = price4;
    }

    public void setPrice7(HashMap<PriceType, Double> price7) {
        this.price7 = price7;
    }

    //endregion
    public String code() {
        return String.format("%s-%s-%s", this.name, this.phoneNumber, this.description);
    }

    public Taxi decode(String code) {
        String[] data = code.split("-");
        Taxi taxi = new Taxi();
        taxi.setName(data[0]);
        taxi.setPhoneNumber(data[1]);
        taxi.setDescription(data[2]);
        return taxi;
    }

}

enum PriceType {
    OPEN, UNDER_20_KM, BELOW_20_KM, AIR_PORT
}
