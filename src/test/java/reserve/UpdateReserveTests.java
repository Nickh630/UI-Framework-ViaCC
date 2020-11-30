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
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("631066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByOne();
        //pageRefreshInstant();
        setReservesUnderEventsPage.clickToUpdateValueInSumField();
        //Thread.sleep(2000);
        String sumAmount = setReservesUnderEventsPage.getNewSumCostEstimate();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryAlertText(), "Pending Transactions", "Unexpected Message: Alert Incorrect");
        //String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostEstimateFromFinancialsSummary(), sumAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies the reserve price is set after Expense cost estimate is updated by adding amount")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-15689")
    @Epic("Automated Testing-Deployments")
    public void givenECEReserve_whenAddingAmount_thenVerifyNewPrice() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("591079001");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("591079001");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfExpenseCostEstimateByAddingOne();
        setReservesUnderEventsPage.clickToUpdateValueInSumField();
        //Thread.sleep(2000);
        String sumAmount = setReservesUnderEventsPage.getNewSumCostEstimate();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryAlertText(), "Pending Transactions", "Unexpected Message: Alert Incorrect");
        //String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentExpenseCostEstimateFromFinancialsSummary(), sumAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies the reserve price is set after Expense cost estimate is updated by subtracting amount")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-15689")
    @Epic("Automated Testing-Deployments")
    public void givenECEReserve_whenSubtractingAmount_thenVerifyNewPrice() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("291079001");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("291079001");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfExpenseCostEstimateBySubtractingOne();
        setReservesUnderEventsPage.clickToUpdateValueInSumField();
        //Thread.sleep(2000);
        String sumAmount = setReservesUnderEventsPage.getNewSumCostEstimate();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        //String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentExpenseCostEstimateFromFinancialsSummary(), sumAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies Price is set after Reserve price is changed by adding a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-14693")
    @Epic("Automated Testing-Deployments")
    public void givenReserve_whenReserveSetByAddingLargeAmount_thenVerifyReserve() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("631066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByAddingLargeAmount();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        String sumAmount = setReservesUnderEventsPage.getNewSumCostEstimate();
        setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(summaryForFinancialsUnderEventsPage.getFinancialsSummaryAlertText(), "Pending Transactions", "Unexpected Message: Alert Incorrect");
        //String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostEstimateFromFinancialsSummary(),sumAmount, "Updated Price is incorrect");
        eventsPage.clickActionsDropdown();
        eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.resetLossCostEstimateToThirtyK();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
    }

    @Test
    @Description("Verifies Price is set after Reserve price is changed by subtracting a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-15689")
    @Epic("Automated Testing-Deployments")
    public void givenReserve_whenReserveSetBySubtractingLargeAmount_thenVerifyReserve() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("631066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateBySubtractingLargeAmount();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        String sumAmount = setReservesUnderEventsPage.getNewSumCostEstimate();
        setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //String pendingAmount = summaryForFinancialsUnderEventsPage.getPendingTransactionAmount();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        assertEquals(summaryForFinancialsUnderEventsPage.getCurrentLossCostEstimateFromFinancialsSummary(),sumAmount, "Updated Price is incorrect");
        eventsPage.clickActionsDropdown();
        eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.resetLossCostEstimateToThirtyK();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        //setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
    }

    //@Test
    @Description("Verifies the total cost exposure roll up matches the updated sum when adding for Auto event")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-19446")
    @Epic("Automated Testing-Deployments")
    public void givenAutoEventNumberWithExposuresThatCombine_whenOneExposureUpdatesByAdding_thenRollUpMatchesSum() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("221099301");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("221099301");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        String totalRollupValue = setReservesUnderEventsPage.getRollUpLossCostValue();
        setReservesUnderEventsPage.convertAndSendRollUpLossCostPlusOne(totalRollupValue);
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

    //@Test
    @Description("Verifies the total cost exposure roll up matches the updated sum when subtracting for Auto event")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-20200")
    @Epic("Automated Testing-Deployments")
    public void givenAutoEventNumberWithExposuresThatCombine_whenOneExposureUpdatesBySubtracting_thenRollUpMatchesSum() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("221099301");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("221099301");
        eventsPage.clickEventSearchIcon();*/
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
