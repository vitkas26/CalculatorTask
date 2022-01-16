package com.example.calculatortask.domain.splitstates;

import java.util.List;

public class OperatorSplitState extends BaseSplitState {
    public OperatorSplitState(List<String> numbers, int cursor) {
        this.numbers.addAll(numbers);
        this.cursor = cursor;
    }

    @Override
    public BaseSplitState nextSymbol(char inputSymbol) {
        switch (inputSymbol) {
            case '0':
                numbers.add(2, "0");
            case '1':
                numbers.add(2, "1");
            case '2':
                numbers.add(2, "2");
            case '3':
                numbers.add(2, "3");
            case '4':
                numbers.add(2, "4");
            case '5':
                numbers.add(2, "5");
            case '6':
                numbers.add(2, "6");
            case '7':
                numbers.add(2, "7");
            case '8':
                numbers.add(2, "8");
            case '9':
                numbers.add(2, "9");
            case '.':
                numbers.add(2, ".");
            case '-':
            case '+':
            case '*':
            case '/':
                return new OperatorSplitState(numbers, cursor);
            default:
                numbers.add(0, "*");
                return new NumberSplitState(numbers, cursor);
        }
    }
}
