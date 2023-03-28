package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIConnector;
import org.json.JSONObject;

public class IncomeStatement {
    private final APIConnector apiConnector;

    public IncomeStatement (APIConnector apiConnector) {
        this.apiConnector = apiConnector;
    }

    public JSONObject getIncomeStatement(String symbol) {
        JSONObject json = apiConnector.getRequest(new Symbol(symbol), Function.INCOME_STATEMENT);
        return json;
    }

}
