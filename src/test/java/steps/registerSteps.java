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
    public void el_usuario_se_encuentra_en_la_pagina_home_de_automationpractice() {
        IP.goToIndexPage();
    }
    @When("Hace clic en SignIn")
    public void hace_clic_en_sign_in() {
       IP.signIn();
    }
    @And("Ingresa su Email")
    public void ingresa_su_email() {
       LP.checkPage();
       LP.emailRegister("mycuenta23@gmail.com");
    }
    @And("Presiona el boton Create an account")
    public void presiona_el_boton_create_an_account() throws InterruptedException {
        LP.clickButtonCreate();
        LP.checkErrorAccount();
    }
    @And("Selecciona Title")
    public void selecciona_title() {
       RP.checkPage();
       RP.selectGender("Mr.");
    }
    @And("Ingresa First name")
    public void ingresa_first_name() {
       RP.enterFirstName("Daniel");
    }
    @And("Ingresa Last name")
    public void ingresa_last_name() {
       RP.enterLastName("Farias");
    }
    @And("Confirma Email")
    public void confirma_email() {
        RP.checkEmail("mycuenta23@gmail.com");
    }
    @And("Ingresa Password")
    public void ingresa_password() {
       RP.enterPasswd("pass23");
    }
    @And("Ingresa Date of Birth")
    public void ingresa_date_of_birth() {
        RP.selectDateOfBirth("21","7","2000");
    }
    @And("Selecciona opciones de suscripcion")
    public void selecciona_opciones_de_suscripcion() {
        RP.selectCheckboxs("yes","no");
    }
    @And("Ingresa Company")
    public void ingresa_company() {
        RP.enterCompany("NA");
    }
    @And("Selecciona Country")
    public void selecciona_country() {
        RP.selectCountry("United States");
    }
    @And("Selecciona State")
    public void selecciona_state() {
        RP.selectState("Delaware");
    }
    @And("Ingresa City")
    public void ingresa_city() {
        RP.enterCity("city");
    }
    @And("Ingresa Postal Code")
    public void ingresa_postal_code() {
       RP.enterPostalCode("11111");
    }
    @And("Ingresa Address1")
    public void ingresa_address1() {
        RP.enterAddress1("address1");
    }
    @And("Ingresa Address2")
    public void ingresa_address2() {
        RP.enterAddress2("address2");
    }
    @And("Ingresa Additional information")
    public void ingresa_additional_information() {
        RP.enterAdditionalInformation("info");
    }
    @And("Ingresa Home phone")
    public void ingresa_home_phone() {
        RP.enterPhone("3814374118");
    }
    @And("Ingresa Mobile phone")
    public void ingresa_mobile_phone() {
       RP.enterPhoneMobile("3813004847");
    }
    @And("Ingresa address alias")
    public void ingresa_address_alias() {
        RP.enterAliasAddress("alias");
    }
    @And("Presiona el boton register")
    public void presiona_el_boton_register() {
        RP.clickButtonRegister();
    }
    @Then("Deberia llevarme a la pagina My Account")
    public void deberia_llevarme_a_la_pagina_my_account() {
        Assert.assertTrue(MA.checkPage());
    }

}
