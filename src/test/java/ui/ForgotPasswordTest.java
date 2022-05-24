package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import utilities.DriverInit;
import utilities.Functions;

import java.io.IOException;
import java.util.Properties;

import static db.EmployeeValidation.ForgotPasswordPage.forgotpassword;


public class ForgotPasswordTest extends DriverInit{
    public static WebDriver driver;
    public static Properties testdata;
    @Parameters("environment")
    @BeforeClass(groups = "ui")
    public void testStartUp(@Optional("environment") String env) throws IOException {
        testdata = utilities.InitTestData.getTestData(env);
        driver = DriverInit.driver;
    }
    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }
    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 001 - successful Forgot password")
    @Description("verify user able to set new password")
    @Test (priority = 1, groups = "smoke", description = "verify password updated successfully")
    public void ForgotPasswordDemo() throws InterruptedException {
//        SoftAssert softAssert = new SoftAssert();
        Functions.openURL(testdata.getProperty("url"));
        String actualurl=driver.getCurrentUrl();
        System.out.println(actualurl);
        String expected_url="https://www.opencart.com/";
        Assert.assertEquals(actualurl,expected_url,"url mismatch");
        LoginPage loginPage = new LoginPage();
        loginPage.goToLogin();
        ForgotPasswordPage fg =new ForgotPasswordPage();
        Functions.verifyText(ForgotPasswordPage.forgotpassword,"Forgot your password?");
        fg.clickForgotPasswordLink();
        fg.enterEmail("abc@gmail.com");
        fg.clickonsubmit();

       String successmsg=driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();

       System.out.println(successmsg);
      Assert.assertEquals(successmsg,"Success: An email with a reset link has been sent your email address!\n" +
              "×");


    }
}
