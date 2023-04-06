package com.FinAnalysis.Website.Controller;

import com.FinAnalysis.Website.Model.FinancialInfo;
import com.FinAnalysis.Website.Service.StockInfoService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticker")

public class StockInfoController {

    @Autowired
    private StockInfoService service;

    @GetMapping("/getIncomeStatement")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> getIncomeStatement(@RequestParam(name = "symbol") String symbol) {
        JSONObject jsonObject = service.getIncomeStatement(symbol);
        //return new JSONObject(jsonString);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Access-Control-Allow-Origin", "*");
//        headers.add("Content-Type", "application/json");
        return new ResponseEntity<>(jsonObject.toMap(), HttpStatus.OK);
    }

    @GetMapping("/getInfo")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Object> getInfo(@RequestParam(name = "symbol") String symbol) {
        JSONObject financialInfo = service.getInfo(symbol);
        return new ResponseEntity<>(financialInfo.toMap(), HttpStatus.OK);
    }

}
