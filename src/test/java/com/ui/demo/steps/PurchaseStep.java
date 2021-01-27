package com.ui.demo.steps;

import com.ui.demo.Pages.PurchasePage;
import cucumber.api.java8.En;

public class PurchaseStep implements En {

    PurchasePage pruchase = new PurchasePage();
    public PurchaseStep() {
        Then("^I fill the details with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$", (String name, String add, String city) -> {
        pruchase.setNameField(name);
        pruchase.setAddressField(add);
        pruchase.setCityField(city);

        });

        And("^further details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$", (String state, String zip, String cardType, String cardNo, String month, String year, String nameOnCard) -> {
            pruchase.setStateField(state);
            pruchase.setZipCodeField(zip);
            pruchase.setVisaSelect(cardType);
            pruchase.setCreditCardField(cardNo);
            pruchase.setMonthField(month);
            pruchase.setYearField(year);
            pruchase.setNameOnCardField(nameOnCard);
        });
        And("^set remember me check box as \"([^\"]*)\"$", (String flag) -> {
            pruchase.setRememberMeCheckBx(flag);
        });
        And("^click on Purchase button$", () -> {
            pruchase.clickPurchaseBtn();
        });
    }
}
