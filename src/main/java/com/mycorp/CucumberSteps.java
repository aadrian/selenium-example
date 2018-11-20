package com.mycorp;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CucumberSteps {
    static String APP_HOME;
    WebDriver driver;
    Selenium selenium;

    @Before
    public void init(){
        selenium = new Selenium();
        try {
            APP_HOME = Utils.fixAppHome();
        } catch (IOException e) {
            // we can't continue, since the app home is not correct
            throw new PendingException(e.getMessage());
        }
    }

    // 1
    @Given("^Selenium Driver is initialized$")
    public void seleniumDriverIsInitialized() throws Throwable {
        // driver = selenium.initFirefox(APP_HOME);
        driver = selenium.initChrome(APP_HOME);
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
