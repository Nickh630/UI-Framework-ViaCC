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
    @Description("Verifies Soft warning after LCE Reserve price for Auto LOB is changed by adding a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-14693")
    @Epic("Automated Testing-Deployments")
    public void givenReserve_whenAddingLargeAmountToLCE_thenASoftWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("521099301");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("521099301");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateByAddingLargeAmount();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "Exposure: Customer should be notified of reserve changes greater than or equal to $20,000 or established SSIs. Rule: TRNVRES04",
                "Unexpected Soft Warning message");
    }

    @Test
    @Description("Verifies Soft warning after LCE Reserve price for Auto LOB is changed by subtracting a large amount(20k)")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-14693")
    @Epic("Automated Testing-Deployments")
    public void givenReserve_whenSubtractingLargeAmountToLCE_thenASoftWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("521099301");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("521099301");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.findAndConvertValueOfLossCostEstimateBySubtractingLargeAmount();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        assertEquals(setReservesUnderEventsPage.getValidationResultsWaringPopUp(), "Validation Results", "Validation Results alert not present");
        assertEquals(setReservesUnderEventsPage.getSoftWarningValidationResults(),
                "Exposure: Customer should be notified of reserve changes greater than or equal to $20,000 or established SSIs. Rule: TRNVRES04",
                "Unexpected Soft Warning message");
    }

    @Test
    @Description("Verifies the total cost exposure roll up matches the updated sum for Auto event")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-19446")
    @Epic("Automated Testing-Deployments")
    public void givenAutoEventNumberWithExposuresThatCombine_whenOneExposureUpdates_thenWarningIsGiven() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("221099301");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
       /* EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("221099301");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        String totalRollupValue = setReservesUnderEventsPage.getRollUpLossCostValue();
        setReservesUnderEventsPage.convertAndSendRollUpLossCostPlusOne(totalRollupValue);
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        String sumAmount = setReservesUnderEventsPage.getAndShortenNewRollUpSumCostEstimate();
        assertEquals(setReservesUnderEventsPage.getRollUpValidationResultsWaringPopUp(),"You have updated reserves for exposures that will roll up to the same ACES claim and coverage ((2) Elaine NG - Liability - Vehicle Damage, (5) Elaine NG - Liability - Property Damage). The Loss Cost Estimate to be sent to ACES, which should represent the total estimate for these exposures, is $" +sumAmount+ ". If this is not correct, please update the Cost Estimate values above. Rule: TRNVRES09","wrong message");
    }

    @Test
    @Description("Given a Contact Coverage Limit/Event When an increase is made to the Reserve over the Limit Then a warning message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-19443")
    @Epic("Automated Testing-Deployments")
    public void givenCoverageLimitForEvent_whenIncreasedOverLimit_thenWarningIsDisplayed() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("91079001");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.setLossCostEstimateToFifteenK();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        assertEquals(setReservesUnderEventsPage.getRollUpValidationResultsWaringPopUp(),"The total Loss Cost Estimate for coverage Operations-Property Damage exceeds the Limit/Event for this coverage. Are you sure you want to proceed with this update? Rule: TRNVRES08",
                "wrong message");
    }

    //@Test
    @Description("Given a Contact Coverage Limit for Combined exposures When an increase is made to the Reserves over the Limit Then a warning message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-19443")
    @Epic("Automated Testing-Deployments")
    public void givenCoverageCombinedLimitForEvent_whenIncreasedOverLimit_thenWarningIsDisplayed() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("891079001");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("891079001");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.setRowTwoEstimateToSixK();
        setReservesUnderEventsPage.setRowFourEstimateToSixK();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        assertEquals(setReservesUnderEventsPage.getRollUpValidationResultsWaringPopUp(),"The total Loss Cost Estimate for coverages Liability-Property Damage, Liability-Bodily Injury exceeds the Combined Limits Limit/Event for these coverages. Are you sure you want to proceed with this update? Rule: TRNVRES10",
                "wrong message");
    }

    @Test
    @Description("Given a Contact Coverage Limit/Property Event When an increase is made to the Reserve over the Limit Then a warning message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-19445")
    @Epic("Automated Testing-Deployments")
    public void givenCoverageLimitForPropertyEvent_whenIncreasedOverLimit_thenWarningIsDisplayed() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("501079101");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("501079101");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.setLossCostEstimateToFifteenK();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        assertEquals(setReservesUnderEventsPage.getRollUpValidationResultsWaringPopUp(),"The total Loss Cost Estimate for coverage Building And Dwelling exceeds the Limit/Event for this coverage. Are you sure you want to proceed with this update? Rule: TRNVRES08",
                "wrong message");
    }

    @Test
    @Description("Given a Contact Coverage Limit/Person When an increase is made to the Reserve over the Limit Then a warning message is displayed.")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-19442")
    @Epic("Automated Testing-Deployments")
    public void givenCoverageLimitPerPerson_whenIncreasedOverLimit_thenWarningIsDisplayed() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("331096201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        /*EventsPage eventsPage = homePage.clickEventsPage();
        eventsPage.clickEventsDropdown();
        eventsPage.setEventNumberSearch("331096201");
        eventsPage.clickEventSearchIcon();*/
        eventsPage.clickActionsDropdown();
        SetReservesUnderEventsPage setReservesUnderEventsPage = eventsPage.clickReservesOptionUnderActions();
        setReservesUnderEventsPage.setRowOneLossCostEstimateToFifteenK();
        setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        pageRefreshInstant();
        assertEquals(setReservesUnderEventsPage.getRollUpValidationResultsWaringPopUp(),"The Loss Cost Estimate for coverage Premises Only-Bodily Injury exceeds the Limit/Person for this coverage. Are you sure you want to proceed with this update? Rule: TRNVRES06",
                "wrong message");
    }
}
