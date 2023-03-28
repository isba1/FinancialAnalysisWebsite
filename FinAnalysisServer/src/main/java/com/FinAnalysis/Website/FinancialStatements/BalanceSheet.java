package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIConnector;
import com.FinAnalysis.Website.APIConnection.APIParameter;
import org.json.JSONObject;

public class BalanceSheet {

    private final APIConnector apiConnector;

    public BalanceSheet(APIConnector apiConnector) {
        this.apiConnector = apiConnector;
    }


    public JSONObject getBalanceSheet(String symbol) {
        JSONObject json = apiConnector.getRequest(new Symbol(symbol), Function.BALANCE_SHEET);
        return json;
    }
}
