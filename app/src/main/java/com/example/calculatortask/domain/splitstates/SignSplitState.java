package com.example.calculatortask.domain.splitstates;

import java.util.List;

public class SignSplitState extends BaseSplitState {
    public SignSplitState() {
        super();
    }

    public SignSplitState(List<String> numbers, int cursor) {
        this.numbers.addAll(numbers);
        this.cursor = cursor;
    }

    public SignSplitState(List<String> numbers, List<String> operators, int cursor) {
        this.operators.addAll(operators);
        this.numbers.addAll(numbers);
        this.cursor = cursor;
    }

    @Override
    public BaseSplitState nextSymbol(char inputSymbol) {
        switch (inputSymbol) {
            case '-':
                return new NegativeSplitState(numbers, cursor, operators);
            case '0':
                numbers.add(cursor, "0");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '1':
                numbers.add(cursor, "1");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '2':
                numbers.add(cursor, "2");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '3':
                numbers.add(cursor, "3");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '4':
                numbers.add(cursor, "4");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '5':
                numbers.add(cursor, "5");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '6':
                numbers.add(cursor, "6");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '7':
                numbers.add(cursor, "7");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '8':
                numbers.add(cursor, "8");
                return new FirstNumberSplitState(numbers, cursor, operators);
            case '9':
                numbers.add(cursor, "9");
                return new FirstNumberSplitState(numbers, cursor, operators);
            default:
                numbers.add(0, "X");
                return new FirstNumberSplitState(numbers, cursor, operators);
        }
    }
}
