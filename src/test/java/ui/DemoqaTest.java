package ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DemoqaPage;
import utilities.DriverInit;
import utilities.Functions;

import java.io.IOException;
import java.util.Properties;

public class DemoqaTest extends DriverInit {
    public static WebDriver driver;
    public static Properties testdata;
    @Parameters("environment")
    @BeforeClass (groups="ui")
    public void testStartUp(String env) throws IOException {
        testdata = utilities.InitTestData.getTestData(env);
        driver = DriverInit.driver;
    }
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 003 -  Account showcase test")
    @Description("verify user able to user able to click on widgets ")
    @Test(priority = '3', groups = "smoke")

    public void select_DemoqaTest() throws InterruptedException {
        Functions.openURL(testdata.getProperty("url"));
        DemoqaPage Page = new DemoqaPage();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        Page.clickWidgets();

        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        Page.clickProgress_Bar();
        Thread.sleep(2000);
        Page.clickStartStopButton();

    }
}
