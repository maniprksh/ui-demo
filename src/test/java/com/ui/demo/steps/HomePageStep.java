package com.ui.demo.steps;

import com.ui.demo.Pages.HomePage;
import com.ui.demo.Pages.ReserverPage;
import cucumber.api.java8.En;

public class HomePageStep implements En {
    HomePage home = new HomePage();
    ReserverPage reserve = new ReserverPage();

    public HomePageStep() {
        Given("^I navigate to the Blazeurl$", () -> {
            home.load();
            home.verifyPageLoaded();
        });
        When("^I select the from city as \"([^\"]*)\"$", (String fromcity) -> {
            home.selectFromCity(fromcity);
        });
        And("^I select to city as \"([^\"]*)\"$", (String toCity) -> {
            home.selectToCity(toCity);
        });
        Then("^I click on Find flight button$", () -> {
            home.clickOnSearchBtn();
        });
        And("^verify reserve page url$", () -> {
            reserve.verifyURL();
        });

        And("^I verify the header of the page for city \"([^\"]*)\" to \"([^\"]*)\"$", (String fromCity, String toCity) -> {
            reserve.verifyHeaderOfReservePage(fromCity,toCity);
        });
    }
}
