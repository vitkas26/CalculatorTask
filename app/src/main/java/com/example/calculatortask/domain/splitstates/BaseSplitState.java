package com.example.calculatortask.domain.splitstates;

import com.example.calculatortask.domain.entities.CalcSymbols;
import com.example.calculatortask.domain.states.BaseState;

import java.util.ArrayList;
import java.util.List;

abstract public class BaseSplitState {
    protected List<String> numbers = new ArrayList<>();
    protected List<String> operators = new ArrayList<>();
    protected int cursor = 0;
    abstract public BaseSplitState nextSymbol(char inputSymbol);
    public List<String> getListOfNumbers() {
        return new ArrayList<>(numbers);
    }
    public List<String> getListOfOperators() {
        return new ArrayList<>(operators);
    }
}
