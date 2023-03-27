package com.FinAnalysis.Website.Controller;

import com.FinAnalysis.Website.Service.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticker")

public class StockInfoController {

    @Autowired
    private StockInfoService service;

    @GetMapping("/getIncomeStatement")
    public String getIncomeStatement(@RequestBody String symbol) {
        return service.getIncomeStatement(symbol);
    }

}
