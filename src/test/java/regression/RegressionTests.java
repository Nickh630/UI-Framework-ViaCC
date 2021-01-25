package regression;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.*;

import static org.testng.Assert.assertEquals;
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

    @Test
    @Description("When an auto event is closed the event status will read closed")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-21771")
    @Epic("Automated Testing-Deployments")
    public void givenOpenAutoEvent_whenClosingFinalExposure_thenEventStatusReadsClosed() {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("651106701");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        if (eventsPage.statusOfEventOpen().equals("St: Closed")) {
            eventsPage.clickActionsDropdown();
            eventsPage.clickReopenEventOption();
            ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickReopenClaimOption();
            eventsPage.clickExposuresOption();
            exposuresUnderEventsPage.clickCollisionExposureNoOne();
            exposuresUnderEventsPage.clickReopenExposureButton();
            exposuresUnderEventsPage.clickSecondReopenExposureButton();
        }
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposuresOption();
        exposuresUnderEventsPage.clickCollisionExposureNoOne();
        exposuresUnderEventsPage.clickEditButton();
        //exposuresUnderEventsPage.selectNoReferralReasonDropdown();
        exposuresUnderEventsPage.clickCloseExposureDropdown();
        exposuresUnderEventsPage.selectYesForClosureValue();
        exposuresUnderEventsPage.selectErrorFromOutcomeDropdown();
        exposuresUnderEventsPage.selectDuplicateFromSpecificReasonDropdown();
        exposuresUnderEventsPage.clickUpdate();
        exposuresUnderEventsPage.clickClearButton();
        exposuresUnderEventsPage.clickUpdate();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = exposuresUnderEventsPage.clickSummaryOption();
        pageRefreshInstant();
        assertEquals(eventsPage.statusOfEventOpen(), "St: Closed", "Incorrect Event Status");
    }

    @Test
    @Description("When an auto event is opened the event status will read opened")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-21780")
    @Epic("Automated Testing-Deployments")
    public void givenClosedAutoEvent_whenOpeningFinalExposure_thenEventStatusReadsOpen() {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("651106701");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        if (eventsPage.statusOfEventOpen().equals("St: Open")) {
            ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposuresOption();
            exposuresUnderEventsPage.clickCollisionExposureNoOne();
            exposuresUnderEventsPage.clickEditButton();
            //exposuresUnderEventsPage.selectNoReferralReasonDropdown();
            exposuresUnderEventsPage.clickCloseExposureDropdown();
            exposuresUnderEventsPage.selectYesForClosureValue();
            exposuresUnderEventsPage.selectErrorFromOutcomeDropdown();
            exposuresUnderEventsPage.selectDuplicateFromSpecificReasonDropdown();
            exposuresUnderEventsPage.clickUpdate();
            exposuresUnderEventsPage.clickClearButton();
            exposuresUnderEventsPage.clickUpdate();
            pageRefreshInstant();
        }
        eventsPage.clickActionsDropdown();
        eventsPage.clickReopenEventOption();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickReopenClaimOption();
        eventsPage.clickExposuresOption();
        exposuresUnderEventsPage.clickCollisionExposureNoOne();
        exposuresUnderEventsPage.clickReopenExposureButton();
        exposuresUnderEventsPage.clickSecondReopenExposureButton();
        assertEquals(eventsPage.statusOfEventOpen(), "St: Open", "Incorrect Event Status");
    }


    @Test
    @Description("When an property event is closed the event status will read closed")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-21774")
    @Epic("Automated Testing-Deployments")
    public void givenClosedPropEvent_whenOpeningFinalExposure_thenEventStatusReadsOpen() {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("731066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        if (eventsPage.statusOfEventOpen().equals("St: Open")) {
            EventDetailsUnderEventsPage eventDetailsUnderEventsPage = eventsPage.clickEventDetailsOption();
            eventDetailsUnderEventsPage.clickEventDetailsEditButton();
            eventDetailsUnderEventsPage.selectYesFromCloseEventDropdown();
            eventDetailsUnderEventsPage.selectOptionFromOutcomeDropdown();
            eventDetailsUnderEventsPage.selectDuplicateFromSpecificReasonDropdown();
            eventDetailsUnderEventsPage.clickEventDetailsUpdateButton();
            eventDetailsUnderEventsPage.clickClearButton();
            eventDetailsUnderEventsPage.clickEventDetailsUpdateButton();
        }
        eventsPage.clickActionsDropdown();
        eventsPage.clickReopenEventOption();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickReopenClaimOption();
        pageRefreshInstant();
        assertEquals(eventsPage.statusOfEventOpen(), "St: Open", "Incorrect Event Status");
    }

    @Test
    @Description("When an property event is closed the event status will read closed")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-21774")
    @Epic("Automated Testing-Deployments")
    public void givenOpenPropEvent_whenClosingFinalExposure_thenEventStatusReadsClosed() {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("731066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        if (eventsPage.statusOfEventOpen().equals("St: Closed")) {
            eventsPage.clickActionsDropdown();
            eventsPage.clickReopenEventOption();
            eventsPage.clickReopenClaimOption();
        }
        EventDetailsUnderEventsPage eventDetailsUnderEventsPage = eventsPage.clickEventDetailsOption();
        eventDetailsUnderEventsPage.clickEventDetailsEditButton();
        eventDetailsUnderEventsPage.selectYesFromCloseEventDropdown();
        eventDetailsUnderEventsPage.selectOptionFromOutcomeDropdown();
        eventDetailsUnderEventsPage.selectDuplicateFromSpecificReasonDropdown();
        eventDetailsUnderEventsPage.clickEventDetailsUpdateButton();
        //eventDetailsUnderEventsPage.clickClearButton();
        //eventDetailsUnderEventsPage.clickEventDetailsUpdateButton();
        pageRefreshInstant();
        assertEquals(eventsPage.statusOfEventOpen(), "St: Closed", "Incorrect Event Status");
    }
}
