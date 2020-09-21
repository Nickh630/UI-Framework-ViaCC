package pages.events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SummaryForFinancialsUnderEventsPage extends BasePage {

    private final By financialsSummaryStatusAlert = By.id("ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:3");
    private final By updatedCurrentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[1]/td[5]/div");
    private final By pendingTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr/td[3]/div");
    private final By pendingSecondTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[2]/td[3]/div");
    //private final By pendingTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[2]/td[3]/div");
    private final By updatedCurrentExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[2]/td[5]/div");


    public SummaryForFinancialsUnderEventsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getFinancialsSummaryAlertText(){
        return driver.findElement(financialsSummaryStatusAlert).getText();
    }

    public String getCurrentLossCostEstimateFromFinancialsSummary(){
        return driver.findElement(updatedCurrentLossCostEstimate).getText();
    }

    public String getCurrentExpenseCostEstimateFromFinancialsSummary(){
        return driver.findElement(updatedCurrentExpenseCostEstimate).getText();
    }

    public void pageRefreshForAcesProcessing() throws InterruptedException {
        try {
            int counter = 0;
            do {
                Thread.sleep(1000);
                driver.navigate().refresh();
                Thread.sleep(2000);
                counter++;
            }
            while (driver.findElements(financialsSummaryStatusAlert).size() > 0 && counter < 10);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getPendingTransactionAmount(){
        return driver.findElement(pendingTransactionPrice).getText();
    }

    public String getSecondPendingTransactionAmount(){
        return driver.findElement(pendingSecondTransactionPrice).getText();
    }
}