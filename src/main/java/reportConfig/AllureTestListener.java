package reportConfig;
import common.AbstractTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class AllureTestListener implements ITestListener {
    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext){
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestStart(ITestResult iTestResult){

    }

    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public static byte[] saveScreenshotPNG(String testName, WebDriver driver){
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult){
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((AbstractTest) testClass).getDriver();

        saveScreenshotPNG(iTestResult.getName(), driver);
    }
}
