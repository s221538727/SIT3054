package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.unitconverterapp.util.LengthConverter;
import com.example.unitconverterapp.util.TempConverter;
import com.example.unitconverterapp.util.WeightConverter;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner sourceSpinner, destSpinner;
    Button convertButton;
    EditText sourceET;
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initSourceSpinner();
        initDestSpinner();

        convertButton = findViewById(R.id.convert_bt);
        sourceET = findViewById(R.id.source_unit_et);
        resultTv = findViewById(R.id.result_tv);

        convertButton.setOnClickListener(this);


    }

    private void initSourceSpinner() {
        sourceSpinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.source_unit, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sourceSpinner.setAdapter(adapter);
    }

    private void initDestSpinner() {
        destSpinner = (Spinner) findViewById(R.id.spinner_d);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.source_unit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destSpinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        String sourceSpinnerText = sourceSpinner.getSelectedItem().toString();
        String destSpinnerText = destSpinner.getSelectedItem().toString();
        String editTextString = sourceET.getText().toString();

        try {
            if(WeightConverter.isWeightUnit(sourceSpinnerText) && WeightConverter.isWeightUnit(destSpinnerText)) {
                double result = WeightConverter.getWeightResult(sourceSpinnerText, destSpinnerText, editTextString);
                resultTv.setText(String.format(Locale.ENGLISH, "%.3f", result));
            } else if(LengthConverter.isLenUnit(sourceSpinnerText) && LengthConverter.isLenUnit(destSpinnerText)) {
                double result = LengthConverter.getLenResult(sourceSpinnerText, destSpinnerText, editTextString);
                resultTv.setText(String.format(Locale.ENGLISH, "%.3f", result));
            } else if(TempConverter.isTempUnit(sourceSpinnerText) && TempConverter.isTempUnit(destSpinnerText)) {
                double result = TempConverter.getTempResult(sourceSpinnerText, destSpinnerText, editTextString);
                resultTv.setText(String.format(Locale.ENGLISH, "%.3f", result));
            } else {
                resultTv.setText("Cannot Convert "+sourceSpinnerText+" To "+ destSpinnerText);
            }
        } catch (Exception npe) {
            resultTv.setText("Invalid Input");
        }




        Log.d("BUTTON", "sourceSpinnerText: " + sourceSpinnerText);
        Log.d("BUTTON", "destSpinnerText: " + destSpinnerText);
        Log.d("BUTTON", "editTextString: " + editTextString);
    }
}