package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private final WebDriver driver;
    private final By statusAlert = By.cssSelector("#DesktopActivities\\:DesktopActivitiesScreen\\:0");
    private final By eventsTab = By.id("TabBar:ClaimTab-btnInnerEl");
    private final By searchTab = By.id("TabBar:SearchTab-btnInnerEl");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

   /* public void clickEventsTab(){
        driver.findElement(eventsTab).click();
    }*/

    public EventsPage clickEventsPage(){
        driver.findElement(eventsTab).click();
        return new EventsPage(driver);
    }

    public SearchPage clickSearchPage(){
        driver.findElement(searchTab).click();
        return new SearchPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
