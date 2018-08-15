import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login {

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
    private WebElement loginUsername;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
    private WebElement loginPassword;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
    static public WebElement checkSuccessful;


    public void loggingIn(){
        loginUsername.sendKeys(importData.userName);
        loginPassword.sendKeys(importData.password);
        loginButton.submit();
    }
}
