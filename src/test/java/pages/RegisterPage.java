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

    public RegisterPage() {
        super(driver);
    }

public void checkPage(){
    try {
        isEnabled(locatorFirstName);
    }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
        throw new Error ("El WebElement locatorFirstName no encontrado: "+e);
    }
}

public void selectRadioButton(String gender){
    try {
        if(gender == "Mr."){
            clickRadioButton(radioButtonGender,"1");
        }else{
            clickRadioButton(radioButtonGender,"2");
        }
    }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
        throw new Error ("El WebElement radioButtonGender no encontrado: "+e);
    }

}

public void enterFirstName(String firstName){
    try {
        sendKeys(locatorFirstName,firstName);
    }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
        throw new Error ("El WebElement locatorFirstName no encontrado: "+e);
    }
}

    public void enterLastName(String lastName){
        try {
            sendKeys(locatorLastName,lastName);
        }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
            throw new Error ("El WebElement locatorLastName no encontrado: "+e);
        }
    }

    public void checkEmail(String email){

        try {
            if( !checkValue(locatorEmail, "mycuenta20@gmail.com")){
                throw new Error("La cuenta ingesada no es igual a la mostrada");
            }else System.out.println("Los email son iguales");
        }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
            throw new Error ("El WebElement locatorEmail no encontrado: "+e);
        }

    }

    public void enterPasswd(){
        try {
            sendKeys(locatorPasswd,"pass20");
        }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
            throw new Error ("El WebElement locatorPasswd no encontrado: "+e);
        }
    }

    public void enterDateOfBirth(String day, String month,String year){
        try {
            selectDate(locatorDays,day);
            selectDate(locatorMonths,month);
            selectDate(locatorYears,year);
        }catch (org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
            throw new Error ("El WebElement locatorDays/locatorMonths/locatorYears no encontrado: "+e);
        }
    }

    public void selectCheckboxs(String check1, String check2) {
        try {
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
        } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            throw new Error("El WebElement checkboxOptin/checkboxNewsletter no encontrado: " + e);
        }

    }
}
