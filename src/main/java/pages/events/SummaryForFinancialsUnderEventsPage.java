package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class SummaryForFinancialsUnderEventsPage extends BasePage {

    private final By financialsSummaryStatusAlert = By.id("ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:3");
    private final By updatedCurrentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[1]/td[5]/div");
    private final By pendingTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr/td[3]/div");
    private final By pendingSecondTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[2]/td[3]/div");
    //private final By pendingTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[2]/td[3]/div");
    private final By updatedCurrentExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[2]/td[5]/div");
    private final By updatedExposureTwoCurrentExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[3]/td[5]/div");
    private final By financialSummaryTitle = By.id("ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:ttlBar");
    //WebDriverWait wait = new WebDriverWait(driver, 8);

    public SummaryForFinancialsUnderEventsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getFinancialsSummaryAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(financialsSummaryStatusAlert));
        return driver.findElement(financialsSummaryStatusAlert).getText();
    }

    public String getCurrentLossCostEstimateFromFinancialsSummary(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(updatedCurrentLossCostEstimate));
        return driver.findElement(updatedCurrentLossCostEstimate).getText();
    }

    public String getCurrentExpenseCostEstimateFromFinancialsSummary(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(updatedCurrentExpenseCostEstimate));
        return driver.findElement(updatedCurrentExpenseCostEstimate).getText();
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

    public String getPendingTransactionAmount(){
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        String pendingTransactionPriceValue = null;
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(pendingTransactionPrice));
                pendingTransactionPriceValue = driver.findElement(pendingTransactionPrice).getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return pendingTransactionPriceValue;
    }

    public String getCurrentLossCostForMultiFromFinancialsSummary(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(updatedCurrentLossCostEstimate));
        String lossCostString = driver.findElement(updatedCurrentLossCostEstimate).getText();
        lossCostString = lossCostString.substring(0, lossCostString.length() - 2).replaceAll("\\D+", "");
        return lossCostString;
    }

    public String getCurrentExpenseCostForMultiFromFinancialsSummary(){
        //driver.findElement(updatedCurrentExpenseCostEstimate).getText();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(updatedCurrentExpenseCostEstimate));
        String expenseCostString = driver.findElement(updatedCurrentExpenseCostEstimate).getText();
        System.out.println(expenseCostString);
        expenseCostString = expenseCostString.substring(0, expenseCostString.length() - 2).replaceAll("\\D+", "");
        System.out.println(expenseCostString);
        return expenseCostString;
    }

    public String getFinancialsSummaryTitleHeader() {
       return driver.findElement(financialSummaryTitle).getText();
    }

    public String getCurrentExposureTwoLossCostForMultiFromFinancialsSummary() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(updatedExposureTwoCurrentExpenseCostEstimate));
        String lossCostString = driver.findElement(updatedExposureTwoCurrentExpenseCostEstimate).getText();
        lossCostString = lossCostString.substring(0, lossCostString.length() - 2).replaceAll("\\D+", "");
        return lossCostString;
    }
}