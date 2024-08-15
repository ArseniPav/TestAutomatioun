package org.example.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage{

    String linkPattern = "//h3/a[text()='%s']";

    @Step("Переход по ссылке {targetLinks}")
    public void getTestDirectory(Links targetLinks){
       $x(String.format(linkPattern,targetLinks.linkValue)).click();
    }

    public enum Links{
        TEXT_INPUT("Text Input"),
        DYNAMIC_TABLE("Dynamic Table"),
        MOUSE_OVER("Mouse Over"),
        ALERTS("Alerts"),
        UPLOAD("File Uploads");

        final String linkValue;

        Links(String s) {
            linkValue = s;
        }
    }
}
