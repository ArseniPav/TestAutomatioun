package org.example.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.example.Listeners.MyTestNgListener;
import org.example.pages.*;
import org.openqa.selenium.OutputType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;


import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

@Listeners(MyTestNgListener.class)
public class BaseTest {

    protected HomePage homePage = new HomePage();
    protected TextInputPage textInputPage = new TextInputPage();
    protected DynamicTablePage dynamicTablePage = new DynamicTablePage();
    protected MouseOverPage mouseOverPage = new MouseOverPage();
    protected FramePage framePage = new FramePage();
    protected AlertsPage alertsPage = new AlertsPage();
    protected UploadPage uploadPage = new UploadPage();


//    private WebDriver setUp() {
//
//        switch (System.getProperty("browser","Chrome")) {
//            case "Chrome":
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//                break;
//            case "Firefox":
//                WebDriverManager.firefoxdriver().setup();
//                driver= new FirefoxDriver();
//                break;
//            default: {
//                System.out.println("Неверное имя браузера");
//            }
//        }
//
//        driver.manage().window().maximize();//через класс manage произходят все манипуляции драйвера
//        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        return driver;
//    }

    public static void takeScreenshot(){
        byte[] bytes = Selenide.screenshot(OutputType.BYTES);
        if(bytes != null){
            Allure.addAttachment("Screen 1", "img/png", new ByteArrayInputStream(bytes), ".img");
        } else {
            System.out.println("Не удалось сделать screenshot");
        }
    }

    @BeforeSuite
    public void setUp() {
        Configuration.browser = System.getProperty("browser", "Chrome");
        Configuration.downloadsFolder = "src/main/resources/downloadDirectory";
        Configuration.fastSetValue = true;
    }

    @BeforeClass
    public void startTest() {
        open(getFromProperties("homeUrl"));
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    public String getFromProperties(String propertyKey) {
        Properties props = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/application.properties");
            props.load(inputStream);
            return props.getProperty(propertyKey);
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл");
        }
        return propertyKey;
    }
}
