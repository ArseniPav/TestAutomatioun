//package tests;
//
//import com.codeborne.selenide.Selenide;
//import com.codeborne.selenide.WebDriverRunner;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
//import org.testng.annotations.Test;
//
//import java.util.Set;
//
//public class FramesTest extends BaseTest {
//
//
//    @Test
//    public void frameTest() {
//        Selenide.switchTo().newWindow(WindowType.TAB);
//        WebDriverRunner.getWebDriver().get(getFromProperties(("frameUrl")));
//        //Selenide.open(getFromProperties("frameUrl"));
////        String uiVisionHandle = driver.getWindowHandle();
////        Set<String> windowHandles = driver.getWindowHandles();
////        driver.switchTo().window(windowHandles.toArray()[0].toString());
////        String playGroundHandle = driver.getWindowHandle();
//
//        Selenide.switchTo().frame(0).findElement(framePage.frameInput).sendKeys("Это фрейм 1");
//        Selenide.switchTo().defaultContent();
//        Selenide.switchTo().frame(1).findElement(framePage.frame2Input).sendKeys("Это фрейм 2");
//        Selenide.switchTo().defaultContent();
//        Selenide.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_3.html']")));
//        Selenide.findElement(framePage.frame3Input).sendKeys("Это фрейм 3");
//        Selenide.switchTo().defaultContent();
//        Selenide.switchTo().frame(3).findElement(framePage.frame4Input).sendKeys("Это фрейм 4");
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame(4).findElement(framePage.frame5Input).sendKeys("Это фрейм 5");
//
//
//        System.out.println("Test");
//    }
//}
