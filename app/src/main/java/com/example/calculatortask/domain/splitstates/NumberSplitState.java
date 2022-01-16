package com.example.calculatortask.domain.splitstates;

import android.media.VolumeShaper;

import java.util.List;

public class NumberSplitState extends BaseSplitState {
    public NumberSplitState(List<String> numbers, int cursor) {
        this.numbers.addAll(numbers);
        this.cursor = cursor;
    }

    @Override
    public BaseSplitState nextSymbol(char inputSymbol) {
        String change = numbers.get(cursor);

        switch (inputSymbol) {
            case '0':
                numbers.add(cursor, change + "0");
            case '1':
                numbers.add(cursor, change + "1");
            case '2':
                numbers.add(cursor, change + "2");
            case '3':
                numbers.add(cursor, change + "3");
            case '4':
                numbers.add(cursor, change + "4");
            case '5':
                numbers.add(cursor, change + "5");
            case '6':
                numbers.add(cursor, change + "6");
            case '7':
                numbers.add(cursor, change + "7");
            case '8':
                numbers.add(cursor, change + "8");
            case '9':
                numbers.add(cursor, change + "9");
            case '.':
                numbers.add(cursor, change + ".");
                return this;
            case '-':
            case '+':
            case '*':
            case '/':
                return new SignSplitState(numbers, cursor);
            default:
                numbers.add(0, "*");
                return new NumberSplitState(numbers, cursor);
        }
    }
}
