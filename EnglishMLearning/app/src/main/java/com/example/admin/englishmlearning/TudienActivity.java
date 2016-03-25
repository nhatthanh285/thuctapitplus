package com.example.admin.englishmlearning;

import android.database.Cursor;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.support.v7.widget.SearchView;
import android.widget.TextView;

import com.example.admin.englishmlearning.adapter.TudienAdapter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class TudienActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private DatabaseAcess dataBaseAcess;
    List<ItemTudien> tudienList;
    ListView listViewtudien;
    TudienAdapter tudienAdapter;
    private SearchView searchView;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudien);

        //init
        listViewtudien = (ListView) findViewById(R.id.listViewtudien);
        tudienList = new ArrayList<>();


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);

                }
            }
        });

        dataBaseAcess = new DatabaseAcess(this);
        dataBaseAcess = DatabaseAcess.getInstance(this);
        dataBaseAcess.open();
        hienthi_tudien("select * from tudien");

    }

    private void hienthi_tudien(String sql){
        try {
            tudienList.removeAll(tudienList);
            Cursor cursor = dataBaseAcess.QueryData(sql);
            if (cursor != null) {
                while (cursor.moveToNext()) {

                    String tu = cursor.getString(cursor.getColumnIndex("tukhoa"));
                    String loaitu = cursor.getString(cursor.getColumnIndex("loaitu"));
                    String phienam = cursor.getString(cursor.getColumnIndex("phienam"));
                    String nghia = cursor.getString(cursor.getColumnIndex("nghia"));

                    tudienList.add(new ItemTudien(tu, loaitu, phienam, nghia));

                }
            }
            tudienAdapter = new TudienAdapter(this, R.layout.item_tudien, tudienList);
            listViewtudien.setAdapter(tudienAdapter);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tudien, menu);
        MenuItem itemSearch = menu.findItem(R.id.search_view);
        searchView=(SearchView)itemSearch.getActionView();
        searchView.setOnQueryTextListener(this);
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

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String tukhoa) {
        String sql="select * from tudien where tukhoa like '%"+tukhoa+"%'";
        hienthi_tudien(sql);
        return true;
    }
}
