package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverInit;
import utilities.Functions;

import java.util.List;

public class AccountPage {
        static WebDriver driver= DriverInit.driver;

        public AccountPage(){
            PageFactory.initElements(driver, this);
        }
        @FindBy(xpath="(//a[text()='Account'])[2]")
        public static WebElement accountButton;
        @FindBy(xpath="(//a[text()='Showcase'])[2]")
        public static WebElement showCase;
        @FindBy(xpath="//a[@class='btn btn-primary']")
        public static WebElement addProject;
        @FindBy(xpath="//input[@id='input-name']")
        public static WebElement showCaseName;

        @FindBy (xpath="//select[@id='input-categ" +
                "ory']")
        public static WebElement categoryDropdown;
        @FindBy(xpath = "//button[@class=\"btn btn-default btn-group\"]")
        public static WebElement calendarButton;
        @FindBy(xpath = "(//th[@class='picker-switch'])[1]")
        public static WebElement calenderPickerSwitch1;
        //    @FindBy(xpath = "(//th[@class='picker-switch'])[2]")
        @FindBy(xpath = "//th[@class='picker-switch' and text()='2022']")
        public static WebElement calenderPickerSwitch2;

        @FindBy (xpath="//input[@id=\"input-link\"]")
        public static WebElement website;
        @FindBy (xpath="//button[@class='btn btn-primary']")
        public static WebElement submit;

        public void clickAccount() {this.accountButton.click();
        }
        // @step("click showcart")
        public void clickShowCart()
        {
            this.showCase.click();
        }
        //@step("click Add project")
        public void clickAddProject()
        {
            this.addProject.click();
        }
        // @step("Enter Show case name")
        public void enterShowCaseName(String name){
            this.showCaseName.sendKeys(name);
        }
        // @step("select showcase category")
        public void selectShowCaseCategory(String value)
        {
            Functions.dropDown(value);
        }

        public void selectDate(String selectDate,String selectMonth,String selectYear) throws InterruptedException {
            this.calendarButton.click();
            this.calenderPickerSwitch1.click();
//        Functions.initPageFactory(AccountPage.class);
            Thread.sleep(1000);
            this.calenderPickerSwitch2.click();
            Thread.sleep(1000);
//        Functions.initPageFactory(AccountPage.class);
            List<WebElement> years = driver.findElements(By.xpath("//span[contains(@class,'year')]"));
            System.out.println("printing all calendar years");
            for (WebElement year : years) {
                System.out.println(year.getText());
            }
            for (WebElement year : years) {
                if (year.getText().equalsIgnoreCase(selectYear)) {
                    System.out.println("selected year:" + year.getText());
                    year.click();
                    break;
                }
            }
            Thread.sleep(2000);
//        Functions.initPageFactory(AccountPage.class);
            List<WebElement> months = driver.findElements(By.xpath("//span[contains(@class,'month')]"));
            System.out.println("printing all calendar months");
            for (WebElement month : months) {
                System.out.println(month.getText());
            }
            for (WebElement month : months) {
                if (month.getText().equalsIgnoreCase(selectMonth)) {
                    System.out.println("selected month:" + month.getText());
                    month.click();
                    break;
                }
            }
//        Functions.initPageFactory(AccountPage.class);
            Thread.sleep(1000);
            List<WebElement> days = driver.findElements(By.xpath("//td[@class='day']"));
            System.out.println("printing all calendar days");
            for (WebElement day : days) {
                System.out.println(day.getText());
            }
            for (WebElement day : days) {
                if (day.getText().equalsIgnoreCase(selectDate)) {
                    System.out.println("selected day:" + day.getText());
                    day.click();
                    break;
                }
            }
        }
        //@step("Enter Website")
        public void enterWebsite (String website)
        {

            this.website.sendKeys(website);
        }
        //@step("click on submit button")
        public void clickSubmitButton ()
        {
            this.submit.click();
        }
    }




