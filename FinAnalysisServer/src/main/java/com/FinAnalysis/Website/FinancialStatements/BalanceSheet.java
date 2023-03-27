package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIConnector;
import com.FinAnalysis.Website.APIConnection.APIParameter;

public class BalanceSheet {

    private final APIConnector apiConnector;

    public BalanceSheet(APIConnector apiConnector) {
        this.apiConnector = apiConnector;
    }


    public String getBalanceSheet(String symbol) {
        String json = apiConnector.getRequest(new Symbol(symbol), Function.BALANCE_SHEET);
        return json;
    }
}
