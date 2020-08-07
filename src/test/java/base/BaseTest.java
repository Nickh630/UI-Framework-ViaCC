package base;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utils.EventReporter;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private EventFiringWebDriver driver;
    protected LoginPage loginPage;

   /* @BeforeSuite
            public void beforeSuiteSetUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
    }*/

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        //driver.register(new EventReporter());
        driver.get("https://test-pcm.lmig.com/palclaims/cc/ClaimCenter.do");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        loginPage = new LoginPage(driver);
        loginPage.setUsernameField("n9996525");
        loginPage.setPasswordField("paltest1");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @AfterSuite
    public void afterSuiteTearDown(){
        System.out.println("Clear Cookies Here");
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        return options;
    }

    public void pageRefreshLong() throws InterruptedException {
        Thread.sleep(6000);
        driver.navigate().refresh();
            Thread.sleep(1500);
    }

    public void pageRefreshInstant() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1500);
    }
}
