package com.calley.CalleyTeamsFullSetup;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pompages.RegistrationPage;

public class RegistrationTest extends BaseClass {

    @Test
    public void registerUser() throws InterruptedException {

        setup();

        driver.get(getProperty("registrationUrl"));

        RegistrationPage registrationPage =
                new RegistrationPage(driver);

        registrationPage.enterName(getProperty("name"));

        registrationPage.enterEmail(getProperty("email"));
        
        registrationPage.enterPassword(getProperty("password"));


        System.out.println(
            "Please complete the CAPTCHA manually to proceed with registration");

        try {
            Thread.sleep(15000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        registrationPage.enterPhone(getProperty("phone"));

       // System.out.println(driver.findElement(By.id("checkbox-signup")).isDisplayed());
        //System.out.println(driver.findElement(By.id("checkbox-signup")).isEnabled());
        
        registrationPage.clickTermsCheckbox();
        
        registrationPage.clickRegister();

        Thread.sleep(5000);
        
        driver.findElement(By.xpath("//button[@class='confirm']")).click();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("OTP_Verification"),  "Registration failed. OTP Verification page was not displayed.");

        //closeBrowser();
    }
}