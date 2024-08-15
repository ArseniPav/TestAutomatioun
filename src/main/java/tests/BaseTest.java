package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.*;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;


public class BaseTest {

    protected HomePage homePage = new HomePage();
    protected TextInputPage textInputPage = new TextInputPage();
    protected DynamicTablePage dynamicTablePage = new DynamicTablePage();
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
        } catch (Exception e) {
            System.out.println("Не удалось загрузить файл");
        }
        return props.getProperty(propertyKey);
    }
}
