import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class createUser {
    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
    private WebElement createUsername;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
    private WebElement createPassword;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
    private WebElement createButton;


    public void creating(){
        createUsername.sendKeys(importData.userName);
        createPassword.sendKeys(importData.password);
        createButton.submit();
    }
}
