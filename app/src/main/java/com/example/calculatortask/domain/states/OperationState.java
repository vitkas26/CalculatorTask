package com.example.calculatortask.domain.states;

import com.example.calculatortask.domain.entities.CalcSymbols;

import java.util.List;

public class OperationState extends BaseState {
    public OperationState(List<CalcSymbols> inputSymbolsList) {
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
                return this;
            case DOT:
                inputSymbolsList.add(CalcSymbols.DOT);
                return new FloatState(inputSymbolsList);
            case CLEAR:
                return new SignState();
            case OP_PLUS:
                inputSymbolsList.add(CalcSymbols.OP_PLUS);
                return new OperationState(inputSymbolsList);
            case OP_MINUS:
                inputSymbolsList.add(CalcSymbols.OP_MINUS);
                return this;
            case OP_DIVIDE:
                inputSymbolsList.add(CalcSymbols.OP_DIVIDE);
                return this;
            case OP_MULTIPLY:
                inputSymbolsList.add(CalcSymbols.OP_MULTIPLY);
                return this;
            case EQUAL:
                inputSymbolsList.add(CalcSymbols.EQUAL);
                return this;
            default:
                return this;
        }
    }
}
