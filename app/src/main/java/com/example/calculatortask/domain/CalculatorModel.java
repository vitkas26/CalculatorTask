package com.example.calculatortask.domain;

import android.util.Log;

import com.example.calculatortask.domain.entities.CalcSymbols;
import com.example.calculatortask.domain.splitstates.BaseSplitState;
import com.example.calculatortask.domain.splitstates.SignSplitState;
import com.example.calculatortask.domain.states.BaseState;
import com.example.calculatortask.domain.states.SignState;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
    private BaseState currentState = new SignState();
    private BaseSplitState state = new SignSplitState();

    public void inputValidation(CalcSymbols inputSymbol) {
        BaseState newState = currentState.inputValidation(inputSymbol);
        Log.d("###", "oldState: " + currentState.getClass().getSimpleName());
        currentState = newState;
        Log.d("###", "newState: " + newState.getClass().getSimpleName());
        Log.d("###", "inputSymbol: " + inputSymbol.name());
        Log.d("###", "\n");
    }

    public List<CalcSymbols> getValidatedInput() {
        return new ArrayList<>(currentState.getValidatedInput());
    }

    public String calculateExpression(StringBuilder convertedSymbols) {
        for (int i = 0; i < convertedSymbols.length(); i++) {
            BaseSplitState newState = state.nextSymbol(convertedSymbols.charAt(i));
            Log.d("###", "splitState: " + state.getClass().getSimpleName());
            state = newState;
            Log.d("###", "newSplitState: " + newState.getClass().getSimpleName());
            Log.d("###", "convertedSymbol: " + convertedSymbols.charAt(i));
        }
        return String.valueOf(state.getListOfNumbers());
    }
}
