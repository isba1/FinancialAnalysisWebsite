package com.FinAnalysis.Website.Service;

import com.FinAnalysis.Website.APIConnection.AlphaVantageConnector;
import com.FinAnalysis.Website.FinancialStatements.BalanceSheet;
import com.FinAnalysis.Website.FinancialStatements.CashFlow;
import com.FinAnalysis.Website.FinancialStatements.IncomeStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockInfoService {
    private final String apiKey = "KJHOTYX4RQYVFABB";
    private final int timeout = 3000;

    private final AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
    private final IncomeStatement incomeStatement = new IncomeStatement(apiConnector);
    private final BalanceSheet balanceSheet = new BalanceSheet(apiConnector);
    private final CashFlow cashFlow = new CashFlow(apiConnector);


    public String getIncomeStatement(String symbol) {
        return incomeStatement.getIncomeStatement(symbol);
    }

    public String getBalanceSheet(String symbol) {
        return balanceSheet.getBalanceSheet(symbol);
    }

    public String getCashFlow(String symbol) {
        return cashFlow.getCashFlow(symbol);
    }



}
