package pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$x;

public class TextInputPage extends BasePage {

    private SelenideElement inputText = $x("//input[@id='newButtonName']");
    private SelenideElement button = $x("//button[@id='updatingButton']");


    //WebElement element = driver.findElement(By.xpath("//input[@id='newButtonName']"));

    public String setText(String textToType) {
//        driver.findElement(inputText).sendKeys(textToType);
//        driver.findElement(button).click();
        inputText.sendKeys(textToType);
        button.click();
        return textToType;
    }

    public String getTextFromButton() {
//      return driver.findElement(button).getText();
        return button.getText();
    }

}
