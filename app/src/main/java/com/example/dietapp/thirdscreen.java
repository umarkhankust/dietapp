package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class thirdscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_thirdscreen);
        TextView bmi =findViewById(R.id.bmi);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("bmi");
//        Log.d("bmi",message+"");
        bmi.setText(message.substring(0, 5));

    }

    public void move(View view)
    {
        Intent i=new Intent(getApplicationContext(),
                fourthactivity.class);
        startActivity(i);
    }
}
