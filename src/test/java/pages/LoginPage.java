package pages;

public class LoginPage extends Base{
private String spanAuthentication="//*[@class=\"navigation_page\"]";
private String inputEmail="//*[@id=\"email\"]";
private String inputPassword="//*[@id=\"passwd\"]";
private String buttonSubmitLogin="//*[@id=\"SubmitLogin\"]";
private String inputEmailCreateAccount="//*[@id=\"email_create\"]";
private String buttonCreateAccount="//*[@id=\"SubmitCreate\"]";
private String errorCreateAccount="//*[@id=\"create_account_error\"]";


    public LoginPage() {
        super(driver);
    }

    public void checkPage(){
            isDisplayed(spanAuthentication);
    }

    public void email(String email){
                   sendKeys(inputEmail,email);
    }

    public void emailRegister(String email){
            sendKeys(inputEmailCreateAccount,email);
    }


    public void passwd(String pass){
            sendKeys(inputPassword,pass);
    }

    public void clickButton(){
            click(buttonSubmitLogin);
    }

    public void clickButtonCreate(){
            click(buttonCreateAccount);
    }

    public void checkErrorAccount() throws InterruptedException {
       // Thread.sleep(2000); //espera de 2 segundos para ver el mensaje de error
        try {
            if (isDisplayed(errorCreateAccount)) {
                throw new Error ("El email ingresado no es correcto o ya esta registrado");
            }
        }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {

        }
    }

}
