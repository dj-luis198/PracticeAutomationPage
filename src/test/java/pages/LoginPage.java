package pages;

import utils.LogHelper;

import java.util.logging.Logger;

public class LoginPage extends Base{

private String spanAuthentication="//*[@class=\"navigation_page\"]";
private String inputEmail="//*[@id=\"email\"]";
private String inputPassword="//*[@id=\"passwd\"]";
private String buttonSubmitLogin="//*[@id=\"SubmitLogin\"]";
private String inputEmailCreateAccount="//*[@id=\"email_create\"]";
private String buttonCreateAccount="//*[@id=\"SubmitCreate\"]";
private String errorCreateAccount="//*[@id=\"create_account_error\"]/ol/li";

    public LoginPage() {
        super(driver);
    }

    public void checkPage(){ isDisplayed(spanAuthentication); }

    public void email(String email){ sendKeys(inputEmail,email); }

    public void emailRegister(String email){ sendKeys(inputEmailCreateAccount,email); }


    public void passwd(String pass){ sendKeys(inputPassword,pass); }

    public void clickButton(){ click(buttonSubmitLogin); }

    public void clickButtonCreate(){ click(buttonCreateAccount); }

    public void checkErrorAccount(){
            if (isDisplayedError(errorCreateAccount)) {
                throw new Error (getText(errorCreateAccount));
            }
    }

}
