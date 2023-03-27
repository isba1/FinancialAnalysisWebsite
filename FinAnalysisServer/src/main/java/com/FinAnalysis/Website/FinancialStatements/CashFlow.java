package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIConnector;
import com.FinAnalysis.Website.APIConnection.APIParameter;

public class CashFlow {
    private final APIConnector apiConnector;

    public CashFlow (APIConnector apiConnector) {
        this.apiConnector = apiConnector;
    }

    public String getCashFlow(String symbol) {
        String json = apiConnector.getRequest(new Symbol(symbol), Function.CASH_FLOW);
        return json;
    }


}
