package com.ems.ems.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigTestController {

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.datasource.url}")
    private String dbConnectionUrl;

    @GetMapping("/config")
    public String getConfig() {
        return "Server Port: " + serverPort + ", DB Connection URL: " + dbConnectionUrl;
    }
}
