package com.ui.demo.common;

import org.openqa.selenium.support.PageFactory;

public class Page extends AnyPage{

    private String baseUrl;

    public Page() {
        baseUrl = Config.getConfigURL();
        PageFactory.initElements(driver, this);
    }

    public void load(){
        System.out.println(baseUrl);
        driver.get(baseUrl);
    }
}
