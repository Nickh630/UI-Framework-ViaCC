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
    @Description("Verifies that a .pdf file is downloaded after print button is clicked ")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-19786")
    @Epic("Automated Testing-Deployments")
    public void givenPrintButton_whenPrintButtonIsClicked_thenVerifyFileDownload() throws InterruptedException {
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
