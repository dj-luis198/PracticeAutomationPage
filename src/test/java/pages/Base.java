package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    private static List<WebElement> findElements(String locator) {
        return ewait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locator)));
    }

    protected static void sendKeys(String locator, String text) {
        findElement(locator).sendKeys(text);
    }

   /* protected static void clickLinkText(String text){
        driver.findElement(By.linkText(text)).click();
    }*/

    protected static void click(String locator){
        findElement(locator).click();
    }

    protected static Boolean isDisplayed(String locator){
        return findElement(locator).isDisplayed();
    }

    protected static Boolean isEnabled(String locator){return findElement(locator).isEnabled();}

    protected static Boolean isSelected(String locator){return findElement(locator).isSelected();}

   /* protected static String getText(String locator){
        return findElement(locator).getText();
    }*/

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

    protected static void selectDate(String locator, String date){
        new Select(findElement(locator)).selectByValue(date);
    }

    protected static void selectCheckbox(String locator){
        findElement(locator).click();
    }

    public static void quit(){
        driver.quit();
    }
}