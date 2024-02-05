package pageObjects;

import common.AbstractPage;
import org.openqa.selenium.WebDriver;

public class Subject7PO extends AbstractPage {
    private WebDriver driver;
    public Subject7PO(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    static final String REGISTER_BUTTON = "//a[@ui-sref='register']";
    static final String FIRST_NAME_TEXTBOX = "//input[@id='firstName']";
    static final String LAST_NAME_TEXTBOX = "//input[@id='lastName']";
    static final String EMAIL_TEXTBOX = "//input[@id='email']";
    static final String PASSWORD_TEXTBOX = "//input[@id='password']";
    static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='passwordConfirm']";
    static final String REGISTER_ACCOUNT_BUTTON = "//input[@value='Register']";
    static final String LOGIN_HEADRER = "//div[@class='panel-heading']/span[text()='Login']";




    public void clickToRegister(){
        waitToElementClickable(REGISTER_BUTTON);
        clickToElement(REGISTER_BUTTON);
    }

    public void inputToFirstName(String firstName){
        waitToElementVisible(FIRST_NAME_TEXTBOX);
        sendKeyToElement(FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputToLastName(String lastName){
        waitToElementVisible(LAST_NAME_TEXTBOX);
        sendKeyToElement(LAST_NAME_TEXTBOX, lastName);
    }

    public void inputToEmail(String email){
        waitToElementVisible(EMAIL_TEXTBOX);
        sendKeyToElement(EMAIL_TEXTBOX, email);
    }

    public void inputToPassword(String password){
        waitToElementVisible(PASSWORD_TEXTBOX);
        sendKeyToElement(PASSWORD_TEXTBOX, password);
    }

    public void inputToConfirmPassword(String confirmPassword){
        waitToElementVisible(CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickToRegisterAccount(){
        waitToElementVisible(REGISTER_ACCOUNT_BUTTON);
        clickToElement(REGISTER_ACCOUNT_BUTTON);
    }

    public boolean isLoginPageDisplayed(){
        return isElementPresentInDOM(LOGIN_HEADRER);
    }
}
