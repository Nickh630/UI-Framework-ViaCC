package pages;

import org.openqa.selenium.*;
import pages.events.EventsPage;

public class SearchPage {

    private WebDriver driver;
    private By searchByDropDownField = By.id("ClaimSearch:ClaimSearchScreen:ClaimSearchDV:ClaimSearchRequiredInputSet:LMClaimSearchByNumType-inputEl");
    private By eventNumberDropDownOption = By.cssSelector("#boundlist-1863-listEl > ul > li:nth-child(6)");
    private By eventNumberSearchField = By.id("ClaimSearch:ClaimSearchScreen:ClaimSearchDV:ClaimSearchRequiredInputSet:ClaimNumber-inputEl");
    private By eventSearchButton = By.id("ClaimSearch:ClaimSearchScreen:ClaimSearchDV:ClaimSearchAndResetInputSet:Search");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSearchByDropDown(){
        driver.findElement(searchByDropDownField).click();
    }

    public void clickEventOptionUnderSearchBy(){
        driver.findElement(eventNumberDropDownOption).click();
    }

    public void setEventNumberSearch(String eventNumber) {
        driver.findElement(eventNumberSearchField).sendKeys(eventNumber);
    }

    public EventsPage clickEventSearchButton(){
        driver.findElement(eventSearchButton).click();
        return new EventsPage(driver);
    }
}
