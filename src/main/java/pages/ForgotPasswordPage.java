package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverInit;

public class ForgotPasswordPage
{
    static WebDriver driver= DriverInit.driver;
    //private Object clickoncomfirmed;

    public ForgotPasswordPage(){
      PageFactory.initElements(driver,this);
  }
  @FindBy(xpath = "//a[@class='btn-link']")
  public static WebElement forgotpassword;

  @FindBy(xpath = "//input[@name='email']")
  public static WebElement enterEamil;

  @FindBy(xpath = "//button[contains(text(),'Submit')]")
  public static WebElement clickonsubmitbtn;

  public void enternewPassword() {
      this.forgotpassword.click();
  }
  public void enterEmail(){
      this.enterEamil.sendKeys("pratikshabagal1999@gmail.com");
  }
  public void clickonsubmit(){
      this.clickonsubmitbtn.click();
  }

    }

