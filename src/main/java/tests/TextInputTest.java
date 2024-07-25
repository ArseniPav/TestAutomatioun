package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TextInputPage;

public class TextInputTest extends BaseTest{


    HomePage homePage ;
    TextInputPage textInputPage ;

    @BeforeMethod
    public void CreatePage(){
         homePage = new HomePage(driver);
         textInputPage = new TextInputPage(driver);
    }

    @Test
    public void textInputTest(){
        homePage.getTestDirectory(HomePage.Links.TEXT_INPUT);
        String startButtonValue = textInputPage.getTextFromButton();

        String expectedText = textInputPage.setText("HelloWorld");
        String actualText = textInputPage.getTextFromButton();

        Assert.assertEquals(expectedText,actualText);
        Assert.assertNotEquals(actualText, startButtonValue);
    }

}
