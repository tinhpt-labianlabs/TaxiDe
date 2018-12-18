package com.labianlabs.lamthn.taxide.Landing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.labianlabs.lamthn.taxide.Adapter.TaxiAdapter;
import com.labianlabs.lamthn.taxide.Model.Taxi;
import com.labianlabs.lamthn.taxide.R;

import java.util.List;

public class LandingActivity extends AppCompatActivity {
    //region SYSTEM EVENTS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    //endregion


}
