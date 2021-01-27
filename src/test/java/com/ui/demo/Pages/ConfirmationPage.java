package com.ui.demo.Pages;

import com.ui.demo.common.Helpers;
import com.ui.demo.common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Generated;
import java.util.List;

public class ConfirmationPage extends Page {

    private static final Logger log = LoggerFactory.getLogger(ConfirmationPage.class);

    @FindBy(css = "div.container h1")
    WebElement confirmationPageHeader;

    @FindBy(css = "table.table tr")
    List<WebElement> row;

    public void verifyURL() {
        wait.until(ExpectedConditions.visibilityOf(confirmationPageHeader));
        assertThat(Helpers.getCurrentURL(driver).equals("https://blazedemo.com/confirmation.php")).isTrue();
    }

    public void getIdAndStatus(){
        List<WebElement> valueId = row.get(1).findElements(By.cssSelector("td"));
        List<WebElement> valueStatus = row.get(2).findElements(By.cssSelector("td"));
        log.info("Id found : " + valueId.get(1).getText());
        log.info("Status found : " +valueStatus.get(1).getText());
        assertThat(valueStatus.get(1).getText().equalsIgnoreCase("PendingCapture")).isTrue();
    }


}
