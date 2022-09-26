package com.example.dpaschedule;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;


public class fragment5 extends Fragment {

    // declare variable
    Button Book;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;

    String RadioButton = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment5, container, false);
        Book = view.findViewById(R.id.book);
        rb1 = view.findViewById(R.id.rB1);
        rb2 = view.findViewById(R.id.rB2);
        rb3 = view.findViewById(R.id.rB3);
        rb4 = view.findViewById(R.id.rB4);


        //set
        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (rb1.isChecked()) {
                    RadioButton = rb1.getText().toString();
                    rb1.setEnabled(false);
                    launchIntent();
                } else if (rb2.isChecked()) {
                    RadioButton = rb2.getText().toString();
                    rb2.setEnabled(false);
                    launchIntent();
                } else if (rb3.isChecked()) {
                    RadioButton = rb3.getText().toString();
                    rb3.setEnabled(false);
                    launchIntent();
                } else if (rb4.isChecked()) {
                    RadioButton = rb4.getText().toString();
                    rb4.setEnabled(false);
                    launchIntent();
                } else {
                    Toast.makeText(getActivity(), "Select time", Toast.LENGTH_LONG).show();
                }
            }


        });
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fragment2, container, false);
        return view;
    }

    public void launchIntent() {

        Intent intent = new Intent(getActivity(), ThirdActivity.class);

        intent.putExtra("na", RadioButton);
        intent.putExtra("doc", "Siona Lu");
        //intent.putExtra("ba", RadioButton);
        startActivity(intent);
    }
}