package com.example.calculatortask.domain;

import android.util.Log;

import com.example.calculatortask.domain.entities.CalcSymbols;
import com.example.calculatortask.domain.splitstates.BaseSplitState;
import com.example.calculatortask.domain.splitstates.SignSplitState;
import com.example.calculatortask.domain.states.BaseState;
import com.example.calculatortask.domain.states.SignState;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalculatorModel {
    private BaseState currentState = new SignState();

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
        BaseSplitState state = new SignSplitState();
        for (int i = 0; i < convertedSymbols.length(); i++) {
            BaseSplitState newState = state.nextSymbol(convertedSymbols.charAt(i));
            Log.d("###", "splitState: " + state.getClass().getSimpleName());
            state = newState;
            Log.d("###", "newSplitState: " + newState.getClass().getSimpleName());
            Log.d("###", "convertedSymbol: " + convertedSymbols.charAt(i));
        }
        ArrayList<String> operators = (ArrayList<String>) state.getListOfOperators();
        ArrayList<String> numbers = (ArrayList<String>) state.getListOfNumbers();
        numbers.sort(Comparator.reverseOrder());
        Log.d("###", "numbersList: " + numbers);
        Log.d("###", "operators: " + operators);
        do {
            for (int i = 0; i < operators.size(); i++) {
                int operatorIndex;
                String firstNumber;
                if (operators.get(i).equals("/")) {
                    operatorIndex = operators.indexOf(operators.get(i));
                    firstNumber = numbers.get(operatorIndex);
                    String secondNumber = numbers.get(operatorIndex + 1);
                    String result = String.valueOf(Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber));
                    numbers.set(operatorIndex, result);
                    numbers.remove(operatorIndex + 1);
                    operators.remove(operatorIndex);
                }
            }
            for (int i = 0; i < operators.size(); i++) {
                int operatorIndex;
                String firstNumber;
                if (operators.get(i).equals("*")) {
                    operatorIndex = operators.indexOf(operators.get(i));
                    firstNumber = numbers.get(operatorIndex);
                    String secondNumber = numbers.get(operatorIndex + 1);
                    String result = String.valueOf(Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber));
                    numbers.set(operatorIndex, result);
                    numbers.remove(operatorIndex + 1);
                    operators.remove(operatorIndex);
                }
            }
            for (int i = 0; i < operators.size(); i++) {
                int operatorIndex;
                String firstNumber;
                if (operators.get(i).equals("-")) {
                    operatorIndex = operators.indexOf(operators.get(i));
                    firstNumber = numbers.get(operatorIndex);
                    String secondNumber = numbers.get(operatorIndex + 1);
                    String result = String.valueOf(Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber));
                    numbers.set(operatorIndex, result);
                    numbers.remove(operatorIndex + 1);
                    operators.remove(operatorIndex);
                }
            }
            for (int i = 0; i < operators.size(); i++) {
                int operatorIndex;
                String firstNumber;
                if (operators.get(i).equals("+")) {
                    operatorIndex = operators.indexOf(operators.get(i));
                    firstNumber = numbers.get(operatorIndex);
                    String secondNumber = numbers.get(operatorIndex + 1);
                    String result = String.valueOf(Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber));
                    numbers.set(operatorIndex, result);
                    numbers.remove(operatorIndex + 1);
                    operators.remove(operatorIndex);
                }
            }
        } while (numbers.size() > 1);
        return String.valueOf(numbers.get(0));
    }

}
