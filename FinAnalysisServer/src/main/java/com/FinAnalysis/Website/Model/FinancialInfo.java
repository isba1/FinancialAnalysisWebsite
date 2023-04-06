package com.FinAnalysis.Website.Model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FinancialInfo {
//    float totalAssets;
//    float totalLiabilities;
//    float shareHolderEquity;
//    float currentRevenue;
//    float netIncome;
//    float grossProfit;
//    float sharesOutstanding;
//    float operatingCashFlow;
//    float capitalExpenditures;
//    double priceToday;
//    float EBITDA;
//    float debt;
//    float investments;
//    float cashCashEquivalents;
//    double dividendYield;
//    float currentAssets;
//    float currentLiabilities;
    float currentRatio;
    float workingCapital;
    float debtEquityRatio;
    float EPS;
    float freeCashFlow;
//    float priceToBookRatio;
//    float PERatio;
    float ROE;


    public FinancialInfo(
//    float totalAssets, float totalLiabilities, float shareHolderEquity, float currentRevenue,
//                         float netIncome, float grossProfit, float sharesOutstanding, float operatingCashFlow,
//                         float capitalExpenditures, double priceToday, float EBITDA, float debt, float investments,
//                         float cashCashEquivalents, double dividendYield, float currentAssets, float currentLiabilities,
                         float currentRatio, float workingCapital, float debtEquityRatio, float EPS, float freeCashFlow, float ROE) {
//                         float priceToBookRatio, float PERatio, float ROE) {
//        this.totalAssets = totalAssets;
//        this.totalLiabilities = totalLiabilities;
//        this.shareHolderEquity = shareHolderEquity;
//        this.currentRevenue = currentRevenue;
//        this.netIncome = netIncome;
//        this.grossProfit = grossProfit;
//        this.sharesOutstanding = sharesOutstanding;
//        this.operatingCashFlow = operatingCashFlow;
//        this.capitalExpenditures = capitalExpenditures;
//        this.priceToday = priceToday;
//        this.EBITDA = EBITDA;
//        this.debt = debt;
//        this.investments = investments;
//        this.cashCashEquivalents = cashCashEquivalents;
//        this.dividendYield = dividendYield;
//        this.currentAssets = currentAssets;
//        this.currentLiabilities = currentLiabilities;
        this.currentRatio = currentRatio;
        this.workingCapital = workingCapital;
        this.debtEquityRatio = debtEquityRatio;
        this.EPS = EPS;
        this.freeCashFlow = freeCashFlow;
//        this.priceToBookRatio = priceToBookRatio;
//        this.PERatio = PERatio;
        this.ROE = ROE;
    }
}
