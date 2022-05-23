package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverInit;
import utilities.Functions;

public class LoginPage {
	static WebDriver driver= DriverInit.driver;

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//a[text()='Login' and @class="btn btn-link navbar-btn"]

	@FindBy (xpath="//a[text()='Login' and @class=\"btn btn-link navbar-btn\"]")
	public static WebElement loginButton;

	@FindBy (xpath="//input[@id='input-email']")
	public static WebElement username1;
	
	@FindBy (xpath="//input[@id='input-password']")
	public static WebElement Password;
	@FindBy (xpath="//button[text()='Login']")
	public static WebElement LoginButton;
	@FindBy (xpath="//div[contains(text(),\"No match for E-Mail and/or Password.\")]")
	public static WebElement errorMessage;
	@FindBy (xpath="//input[@id='input-pin']")
	public static WebElement pinTab;
	@FindBy (xpath="//button[@class='btn btn-primary btn-lg']")
	public static WebElement continueButton;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	public static WebElement errorPinMsg;
	@Step("go to Login page")
	public void goToLogin(){
		Functions.drowborder(loginButton);
		this.loginButton.click();

	}
	@Step("enter username {0}")
	public void enterUsername(String username){
		Functions.drowborder(username1);
		this.username1.sendKeys(username);
	}
	@Step("enter password {0}")
	public void enterPassword(String password){
		Functions.drowborder(Password);
		this.Password.sendKeys(password);
	}
	@Step("click login button")
	public void clickLoginButton(){
		Functions.drowborder(LoginButton);
		this.LoginButton.click();
	}
	@Step("enter pin")
			public void enterPin(String pin){
		Functions.drowborder(pinTab);
		Functions. waitForElementClickable(pinTab,"1000");
		this.pinTab.sendKeys(pin);
			}
	@Step("click on continue")
			public void clickContinueButton()
	{
		Functions.drowborder(continueButton);
		Functions.waitForElementLoad(continueButton,"10");
		this.continueButton.click();
	}
	@Step("pin limit exceeded")
	public String pinLimitExceeded(){
    return this.errorPinMsg.getText();
	}
}
