package com.calley.CalleyTeamsFullSetup;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

    public static WebDriver driver;

    public void setup() {

    	ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void closeBrowser() {

        if(driver != null) {
            driver.quit();
        }
       
    }
    
    public String getProperty(String key) {

        Properties prop = new Properties();

        try {

            FileInputStream fis =
                    new FileInputStream("src/main/resources/data.properties");

            prop.load(fis);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return prop.getProperty(key);
    }
}