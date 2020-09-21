package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class EventsPage extends BasePage {

    private By eventNumberArrow = By.id("TabBar:ClaimTab-btnWrap");
    private By eventNumberSearch = By.xpath("//*[@id=\"TabBar:ClaimTab:ClaimTab_FindClaim-inputEl\"]");
    private By searchIcon = By.id("TabBar:ClaimTab:ClaimTab_FindClaim_Button");
    private By exposures = By.xpath("//*[@id=\"Claim:MenuLinks:Claim_ClaimExposures\"]/div");

    public EventsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickEventsDropdown() throws InterruptedException {
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

    public ExposuresUnderEventsPage clickExposuresOption() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable((exposures)));
        driver.findElement(exposures).click();
        return new ExposuresUnderEventsPage(driver);
    }
}
