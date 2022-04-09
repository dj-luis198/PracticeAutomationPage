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
    click(signIn);
}
}
