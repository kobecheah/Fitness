package com.example.user.fitness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.fitness.weightcontract.weightEntry;



public class weightdbhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "weight.db";

    private static final String SQL_CREATE_weight_TABLE =
            " CREATE TABLE " + weightEntry.TABLE_NAME + " (" +
                   weightEntry._ID + " INTEGER PRIMARY KEY, " +
                  weightEntry.COLUMN_DAY + " TEXT NOT NULL, " +
                    weightEntry.COLUMN_DATE + " TEXT NOT NULL, " +
                    weightEntry.COLUMN_BMI+ " TEXT NOT NULL "+
                    " ); ";


    public weightdbhelper(Context context) {
        //create database
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //here is where you create table
        sqLiteDatabase.execSQL(SQL_CREATE_weight_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE EXISTS" + weightEntry.TABLE_NAME);

    }
}
