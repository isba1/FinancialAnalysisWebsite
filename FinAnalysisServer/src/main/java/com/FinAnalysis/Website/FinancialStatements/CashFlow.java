package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIConnector;
import com.FinAnalysis.Website.APIConnection.APIParameter;
import org.json.JSONObject;

public class CashFlow {
    private final APIConnector apiConnector;

    public CashFlow (APIConnector apiConnector) {
        this.apiConnector = apiConnector;
    }

    public JSONObject getCashFlow(String symbol) {
        JSONObject json = apiConnector.getRequest(new Symbol(symbol), Function.CASH_FLOW);
        return json;
    }


}
