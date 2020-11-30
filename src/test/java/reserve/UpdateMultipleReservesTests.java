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
    //DO NOT RUN IN IE

    @Test
    @Description("Verifies multiple reserve prices are set after LCE and ECE are updated for Auto")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-17723")
    @Epic("Automated Testing-Deployments")
    public void givenMultipleReservesForAuto_whenReservePricesAreUpdated_thenVerifyReserve() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("391079001");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
       /* EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("391079001");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByOne();
        setReservesUnderEventsPage.findAndConvertValueForMultipleReserveOfExpenseCostEstimateByAddingOne();
        String lossValueValidation = setReservesUnderEventsPage.getNewMultiValueForLoss();
        String expenseValueValidation = setReservesUnderEventsPage.getNewMultiValueForExpense();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        eventsPage.clickExposuresOption();
        eventsPage.clickFinancialsOption();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostForMultiFromFinancialsSummary(), lossValueValidation, "Updated Price is incorrect");
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentExpenseCostForMultiFromFinancialsSummary(), expenseValueValidation, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies multiple reserve prices are set after LCE and ECE are updated for property")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-17723")
    @Epic("Automated Testing-Deployments")
    public void givenMultipleReservesForProperty_whenReservesAreUpdated_thenVerifyReserveUpdates() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("201079101");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("201079101");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByOne();
        setReservesUnderEventsPage.findAndConvertValueForMultipleExposureTwoLossCostByAddingOne();
        String lossValueValidation = setReservesUnderEventsPage.getNewMultiValueForLoss();
        String exposureTwoValueValidation = setReservesUnderEventsPage.getNewMultiValueForExposureTwoLoss();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        eventsPage.clickExposuresOption();
        eventsPage.clickFinancialsOption();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostForMultiFromFinancialsSummary(), lossValueValidation, "Updated Price is incorrect");
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentExposureTwoLossCostForMultiFromFinancialsSummary(), exposureTwoValueValidation, "Updated Price is incorrect");
    }
}
