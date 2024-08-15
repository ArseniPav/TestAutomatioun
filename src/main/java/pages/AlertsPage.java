package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AlertsPage extends BasePage {

    SelenideElement alertBtn = $x("\"//button[@id='alertButton']\"");
    SelenideElement alertConfirm = $x("//button[@id='confirmButton']");
    SelenideElement alertPromt = $x("//button[@id='promtButton']");


    public void clickAlert(){
        alertBtn.click();
    }
    public void clickConfirm(){
        alertConfirm.click();
    }
    public void clickPromt(){
        alertPromt.click();
    }

}
