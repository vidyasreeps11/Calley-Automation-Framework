package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AgentPage {

    WebDriver driver;
    
    By laterButton = By.id("onesignal-slidedown-cancel-button");

    By teamMenu = By.xpath("//span[text()='Team']");
    By agentsMenu = By.xpath("//span[text()='Agents']");

    By agentName = By.xpath("//input[@placeholder='Enter name']");
    By agentMobile = By.xpath("//input[@placeholder='Enter mobile no.']");
    By agentEmail = By.xpath("//input[@placeholder='Enter email']");
    By agentPassword = By.xpath("//input[@placeholder='Enter password']");

    By submitButton = By.id("ContentPlaceHolder1_btn_submit");

    By successMessage =
            By.xpath("//p[text()='Agent Added Successfully!']");

    By okButton =
            By.xpath("//button[text()='OK']");

    public AgentPage(WebDriver driver) {

        this.driver = driver;
    }

    public void closeNotificationPopup() {

        try {

            driver.findElement(laterButton).click();

        } catch (Exception e) {

            System.out.println(
                "Notification popup not displayed");
        }
    }
    
    public void navigateToAgents() throws InterruptedException {

    	WebElement team =
                driver.findElement(teamMenu);

        Actions actions =
                new Actions(driver);

        actions.moveToElement(team)
               .perform();

        Thread.sleep(1000);

        driver.findElement(agentsMenu)
              .click();
    }

    public void enterAgentName(String name) {

        driver.findElement(agentName).sendKeys(name);
    }

    public void enterAgentMobile(String mobile) {

        driver.findElement(agentMobile).sendKeys(mobile);
    }

    public void enterAgentEmail(String email) {

        driver.findElement(agentEmail).sendKeys(email);
    }

    public void enterAgentPassword(String password) {

        driver.findElement(agentPassword).sendKeys(password);
    }

    public void clickSubmit() {

        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {

        return driver.findElement(successMessage).getText();
    }

    public void clickOK() {

        driver.findElement(okButton).click();
    }
}