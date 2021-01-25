package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class EventDetailsUnderEventsPage extends BasePage {

    private final By editButton = By.id("ClaimLossDetails:ClaimLossDetailsScreen:Edit-btnInnerEl");
    private final By eventClassificationDropdown = By.id("ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:LMPropertyLossDetailsDV:Claim_LMClaimClassType-inputEl");
    private final By updateButton = By.id("ClaimLossDetails:ClaimLossDetailsScreen:Update-btnInnerEl");
    private final By eventClassificationErrorMessage = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs");
    private final By cancelButton = By.id("ClaimLossDetails:ClaimLossDetailsScreen:Cancel-btnInnerEl");
    private final By closeEventDropdown = By.id("ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:LMPropertyLossDetailsDV:LMEventStatusCommonInputSet:Event_ClosingFlag-inputEl");
    private final By outcomeDropdown = By.id("ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:LMPropertyLossDetailsDV:LMEventStatusCommonInputSet:LMClaimCloseInputSet:Closing_ClosingReason-inputEl");
    private final By specificReasonDropdown = By.id("ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:LMPropertyLossDetailsDV:LMEventStatusCommonInputSet:LMClaimCloseInputSet:Closing_ClosingSubReason-inputEl");
    private final By clearButton = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl");

    public EventDetailsUnderEventsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
    }

    public void clickEventDetailsEditButton(){
        WebElement editButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButtonEle.click();
    }

    public void selectHomeOfficeFromEventClassificationDropdown() {
        boolean timeoutElement = true;
        while(timeoutElement){
            try{
                WebElement ele =  fluentWait.until(ExpectedConditions.elementToBeClickable(eventClassificationDropdown));
                ele.click();
                action.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build().perform();
                //WebElement ele = driver.findElement(eventClassificationDropdown);
                //action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
                timeoutElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                timeoutElement = true;
            }
        }
    }

    public void clickEventDetailsUpdateButton() {
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement updateButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(updateButton));
                updateButtonEle.click();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
    }

    public String getEventClassificationMessage() {
        boolean staleElement = true;
        String validationResultsErrorText = null;
        while(staleElement){
            try{
                WebElement errorMessageEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(eventClassificationErrorMessage));
                validationResultsErrorText = errorMessageEle.getText();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return validationResultsErrorText;
    }

    public void clickCancel() {
        WebElement cancelButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButtonEle.click();
    }

    public void selectYesFromCloseEventDropdown() {
        WebElement ele = fluentWait.until(ExpectedConditions.elementToBeClickable(closeEventDropdown));
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectOptionFromOutcomeDropdown() {
        WebElement ele = fluentWait.until(ExpectedConditions.elementToBeClickable(outcomeDropdown));
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void selectDuplicateFromSpecificReasonDropdown() {
        WebElement ele = fluentWait.until(ExpectedConditions.elementToBeClickable(specificReasonDropdown));
        action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
    }

    public void clickClearButton() {
        WebElement clearButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(clearButton));
        clearButtonEle.click();
    }
}
