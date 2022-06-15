package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumCalculatorTest {

static AppiumDriver<MobileElement>driver;

    public static void main(String[]args) throws MalformedURLException {
        opencalculetor();
    }
    public static void opencalculetor() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("deviceName","narzo 50A");
        cap.setCapability("udid","7DFENF4PNFQOTOJF");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11");

        cap.setCapability("appPackage","com.coloros.calculator");
        cap.setCapability("appActivity","com.coloros.calculator.Calculator");
        URL url=new  URL("http://127.0.0.1:4723/wd/hub");
        driver =new AppiumDriver<MobileElement>(url,cap);
        System.out.println("Application Started ");

    }

}
