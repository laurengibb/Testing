import com.relevantcodes.extentreports.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class test {
    public static ExtentReports report;
    public ExtentTest test;

    WebDriver driver;
    Actions action;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\LocalInstall\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
    }

    @BeforeClass
    static public void reportSetup(){
        report = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Testing\\Report.html", true);
    }

    @Test
    public void login() {
        //Test Name
        test = report.startTest("Can log in");

        //Maximise window
        driver.manage().window().maximize();
        //test note
        test.log(LogStatus.INFO, "Browser maximised");

        //Load Create User Page
        driver.get(constant.addUser);
        //test note
        test.log(LogStatus.INFO, "Create User Page loaded");

        //getData
        importData page = PageFactory.initElements(driver, importData.class);
        page.data();
        //test note
        test.log(LogStatus.INFO, "Login data from spreadsheet got");

        //Create User
        createUser page2 = PageFactory.initElements(driver, createUser.class);
        page2.creating();
        //test note
        test.log(LogStatus.INFO, "User created");

        //Load Log-in page
        driver.get(constant.logIn);
        //test note
        test.log(LogStatus.INFO, "Login Page loaded");

        //Log-in
        login page3 = PageFactory.initElements(driver, login.class);
        page3.loggingIn();

        if (login.checkSuccessful.getText().equals("**Successful Login**")) {
            // report the test as a pass
            test.log(LogStatus.PASS, "Logged In");
        } else {
            test.log(LogStatus.FAIL, "Logged In");
        }

        Assert.assertEquals("**Successful Login**", login.checkSuccessful.getText());
    }

    @After
    public void teardown() {
        report.endTest(test);
        driver.quit();
    }

    @AfterClass
    static public void endReport(){
        report.flush();
    }

}
