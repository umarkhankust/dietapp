package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class mainscreen extends Activity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Spinner spinnerTwo = (Spinner) findViewById(R.id.spinner2);
        final Button next_id = (Button)findViewById(R.id.next_id);
        next_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),
                        thirdscreen.class);
                startActivity(i);
            }
        });


        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        spinnerTwo.setOnItemSelectedListener(this);



        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Male");
        categories.add("Female");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        List<String> categories_weight = new ArrayList<String>();
        categories_weight.add("40KG");
        categories_weight.add("50KG");
        categories_weight.add("60KG");
        categories_weight.add("70KG");
        categories_weight.add("80KG");
        ArrayAdapter<String> dataAdapter_weight = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories_weight);
        // Drop down layout style - list view with radio button
        dataAdapter_weight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner

        //spinner3
        List<String> categories_height = new ArrayList<String>();
        categories_height.add("1ft");
        categories_height.add("2ft");
        categories_height.add("3ft");
        categories_height.add("4ft");
        categories_height.add("5ft");
        categories_height.add("4ft");
        categories_height.add("4ft");
        categories_height.add("4ft");
        categories_height.add("4ft");
        categories_height.add("4ft");
        categories_height.add("4ft");
        categories_height.add("4ft");
        categories_height.add("4ft");

        ArrayAdapter<String> dataAdapter_height = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories_height);
        // Drop down layout style - list view with radio button
        dataAdapter_height.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinnerTwo.setAdapter(dataAdapter_height);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
