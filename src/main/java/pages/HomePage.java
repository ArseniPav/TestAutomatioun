package pages;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage{

    String linkPattern = "$x//h3/a[text()='%s']";

    public void getTestDirectory(Links targetLinks){
       $x(String.format(linkPattern,targetLinks.linkValue)).click();
    }

    public enum Links{
        TEXT_INPUT("Text Input"),
        DYNAMIC_TABLE("Dynamic Table"),
        ALERTS("Alerts"),
        UPLOAD("File Uploads");

        final String linkValue;

        Links(String s) {
            linkValue = s;
        }
    }
}
