package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CSVUploadPage {

    WebDriver driver;

    By callListMenu =
            By.xpath("//span[text()='Call List ']");

    By powerImportMenu =
            By.xpath("//span[text()='Add - Power Import']");

    By listName =
            By.id("ContentPlaceHolder1_txtlistname");
    
    By selectAgentsDropDown=
    		By.xpath("//button[@title='Please select an agent']");

    By selectAllAgents =
            By.xpath("//input[@value='all']");
    
    By fileUpload =
            By.id("ContentPlaceHolder1_fileUpload");

    By uploadButton =
            By.xpath("//p[@id='btnUp']");

    By confirmPopup =
            By.xpath("//h2[text()='Are you sure?']");

    By confirmOkButton =
            By.xpath("//button[text()='Ok']");

    By firstDropdown =
            By.id("ddlbelongto_1");

    By secondDropdown =
            By.id("ddlbelongto_2");

    By thirdDropdown =
            By.id("ddlbelongto_3");

    By importButton =
            By.id("ContentPlaceHolder1_btnUpload");

    By uploadSuccessMessage =
            By.xpath("//p[contains(text(),'Data Uploaded Successfully!')]");

    By uploadSuccessOk =
            By.xpath("//button[text()='OK']");

    public CSVUploadPage(WebDriver driver) {

        this.driver = driver;
    }

    public void navigateToPowerImport() throws InterruptedException {

        Actions actions =
                new Actions(driver);

        actions.moveToElement(
                driver.findElement(callListMenu))
                .perform();
        
        Thread.sleep(1000);

        driver.findElement(powerImportMenu)
              .click();
    }

    public void enterListName(String name) {

        driver.findElement(listName)
              .sendKeys(name);
    }

    public void selectAllAgents() {
    	
    	driver.findElement(selectAgentsDropDown).click();

        driver.findElement(selectAllAgents)
              .click();
        
        driver.findElement(By.xpath("//label[@for='ddldistributiontype']")).click();
    }
    
    public void uploadCSV(String filePath) {

        driver.findElement(fileUpload)
              .sendKeys(filePath);
    }

    public void clickUpload() {

        driver.findElement(uploadButton)
              .click();
    }

    public void confirmUpload() {

        driver.findElement(confirmOkButton)
              .click();
    }

    public String getUploadSuccessMessage() {

        return driver.findElement(uploadSuccessMessage)
                     .getText();
    }

    public void clickSuccessOk() {

        driver.findElement(uploadSuccessOk)
              .click();
    }
    
    public void mapFields() {

        Select first =
                new Select(
                        driver.findElement(
                                By.id("ddlbelongto_1")));

        first.selectByValue("FirstName");

        Select second =
                new Select(
                        driver.findElement(
                                By.id("ddlbelongto_2")));

        second.selectByValue("Phone");

        Select third =
                new Select(
                        driver.findElement(
                                By.id("ddlbelongto_3")));

        third.selectByValue("Notes");
    }
    
    public void clickImportButton() {

        driver.findElement(importButton)
              .click();
    }
    
    public boolean isListPresent(String listName) {

        return driver.findElement(
                By.xpath("//a[text()='"
                        + listName
                        + "']"))
                .isDisplayed();
    }
}