package com.example.calculatortask.domain.splitstates;

import java.util.List;

public class NegativeSplitState extends BaseSplitState {
    public NegativeSplitState(List<String> numbers, int cursor) {
        this.numbers.addAll(numbers);
        this.cursor = cursor;
    }

    @Override
    public BaseSplitState nextSymbol(char inputSymbol) {
        switch (inputSymbol) {
            case '0':
                numbers.add(cursor, "-0");
            case '1':
                numbers.add(cursor, "-1");
            case '2':
                numbers.add(cursor, "-2");
            case '3':
                numbers.add(cursor, "-3");
            case '4':
                numbers.add(cursor, "-4");
            case '5':
                numbers.add(cursor, "-5");
            case '6':
                numbers.add(cursor, "-6");
            case '7':
                numbers.add(cursor, "-7");
            case '8':
                numbers.add(cursor, "-8");
            case '9':
                numbers.add(cursor, "-9");
                return new NumberSplitState(numbers,cursor);
            case '-':
            case '+':
            case '*':
            case '/':
                return new OperatorSplitState(numbers,cursor++);
            default:
                numbers.add(0, "*");
                return new NumberSplitState(numbers,cursor);
        }
    }
}
