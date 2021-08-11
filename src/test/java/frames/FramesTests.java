package frames;

import base.BaseTests;
import org.testng.annotations.Test;

public class FramesTests extends BaseTests {
    @Test
    public void testFrames(){

    var framesPage = homePage.clickFramesLink();
     var nestedFrames = framesPage.clickNestedFrames();

     nestedFrames.switchtoLeftFrame();


        System.out.println(nestedFrames.getFrameText());

        nestedFrames.switchToMainArea();
        nestedFrames.switchToMainArea();
        nestedFrames.switchtoBotttomFrame();
        System.out.println(nestedFrames.getFrameText());
        nestedFrames.switchToMainArea();




    }
}
