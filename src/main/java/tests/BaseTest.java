package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver.exe");
        if (driver == null){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();//через класс manage произходят все манипуляции драйвера
        driver.get(getFromProperties("homeUrl"));
    }

    @AfterClass
    public void tearDawn(){
        driver.quit();//закроется браузер
        //driver.close();//закроет последнию вкладку
    }

    public String getFromProperties(String propertyKey)  {
        Properties props = new Properties();

        try{
            FileInputStream inputStream = new FileInputStream("src/main/resources/application.properties");
            props.load(inputStream);
        }catch (Exception e){
            System.out.println("Не удалось загрузить файл");
        }
        return props.getProperty(propertyKey);
    }
}
