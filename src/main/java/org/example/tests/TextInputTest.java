package org.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.HomePage;

public class TextInputTest extends BaseTest {



    @Test(description = "Тестирование поля ввода")
    public void textInputTest() {
//        takeScreenshot();
        homePage.getTestDirectory(HomePage.Links.TEXT_INPUT);
//        takeScreenshot();
        String startButtonValue = textInputPage.getTextFromButton();

        String expectedText = textInputPage.setText("HelloWorld");
//        takeScreenshot();
        String actualText = textInputPage.getTextFromButton();

        Assert.assertEquals(expectedText, actualText);
        Assert.assertNotEquals(actualText, startButtonValue);
    }


}
