package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverInit;

import java.time.Duration;

public class DemoqaPage {

        static WebDriver driver= DriverInit.driver;
        public DemoqaPage()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy (xpath="//h5[text()='Widgets']")
        public static WebElement Widgets;

        @FindBy (xpath="//span[text()='Progress Bar']")
        public static WebElement ProgressBar;


        @FindBy (xpath="//button[@id='startStopButton']")
        public static WebElement StartStopButton;

        @FindBy(xpath = "//div[@role=\"progressbar\"]")
        public static WebElement ProgressBarButton;


        public void clickWidgets()
        {
            this.Widgets.click();
        }

        public void clickProgress_Bar()
        {
            this.ProgressBar.click();
        }

        public void clickStartStopButton() throws InterruptedException {
            this.StartStopButton.click();
            Thread.sleep(5000);
          // this.StartStopButton.click();
        }
        public void ProgressBarButton() throws InterruptedException {
            Thread.sleep(3000);
            String text = this.ProgressBarButton.getText();
            System.out.println("Text "+text);
            WebDriverWait wait=new WebDriverWait(driver,30);
            Boolean ProgressBarStatus = wait.until(ExpectedConditions.attributeToBe(ProgressBarButton, "aria-valuenow", "100"));
            Thread.sleep(3000);
            if(ProgressBarStatus==true)
            {
              wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='resetButton']"))).click();
            }

        }



    }


