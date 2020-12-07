package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class SummaryForFinancialsUnderEventsPage extends BasePage {

    private final By financialsSummaryStatusAlert = By.id("ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:3");
    private final By updatedCurrentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[1]/td[5]/div");
    private final By pendingTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr/td[3]/div");
    private final By pendingSecondTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[2]/td[3]/div");
    //private final By pendingTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[2]/td[3]/div");
    private final By updatedCurrentExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[2]/td[5]/div");
    private final By updatedExposureTwoCurrentExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[3]/td[5]/div");
    private final By financialSummaryTitle = By.id("ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:ttlBar");
    private final By rollUpPendingTransactionField = By.id("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[8]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr/td[3]/div");
    private final By rollUpNewTotalLCE = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[6]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr/td[4]/div");
    private final By financialsSummaryRollUpStatusAlert = By.id("ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:4");

    public SummaryForFinancialsUnderEventsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
    }

    public String getFinancialsSummaryAlertText(){
        boolean staleElement = true;
        String StatusAlertText = null;
        while(staleElement){
            try{
                WebElement statusAlertEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(financialsSummaryStatusAlert));
                StatusAlertText = statusAlertEle.getText();
                /*wait.until(ExpectedConditions.presenceOfElementLocated(financialsSummaryStatusAlert));
                StatusAlertText = driver.findElement(financialsSummaryStatusAlert).getText();*/
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return StatusAlertText;
    }

    public int presenceOfSummaryAlertText(){
        wait.until(ExpectedConditions.presenceOfElementLocated(financialsSummaryStatusAlert));
        int ele = driver.findElements(financialsSummaryStatusAlert).size();
        return ele;
    }

    public String getCurrentLossCostEstimateFromFinancialsSummary(){
        WebElement costEstimateEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(updatedCurrentLossCostEstimate));
        //return driver.findElement(updatedCurrentLossCostEstimate).getText();
        return costEstimateEle.getText();
    }

    public String getCurrentExpenseCostEstimateFromFinancialsSummary(){
        boolean staleElement = true;
        String statusAlertText = null;
        while(staleElement){
            try{
                WebElement costEstimateEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(updatedCurrentExpenseCostEstimate));
                //return driver.findElement(updatedCurrentExpenseCostEstimate).getText();
                statusAlertText = costEstimateEle.getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return statusAlertText;

    }

    public void pageRefreshForAcesProcessing() throws InterruptedException {
        try {
            int counter = 0;
            do {
                Thread.sleep(4000);
                driver.navigate().refresh();
                Thread.sleep(100);
                counter++;
            }
            while (driver.findElements(financialsSummaryStatusAlert).size() > 0 && counter < 10);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void pageRefreshOnRollUpForAcesProcessing() throws InterruptedException {
        try {
            int counter = 0;
            do {
                Thread.sleep(100);
                driver.navigate().refresh();
                Thread.sleep(4000);
                counter++;
            }
            while (driver.findElements(financialsSummaryRollUpStatusAlert).size() > 0 && counter < 10);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getPendingTransactionAmount(){
        boolean staleElement = true;
        String pendingTransactionPriceValue = null;
        while(staleElement){
            try{
                WebElement pendingTransField = fluentWait.until(ExpectedConditions.presenceOfElementLocated(pendingTransactionPrice));
                pendingTransactionPriceValue = pendingTransField.getText();
                //pendingTransactionPriceValue = driver.findElement(pendingTransactionPrice).getText();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return pendingTransactionPriceValue;
    }

    public String getCurrentLossCostForMultiFromFinancialsSummary(){
        WebElement updatedLCEEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(updatedCurrentLossCostEstimate));
        String lossCostString = updatedLCEEle.getText();
        lossCostString = lossCostString.substring(0, lossCostString.length() - 2).replaceAll("\\D+", "");
        return lossCostString;
    }

    public String getCurrentExpenseCostForMultiFromFinancialsSummary(){
        WebElement updatedECEEle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(updatedCurrentExpenseCostEstimate));
        String expenseCostString = updatedECEEle.getText();
        expenseCostString = expenseCostString.substring(0, expenseCostString.length() - 2).replaceAll("\\D+", "");
        return expenseCostString;
    }

    public String getFinancialsSummaryTitleHeader() {
       return driver.findElement(financialSummaryTitle).getText();
    }

    public String getCurrentExposureTwoLossCostForMultiFromFinancialsSummary() {
        wait.until(ExpectedConditions.presenceOfElementLocated(updatedExposureTwoCurrentExpenseCostEstimate));
        String lossCostString = driver.findElement(updatedExposureTwoCurrentExpenseCostEstimate).getText();
        lossCostString = lossCostString.substring(0, lossCostString.length() - 2).replaceAll("\\D+", "");
        return lossCostString;
    }

    public String getRollUpPendingTransactionAmount() {
        boolean staleElement = true;
        String rollUpAmount = null;
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(rollUpPendingTransactionField));
                rollUpAmount = driver.findElement(rollUpPendingTransactionField).getText();
                staleElement = false;
            } catch(NoSuchElementException | StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return rollUpAmount;
    }

    public String getRollUpLCEFromFinancialsSummary() {
        WebElement rollUpLCEEele = wait.until(ExpectedConditions.presenceOfElementLocated(rollUpNewTotalLCE));
        //String rollUpTotal = driver.findElement(rollUpNewTotalLCE).getText();
        String rollUpTotal = rollUpLCEEele.getText();
        return rollUpTotal;
    }

    /*public String getRollUpLCEFromFinancialsSummary() {
    }*/
}