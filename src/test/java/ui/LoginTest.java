package ui;

import java.io.IOException;
import java.util.Properties;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import org.testng.asserts.SoftAssert;
import pages.AccountPage;
import pages.LoginPage;
import pages.HomePage;
import utilities.DriverInit;
import utilities.Functions;

@Feature("Login feature")
@Listeners(utilities.ListenerUtils.class)
public class LoginTest extends DriverInit {
	public static WebDriver driver;
	public static Properties testdata;
	@Parameters("environment")
	@BeforeClass (groups="ui")
	public void testStartUp(String env) throws IOException {
		testdata = utilities.InitTestData.getTestData(env);
		driver = DriverInit.driver;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	@Severity(SeverityLevel.CRITICAL)
	@Story("story_id: 001 - successful login test")
	@Description("verify user able to login to OpenKart app with valid credentials")
	@Test (priority=1, groups="smoke", description = "verify successful login test")
	public void successful_Login_Test() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
		Functions.openURL(testdata.getProperty("url"));
		String title=driver.getTitle();
		Functions.logStep("verifyed Title");
		softAssert.assertEquals(title,"OpenCart - Open Source Shopping Cart Solution","Title mismatch");
		LoginPage loginPage = new LoginPage();
		String actualcurrenturl=driver.getCurrentUrl();
		String expectedurl="https://www.opencart.com/";
		Functions.logStep("verify URL");
		softAssert.assertEquals(actualcurrenturl,expectedurl,"Url is not matched");
		loginPage.goToLogin();
		loginPage.enterUsername(testdata.getProperty("username"));
		loginPage.enterPassword(testdata.getProperty("password"));
		loginPage.clickLoginButton();
		loginPage.enterPin(testdata.getProperty("pin"));
		loginPage.clickContinueButton();
//     	Functions.verifyText(loginPage.errorPinMsg,"You have exceeded the allowed number of PIN attempts! Please use the Reset PIN button or contact us page to request your account to be unlocked.");
		HomePage homePage = new HomePage();
		homePage.welecomeOpenCart();
		Functions.waitForElementLoad(HomePage.welcomeText,testdata.getProperty("default_timeout"));
		Functions.logStep("verifyed welcomeText");
		Functions.verifyElementDisplayed(HomePage.welcomeText);
		softAssert.assertAll();
	}
	@Severity(SeverityLevel.NORMAL)
	@Story("story_id: 002 - invalid login test")
	@Description("verify user not able to login to OpenKart app with invalid credentials")
	@Test (priority=2, groups="smoke", description = "verify unsuccessful login test")
	public void invalid_Login_Test() throws InterruptedException {
		driver.get(testdata.getProperty("url"));
		LoginPage loginPage = new LoginPage();
		loginPage.goToLogin();
		loginPage.enterUsername(testdata.getProperty("username"));
		loginPage.enterPassword("invalid");
		loginPage.clickLoginButton();
		Functions.waitForElementLoad(loginPage.errorMessage, testdata.getProperty("default_timeout"));
		Functions.verifyElementDisplayed(loginPage.errorMessage);
	}

}


