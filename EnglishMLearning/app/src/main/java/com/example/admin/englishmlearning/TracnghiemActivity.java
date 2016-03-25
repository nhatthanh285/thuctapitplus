package com.example.admin.englishmlearning;

import android.database.Cursor;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.englishmlearning.adapter.TracnghiemAdapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class TracnghiemActivity extends AppCompatActivity {
    ListView listviewTracnghiem;
    TracnghiemAdapter tracnghiemAdapter;
    List<ItemTracnghiem> listTracnghiem;
    DatabaseAcess databaseAcess;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracnghiem);

        //init
        listviewTracnghiem = (ListView) findViewById(R.id.listViewTracnghiem);
        listTracnghiem = new ArrayList<>();
        databaseAcess = new DatabaseAcess(this);
        databaseAcess = databaseAcess.getInstance(this);
        databaseAcess.open();
        Cursor cursor = null;
        final TextView textViewThoigian = (TextView) findViewById(R.id.textViewThoigian);

        countDownTimer = new CountDownTimer(600000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int giay = (int) millisUntilFinished / 1000;
                int phut = giay / 60;
                giay = giay % 60;

                textViewThoigian.setText("" + phut + ":"
                        + String.format("%02d", giay));
            }

            @Override
            public void onFinish() {

            }
        }.start();
        Vector cauhoi = laymacauhoi();
        for (int i = 0; i < cauhoi.size(); i++) {
            try {
                cursor = databaseAcess.QueryData("select * from tracnghiem where id='" + cauhoi.get(i) + "'");
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        String noidung = cursor.getString(cursor.getColumnIndex("noidung"));
                        String dapan1 = cursor.getString(cursor.getColumnIndex("dap an 1"));
                        String dapan2 = cursor.getString(cursor.getColumnIndex("dap an 2"));
                        String dapan3 = cursor.getString(cursor.getColumnIndex("dap an 3"));
                        String dapan4 = cursor.getString(cursor.getColumnIndex("dap an 4"));
                        String dapandung = cursor.getString(cursor.getColumnIndex("dap an dung"));
                        listTracnghiem.add(new ItemTracnghiem(noidung, dapan1, dapan2, dapan3, dapan4, dapandung));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        tracnghiemAdapter = new TracnghiemAdapter(this, R.layout.item_tracnghiem, listTracnghiem);
        listviewTracnghiem.setAdapter(tracnghiemAdapter);
    }

    public Vector laymacauhoi() {
        Vector v = new Vector();
        Random rd = new Random();
        int iNew = 0;
        for (int i = 0; i < 10; ) {
            iNew = rd.nextInt(50);
            if (!v.contains(iNew)) {
                i++;
                v.add(iNew);
            }
        }
        return v;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tracnghiem, menu);
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
