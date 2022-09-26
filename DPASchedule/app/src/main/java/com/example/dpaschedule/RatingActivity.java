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
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        final RatingBar ratingBar = findViewById(R.id.ratingStar);
        if (ratingBar != null) {
            Button button = findViewById(R.id.btnSubmit);
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String msg = String.valueOf(ratingBar.getRating());
                        Toast.makeText(RatingActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }
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
        Intent intentLogout = new Intent(RatingActivity.this, LoginActivity.class);
        startActivity(intentLogout);
        finish();
        Toast.makeText(RatingActivity.this, "Logged out successfully", Toast.LENGTH_LONG).show();
    }
}