package com.example.calculatortask.domain.splitstates;

import com.example.calculatortask.domain.states.BaseState;

import java.util.List;

public class SignSplitState extends BaseSplitState {
    public SignSplitState() {
        super();
    }

    public SignSplitState(List<String> numbers, int cursor) {
        this.numbers.addAll(numbers);
        this.cursor = cursor;
    }

    @Override
    public BaseSplitState nextSymbol(char inputSymbol) {
        switch (inputSymbol) {
            case '-':
                numbers.add(cursor, "-");
                return new NegativeSplitState(numbers, cursor);
            case '0':
                numbers.add(cursor, "0");
                return this;
            case '.':
                numbers.add(cursor, ".");
                return this;
            case '1':
                numbers.add(cursor, "1");
            case '2':
                numbers.add(cursor, "2");
            case '3':
                numbers.add(cursor, "3");
            case '4':
                numbers.add(cursor, "4");
            case '5':
                numbers.add(cursor, "5");
            case '6':
                numbers.add(cursor, "6");
            case '7':
                numbers.add(cursor, "7");
            case '8':
                numbers.add(cursor, "8");
            case '9':
                numbers.add(cursor, "9");
                return new NumberSplitState(numbers, cursor);
            default:
                numbers.add(0, "*");
                return new NumberSplitState(numbers, cursor);
        }
    }
}
