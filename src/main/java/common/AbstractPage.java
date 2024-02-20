package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    WebDriver driver;
    WebElement element;
    By by;
    WebDriverWait waitExplicit;
    List<WebElement> elements;
    Actions action;
    Duration longTimeout = Duration.ofSeconds(30);
    Random random;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
    }

    public void overideGlobalTimeout(long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    /* WEB BROWSER */
    public void openURL(String url) {
        driver.get(url);
    }

    public void sleepInSecond(long numberInSecond) {
        try {
            Thread.sleep(numberInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /* WEB ELEMENTS */

    public void clickToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void sendKeyToElement(String locator, String value) {
        element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(value);
    }

    public String getTextElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.getText();
    }

    public boolean isElementDisplayed(String locator) {
        overideGlobalTimeout(5);
        element = driver.findElement(By.xpath(locator));
        overideGlobalTimeout(30);
        return element.isDisplayed();
    }

    public boolean isElementPresentInDOM(String locator) {
        overideGlobalTimeout(5);
        elements = driver.findElements(By.xpath(locator));
        overideGlobalTimeout(30);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void waitToElementClickable(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitToElementVisible(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, longTimeout);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void deleteAllFilesInFolder(String folderName){
        try {
            String projectFolderPath = System.getProperty("user.dir");
            String pathFolder = projectFolderPath + File.separator + File.separator + folderName;
            File file = new File(pathFolder);
            File[] listOfFiles = file.listFiles();
            for(int i=0; i<listOfFiles.length; i++){
                if (listOfFiles[i].isFile() && !listOfFiles[i].getName().endsWith(".properties")){
                    new File(listOfFiles[i].toString()).delete();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteFilesInAllureReport(){
        deleteAllFilesInFolder("allure-results");
    }
}

