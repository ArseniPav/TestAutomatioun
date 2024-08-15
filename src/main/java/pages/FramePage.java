package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class FramePage extends BasePage {

    public SelenideElement frameInput = $x("//input[@name='mytext1']");
    public SelenideElement frame2Input = $x("//input[@name='mytext2']");
    public SelenideElement frame3Input = $x("//input[@name='mytext3']");
    public SelenideElement frame4Input = $x("//input[@name='mytext4']");
    public SelenideElement frame5Input = $x("//input[@name='mytext5']");

    public void getFromByIndex(int frameIndex) {
        Selenide.switchTo().frame(frameIndex);
    }
}
