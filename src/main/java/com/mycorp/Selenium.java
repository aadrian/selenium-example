package com.mycorp;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
    public WebDriver initFirefox(String appHome) {
        System.out.println("Selenium.initFirefox");
        // OS independent way of building the WebDriver path
        String driverName = "geckodriver";
        String os = null;

        // Gekodriver contains the version in the directory name too (unlike Chrome)
        // Todo: change it here too, when changing in gradle.properties
        String gekodriverVersion = "v0.23.0";

        if(SystemUtils.IS_OS_WINDOWS) {
            driverName+=".exe"; // windows files contain the .exe
            os = "win64";
        } else if(SystemUtils.IS_OS_MAC_OSX) {
            os = "macos";
        } else if(SystemUtils.IS_OS_LINUX) {
            os = "linux64";
        } else {
            throw new RuntimeException("Unsupported OS");
        }

        String driverFileName = appHome+"/drivers/geckodriver-"+gekodriverVersion+"-"+os+"/"+driverName;
        System.out.println("using driverFileName = " + driverFileName);

        // set the driver location
        System.setProperty("webdriver.gecko.driver", driverFileName);
        return new FirefoxDriver();
    }

    public WebDriver initChrome(String appHome) {
        System.out.println("Selenium.initChrome");
        // OS independent way of building the WebDriver path
        String driverName = "chromedriver";
        String os = null;
        if(SystemUtils.IS_OS_WINDOWS) {
            driverName+=".exe"; // windows files contain the .exe
            os = "win32";
        } else if(SystemUtils.IS_OS_MAC_OSX) {
            os = "mac64";
        } else if(SystemUtils.IS_OS_LINUX) {
            os = "linux64";
        } else {
            throw new RuntimeException("Unsupported OS");
        }

        String driverFileName = appHome+"/drivers/chromedriver_"+os+"/"+driverName;
        System.out.println("using driverFileName = " + driverFileName);

        // set the driver location
        System.setProperty("webdriver.chrome.driver", driverFileName);
        return new ChromeDriver();
    }

    public boolean step_navigate(WebDriver driver, String url) {
        System.out.println("Selenium.step_navigate");
        // navigate to Google to test if it works ...
        driver.get(url);
        return true;
    }

    public boolean step_check_title(WebDriver driver, String title) {
        System.out.println("Selenium.step_check_title");
        return driver.getTitle().toLowerCase().contains(title);
    }
}
