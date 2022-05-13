package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class DriverInit {
    public static WebDriver driver;

    @BeforeTest
    @Parameters("test_type")
    public static void initTestType(String test_type){
        Functions.test_type = test_type;
        System.out.println("test type is: "+test_type);
    }

    @BeforeTest
    @Parameters("browser")
    public void getBrowser(String browser) {

        if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
            driver= new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.manage().window().maximize();


        }
        else if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver= new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            System.out.println("chrome browser started");
        }
        else if (browser.equalsIgnoreCase("firefox")){
            //System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
            driver= new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        else{
            System.out.println("invalid browser selected");

        }
    }
}
