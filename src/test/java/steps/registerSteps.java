package steps;

import io.cucumber.java.en.*;
import pages.IndexPage;
import pages.LoginPage;

public class registerSteps {
    IndexPage IP = new IndexPage();
    LoginPage LP= new LoginPage();

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
        LP.emailRegister("mycuenta5@gmail.com");
    }

    @And("^Press the create account button$")
    public void clickCreateAccountButton() throws InterruptedException {
        LP.clickButtonCreate();
        LP.checkErrorAccount();

    }


    @And("^Enter your personal data$")
    public void enterPersonalData(){

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
