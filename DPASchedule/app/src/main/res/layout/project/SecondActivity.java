package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    fragment1  fragment1Action;
    fragment2 fragment2Action;
    fragment3 fragment3Action;
    fragment4 fragment4Action;
    fragment5 fragment5Action;
    Spinner spinner;
    List <String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        spinner=findViewById(R.id.dName);
        fragment1Action=new fragment1();
        fragment2Action=new fragment2();
        fragment3Action=new fragment3();
        fragment4Action=new fragment4();
        fragment5Action=new fragment5();

        names = new ArrayList<>();
        names.add("Select your Doctor");
        names.add("David Yang");
        names.add("Michael Zhou");
        names.add("Fran Wilkins");
        names.add("Siona Lu");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SecondActivity.this, R.layout.item,names);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i) {
                    case 0:
                        selectFragment(fragment1Action);
                        break;
                    case 1:
                        selectFragment(fragment2Action);
                        break;
                    case 2:
                        selectFragment(fragment3Action);
                        break;
                    case 3:
                        selectFragment(fragment4Action);
                        break;
                    case 4:
                        selectFragment(fragment5Action);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void selectFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.FrameLayout, fragment);
        fragmentTransaction.commit();
    }
}