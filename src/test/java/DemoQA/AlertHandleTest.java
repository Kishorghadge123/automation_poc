package DemoQA;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Custome_Wait;
import utilities.DriverInit;
import utilities.Functions;

import java.io.IOException;
import java.util.Properties;

import static DemoQA.AlertHandlePage.Alerts;
import static DemoQA.AlertHandlePage.Click_me;

public class AlertHandleTest extends DriverInit{
    public static WebDriver driver;
    public static Properties testdata;


    @Parameters("environment")
    @BeforeClass(groups="ui")
    public void testStartUp(String env) throws IOException {
        testdata = utilities.InitTestData.getTestData(env);
        driver = DriverInit.driver;
    }
    @AfterTest
    public void closeBrowser()
    {
      driver.quit();
    }
    @Severity(SeverityLevel.BLOCKER)
    @Story("story_id: 001 - successful Alert Handled test")
    @Description("verify user able to Handle Alert in DemoQA app")
    @Test(priority=1, groups="smoke", description = "verify successful AlertHandle test")
    public void successful_AlertHandle_Test() throws InterruptedException {
        Functions.openURL("https://demoqa.com/alertsWindows");
        AlertHandlePage alertHandlePage=new AlertHandlePage();
        alertHandlePage.selectAlert_Frame_Windows();
        alertHandlePage.scrollupdown();
        Functions.waitForElementClickable(Alerts,"5");
        alertHandlePage.Alerts();
        System.out.println("clik on alert");
        alertHandlePage.Click_me();
        System.out.println("click on me");
        Functions.fluentwait();
        alertHandlePage.GetText();
        Functions.fluentwait();
        alertHandlePage.accept_alert();
    }
}
