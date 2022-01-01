package com.example.calculatortask.domain;

import android.util.Log;

import com.example.calculatortask.domain.entities.CalcSymbols;
import com.example.calculatortask.domain.states.BaseState;
import com.example.calculatortask.domain.states.SignState;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
    private BaseState currentState = new SignState();

    public void inputValidation(CalcSymbols inputSymbol) {
        BaseState newState = currentState.inputValidation(inputSymbol);
        currentState = newState;
        Log.d("###", "oldState: " + currentState.getClass().getSimpleName());
        Log.d("###", "newState: " + newState.getClass().getSimpleName());
        Log.d("###", "inputSymbol: " + inputSymbol.name());
        Log.d("###", "\n");
    }

    public List<CalcSymbols> getValidatedInput() {
        return new ArrayList<>(currentState.getValidatedInput());
    }
}
