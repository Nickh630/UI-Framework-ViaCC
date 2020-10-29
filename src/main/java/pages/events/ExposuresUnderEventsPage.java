package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class ExposuresUnderEventsPage extends BasePage {

    private final By collisionNoOne = By.id("ClaimExposures:ClaimExposuresScreen:ExposuresLV:0:Order");
    private final By editReserve = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailScreen_CreateReserveButton-btnInnerEl");
    private final By editButton = By.id("ExposureDetail:ExposureDetailScreen:Edit-btnInnerEl");
    private final By closeExposureDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamageDV:LMExposureStatusCommonInputSet:Closing_ClosingInd-inputEl");
    private final By closePropertyExposureDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamagePropertyDV:LMPropExpCommonInputSet:LMExposureStatusCommonInputSet:Closing_ClosingInd-inputEl");
    private final By outcomeDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamageDV:LMExposureCloseCommonInputSet:Closing_ClosingReason-inputEl");
    private final By directDealAtClosingDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamageDV:LMExposureCloseCommonInputSet:Closing_DirectDealAtClose-inputEl");
    private final By updateButton = By.id("ExposureDetail:ExposureDetailScreen:Update-btnInnerEl");
    private final By reopenExposureButton = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailScreen_ReopenButton-btnInnerEl");
    private final By specificReasonDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamageDV:LMExposureCloseCommonInputSet:Closing_ClosingSubReason-inputEl");
    private final By clearWarningButton = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl");
    private final By secondReopenExposureButton = By.id("ReopenExposurePopup:ReopenExposureScreen:Update-btnInnerEl");
    private final By upToExposuresLink = By.id("ExposureDetail:ExposureDetail_UpLink");
    private final By exposureStatus = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[3]/td/div/div[3]/div/table/tbody/tr[1]/td[6]/div");
    private final By outcomePropertyDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamagePropertyDV:LMPropExpCommonInputSet:LMExposureCloseCommonInputSet:Closing_ClosingReason-inputEl");
    private final By specificReasonDropdownForProperty = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamagePropertyDV:LMPropExpCommonInputSet:LMExposureCloseCommonInputSet:Closing_ClosingSubReason-inputEl");
    private final By exposureClassificationDropdown = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:VehicleDamageDV:LMExposureOverallCommonInputSet:Exposure_LMClaimClassCode-inputEl");
    private final By exposureClassificationErrorMessage = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs");
    private final By cancelButton = By.id("ExposureDetail:ExposureDetailScreen:Cancel-btnInnerEl");
    //public Actions actions = new Actions(driver);
    //WebDriverWait wait = new WebDriverWait(driver, 10);

    public ExposuresUnderEventsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCollisionExposureNoOne(){
        driver.findElement(collisionNoOne).click();
    }

    public SetReservesUnderEventsPage clickEditReserveButton(){
        driver.findElement(editReserve).click();
        return new SetReservesUnderEventsPage(driver);
    }

   /* public boolean presenceOfEditExposureButton(){
        WebElement element = driver.findElement(editReserve);
        return element.isDisplayed();
    }*/
   public int presenceOfEditExposureButton() {
       int element = driver.findElements(editReserve).size();
       return element;
   }
    public void clickEditButton(){
        driver.findElement(editButton).click();
    }

    public void clickCloseExposureDropdown(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated((closeExposureDropdown)));
            driver.findElement(closeExposureDropdown).click();
        }
        catch (StaleElementReferenceException e){
            wait.until(ExpectedConditions.presenceOfElementLocated((closeExposureDropdown)));
            driver.findElement(closeExposureDropdown).click();
        }
    }

    public void clickClosePropertyExposureDropdown(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated((closePropertyExposureDropdown)));
            driver.findElement(closePropertyExposureDropdown).click();
        }
        catch (StaleElementReferenceException e){
            wait.until(ExpectedConditions.presenceOfElementLocated((closePropertyExposureDropdown)));
            driver.findElement(closePropertyExposureDropdown).click();
        }
    }

    public void selectYesForClosureValue(){
        driver.findElement(closeExposureDropdown).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void selectYesForPropertyClosureValue(){
        driver.findElement(closePropertyExposureDropdown).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void selectErrorFromOutcomeDropdown(){
        //driver.findElement(outcomeDropdown).click();
        WebElement ele = driver.findElement(outcomeDropdown);
        Actions action = new Actions(driver);
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectErrorFromPropertyOutcomeDropdown(){
        WebElement ele = driver.findElement(outcomePropertyDropdown);
        Actions action = new Actions(driver);
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectYesFromDirectDealDropdown(){
        WebElement ele = driver.findElement(directDealAtClosingDropdown);
        Actions action = new Actions(driver);
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectDuplicateFromSpecificReasonDropdown(){
        WebElement ele = driver.findElement(specificReasonDropdown);
        Actions action = new Actions(driver);
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectDuplicateFromPropertySpecificReasonDropdown(){
        WebElement ele = driver.findElement(specificReasonDropdownForProperty);
        Actions action = new Actions(driver);
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void clickUpdate(){
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        while(staleElement){
            try{
                //Thread.sleep(800);
                WebElement element = driver.findElement(updateButton);
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                wait.until(ExpectedConditions.presenceOfElementLocated(updateButton));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            } /*catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
      //driver.findElement(updateButton).click();
    }

    public void clickReopenExposureButton(){
        driver.findElement(reopenExposureButton).click();
    }

    public void clickClearButton(){
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        while(staleElement){
            try{
                WebElement element = driver.findElement(clearWarningButton);
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                wait.until(ExpectedConditions.presenceOfElementLocated(clearWarningButton));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            } catch (NoSuchElementException e) {
                staleElement = true;
            }
        }
    }

    public void clickSecondReopenExposureButton() {
        driver.findElement(secondReopenExposureButton).click();
    }

    public void clickUpToExposuresLink() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        while(staleElement){
            try{
                Thread.sleep(800);
                WebElement element = driver.findElement(upToExposuresLink);
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                wait.until(ExpectedConditions.presenceOfElementLocated(upToExposuresLink));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       //driver.findElement(upToExposuresLink);
    }

    public String getExposureStatus(){
      return driver.findElement(exposureStatus).getText();
    }

    public void selectHomeOfficeFromExposureClassificationDropdown(){
        boolean timeoutElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        Actions action = new Actions(driver);
        while(timeoutElement){
            try{
                Thread.sleep(300);
                wait.until(ExpectedConditions.presenceOfElementLocated(exposureClassificationDropdown));
                WebElement ele = driver.findElement(exposureClassificationDropdown);
                action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
                timeoutElement = false;
            } catch(TimeoutException | InterruptedException e){
                timeoutElement = true;
            }
        }
    }

    public String getErrorExposureClassificationMessage() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        String validationResultsErrorText = null;
        while(staleElement){
            try{
                //WebElement element = driver.findElement(exposureClassificationErrorMessage);
                wait.until(ExpectedConditions.presenceOfElementLocated(exposureClassificationErrorMessage));
                validationResultsErrorText = driver.findElement(exposureClassificationErrorMessage).getText();
                staleElement = false;
            } catch(StaleElementReferenceException | TimeoutException e){
                staleElement = true;
            }
        }
        return validationResultsErrorText;
    }

    public void clickCancel() {
       driver.findElement(cancelButton).click();
    }
}
