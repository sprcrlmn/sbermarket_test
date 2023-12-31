package web.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import web.core.BasePage;


@Getter
public class MaxReviewPhonePage extends BasePage {
    Actions actions = new Actions(driver);
    private static MaxReviewPhonePage instance;

    private MaxReviewPhonePage(WebDriver webDriver) {
        super(webDriver);
    }

    public static MaxReviewPhonePage getInstance(WebDriver webDriver) {
        if (instance == null)
            instance = new MaxReviewPhonePage(webDriver);
        return instance;
    }

    @FindBy(xpath = "//div[@class = 'pdp-sales-block__button']")
    private WebElement buyButton;

}
