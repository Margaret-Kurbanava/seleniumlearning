package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By EmailField = By.id("email");
    private By RetrievePasswordButton = By.id("form_submit");


    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

  /*  public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }*/

    public void setEmail(String email){
        driver.findElement(EmailField).sendKeys(email);
    }

    public PasswordSentPage ClickRetrievePasswordButton(){
        driver.findElement(RetrievePasswordButton).click();
        return new PasswordSentPage(driver);
    }





}
