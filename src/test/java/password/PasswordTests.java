package password;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.PasswordSentPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class PasswordTests extends BaseTests {

    @Test
    public void testForgotPassword(){
      /*  LoginPage loginPage = homePage.clickFormAuthenticationLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        System.out.println(secureAreaPage.getAlertText());
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");*/


        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.setEmail("test@123.ru");
        PasswordSentPage passwordSentPage = forgotPasswordPage.ClickRetrievePasswordButton();
        assertTrue(passwordSentPage.getSentAlertText()
                .contains("Your e-mail's been sent!"),
                "Alert text is incorrect");


    }


}
