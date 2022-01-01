package com.example.calculatortask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calculatortask.domain.CalculatorModel;
import com.example.calculatortask.domain.entities.CalcSymbols;
import com.example.calculatortask.domain.entities.Numbers;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "###";
    private static String BUNDLE_KEY = "saveNumberToBundle";

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
    private Button operationAdditionButton;
    private Button operationSubtractionButton;
    private Button operationMultiplicationButton;
    private Button operationDivisionButton;
    private Button seeResultButton;
    private Numbers savedResult = new Numbers();
    private CalculatorModel calcModel = new CalculatorModel();

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
        operationAdditionButton = findViewById(R.id.operation_addition_button);
        operationSubtractionButton = findViewById(R.id.operation_subtraction_button);
        operationMultiplicationButton = findViewById(R.id.operation_multiplication_button);
        operationDivisionButton = findViewById(R.id.operation_division_button);
        seeResultButton = findViewById(R.id.see_result_button);

    }

    private void setListeners() {
        numberOneButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_1));
        numberTwoButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_2));
        numberThreeButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_3));
        numberFourButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_4));
        numberFiveButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_5));
        numberSixButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_6));
        numberSevenButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_7));
        numberEightButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_8));
        numberNineButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_9));
        numberZeroButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_0));
        numberDoubleZeroButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.NUM_00));
        operationClearButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.CLEAR));
        dotButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.DOT));
        dotButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.CLEAR));
        dotButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.OP_PLUS));
        dotButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.OP_MINUS));
        dotButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.OP_DIVIDE));
        dotButton.setOnClickListener(v -> onNumberButtonClick(CalcSymbols.OP_MULTIPLY));
        seeResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            savedResult.setLastValue(calculatedResultTextView.getText().toString());
            intent.putExtra("resultFromMain", savedResult);
            startActivity(intent);
        });
    }

    private void onNumberButtonClick(CalcSymbols inputSymbol) {
        calcModel.inputValidation(inputSymbol);
        List<CalcSymbols> calcSymbolsList = calcModel.getValidatedInput();
        calculatedResultTextView.setText(makeCalcSymbolsListToString(calcSymbolsList));
    }

    private String makeCalcSymbolsListToString(List<CalcSymbols> calcSymbolsList) {
        StringBuilder symbolsToString = new StringBuilder();
        for (CalcSymbols iterator : calcSymbolsList) {
            switch (iterator) {
                case NUM_0:
                    symbolsToString.append(getResources().getString(R.string.number_zero_button));
                    break;
                case NUM_1:
                    symbolsToString.append(getResources().getString(R.string.number_one_button));
                    break;
                case NUM_2:
                    symbolsToString.append(getResources().getString(R.string.number_two_button));
                    break;
                case NUM_3:
                    symbolsToString.append(getResources().getString(R.string.number_three_button));
                    break;
                case NUM_4:
                    symbolsToString.append(getResources().getString(R.string.number_four_button));
                    break;
                case NUM_5:
                    symbolsToString.append(getResources().getString(R.string.number_five_button));
                    break;
                case NUM_6:
                    symbolsToString.append(getResources().getString(R.string.number_six_button));
                    break;
                case NUM_7:
                    symbolsToString.append(getResources().getString(R.string.number_seven_button));
                    break;
                case NUM_8:
                    symbolsToString.append(getResources().getString(R.string.number_eight_button));
                    break;
                case NUM_9:
                    symbolsToString.append(getResources().getString(R.string.number_nine_button));
                    break;
                case NUM_00:
                    symbolsToString.append(getResources().getString(R.string.number_double_zero_button));
                    break;
                case OP_MINUS:
                    symbolsToString.append(getResources().getString(R.string.operation_subtraction_button));
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