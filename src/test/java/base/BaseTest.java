package base;


import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    //private EventFiringWebDriver driver = null;
    //private WebDriver driver = null;
    public RemoteWebDriver driver;
    protected LoginPage loginPage;

    @BeforeSuite
    public void beforeSuiteSetUp(){
    }

    @BeforeClass
    @Parameters({ "browser" })
    public void setUpTest(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = null;

        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches",
                    Arrays.asList("disable-popup-blocking"));
            options.addArguments("disable-infobars");
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            //options.addArguments("--headless");
            options.getVersion();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", "C:\\Users\\n1514868\\Downloads\\ViaAutoDownloads");
            options.setExperimentalOption("prefs", prefs);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        else if (browser.equalsIgnoreCase("firefox")){
            capabilities = DesiredCapabilities.firefox();
            /*FirefoxOptions options = new FirefoxOptions();
            options.setLegacy(true);*/
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("dom.popup_maximum", 0);
            profile.setPreference("privacy.popups.showBrowserMessage", false);
            capabilities.setCapability(FirefoxDriver.PROFILE, profile);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }
        else if (browser.equalsIgnoreCase("ie")) {
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            capabilities.setCapability("ignoreProtectedModeSettings", false);
            capabilities.setJavascriptEnabled(true);
            capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
            //capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
            capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
            capabilities.setCapability("cssSelectorsEnabled", true);
            capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            //capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }

       //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver","C:/Users/n1514868/Desktop/Liberty/Drivers/geckodriver.exe");
        //System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
        //System.setProperty("webdriver.edge.driver", "Drivers/MicrosoftWebdriver.exe");
    }

    @BeforeMethod
    public void setUpMethod() throws MalformedURLException, InterruptedException {
        //WebDriver driver = new FirefoxDriver();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        //driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        /*if(driver == null){
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        }
        else{
            System.out.println("Webdriver Instance");
        }*/
        /*if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        }
        else if(browserName.equalsIgnoreCase("ie")){
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            System.setProperty("webdriver.ie.driver","Drivers/IEDriverServer.exe");
            //driver = new InternetExplorerDriver();
        }*/

        driver.manage().deleteAllCookies();
        driver.get("https://test-pcm.lmig.com/palclaims/cc/ClaimCenter.do");
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(11, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        loginPage = new LoginPage(driver);
        loginPage.setUsernameField("n9995191");
        loginPage.setPasswordField("VIArox02");
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        /*if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/test.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //driver.close();
        //driver.quit();
    }

    @AfterClass
    @Parameters({ "browser" })
    public void teardown(String browser){
        if(browser.equalsIgnoreCase("ie")){
            driver.manage().deleteAllCookies();
            driver.close();
            System.out.println("Testing on IE");
        }
        driver.quit();
    }

    @AfterTest
    public void afterTestTearDown(){
        //driver.quit();
    }

    @AfterSuite
    public void afterSuiteTearDown(){
        //driver.quit();
        System.out.println("Clear Cookies Here");
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-popup-blocking");
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
