package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected HomePage homePage = new HomePage(setUp());
    protected TextInputPage textInputPage = new TextInputPage(setUp());
    protected DynamicTablePage dynamicTablePage = new DynamicTablePage(setUp());
    protected FramePage framePage = new FramePage(setUp());
    protected AlertsPage alertsPage = new AlertsPage(setUp());

    protected WebDriver driver;

    private WebDriver setUp() {
        WebDriverManager.chromedriver().setup();

        if (driver == null) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();//через класс manage произходят все манипуляции драйвера
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    @BeforeClass
    public void startTest() {
        driver.get(getFromProperties("homeUrl"));
    }


    @AfterClass
    public void tearDawn() {
        driver.quit();//закроется браузер
        //driver.close();//закроет последнию вкладку
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
