package tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.LocalDate;

public class AlertTest extends BaseTest {
    @Test
    public void alertTest() {
        homePage.getTestDirectory(HomePage.Links.ALERTS);

        alertsPage.clickAlert();
        Selenide.switchTo().alert().accept();

        int day = LocalDate.now().getDayOfWeek().getValue();

        alertsPage.clickConfirm();
        if (day == 5) {
            Selenide.switchTo().alert().accept();// подтвердить
        } else {
            Selenide.switchTo().alert().dismiss();// отменить
            Selenide.switchTo().alert().accept();
        }

        String textToType = "test";
        String expected = "User value: %s";

        alertsPage.clickPromt();
        Selenide.switchTo().alert().sendKeys(textToType);
        Selenide.switchTo().alert().accept();
        Selenide.switchTo().alert().accept();
        Selenide.switchTo().alert();
    }
}
