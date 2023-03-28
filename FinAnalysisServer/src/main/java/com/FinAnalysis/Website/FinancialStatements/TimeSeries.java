package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIConnector;
import org.json.JSONObject;

public class TimeSeries {
    private final APIConnector apiConnector;

    public TimeSeries (APIConnector apiConnector) {
        this.apiConnector = apiConnector;
    }


    public JSONObject getTimeSeries(String symbol) {
        JSONObject json = apiConnector.getRequest(new Symbol(symbol), Function.TIME_SERIES_DAILY_ADJUSTED);
        return json;
    }
}
