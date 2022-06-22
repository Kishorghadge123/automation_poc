package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverInit;

public class HomePage {
	static WebDriver driver=DriverInit.driver;
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath="//p[text()=\"Welcome to OpenCart!\"]")
	public static WebElement welcomeText;
	@FindBy (xpath="//a[@class='btn btn-black navbar-btn']")
	public static WebElement logout;

	@Step("Welecome to open cart")
	public void welecomeOpenCart()
	{
		this.welcomeText();
	}

	private void welcomeText() {
	}

	public void clickLogout(){
		this.logout.click();
	}
}
