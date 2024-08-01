package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.AlertTest;
import tests.BaseTest;

public class AlertsPage extends BasePage {
    private final By alertBtn = By.xpath("//button[@id='alertButton']");
    private final By alertConfirm = By.xpath("//button[@id='confirmButton']");
    private final By alertPromt = By.xpath("//button[@id='promtButton']");

    public void clickAlert(){
        driver.findElement(alertBtn).click();
    }
    public void clickConfirm(){
        driver.findElement(alertConfirm).click();
    }
    public void clickPromt(){
        driver.findElement(alertPromt).click();
    }

     public AlertsPage(WebDriver driver){
        super(driver);
     }

}
