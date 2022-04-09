package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.IndexPage;
import pages.LoginPage;
import pages.MyAccount;

public class loginSteps {
IndexPage IP = new IndexPage();
LoginPage LP= new LoginPage();
MyAccount MA= new MyAccount();
    @Given ("^Will enter the page http://automationpractice.com/index.php$")
    public void goTOPage(){
            IP.goToIndexPage();
        }

    @When("^Click on Sign in$")
    public void clickSignIn(){
            IP.signIn();
    }

    @And("^Enter your email (.+)$")
    public void enterEmail(String email){
        LP.checkPage();
        LP.email(email);
    }

    @And("^Enter your password (.+)$")
    public void enterPassword(String pass){
        LP.passwd(pass);
    }

    @And("^Click on the Sign In button$")
    public void clickSignInButton(){
        LP.clickButton();
    }

    @Then("^takes me to the user profile$")
    public void assertProfiles(){
        Assert.assertTrue("No se inicio sesion",MA.checkPage());
    }
}
