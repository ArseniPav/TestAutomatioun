package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class DynamicTableTest extends BaseTest{

    @Test
    public void tableTest(){
        homePage.getTestDirectory(HomePage.Links.DYNAMIC_TABLE);

//        String expectedCpu = dynamicTablePage.getExpectedValue();
//        String tableValue = dynamicTablePage.getTableValue();

//        Assert.assertEquals(expectedCpu,tableValue);
    }
}
