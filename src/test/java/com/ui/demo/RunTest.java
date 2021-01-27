package com.ui.demo;

import com.cucumber.listener.Reporter;
import com.ui.demo.common.DriverWrapper;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
                plugin = { "junit:target/results/cucumber.xml", "com.cucumber.listener.ExtentCucumberFormatter:target/results/report.html"})

public class RunTest {

    @AfterClass
    public static void setup()
    {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        Reporter.setSystemInfo("User Name", "Mani");
        Reporter.setSystemInfo("Application Name", "Blaze App ");
        Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
        Reporter.setSystemInfo("Environment", "Test");
        Reporter.setTestRunnerOutput("Test Execution Cucumber Report");

        DriverWrapper.getInstance().closeBrowser();
    }

}
