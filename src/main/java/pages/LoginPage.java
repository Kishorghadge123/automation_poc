package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverInit;

public class LoginPage {
	static WebDriver driver= DriverInit.driver;

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//a[text()='Login' and @class="btn btn-link navbar-btn"]

	@FindBy (xpath="//a[text()='Login' and @class=\"btn btn-link navbar-btn\"]")
	public static WebElement loginButton;

	@FindBy (xpath="//input[@id='input-email']")
	public static WebElement username;
	
	@FindBy (xpath="//input[@id='input-password']")
	public static WebElement password;
	
	@FindBy (xpath="//button[text()='Login']")
	public static WebElement LoginButton;

	@FindBy (xpath="//div[contains(text(),\"No match for E-Mail and/or Password.\")]")
	public static WebElement errorMessage;

	public void goToLogin(){
		this.loginButton.click();
	}

	public void enterUsername(String username){
		this.username.sendKeys(username);
	}

	public void enterPassword(String password){
		this.password.sendKeys(password);
	}

	public void clickLoginButton(){
		this.LoginButton.click();
	}
}
