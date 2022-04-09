package pages;

public class MyAccount extends Base{

    private String logout="//*[@class=\"logout\"]";

    public MyAccount() {
        super(driver);
    }

    public Boolean checkPage(){
        try {
            return isDisplayed(logout);
        }catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
           return false;
        }

    }
}
