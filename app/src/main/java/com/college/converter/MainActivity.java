package com.college.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
/*
    TODOs:
    In groups of 4, complete the following tasks, 1 for each team member:
    1. Extract all the strings into the strings.xml file and use them in the layout and the activity
    2. Change the theme of the app to a NoActionBar theme and modify the primary colors
    3. Add Log messages at the entry/exit of onCreate() and convertCurrency methods. Level should be Info
    4. Add ViewBinding to the project

    ** Each task must be done in a separate branch and merged to the main branch
    after completion using a Pull Request.
    ** Each task must be done by a different team member.

*/

public class MainActivity extends AppCompatActivity {

    private LogWrapper logWrapper = new LogWrapper();

    static class LogWrapper {
        public void log(String tag, String message) {
            Log.i(tag, message);
        }
    }

    public void setLogWrapper(LogWrapper logWrapper) {
        this.logWrapper = logWrapper;
    }

    static private final Float CONVERSION_RATE = 0.80F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Log entry message for onCreate() method
        Log.i("MainActivity", "onCreate() method called");

        Button buttonConvert = findViewById(R.id.convertButton);

        buttonConvert.setOnClickListener(view -> {
            convertCurrency(view);
        });
    }

    public void convertCurrency(View view) {
        // Log entry message for convertCurrency() method
        Log.i("MainActivity", "convertCurrency() method called");

        EditText inputView = findViewById(R.id.entryId);
        String inputAmount = inputView.getText().toString();
        TextView resultView = findViewById(R.id.resultId);

        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);
            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;
            resultView.setText(resultFloat + " Euros");
        }

        // Log exit message for convertCurrency() method
        Log.i("MainActivity", "convertCurrency() method finished");
    }
}
