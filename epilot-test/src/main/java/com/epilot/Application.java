package com.epilot;

import static spark.Spark.*;

import com.epilot.controller.MultipledOfController;
import com.epilot.service.MultipleOfNumberService;

public class Application {
    public static void main(String[] args) {
    	port(8080);
    	
    	post("/baz", (req, res) -> new MultipledOfController(new MultipleOfNumberService()).checkMultipledbyNumber(req, res));
    	post("/fiz", (req, res) -> new MultipledOfController(new MultipleOfNumberService()).checkMultipledbyNumber(req, res));
    	
    }
}