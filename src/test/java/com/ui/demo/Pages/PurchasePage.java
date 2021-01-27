package com.ui.demo.Pages;

import com.ui.demo.common.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PurchasePage extends Page {

    private static final Logger log = LoggerFactory.getLogger(PurchasePage.class);

    @FindBy(css = "input#inputName")
    WebElement nameField;

    @FindBy(css="input#address")
    WebElement addressField;

    @FindBy(css = "input[name='city']")
    WebElement cityField;

    @FindBy(css = "input[name='state']")
    WebElement stateField;

    @FindBy(css = "input#zipCode")
    WebElement zipCodeField;

    @FindBy(css = "select[name='cardType']")
    WebElement visaSelect;

    @FindBy(css = "input[name='creditCardNumber']")
    WebElement creditCardField;

    @FindBy(css ="input[name='creditCardMonth']")
    WebElement monthField;

    @FindBy(css ="input[name='creditCardYear']")
    WebElement yearField;

    @FindBy(css ="input[name='nameOnCard']")
    WebElement nameOnCardField;

    @FindBy(css = "input[name='rememberMe']")
    WebElement rememberMeCheckBx;

    @FindBy(css = "input.btn.btn-primary")
    WebElement purchaseBtn;


    public void setNameField(String name){
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(name);
    }

    public void setAddressField(String name){
        addressField.sendKeys(name);
    }

    public void setCityField(String name){
        cityField.sendKeys(name);
    }

    public void setStateField(String name){
        stateField.sendKeys(name);
    }

    public void setZipCodeField(String name){
        zipCodeField.sendKeys(name);
    }

    public void setVisaSelect(String name){
        Select s = new Select(visaSelect);
        s.selectByValue(name);
    }

    public void setCreditCardField(String cardNo){
        creditCardField.sendKeys(cardNo);
    }

    public void setMonthField(String name){
        monthField.sendKeys(name);
    }

    public void setYearField(String name){
        yearField.sendKeys(name);
    }

    public void setNameOnCardField(String name){
        nameOnCardField.sendKeys(name);
    }

    public void setRememberMeCheckBx(String flag){
        if(flag.equalsIgnoreCase("Y"))
        rememberMeCheckBx.click();
        else
            log.info("Remember me checkbox not cliked");
    }

    public void clickPurchaseBtn(){
        purchaseBtn.click();
    }

}
