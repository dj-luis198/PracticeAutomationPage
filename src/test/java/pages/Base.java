package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected static WebDriver driver;
    private static WebDriverWait ewait;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win3299//chromedriver.exe");
        ChromeOptions ChromeOptions = new ChromeOptions();
        driver = new ChromeDriver(ChromeOptions);
        driver.manage().window().maximize();
        WebDriverWait ewait = new WebDriverWait(driver, 10);
    }

    public Base(WebDriver driver) {

        Base.driver = driver;
        ewait = new WebDriverWait(driver, 10);
    }

    protected static void goTo(String url) {
        driver.get(url);
    }

    private static WebElement findElement(String locator) {
        return ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    protected static void sendKeys(String locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected static void clickLinkText(String text){
        driver.findElement(By.linkText(text)).click();
    }

    protected static void click(String locator){
        findElement(locator).click();
    }

    protected static Boolean isDisplayed(String locator){
        return findElement(locator).isDisplayed();
    }

    public static void quit(){
        driver.quit();
    }
}