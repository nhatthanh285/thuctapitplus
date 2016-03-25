package com.example.admin.englishmlearning.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.englishmlearning.ItemNguphap;
import com.example.admin.englishmlearning.R;

import java.util.List;

/**
 * Created by Admin on 3/18/2016.
 */
public class NguphapAdapter extends ArrayAdapter<ItemNguphap> {
    public NguphapAdapter(Context context, int resource, List<ItemNguphap> listNguphap) {
        super(context, resource, listNguphap);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_nguphap, null);
        }
        TextView id = (TextView) v.findViewById(R.id.textViewSTT);
        TextView ten = (TextView) v.findViewById(R.id.textViewTenThi);
        TextView congthuc = (TextView) v.findViewById(R.id.textViewCongthuc);
        final TextView dauhieu = (TextView) v.findViewById(R.id.textViewDauhhieu);
        final TextView chitiet = (TextView) v.findViewById(R.id.textViewChitiet);

        final ItemNguphap item = getItem(position);

        id.setText(item.getId() + ":");
        ten.setText(item.getTen());
        congthuc.setText(item.getCongthuc());
        dauhieu.setText(item.getDauhieu());

        /*chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chitiet.getCurrentTextColor() == Color.parseColor("#0004FF")) {
                    chitiet.setTextColor(Color.parseColor("#8B008B"));
                    dauhieu.setVisibility(View.VISIBLE);
                } else {
                    chitiet.setTextColor(Color.parseColor("#0004FF"));
                    dauhieu.setVisibility(View.GONE);
                }

            }
        });*/
        return v;
    }
}
