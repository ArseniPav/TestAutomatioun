package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

public class UploadFileTest extends BaseTest {

    @Test
    public void uploadTest() {
        homePage.getTestDirectory(HomePage.Links.UPLOAD);
        uploadPage.uploadByClassic();
        System.out.println("Test");
    }

    @Test
    public void uploadSelenide() {
        List<String> expected = List.of("upload.txt");

        homePage.getTestDirectory(HomePage.Links.UPLOAD);
        uploadPage.uploadSelenide();
        System.out.println("Test");

        Assert.assertTrue(uploadPage.isFileUploaded(expected));
    }
}
