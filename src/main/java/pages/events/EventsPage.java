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
    private final By eventStatusText = By.id("Claim:ClaimInfoBar:State-btnInnerEl");
    private final By reopenEventButton = By.id("Claim:ClaimMenuActions:ClaimFileMenuItemSet:ClaimMenuActions_ClaimActions:ClaimMenuActions_ReopenClaim-textEl");
    private final By reopenClaim = By.id("ReopenClaimPopup:ReopenClaimScreen:Update-btnInnerEl");
    private final By chooseByExposureButton = By.id("Claim:ClaimMenuActions:ClaimMenuActions_NewExposure:NewExposureMenuItemSet:NewExposureMenuItemSet_ByCoverage-textEl");
    private final By contractLevelCoverageDropdown = By.id("Claim:ClaimMenuActions:ClaimMenuActions_NewExposure:NewExposureMenuItemSet:NewExposureMenuItemSet_ByCoverage:0:item-textEl");
    private final By buildingDropdown = By.id("Claim:ClaimMenuActions:ClaimMenuActions_NewExposure:NewExposureMenuItemSet:NewExposureMenuItemSet_ByCoverage:0:item:0:item-textEl");
    private final By liabilityPropertyDamageDropdown = By.id("Claim:ClaimMenuActions:ClaimMenuActions_NewExposure:NewExposureMenuItemSet:NewExposureMenuItemSet_ByCoverage:0:item:0:item-textEl");
    private final By liabilityPropertyDamageDropdownUnderLPD = By.id("Claim:ClaimMenuActions:ClaimMenuActions_NewExposure:NewExposureMenuItemSet:NewExposureMenuItemSet_ByCoverage:0:item:0:item:0:item-textEl");
    private final By exposureFilterButtonGL = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td/div/div[2]/div/div/div[1]/div/span");
    private final By exposureFilterButtonProp = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td/div/div[3]/div/div/div[1]/div/span");
                                                    ///html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td/div/div[3]/div/div/div[1]
     private final By exposureFilterButtonAuto = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td/div/div[3]/div/div/div[1]/div/span");
                                                    ///html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[5]/td/div/div[3]/div/div/div[1]
    private final By topExposureNumber = By.id("ClaimSummary:ClaimSummaryScreen:ClaimSummaryExposuresLV:0:Order");
    private final By premisesPropertyDamageDropdown = By.id("Claim:ClaimMenuActions:ClaimMenuActions_NewExposure:NewExposureMenuItemSet:NewExposureMenuItemSet_ByCoverage:0:item:1:item-textEl");
    private final By maturityLevelText = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailDV:PropertyDamageDV:LMExposureOverallCommonInputSet:Exposure_ValidationLevel-inputEl");

    public EventsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
    }

    public void clickEventsDropdown() throws InterruptedException {
        boolean staleElement = true;
        int xOffset = 148/2 - 5;
        //int xOffset = 108/2 - 5;
        //WebElement dropdown = driver.findElement(eventNumberArrow);
        while(staleElement){
            try{
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
        while(staleElement){
            try{
                WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(eventNumberSearch));
                executor.executeScript("arguments[0].click();", element);
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
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return new ExposuresUnderEventsPage(driver);
    }

    public SummaryForFinancialsUnderEventsPage clickFinancialsOption(){
        WebElement financialsEle = fluentWait.until(ExpectedConditions.elementToBeClickable(financials));
        financialsEle.click();
        return new SummaryForFinancialsUnderEventsPage(driver);
    }

    public void clickActionsDropdown(){
        WebElement actionsDropdownElement = fluentWait.until(ExpectedConditions.presenceOfElementLocated(actionsDropdown));
        try {
            if (actionsDropdownElement.isDisplayed()) {
                WebElement actionsEle = fluentWait.until(ExpectedConditions.elementToBeClickable(actionsDropdown));
                executor.executeScript("arguments[0].click();", actionsEle);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            System.out.println( e.getStackTrace());
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
                //WebElement element = driver.findElement(exposureOptionOne);
                WebElement element= wait.until(ExpectedConditions.elementToBeClickable(exposureOptionOne));
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
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(eventDetails));
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

    /*public int statusOfEventOpen() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        int element = driver.findElements(eventStatusText).size();
        return element;
    }*/

    public String statusOfEventOpen() {
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(eventStatusText));
        return element.getText();
    }

    public void clickReopenEventOption() {
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(reopenEventButton));
        element.click();
    }

    public ExposuresUnderEventsPage clickReopenClaimOption() {
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(reopenClaim));
        element.click();
        return new ExposuresUnderEventsPage(driver);
    }

    public void clickChooseByExposure() {
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(chooseByExposureButton));
        element.click();
    }

    public void clickContractLevelCoverage() {
        WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(contractLevelCoverageDropdown));
        element.click();
    }

    public NewExposureBuildingPage clickBuildingNewExposure() {
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(buildingDropdown));
        element.click();
        return new NewExposureBuildingPage(driver);
    }

    public void clickLiabilityPropertyDamageDropSide() {
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(liabilityPropertyDamageDropdown));
        element.click();
    }

    public NewExposurePropertyDamagePage clickPremisesPropertyDamageDropSide() {
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(premisesPropertyDamageDropdown));
        element.click();
        return new NewExposurePropertyDamagePage(driver);
    }

    public NewExposurePropertyDamagePage clickLiabilityPropertyDamageUnderLPDDropSide() {
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(liabilityPropertyDamageDropdownUnderLPD));
        element.click();
        return new NewExposurePropertyDamagePage(driver);
    }

    public void clickExposureFilterProp() {
        /*try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(exposureFilterButtonProp));
        element.click();
        //executor.executeScript("arguments[0].click();", element);
       /* WebElement exposureNumEle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(topExposureNumber));
        String exposureString = exposureNumEle.getText();
        if(exposureString.equals("1")){
            fluentWait.until(ExpectedConditions.elementToBeClickable(exposureFilterButtonProp));
            element.click();
        }*/
    }

    public void clickExposureFilterAuto() {
        WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(exposureFilterButtonAuto));
        executor.executeScript("arguments[0].click();", element);
       /* WebElement exposureNumEle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(topExposureNumber));
        String exposureString = exposureNumEle.getText();
        if(exposureString.equals("1")){
            fluentWait.until(ExpectedConditions.elementToBeClickable(exposureFilterButtonAuto));
            executor.executeScript("arguments[0].click();", element);
        }*/
    }

    public void clickExposureFilterGL() {
        WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(exposureFilterButtonGL));
        element.click();
        /*WebElement exposureNumEle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(topExposureNumber));
        String exposureString = exposureNumEle.getText();
        if(exposureString.equals("1")){
            fluentWait.until(ExpectedConditions.elementToBeClickable(exposureFilterButtonGL));
            executor.executeScript("arguments[0].click();", element);
        }*/
    }

    public int getExposureNumber() {
        String exposureString = null;
        try {
            Thread.sleep(300);
            WebElement exposureNumEle = fluentWait.until(ExpectedConditions.elementToBeClickable(topExposureNumber));
            exposureString = exposureNumEle.getText();
        } catch (InterruptedException | StaleElementReferenceException e) {
            e.printStackTrace();
        }
        assert exposureString != null;
        return Integer.parseInt(exposureString);
       /* try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement exposureNumEle = fluentWait.until(ExpectedConditions.elementToBeClickable(topExposureNumber));
        String exposureString = exposureNumEle.getText();
        return Integer.parseInt(exposureString);*/
    }

    public String getMaturityLevelOption() {
        WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(maturityLevelText));
        return element.getText();
    }
}

