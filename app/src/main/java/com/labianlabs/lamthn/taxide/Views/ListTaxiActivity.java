package com.labianlabs.lamthn.taxide.Views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.labianlabs.lamthn.taxide.Adapter.TaxiAdapter;
import com.labianlabs.lamthn.taxide.AppInstance;
import com.labianlabs.lamthn.taxide.Model.DatabaseAdapter;
import com.labianlabs.lamthn.taxide.Model.DatabaseHelper;
import com.labianlabs.lamthn.taxide.Model.Taxi;
import com.labianlabs.lamthn.taxide.R;
import com.labianlabs.lamthn.taxide.Utils.CommunityKeys;

import java.util.ArrayList;
import java.util.List;

public class ListTaxiActivity extends AppCompatActivity implements TaxiAdapter.ItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_taxi);
        mapView();
        setupCommonListTaxi();
        mStore = AppInstance.getStore();
    }

    //region UTILS
    private void openDetail(int id) {
        Intent intent = new Intent(this, DetailTaxiActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(CommunityKeys.PUSH_TAXI_DATA_FOR_DETAIL, taxis.get(id).code());
        intent.putExtra(CommunityKeys.OPEN_DETAIL_TAXI, bundle);
        startActivity(intent);
    }

    private void setupCommonListTaxi() {
        taxis = AppInstance.getStore().getAllTaxi();
        TaxiAdapter taxiAdapter = new TaxiAdapter(this, taxis);
        listTaxi.setAdapter(taxiAdapter);
        taxiAdapter.setItemClickListener(this);
    }

    private void mapView() {
        listTaxi = findViewById(R.id.list_taxi);
    }
    //endregion

    //region VIEW EVENTS

    @Override
    public void onItemClick(int position) {
        openDetail(position);
    }

    @Override
    public void onCallClick(String phoneNumber) {
        call(phoneNumber);
    }

    private void call(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phoneNumber));
        startActivity(intent);
    }
    //endregion

    //region VARS
    private ListView listTaxi;
    private List<Taxi> taxis;
    private DatabaseAdapter mStore;
    //endregion
}
