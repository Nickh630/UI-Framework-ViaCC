package exposures;

import base.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.events.*;

import static org.testng.Assert.assertEquals;

public class AddExposureTests extends BaseTest {

    //@Test
    @Description("An exposure can be added to a property event")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-21751")
    @Epic("Automated Testing (Deployments): VIA CC Regression")
    public void givenPropertyEvent_whenAddingExposure_thenNewExposureIsListedOnSummary() {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("571096501");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickExposureFilterProp();
        int exposureNumber = eventsPage.getExposureNumber();
        eventsPage.clickActionsDropdown();
        eventsPage.clickChooseByExposure();
        eventsPage.clickContractLevelCoverage();
        NewExposureBuildingPage newExposureBuildingPage = eventsPage.clickBuildingNewExposure();
        newExposureBuildingPage.clickNewIncidentDropdownArrow();
        NewPropertyIncidentUnderEventsPage newPropertyIncidentUnderEventsPage = newExposureBuildingPage.selectNewIncidentOption();
        newPropertyIncidentUnderEventsPage.clickPropertyIncidentOkButton();
        ExposuresUnderEventsPage exposuresUnderEventsPage = newExposureBuildingPage.clickBuildingExposureUpdateButton();
        exposuresUnderEventsPage.clickSummaryOption();
        int updatedExposureNumber = eventsPage.getExposureNumber();
        assertEquals(updatedExposureNumber, exposureNumber + 1, "Wrong Title");
    }

    //@Test
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-21756")
    @Epic("Automated Testing (Deployments): VIA CC Regression")
    public void givenAuto_when_then() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("811074301");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickExposureFilterAuto();
        int exposureNumber = eventsPage.getExposureNumber();
        eventsPage.clickActionsDropdown();
        eventsPage.clickChooseByExposure();
        eventsPage.clickContractLevelCoverage();
        eventsPage.clickLiabilityPropertyDamageDropSide();
        NewExposurePropertyDamagePage newExposurePropertyDamagePage = eventsPage.clickLiabilityPropertyDamageUnderLPDDropSide();
        newExposurePropertyDamagePage.clickNameDropdown();
        newExposurePropertyDamagePage.selectRideShareFromNameDropdown();
        newExposurePropertyDamagePage.clickExposureRoleDropdown();
        newExposurePropertyDamagePage.selectCustomerFromExposureRoleDropdown();
        newExposurePropertyDamagePage.selectTodaysDateFromCalendar();
        ExposuresUnderEventsPage exposuresUnderEventsPage = newExposurePropertyDamagePage.clickUpdateButton();
        exposuresUnderEventsPage.clickSummaryOption();
        int updatedExposureNumber = eventsPage.getExposureNumber();
        assertEquals(updatedExposureNumber, exposureNumber + 1, "Wrong Title");
    }

    //@Test
    @Description("An exposure can be added to a GL event")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-21759")
    @Epic("Automated Testing (Deployments): VIA CC Regression")
    public void givenGL_whenAddingExposure_thenNewExposureIsListedOnSummary() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("161066201");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickExposureFilterGL();
        int exposureNumber = eventsPage.getExposureNumber();
        eventsPage.clickActionsDropdown();
        eventsPage.clickChooseByExposure();
        eventsPage.clickContractLevelCoverage();
        NewExposurePropertyDamagePage newExposurePropertyDamagePage = eventsPage.clickPremisesPropertyDamageDropSide();
        newExposurePropertyDamagePage.clickNameDropdown();
        newExposurePropertyDamagePage.selectRideShareFromNameDropdown();
        newExposurePropertyDamagePage.selectTodaysDateFromCalendar();
        ExposuresUnderEventsPage exposuresUnderEventsPage = newExposurePropertyDamagePage.clickUpdateButton();
        exposuresUnderEventsPage.clickClearOnExposureUpdate();
        newExposurePropertyDamagePage.clickUpdateButton();
        exposuresUnderEventsPage.clickSummaryOption();
        int updatedExposureNumber = eventsPage.getExposureNumber();
        assertEquals(updatedExposureNumber, exposureNumber + 1, "Wrong Title");
    }

    //Test
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-")
    @Epic("Automated Testing (Deployments): VIA CC Regression")
    public void givenProp_when_thenMature() {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("961109901");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        eventsPage.clickChooseByExposure();
        eventsPage.clickContractLevelCoverage();
        NewExposureBuildingPage newExposureBuildingPage = eventsPage.clickBuildingNewExposure();
        newExposureBuildingPage.clickNewIncidentDropdownArrow();
        NewPropertyIncidentUnderEventsPage newPropertyIncidentUnderEventsPage = newExposureBuildingPage.selectNewIncidentOption();
        newPropertyIncidentUnderEventsPage.clickPropertyIncidentOkButton();
        ExposuresUnderEventsPage exposuresUnderEventsPage = newExposureBuildingPage.clickBuildingExposureUpdateButton();
    }

    @Test
    @Description("")
    @Severity(SeverityLevel.NORMAL)
    @Story("ANCP-21765")
    @Epic("Automated Testing (Deployments): VIA CC Regression")
    public void givenAuto_when_thenMature() throws InterruptedException {
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickEventsDropdown();
        homePage.setEventNumberSearch("311099301");
        EventsPage eventsPage = homePage.clickEventSearchIcon();
        eventsPage.clickActionsDropdown();
        eventsPage.clickChooseByExposure();
        eventsPage.clickContractLevelCoverage();
        eventsPage.clickLiabilityPropertyDamageDropSide();
        NewExposurePropertyDamagePage newExposurePropertyDamagePage = eventsPage.clickLiabilityPropertyDamageUnderLPDDropSide();
        newExposurePropertyDamagePage.clickNameDropdown();
        newExposurePropertyDamagePage.selectRideShareFromNameDropdown();
        newExposurePropertyDamagePage.clickExposureRoleDropdown();
        newExposurePropertyDamagePage.selectCustomerFromExposureRoleDropdown();
        newExposurePropertyDamagePage.selectTodaysDateFromCalendar();

        //newExposurePropertyDamagePage.clickExposureClassificationDropdown();
        newExposurePropertyDamagePage.clickExposureClassificationDropdown();
        newExposurePropertyDamagePage.selectBranchOfficeFromClassDropdown();

        ExposuresUnderEventsPage exposuresUnderEventsPage = newExposurePropertyDamagePage.clickUpdateButton();
        //exposuresUnderEventsPage.clickClearOnExposureUpdate();
        //newExposurePropertyDamagePage.clickUpdateButton();
        exposuresUnderEventsPage.clickSummaryOption();
        eventsPage.clickExposureFilterAuto();
        eventsPage.clickExposureOptionOne();
        SetReservesUnderEventsPage setReservesUnderEventsPage = exposuresUnderEventsPage.clickEditReserveButton();
        setReservesUnderEventsPage.clickAddForReserve();
        setReservesUnderEventsPage.clickCostTypeOption();
        setReservesUnderEventsPage.selectLCEFromCostType();
        setReservesUnderEventsPage.setFirstNewCostEstimate("10");
        SummaryForFinancialsUnderEventsPage summaryForFinancialsUnderEventsPage = setReservesUnderEventsPage.clickSaveButtonForSetReserves();
        summaryForFinancialsUnderEventsPage.pageRefreshForAcesProcessing();
        pageRefreshInstant();
        eventsPage.clickExposuresOption();
        eventsPage.clickFinancialsOption();
        summaryForFinancialsUnderEventsPage.clickSummaryOption();
        eventsPage.clickExposureOptionOne();
        assertEquals(eventsPage.getMaturityLevelOption(), "ability to pay", "incorrect lvl");
    }
}
