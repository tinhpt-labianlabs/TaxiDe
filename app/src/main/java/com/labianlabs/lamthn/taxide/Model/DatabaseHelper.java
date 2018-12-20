package com.labianlabs.lamthn.taxide.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //region SYSTEM EVENTS
    public DatabaseHelper(Context context) {
        super(context, dataBaseName, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(dropTable);
        onCreate(sqLiteDatabase);
    }

    //endregion

    //region VARS
    static final String dataBaseName = "taxiData";
    static final String tableName = "taxiTable";
    private Context context;
    public static String nameTaxi = "nameTaxi";
    public static String phoneTaxi = "phoneTaxi";
    public static String price4Taxi = "price4Taxi";
    public static String price7Taxi = "price7Taxi";
    public static String descriptionTaxi = "descriptionTaxi";
    public static String _id = "_id";

    private static final String CREATE_TABLE = "CREATE TABLE "+tableName+
            " ("+_id+" INTEGER PRIMARY KEY, "
            + nameTaxi+" TEXT ,"
            + phoneTaxi +" TEXT ,"
            + descriptionTaxi + "TEXT ,"
            +price4Taxi + "TEXT ,"
            + price7Taxi+" TEXT);";

    private final String dropTable = "DROP TABLE IF EXISTS " + tableName;
    //endregion
}
