package pages.events;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

public class SetReservesUnderEventsPage extends BasePage {

    private final By currentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[5]/div");
    private final By reserveSaveButton = By.id("NewReserveSet:NewReserveSetScreen:Update-btnInnerEl");
    private final By softWarningMessage = By.className("message");
    private final By validationResultsAlert = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:ttlBar");
    private final By clearButtonForAlert = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl");
    private final By newLossCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div");
    private final By currentExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[5]/div");
    private final By newExpenseCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[6]/div");
    private Integer costEstimateInteger;
    //public Actions action = new Actions(driver);

    public SetReservesUnderEventsPage(WebDriver driver){
        this.driver = driver;
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

    public String getSoftWarningValidationResults(){
        return driver.findElement(softWarningMessage).getText();
    }

    public SummaryForFinancialsUnderEventsPage clickSaveButtonForSetReserves(){
        boolean staleElement = true;
        while(staleElement){
            try{
                driver.findElement(reserveSaveButton).click();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return new SummaryForFinancialsUnderEventsPage(driver);
    }

    public String getValidationResultsWaringPopUp(){
        return driver.findElement(validationResultsAlert).getText();
    }

    public void clickClearButtonForValidationResultsAlert(){
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

    public void findAndConvertValueOfExpenseCostEstimateByAddingOne(){
        String costEstimateString = driver.findElement(currentExpenseCostEstimate).getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewExpenseCostPlusOne();
    }

    public void sendNewExpenseCostPlusOne(){
        costEstimateInteger = costEstimateInteger + 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        System.out.println(costEstimateInteger);
        WebElement newExpenseCostEstimate = driver.findElement(newExpenseCostEstimateField);
        Actions action = new Actions(driver);
        action.click(newExpenseCostEstimate).sendKeys(costEstimateString).perform();
    }

    public void findAndConvertValueOfExpenseCostEstimateBySubtractingOne(){
        String costEstimateString = driver.findElement(currentExpenseCostEstimate).getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewExpenseCostMinusOne();
    }

    public void sendNewExpenseCostMinusOne(){
        costEstimateInteger = costEstimateInteger - 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        System.out.println(costEstimateInteger);
        WebElement newExpenseCostEstimate = driver.findElement(newExpenseCostEstimateField);
        Actions action = new Actions(driver);
        action.click(newExpenseCostEstimate).sendKeys(costEstimateString).perform();
    }
}

