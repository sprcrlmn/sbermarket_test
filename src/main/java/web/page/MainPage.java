package web.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.core.BasePage;
import org.openqa.selenium.interactions.Actions;
import web.webData.constants.Waiting;

import java.time.Duration;

import static web.webData.constants.Waiting.EXPLICIT_WAIT;
import static web.webData.constants.Waiting.IMPLICIT_WAIT;

@Getter
public class MainPage extends BasePage {

    private static MainPage instance;

    private MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public static MainPage getInstance(WebDriver webDriver) {
        if (instance == null)
            instance = new MainPage(webDriver);
        return instance;
    }
    Actions actions = new Actions(driver);

    @FindBy(className = "header-menu")
    private WebElement catalog;

    @FindBy (xpath = "//a[@href='/catalog/elektronika/']")
    private WebElement electronicaCatalog;

    @FindBy (xpath = "//a[@href='/catalog/mobilnye-telefony-i-aksessuary/']")
    private WebElement mobilePhoneAndAccessoriesCatalog;

    @FindBy (xpath = "//a[@href='/catalog/mobilnye-telefony/']")
    private WebElement mobilePhoneCatalog;

    public MainPage clickOnCatalog(){
        catalog.click();
        return this;
    }

    public MainPage clickOnMobilePhoneCatalog(){
        wait.until(ExpectedConditions.visibilityOf(electronicaCatalog));
        actions.moveToElement(electronicaCatalog).perform();
        wait.until(ExpectedConditions.visibilityOf(mobilePhoneAndAccessoriesCatalog));
        actions.moveToElement(mobilePhoneAndAccessoriesCatalog).perform();
        actions.moveToElement(mobilePhoneCatalog).perform();
        mobilePhoneCatalog.click();
        return this;
    }
}
