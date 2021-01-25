package reserve;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.EventsPage;
import pages.events.SetReservesUnderEventsPage;
import pages.events.SummaryForFinancialsUnderEventsPage;

import static org.testng.Assert.assertEquals;

public class UpdatePropertyReserveTests extends BaseTest {

    @Test
    @Description("Verifies the Property reserve price is set after loss cost estimate is updated by increasing value")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-17725")
    @Epic("Automated Testing-Deployments")
    public void givenPropertyEventNumber_whenReserveIsIncreased_thenVerifyReserve() throws InterruptedException {
        //here
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("451066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByOne();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostEstimateFromFinancialsSummary(), pendingAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies the Property reserve price is set after loss cost estimate is updated by decreasing value")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-17725")
    @Epic("Automated Testing-Deployments")
    public void givenPropertyEventNumber_whenReserveIsDecreased_thenVerifyReserve() throws InterruptedException {
        //here
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("451066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateBySubtractingOne();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostEstimateFromFinancialsSummary(), pendingAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies the Property reserve price is set after Expense cost estimate is updated by increasing value")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-17725")
    @Epic("Automated Testing-Deployments")
    public void givenPropertyEventNumber_whenECEReserveIsIncreased_thenVerifyReserve() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("451066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfExpenseCostEstimateByAddingOne();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryAlertText(), "Pending Transactions", "Unexpected Message: Alert Incorrect");
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        eventsPage.clickExposuresOption();
        eventsPage.clickFinancialsOption();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentExpenseCostEstimateFromFinancialsSummary(), pendingAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies the Property reserve price is set after Expense cost estimate is updated by decreased value")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-17725")
    @Epic("Automated Testing-Deployments")
    public void givenPropertyEventNumber_whenECEReserveIsDecreased_thenVerifyReserve() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("451066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfExpenseCostEstimateBySubtractingOne();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //here
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        eventsPage.clickExposuresOption();
        eventsPage.clickFinancialsOption();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentExpenseCostEstimateFromFinancialsSummary(), pendingAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies the total cost exposure roll up matches the updated sum for Property event")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-19447")
    @Epic("Automated Testing-Deployments")
    public void givenPropertyEventNumberWithExposuresThatCombine_whenOneExposureUpdatesByAdding_thenRollUpMatchesSum() throws InterruptedException {
        //here II
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("301079101");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        String totalRollupValue = setReservesUnderEventsPage.getRollUpLossCostValue();
        setReservesUnderEventsPage.convertAndSendRollUpLossCostPlusOne(totalRollupValue);
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        String sumAmount = setReservesUnderEventsPage.getNewSumCostEstimate();
        setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        summaryForFinancialsUnderEventsPage.pageRefreshWaitOnRollUpForAcesProcessing();
        summaryForFinancialsUnderEventsPage.pageRefreshOnRollUpForAcesProcessing();
        pageRefreshInstant();
        eventsPage.clickExposuresOption();
        eventsPage.clickFinancialsOption();
        assertEquals(summaryForFinancialsUnderEventsPage.getRollUpLCEFromFinancialsSummary(), sumAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies the total cost exposure roll up matches the updated sum when subtracting for Property event")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-20203")
    @Epic("Automated Testing-Deployments")
    public void givenPropertyEventNumberWithExposuresThatCombine_whenOneExposureUpdatesBySubtracting_thenRollUpMatchesSum() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("301079101");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        String totalRollupValue = setReservesUnderEventsPage.getRollUpLossCostValue();
        setReservesUnderEventsPage.convertAndSendRollUpLossCostMinusOne(totalRollupValue);
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        String sumAmount = setReservesUnderEventsPage.getNewSumCostEstimate();
        //setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        summaryForFinancialsUnderEventsPage.pageRefreshOnRollUpForAcesProcessing();
        pageRefreshInstant();
        eventsPage.clickExposuresOption();
        eventsPage.clickFinancialsOption();
        assertEquals(summaryForFinancialsUnderEventsPage.getRollUpLCEFromFinancialsSummary(), sumAmount, "Updated Price is incorrect");
    }
}
