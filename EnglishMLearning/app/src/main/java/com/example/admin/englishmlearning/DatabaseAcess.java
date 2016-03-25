package com.example.admin.englishmlearning;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by Admin on 3/15/2016.
 */
public class DatabaseAcess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAcess instance;


    public DatabaseAcess(Context context) {
       this.openHelper=new DatabaseOpenHelper(context);
    }


    public static DatabaseAcess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAcess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public Cursor QueryData(String query) throws SQLException {
        return database.rawQuery(query, null);
    }
}
