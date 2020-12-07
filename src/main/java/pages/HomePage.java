package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.events.EventsPage;

import java.time.Duration;

public class HomePage extends BasePage  {

    private final By statusAlert = By.cssSelector("#DesktopActivities\\:DesktopActivitiesScreen\\:0");
    //private final By eventsTab = By.id("TabBar:ClaimTab-btnInnerEl");
    private final By eventsTab = By.id("TabBar:ClaimTab");
    private final By searchTab = By.id("TabBar:SearchTab-btnInnerEl");
    private final By eventNumberArrow = By.id("TabBar:ClaimTab-btnWrap");
    private final By eventNumberSearch = By.xpath("//*[@id=\"TabBar:ClaimTab:ClaimTab_FindClaim-inputEl\"]");
    private final By searchIcon = By.id("TabBar:ClaimTab:ClaimTab_FindClaim_Button");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(400)).ignoring(NoSuchElementException.class);
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

    public void clickEventsTab(){
        driver.findElement(eventsTab).click();
    }

    public void clickEventsDropdown() throws InterruptedException {
        boolean staleElement = true;
        //int xOffset = 148/2 - 5;
        //int xOffset = 108/2;
        //WebElement dropdown = driver.findElement(eventNumberArrow);
        while(staleElement){
            try{
                //Thread.sleep(1100);
                WebElement dropdown = fluentWait.until(ExpectedConditions.elementToBeClickable(eventNumberArrow));
                int width = dropdown.getSize().getWidth();
                action.moveToElement(dropdown).moveByOffset((width/2) - 2, 0).click().perform();
                //action.moveToElement(dropdown, xOffset, 0);
                //action.click().build().perform();
                //executor.executeScript("arguments[0].click();", element);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
    }

    public void setEventNumberSearch(String eventNumber){
        //Check, No such Ele
        boolean staleElement = true;
        //WebElement element = driver.findElement(eventNumberSearch);
        while(staleElement){
            try{
                //Thread.sleep(400);
                WebElement element = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(eventNumberSearch));
                //WebElement element = driver.findElement(eventNumberSearch);
                executor.executeScript("arguments[0].click();", element);
                driver.findElement(eventNumberSearch).sendKeys(eventNumber);
                staleElement = false;
            } catch(StaleElementReferenceException | NoSuchElementException e){
                staleElement = true;
            }
        }
    }

    public EventsPage clickEventSearchIcon() throws InterruptedException {
        fluentWait.until(ExpectedConditions.elementToBeClickable(searchIcon));
        //Thread.sleep(2000);
        driver.findElement(searchIcon).click();
        return new EventsPage(driver);
    }

    public EventsPage clickEventsPage(){
        driver.findElement(eventsTab).click();
        return new EventsPage(driver);
    }

    public SearchPage clickSearchPage(){
        driver.findElement(searchTab).click();
        return new SearchPage(driver);
    }
}
