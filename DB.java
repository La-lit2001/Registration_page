package com.example.registrationpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB( Context context) {
        super(context, "Userdata.db", null,  1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL ("create Table Userdetails (name TEXT primary key, DOB TEXT, email Text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL ("drop Table if exists Userdetails");

    }
    public Boolean insertuserdata(String name,String dob,String email) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("DOB",dob);
        contentValues.put("email", email);
        long result = DB.insert("Userdetails",null,contentValues) ;
        if (result==-1)
        {
            return false ;
        }
        else
            {
                return true ;
            }
    }
    public Cursor getdata()
    {
        SQLiteDatabase DB =this.getWritableDatabase();
        Cursor cursor =DB.rawQuery ( "Select * from Userdetails", null);
        return cursor;
}
}
