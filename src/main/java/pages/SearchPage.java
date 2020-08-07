package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SearchPage {

    private WebDriver driver;
    private By searchByDropDownField = By.id("ClaimSearch:ClaimSearchScreen:ClaimSearchDV:ClaimSearchRequiredInputSet:LMClaimSearchByNumType-inputEl");
    private By eventNumberDropDownOption = By.cssSelector("#boundlist-1863-listEl > ul > li:nth-child(6)");
            //.id("ext-gen4894");
    private By eventNumberSearchField = By.id("ClaimSearch:ClaimSearchScreen:ClaimSearchDV:ClaimSearchRequiredInputSet:ClaimNumber-inputEl");
    private By eventSearchButton = By.id("ClaimSearch:ClaimSearchScreen:ClaimSearchDV:ClaimSearchAndResetInputSet:Search");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSearchByDropDown(){
        driver.findElement(searchByDropDownField).click();
    }

    public void clickEventOptionUnderSearchBy(){

       /*WebElement element = driver.findElement(By.id("ext-gen4894"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);*/
        driver.findElement(eventNumberDropDownOption).click();
    }

    public void setEventNumberSearch(String eventNumber) {
        driver.findElement(eventNumberSearchField).sendKeys(eventNumber);
    }

    /*public void clickEventSearchButton(){
        driver.findElement(eventSearchButton).click();
    }*/

    public EventsPage clickEventSearchButton(){
        driver.findElement(eventSearchButton).click();
        return new EventsPage(driver);
    }
}
