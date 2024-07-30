package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends BasePage{

    public By frameInput = By.xpath("//input[@name='mytext1']");
    public By frame2Input = By.xpath("//input[@name='mytext2']");
    public By frame3Input = By.xpath("//input[@name='mytext3']");
    public By frame4Input = By.xpath("//input[@name='mytext4']");
    public By frame5Input = By.xpath("//input[@name='mytext5']");

    public void getFromByIndex(int frameIndex){
        driver.switchTo().frame(frameIndex);
    }


    public FramePage(WebDriver driver) {
        super(driver);
    }
}
