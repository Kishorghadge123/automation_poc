package pages.DemoBlaze;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utilities.DriverInit;

import java.time.Duration;

public class HomePage {
    WebDriver driver = DriverInit.driver;
    FluentWait<WebDriver> wait;
    //adding PageFactory Initialization in the Initializer block, so that each time a webelement is accessed (directly or via a method),
    // the element is re-initialized. For e.g. while running tests with multiple sets of data.
    /*{
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver,HomePage.class);
    }*/

    public HomePage() {
        PageFactory.initElements(driver, this);
        wait = new FluentWait<WebDriver>(driver).pollingEvery(Duration.ofSeconds(2)).withTimeout(Duration.ofSeconds(60));
    }

    @FindBy(how = How.ID, using = "login2")
    public static WebElement btn_Login;
    @FindBy(how = How.ID, using = "nameofuser")
    public WebElement lbl_UserName;
    @FindBy(how = How.ID, using = "signin2")
    public WebElement lbl_SignUp;
    @FindBy(how = How.ID, using = "logout2")
    public static WebElement btn_Logout;

    public String getUserLoginLabel() {
        driver.switchTo().defaultContent();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lbl_UserName));
        } catch (StaleElementReferenceException sere) {
            //sere.printStackTrace();
            System.out.println("Stale Element Reference Exception for Username Label");
            PageFactory.initElements(driver, this);
        }
        return lbl_UserName.getText();
    }

    public void clickLogInButton() {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(btn_Login)).click();
        }catch (StaleElementReferenceException sere) {
            //sere.printStackTrace();
            System.out.println("Stale Element Reference Exception for Login button");
            PageFactory.initElements(driver, this);
        }
    }
    public void clickLogOutButton() {
        try{
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(btn_Logout)).click();
        } catch (StaleElementReferenceException sere) {
        //sere.printStackTrace();
        System.out.println("Stale Element Reference Exception for Logout button");
        PageFactory.initElements(driver, this);
        }
    }
    public String getSignUpLabel() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(lbl_SignUp));
        } catch (StaleElementReferenceException sere) {
            //sere.printStackTrace();
            System.out.println("Stale Element Reference Exception for Username Label");
            PageFactory.initElements(driver, this);
        }
        return lbl_SignUp.getText();
    }
}