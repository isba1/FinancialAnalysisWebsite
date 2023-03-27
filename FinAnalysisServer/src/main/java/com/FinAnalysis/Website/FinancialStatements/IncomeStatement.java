package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIConnector;

public class IncomeStatement {
    private final APIConnector apiConnector;

    public IncomeStatement (APIConnector apiConnector) {
        this.apiConnector = apiConnector;
    }

    public String getIncomeStatement(String symbol) {
        String json = apiConnector.getRequest(new Symbol(symbol), Function.INCOME_STATEMENT);
        return json;
    }

}
