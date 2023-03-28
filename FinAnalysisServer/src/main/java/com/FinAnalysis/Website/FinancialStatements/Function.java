package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIParameter;

public enum Function implements APIParameter {

    INCOME_STATEMENT("INCOME_STATEMENT"),
    BALANCE_SHEET("BALANCE_SHEET"),
    CASH_FLOW("CASH_FLOW"),
    TIME_SERIES_DAILY_ADJUSTED("TIME_SERIES_DAILY_ADJUSTED");


    private final String urlParameter;

    Function(String urlParameter) {
        this.urlParameter = urlParameter;
    }

    @Override
    public String getKey() {
        return "function";
    }

    @Override
    public String getValue() {
        return urlParameter;
    }

}
