package pages;

public class IndexPage extends Base{
    private String signIn="//*[@class=\"login\"]";

    public IndexPage() {
        super(driver);
    }

    public void goToIndexPage(){
        goTo("http://automationpractice.com/index.php");
}

    public void signIn(){
    try {
        click(signIn);
    }catch (org.openqa.selenium.TimeoutException e) {
        throw new Error ("El WebElement singnIn no encontrado: "+e);
    }
}
}
