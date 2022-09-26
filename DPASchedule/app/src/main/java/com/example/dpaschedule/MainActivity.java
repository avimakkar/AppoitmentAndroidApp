package com.example.dpaschedule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declare variable
    Button BookAppointment;
    Button LogOut;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Patient Name");

        BookAppointment = findViewById(R.id.BookAppointment);
        LogOut = findViewById(R.id.logout);
        textView = findViewById(R.id.textView);
        textView.setText("Welcome " + name + ",");

        BookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogout();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logoutMenu:{
                userLogout();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    public void userLogout(){
        Intent intentLogout = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intentLogout);
        finish();
        Toast.makeText(MainActivity.this, "Logged out successfully", Toast.LENGTH_LONG).show();
    }
}