package pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
	
	WebDriver driver ;
	
	By laterButton = By.xpath("//button[@class='close']");
    By teamMenu = By.xpath("//span[text()='Team']");
    By agentsMenu = By.xpath("//span[text()='Agents']");
    
    public DashboardPage(WebDriver driver)
    {
    	this.driver=driver;
    }

    //method to close notification pop on login
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
}
