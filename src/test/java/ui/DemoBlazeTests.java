package ui;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DemoBlaze.HomePage;
import pages.DemoBlaze.LoginPage;
import utilities.DriverInit;
import utilities.ExcelUtils;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.util.Map;

public class DemoBlazeTests {

    WebDriver driver;
    HomePage objHomePage;
    LoginPage objLoginPage;
    ExcelUtils objExcelUtils;
    @BeforeClass
    public void testStart(){
        driver = DriverInit.driver;
        objExcelUtils = new ExcelUtils();
        //driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void initializePages(){
        objHomePage = new HomePage();
        objLoginPage = new LoginPage();
        //driver.get("https://www.demoblaze.com/index.html");
    }
    @Test(dataProvider = "testDataProvider")
    public void loginTest(Map<Object, Object> dataMap){
        driver.get("https://www.demoblaze.com/index.html");
        //Map<String,Object> map = (HashMap<String,Object>) dataMap;
        objHomePage.clickLogInButton();
        objLoginPage.enterUserName((String) dataMap.get("UserName"));
        objLoginPage.enterPassword((String) dataMap.get("Password"));
        objLoginPage.clickLoginButton();
        System.out.println(objHomePage.getUserLoginLabel());
        System.out.println(objHomePage.getUserLoginLabel().split(" ")[1]+" | "+(String) dataMap.get("UserName"));
        Assert.assertEquals(objHomePage.getUserLoginLabel().split(" ")[1],(String) dataMap.get("UserName"));
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void logoutTest(){
        objHomePage.clickLogOutButton();
        Assert.assertEquals(objHomePage.getSignUpLabel(),"Sign up");
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() throws IOException, InvalidFormatException {
        return objExcelUtils.getExcelData();
    }
}
