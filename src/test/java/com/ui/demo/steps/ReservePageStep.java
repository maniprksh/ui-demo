package com.ui.demo.steps;

import com.ui.demo.Pages.ReserverPage;
import cucumber.api.java8.En;

public class ReservePageStep implements En {
    ReserverPage reserve = new ReserverPage();
    public ReservePageStep() {
        And("^I click on \"([^\"]*)\" flight$", (String airline) -> {
            reserve.findFlightAndChooseFlight(airline);
        });

    }
}
