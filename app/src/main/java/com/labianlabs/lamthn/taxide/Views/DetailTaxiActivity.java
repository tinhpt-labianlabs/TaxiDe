package com.labianlabs.lamthn.taxide.Views;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.labianlabs.lamthn.taxide.Model.Taxi;
import com.labianlabs.lamthn.taxide.R;
import com.labianlabs.lamthn.taxide.Utils.CommunityKeys;

import org.w3c.dom.Text;

public class DetailTaxiActivity extends AppCompatActivity {

    //region SYSTEM EVENTS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_taxi);
        setFinishOnTouchOutside(false);
        mapView();
        receiveData();
        textNameTaxi.setText(taxi.getName());
        onCallClick();
        onCloseClick();
    }
    //endregion

    //region UTILS
    private void receiveData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(CommunityKeys.OPEN_DETAIL_TAXI);
        String code = bundle.getString(CommunityKeys.PUSH_TAXI_DATA_FOR_DETAIL);
        taxi = new Taxi();
        taxi = taxi.decode(code);
    }

    private void mapView(){
        textNameTaxi = findViewById(R.id.text_taxi_name);
        btnCall = findViewById(R.id.btn_call);
        imClose = findViewById(R.id.btn_close);
    }
    //endregion

    //region VIEW EVENTS
    private void onCallClick(){
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+taxi.getPhoneNumber()));
                startActivity(intent);
            }
        });
    }
    private void onCloseClick(){
        imClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    //endregion

    //region VARS
    private TextView textNameTaxi;
    private Button btnCall;
    private ImageView imClose;
    private Taxi taxi;
    //endregion
}
