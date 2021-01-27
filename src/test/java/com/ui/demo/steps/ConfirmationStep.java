package com.ui.demo.steps;

import com.ui.demo.Pages.ConfirmationPage;
import cucumber.api.java8.En;

public class ConfirmationStep implements En {
    public ConfirmationStep() {

        ConfirmationPage confirm = new ConfirmationPage();

        And("^Confirm Purchase Page$", () -> {
            confirm.verifyURL();
            confirm.getIdAndStatus();
        });
    }
}
