package com.labianlabs.lamthn.taxide.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseAdapter {

    private DatabaseHelper helper;
    private Context context;

    public DatabaseAdapter(Context context) {
        this.helper = new DatabaseHelper(context);
        this.context = context;
    }

    //region PUBLIC UTILS
    public void addTaxi(Taxi taxi) {

        String query = "INSERT INTO "+helper.tableName+" (_id,"+helper.nameTaxi+","+
                helper.phoneTaxi+","+helper.descriptionTaxi+","+helper.price4Taxi+","
                +helper.price7Taxi+") VALUES (123,\"abc\",\"123\",\"sdfdsf\",\"3000\",\"7000\")";
        SQLiteDatabase database = helper.getWritableDatabase();
        database.execSQL(query);
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(helper.nameTaxi, taxi.getName());
//        contentValues.put(helper.phoneTaxi, taxi.getName());
//        contentValues.put(helper.descriptionTaxi, taxi.getDescription());
//        contentValues.put(helper.price4Taxi, escapePrice(taxi.getPrice4()));
//        contentValues.put(helper.price7Taxi, escapePrice(taxi.getPrice7()));
//        database.insert(helper.tableName, null, contentValues);
        database.close();
    }

    public Taxi getTaxi(int id) {
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = database.query(helper.tableName, new String[]{String.valueOf(id),
                        helper.nameTaxi, helper.phoneTaxi, helper.descriptionTaxi, helper.price4Taxi, helper.price7Taxi}, id + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Taxi taxi = new Taxi(cursor.getString(1), cursor.getString(2), cursor.getString(3));
        taxi.setPrice4(unescapePrice(cursor.getString(4)));
        taxi.setPrice7(unescapePrice(cursor.getString(5)));
        cursor.close();
        database.close();
        return taxi;
    }

    public List<Taxi> getAllTaxi() {
        List<Taxi> taxis = new ArrayList<>();
        SQLiteDatabase database = helper.getWritableDatabase();
        String[] columns = {helper.nameTaxi, helper.phoneTaxi};
        Log.e("LOGGGG",database.toString());
        Cursor cursor = database.query(helper.tableName,columns,null,null,null,null,null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(helper.nameTaxi));
            String phone = cursor.getString(cursor.getColumnIndex(helper.phoneTaxi));
//            String description = cursor.getString(cursor.getColumnIndex(helper.descriptionTaxi));
//            String price4Code = cursor.getString(cursor.getColumnIndex(helper.price4Taxi));
//            String price7Code = cursor.getString(cursor.getColumnIndex(helper.price7Taxi));
            Taxi taxi = new Taxi(name,phone," ");
//            taxi.setPrice4(unescapePrice(price4Code));
//            taxi.setPrice7(unescapePrice(price7Code));
            taxis.add(taxi);
        }
        cursor.close();
        database.close();
        return taxis;
    }

    private String escapePrice(HashMap<PriceType, Double> priceMap) {
        StringBuffer price = new StringBuffer();
        price.append(String.valueOf(priceMap.get(PriceType.OPEN)));
        price.append(",");
        price.append(String.valueOf(priceMap.get(PriceType.BELOW_20_KM)));
        price.append(",");
        price.append(String.valueOf(priceMap.get(PriceType.UNDER_20_KM)));
        price.append(",");
        price.append(String.valueOf(priceMap.get(PriceType.AIR_PORT)));
        return price.toString().trim();
    }

    private HashMap<PriceType, Double> unescapePrice(String code) {
        String[] temp = code.trim().split(",");
        List<String> data = new ArrayList<>();
        HashMap<PriceType, Double> priceMap = new HashMap<>();
        for (String value : temp) {
            if (!value.isEmpty()) {
                data.add(value);
            }
        }
        priceMap.put(PriceType.OPEN, Double.parseDouble(data.get(0).trim()));
        priceMap.put(PriceType.BELOW_20_KM, Double.parseDouble(data.get(1).trim()));
        priceMap.put(PriceType.UNDER_20_KM, Double.parseDouble(data.get(2).trim()));
        if (!data.get(3).isEmpty()) {
            priceMap.put(PriceType.AIR_PORT, Double.parseDouble(data.get(3).trim()));
        }
        return priceMap;

    }
    //endregion
}
