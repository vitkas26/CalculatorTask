package com.example.calculatortask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "###";
    private static String BUNDLE_KEY = "saveNumberToBundle";
    private static int numberOne;
    private static int numberTwo;
    private static int sum;

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
    private Button buttonDot;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button seeResultBt;
    private Numbers savedResult = new Numbers();
    private CalcModel calcModel = new CalcModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View hideStatusBar = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        hideStatusBar.setSystemUiVisibility(uiOptions);

        initializeViews();

        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_KEY)) {
            savedResult = savedInstanceState.getParcelable(BUNDLE_KEY);
            resultTv.setText(savedResult.getLastValue());
        }

        setListeners();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        savedResult.setLastValue(resultTv.getText().toString());
        outState.putParcelable(BUNDLE_KEY, savedResult);
        Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
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
        buttonDot = findViewById(R.id.button_dot);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonDivide = findViewById(R.id.button_divide);
        seeResultBt = findViewById(R.id.button_see_result);

    }

    private void setListeners() {
        buttonOne.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_1));
        buttonTwo.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_2));
        buttonThree.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_3));
        buttonFour.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_4));
        buttonFive.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_5));
        buttonSix.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_6));
        buttonSeven.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_7));
        buttonEight.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_8));
        buttonNine.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_9));
        buttonZero.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_0));
        buttonDoubleZero.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_00));
        buttonDelete.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.CLEAR));
        buttonDot.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.DOT));
        buttonDot.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.CLEAR));
        buttonDot.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.OP_PLUS));
        buttonDot.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.OP_MINUS));
        buttonDot.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.OP_DIVIDE));
        buttonDot.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.OP_MULTIPLY));
        seeResultBt.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            savedResult.setLastValue(resultTv.getText().toString());
            intent.putExtra("resultFromMain", savedResult);
            startActivity(intent);
        });
    }

    private void onNumberButtonClick(CalcSymbols value) {
        calcModel.calcSymbolsValidation(value);
        List<CalcSymbols> calcSymbolsList = calcModel.getCalcSymbolsList();
        resultTv.setText(makeCalcSymbolsListToString(calcSymbolsList));
    }

    private String makeCalcSymbolsListToString(List<CalcSymbols> calcSymbolsList) {
        StringBuilder symbolsToString = new StringBuilder();
        for (CalcSymbols iterator : calcSymbolsList) {
            switch (iterator) {
                case NUM_0:
                    symbolsToString.append(R.string.button_0);
                    break;
                case NUM_1:
                    symbolsToString.append(R.string.button_1);
                    break;
                case NUM_2:
                    symbolsToString.append(R.string.button_2);
                    break;
                case NUM_3:
                    symbolsToString.append(R.string.button_3);
                    break;
                case NUM_4:
                    symbolsToString.append(R.string.button_4);
                    break;
                case NUM_5:
                    symbolsToString.append(R.string.button_5);
                    break;
                case NUM_6:
                    symbolsToString.append(R.string.button_6);
                    break;
                case NUM_7:
                    symbolsToString.append(R.string.button_7);
                    break;
                case NUM_8:
                    symbolsToString.append(R.string.button_8);
                    break;
                case NUM_9:
                    symbolsToString.append(R.string.button_9);
                    break;
                case NUM_00:
                    symbolsToString.append(R.string.button_00);
                    break;
                case OP_MINUS:
                    symbolsToString.append(R.string.button_minus);
                    break;
                default:
                    symbolsToString.append("(*)");
                    break;
            }
        }
        return symbolsToString.toString();
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