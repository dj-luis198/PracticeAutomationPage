package pages;

public class LoginPage extends Base{
private String spanAuthentication="//*[@class=\"navigation_page\"]";
private String inputEmail="//*[@id=\"email\"]";
private String inputPassword="//*[@id=\"passwd\"]";
private String buttonSubmitLogin="//*[@id=\"SubmitLogin\"]";


    public LoginPage() {
        super(driver);
    }

    public void checkPage(){
        try {
            isDisplayed(spanAuthentication);
        }catch (org.openqa.selenium.TimeoutException e) {
            throw new Error ("El WebElement spanAuthentication no encontrado: "+e);
        }
    }

    public void email(String email){
        try {
            sendKeys(inputEmail,email);
        }catch (org.openqa.selenium.TimeoutException e) {
            throw new Error ("El WebElement inputEmail no encontrado: "+e);
        }
    }

    public void passwd(String pass){
        try {
            sendKeys(inputPassword,pass);
        }catch (org.openqa.selenium.TimeoutException e) {
            throw new Error ("El WebElement inputPassword no encontrado: "+e);
        }
    }

    public void clickButton(){
        try {
            click(buttonSubmitLogin);
        }catch (org.openqa.selenium.TimeoutException e) {
            throw new Error ("El WebElement buttonSubmitLogin no encontrado: "+e);
        }
    }



}
