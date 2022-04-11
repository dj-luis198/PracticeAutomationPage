package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.IndexPage;
import pages.LoginPage;
import pages.MyAccount;
import pages.RegisterPage;

public class registerSteps {
    private static final MyAccount MA = new MyAccount();
    private static final IndexPage IP = new IndexPage();
    private static final LoginPage LP= new LoginPage();
    private static final RegisterPage RP= new RegisterPage();

    @Given("El usuario se encuentra en la pagina home de automationpractice")
    public void elUsuarioSeEncuentraEnLaPaginaHomeDeAutomationPractice() {
        IP.goToIndexPage();
        IP.checkPage();
    }
    @When("Hace clic en SignIn")
    public void haceClicEnSignIn() {
       IP.signIn();
    }
    @And("Ingresa su Email")
    public void ingresaSuEmail() {
       LP.checkPage();
       LP.emailRegister("mycuenta26@gmail.com");
    }
    @And("Presiona el boton Create an account")
    public void presionaElBotonCreateAnAccount() throws InterruptedException {
        LP.clickButtonCreate();
        LP.checkErrorAccount();
    }
    @And("Selecciona Title")
    public void seleccionaTitle() {
       RP.checkPage();
       RP.selectGender("Mr.");
    }
    @And("Ingresa First name")
    public void ingresaFirstName() {
       RP.enterFirstName("Daniel");
    }
    @And("Ingresa Last name")
    public void ingresaLastName() {
       RP.enterLastName("Farias");
    }
    @And("Confirma Email")
    public void confirmaEmail() {
        RP.checkEmail("mycuenta26@gmail.com");
    }
    @And("Ingresa Password")
    public void ingresaPassword() {
       RP.enterPasswd("pass23");
    }
    @And("Ingresa Date of Birth")
    public void ingresaDateOfBirth() {
        RP.selectDateOfBirth("21","7","2000");
    }
    @And("Selecciona opciones de suscripcion")
    public void seleccionaOpcionesDeSuscripcion() {
        RP.selectCheckboxs("yes","no");
    }
    @And("Ingresa Company")
    public void ingresaCompany() {
        RP.enterCompany("NA");
    }
    @And("Selecciona Country")
    public void seleccionaCountry() {
        RP.selectCountry("United States");
    }
    @And("Selecciona State")
    public void seleccionaState() {
        RP.selectState("Delaware");
    }
    @And("Ingresa City")
    public void ingresaCity() {
        RP.enterCity("city");
    }
    @And("Ingresa Postal Code")
    public void ingresaPostalCode() {
       RP.enterPostalCode("11111");
    }
    @And("Ingresa Address1")
    public void ingresaAddress1() {
        RP.enterAddress1("address1");
    }
    @And("Ingresa Address2")
    public void ingresaAddress2() {
        RP.enterAddress2("address2");
    }
    @And("Ingresa Additional information")
    public void ingresaAdditionalInformation() {
        RP.enterAdditionalInformation("info");
    }
    @And("Ingresa Home phone")
    public void ingresaHomePhone() {
        RP.enterPhone("3814374118");
    }
    @And("Ingresa Mobile phone")
    public void ingresaMobilePhone() {
       RP.enterPhoneMobile("3813004847");
    }
    @And("Ingresa address alias")
    public void ingresaAddressAlias() {
        RP.enterAliasAddress("alias");
    }
    @And("Presiona el boton register")
    public void presionaElBotonRegister() { RP.clickButtonRegister(); }
    @Then("Deberia llevarme a la pagina My Account")
    public void deberiaLlevarmeALaPaginaMyAccount() {
        Assert.assertTrue(MA.checkPage());
        Assert.assertEquals("Daniel Farias",MA.checkUserName("Daniel Farias"));
    }

}
