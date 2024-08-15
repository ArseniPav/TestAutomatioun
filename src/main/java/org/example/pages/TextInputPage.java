package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Data;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class TextInputPage extends BasePage {

    private SelenideElement inputText = $x("//input[@id='newButtonName']");
    private SelenideElement button = $x("//button[@id='updatingButton']");


    @Step("Изменение текста кнопки на {textToType}")
    public String setText(String textToType) {
//        driver.findElement(inputText).sendKeys(textToType);
//        driver.findElement(button).click();
        inputText.sendKeys(textToType);
        button.click();
        return textToType;
    }

    @Step("Получение текста с кнопки")
    public String getTextFromButton() {
        return button.getText();
    }
}
