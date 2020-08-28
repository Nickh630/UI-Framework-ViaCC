package reserve;

import base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.EventsPage;
import pages.HomePage;
import pages.SearchPage;

import static org.testng.Assert.assertEquals;


public class ExposureTests extends BaseTest {

    @Test
    @Description("Verifies the reserve price is set after loss cost estimate is updated")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-13684")
    @Epic("Automated Testing-Deployments")
    public void givenEventNumber_whenReservePriceIsUpdated_thenVerifyPrice() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickExposuresOption();
        eventsPage.clickCollisionExposureNoOne();
        eventsPage.clickEditReserveButton();
        eventsPage.findAndConvertValueOfLossCostEstimateByOne();
        eventsPage.clickSaveButtonForSetReserves();
        assertEquals(eventsPage.getFinancialsSummaryAlertText(), "Pending Transactions (not yet processed in ACES)", "Unexpected Message: Alert Incorrect");
        String pendingAmount = eventsPage.getPendingTransactionAmount();
        eventsPage.pageRefreshForAcesProcessing();
        assertEquals(eventsPage.getCurrentCostEstimateFromFinancialsSummary(),pendingAmount, "Updated Price is incorrect");
    }

    @Test
    @Description("Verifies Soft warning after Reserve price is changed by adding a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-14693")
    @Epic("Automated Testing-Deployments")
    public void givenReservePrice_whenAddingLargeAmount_thenASoftWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickExposuresOption();
        eventsPage.clickCollisionExposureNoOne();
        eventsPage.clickEditReserveButton();
        eventsPage.findAndConvertValueOfLossCostEstimateByAddingLargeAmount();
        eventsPage.clickSaveButtonForSetReserves();
        assertEquals(eventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present" );
        assertEquals(eventsPage.getSoftWarningValidationResults(),
                "Exposure: Customer should be notified of reserve changes greater than or equal to $20,000 or established SSIs. Rule: TRNVRES04",
                "Unexpected Soft Warning message");
    }

    @Test
    @Description("Verifies Soft warning after Reserve price is changed by subtracting a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-14693")
    @Epic("Automated Testing-Deployments")
    public void givenReservePrice_whenSubtractingLargeAmount_thenASoftWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickExposuresOption();
        eventsPage.clickCollisionExposureNoOne();
        eventsPage.clickEditReserveButton();
        eventsPage.findAndConvertValueOfLossCostEstimateBySubtractingLargeAmount();
        eventsPage.clickSaveButtonForSetReserves();
        assertEquals(eventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present" );
        assertEquals(eventsPage.getSoftWarningValidationResults(),
                "Exposure: Customer should be notified of reserve changes greater than or equal to $20,000 or established SSIs. Rule: TRNVRES04",
                "Unexpected Soft Warning message");
    }

    @Test
    @Description("Verifies Price is set after Reserve price is changed by adding a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-14693")
    @Epic("Automated Testing-Deployments")
    public void givenReservePrice_whenReserveSetByAddingLargeAmount_thenVerifyPrice() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickExposuresOption();
        eventsPage.clickCollisionExposureNoOne();
        eventsPage.clickEditReserveButton();
        eventsPage.findAndConvertValueOfLossCostEstimateByAddingLargeAmount();
        eventsPage.clickSaveButtonForSetReserves();
        eventsPage.clickClearButtonForValidationResultsAlert();
        eventsPage.clickSaveButtonForSetReserves();
        assertEquals(eventsPage.getFinancialsSummaryAlertText(), "Pending Transactions (not yet processed in ACES)", "Unexpected Message: Alert Incorrect");
        String pendingAmount = eventsPage.getPendingTransactionAmount();
        eventsPage.pageRefreshForAcesProcessing();
        assertEquals(eventsPage.getCurrentCostEstimateFromFinancialsSummary(),pendingAmount, "Updated Price is incorrect");
        eventsPage.clickExposuresOption();
        eventsPage.clickCollisionExposureNoOne();
        eventsPage.clickEditReserveButton();
        eventsPage.resetLossCostEstimateToThirtyK();
        eventsPage.clickSaveButtonForSetReserves();
        eventsPage.clickClearButtonForValidationResultsAlert();
        eventsPage.clickSaveButtonForSetReserves();
    }
    //@Test
    public void givenEventNumberIsSearched_whenPriceIsSet_thenVerifyPrice() throws InterruptedException {
        /*loginPage.setUsernameField("n9996525");
        loginPage.setPasswordField("paltest1");*/
        HomePage homePage = loginPage.clickLoginButton();
        SearchPage searchPage = homePage.clickSearchPage();
        searchPage.clickSearchByDropDown();
        Thread.sleep(2000);
        searchPage.clickEventOptionUnderSearchBy();
        searchPage.setEventNumberSearch("631066201");
        Thread.sleep(2000);
        EventsPage eventsPage = searchPage.clickEventSearchButton();
    }
}
