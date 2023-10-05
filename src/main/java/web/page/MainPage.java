package web.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.core.BasePage;
import org.openqa.selenium.interactions.Actions;

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

    public MainPage clickOnCatalog(){
        catalog.click();
        return this;
    }

    @FindBy (xpath = "//div[@class='header-catalog-menu-item__title'][contains(text(), 'Электроника')]")
    private WebElement electronicaCatalog;

    @FindBy (xpath = "//div[@class='header-catalog-menu-item__title'][contains(text(), 'Мобильные телефоны и аксессуары')]")
    private WebElement mobilePhoneAndAccessoriesCatalog;

    @FindBy (xpath = "//div[@class='header-catalog-menu-item__title'][normalize-space(text())='Мобильные телефоны']")
    private WebElement mobilePhoneCatalog;

    public MainPage clickOnMobilePhoneCatalog(){
        actions.moveToElement(electronicaCatalog).perform();
        actions.moveToElement(mobilePhoneAndAccessoriesCatalog).perform();
        mobilePhoneCatalog.click();
        return this;
    }
}
