package slider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTests {

    int n = 8;

    @Test
    public void testSlider(){
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveSlider(n);

        int expected = n/2;
        String expectedRange = Integer.toString(expected);

        assertEquals(horizontalSliderPage.getRange(), expectedRange, "Slider move problem");



    }
}
