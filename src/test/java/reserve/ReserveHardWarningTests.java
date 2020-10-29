package reserve;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.EventsPage;
import pages.events.SetReservesUnderEventsPage;

import static org.testng.Assert.assertEquals;

public class ReserveHardWarningTests extends BaseTest {

    @Test
    @Description("Verifies Hard warning after LCE Reserve price for Auto LOB is changed to less than paid to date price.")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18136")
    @Epic("Automated Testing-Deployments")
    public void givenPaidToDatePriceForAuto_whenChangingLCEReservePriceLessThanPTD_thenAHardWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("791079001");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.changeCostEstimateForLossCostTo3K();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "New Cost Estimate must be greater than or equal to Net Paid to Date. Rule:TRNVRES05",
                "Unexpected Hard Warning message");
        //setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "New Cost Estimate must be greater than or equal to Net Paid to Date. Rule:TRNVRES05",
                "Unexpected Hard Warning message");
        //setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
    }

    @Test
    @Description("Verifies Hard warning after ECE Reserve price for Auto is changed to less than paid to date price.")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18136")
    @Epic("Automated Testing-Deployments")
    public void givenPaidToDatePriceForAuto_whenChangingECEReservePriceLessThanPTD_thenAHardWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("791079001");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.changeCostEstimateForExpenseCostTo3K();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "New Cost Estimate must be greater than or equal to Net Paid to Date. Rule:TRNVRES05",
                "Unexpected Hard Warning message");
        //setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "New Cost Estimate must be greater than or equal to Net Paid to Date. Rule:TRNVRES05",
                "Unexpected Hard Warning message");
        //setReservesUnderEventsPage.clickClearButtonForValidationResultsAlert();
    }

    @Test
    @Description("Verifies Hard warning after LCE Reserve price for Property LOB is changed to less than paid to date price.")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18136")
    @Epic("Automated Testing-Deployments")
    public void givenPaidToDatePriceForProperty_whenChangingLCEReservePriceLessThanPTD_thenAHardWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("401079101");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.changeCostEstimateForLossCostTo3K();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "New Cost Estimate must be greater than or equal to Net Paid to Date. Rule:TRNVRES05",
                "Unexpected Hard Warning message");
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "New Cost Estimate must be greater than or equal to Net Paid to Date. Rule:TRNVRES05",
                "Unexpected Hard Warning message");
    }

    @Test
    @Description("Verifies Hard warning after LCE Reserve price for Property LOB is changed to less than paid to date price.")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-18136")
    @Epic("Automated Testing-Deployments")
    public void givenPaidToDatePriceForProperty_whenChangingECEReservePriceLessThanPTD_thenAHardWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("401079101");
        eventsPage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.changeCostEstimateForExpenseCostTo3K();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        //assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "New Cost Estimate must be greater than or equal to Net Paid to Date. Rule:TRNVRES05",
                "Unexpected Hard Warning message");
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "New Cost Estimate must be greater than or equal to Net Paid to Date. Rule:TRNVRES05",
                "Unexpected Hard Warning message");
    }
}
