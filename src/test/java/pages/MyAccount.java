package pages;

public class MyAccount extends Base{

    private String logout="//*[@class=\"logout\"]";

    public MyAccount() {
        super(driver);
    }

    public Boolean checkPage(){
            return isDisplayed(logout);
    }

    public String checkUserName(String text){
        return findElementLinkText(text).getText();
    }
}
