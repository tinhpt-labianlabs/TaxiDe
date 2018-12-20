package com.labianlabs.lamthn.taxide.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataOpenHelper {

    public static List<Taxi> taxis(){
        List<Taxi> taxis = new ArrayList<>();
        Taxi taxiLado = new Taxi("Lado","0633 666 777","Taxi Lâm Đồng hay thường gọi là taxi Lado hoạt động ở Đà Lạt hơn 4 năm, tax Lado có hơn 370 đầu xe trên khắp tỉnh Lâm Đồng.\n" +
                "Taxi Lado được đánh giá là một trong những hãng xe taxi giá rẻ nhất Đà Lạt.");
        HashMap<PriceType,Double> price4Lado = new HashMap<>();
        HashMap<PriceType,Double> price7Lado = new HashMap<>();
        price4Lado.put(PriceType.OPEN,7.000);
        price4Lado.put(PriceType.BELOW_20_KM,11.100);
        price4Lado.put(PriceType.UNDER_20_KM,6.800);
        price4Lado.put(PriceType.AIR_PORT,170.000);

        price7Lado.put(PriceType.OPEN,7.000);
        price7Lado.put(PriceType.BELOW_20_KM,15.200);
        price7Lado.put(PriceType.UNDER_20_KM,8.600);
        price7Lado.put(PriceType.AIR_PORT,190.000);

        taxiLado.setPrice4(price4Lado);
        taxiLado.setPrice7(price7Lado);

        taxis.add(taxiLado);
        taxis.add(taxiLado);
        taxis.add(taxiLado);

        return taxis;
    }



}
