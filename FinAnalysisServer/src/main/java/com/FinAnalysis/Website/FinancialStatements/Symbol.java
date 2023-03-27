package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIParameter;

public class Symbol implements APIParameter {
    private String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getKey() {
        return "symbol";
    }

    @Override
    public String getValue() {
        return symbol;
    }
}
