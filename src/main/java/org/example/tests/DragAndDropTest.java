package org.example.tests;

import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTest extends BaseTest{


@Test
    public void dragTest(){
        Selenide.switchTo().newWindow(WindowType.TAB);
        open("https://practice.expandtesting.com/drag-and-drop");

        SelenideElement a = $x("//div[@id = 'column-a']");
        SelenideElement b = $x("//div[@id = 'column-b']");

        SelenideElement aHeader = $x("//div[@id = 'column-a']/header");
        SelenideElement bHeader = $x("//div[@id = 'column-b']/header");

        String actualValue = aHeader.getText();
//        a.dragAndDrop(DragAndDropOptions.to(b));
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.clickAndHold().moveByOffset(200,0).release().perform();

        System.out.println("Test");
    }
}
