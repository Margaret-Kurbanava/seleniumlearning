package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String leftFrameName = "frame-left";
    private String bottomFrameName = "frame-bottom";
    private By textBody = By.cssSelector("body");

    public NestedFramesPage(WebDriver driver){ this.driver= driver;}

    private void switchToFrameArea(String frameName) {

        driver.switchTo().frame(frameName);

    }

    public void switchtoLeftFrame(){
        driver.switchTo().frame("frame-top");
        switchToFrameArea(leftFrameName);
    }

    public void switchtoBotttomFrame(){
        switchToFrameArea(bottomFrameName);
    }


    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    public String getFrameText(){

        return driver.findElement(textBody).getText();
    }


}
