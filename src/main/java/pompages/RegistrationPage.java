package pompages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    WebDriver driver;

    By name = By.id("txtName");
    By email = By.id("txtEmail");
    By phone = By.id("txt_mobile");
    By password = By.id("txtPassword");
    By termsCheckbox = By.id("checkbox-signup");
    By registerButton = By.id("btnSignUp");

    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterName(String userName) {

        driver.findElement(name).sendKeys(userName);
    }

    public void enterEmail(String userEmail) {

        driver.findElement(email).sendKeys(userEmail);
    }

    public void enterPhone(String userPhone) {

        driver.findElement(phone).sendKeys(userPhone);
    }

    public void enterPassword(String userPassword) {

        driver.findElement(password).sendKeys(userPassword);
    }

    public void clickTermsCheckbox() {
    	
    	WebElement checkbox=driver.findElement(By.id("checkbox-signup"));
    	JavascriptExecutor js=(JavascriptExecutor)driver;

    	js.executeScript("arguments[0].click();", checkbox);
    	
       // driver.findElement(termsCheckbox).click();
    	
    	//System.out.println( checkbox.isSelected());
    }

    public void clickRegister() {

        driver.findElement(registerButton).click();
    }
}