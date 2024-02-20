
import com.github.javafaker.Faker;
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
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        emai = faker.internet().emailAddress();
        password = "Abc123";
    }

    @Test
    public void TC01_CreateAnAccount(){
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

    @Test
    public void TC02_LoginToSystem(){
        log.info("TC02 - Step 01 - Input to email");
        subject7Page.inputToEmail(emai);
        log.info("TC02 - Step 02 - Input to password");
        subject7Page.inputToPassword(password);
        log.info("TC02 - Step 03 - Click to login button");
        subject7Page.clickToLoginButton();
        log.info("TC02 - Step 04 - Verify the first name after login is matched with the first name registered");
        verifyTrue(subject7Page.getFirstNameLabelAfterLogin().equalsIgnoreCase(firstName));
        log.info("TC02 - Step 05 - Verify the last name after login is matched with the last name registered");
        verifyTrue(subject7Page.getLastNameLabelAfterLogin().equalsIgnoreCase(lastName));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
