package com.example.calculatortask.domain.splitstates;

import java.util.List;

public class FirstNumberSplitState extends BaseSplitState {
    public FirstNumberSplitState(List<String> numbers, int cursor, List<String> operators) {
        this.numbers.addAll(numbers);
        this.cursor = cursor;
        this.operators = operators;
    }

    @Override
    public BaseSplitState nextSymbol(char inputSymbol) {

        String change = numbers.get(cursor);

        switch (inputSymbol) {
            case '0':
                numbers.set(cursor, change + "0");
                return this;
            case '1':
                numbers.set(cursor, change + "1");
                return this;

            case '2':
                numbers.set(cursor, change + "2");
                return this;

            case '3':
                numbers.set(cursor, change + "3");
                return this;

            case '4':
                numbers.set(cursor, change + "4");
                return this;

            case '5':
                numbers.set(cursor, change + "5");
                return this;

            case '6':
                numbers.set(cursor, change + "6");
                return this;

            case '7':
                numbers.set(cursor, change + "7");
                return this;

            case '8':
                numbers.set(cursor, change + "8");
                return this;

            case '9':
                numbers.set(cursor, change + "9");
                return this;
            case '.':
                numbers.set(cursor, change + ".");
                return this;
            case '-':
                operators.add("-");
                return new SignSplitState(numbers, operators, cursor++);
            case '+':
                operators.add("+");
                return new SignSplitState(numbers, operators, cursor++);
            case '*':
                operators.add("*");
                return new SignSplitState(numbers, operators, cursor++);
            case '/':
                operators.add("/");
                return new SignSplitState(numbers, operators, cursor++);
            default:
                numbers.add(0, "X");
                return new FirstNumberSplitState(numbers, cursor, operators);
        }
    }
}
