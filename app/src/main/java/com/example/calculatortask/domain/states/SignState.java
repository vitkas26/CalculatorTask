package com.example.calculatortask.domain.states;

import com.example.calculatortask.domain.entities.CalcSymbols;

import java.util.List;

public class SignState extends BaseState {

    @Override
    public BaseState inputValidation(CalcSymbols inputSymbol) {
        switch (inputSymbol) {
            case OP_MINUS:
                inputSymbolsList.add(CalcSymbols.OP_MINUS);
                return new IntState(inputSymbolsList);
//            case OP_PLUS:
//            case OP_DIVIDE:
//            case OP_MULTIPLY:
//                return new IntState(inputSymbolsList);
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
            case DOT:
                inputSymbolsList.add(CalcSymbols.NUM_0);
                inputSymbolsList.add(CalcSymbols.DOT);
                return new FloatState(inputSymbolsList);

            case CLEAR:
                return new SignState();
//            case EQUAL:
//                break;
            default:
                return this;
        }
    }
}
