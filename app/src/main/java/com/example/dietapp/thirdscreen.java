package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class thirdscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_thirdscreen);
        TextView bmi =findViewById(R.id.bmi);
        TextView bmiinterpreter =findViewById(R.id.bmiinterpreter);
        Button moveButton =findViewById(R.id.move);

        Bundle bundle = getIntent().getExtras();
        String bmiString = bundle.getString("bmi");
        String  bmiinterpreterMessage=bundle.getString("bmiinterpreter");
//        Log.d("bmi",message+"");
        bmi.setText(bmiString.substring(0, 5));
        bmiinterpreter.setText("You are "+bmiinterpreterMessage);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.groupradio);

        // Uncheck or reset the radio buttons initially
        radioGroup.clearCheck();

        // Add the Listener to the RadioGroup
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override

                    // The flow will come here when
                    // any of the radio buttons in the radioGroup
                    // has been clicked

                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        RadioButton radioButton = (RadioButton)group.findViewById(checkedId);
                    }
                });

/// If no Radio Button is set, -1 will be returned
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            Toast.makeText(this, "No Disease has been selected", Toast.LENGTH_SHORT).show();
        }
        else {
            RadioButton radioButton = (RadioButton)radioGroup.findViewById(selectedId);

            // Now display the value of selected item
            // by the Toast message
            Toast.makeText(this, radioButton.getText(), Toast.LENGTH_SHORT).show();
        }

        // Add the Listener to the Submit Button
        moveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                // When submit button is clicked,
                // Ge the Radio Button which is set
                // If no Radio Button is set, -1 will be returned
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(getApplicationContext(),
                            "No Disease has been selected",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else {

                    RadioButton radioButton
                            = (RadioButton)radioGroup
                            .findViewById(selectedId);

                    // Now display the value of selected item
                    // by the Toast message
                    Toast.makeText(getApplicationContext(),
                            radioButton.getText(),
                            Toast.LENGTH_SHORT)
                            .show();

                    // pass data to model

                }
            }
        });


    }

    public void move(View view)
    {
        Intent i=new Intent(getApplicationContext(),
                fourthactivity.class);
        startActivity(i);
    }
}
