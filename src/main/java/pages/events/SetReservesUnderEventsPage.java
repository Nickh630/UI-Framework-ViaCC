package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class SetReservesUnderEventsPage extends BasePage {

    private final By currentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[5]/div");
    private final By reserveSaveButton = By.id("NewReserveSet:NewReserveSetScreen:Update-btnInnerEl");
    private final By softWarningMessage = By.className("message");
    private final By hardWarningMessage = By.className("message");
    private final By validationResultsAlert = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:ttlBar");
    private final By clearButtonForAlert = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl");
    private final By newLossCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div");
    private final By currentExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[5]/div");
    private final By currentMultipleExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[5]/div");
    private final By newMultipleExpenseCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[6]/div");
    private final By newExpenseCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[6]/div");
    private final By addButtonForReserve =By.id("NewReserveSet:NewReserveSetScreen:Add");
    private final By cancelButtonForReserve = By.id("NewReserveSet:NewReserveSetScreen:Cancel-btnInnerEl");
    private final By exposureTwoCurrentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[3]/td[5]/div");
    private final By newExposureTwoLossCost = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[3]/td[6]/div");
    private Integer costEstimateInteger;
    private final String threeK = "3000";
    public JavascriptExecutor executor = (JavascriptExecutor)driver;
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
        //add wait. no such element
        WebElement newLossCostEstimate  = driver.findElement(By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div"));
        Actions action = new Actions(driver);
        //action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();
    }

    public void findAndConvertValueOfLossCostEstimateBySubtractingOne(){
        String costEstimateString = driver.findElement(currentLossCostEstimate).getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewLostCostMinusOne();
    }

    public void sendNewLostCostMinusOne(){
        costEstimateInteger = costEstimateInteger - 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newLossCostEstimate  = driver.findElement(By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div"));
        Actions action = new Actions(driver);
        //action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();
    }

    public void findAndConvertValueOfLossCostEstimateByAddingLargeAmount(){
        //no such ele
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
        //action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();
    }

    public void findAndConvertValueOfLossCostEstimateBySubtractingLargeAmount(){
        //no such ele
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
        //action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();
    }

    public String getSoftWarningValidationResults(){
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        String validationResultsText = null;
        while(staleElement){
            try{
                Thread.sleep(800);
                WebElement element = driver.findElement(softWarningMessage);
                wait.until(ExpectedConditions.presenceOfElementLocated(softWarningMessage));
                validationResultsText = driver.findElement(softWarningMessage).getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return validationResultsText;
    }

    public String getHardWarningValidationForPTDResults(){
        return driver.findElement(hardWarningMessage).getText();
    }

    public SummaryForFinancialsUnderEventsPage clickSaveButtonForSetReserves(){
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        while(staleElement){
            try{
                Thread.sleep(600);
                wait.until(ExpectedConditions.presenceOfElementLocated(reserveSaveButton));
                WebElement element = driver.findElement(reserveSaveButton);
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                executor.executeScript("arguments[0].click();", element);
                //driver.findElement(reserveSaveButton).click();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return new SummaryForFinancialsUnderEventsPage(driver);
    }

    public String getValidationResultsWaringPopUp(){
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        String validationResultsText = null;
        while(staleElement){
            try{
                //Thread.sleep(800);
                //WebElement element = driver.findElement(validationResultsAlert);
                wait.until(ExpectedConditions.presenceOfElementLocated(validationResultsAlert));
                validationResultsText = driver.findElement(validationResultsAlert).getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            } /*catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        return validationResultsText;
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(validationResultsAlert));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return driver.findElement(validationResultsAlert).getText();*/
    }

    public void clickClearButtonForValidationResultsAlert(){
        WebElement clearButtonForAlertElement = driver.findElement(clearButtonForAlert);
        WebDriverWait wait = new WebDriverWait(driver, 8);
        for(int i=0; i<=2;i++){
            try{
                Thread.sleep(500);
                //if (clearButtonForAlertElement.isDisplayed()) {
                    wait.until(ExpectedConditions.presenceOfElementLocated(clearButtonForAlert));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clearButtonForAlertElement);
               /* } else {
                    System.out.println("Unable to click on element");
                }*/
                /*driver.findElement(clearButtonForAlert).click();
                break;*/
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void resetLossCostEstimateToThirtyK(){
        WebElement newLossCostEstimate  = driver.findElement(newLossCostEstimateField);
        Actions action = new Actions(driver);
        //action.click(newLossCostEstimate).sendKeys("30000").perform();
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, "30000").build().perform();
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
        WebElement newExpenseCostEstimate = driver.findElement(newExpenseCostEstimateField);
        Actions action = new Actions(driver);
        //action.click(newExpenseCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newExpenseCostEstimate);
        action.sendKeys(newExpenseCostEstimate, costEstimateString).build().perform();
    }

    public void findAndConvertValueForMultipleReserveOfExpenseCostEstimateByAddingOne(){
        String costEstimateString = driver.findElement(currentExpenseCostEstimate).getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewExpenseCostForMultiplePlusOne();
    }

    public void sendNewExpenseCostForMultiplePlusOne(){
        costEstimateInteger = costEstimateInteger + 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newExpenseCostEstimate = driver.findElement(newMultipleExpenseCostEstimateField);
        Actions action = new Actions(driver);
        //action.click(newExpenseCostEstimate);
        //action.sendKeys(newExpenseCostEstimate, costEstimateString).build().perform();
        action.click(newExpenseCostEstimate).sendKeys(costEstimateString).build().perform();

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
        action.click(newExpenseCostEstimate);
        action.sendKeys(newExpenseCostEstimate, costEstimateString).build().perform();
    }

    public void changeCostEstimateForLossCostTo3K(){
        WebElement newLossCostEstimateFieldAction = driver.findElement(newLossCostEstimateField);
        Actions action = new Actions(driver);
        driver.findElement(newLossCostEstimateField).click();
        action.sendKeys(newLossCostEstimateFieldAction, threeK).build().perform();
    }

    public void changeCostEstimateForExpenseCostTo3K() throws InterruptedException {
        Thread.sleep(600);
        WebElement newExpenseCostEstimateFieldAction = driver.findElement(newExpenseCostEstimateField);
        Actions action = new Actions(driver);
        driver.findElement(newExpenseCostEstimateField).click();
        action.sendKeys(newExpenseCostEstimateFieldAction, threeK).build().perform();
    }

    public String getNewMultiValueForLoss() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        String storedValueForValidation = null;
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(newLossCostEstimateField));
                storedValueForValidation = driver.findElement(newLossCostEstimateField).getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return storedValueForValidation;
    }

    public String getNewMultiValueForExpense() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        String storedValueForValidation = null;
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(newMultipleExpenseCostEstimateField));
                storedValueForValidation = driver.findElement(newMultipleExpenseCostEstimateField).getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return storedValueForValidation;
    }

    public void clickAddForReserve() {
        driver.findElement(addButtonForReserve).click();
    }

    public SummaryForFinancialsUnderEventsPage clickCancelForReserve() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        while(staleElement){
            try{
                WebElement element = driver.findElement(cancelButtonForReserve);
                JavascriptExecutor executor = (JavascriptExecutor)driver;
                wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonForReserve));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        //driver.findElement(cancelButtonForReserve).click();
        return new SummaryForFinancialsUnderEventsPage(driver);
    }

    public void addValueInReserveForCancel() {
        WebElement newLossCostEstimate  = driver.findElement(newLossCostEstimateField);
        Actions action = new Actions(driver);
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, "110").build().perform();
    }

    public void findAndConvertValueForMultipleExposureTwoLossCostByAddingOne() {
        String costEstimateString = driver.findElement(exposureTwoCurrentLossCostEstimate).getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewLostCostExposureTwoPlusOne();
    }

    public void sendNewLostCostExposureTwoPlusOne(){
        Actions action = new Actions(driver);
        costEstimateInteger = costEstimateInteger + 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newLossCostEstimate  = driver.findElement(newExposureTwoLossCost);
        action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        /*action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();*/
    }

    public String getNewMultiValueForExposureTwoLoss() {
        boolean staleElement = true;
        WebDriverWait wait = new WebDriverWait(driver, 8);
        String storedValueForValidation = null;
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(newExposureTwoLossCost));
                storedValueForValidation = driver.findElement(newExposureTwoLossCost).getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return storedValueForValidation;
    }
}

