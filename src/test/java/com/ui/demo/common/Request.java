package com.ui.demo.common;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Request {

    public Response restGET(String url) {
        Response response = RestAssured.given()
                .urlEncodingEnabled(false)
                .relaxedHTTPSValidation()
                .when().get(url)
                .then().statusCode(200).extract().response();
        return response;
    }
}
