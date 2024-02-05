
import common.AbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Subject7PO;

public class TC01_Create_Account extends AbstractTest {
    private WebDriver driver;
    private Subject7PO subject7Page;
    private String firstName, lastName, emai, password;


    @BeforeTest
    public void beforeTest(){
        driver = getBrowserDriver("chrome");
        subject7Page = new Subject7PO(driver);
        subject7Page.deleteFilesInAllureReport();
        firstName = "Nguyen";
        lastName = "Tam";
        emai = "tam.nguyen@orientsoftware.com";
        password = "Abc123";
    }

    @Test
    public void createAnAccount(){
        log.info("TC01 - Step 01 - Go to Reference Subject7");
        subject7Page.openURL("https://reference.subject-7.com/#/");

        log.info("TC01 - Step 02 - Click to Register link");
        subject7Page.clickToRegister();
        log.info("TC01 - Step 03 - Input to First Name");
        subject7Page.inputToFirstName(firstName);
        log.info("TC01 - Step 04 - Input to Last Name");
        subject7Page.inputToLastName(lastName);
        log.info("TC01 - Step 05 - Input to Email");
        subject7Page.inputToEmail(emai);
        log.info("TC01 - Step 06 - Input to Password");
        subject7Page.inputToPassword(password);
        log.info("TC01 - Step 07 - Input to Confirm Password");
        subject7Page.inputToConfirmPassword(password);
        log.info("TC01 - Step 08 - Click to Register button");
        subject7Page.clickToRegisterAccount();
        log.info("TC01 - Step 08 - Verify the account created successfully");
        verifyTrue(subject7Page.isLoginPageDisplayed());
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
