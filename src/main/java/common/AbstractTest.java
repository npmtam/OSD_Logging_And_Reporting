package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class AbstractTest {
    protected final Logger log; //class extend tu class nay co the goi duoc
    private WebDriver driver;
    public AbstractTest(){
        log = LogManager.getLogger(getClass()); //khoi tao bien log
    }

    public WebDriver getBrowserDriver(String browserName) {
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Please input your browser name");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;
    }

    protected boolean verifyTrue(boolean condition){
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info("----------------- PASSED -----------------");
        } catch (Exception e){
            log.fatal("----------------- FAILED -----------------");
            log.debug(e.getMessage());
            pass = false;
        }
        return pass;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
