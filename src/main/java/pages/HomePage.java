package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    String linkPattern = "$x//h3/a[text()='%s']";

    public void getTestDirectory(Links targetLinks){
        driver.findElement(By.xpath(String.format(linkPattern,targetLinks.linkValue))).click();
    }

    public HomePage(WebDriver driver){
        super(driver);//Обращение к методу родителя
    }

    public enum Links{
        TEXT_INPUT("Text Input"),
        DYNAMIC_TABLE("Dynamic Table");

        final String linkValue;

        Links(String s) {
            linkValue = s;
        }
    }
}
