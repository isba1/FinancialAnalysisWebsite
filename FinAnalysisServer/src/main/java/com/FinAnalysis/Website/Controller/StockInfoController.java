package com.FinAnalysis.Website.Controller;

import com.FinAnalysis.Website.Service.StockInfoService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticker")

public class StockInfoController {

    @Autowired
    private StockInfoService service;

    @GetMapping("/getIncomeStatement")
    public String getIncomeStatement(@RequestParam(name = "symbol") String symbol) {
        String jsonString = service.getIncomeStatement(symbol);
        //return new JSONObject(jsonString);
        return jsonString;
    }

}
