package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class thirdscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdscreen);
    }

    public void move(View view)
    {
        Intent i=new Intent(getApplicationContext(),
                fourthactivity.class);
        startActivity(i);
    }
}
