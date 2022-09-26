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

public class ThirdActivity extends AppCompatActivity {

    Button btnRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView timeBooked = findViewById(R.id.timeBooked);
        TextView docName = findViewById(R.id.docName);
        Intent intent = getIntent();

        String info = intent.getStringExtra("na");
        String doc = intent.getStringExtra("doc");

        docName.setText("Doctor: " + doc);
        timeBooked.setText(info);

        btnRating = findViewById(R.id.btnRating);
        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchRatingBar();
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
        Intent intentLogout = new Intent(ThirdActivity.this, LoginActivity.class);
        startActivity(intentLogout);
        finish();
        Toast.makeText(ThirdActivity.this, "Logged out successfully", Toast.LENGTH_LONG).show();
    }

    public void launchRatingBar(){
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
    }
}