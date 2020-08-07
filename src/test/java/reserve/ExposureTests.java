package reserve;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.EventsPage;
import pages.HomePage;
import pages.SearchPage;

import static org.testng.Assert.assertEquals;


public class ExposureTests extends BaseTest {

    @Test
    public void givenEventNumber_whenReservePriceIsSet_thenVerifyPrice() throws InterruptedException {
        //Thread.sleep(2000);
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        Thread.sleep(2100);
        eventsPage.clickEventsDropdown();
        Thread.sleep(1100);
        eventsPage.setEventNumberSearch("631066201");
        eventsPage.clickEventSearchIcon();
        Thread.sleep(1000);
        eventsPage.clickExposuresOption();
        eventsPage.clickCollisionExposureNoOne();
        Thread.sleep(1500);
        eventsPage.clickEditReserveButton();
        Thread.sleep(1500);
        eventsPage.findAndConvertValueOfLossCostEstimate();
        eventsPage.clickSaveButtonForSetReserves();
        Thread.sleep(2000);
        assertEquals(eventsPage.getFinancialsSummaryAlertText(), "Pending Transactions (not yet processed in ACES)", "Unexpected Message: Alert Incorrect");
        String pendingAmount = eventsPage.getPendingTransactionAmount();
        pageRefreshLong();
        assertEquals(eventsPage.getCurrentCostEstimateFromFinancialsSummary(),pendingAmount, "Updated Price is incorrect");
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
