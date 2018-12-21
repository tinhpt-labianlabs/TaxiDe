package com.labianlabs.lamthn.taxide;

import android.app.Application;

import com.labianlabs.lamthn.taxide.Model.DataOpenHelper;
import com.labianlabs.lamthn.taxide.Model.DatabaseAdapter;
import com.labianlabs.lamthn.taxide.Model.DatabaseHelper;
import com.labianlabs.lamthn.taxide.Model.Taxi;

public class AppInstance extends Application {

    //region VARS
    public static AppInstance mInstance;
    public static DatabaseAdapter mStore;
    //endregion

    public AppInstance() {
        mInstance = this;
    }

    public static AppInstance getInstance() {
        if (mInstance == null) {
            mInstance = new AppInstance();
        }
        return mInstance;
    }

    public static DatabaseAdapter getStore() {
        getInstance();
        if (mStore == null) {
            mStore = new DatabaseAdapter(mInstance);
            addData();
        }
        return mStore;
    }

    public static void addData() {
        for (Taxi taxi : DataOpenHelper.taxis()) {
            mStore.addTaxi(taxi);
        }
    }
}
