package com.example.calculatortask.domain.states;

import com.example.calculatortask.domain.entities.CalcSymbols;
import com.example.calculatortask.domain.entities.ValuesToCalculate;

import java.util.ArrayList;
import java.util.List;

abstract public class BaseState {
    protected List<CalcSymbols> inputSymbolsList = new ArrayList<>();

    abstract public BaseState inputValidation(CalcSymbols inputSymbol);

    public List<CalcSymbols> getValidatedInput() {
        return new ArrayList<>(inputSymbolsList);
    }
}