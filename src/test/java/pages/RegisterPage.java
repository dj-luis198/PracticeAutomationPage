package pages;


public class RegisterPage extends Base{
    private String radioButtonGender="id_gender";
    private String locatorFirstName="//*[@id=\"customer_firstname\"]";
    private String locatorLastName="//*[@id=\"customer_lastname\"]";
    private String locatorEmail="//*[@id=\"email\"]";
    private String locatorPasswd="//*[@id=\"passwd\"]";
    private String locatorDays="//*[@id=\"days\"]";
    private String locatorMonths="//*[@id=\"months\"]";
    private String locatorYears="//*[@id=\"years\"]";
    private String checkboxNewsletter="//*[@id=\"newsletter\"]";
    private String checkboxOptin="//*[@id=\"optin\"]";
    private String locatorCompany="//*[@id=\"company\"]";
    private String locatorAddress1="//*[@id=\"address1\"]";
    private String locatorAddress2="//*[@id=\"address2\"]";
    private String locatorCity="//*[@id=\"city\"]";
    private String locatorCountry="//*[@id=\"id_country\"]";
    private String locatorState="//*[@id=\"id_state\"]";
    private String locatorPostalCode="//*[@id=\"postcode\"]";
    private String locatorAdditionalInformation="//*[@id=\"other\"]";
    private String locatorPhone="//*[@id=\"phone\"]";
    private String locatorPhoneMobile="//*[@id=\"phone_mobile\"]";
    private String locatorAliasAddress="//*[@id=\"alias\"]";
    private String locatorRegisterButton="//*[@id=\"submitAccount\"]";

    public RegisterPage() {
        super(driver);
    }

    public void checkPage(){
        isEnabled(locatorFirstName);
}

    public void selectGender(String gender){
        if(gender == "Mr."){
            clickRadioButton(radioButtonGender,"1");
        }else{
            clickRadioButton(radioButtonGender,"2");
        }
}

    public void enterFirstName(String firstName){
        sendKeys(locatorFirstName,firstName);
}

    public void enterLastName(String lastName){
            sendKeys(locatorLastName,lastName);
       }

    public void checkEmail(String email){
            if( !checkValue(locatorEmail, email)){
                throw new Error("La cuenta ingesada no es igual a la mostrada");
            }else System.out.println("Los email son iguales");
    }

    public void enterPasswd(String passwd){
            sendKeys(locatorPasswd,passwd);
    }

    public void selectDateOfBirth(String day, String month,String year){
            selectByValue(locatorDays,day);
            selectByValue(locatorMonths,month);
            selectByValue(locatorYears,year);
    }

    public void selectCheckboxs(String check1, String check2) {
            if (check1 == "yes" && check2 == "yes") {
                if (!isSelected(checkboxNewsletter)) {
                    selectCheckbox(checkboxNewsletter);
                }
                if (!isSelected(checkboxOptin)) {
                    selectCheckbox(checkboxOptin);
                }

            } else {
                if (check1 == "yes") {
                    if (!isSelected(checkboxNewsletter)) {
                        selectCheckbox(checkboxNewsletter);
                    }
                } else {
                    if (check2 == "yes") {
                        if (!isSelected(checkboxOptin)) {
                            selectCheckbox(checkboxOptin);
                        }
                    }
                }
            }
    }

    public void enterCompany(String company){
            sendKeys(locatorCompany,company);
    }

    public void enterAddress1(String address){
            sendKeys(locatorAddress1,address);
    }

    public void enterAddress2(String address){
            sendKeys(locatorAddress2,address);
    }

    public void enterCity(String city){
            sendKeys(locatorCity,city);
    }

    public void selectCountry(String country){
                selectByText(locatorCountry, country);
    }

    public void selectState(String state){
            selectByText(locatorState, state);
    }

    public void enterPostalCode(String postalCode){
            if(postalCode.length()==5) {
                sendKeys(locatorPostalCode,postalCode);
            }else {
                throw new Error ("Codigo postal invalido debe tener tamaño igual a 5");
            }
    }

    public void enterAdditionalInformation(String addInfo){
            sendKeys(locatorAdditionalInformation,addInfo);
    }

    public void enterPhone(String phone){
            sendKeys(locatorPhone,phone);
    }

    public void enterPhoneMobile(String phoneMobile){
            sendKeys(locatorPhoneMobile,phoneMobile);
    }

    public void enterAliasAddress(String aliasAddress){
            sendKeys(locatorAliasAddress,aliasAddress);
    }

    public void clickButtonRegister(){
            click(locatorRegisterButton);
    }

}
