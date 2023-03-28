package com.FinAnalysis.Website.FinancialStatements;

import com.FinAnalysis.Website.APIConnection.APIConnector;

public class TimeSeries {
    private final APIConnector apiConnector;

    public TimeSeries (APIConnector apiConnector) {
        this.apiConnector = apiConnector;
    }


    public String getTimeSeries(String symbol) {
        String json = apiConnector.getRequest(new Symbol(symbol), Function.TIME_SERIES_DAILY_ADJUSTED);
        return json;
    }
}
