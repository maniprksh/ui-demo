package com.ui.demo.Pages;

import com.ui.demo.common.Helpers;
import com.ui.demo.common.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReserverPage extends Page {

    private static final Logger log = LoggerFactory.getLogger(ReserverPage.class);

    @FindBy(css = "div.container h3")
    WebElement headerReservePage;

    @FindBy(css = "table.table tbody tr")
    List<WebElement>chooseFlightRow;

    @FindBy(css = "input.btn.btn-small")
    List<WebElement> chooseFlightbtn;


    public void verifyURL(){
        wait.until(ExpectedConditions.visibilityOf(headerReservePage));
        assertThat(Helpers.getCurrentURL(driver).equals("https://blazedemo.com/reserve.php")).isTrue();
    }

    public void verifyHeaderOfReservePage(String fromCity, String toCity){
        wait.until(ExpectedConditions.visibilityOf(headerReservePage));
        String expectedHeader = "Flights from "+fromCity+" to "+toCity+":";
        assertThat(headerReservePage.getText().equalsIgnoreCase(expectedHeader)).isTrue();
    }

    public void findFlightAndChooseFlight(String airline){
        wait.until(ExpectedConditions.visibilityOfAllElements(chooseFlightRow));
        for(int i =0; i< chooseFlightRow.size();i++){
            List<WebElement> col = chooseFlightRow.get(i).findElements(By.cssSelector("td"));
            if(col.get(2).getText().equalsIgnoreCase(airline)){
                log.info("Airline found : " + col.get(2).getText());
                log.info("Price of flight : " + col.get(5).getText());
                chooseFlightbtn.get(i).click();
                break;
            }
        }
    }


}
