package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, dob, email ;
    Button sumbit, view ;
    SharedPreferences sp ;
    String namestr , emailstr, dobstr ;
    DB DB1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextTextPersonName) ;
        dob = findViewById(R.id.editTextDate) ;
        email = findViewById(R.id.editTextTextEmailAddress) ;
        sumbit = findViewById(R.id.button) ;
        view = findViewById(R.id.button2) ;

        DB1 = new DB(this) ;

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namestr = name.getText().toString();
                emailstr = email.getText().toString() ;
                dobstr = dob.getText().toString() ;
                Boolean checkinsertdata = DB1.insertuserdata(namestr,dobstr,emailstr);
                if(checkinsertdata == true)
                {
                    Toast.makeText(MainActivity.this, "New Entry Done", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "New Entry not Done", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}