package com.example.calculatortask.domain.states;

import com.example.calculatortask.domain.entities.CalcSymbols;

import java.util.List;

public class ZeroState extends BaseState {
    public ZeroState(List<CalcSymbols> inputSymbolsList) {
        this.inputSymbolsList.addAll(inputSymbolsList);
    }

    @Override
    public BaseState inputValidation(CalcSymbols inputSymbol) {
        switch (inputSymbol) {
            case DOT:
                inputSymbolsList.add(CalcSymbols.DOT);
                return new IntState(inputSymbolsList);
            case CLEAR:
                return new SignState();
            default:
                return this;
        }
    }
}
