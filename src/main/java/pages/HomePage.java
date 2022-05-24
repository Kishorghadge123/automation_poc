package pages;

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

	@FindBy (xpath="//p[text()='Welcome to OpenCart!']")
	public static WebElement welcomeText;



	@FindBy (xpath ="//a[@class='btn btn-black navbar-btn']")
	public static WebElement logout;

	public void welcomeOpenCart()
	{
		this.welcomeText();
	}
	public void welcomeText() {
	}
	public void clikOnLogoutButton(){
		this.logout.click();
	}

	public void clickonlogoutbutton() {
	}
}