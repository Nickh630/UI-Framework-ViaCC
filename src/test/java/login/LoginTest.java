package login;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        Thread.sleep(1000);
        assertEquals(homePage.getAlertText(), "Activities", "Text is incorrect");
    }
}
