package com.example.admin.englishmlearning.adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.englishmlearning.ItemTudien;
import com.example.admin.englishmlearning.R;

import java.util.List;
import java.util.Locale;

/**
 * Created by Admin on 3/16/2016.
 */
public class TudienAdapter extends ArrayAdapter<ItemTudien> {

    private TextToSpeech tts;
    public TudienAdapter(Context context, int resource, List<ItemTudien> listTudien) {
        super(context, resource, listTudien);

    }

    public TudienAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi=LayoutInflater.from(getContext());
            v=vi.inflate(R.layout.item_tudien,null);
        }
        //View v = View.inflate(context, R.layout.item_tudien, null);
        TextView tu = (TextView) v.findViewById(R.id.tudien_tu);
        TextView tuloai = (TextView) v.findViewById(R.id.tudien_loaitu);
        TextView phienam = (TextView) v.findViewById(R.id.tudien_phienam);
        TextView dichnghia = (TextView) v.findViewById(R.id.tudien_dichnghia);
        Button btn_phatam = (Button) v.findViewById(R.id.tudien_phatam);

        final ItemTudien item = getItem(position);

        tu.setText(item.getTu());
        tuloai.setText(item.getTuloai());
        phienam.setText(item.getPhienam());
        dichnghia.setText(item.getDichnghia());

        tts=new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);

                }
            }
        });
        btn_phatam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tu_phatam = item.getTu().toString();
                tts.speak(tu_phatam,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        return v;
    }
}
