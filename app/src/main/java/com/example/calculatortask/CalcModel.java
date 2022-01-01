package com.example.calculatortask;

import java.util.ArrayList;
import java.util.List;

public class CalcModel {
    private List<CalcSymbols> calcSymbolsList = new ArrayList<>();

    public void calcSymbolsValidation(CalcSymbols value) {

    }

    public List<CalcSymbols> getCalcSymbolsList() {
        return new ArrayList<>(calcSymbolsList);
    }
}
