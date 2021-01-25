package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NewExposurePropertyDamagePage  extends BasePage {

    public NewExposurePropertyDamagePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
    }

    private final By newIncidentDropdownButton = By.id("NewExposure:NewExposureScreen:NewExposureDV:LMExpFixedPropIncidentInputSet:Property_Incident:Property_IncidentMenuIcon");
    private final By newIncidentOption = By.id("NewExposure:NewExposureScreen:NewExposureDV:LMExpFixedPropIncidentInputSet:Property_Incident:PropertyDamageDV_NewIncidentMenuItem-textEl");
    //private final By calendarIcon = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr/td/div/table/tbody/tr/td[2]/div/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div");
    private final By nameSelectionDropdown = By.id("NewExposure:NewExposureScreen:NewExposureDV:LMClaimantCommonInputSet:LMClaimant3rdPartyInputSet:Claimant_Picker-inputEl");
                                                   //NewExposure:NewExposureScreen:NewExposureDV:LMClaimantCommonInputSet:LMClaimant3rdPartyInputSet:Claimant_Picker-inputCell
    private final By exposureRoleDropDown = By.id("NewExposure:NewExposureScreen:NewExposureDV:LMClaimantCommonInputSet:Claimant_VehicleRelationship-inputEl");
    private final By calendarIcon = By.id("NewExposure:NewExposureScreen:NewExposureDV:LMExposureOverallCommonInputSet:Exposure_LMReportLMGDate-triggerWrap");
    private final By calendarField = By.id("NewExposure:NewExposureScreen:NewExposureDV:LMExposureOverallCommonInputSet:Exposure_LMReportLMGDate-inputEl");
    private final By updateButton = By.id("NewExposure:NewExposureScreen:Update");
    private final By updateButtonTwo = By.id("NewExposure:NewExposureScreen:Update");
    private final By statusAlert = By.id("NewExposure:NewExposureScreen:_msgs");
    private final By exposureClassificationDropDown = By.id("NewExposure:NewExposureScreen:NewExposureDV:LMExposureOverallCommonInputSet:Exposure_LMClaimClassCode-inputCell");


    public void clickNameDropdown(){
        WebElement buttonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(nameSelectionDropdown));
        buttonEle.click();
    }

    public void selectRideShareFromNameDropdown() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(nameSelectionDropdown));
        action.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();

    }

    public void clickExposureRoleDropdown() throws InterruptedException {
        //Thread.sleep(700);
        WebElement buttonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(exposureRoleDropDown));
        buttonEle.click();
        //action.click(buttonEle).sendKeys( "cust", Keys.ENTER,  Keys.ENTER).perform();
    }

    public void selectCustomerFromExposureRoleDropdown() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(exposureRoleDropDown));
        action.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
    }

    public void selectTodaysDateFromCalendar() throws InterruptedException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        Thread.sleep(300);
        WebElement buttonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(calendarIcon));
        String dateOfToday = (dateFormat.format(date));
        action.click(buttonEle);
        executor.executeScript("document.getElementById('NewExposure:NewExposureScreen:NewExposureDV:LMExposureOverallCommonInputSet:Exposure_LMReportLMGDate-inputEl').setAttribute('value', '"+dateOfToday+"')");
    }

    public ExposuresUnderEventsPage clickUpdateButton() throws InterruptedException {
        Thread.sleep(300);
        WebElement buttonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(updateButton));
        buttonEle.click();
        return new ExposuresUnderEventsPage(driver);
    }

    public int presenceOfExposureStatusAlert() {
        int ele =0;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            WebElement actionsEle = fluentWait.until(ExpectedConditions.elementToBeClickable(statusAlert));
            if (actionsEle.isDisplayed()) {
                ele =  driver.findElements(statusAlert).size();
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            System.out.println( e.getStackTrace());
        }
        return ele;
    }

    public void clickUpdateButtonAfterAlert(){
       try {
           WebElement buttonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(updateButtonTwo));
           buttonEle.click();
       } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
           e.printStackTrace();
       }
        new ExposuresUnderEventsPage(driver);
    }

    public void clickExposureClassificationDropdown() throws InterruptedException{
        Thread.sleep(300);
        WebElement buttonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(exposureClassificationDropDown));
        buttonEle.click();
    }

    public void selectBranchOfficeFromClassDropdown() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(exposureClassificationDropDown));
        action.sendKeys("Bra", Keys.ENTER).perform();
    }
}
