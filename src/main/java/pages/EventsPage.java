package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class EventsPage {

    private WebDriver driver;

    private By eventNumberSearch = By.xpath("//*[@id=\"TabBar:ClaimTab:ClaimTab_FindClaim-inputEl\"]");
    private By searchIcon = By.id("TabBar:ClaimTab:ClaimTab_FindClaim_Button");
    private By exposures = By.xpath("//*[@id=\"Claim:MenuLinks:Claim_ClaimExposures\"]/div");
    private By collisionNoOne = By.id("ClaimExposures:ClaimExposuresScreen:ExposuresLV:0:Order");
    private By editReserve = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailScreen_CreateReserveButton-btnInnerEl");
    private By currentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[5]/div");
    private By reserveSaveButton = By.id("NewReserveSet:NewReserveSetScreen:Update-btnInnerEl");
    private By financialsSummaryStatusAlert = By.id("ClaimFinancialsSummary:ClaimFinancialsSummaryScreen:3");
    private By updatedCurrentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr[1]/td[5]/div");
    private By pendingTransactionPrice = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/table/tbody/tr[2]/td/div/div[2]/div/table/tbody/tr/td[3]/div");
            //By.cssSelector("tr.x-grid-row.x-grid-row-alt.x-grid-data-row td.x-grid-cell.x-grid-td.x-grid-cell-headerId-gridcolumn-1213.gw-currency-positive.x-grid-cell-selected div.x-grid-cell-inner");
    //private By newLossCostEstimate = By.cssSelector("tr.x-grid-row.x-grid-row-alt.x-grid-data-row td.x-grid-cell.x-grid-td.x-grid-cell-headerId-gridcolumn-1155.x-grid-cell-last.g-cell-edit div.x-grid-cell-inner");
        //CLICK THIS /html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div
        //SENDKEYS   4/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div

    private Integer costEstimateInteger;


    public EventsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickEventsDropdown(){
        WebElement dropdown = driver.findElement(By.id("TabBar:ClaimTab-btnWrap"));
        int xOffset = 148/2 - 5;
        Actions actions = new Actions(driver);
        actions.moveToElement(dropdown, xOffset, 0);
        actions.click().build().perform();
    }

    public void setEventNumberSearch(String eventNumber){
        driver.findElement(eventNumberSearch).sendKeys(eventNumber);
    }

    public void clickEventSearchIcon(){
        driver.findElement(searchIcon).click();
    }

    public void clickExposuresOption(){
        driver.findElement(exposures).click();
    }

    public void clickCollisionExposureNoOne(){
        driver.findElement(collisionNoOne).click();
    }

    public void clickEditReserveButton(){
        driver.findElement(editReserve).click();
    }

    public void findAndConvertValueOfLossCostEstimate(){
        String costEstimateString = driver.findElement(currentLossCostEstimate).getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewLostCostPlusOne();
    }

    public void sendNewLostCostPlusOne(){
        costEstimateInteger = costEstimateInteger + 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newLossCostEstimate  = driver.findElement(By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div"));
        Actions action = new Actions(driver);
        action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
    }

    public void clickSaveButtonForSetReserves(){
        driver.findElement(reserveSaveButton).click();
    }

    public String getFinancialsSummaryAlertText(){
       return driver.findElement(financialsSummaryStatusAlert).getText();
    }

    public String getCurrentCostEstimateFromFinancialsSummary(){
        return driver.findElement(updatedCurrentLossCostEstimate).getText();
    }

    public String getPendingTransactionAmount(){
        return driver.findElement(pendingTransactionPrice).getText();
    }
}
