package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declare variable
    Button BookAppointment;
    Button LogOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookAppointment = findViewById(R.id.BookAppointment);
        LogOut = findViewById(R.id.logout);

        //set
          BookAppointment.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                  startActivity(intent);


              }
          }

);
          LogOut.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intentL = new Intent(MainActivity.this,LoginActivity.class);
                  startActivity(intentL);
                  finish();
                  Toast.makeText(MainActivity.this, "Successfully Logout", Toast.LENGTH_LONG).show();
              }
          });
    }
}