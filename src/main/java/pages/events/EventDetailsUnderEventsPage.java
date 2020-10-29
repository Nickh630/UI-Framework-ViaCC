package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class EventDetailsUnderEventsPage extends BasePage {

    private final By editButton = By.id("ClaimLossDetails:ClaimLossDetailsScreen:Edit-btnInnerEl");
    private final By eventClassificationDropdown = By.id("ClaimLossDetails:ClaimLossDetailsScreen:LossDetailsPanelSet:LossDetailsCardCV:LossDetailsDV:LMPropertyLossDetailsDV:Claim_LMClaimClassType-inputEl");
    private final By updateButton = By.id("ClaimLossDetails:ClaimLossDetailsScreen:Update-btnInnerEl");
    private final By eventClassificationErrorMessage = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:grpMsgs");
    private final By cancelButton = By.id("ClaimLossDetails:ClaimLossDetailsScreen:Cancel-btnInnerEl");

    public EventDetailsUnderEventsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickEventDetailsEditButton() throws InterruptedException {
        driver.findElement(editButton).click();
        Thread.sleep(500);
    }

    public void selectHomeOfficeFromEventClassificationDropdown() {
        boolean timeoutElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        Actions action = new Actions(driver);
        while(timeoutElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(eventClassificationDropdown));
                WebElement ele = driver.findElement(eventClassificationDropdown);
                action.click(ele).sendKeys(Keys.ARROW_DOWN, Keys.ENTER ).perform();
                timeoutElement = false;
            } catch(TimeoutException e){
                timeoutElement = true;
            }
        }
    }

    public void clickEventDetailsUpdateButton() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(updateButton));
                driver.findElement(updateButton).click();
                staleElement = false;
            } catch(StaleElementReferenceException | TimeoutException e){
                staleElement = true;
            }
        }
    }

    public String getEventClassificationMessage() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        String validationResultsErrorText = null;
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(eventClassificationErrorMessage));
                validationResultsErrorText = driver.findElement(eventClassificationErrorMessage).getText();
                staleElement = false;
            } catch(StaleElementReferenceException | TimeoutException e){
                staleElement = true;
            }
        }
        return validationResultsErrorText;
    }

    public void clickCancel() {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.presenceOfElementLocated(cancelButton));
        driver.findElement(cancelButton).click();
    }
}
