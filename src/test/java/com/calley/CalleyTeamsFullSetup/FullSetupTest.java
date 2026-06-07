package com.calley.CalleyTeamsFullSetup;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pompages.AgentPage;
import pompages.CSVUploadPage;
import pompages.Dashboard;
import pompages.LoginPage;

public class FullSetupTest extends BaseClass {

    @Test
    public void fullSetup() throws InterruptedException {

        setup();

        //AUTOMATING LOGIN PAGE
        
        driver.get(getProperty("loginUrl"));

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.enterEmail(
                getProperty("loginEmail"));

        loginPage.enterPassword(
                getProperty("loginPassword"));

        loginPage.clickLogin();

        try {
            Thread.sleep(5000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //CHECKING WHETHER PAGE NAVIGATED TO DASHBOARD PAGE AFTER SUCCESSFULL LOGIN
        
        Assert.assertTrue(
                driver.getCurrentUrl()
                        .contains("dashboard"),
                "Login Failed");

        System.out.println(
                "Login Successful");
        
        Dashboard  dashboard=new Dashboard(driver); 
        
        dashboard.closeNotificationPopup();

        Thread.sleep(2000);
        
        dashboard.navigateToAgents();

        Thread.sleep(3000);
        
       //AUTOMATING ADDING AGENTS
        
        AgentPage agentPage =
                new AgentPage(driver);
        
        Assert.assertTrue(
        	    driver.getCurrentUrl()
        	          .contains("agents.aspx"),
        	    "Agents page not opened"
        	);

        agentPage.enterAgentName(
                getProperty("agentName"));

        agentPage.enterAgentMobile(
                getProperty("agentMobile"));

        agentPage.enterAgentEmail(
                getProperty("agentEmail"));

        agentPage.enterAgentPassword(
                getProperty("agentPassword"));

        agentPage.clickSubmit();

        Thread.sleep(3000);

        Assert.assertEquals(
                agentPage.getSuccessMessage(),
                "Agent Added Successfully!"
        );

        agentPage.clickOK();
        
        //VERIFYING WHETHER ADDED AGENT IS DISPLAYED IN THE AGENT TABLE/LIST
        
        Assert.assertTrue(
        	    driver.findElement(
        	        By.xpath("//td[text()='"
        	            + getProperty("agentEmail")
        	            + "']")
        	    ).isDisplayed()
        	);

        //AUTOMATING CSV FILE UPLOAD
        
        CSVUploadPage csvPage =
                new CSVUploadPage(driver);

        csvPage.navigateToPowerImport();

        Thread.sleep(2000);

        Assert.assertTrue(
                driver.getCurrentUrl()
                      .contains("BulkUploadCsv"),
                "Power Import page not opened");

        csvPage.enterListName(
                getProperty("listName"));

        csvPage.selectAllAgents();

        csvPage.uploadCSV(
                getProperty("csvPath"));

        csvPage.clickUpload();

        Thread.sleep(2000);

        csvPage.confirmUpload();

        Thread.sleep(3000);

        csvPage.mapFields();

        csvPage.clickImportButton();

        Thread.sleep(3000);

        Assert.assertTrue(
                csvPage.getUploadSuccessMessage().contains("Data Uploaded Successfully!"));

        csvPage.clickSuccessOk();
        
        Assert.assertTrue(
                driver.getCurrentUrl()
                      .contains("CallReport"),
                "Call Report page not opened");
        
        Assert.assertTrue(
                csvPage.isListPresent(
                        getProperty("listName")),
                "Uploaded list not found");
        // closeBrowser();
    }
}