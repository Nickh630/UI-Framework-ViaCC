package regression;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.EventsPage;

public class RegressionTests extends BaseTest {

    @Test
    @Description("Verifies ")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-")
    @Epic("Automated Testing-Deployments")
    public void given_when_then() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickActionsDropdown();
        PrintOptionsUnderEventsPage printOptionsUnderEventsPage = eventsPage.clickPrintEvent();
        printOptionsUnderEventsPage.
    }
}
