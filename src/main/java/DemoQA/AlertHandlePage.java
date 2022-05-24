package DemoQA;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import utilities.Custome_Wait;
import utilities.DriverInit;
import utilities.Custome_Wait;

import javax.imageio.metadata.IIOMetadataNode;

import static java.awt.SystemColor.window;

public class AlertHandlePage<function> {

    static WebDriver driver= DriverInit.driver;

    public AlertHandlePage()

    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[text()='Alerts, Frame & Windows']")
    public static WebElement Alerts_Frame;

    @FindBy(xpath = "//span[text()='Alerts']")
    public static WebElement Alerts;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    public static WebElement Click_me ;
    @Step("Alert,Frame & Windowsdropdown")
    public void selectAlert_Frame_Windows() {this.Alerts_Frame.click();}

@Step("Scrolling")
public static void scrollupdown(){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,250)", "");
}


//    @Step("ScrollBy")
//            js.executeScript("argument[0].scrollIntoView();",Alerts);

    @Step("Alerts")
    public void Alerts() throws InterruptedException {this.Alerts.click();}

    @Step("ClickOn Click_me")
    public void Click_me(){this.Click_me.click();}

    @Step("generate_alert_AND_getText&accept alert")
    public void GetText()
    {
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
    }
    @Step
    public void accept_alert()
    {
        driver.switchTo().alert().accept();
    }
}


