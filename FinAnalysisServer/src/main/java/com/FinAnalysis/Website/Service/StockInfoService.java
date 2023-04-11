package com.FinAnalysis.Website.Service;

import com.FinAnalysis.Website.APIConnection.AlphaVantageConnector;
import com.FinAnalysis.Website.FinancialStatements.BalanceSheet;
import com.FinAnalysis.Website.FinancialStatements.CashFlow;
import com.FinAnalysis.Website.FinancialStatements.IncomeStatement;
import com.FinAnalysis.Website.FinancialStatements.TimeSeries;
import com.FinAnalysis.Website.Model.FinancialInfo;
import jdk.jshell.execution.JdiExecutionControlProvider;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.Iterator;

@Service
public class StockInfoService {
    private final String apiKey = "KJHOTYX4RQYVFABB";
    private final int timeout = 3000;

    private final AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
    private final IncomeStatement incomeStatement = new IncomeStatement(apiConnector);
    private final BalanceSheet balanceSheet = new BalanceSheet(apiConnector);
    private final CashFlow cashFlow = new CashFlow(apiConnector);
    private final TimeSeries timeSeries = new TimeSeries(apiConnector);


    public JSONObject getIncomeStatement(String symbol) {
        return incomeStatement.getIncomeStatement(symbol);
    }

    public JSONObject getBalanceSheet(String symbol) {
        return balanceSheet.getBalanceSheet(symbol);
    }

    public JSONObject getCashFlow(String symbol) {
        return cashFlow.getCashFlow(symbol);
    }

    public JSONObject getTimeSeries(String symbol) {
        return timeSeries.getTimeSeries(symbol);
    }

    // function to get individual most important info
    public JSONObject getInfo(String symbol) {
        final JSONObject IS = incomeStatement.getIncomeStatement(symbol);
        final JSONObject BS = balanceSheet.getBalanceSheet(symbol);
        final JSONObject CF = cashFlow.getCashFlow(symbol);
        final JSONObject TS = timeSeries.getTimeSeries(symbol);
        //final JSONObject timeSeries = TS.getJSONObject("Time Series (5min)");

        final JSONArray BSAnnualReports = BS.getJSONArray("annualReports");
        final JSONArray ISAnnualReports = IS.getJSONArray("annualReports");
        final JSONArray CFAnnualReports = CF.getJSONArray("annualReports");

        final JSONObject firstBSAnnual = BSAnnualReports.getJSONObject(0);
        final JSONObject firstISAnnual = ISAnnualReports.getJSONObject(0);
        final JSONObject firstCFAnnual = CFAnnualReports.getJSONObject(0);

//        Iterator<String> keys = timeSeries.keys();
//        String firstKey = keys.next();
//        final JSONObject lastDay = timeSeries.getJSONObject(firstKey);


        // raw data
        final long totalAssets = firstBSAnnual.getLong("totalCurrentAssets");
        final long totalLiabilites = firstBSAnnual.getLong("totalCurrentLiabilities");
        final long shareHolderEquity = firstBSAnnual.getLong("totalShareholderEquity");
        final long currentRevenue = firstISAnnual.getLong("totalRevenue");
        final long netIncome = firstCFAnnual.getLong("netIncome");
        final long grossProfit = firstISAnnual.getLong("grossProfit");
        final long sharesOutstanding = firstBSAnnual.getLong("commonStockSharesOutstanding");
        final long operatingCashFlow = firstCFAnnual.getLong("operatingCashflow");
        final long EBITDA = firstISAnnual.getLong("ebitda");
        final long debt = firstBSAnnual.getLong("currentDebt");
        final long investments = firstBSAnnual.getLong("currentDebt");
        final float dividendYield = firstCFAnnual.getFloat("dividendPayout");


        //calculations
        final float currentRatio = currentRatio(firstBSAnnual);
        final float workingCapital = workingCapital(firstBSAnnual);
        final float debtEquity = debtEquityRatio(firstBSAnnual);
        final float EPS = EPS(firstCFAnnual, firstBSAnnual);
        final float freeCashFlow = freeCashFlow(firstCFAnnual);
//        final float priceToBook  = priceToBookRatio(firstBSAnnual, lastDay);
//        final float PERatio = PERatio(lastDay, firstCFAnnual, firstBSAnnual);
        final float ROE = ROE(firstCFAnnual, firstBSAnnual);


//        FinancialInfo financialInfo = new FinancialInfo(currentRatio, workingCapital, debtEquity, EPS, freeCashFlow, ROE);
////                priceToBook, PERatio, ROE);

        JSONObject financialInfo = new JSONObject();
        financialInfo.put("Total Assets", totalAssets);
        financialInfo.put("Total Liabilities", totalLiabilites);
        financialInfo.put("Share Holder Equity", shareHolderEquity);
        financialInfo.put("Current Revenue", currentRevenue);
        financialInfo.put("Net Income", netIncome);
        financialInfo.put("Gross Profit", grossProfit);
        financialInfo.put("Shares Outstanding", sharesOutstanding);
        financialInfo.put("Operating Cash Flow", operatingCashFlow);
        financialInfo.put("EBITDA", EBITDA);
        financialInfo.put("Debt", debt);
        financialInfo.put("Investments", investments);
        financialInfo.put("Divident Payout", dividendYield);
        financialInfo.put("Current Ratio", currentRatio);
        financialInfo.put("Working Capital", workingCapital);
        financialInfo.put("Debt to Equity", debtEquity);
        financialInfo.put("EPS", EPS);
        financialInfo.put("Free Cash Flow", freeCashFlow);
        financialInfo.put("Return on Equity", ROE);

        return financialInfo;

    }

    private float currentRatio(JSONObject firstBSAnnual) {
        final float currentAssets = firstBSAnnual.getFloat("totalCurrentAssets");
        final float currentLiabilities = firstBSAnnual.getFloat("totalCurrentLiabilities");

        return currentAssets / currentLiabilities;
    }

    private float workingCapital(JSONObject firstBSAnnual) {
        final float currentAssets = firstBSAnnual.getFloat("totalCurrentAssets");
        final float currentLiabilities = firstBSAnnual.getFloat("totalCurrentLiabilities");

        return currentAssets - currentLiabilities;
    }

    private float debtEquityRatio(JSONObject firstBSAnnual) {
        final float liabilities = firstBSAnnual.getFloat("totalLiabilities");
        final float shareholderEquity = firstBSAnnual.getFloat("totalShareholderEquity");

        return liabilities / shareholderEquity;
    }

    private float EPS(JSONObject firstCFAnnual, JSONObject firstBSAnnual) {
        final float dividendPayout = firstCFAnnual.getFloat("dividendPayout");
        final float netIncome = firstCFAnnual.getFloat("netIncome");
        final float sharesOutstanding = firstBSAnnual.getFloat("commonStockSharesOutstanding");

        return (netIncome - dividendPayout) / sharesOutstanding;
    }

    private float freeCashFlow(JSONObject firstCFAnnual) {
        final float operatingCashFlow = firstCFAnnual.getFloat("operatingCashflow");
        final float capitalExpenditures = firstCFAnnual.getFloat("capitalExpenditures");

        return operatingCashFlow - capitalExpenditures;
    }

    private float priceToBookRatio(JSONObject firstBSAnnual, JSONObject lastDay) {
        final float finalPrice = lastDay.getFloat("4. close");
        final float sharesOutstanding = firstBSAnnual.getFloat("commonStockSharesOutstanding");
        final float shareholderEquity = firstBSAnnual.getFloat("totalShareholderEquity");

        return finalPrice / (shareholderEquity / sharesOutstanding);
    }


    private float PERatio(JSONObject lastDay, JSONObject firstCFAnnual, JSONObject firstBSAnnual) {
        final float EPS = EPS(firstCFAnnual, firstBSAnnual);
        final float finalPrice = lastDay.getFloat("4. close");

        return finalPrice / EPS;
    }

    private float ROE(JSONObject firstCFAnnual, JSONObject firstBSAnnual) {
        final float netIncome = firstCFAnnual.getFloat("netIncome");
        final float shareholderEquity = firstBSAnnual.getFloat("totalShareholderEquity");

        return netIncome / shareholderEquity;
    }







}
