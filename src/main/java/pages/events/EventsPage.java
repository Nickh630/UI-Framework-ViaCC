package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class EventsPage extends BasePage {

    private final By eventNumberArrow = By.id("TabBar:ClaimTab-btnWrap");
    private final By eventNumberSearch = By.xpath("//*[@id=\"TabBar:ClaimTab:ClaimTab_FindClaim-inputEl\"]");
    private final By searchIcon = By.id("TabBar:ClaimTab:ClaimTab_FindClaim_Button");
    private final By exposures = By.xpath("//*[@id=\"Claim:MenuLinks:Claim_ClaimExposures\"]/div");
    private final By financials = By.xpath("/html/body/div[1]/div[2]/div/span/div/div[3]/div[2]/div/table/tbody/tr[7]/td/div/span");
    private final By actionsDropdown = By.id("Claim:ClaimMenuActions-btnIconEl");
    private final By reserveOptionUnderActions = By.id("Claim:ClaimMenuActions:ClaimMenuActions_NewTransaction:ClaimMenuActions_NewTransaction_ReserveSet-textEl");
    private final By exposureOptionOne = By.id("ClaimSummary:ClaimSummaryScreen:ClaimSummaryExposuresLV:0:Order");
    private final By eventDetails = By.id("Claim:MenuLinks:Claim_ClaimLossDetailsGroup");
    private final By printEventLink = By.id("Claim:ClaimMenuActions:ClaimFileMenuItemSet:ClaimMenuActions_ClaimActions:ClaimMenuActions_Print-textEl");

    public EventsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
    }

    public void clickEventsDropdown() throws InterruptedException {
        boolean staleElement = true;
        int xOffset = 148/2 - 5;
        //int xOffset = 108/2 - 5;
        //WebElement dropdown = driver.findElement(eventNumberArrow);
        while(staleElement){
            try{
                //Thread.sleep(1100);
                //wait.until(ExpectedConditions.presenceOfElementLocated(eventNumberArrow));
                WebElement dropdown = fluentWait.until(ExpectedConditions.presenceOfElementLocated(eventNumberArrow));
                action.moveToElement(dropdown, xOffset, 0);
                action.click().build().perform();
                //executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
    }

    public void setEventNumberSearch(String eventNumber){
        boolean staleElement = true;
        //WebElement element = driver.findElement(eventNumberSearch);
        while(staleElement){
            try{
                //Thread.sleep(400);
                WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(eventNumberSearch));
                executor.executeScript("arguments[0].click();", element);
                //driver.findElement(eventNumberSearch).sendKeys(eventNumber);
                element.sendKeys(eventNumber);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
    }

    public void clickEventSearchIcon(){
        driver.findElement(searchIcon).click();
    }

    public ExposuresUnderEventsPage clickExposuresOption() {
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(exposures));
                //WebElement element = driver.findElement(exposures);
                executor.executeScript("arguments[0].click();", element);
                //action.click(newExpenseCostEstimate);
                //action.sendKeys(element, eventNumber).build().perform();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return new ExposuresUnderEventsPage(driver);
    }

    public SummaryForFinancialsUnderEventsPage clickFinancialsOption(){
        wait.until(ExpectedConditions.presenceOfElementLocated(financials));
        driver.findElement(financials).click();
        return new SummaryForFinancialsUnderEventsPage(driver);
    }

    public void clickActionsDropdown(){
        /*WebElement actionsDropdownElement = driver.findElement(actionsDropdown);
        wait.until(ExpectedConditions.presenceOfElementLocated(actionsDropdown));*/
        WebElement actionsDropdownElement = fluentWait.until(ExpectedConditions.presenceOfElementLocated(actionsDropdown));
        try {
            if (actionsDropdownElement.isDisplayed()) {
                WebElement actionsEle = fluentWait.until(ExpectedConditions.elementToBeClickable(actionsDropdown));
                executor.executeScript("arguments[0].click();", actionsEle);
                //Thread.sleep(2000);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "+ e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM "+ e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element "+ e.getStackTrace());
        }
    }

    public SetReservesUnderEventsPage clickReservesOptionUnderActions(){
        WebElement reserveOptionEle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(reserveOptionUnderActions));
        reserveOptionEle.click();
        //driver.findElement(reserveOptionUnderActions).click();
        return new SetReservesUnderEventsPage(driver);
    }

    public ExposuresUnderEventsPage clickExposureOptionOne() {
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement element = driver.findElement(exposureOptionOne);
                wait.until(ExpectedConditions.presenceOfElementLocated(exposureOptionOne));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return new ExposuresUnderEventsPage(driver);
    }

    public EventDetailsUnderEventsPage clickEventDetailsOption() {
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement element = driver.findElement(eventDetails);
                wait.until(ExpectedConditions.presenceOfElementLocated(eventDetails));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return new EventDetailsUnderEventsPage(driver);
    }

    public PrintOptionsUnderEventsPage clickPrintEvent() {
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement element = driver.findElement(printEventLink);
                wait.until(ExpectedConditions.presenceOfElementLocated(printEventLink));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return new PrintOptionsUnderEventsPage(driver);
    }
}

