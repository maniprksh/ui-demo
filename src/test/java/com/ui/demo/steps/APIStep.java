package com.ui.demo.steps;

import com.google.gson.JsonArray;
import com.jayway.jsonpath.JsonPath;
import com.ui.demo.common.Config;
import com.ui.demo.common.Request;
import cucumber.api.java8.En;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.assertThat;

public class APIStep implements En {

    private static final Logger log = LoggerFactory.getLogger(APIStep.class);
    public Request restRequest = new Request();
    Response response;

    public APIStep()
    {
        When("^I call \"([^\"]*)\" api$", (String api) -> {
            response = restRequest.restGET(Config.getAPIBaseURL() + api);
        });
        Then("^I verify the name as \"([^\"]*)\"$", (String name) -> {
            String resp = response.asString();
            JSONArray getName = JsonPath.read(resp,"$..[?(@.hair_color=='blond')]name");
            assertThat(getName.get(0).toString().equalsIgnoreCase(name));

        });
        And("^I print the films api$", () -> {
            String resp = response.asString();
            JSONArray getFilms = (JsonPath.read(resp,"$..[?(@.name=='Luke Skywalker')].films"));
            JSONArray getUrls = (JSONArray) getFilms.get(0);
            for(Object getUrl : getUrls){
                log.info(getUrl.toString());
            }


        });

        Then("^I print the eye color for \"([^\"]*)\"$", (String name) -> {
            String resp = response.asString();
            JSONArray getEyeColor = JsonPath.read(resp,"$..[?(@.name=='"+name+"')]eye_color");
                log.info("Eye Color of : " +name +" : "+ getEyeColor.get(0).toString());
                assertThat(getEyeColor.get(0).toString().isEmpty()).isFalse();
        });
    }
}
