package ui;

import java.io.IOException;
import java.util.Properties;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.LoginPage;
import pages.HomePage;
import utilities.DriverInit;
import utilities.Functions;

@Feature("Login feature")
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
	public void closeBrowser(){
		driver.close();
	}


	@Story("story_id: 001 - successful login")
	@Description("verify successful login to OpenKart app")
	@Test (priority=1, groups="smoke",description = "verify successful login to OpenKart app")
	public void successful_Login_Test(){
	try{
		driver.get(testdata.getProperty("url"));
		LoginPage loginPage = new LoginPage();
		loginPage.goToLogin();
		loginPage.enterUsername(testdata.getProperty("username"));
		loginPage.enterPassword(testdata.getProperty("password"));
		loginPage.clickLoginButton();
		HomePage homePage = new HomePage();
		Functions.waitForElementLoad(HomePage.welcomeText,testdata.getProperty("default_timeout"));
		Functions.verifyElementDisplayed(HomePage.welcomeText);
	}
	catch(Exception e){
	e.printStackTrace();
	Assert.fail("Test case failed!");
	}
}
	

	@Test (priority=2, groups="smoke")
	public void invalid_Login_Test(){
		try{
			driver.get(testdata.getProperty("url"));
			LoginPage loginPage = new LoginPage();
			loginPage.goToLogin();
			loginPage.enterUsername(testdata.getProperty("username"));
			loginPage.enterPassword("invalid");
			loginPage.clickLoginButton();

			Functions.waitForElementLoad(loginPage.errorMessage,testdata.getProperty("default_timeout"));
			Functions.verifyElementDisplayed(loginPage.errorMessage);
		}
		catch(Exception e){
			e.printStackTrace();
			Assert.fail("Test case failed!");
		}
	}
}


