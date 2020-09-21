package base;


import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private EventFiringWebDriver driver;
    protected LoginPage loginPage;

    @BeforeSuite
    public void beforeSuiteSetUp(){
    }

    @BeforeClass
    public void setUpClass(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUpMethod(){
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.get("https://test-pcm.lmig.com/palclaims/cc/ClaimCenter.do");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        loginPage = new LoginPage(driver);
        loginPage.setUsernameField("n9975299");
        loginPage.setPasswordField("PALSTCC1");
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/test.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.close();
    }

    @AfterClass
    public void teardown(){
    }

    @AfterSuite
    public void afterSuiteTearDown(){
        driver.quit();
        System.out.println("Clear Cookies Here");
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.getVersion();
        return options;
    }

    public void pageRefreshLong() throws InterruptedException {
        Thread.sleep(4500);
        driver.navigate().refresh();
            Thread.sleep(2500);
    }

    public void pageRefreshInstant(){
        driver.navigate().refresh();
    }
}
