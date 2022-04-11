package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogHelper;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Base {
    private static final Logger LOGGER= LogHelper.getLogger();
    protected static WebDriver driver;
    private static WebDriverWait ewait;

    static {
        System.setProperty("webdriver.chrome.driver", "./drivers\\chromeDriver\\chromedriver.exe");
        ChromeOptions ChromeOptions = new ChromeOptions();
        driver = new ChromeDriver(ChromeOptions);
        driver.manage().window().maximize();
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Base(WebDriver driver) {

        Base.driver = driver;
        ewait = new WebDriverWait(driver, 10);
    }

    protected static void goTo(String url) {
        driver.get(url);
    }

    private static WebElement findElement(String locator) {
        try {
            return ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
            throw new Error ("WebElement "+locator+" no encontrado: "+e);
        }
    }

    protected static WebElement findElementLinkText(String text) {
        try {
            return ewait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
        }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
            throw new Error ("El LinkText "+text+" no encontrado: "+e);
        }
    }

    private static List<WebElement> findElements(String locator) {
        try {
            return ewait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locator)));
        }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
            throw new Error ("WebElement "+locator+" no encontrado: "+e);

        }
    }

    protected static void sendKeys(String locator, String text) {
        clear(locator);
        findElement(locator).sendKeys(text);
    }

    protected static void click(String locator){
        findElement(locator).click();
    }

    protected static Boolean isDisplayed(String locator){
        return findElement(locator).isDisplayed();
    }

    protected static Boolean isDisplayedError(String locator) {
        try {
            return ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            LOGGER.log(Level.INFO,"El WebElement "+locator+" no fue encontrados");

        }
        return false;
    }

    protected static Boolean isEnabled(String locator){return findElement(locator).isEnabled();}

    protected static Boolean isSelected(String locator){return findElement(locator).isSelected();}

    protected static void clickRadioButton(String locator, String text){
        List <WebElement> radioButton= findElements(locator);
        for (WebElement r : radioButton) {
            if(r.getAttribute("value").equalsIgnoreCase(text)){
               if(!r.isSelected()){
                r.click();
              }
            }
        }
    }

    protected static Boolean checkValue(String locator, String email){
        if(findElement(locator).getAttribute("value").equals(email)){
            return true;
        }else {return false;}
    }

    protected static void selectByValue(String locator, String value){
        new Select(findElement(locator)).selectByValue(value);
    }

    protected static void selectByText(String locator, String text){
        new Select(findElement(locator)).selectByVisibleText(text);
    }

    protected static void selectCheckbox(String locator){
        findElement(locator).click();
    }

    protected static String getTitle(){
        return driver.getTitle();
    }

    protected static String getText(String locator){
        return findElement(locator).getText();
    }

    private static void clear(String locator){
        findElement(locator).clear();
    }

    public static void quit(){
        driver.quit();
    }
}