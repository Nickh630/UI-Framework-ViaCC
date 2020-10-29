package reserve;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.EventsPage;
import pages.events.SetReservesUnderEventsPage;
import pages.events.SummaryForFinancialsUnderEventsPage;

import static org.testng.Assert.assertEquals;

public class ReserveRegressionTests extends BaseTest {

    @Test
    @Description("Add Reserve and then Cancel - Land on Financial Summary Page")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18855")
    @Epic("Automated Testing-Deployments")
    public void givenExposure_whenValueIsAdjustedThenCanceled_thenFinancialSummaryScreenDisplays() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.clickAddForReserve();
        //setReservesUnderEventsPage.addValueInReserveForCancel();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickCancelForReserve();
        assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryTitleHeader(), "Financials: Summary", "Page Title incorrect");
    }
}
