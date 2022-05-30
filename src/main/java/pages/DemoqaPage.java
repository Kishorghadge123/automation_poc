package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverInit;

public class DemoqaPage {

        static WebDriver driver= DriverInit.driver;
        public DemoqaPage()
        {
            PageFactory.initElements(driver, this);
        }

        @FindBy (xpath="//h5[text()='Widgets']")
        public static WebElement Widgets;

        @FindBy (xpath="//span[text()='Progress Bar']")
        public static WebElement Progress_Bar;

        @FindBy (xpath="//button[@id='startStopButton']")
        public static WebElement StartStopButton;

        public void clickWidgets()
        {
            this.Widgets.click();
        }

        public void clickProgress_Bar()
        {
            this.Progress_Bar.click();
        }
        public void clickStartStopButton()
        {
            this.StartStopButton.click();
        }
    }


