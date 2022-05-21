package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import utilities.DriverInit;
import utilities.Functions;

import java.io.IOException;
import java.util.Properties;

public class ForgotPassword extends DriverInit {
    public static WebDriver driver;
    public static Properties testdata;

    @Parameters("environment")
    @BeforeClass(groups = "ui")
    public void testStartUp(@Optional("environment") String env) throws IOException {
        testdata = utilities.InitTestData.getTestData(env);
        driver = DriverInit.driver;
    }
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 001 - successful Forgot password")
    @Description("verify user able to set new password")
    @Test(priority = 1, groups = "smoke", description = "verify password updated successfully")
    public void ForgotPasswordDemo() throws InterruptedException {
        Functions.openURL(testdata.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.goToLogin();
        ForgotPasswordPage fg =new ForgotPasswordPage();
        fg.enternewPassword();
        fg.enterEmail();
        fg.clickonsubmit();
    }
}
