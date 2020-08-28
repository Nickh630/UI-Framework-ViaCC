package login;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @Description("User is logged in and taken to Homepage")
    @Severity(SeverityLevel.BLOCKER)
    @Story("ANCP-13684")
    @Epic("Automated Testing-Deployments")
    public void testSuccessfulLogin() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        assertEquals(homePage.getAlertText(), "Activities", "Text is incorrect");
    }
}
