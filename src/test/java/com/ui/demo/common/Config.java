package com.ui.demo.common;

public class Config {
    private static final String URL = "DEMOURL";
    private static final String ApiBase = "API";

    public static String getConfigURL() {
        String baseUrl = System.getenv(URL);
        return baseUrl;
    }

    public static String getAPIBaseURL(){
        String apiBaseUrl = System.getenv(ApiBase);
        return apiBaseUrl;
    }
}
