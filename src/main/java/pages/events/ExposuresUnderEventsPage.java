package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExposuresUnderEventsPage extends BasePage {

    private final By collisionNoOne = By.id("ClaimExposures:ClaimExposuresScreen:ExposuresLV:0:Order");
    private final By editReserve = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailScreen_CreateReserveButton-btnInnerEl");
    private final By editButton = By.id("ExposureDetail:ExposureDetailScreen:Edit-btnInnerEl");
    private final By closeExposureDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamageDV:LMExposureStatusCommonInputSet:Closing_ClosingInd-inputEl");
    private final By closePropertyExposureDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamagePropertyDV:LMPropExpCommonInputSet:LMExposureStatusCommonInputSet:Closing_ClosingInd-inputEl");
    private final By outcomeDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamageDV:LMExposureCloseCommonInputSet:Closing_ClosingReason-inputEl");
    private final By directDealAtClosingDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamageDV:LMExposureCloseCommonInputSet:Closing_DirectDealAtClose-inputEl");
    private final By updateButton = By.id("ExposureDetail:ExposureDetailScreen:Update-btnInnerEl");
    private final By reopenExposureButton = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailScreen_ReopenButton-btnInnerEl");
    private final By specificReasonDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamageDV:LMExposureCloseCommonInputSet:Closing_ClosingSubReason-inputEl");
    private final By clearWarningButton = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl");
    private final By secondReopenExposureButton = By.id("ReopenExposurePopup:ReopenExposureScreen:Update-btnInnerEl");
    private final By upToExposuresLink = By.id("ExposureDetail:ExposureDetail_UpLink");
    private final By exposureStatus = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td/div/div[3]/div/table/tbody/tr[1]/td[6]/div");
    private final By outcomePropertyDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamagePropertyDV:LMPropExpCommonInputSet:LMExposureCloseCommonInputSet:Closing_ClosingReason-inputEl");
    private final By specificReasonDropdownForProperty = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamagePropertyDV:LMPropExpCommonInputSet:LMExposureCloseCommonInputSet:Closing_ClosingSubReason-inputEl");
    private final By exposureClassificationDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamageDV:LMExposureOverallCommonInputSet:Exposure_LMClaimClassCode-inputEl");
    private final By exposureClassificationErrorMessage = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs");
    private final By cancelButton = By.id("ExposureDetail:ExposureDetailScreen:Cancel-btnInnerEl");
    private final By summaryOption = By.id("Claim:MenuLinks:Claim_ClaimSummaryGroup");
    private final By noReferralReasonDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamageDV:LMExposureStatusCommonInputSet:RejectReason1-inputEl");
    private final By exposurePageTitle = By.id("ClaimExposures:ClaimExposuresScreen:ttlBar");
    private final By exposureFilterButton = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td/div/div[2]/div/div/div[2]");
    //private final By exposureFilterButton = By.id("gridcolumn-1149");
    private final By topExposureNumber = By.id("ClaimExposures:ClaimExposuresScreen:ExposuresLV:0:Order");
    private final By warningClearButton = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl");

    public ExposuresUnderEventsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
    }

    public void clickCollisionExposureNoOne(){
        WebElement collisionNoOneEle = fluentWait.until(ExpectedConditions.elementToBeClickable(collisionNoOne));
        collisionNoOneEle.click();
    }

    public SetReservesUnderEventsPage clickEditReserveButton(){
        driver.findElement(editReserve).click();
        return new SetReservesUnderEventsPage(driver);
    }

   public int presenceOfEditExposureButton() {
       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       int element = driver.findElements(editReserve).size();
       return element;
   }
    public void clickEditButton(){
        WebElement editButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButtonEle.click();
    }

    public void clickCloseExposureDropdown(){
        try {
            WebElement dropdownEle = fluentWait.until(ExpectedConditions.elementToBeClickable((closeExposureDropdown)));
            dropdownEle.click();
        }
        catch (StaleElementReferenceException e){
            WebElement dropdownEle = fluentWait.until(ExpectedConditions.elementToBeClickable((closeExposureDropdown)));
            dropdownEle.click();
        }
    }

    public void clickClosePropertyExposureDropdown(){
        try {
            WebElement dropdownEle = fluentWait.until(ExpectedConditions.elementToBeClickable((closePropertyExposureDropdown)));
            dropdownEle.click();
        }
        catch (StaleElementReferenceException e){
            WebElement dropdownEle = fluentWait.until(ExpectedConditions.elementToBeClickable((closePropertyExposureDropdown)));
            dropdownEle.click();
        }
    }

    public void selectYesForClosureValue(){
        WebElement dropdownEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(closeExposureDropdown));
        dropdownEle.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void selectYesForPropertyClosureValue(){
        WebElement dropdownEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(closePropertyExposureDropdown));
        dropdownEle.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void selectErrorFromOutcomeDropdown(){
        WebElement ele = fluentWait.until(ExpectedConditions.elementToBeClickable(outcomeDropdown));
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectErrorFromPropertyOutcomeDropdown(){
        WebElement ele = fluentWait.until(ExpectedConditions.elementToBeClickable(outcomePropertyDropdown));
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectYesFromDirectDealDropdown(){
        WebElement ele = driver.findElement(directDealAtClosingDropdown);
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectDuplicateFromSpecificReasonDropdown(){
        WebElement ele = fluentWait.until(ExpectedConditions.elementToBeClickable(specificReasonDropdown));
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectDuplicateFromPropertySpecificReasonDropdown(){
        WebElement ele = fluentWait.until(ExpectedConditions.elementToBeClickable(specificReasonDropdownForProperty));
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void clickUpdate(){
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(updateButton));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
    }

    public void clickReopenExposureButton(){
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement reopenButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(reopenExposureButton));
        reopenButtonEle.click();
    }

    public void clickClearButton(){
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(clearWarningButton));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
    }

    public void clickSecondReopenExposureButton() {
        WebElement secondReopenButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(secondReopenExposureButton));
        secondReopenButtonEle.click();
    }

    public void clickUpToExposuresLink() {
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(upToExposuresLink));
                //executor.executeScript("arguments[0].click();", element);
                element.click();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
    }

    public String getExposureStatus(){
        WebElement exposureStatusEle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(exposureStatus));
        return exposureStatusEle.getText();
    }

    public void selectHomeOfficeFromExposureClassificationDropdown(){
        boolean timeoutElement = true;
        while(timeoutElement){
            try{
                /*Thread.sleep(300);
                wait.until(ExpectedConditions.presenceOfElementLocated(exposureClassificationDropdown));
                WebElement ele = driver.findElement(exposureClassificationDropdown);*/
                WebElement ele = fluentWait.until(ExpectedConditions.elementToBeClickable(exposureClassificationDropdown));
                action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
                timeoutElement = false;
            } catch(StaleElementReferenceException e){
                timeoutElement = true;
            }
        }
    }


    public String getErrorExposureClassificationMessage() {
        boolean staleElement = true;
        String validationResultsErrorText = null;
        while(staleElement){
            try{
                WebElement errorMessageEle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(exposureClassificationErrorMessage));
                validationResultsErrorText = errorMessageEle.getText();
                staleElement = false;
            } catch(StaleElementReferenceException | TimeoutException e){
                staleElement = true;
            }
        }
        return validationResultsErrorText;
    }

    public void clickCancel() {
        WebElement cancelButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButtonEle.click();
    }

    public SummaryForFinancialsUnderEventsPage clickSummaryOption(){
        boolean staleElement = true;
        /*try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        while(staleElement){
            try{
                WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(summaryOption));
                element.click();
                staleElement = false;
            } catch(StaleElementReferenceException | ElementClickInterceptedException e){
                staleElement = true;
            }
        }
        return new SummaryForFinancialsUnderEventsPage(driver);
    }

    public void selectNoReferralReasonDropdown() {
        WebElement ele = fluentWait.until(ExpectedConditions.elementToBeClickable(noReferralReasonDropdown));
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public Object getExposurePageTitle() {
        WebElement pageTitle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(exposurePageTitle));
        return pageTitle.getText();
    }

    public void clickExposureFilter() {
        WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(exposureFilterButton));
        element.click();
    }

    public int getExposureNumber() {
        WebElement exposureNumEle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(topExposureNumber));
        String exposureString = exposureNumEle.getText();
        return Integer.parseInt(exposureString);
    }

    public void clickClearOnExposureUpdate() {
        WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(warningClearButton));
        element.click();
    }
}
