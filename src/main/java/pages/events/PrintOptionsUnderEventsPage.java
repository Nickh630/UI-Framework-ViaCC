package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PrintOptionsUnderEventsPage extends BasePage {

    private final By printButton = By.id("ClaimPrintout:ClaimPrintoutScreen:ClaimPrint-btnInnerEl");
    private final By currentEventsRadioButton = By.id("ClaimPrintout:ClaimPrintoutScreen:ClaimPrintoutPrintoutDV:CurrentClaimFilePagePrintWithDetailsChoice_Choice-inputEl");
    private final By includingDetailsRadioButton = By.id("ClaimPrintout:ClaimPrintoutScreen:ClaimPrintoutPrintoutDV:AllClaimPagesWithDetailsChoice_Choice-inputEl");

    public PrintOptionsUnderEventsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
    }

    public void clickPrintButton() throws InterruptedException {
        boolean staleElement = true;
        while (staleElement) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(printButton));
                driver.findElement(printButton).click();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
    }

    public void clickIncludingDetailsRadioButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(includingDetailsRadioButton));
        driver.findElement(includingDetailsRadioButton).click();
    }

    public void tabToPDFDownload() throws InterruptedException {
        //driver.findElement(currentEventsRadioButton).click();
        action.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
        Thread.sleep(3000);
    }

    public boolean isFileDownloaded(String downloadPath, String fileName){
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();
        for (int i = 0; i < Objects.requireNonNull(dir_contents).length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                flag = true;
            System.out.println(flag);
            System.out.println(dir);
            System.out.println(fileName);
        }
        return flag;
    }

    public void deleteFileDownloaded(String fileLocation){
        File downloadedFile = new File(fileLocation);
        downloadedFile.deleteOnExit();
    }

    public void waitForFileDownload(String fileLocation) throws InterruptedException {
        File downloadedFile = new File(fileLocation);
        while(downloadedFile.length() == 0){
            Thread.sleep(100);
        }
    }
}
