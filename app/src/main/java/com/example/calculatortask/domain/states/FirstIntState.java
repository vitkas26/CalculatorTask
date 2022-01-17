package com.example.calculatortask.domain.states;

import com.example.calculatortask.domain.entities.CalcSymbols;

import java.util.List;

/**
 * Проверка ввода первого целого числа, после знака
 */
public class FirstIntState extends BaseState {
    public FirstIntState(List<CalcSymbols> inputSymbolsList) {
        this.inputSymbolsList.addAll(inputSymbolsList);
    }

    @Override
    public BaseState inputValidation(CalcSymbols inputSymbol) {
        switch (inputSymbol) {
            case NUM_1:
            case NUM_2:
            case NUM_3:
            case NUM_4:
            case NUM_5:
            case NUM_6:
            case NUM_7:
            case NUM_8:
            case NUM_9:
                inputSymbolsList.add(inputSymbol);
                return new IntState(inputSymbolsList);
            case DOT:
                inputSymbolsList.add(CalcSymbols.NUM_0);
                inputSymbolsList.add(CalcSymbols.DOT);
                return new FloatState(inputSymbolsList);
            case NUM_0:
                inputSymbolsList.add(CalcSymbols.NUM_0);
                return new ZeroState(inputSymbolsList);
            case CLEAR:
                return new SignState();
            default:
                return this;
        }
    }
}
