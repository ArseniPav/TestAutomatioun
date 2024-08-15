package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicTablePage extends BasePage {

    SelenideElement expectedValue = $x("//p[@class='bg-warning']");
    ElementsCollection columnHeaders = $$x("//span[@role='columnheader']");
    ElementsCollection chromeRow = $$x("//div//span[text()='Chrome']/following-sibling::span");


    public String getExpectedValue() {
        String expectedTense = expectedValue.getText();
        return expectedTense.substring(12);
    }

    private int getCpuIndex() {
        ElementsCollection headers = columnHeaders;
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equals("CPU")) {
                return i;
            }
        }
        return 0;
    }

    public String getTableValue() {
        return chromeRow.get(getCpuIndex() - 1).getText();
    }

}
