package ui;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import utilities.DriverInit;
import utilities.Functions;

import java.io.IOException;
import java.util.Properties;

public class AccountTest extends DriverInit{
public static WebDriver driver;
    public static Properties test_data;
    @BeforeClass(groups="ui")
    @Parameters("environment")
    public void testStartUp(String env) throws IOException {
        test_data = utilities.InitTestData.getTestData(env);
        driver = DriverInit.driver;
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 003 -  Account showcase test")
    @Description("verify user able to create Account ")
    @Test(priority='3',groups="smoke")
    public void successful_Account_Test() throws InterruptedException {
        Functions.openURL(test_data.getProperty("url"));
        AccountPage accountPage=new AccountPage();
        accountPage.clickAccount();
        accountPage.clickShowCart();
        accountPage.clickAddProject();
        accountPage.enterShowCaseName("abc");
        accountPage.selectShowCaseCategory("2");
        accountPage.selectDate("10","Feb","2023");
        accountPage.enterWebsite("xyz");
        accountPage.clickSubmitButton();
    }
    @Severity(SeverityLevel.CRITICAL)
    @Story("story_id: 004 - logout")
    @Description("verify user able to logout ")
    @Test(priority='4',groups="smoke")
    public void logoutButton() {
        HomePage homePage = new HomePage();
        homePage.clickonlogoutbutton();

    }
}