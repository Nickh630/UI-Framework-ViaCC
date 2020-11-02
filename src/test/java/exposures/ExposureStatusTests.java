package exposures;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.EventsPage;
import pages.events.ExposuresUnderEventsPage;
import pages.events.SetReservesUnderEventsPage;

import static org.testng.Assert.assertEquals;

public class ExposureStatusTests extends BaseTest {

    @Test
    @Description("Verifies the status of an Auto Exposure is set to open after going through the reopen process ")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18850")
    @Epic("Automated Testing-Deployments")
    public void givenClosedAutoExposure_whenReopening_thenVerifyExposureStatusIsSetToOpen() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("831047101");
        eventsPage.clickEventSearchIcon();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposuresOption();
        exposuresUnderEventsPage.clickCollisionExposureNoOne();
            if(exposuresUnderEventsPage.presenceOfEditExposureButton()>0){
                exposuresUnderEventsPage.clickEditButton();
                exposuresUnderEventsPage.clickCloseExposureDropdown();
                exposuresUnderEventsPage.selectYesForClosureValue();
                exposuresUnderEventsPage.selectErrorFromOutcomeDropdown();
                exposuresUnderEventsPage.selectDuplicateFromSpecificReasonDropdown();
                exposuresUnderEventsPage.selectYesFromDirectDealDropdown();
                exposuresUnderEventsPage.clickUpdate();
                exposuresUnderEventsPage.clickClearButton();
                exposuresUnderEventsPage.clickUpdate();
            }
        exposuresUnderEventsPage.clickReopenExposureButton();
        exposuresUnderEventsPage.clickSecondReopenExposureButton();
        exposuresUnderEventsPage.clickUpToExposuresLink();
        assertEquals(exposuresUnderEventsPage.getExposureStatus(), "Open", "Incorrect status");
    }

    @Test
    @Description("Verifies the status of an Auto Exposure is set to open after going through the reopen process")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18849")
    @Epic("Automated Testing-Deployments")
    public void givenClosedAutoExposure_whenReopening_thenVerifyExposureStatusIsSetToOpe() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("831047101");
        eventsPage.clickEventSearchIcon();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposuresOption();
        exposuresUnderEventsPage.clickCollisionExposureNoOne();
        if(exposuresUnderEventsPage.presenceOfEditExposureButton()==0){
            exposuresUnderEventsPage.clickReopenExposureButton();
            exposuresUnderEventsPage.clickSecondReopenExposureButton();
        }
        exposuresUnderEventsPage.clickEditButton();
        exposuresUnderEventsPage.clickCloseExposureDropdown();
        exposuresUnderEventsPage.selectYesForClosureValue();
        exposuresUnderEventsPage.selectErrorFromOutcomeDropdown();
        exposuresUnderEventsPage.selectDuplicateFromSpecificReasonDropdown();
        exposuresUnderEventsPage.selectYesFromDirectDealDropdown();
        exposuresUnderEventsPage.clickUpdate();
        exposuresUnderEventsPage.clickClearButton();
        exposuresUnderEventsPage.clickUpdate();
        exposuresUnderEventsPage.clickUpToExposuresLink();
        assertEquals(exposuresUnderEventsPage.getExposureStatus(), "Closed", "Incorrect status");
    }

    @Test
    @Description("Verifies the status of an Property Exposure is set to open after going through the reopen process ")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18851")
    @Epic("Automated Testing-Deployments")
    public void givenClosedPropertyExposure_whenReopening_thenVerifyExposureStatusIsSetToOpen() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("731066201");
        eventsPage.clickEventSearchIcon();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposuresOption();
        exposuresUnderEventsPage.clickCollisionExposureNoOne();
        if(exposuresUnderEventsPage.presenceOfEditExposureButton()>0){
            exposuresUnderEventsPage.clickEditButton();
            exposuresUnderEventsPage.clickClosePropertyExposureDropdown();
            exposuresUnderEventsPage.selectYesForPropertyClosureValue();
            exposuresUnderEventsPage.selectErrorFromPropertyOutcomeDropdown();
            exposuresUnderEventsPage.selectDuplicateFromPropertySpecificReasonDropdown();
            exposuresUnderEventsPage.clickUpdate();
        }
        exposuresUnderEventsPage.clickReopenExposureButton();
        exposuresUnderEventsPage.clickSecondReopenExposureButton();
        exposuresUnderEventsPage.clickUpToExposuresLink();
        assertEquals(exposuresUnderEventsPage.getExposureStatus(), "Open", "Incorrect status");
    }

    @Test
    @Description("Verifies the status of a Property Exposure is set to closed after going through the closing process ")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18852")
    @Epic("Automated Testing-Deployments")
    public void givenOpenPropertyExposure_whenClosing_thenVerifyExposureStatusIsSetToClosed() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("731066201");
        eventsPage.clickEventSearchIcon();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposuresOption();
        exposuresUnderEventsPage.clickCollisionExposureNoOne();
        if(exposuresUnderEventsPage.presenceOfEditExposureButton()==0){
            exposuresUnderEventsPage.clickReopenExposureButton();
            exposuresUnderEventsPage.clickSecondReopenExposureButton();
        }
        exposuresUnderEventsPage.clickEditButton();
        exposuresUnderEventsPage.clickClosePropertyExposureDropdown();
        exposuresUnderEventsPage.selectYesForPropertyClosureValue();
        exposuresUnderEventsPage.selectErrorFromPropertyOutcomeDropdown();
        exposuresUnderEventsPage.selectDuplicateFromPropertySpecificReasonDropdown();
        exposuresUnderEventsPage.clickUpdate();
        exposuresUnderEventsPage.clickUpToExposuresLink();
        assertEquals(exposuresUnderEventsPage.getExposureStatus(), "Closed", "Incorrect status");
    }
}
