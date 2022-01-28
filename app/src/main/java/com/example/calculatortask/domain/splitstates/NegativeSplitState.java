package com.example.calculatortask.domain.splitstates;

import java.util.List;

public class NegativeSplitState extends BaseSplitState {
    public NegativeSplitState(List<String> numbers, int cursor, List<String> operators) {
        this.numbers.addAll(numbers);
        this.cursor = cursor;
        this.operators = operators;
    }

    @Override
    public BaseSplitState nextSymbol(char inputSymbol) {
        switch (inputSymbol) {
            case '0':
                numbers.add(cursor, "-0");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '1':
                numbers.add(cursor, "-1");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '2':
                numbers.add(cursor, "-2");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '3':
                numbers.add(cursor, "-3");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '4':
                numbers.add(cursor, "-4");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '5':
                numbers.add(cursor, "-5");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '6':
                numbers.add(cursor, "-6");
                return new FirstNumberSplitState(numbers,cursor, operators);
            case '7':
                numbers.add(cursor, "-7");
                return new FirstNumberSplitState(numbers,cursor, operators);
            case '8':
                numbers.add(cursor, "-8");
                return new FirstNumberSplitState(numbers,cursor, operators);
            case '9':
                numbers.add(cursor, "-9");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '-':
            case '+':
            case '*':
            case '/':
                return new SignSplitState(numbers, operators, cursor++);
            default:
                numbers.add(0, "*");
                return new FirstNumberSplitState(numbers, cursor, operators);
        }
    }
}
