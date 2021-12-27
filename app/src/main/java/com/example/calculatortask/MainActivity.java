package com.example.calculatortask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "###";
    private TextView resultTv;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private Button buttonDoubleZero;
    private Button buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setListeners();
    }

    private void initializeViews() {
        resultTv = findViewById(R.id.result_text_tv);
        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);
        buttonThree = findViewById(R.id.button_three);
        buttonFour = findViewById(R.id.button_four);
        buttonFive = findViewById(R.id.button_five);
        buttonSix = findViewById(R.id.button_six);
        buttonSeven = findViewById(R.id.button_seven);
        buttonEight = findViewById(R.id.button_eight);
        buttonNine = findViewById(R.id.button_nine);
        buttonZero = findViewById(R.id.button_zero);
        buttonDoubleZero = findViewById(R.id.button_double_zero);
        buttonDelete = findViewById(R.id.button_delete);

    }

    private void setListeners() {
        buttonOne.setOnClickListener(this::onNumberButtonClick);
        buttonTwo.setOnClickListener(this::onNumberButtonClick);
        buttonThree.setOnClickListener(this::onNumberButtonClick);
        buttonFour.setOnClickListener(this::onNumberButtonClick);
        buttonFive.setOnClickListener(this::onNumberButtonClick);
        buttonSix.setOnClickListener(this::onNumberButtonClick);
        buttonSeven.setOnClickListener(this::onNumberButtonClick);
        buttonEight.setOnClickListener(this::onNumberButtonClick);
        buttonNine.setOnClickListener(this::onNumberButtonClick);
        buttonZero.setOnClickListener(this::onNumberButtonClick);
        buttonDoubleZero.setOnClickListener(this::onNumberButtonClick);
        buttonDelete.setOnClickListener(this::onNumberButtonClick);
    }

    private void onNumberButtonClick(View view) {
        Button b = (Button) view;
        String buttonNumber = b.getText().toString();
        if (b.getId() == R.id.button_delete) {
            deleteLastCharacter();
        } else {
            resultTv.append(buttonNumber);
        }
    }

    private void deleteLastCharacter() {
        String toRemove = resultTv.getText().toString();
        try {
            String editedText = toRemove.substring(0, toRemove.length() - 1);
            resultTv.setText(editedText);
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