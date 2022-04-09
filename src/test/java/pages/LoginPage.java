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
        isDisplayed(spanAuthentication);
    }

    public void email(String email){
        sendKeys(inputEmail,email);
    }

    public void passwd(String pass){
        sendKeys(inputPassword,pass);
    }

    public void clickButton(){
        click(buttonSubmitLogin);
    }



}
