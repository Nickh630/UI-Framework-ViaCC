package regression;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.EventsPage;
import pages.events.PrintOptionsUnderEventsPage;

import static org.testng.Assert.assertTrue;

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
        printOptionsUnderEventsPage.clickIncludingDetailsRadioButton();
        printOptionsUnderEventsPage.clickPrintButton();
        printOptionsUnderEventsPage.waitForFileDownload("C:\\Users\\n1514868\\Downloads\\ViaAutoDownloads\\Print.pdf");
        assertTrue(printOptionsUnderEventsPage.isFileDownloaded("C:\\Users\\n1514868\\Downloads\\ViaAutoDownloads", "Print.pdf"), "Presence of file == false");
        printOptionsUnderEventsPage.deleteFileDownloaded("C:\\Users\\n1514868\\Downloads\\ViaAutoDownloads\\Print.pdf");
    }
}
