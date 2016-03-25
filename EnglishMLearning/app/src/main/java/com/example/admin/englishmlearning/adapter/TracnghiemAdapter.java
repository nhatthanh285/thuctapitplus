package com.example.admin.englishmlearning.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.admin.englishmlearning.ItemNguphap;
import com.example.admin.englishmlearning.ItemTracnghiem;
import com.example.admin.englishmlearning.R;

import java.util.List;

/**
 * Created by Admin on 3/23/2016.
 */
public class TracnghiemAdapter extends ArrayAdapter<ItemTracnghiem>{

    public TracnghiemAdapter(Context context, int resource, List<ItemTracnghiem> itemTracnghiemList) {
        super(context, resource, itemTracnghiemList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.item_tracnghiem, null);
        }
        //TextView id = (TextView) v.findViewById(R.id.textViewSTT);
        TextView stt=(TextView)v.findViewById(R.id.textViewStt);
        TextView noidung = (TextView) v.findViewById(R.id.textViewNoidung);
        RadioButton dapan1=(RadioButton)v.findViewById(R.id.radioButtonDA1);
        RadioButton dapan2=(RadioButton)v.findViewById(R.id.radioButtonDA2);
        RadioButton dapan3=(RadioButton)v.findViewById(R.id.radioButtonDA3);
        RadioButton dapan4=(RadioButton)v.findViewById(R.id.radioButtonDA4);

        final ItemTracnghiem item = getItem(position);
        stt.setText(position+1+ ": ");
        noidung.setText(item.getNoidung() + ":");
        dapan1.setText(item.getDapan1());
        dapan2.setText(item.getDapan2());
        dapan3.setText(item.getDapan3());
        dapan4.setText(item.getDapan4());
        String dapandung=item.getDapandung();


        return v;
    }
}
