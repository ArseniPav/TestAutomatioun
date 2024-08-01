package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicTablePage extends BasePage {

    By expectedValue = By.xpath("//div[@class='container']/p[@class='bg-warning']");
    By columnHeaders = By.xpath("//span[@role='columnheader']");
    By chromeRow = By.xpath("//span[@role='cell' and text()='Chrome']/following-sibling::span");


    public String getExpectedValue() {
        String expectedTense = driver.findElement(expectedValue).getText();
        //return expectedTense.split(": ")[1];
        return expectedTense.substring(12);
    }

    private int getCpuIndex() {
        List<WebElement> headers = driver.findElements(columnHeaders);
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equals("CPU")) {
                return i;
            }
        }
        return 0;
    }

    public String getTableValue() {
        return driver.findElements(chromeRow).get(getCpuIndex() - 1).getText();
    }

    public DynamicTablePage(WebDriver driver) {
        super(driver);
    }
}
