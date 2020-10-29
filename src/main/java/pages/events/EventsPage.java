package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

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

    public EventsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickEventsDropdown() throws InterruptedException {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 6);
        int xOffset = 148/2 - 5;
        Actions actions = new Actions(driver);
        while(staleElement){
            try{
                Thread.sleep(1100);
                wait.until(ExpectedConditions.presenceOfElementLocated(eventNumberArrow));
                WebElement dropdown = driver.findElement(eventNumberArrow);
                //JavascriptExecutor executor = (JavascriptExecutor)driver;
                actions.moveToElement(dropdown, xOffset, 0);
                actions.click().build().perform();
                //executor.executeScript("arguments[0].click();", element);
                //driver.findElement(reserveSaveButton).click();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            } /*catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        //return new SummaryForFinancialsUnderEventsPage(driver);
    }
        /*Thread.sleep(2500);
        WebElement dropdown = driver.findElement(eventNumberArrow);
        int xOffset = 148/2 - 5;
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown, xOffset, 0);
        actions.click().build().perform();*/


    public void setEventNumberSearch(String eventNumber){
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        //Actions action = new Actions(driver);
        while(staleElement){
            try{
                Thread.sleep(400);
                WebElement element = driver.findElement(eventNumberSearch);
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                wait.until(ExpectedConditions.presenceOfElementLocated(eventNumberSearch));
                executor.executeScript("arguments[0].click();", element);
                driver.findElement(eventNumberSearch).sendKeys(eventNumber);
                //action.click(newExpenseCostEstimate);
                //action.sendKeys(element, eventNumber).build().perform();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException | InterruptedException e){
                staleElement = true;
            }
        }
    }

    public void clickEventSearchIcon(){
        driver.findElement(searchIcon).click();
    }

    public ExposuresUnderEventsPage clickExposuresOption() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        //Actions action = new Actions(driver);
        while(staleElement){
            try{
                WebElement element = driver.findElement(exposures);
                //JavascriptExecutor executor = (JavascriptExecutor)driver;
                wait.until(ExpectedConditions.presenceOfElementLocated(exposures));
                executor.executeScript("arguments[0].click();", element);
                //driver.findElement(eventNumberSearch).sendKeys(eventNumber);
                //action.click(newExpenseCostEstimate);
                //action.sendKeys(element, eventNumber).build().perform();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated((exposures)));
            driver.findElement(exposures).click();
        }
        catch (StaleElementReferenceException | ElementClickInterceptedException e){
            wait.until(ExpectedConditions.presenceOfElementLocated((exposures)));
            driver.findElement(exposures).click();
        }*/
        return new ExposuresUnderEventsPage(driver);
    }

    public SummaryForFinancialsUnderEventsPage clickFinancialsOption(){
        driver.findElement(financials).click();
        return new SummaryForFinancialsUnderEventsPage(driver);
    }

    public void clickActionsDropdown(){
        WebElement actionsDropdownElement = driver.findElement(actionsDropdown);
        try {
            if (actionsDropdownElement.isDisplayed()) {
                System.out.println("Clicking on element using java script click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", actionsDropdownElement);
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
        driver.findElement(reserveOptionUnderActions).click();
        return new SetReservesUnderEventsPage(driver);
    }

    public ExposuresUnderEventsPage clickExposureOptionOne() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        //Actions action = new Actions(driver);
        while(staleElement){
            try{
                WebElement element = driver.findElement(exposureOptionOne);
                wait.until(ExpectedConditions.presenceOfElementLocated(exposureOptionOne));
                executor.executeScript("arguments[0].click();", element);
                //driver.findElement(eventNumberSearch).sendKeys(eventNumber);
                //action.click(newExpenseCostEstimate);
                //action.sendKeys(element, eventNumber).build().perform();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        //driver.findElement(exposureOptionOne).click();
        return new ExposuresUnderEventsPage(driver);
    }

    public EventDetailsUnderEventsPage clickEventDetailsOption() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
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
}

