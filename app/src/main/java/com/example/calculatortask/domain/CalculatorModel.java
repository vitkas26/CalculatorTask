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
                String dividend;
                if (operators.get(i).equals("/")) {
                    operatorIndex = operators.indexOf(operators.get(i));
                    if (operatorIndex == 0) {
                        dividend = numbers.get(operatorIndex);
                    } else {
                        dividend = numbers.get(operatorIndex - 1);
                    }
                    String divider = numbers.get(operatorIndex + 1);
                    String result = String.valueOf(Integer.parseInt(dividend) / Integer.parseInt(divider));
                    numbers.remove(divider);
                    operators.remove(operatorIndex);
                    try {
                        numbers.set(numbers.indexOf(dividend), result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        numbers.set(operatorIndex, result);
                    }
                } else {
                    i++;
                }
            }
            for (int i = 0; i < operators.size(); i++) {
                int operatorIndex;
                String multiplicand;
                if (operators.get(i).equals("*")) {
                    operatorIndex = operators.indexOf(operators.get(i));
                    if (operatorIndex == 0) {
                        multiplicand = numbers.get(operatorIndex);
                    } else {
                        multiplicand = numbers.get(operatorIndex - 1);
                    }
                    String multiplier = numbers.get(operatorIndex + 1);
                    String result = String.valueOf(Integer.parseInt(multiplicand) * Integer.parseInt(multiplier));
                    numbers.remove(multiplier);
                    operators.remove(operatorIndex);
                    try {
                        numbers.set(numbers.indexOf(multiplicand), result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        numbers.set(operatorIndex, result);
                    }
                }
            }
            for (int i = 0; i < operators.size(); i++) {
                int operatorIndex;
                String subtrahend;
                if (operators.get(i).equals("-")) {
                    operatorIndex = operators.indexOf(operators.get(i));
                    if (operatorIndex == 0) {
                        subtrahend = numbers.get(operatorIndex);
                    } else {
                        subtrahend = numbers.get(operatorIndex - 1);
                    }
                    String subtractor = numbers.get(operatorIndex + 1);
                    String result = String.valueOf(Integer.parseInt(subtrahend) - Integer.parseInt(subtractor));
                    numbers.remove(subtractor);
                    operators.remove(operatorIndex);
                    try {
                        numbers.set(numbers.indexOf(subtrahend), result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        numbers.set(operatorIndex, result);
                    }
                } else {
                    i++;
                }
            }
            for (int i = 0; i < operators.size(); i++) {
                int operatorIndex;
                String term;
                if (operators.get(i).equals("+")) {
                    operatorIndex = operators.indexOf(operators.get(i));
                    if (operatorIndex == 0) {
                        term = numbers.get(operatorIndex);
                    } else {
                        term = numbers.get(operatorIndex - 1);
                    }
                    String term1 = numbers.get(operatorIndex + 1);
                    String result = String.valueOf(Integer.parseInt(term) + Integer.parseInt(term1));
                    numbers.remove(term1);
                    operators.remove(operatorIndex);
                    try {
                        numbers.set(numbers.indexOf(term), result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        numbers.set(operatorIndex, result);
                    }
                } else {
                    i++;
                }
            }
        } while (numbers.size() > 1);
        return String.valueOf(numbers.get(0));
    }

}
