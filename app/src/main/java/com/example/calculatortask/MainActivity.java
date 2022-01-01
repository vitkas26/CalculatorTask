package com.example.calculatortask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "###";
    private static final String BUNDLE_KEY = "saveNumberToBundle";

    private TextView calculatedResultTextView;
    private Button numberOneButton;
    private Button numberTwoButton;
    private Button numberThreeButton;
    private Button numberFourButton;
    private Button numberFiveButton;
    private Button numberSixButton;
    private Button numberSevenButton;
    private Button numberEightButton;
    private Button numberNineButton;
    private Button numberZeroButton;
    private Button numberDoubleZeroButton;
    private Button operationClearButton;
    private Button dotButton;
    private Button seeResultButton;
    private Numbers savedResult = new Numbers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_KEY)) {
            savedResult = savedInstanceState.getParcelable(BUNDLE_KEY);
            calculatedResultTextView.setText(savedResult.getLastValue());
        }

        setListeners();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        savedResult.setLastValue(calculatedResultTextView.getText().toString());
        outState.putParcelable(BUNDLE_KEY, savedResult);
        Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
    }

    private void initializeViews() {
        calculatedResultTextView = findViewById(R.id.calculated_result_text_view);
        numberOneButton = findViewById(R.id.number_one_button);
        numberTwoButton = findViewById(R.id.number_two_button);
        numberThreeButton = findViewById(R.id.number_three_button);
        numberFourButton = findViewById(R.id.number_four_button);
        numberFiveButton = findViewById(R.id.number_five_button);
        numberSixButton = findViewById(R.id.number_six_button);
        numberSevenButton = findViewById(R.id.number_seven_button);
        numberEightButton = findViewById(R.id.number_eight_button);
        numberNineButton = findViewById(R.id.number_nine_button);
        numberZeroButton = findViewById(R.id.number_zero_button);
        numberDoubleZeroButton = findViewById(R.id.number_double_zero_button);
        operationClearButton = findViewById(R.id.operation_clear_button);
        dotButton = findViewById(R.id.dot_button);
        seeResultButton = findViewById(R.id.see_result_button);

    }

    private void setListeners() {
        numberOneButton.setOnClickListener(this::onNumberButtonClick);
        numberTwoButton.setOnClickListener(this::onNumberButtonClick);
        numberThreeButton.setOnClickListener(this::onNumberButtonClick);
        numberFourButton.setOnClickListener(this::onNumberButtonClick);
        numberFiveButton.setOnClickListener(this::onNumberButtonClick);
        numberSixButton.setOnClickListener(this::onNumberButtonClick);
        numberSevenButton.setOnClickListener(this::onNumberButtonClick);
        numberEightButton.setOnClickListener(this::onNumberButtonClick);
        numberNineButton.setOnClickListener(this::onNumberButtonClick);
        numberZeroButton.setOnClickListener(this::onNumberButtonClick);
        numberDoubleZeroButton.setOnClickListener(this::onNumberButtonClick);
        operationClearButton.setOnClickListener(this::onNumberButtonClick);
        dotButton.setOnClickListener(this::onNumberButtonClick);
        seeResultButton.setOnClickListener(v-> {
                Intent intent = new Intent(this, SecondActivity.class);
                savedResult.setLastValue(calculatedResultTextView.getText().toString());
                intent.putExtra("resultFromMain",savedResult);
                startActivity(intent);
        });
    }

    private void onNumberButtonClick(View view) {
        Button b = (Button) view;
        String buttonNumber = b.getText().toString();
        if (b.getId() == R.id.operation_clear_button) {
            deleteLastCharacter();
        } else if (b.getId() == R.id.dot_button) {
            if (!calculatedResultTextView.getText().toString().contains(".")) {
                calculatedResultTextView.append(buttonNumber);
            } else{
                Toast.makeText(this, "Dot is exist!", Toast.LENGTH_SHORT).show();
            }
        } else {
            calculatedResultTextView.append(buttonNumber);
        }
    }

    private void deleteLastCharacter() {
        String toRemove = calculatedResultTextView.getText().toString();
        try {
            String editedText = toRemove.substring(0, toRemove.length() - 1);
            calculatedResultTextView.setText(editedText);
        } catch (Exception e) {
            Toast.makeText(this, "Field is empty", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

}