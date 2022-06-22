package ui;
import io.qameta.allure.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverInit;
import utilities.Functions;
import java.io.IOException;
import java.util.Properties;
@Feature("Account feature")
public class AccountTest extends DriverInit
{
    static Properties testdata;
    @Parameters("environment")
    @BeforeClass(groups="ui")
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
    @Description("verify user able to user able to created Account ")
    @Test(priority='3',groups="smoke")
    public void Account_Test() throws InterruptedException {

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
    public void logoutTest(){
        HomePage homePage=new HomePage();
        homePage.clickLogout();
    }
}
