package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordSentPage {
    private WebDriver driver;
    private By emailSentAlert = By.id("content");

    public PasswordSentPage(WebDriver driver){
        this.driver = driver;
    }

    public String getSentAlertText(){
        return driver.findElement(emailSentAlert).getText();

    }










}
