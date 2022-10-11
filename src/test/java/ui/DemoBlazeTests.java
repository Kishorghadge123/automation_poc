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
    @Parameters("browser")
    @BeforeClass
    public void testStart(String browser){
        driver = DriverInit.getBrowser(browser);
        objExcelUtils = new ExcelUtils();
        driver.get("https://www.demoblaze.com/index.html");
        //driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void initializePages(){
        //driver = DriverInit.driver;
        objHomePage = new HomePage();
        objLoginPage = new LoginPage();
        //driver.get("https://www.demoblaze.com/index.html");
    }
    @Test(dataProvider = "testDataProvider")
    public void loginTest(Map<Object, Object> dataMap){
        //Map<String,Object> map = (HashMap<String,Object>) dataMap;
        objHomePage.clickLogInButton();
        objLoginPage.enterUserName((String) dataMap.get("UserName"));
        objLoginPage.enterPassword((String) dataMap.get("Password"));
        objLoginPage.clickLoginButton();
        System.out.println(objHomePage.getUserLoginLabel());
        System.out.println(objHomePage.getUserLoginLabel().split(" ")[1]+" | "+(String) dataMap.get("UserName"));
        Assert.assertEquals(objHomePage.getUserLoginLabel().split(" ")[1],(String) dataMap.get("UserName"));
        objHomePage.clickLogOutButton();
        Assert.assertEquals(objHomePage.getSignUpLabel(),"Sign up");
    }

/*    @Test(dependsOnMethods = {"loginTest"})
    public void logoutTest(){

    }*/

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
    @DataProvider(name = "testDataProvider")
    public Object[][] testDataProvider() throws IOException, InvalidFormatException {
        return objExcelUtils.getExcelData();
    }
}
