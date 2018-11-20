package com.mycorp;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class CucumberSteps {
    WebDriver driver;
    Selenium selenium;

    @Before
    public void init(){
        selenium = new Selenium();
    }

    // 1
    @Given("^Selenium Driver is initialized$")
    public void seleniumDriverIsInitialized() throws Throwable {
        // driver = selenium.initFirefox();
        driver = selenium.initChrome();
    }

    // 2
    @Given("^The \"([^\"]*)\" page opened in browser$")
    public void thePageOpenedInBrowser(String url) throws Throwable {
        // boolean navigated = selenium.step_check_title(driver, "https://google.com");
        boolean navigated = selenium.step_check_title(driver, url);
        if(!navigated) { throw new PendingException("Can't navigate to: "+url); }
    }

    // 3
    @Then("^Page Title should contain \"([^\"]*)\"$")
    public void pageTitleShouldContain(String title) throws Throwable {
//        boolean titled = selenium.step_navigate(driver, "Goolge");
        boolean titled = selenium.step_navigate(driver, title);
        if(!titled) { throw new PendingException("Can't find title: "+title); }
    }
}
