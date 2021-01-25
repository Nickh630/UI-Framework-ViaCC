package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class NewPropertyIncidentUnderEventsPage extends BasePage {

    public NewPropertyIncidentUnderEventsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
    }

    private final By newIncidentOkButton = By.id("NewFixedPropertyIncidentPopup:NewFixedPropertyIncidentScreen:Update-btnInnerEl");

    public void clickPropertyIncidentOkButton() {
        WebElement ButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(newIncidentOkButton));
        ButtonEle.click();
    }
}
