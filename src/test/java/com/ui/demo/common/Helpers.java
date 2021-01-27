package com.ui.demo.common;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Helpers extends Page{

    private static final Logger log = LoggerFactory.getLogger(Helpers.class);
     public static String getCurrentURL(WebDriver driver){
         String currentUrl = driver.getCurrentUrl();
         return currentUrl;
     }



}
