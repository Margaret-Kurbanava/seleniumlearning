package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JSAlertTests extends BaseTests {
    @Test
    public void testingJSAlert(){

        var contextMenuPage = homePage.clickContextMenulink();
        contextMenuPage.rightClickOnHotSpot();
        String text = contextMenuPage.alert_getText();
        assertEquals(text, "You selected a context menu", "Alert text incorrect");
        contextMenuPage.alert_clickToAccept();

    }
}
