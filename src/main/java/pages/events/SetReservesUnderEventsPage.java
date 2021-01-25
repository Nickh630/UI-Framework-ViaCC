package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class SetReservesUnderEventsPage extends BasePage {

    private final By currentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[5]/div");
    private final By reserveSaveButton = By.id("NewReserveSet:NewReserveSetScreen:Update-btnInnerEl");
    private final By softWarningMessage = By.className("message");
    private final By hardWarningMessage = By.className("message");
    private final By validationResultsAlert = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:ttlBar");
    private final By clearButtonForAlert = By.id("WebMessageWorksheet:WebMessageWorksheetScreen:WebMessageWorksheet_ClearButton-btnInnerEl");
    private final By newLossCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div");
    private final By newFirstRowLossCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr/td[6]/div");
    private final By newFourthRowLossCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[4]/td[6]/div");
    private final By currentExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[5]/div");
    private final By currentMultipleExpenseCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[5]/div");
    private final By newMultipleExpenseCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[6]/div");
    private final By newExpenseCostEstimateField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div");
    private final By newExpenseCostEstimateFieldForProp = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[1]/td[6]/div");
    private final By addButtonForReserve =By.id("NewReserveSet:NewReserveSetScreen:Add");
    private final By cancelButtonForReserve = By.id("NewReserveSet:NewReserveSetScreen:Cancel-btnInnerEl");
    private final By exposureTwoCurrentLossCostEstimate = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[3]/td[5]/div");
    private final By newExposureTwoLossCost = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[3]/td[6]/div");
    private final By rollUpTotalLossCost = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[7]/td/div/div[2]/div/table/tbody/tr/td[4]/div");
    //private final By reserveSumField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tfoot/tr/td[6]/div");
    private final By reserveSumField = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tfoot/tr/td[6]/div/a");
    private final By rollUpSumFieldForWarning = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tfoot/tr/td[6]/div/a");
    //private final By getRollUpTotalForWarning = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tfoot/tr/td[6]/div");
    private final By rollUpValidationResultsWarning = By.xpath("/html/body/div[1]/div[6]/div[2]/div/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/div");
    private Integer costEstimateInteger;
    private Integer totalRollupInteger;
    private final String threeK = "3000";
    private final String valueOfSixK = "6000";
    private final By costType = By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr/td[4]");

    public SetReservesUnderEventsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
    }

    public void findAndConvertValueOfLossCostEstimateByOne(){
        WebElement estimateEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(currentLossCostEstimate));
        String costEstimateString = estimateEle.getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewLostCostPlusOne();
    }

    public void sendNewLostCostPlusOne(){
        costEstimateInteger = costEstimateInteger + 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        wait.until(ExpectedConditions.presenceOfElementLocated(currentLossCostEstimate));
        WebElement newLossCostEstimate  = driver.findElement(By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div"));
        //action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();
    }

    public void findAndConvertValueOfLossCostEstimateBySubtractingOne(){
        wait.until(ExpectedConditions.presenceOfElementLocated(currentLossCostEstimate));
        String costEstimateString = driver.findElement(currentLossCostEstimate).getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewLostCostMinusOne();
    }

    public void sendNewLostCostMinusOne(){
        costEstimateInteger = costEstimateInteger - 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newLossCostEstimate  = driver.findElement(By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div"));
        //action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();
    }

    public void findAndConvertValueOfLossCostEstimateByAddingLargeAmount(){
        boolean staleElement = true;
        String costEstimateString = null;
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(currentLossCostEstimate));
                costEstimateString = driver.findElement(currentLossCostEstimate).getText();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewLostCostPlusTwentyK();
    }

    public void sendNewLostCostPlusTwentyK(){
        costEstimateInteger = costEstimateInteger + 20000;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newLossCostEstimate  = driver.findElement(By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div"));
        //action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();
    }

    public void findAndConvertValueOfLossCostEstimateBySubtractingLargeAmount(){
        boolean staleElement = true;
        String costEstimateString = null;
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(currentLossCostEstimate));
                costEstimateString = driver.findElement(currentLossCostEstimate).getText();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewLostCostMinusTwentyK();
    }

    public void sendNewLostCostMinusTwentyK(){
        costEstimateInteger = costEstimateInteger - 20000;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newLossCostEstimate  = driver.findElement(By.xpath("/html/body/div[1]/div[4]/table/tbody/tr/td/div/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[6]/div"));
        //action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();
    }

    public String getSoftWarningValidationResults(){
        //Took out SLEEP
        boolean staleElement = true;
        String validationResultsText = null;
        while(staleElement){
            try{
                WebElement element = fluentWait.until(ExpectedConditions.presenceOfElementLocated(softWarningMessage));
                //validationResultsText = driver.findElement(softWarningMessage).getText();
                validationResultsText = element.getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return validationResultsText;
    }

    public String getHardWarningValidationForPTDResults(){
        return driver.findElement(hardWarningMessage).getText();
    }

    public SummaryForFinancialsUnderEventsPage clickSaveButtonForSetReserves() throws InterruptedException {
        //Took out SLEEP
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement element = fluentWait.until( ExpectedConditions.elementToBeClickable(reserveSaveButton));
                //element.click();
                //WebElement element = driver.findElement(reserveSaveButton);
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return new SummaryForFinancialsUnderEventsPage(driver);
    }

    public String getValidationResultsWaringPopUp(){
        boolean staleElement = true;
        String validationResultsText = null;
        while(staleElement){
            try{
                fluentWait.until(ExpectedConditions.visibilityOfElementLocated(validationResultsAlert));
                validationResultsText = driver.findElement(validationResultsAlert).getText();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return validationResultsText;
    }

    public String getRollUpValidationResultsWaringPopUp(){
        boolean staleElement = true;
        String validationResultsText = null;
        while(staleElement){
            try{
                WebElement validationResultsWarningEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(rollUpValidationResultsWarning));
                //validationResultsText = driver.findElement(rollUpValidationResultsWarning).getText();
                validationResultsText = validationResultsWarningEle.getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return validationResultsText;
    }

    public void clickClearButtonForValidationResultsAlert(){
        boolean staleElement = true;
        //WebElement clearButtonForAlertElement = driver.findElement(clearButtonForAlert);
        while(staleElement){
            try{
                //fluentWait.until(ExpectedConditions.presenceOfElementLocated(clearButtonForAlert));
                WebElement clearButtonForAlertElement = fluentWait.until(ExpectedConditions.elementToBeClickable(clearButtonForAlert));
               try{
                   executor.executeScript("arguments[0].click();", clearButtonForAlertElement);
                   staleElement = false;
               }catch (WebDriverException ie){
                   staleElement = true;
                System.out.println(ie);
               }
               }catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
            }
    }

    public void resetLossCostEstimateToThirtyK(){
        WebElement newLossCostEstimate  = fluentWait.until(ExpectedConditions.elementToBeClickable(newLossCostEstimateField));
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, "30000").build().perform();
    }

    public void setLossCostEstimateToFifteenK(){
        WebElement newLossCostEstimate = fluentWait.until(ExpectedConditions.elementToBeClickable(newExpenseCostEstimateField));
        //WebElement newLossCostEstimate  = driver.findElement(newLossCostEstimateField);
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, "15000").build().perform();
    }

    public void setRowOneLossCostEstimateToFifteenK(){
        WebElement newLossCostEstimate = fluentWait.until(ExpectedConditions.elementToBeClickable(newFirstRowLossCostEstimateField));
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, "15000").build().perform();
    }

    public void setRowTwoEstimateToSixK(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newLossCostEstimateField));
        WebElement newLossCostEstimate  = driver.findElement(newLossCostEstimateField);
        action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, valueOfSixK).build().perform();
        //action.sendKeys(Keys.TAB, Keys.TAB, "6000").build().perform();
    }

    public void setRowFourEstimateToSixK() throws InterruptedException {
        //Thread.sleep(600);
        WebElement newLossCostEstimateEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(newFourthRowLossCostEstimateField));
        action.sendKeys(newLossCostEstimateEle, valueOfSixK).build().perform();
    }

    public void findAndConvertValueOfExpenseCostEstimateByAddingOne(){
        WebElement currentEstimateEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(currentExpenseCostEstimate));
        String costEstimateString = currentEstimateEle.getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewExpenseCostPlusOne();
    }

    public void sendNewExpenseCostPlusOne(){
        costEstimateInteger = costEstimateInteger + 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newExpenseCostEstimateEle = fluentWait.until(ExpectedConditions.elementToBeClickable(newExpenseCostEstimateFieldForProp));
                //driver.findElement(newExpenseCostEstimateField);
        //action.click(newExpenseCostEstimate).sendKeys(costEstimateString).perform();
        action.click(newExpenseCostEstimateEle);
        action.sendKeys(newExpenseCostEstimateEle, costEstimateString).build().perform();
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
        //action.sendKeys(newExpenseCostEstimate, costEstimateString).build().perform();
        action.click(newExpenseCostEstimate).sendKeys(costEstimateString).build().perform();

    }

    public void findAndConvertValueOfExpenseCostEstimateBySubtractingOne(){
        WebElement currentEstimateEle = fluentWait.until(ExpectedConditions.presenceOfElementLocated(currentExpenseCostEstimate));
        String costEstimateString = currentEstimateEle.getText();
        costEstimateString = costEstimateString.substring(0, costEstimateString.length() - 2).replaceAll("\\D+", "");
        costEstimateInteger = Integer.parseInt(costEstimateString);
        sendNewExpenseCostMinusOne();
    }

    public void sendNewExpenseCostMinusOne(){
        costEstimateInteger = costEstimateInteger - 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newExpenseCostEstimateEle = fluentWait.until(ExpectedConditions.elementToBeClickable(newExpenseCostEstimateFieldForProp));
        action.click(newExpenseCostEstimateEle);
        action.sendKeys(newExpenseCostEstimateEle, costEstimateString).build().perform();
        /*WebElement newExpenseCostEstimate = driver.findElement(newExpenseCostEstimateField);
        action.click(newExpenseCostEstimate);
        action.sendKeys(newExpenseCostEstimate, costEstimateString).build().perform();*/
    }

    public void changeCostEstimateForLossCostTo3K(){
        WebElement newLossCostEstimateFieldAction = fluentWait.until(ExpectedConditions.elementToBeClickable(newLossCostEstimateField));
        newLossCostEstimateFieldAction.click();
        action.sendKeys(newLossCostEstimateFieldAction, threeK).build().perform();
    }

    public void changeCostEstimateForExpenseCostTo3K() throws InterruptedException {
        //Thread.sleep(600);
        //WebElement newExpenseCostEstimateFieldAction = driver.findElement(newExpenseCostEstimateField);
        WebElement newExpenseCostEstimateFieldAction = fluentWait.until(ExpectedConditions.elementToBeClickable(newExpenseCostEstimateField));
        newExpenseCostEstimateFieldAction.click();
        //driver.findElement(newExpenseCostEstimateField).click();
        action.sendKeys(newExpenseCostEstimateFieldAction, threeK).build().perform();
    }

    public String getNewMultiValueForLoss() {
        boolean staleElement = true;
        String storedValueForValidation = null;
        while(staleElement){
            try{
                WebElement lossCostFieldEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(newLossCostEstimateField));
                storedValueForValidation = lossCostFieldEle.getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return storedValueForValidation;
    }

    public String getNewMultiValueForExpense() {
        boolean staleElement = true;
        String storedValueForValidation = null;
        while(staleElement){
            try{
                WebElement multiECEEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(newMultipleExpenseCostEstimateField));
                storedValueForValidation = multiECEEle.getText();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return storedValueForValidation;
    }

    public void clickAddForReserve() {
        WebElement ele = fluentWait.until(ExpectedConditions.presenceOfElementLocated(addButtonForReserve));
        ele.click();
    }

    public SummaryForFinancialsUnderEventsPage clickCancelForReserve() {
        boolean staleElement = true;
        while(staleElement){
            try{
                WebElement element = driver.findElement(cancelButtonForReserve);
                wait.until(ExpectedConditions.presenceOfElementLocated(cancelButtonForReserve));
                executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return new SummaryForFinancialsUnderEventsPage(driver);
    }

    public void addValueInReserveForCancel() {
        WebElement newLossCostEstimate  = driver.findElement(newLossCostEstimateField);
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
        costEstimateInteger = costEstimateInteger + 1;
        String costEstimateString = Integer.toString(costEstimateInteger);
        WebElement newLossCostEstimate  = driver.findElement(newExposureTwoLossCost);
        action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
        /*action.click(newLossCostEstimate);
        action.sendKeys(newLossCostEstimate, costEstimateString).build().perform();*/
    }

    public String getNewMultiValueForExposureTwoLoss() {
        boolean staleElement = true;
        String storedValueForValidation = null;
        while(staleElement){
            try{
                WebElement multiValueEle = wait.until(ExpectedConditions.presenceOfElementLocated(newExposureTwoLossCost));
                //storedValueForValidation = driver.findElement(newExposureTwoLossCost).getText();
                storedValueForValidation = multiValueEle.getText();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return storedValueForValidation;
    }

    public String getRollUpLossCostValue() {
        boolean staleElement = true;
        String storedLossCost = null;
        while(staleElement){
            try{
                wait.until(ExpectedConditions.presenceOfElementLocated(rollUpTotalLossCost));
                storedLossCost = driver.findElement(rollUpTotalLossCost).getText();
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
        return storedLossCost;
    }

    public void convertAndSendRollUpLossCostPlusOne(String totalRollupValue) {
        totalRollupValue = totalRollupValue.substring(0, totalRollupValue.length() - 2).replaceAll("\\D+", "");
        totalRollupInteger = Integer.parseInt(totalRollupValue);
        totalRollupInteger = totalRollupInteger + 1;
        String costEstimateString = Integer.toString(totalRollupInteger);
        WebElement newLossCostEstimate  = driver.findElement(newLossCostEstimateField);
        action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
    }

    public void convertAndSendRollUpLossCostMinusOne(String totalRollupValue) {
        totalRollupValue = totalRollupValue.substring(0, totalRollupValue.length() - 2).replaceAll("\\D+", "");
        totalRollupInteger = Integer.parseInt(totalRollupValue);
        totalRollupInteger = totalRollupInteger - 1;
        String costEstimateString = Integer.toString(totalRollupInteger);
        WebElement newLossCostEstimate  = driver.findElement(newLossCostEstimateField);
        action.click(newLossCostEstimate).sendKeys(costEstimateString).perform();
    }

    public String getNewSumCostEstimate() {
        boolean staleElement = true;
        String rollUpSum = null;
        while(staleElement){
            try{
                //fluentWait.until(ExpectedConditions.visibilityOfElementLocated(reserveSumField)).isDisplayed();
                //rollUpSum = driver.findElement(reserveSumField).getText();
                WebElement sumEstimateEle = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(reserveSumField));
                rollUpSum = sumEstimateEle.getText();
                staleElement = false;
            } catch(NoSuchElementException | StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return rollUpSum;
    }


    public String getAndShortenNewRollUpSumCostEstimate() {
        boolean staleElement = true;
        String rollUpSum = null;
        while(staleElement){
            try{
                fluentWait.until(ExpectedConditions.visibilityOfElementLocated(rollUpSumFieldForWarning));
                //wait.until(ExpectedConditions.presenceOfElementLocated(rollUpSumFieldForWarning));
                rollUpSum = driver.findElement(rollUpSumFieldForWarning).getText();
                rollUpSum = rollUpSum.substring(0, rollUpSum.length() - 2).replaceAll("\\D+", "");
                staleElement = false;
            } catch(NoSuchElementException | StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return rollUpSum;
    }

    public void clickToUpdateValueInSumField() {
        WebElement ele = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(currentLossCostEstimate));
        action.click(ele);
        action.sendKeys(Keys.TAB).build().perform();
    }

    public void clickCostTypeOption() {
        WebElement ele = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(costType));
        ele.click();
    }

    public void selectLCEFromCostType(){
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(costType));
        action.sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER).build().perform();
    }

    public void setFirstNewCostEstimate(String firstRowInt ) {
        WebElement newLossCostEstimate = fluentWait.until(ExpectedConditions.elementToBeClickable(newLossCostEstimateField));
        action.click(newLossCostEstimate);
        action.sendKeys(firstRowInt).build().perform();
    }
}

