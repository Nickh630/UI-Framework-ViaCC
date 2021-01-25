package exposures;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.EventDetailsUnderEventsPage;
import pages.events.EventsPage;
import pages.events.ExposuresUnderEventsPage;

import static org.testng.Assert.assertEquals;

public class ExposureWarningTests extends BaseTest {

    @Test
    @Description("Verifies warning message displays after changing Exposure Classification to Home Office")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18853")
    @Epic("Automated Testing-Deployments")
    public void givenAutoExposure_whenSelectingHomeOfficeForExposureClassification_thenErrorMessageDisplays() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("991079001");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposureOptionOne();
        exposuresUnderEventsPage.clickEditButton();
        exposuresUnderEventsPage.selectHomeOfficeFromExposureClassificationDropdown();
        exposuresUnderEventsPage.clickUpdate();
        assertEquals(exposuresUnderEventsPage.getErrorExposureClassificationMessage(), "You cannot change the Exposure Classification to Home Office unless a user with the role of Examiner is added to this event. Rule: EXVAGC04", "Incorrect Error message" );
        exposuresUnderEventsPage.clickCancel();
    }

    @Test
    @Description("Verifies warning message displays after changing Exposure Classification to Home Office")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18853")
    @Epic("Automated Testing-Deployments")
    public void givenPropExposure_whenSelectingHomeOfficeForExposureClassification_thenErrorMessageDisplays() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("861096501");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        EventDetailsUnderEventsPage eventDetailsUnderEventsPage = eventsPage.clickEventDetailsOption();
        eventDetailsUnderEventsPage.clickEventDetailsEditButton();
        eventDetailsUnderEventsPage.selectHomeOfficeFromEventClassificationDropdown();
        eventDetailsUnderEventsPage.clickEventDetailsUpdateButton();
        assertEquals(eventDetailsUnderEventsPage.getEventClassificationMessage(), "You cannot change the Event Classification to Home Office unless a user with the role of Examiner is added to this event. Rule: EVEDPC04", "Incorrect Error message" );
        eventDetailsUnderEventsPage.clickCancel();
    }
}
