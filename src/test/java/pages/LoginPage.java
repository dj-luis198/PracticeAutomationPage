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

    public void emailRegister(String email){
        try {
            sendKeys(inputEmailCreateAccount,email);
        }catch (org.openqa.selenium.TimeoutException e) {
            throw new Error ("El WebElement inputEmailCreateAccount no encontrado: "+e);
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

    public void clickButtonCreate(){
        try {
            click(buttonCreateAccount);
        }catch (org.openqa.selenium.TimeoutException e) {
            throw new Error ("El WebElement buttonCreateAccount no encontrado: "+e);
        }
    }

    public void checkErrorAccount() throws InterruptedException {
        Thread.sleep(2000); //espera de 2 segundos para ver el mensaje de error
        try {
            if (isDisplayed(errorCreateAccount)) {
                throw new Error ("El email ingresado no es correcto o ya esta registrado");
            }
        }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
            throw new Error ("El WebElement buttonCreateAccount no encontrado: "+e);
        }
    }

}
