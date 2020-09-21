package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventsPage extends BasePage {

    private WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 10);

    private By eventNumberArrow = By.id("TabBar:ClaimTab-btnWrap");
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
    private By softWarningMessage = By.className("message");
    private By validationResultsAlert = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:ttlBar");
    private By clearButtonForAlert = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl");
    private By newLossCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div");

    private Integer costEstimateInteger;

    public EventsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickEventsDropdown() throws InterruptedException {
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.(driver.findElement(eventNumberArrow)));*/
        Thread.sleep(2200);
        WebElement dropdown = driver.findElement(eventNumberArrow);
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable((exposures)));
        driver.findElement(exposures).click();
    }

    public void clickCollisionExposureNoOne(){
        driver.findElement(collisionNoOne).click();
    }

    public void clickEditReserveButton(){
        driver.findElement(editReserve).click();
    }

    public void findAndConvertValueOfLossCostEstimateByOne(){
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

    public void findAndConvertValueOfLossCostEstimateByAddingLargeAmount(){
        String costEstimateString = driver.findElement(currentLossCostEstimate).getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewLostCostPlusTwentyK();
    }

    public void sendNewLostCostPlusTwentyK(){
        costEstimateInteger = costEstimateInteger + 20000;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newLossCostEstimate  = driver.findElement(By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div"));
        Actions action = new Actions(driver);
        action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
    }

    public void findAndConvertValueOfLossCostEstimateBySubtractingLargeAmount(){
        String costEstimateString = driver.findElement(currentLossCostEstimate).getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewLostCostMinusTwentyK();
    }

    public void sendNewLostCostMinusTwentyK(){
        costEstimateInteger = costEstimateInteger - 20000;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newLossCostEstimate  = driver.findElement(By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div"));
        Actions action = new Actions(driver);
        action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
    }

    public void clickSaveButtonForSetReserves(){
        boolean staleElement = true;
        while(staleElement){
            try{
                driver.findElement(reserveSaveButton).click();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
    }

    public String getFinancialsSummaryAlertText(){
        return driver.findElement(financialsSummaryStatusAlert).getText();
    }

    public String getCurrentCostEstimateFromFinancialsSummary(){
        return driver.findElement(updatedCurrentLossCostEstimate).getText();
    }

    public void pageRefreshForAcesProcessing() throws InterruptedException {
        try {
            int counter = 0;
            do {
                Thread.sleep(1200);
                driver.navigate().refresh();
                Thread.sleep(2200);
                counter++;
            }
            while (driver.findElements(financialsSummaryStatusAlert).size() > 0 && counter < 15);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getPendingTransactionAmount(){
        return driver.findElement(pendingTransactionPrice).getText();
    }

    public String getSoftWarningValidationResults(){
        return driver.findElement(softWarningMessage).getText();
    }

    public String getValidationResultsWaringPopUp(){
        return driver.findElement(validationResultsAlert).getText();
    }

    public void clickClearButtonForValidationResultsAlert() throws InterruptedException {
        //Thread.sleep(2000);
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.elementToBeClickable((clearButtonForAlert)));
        for(int i=0; i<=2;i++){
            try{
                driver.findElement(clearButtonForAlert).click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void resetLossCostEstimateToThirtyK(){
        WebElement newLossCostEstimate  = driver.findElement(newLossCostEstimateField);
        Actions action = new Actions(driver);
        action.click(newLossCostEstimate).sendKeys("30000").perform();
    }
}
