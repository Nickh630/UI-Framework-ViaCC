package reserve;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.EventsPage;
import pages.events.ExposuresUnderEventsPage;
import pages.events.SetReservesUnderEventsPage;

import static org.testng.Assert.assertEquals;

public class ReserveWarningTests extends BaseTest {

    @Test
    @Description("Verifies Soft warning after LCE Reserve price is changed by adding a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-14693")
    @Epic("Automated Testing-Deployments")
    public void givenReservePrice_whenAddingLargeAmount_thenASoftWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposuresOption();
        exposuresUnderEventsPage.clickCollisionExposureNoOne();
        SetReservesUnderEventsPage setReservesUnderEventsPage = exposuresUnderEventsPage.clickEditReserveButton();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByAddingLargeAmount();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present" );
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "Exposure: Customer should be notified of reserve changes greater than or equal to $20,000 or established SSIs. Rule: TRNVRES04",
                "Unexpected Soft Warning message");
    }

    @Test
    @Description("Verifies Soft warning after LCE Reserve price is changed by subtracting a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-14693")
    @Epic("Automated Testing-Deployments")
    public void givenReservePrice_whenSubtractingLargeAmount_thenASoftWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposuresOption();
        exposuresUnderEventsPage.clickCollisionExposureNoOne();
        SetReservesUnderEventsPage setReservesUnderEventsPage = exposuresUnderEventsPage.clickEditReserveButton();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateBySubtractingLargeAmount();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present" );
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "Exposure: Customer should be notified of reserve changes greater than or equal to $20,000 or established SSIs. Rule: TRNVRES04",
                "Unexpected Soft Warning message");
    }
}
