package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TextInputPage;

public class TextInputTest extends BaseTest {



    @Test
    public void textInputTest() {
        driver.get(getFromProperties("homeUrl"));
        homePage.getTestDirectory(HomePage.Links.TEXT_INPUT);
        String startButtonValue = textInputPage.getTextFromButton();

        String expectedText = textInputPage.setText("HelloWorld");
        String actualText = textInputPage.getTextFromButton();

        Assert.assertEquals(expectedText, actualText);
        Assert.assertNotEquals(actualText, startButtonValue);
    }

}
