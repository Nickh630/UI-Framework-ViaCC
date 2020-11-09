package reserve;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.events.EventsPage;
import pages.HomePage;
import pages.events.SetReservesUnderEventsPage;
import pages.events.SummaryForFinancialsUnderEventsPage;

import static org.testng.Assert.assertEquals;

public class UpdateReserveTests extends BaseTest {

    @Test
    @Description("Verifies the reserve price is set after loss cost estimate is updated")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-13684")
    @Epic("Automated Testing-Deployments")
    public void givenLCEReserve_whenAddingAmount_thenVerifyNewPrice() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByOne();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryAlertText(), "Pending Transactions", "Unexpected Message: Alert Incorrect");
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostEstimateFromFinancialsSummary(),pendingAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies the reserve price is set after Expense cost estimate is updated by adding amount")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-15689")
    @Epic("Automated Testing-Deployments")
    public void givenECEReserve_whenAddingAmount_thenVerifyNewPrice() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("591079001");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfExpenseCostEstimateByAddingOne();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryAlertText(), "Pending Transactions", "Unexpected Message: Alert Incorrect");
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentExpenseCostEstimateFromFinancialsSummary(),pendingAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies the reserve price is set after Expense cost estimate is updated by subtracting amount")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-15689")
    @Epic("Automated Testing-Deployments")
    public void givenECEReserve_whenSubtractingAmount_thenVerifyNewPrice() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("291079001");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfExpenseCostEstimateBySubtractingOne();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryAlertText(), "Pending Transactions", "Unexpected Message: Alert Incorrect");
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentExpenseCostEstimateFromFinancialsSummary(),pendingAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies Price is set after Reserve price is changed by adding a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-14693")
    @Epic("Automated Testing-Deployments")
    public void givenReserve_whenReserveSetByAddingLargeAmount_thenVerifyReserve() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByAddingLargeAmount();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryAlertText(), "Pending Transactions", "Unexpected Message: Alert Incorrect");
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostEstimateFromFinancialsSummary(),pendingAmount, "Updated Price is incorrect");
        eventsPage.clickActionsDropdown();
        eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.resetLossCostEstimateToThirtyK();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
    }

    @Test
    @Description("Verifies Price is set after Reserve price is changed by subtracting a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-15689")
    @Epic("Automated Testing-Deployments")
    public void givenReserve_whenReserveSetBySubtractingLargeAmount_thenVerifyReserve() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateBySubtractingLargeAmount();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        if(summaryForFinancialsUnderEventsPage.presenceOfSummaryAlertText()==0) {
            setReservesUnderEventsPage.resetLossCostEstimateToThirtyK();
            setReservesUnderEventsPage.clickSaveButtonForSetReserves();
            setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
            setReservesUnderEventsPage.clickSaveButtonForSetReserves();
            summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        }
        String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostEstimateFromFinancialsSummary(),pendingAmount, "Updated Price is incorrect");
        eventsPage.clickActionsDropdown();
        eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.resetLossCostEstimateToThirtyK();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
    }
}
