package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import java.time.LocalDate;

public class AlertTest extends BaseTest {
    @Test
    public void alertTest() {
        homePage.getTestDirectory(HomePage.Links.ALERTS);

        alertsPage.clickAlert();
        driver.switchTo().alert().accept();

        int day = LocalDate.now().getDayOfWeek().getValue();

        alertsPage.clickConfirm();
        if (day == 5) {
            driver.switchTo().alert().accept();// подтвердить
        } else {
            driver.switchTo().alert().dismiss();// отменить
            driver.switchTo().alert().accept();
        }

        String textToType = "test";
        String expected = "User value: %s";

        alertsPage.clickPromt();
        driver.switchTo().alert().sendKeys(textToType);
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        driver.switchTo().alert();
    }
}
