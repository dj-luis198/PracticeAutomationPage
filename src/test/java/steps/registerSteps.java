package steps;

import io.cucumber.java.en.*;
import pages.IndexPage;
import pages.LoginPage;
import pages.RegisterPage;

public class registerSteps {
    IndexPage IP = new IndexPage();
    LoginPage LP= new LoginPage();
    RegisterPage RP= new RegisterPage();

    @Given("^Will enter the page automationpractice.com$")
    public void goTOPage(){
        IP.goToIndexPage();
    }

    @When("^Click on Sign in button$")
    public void clickSignIn(){
        IP.signIn();
    }

    @And("^Register your email$")
    public void emailRegister(){
        LP.checkPage();
        LP.emailRegister("mycuenta20@gmail.com");
    }

    @And("^Press the create account button$")
    public void clickCreateAccountButton() throws InterruptedException {
        LP.clickButtonCreate();
        LP.checkErrorAccount();

    }


    @And("^Enter your personal data$")
    public void enterPersonalData(){

        RP.checkPage();
        RP.selectRadioButton("Mrs.");
        RP.enterFirstName("Daniel");
        RP.enterLastName("Farias");
        RP.checkEmail("mycuenta20@gmail.com");
        RP.enterPasswd();
        RP.enterDateOfBirth("21","7","2000");
        RP.selectCheckboxs("no","yes");
    }

    @And("^Enter your address information$")
    public void enterAddressInfo(){

    }

    @And("^Press the register button$")
    public void clickRegisterButton(){

    }

    @Then("^I should be registered$")
    public void assertRegister(){

    }

}
