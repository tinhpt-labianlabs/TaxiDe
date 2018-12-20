package com.labianlabs.lamthn.taxide.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.labianlabs.lamthn.taxide.Model.Taxi;
import com.labianlabs.lamthn.taxide.R;

import java.util.List;

public class TaxiAdapter extends BaseAdapter {
    //region VARS
    private Context context;
    private List<Taxi> taxis;
    private TaxiHolder taxiHolder;
    private LayoutInflater layoutInflater;
    private ItemClickListener itemClickListener;
    //endregion

    //region INTERFACE
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(int id);
        void onCallClick(String phoneNumber);
    }
    //endregion

    //region CONSTRUCTOR
    public TaxiAdapter(Context context, List<Taxi> taxis) {
        this.context = context;
        this.taxis = taxis;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //endregion

    //region SYSTEM EVENTS
    @Override
    public int getCount() {
        return taxis.size();
    }

    @Override
    public Object getItem(int i) {
        return taxis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        taxiHolder = new TaxiHolder();
        if (view == null) {
            view = layoutInflater.inflate(R.layout.taxi_item_component, null);
            taxiHolder.btnCall = view.findViewById(R.id.btn_call);
            taxiHolder.imageAvatar = view.findViewById(R.id.im_avatar);
            taxiHolder.textName = view.findViewById(R.id.text_name);
            taxiHolder.textPrice4 = view.findViewById(R.id.text_price_4);
            taxiHolder.textPrice7 = view.findViewById(R.id.text_price_7);
            taxiHolder.containerInfo = view.findViewById(R.id.container_info);
            view.setTag(taxiHolder);
        } else {
            taxiHolder = (TaxiHolder) view.getTag();
        }
        onRowClick(i);
        onCallClick(i);
        updateUI(i);
        return view;
    }

    //endregion

    //region UTILS
    private void onCallClick(final int position) {
        taxiHolder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onCallClick(taxis.get(position).getPhoneNumber());
            }
        });
    }

    private void onRowClick(final int position) {
        taxiHolder.containerInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(position);
            }
        });

        taxiHolder.imageAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(position);
            }
        });
    }

    private void updateUI(int position) {
        taxiHolder.textName.setText(taxis.get(position).getName());
        taxiHolder.textPrice4.setText(taxis.get(position).getPrice4());
        taxiHolder.textPrice7.setText(taxis.get(position).getPrice7());
    }
    //endregion
}

class TaxiHolder {
    TextView textName;
    TextView textPrice4;
    TextView textPrice7;
    ImageView imageAvatar;
    Button btnCall;
    LinearLayout containerInfo;
}