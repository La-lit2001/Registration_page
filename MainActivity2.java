package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name, dob ,email ;
    DB DB2;
    MyAD adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DB2 = new DB(this) ;
        name = new ArrayList<>() ;
        dob = new ArrayList<>() ;
        email = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerview) ;
        adapter = new MyAD(this, name, dob, email) ;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


    }

    private void displaydata() {
        Cursor cursor = DB2.getdata();
        if(cursor.getCount()==0)
        {
            Toast.makeText( MainActivity2.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                dob.add(cursor.getString(1));
                email.add(cursor.getString(2));
            }

        }
    }
}