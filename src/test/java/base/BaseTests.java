package base;

import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

import java.util.List;

public class BaseTests {
    private EventFiringWebDriver driver;
    protected static Eyes eyes;
    protected HomePage homePage;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe"); //fist part- just copy as is, second part- specify path to chromedriver

        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());


        goHome();
        //setCookie();
       // deleteCookie();


        //open the page
        //driver.get("https://the-internet.herokuapp.com/");

        //maximize window
         driver.manage().window().maximize();

        //full screen
        //driver.manage().window().fullscreen();

        //3 - Specific size (e.g. show Chrome iPhoneX emulator)
        //Dimension size = new Dimension(375, 812);
        //driver.manage().window().setSize(size);

        //get the title of application and print to console
        //System.out.println(driver.getTitle());

        //findElements - find multiple elements, e.g. find all links and count how many links are on the page
        //List<WebElement> links= driver.findElements(By.tagName("a"));
        //System.out.println(links.size());

        //findElement- find an element,  store it to a variable, click
        //WebElement inputsLink =driver.findElement(By.linkText("Inputs"));
        //inputsLink.click();

       // homePage = new HomePage(driver);

       //close browser
        //driver.quit();

    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);


    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }



    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }


    //screenshot after every test
   /* @AfterMethod
    public void takeScreenshot(){

        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        try{
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }*/


    //screenshot after failed tests
    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }

private ChromeOptions getChromeOptions(){
ChromeOptions options = new ChromeOptions();
    options.addArguments("disable-infobars");
    //options.setHeadless(true);

    return options;

}

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }


private void deleteCookie(){
    Cookie cookie1 = new Cookie.Builder("optimizelyBuckets", "%7B%7D")
            .domain("the-internet.herokuapp.com")
            .build();

        driver.manage().deleteCookie(cookie1);

}


private static void initiateEyes(){
        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }



}
