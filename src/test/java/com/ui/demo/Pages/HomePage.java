package com.ui.demo.Pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ui.demo.common.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends Page {

    @FindBy(css = "a.brand[href='index.php']")
    WebElement headerLink;

    @FindBy(css = "div.container h1")
    WebElement header;

    @FindBy(css = "select[name='fromPort']")
    WebElement fromPortDropDwn;

    @FindBy(css = "select[name='toPort']")
    WebElement toPortDropDown;

    @FindBy(css ="input.btn.btn-primary")
    WebElement searchFlightBtn;

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    public void load() {
        super.load();
    }

    public  void verifyPageLoaded(){
        wait.until(ExpectedConditions.visibilityOf(headerLink));
        assertThat(headerLink.getText().equals("Travel The World")).isTrue();

    }

    public void selectFromCity(String city){
        wait.until(ExpectedConditions.elementToBeClickable(fromPortDropDwn));
        Select fromCity = new Select(fromPortDropDwn);
        fromCity.selectByValue(city);
    }

    public void selectToCity(String city){
        wait.until(ExpectedConditions.elementToBeClickable(toPortDropDown));
        Select toCity = new Select(toPortDropDown);
        toCity.selectByValue(city);
    }

    public void clickOnSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightBtn));
        searchFlightBtn.click();
    }

}
