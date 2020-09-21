package pages.events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ExposuresUnderEventsPage extends BasePage {

    private final By collisionNoOne = By.id("ClaimExposures:ClaimExposuresScreen:ExposuresLV:0:Order");
    private final By editReserve = By.id("ExposureDetail:ExposureDetailScreen:ExposureDetailScreen_CreateReserveButton-btnInnerEl");

    public ExposuresUnderEventsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCollisionExposureNoOne(){
        driver.findElement(collisionNoOne).click();
    }
    public SetReservesUnderEventsPage clickEditReserveButton(){
        driver.findElement(editReserve).click();
        return new SetReservesUnderEventsPage(driver);
    }
}
