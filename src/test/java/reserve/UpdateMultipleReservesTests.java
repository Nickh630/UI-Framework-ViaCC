package reserve;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.EventsPage;
import pages.events.ExposuresUnderEventsPage;
import pages.events.SetReservesUnderEventsPage;
import pages.events.SummaryForFinancialsUnderEventsPage;

import static org.testng.Assert.assertEquals;

public class UpdateMultipleReservesTests extends BaseTest {

    @Test
    @Description("Verifies multiple reserve prices are set after LCE and ECE are updated for Auto")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-13684")
    @Epic("Automated Testing-Deployments")
    public void givenMultipleReserves_whenReservePricesAreUpdated_thenVerifyPrice() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("391079001");
        eventsPage.clickEventSearchIcon();
        ExposuresUnderEventsPage exposuresUnderEventsPage = eventsPage.clickExposuresOption();
        exposuresUnderEventsPage.clickCollisionExposureNoOne();
        SetReservesUnderEventsPage setReservesUnderEventsPage = exposuresUnderEventsPage.clickEditReserveButton();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByOne();
        setReservesUnderEventsPage.findAndConvertValueOfExpenseCostEstimateByAddingOne();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryAlertText(), "Pending Transactions", "Unexpected Message: Alert Incorrect");
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        Thread.sleep(1500);
        String pendingSecondAmount = summaryForFinancialsUnderEventsPage.getSecondPendingTransactionAmount();
        System.out.println(pendingAmount + pendingSecondAmount);
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        Thread.sleep(2000);
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostEstimateFromFinancialsSummary(),pendingSecondAmount, "Updated Price is incorrect");
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentExpenseCostEstimateFromFinancialsSummary(),pendingAmount, "Updated Price is incorrect");
    }
}
