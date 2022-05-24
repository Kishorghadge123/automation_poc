package ui;

import java.io.IOException;
import java.util.Properties;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;
import pages.HomePage;
import utilities.DriverInit;
import utilities.Functions;

@Feature("Login feature")
@Listeners(utilities.ListenerUtils.class)
public class LoginTest extends DriverInit {

	public static WebDriver driver;
	public static Properties test_data;
	
	@BeforeClass (groups="ui")
	@Parameters("environment")
	public void testStartUp(String env) throws IOException {
		System.out.println(env);
		test_data = utilities.InitTestData.getTestData(env);
		driver = DriverInit.driver;
	}
	@Severity(SeverityLevel.CRITICAL)
	@Story("story_id: 001 - successful login test")
	@Description("verify user able to login to OpenKart app with valid credentials")
	@Test (priority=1, groups="smoke", description = "verify successful login test")
	public void successful_Login_Test() throws InterruptedException {
		System.out.println("Inside Login");
		System.out.println(test_data.getProperty("url"));
		Functions.openURL(test_data.getProperty("url"));
		LoginPage loginPage = new LoginPage();
		System.out.println("Before Login");
		loginPage.goToLogin();
		System.out.println("After Login");
		loginPage.enterUsername(test_data.getProperty("username"));
		loginPage.enterPassword(test_data.getProperty("password"));
		System.out.println("Before button click");
		loginPage.clickLoginButton();
		loginPage.enterpin("4567");
		loginPage.clickOnContinue();
		System.out.println("after button click");
		HomePage homePage = new HomePage();

		Functions.waitForElementLoad(HomePage.welcomeText, test_data.getProperty("default_timeout"));
		homePage.welcomeOpenCart();
		Functions.verifyElementDisplayed(HomePage.welcomeText);
		homePage.clickonlogoutbutton();

	}
	@Severity(SeverityLevel.NORMAL)
	@Story("story_id: 002 - invalid login test")
	@Description("verify user not able to login to OpenKart app with invalid credentials")
	@Test (priority=2, groups="smoke", description = "verify unsuccessful login test")
	public void invalid_Login_Test() throws InterruptedException {

		driver.get(test_data.getProperty("url"));


		LoginPage loginPage = new LoginPage();
		loginPage.goToLogin();
		loginPage.enterUsername(test_data.getProperty("username"));
		loginPage.enterPassword("invalid");
		loginPage.clickLoginButton();
		Functions.waitForElementLoad(LoginPage.errorMessage, test_data.getProperty("default_timeout"));
		Functions.verifyElementDisplayed(LoginPage.errorMessage);
	}
	@AfterTest
	public void closeBrowser(){
		System.out.println("Before quit");
		driver.quit();
		System.out.println("After quit");
	}

			}