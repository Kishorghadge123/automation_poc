package pages.DemoBlaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverInit;

public class LoginPage {
    static WebDriver driver= DriverInit.driver;

    public LoginPage()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.ID, using = "loginusername")
    public static WebElement txt_UserName;

    @FindBy(how= How.ID, using = "loginpassword")
    public static WebElement txt_Password;

    @FindBy(how= How.XPATH, using = "//button[text()='Log in']")
    public WebElement btn_LogIn;

    public void enterUserName(String userName){
        txt_UserName.sendKeys(userName);
    }

    public void enterPassword(String password){
        txt_Password.sendKeys(password);
    }

    public void clickLoginButton(){
        btn_LogIn.click();
    }


}
