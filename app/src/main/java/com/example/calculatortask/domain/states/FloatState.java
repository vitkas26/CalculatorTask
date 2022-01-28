package com.example.calculatortask.domain.states;

import com.example.calculatortask.domain.entities.CalcSymbols;

import java.util.List;

public class FloatState extends BaseState {

    public FloatState(List<CalcSymbols> inputSymbolsList) {
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
            case NUM_0:
            case NUM_00:
                inputSymbolsList.add(inputSymbol);
                return new IntState(inputSymbolsList);
            case CLEAR:
                return new SignState();
//            case EQUAL:
//                break;
            default:
                return this;
        }
    }
}
