package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class UploadPage extends BasePage {
    SelenideElement inputFile = $x("//input[@type='file']");
    ElementsCollection uploadedFiles =$$x("//div[@class='file-info']/p");

    public void uploadByClassic() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        Selenide.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\SanchoArs\\IdeaProjects\\ArseniTestAutomation\\src\\main\\resources\\toUpload\\upload.txt");
        Selenide.switchTo().defaultContent();
    }

    public void uploadSelenide() {
        File fileToUpload = new File("src/main/resources/toUpload/upload.txt");
        Selenide.switchTo().frame(0);
        inputFile.uploadFile(fileToUpload);
        Selenide.switchTo().defaultContent();
    }

    public boolean isFileUploaded(List<String> fileNames){
        Selenide.switchTo().frame(0);
        if (uploadedFiles.isEmpty()){
            return false;
        } else {
            List<String> actualNames = new ArrayList<>();
            uploadedFiles.forEach(file -> actualNames.add(file.getText()));
            Selenide.switchTo().defaultContent();
            return fileNames.containsAll(actualNames);
        }
    }
}
