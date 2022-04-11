package pages;

public class IndexPage extends Base{

    private String signIn="//*[@class=\"login\"]";


    public IndexPage() {
        super(driver);
    }

    public void goToIndexPage(){
        goTo("http://automationpractice.com/index.php");
}

    public void checkPage(){
        String actual=getTitle();
        String expected="My Store";

        if(!actual.equals(expected)){
            throw new Error("No nos encontramos en la Home Page");
        }
    }

    public void signIn(){
        click(signIn);
    }
}
