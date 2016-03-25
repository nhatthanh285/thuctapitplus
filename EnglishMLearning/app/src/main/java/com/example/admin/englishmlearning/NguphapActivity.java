package com.example.admin.englishmlearning;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.englishmlearning.R;
import com.example.admin.englishmlearning.adapter.NguphapAdapter;
import com.example.admin.englishmlearning.adapter.TudienAdapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NguphapActivity extends AppCompatActivity {
    private List<ItemNguphap> listNguphap;
    private NguphapAdapter nguphapAdapter;
    private ListView listViewNguphap;
    private DatabaseAcess databaseAcess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguphap);

        //init
        listViewNguphap=(ListView)findViewById(R.id.listViewNguphap);
        listNguphap=new ArrayList<>();
        databaseAcess=new DatabaseAcess(this);
        databaseAcess=databaseAcess.getInstance(this);
        databaseAcess.open();
        Cursor cursor = null;
        try {
            cursor = databaseAcess.QueryData("select * from nguphap");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (cursor != null) {
            while (cursor.moveToNext()) {

                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String ten = cursor.getString(cursor.getColumnIndex("ten_nguphap"));
                String congthuc = cursor.getString(cursor.getColumnIndex("cong_thuc"));
                String dauhieu = cursor.getString(cursor.getColumnIndex("dau_hieu"));

                listNguphap.add(new ItemNguphap(id, ten, congthuc, dauhieu));

            }
        }
        nguphapAdapter = new NguphapAdapter(this, R.layout.item_nguphap, listNguphap);
        listViewNguphap.setAdapter(nguphapAdapter);

        listViewNguphap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listViewNguphap.setItemChecked(position, true);
                TextView dauhieu=(TextView)view.findViewById(R.id.textViewDauhhieu);
                if(dauhieu.getVisibility()==View.GONE)
                    dauhieu.setVisibility(View.VISIBLE);
                else
                    dauhieu.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nguphap, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
