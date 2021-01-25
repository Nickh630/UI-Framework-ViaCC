package pages.events;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class NewExposureBuildingPage extends BasePage {

    public NewExposureBuildingPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 8);
        this.action = new Actions(driver);
        this.executor = (JavascriptExecutor)driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
    }

    private final By newIncidentDropdownButton = By.id("NewExposure:NewExposureScreen:NewExposureDV:LMExpFixedPropIncidentInputSet:Property_Incident:Property_IncidentMenuIcon");
    private final By newIncidentOption = By.id("NewExposure:NewExposureScreen:NewExposureDV:LMExpFixedPropIncidentInputSet:Property_Incident:PropertyDamageDV_NewIncidentMenuItem-textEl");
    private final By buildingExposureUpdateButton = By.id("NewExposure:NewExposureScreen:Update-btnInnerEl");

    public void clickNewIncidentDropdownArrow(){
        WebElement ButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(newIncidentDropdownButton));
        ButtonEle.click();
    }

    public NewPropertyIncidentUnderEventsPage selectNewIncidentOption() {
        WebElement ButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(newIncidentOption));
        ButtonEle.click();
        return new NewPropertyIncidentUnderEventsPage(driver);
    }

    public ExposuresUnderEventsPage clickBuildingExposureUpdateButton() {
        WebElement ButtonEle = fluentWait.until(ExpectedConditions.elementToBeClickable(buildingExposureUpdateButton));
        ButtonEle.click();
        return new ExposuresUnderEventsPage(driver);
    }
}
