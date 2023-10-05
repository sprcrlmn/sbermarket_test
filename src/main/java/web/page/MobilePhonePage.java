package web.page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import web.core.BasePage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MobilePhonePage extends BasePage {
    Actions actions = new Actions(driver);
    private int maxReview;
    private static MobilePhonePage instance;

    private MobilePhonePage(WebDriver webDriver) {
        super(webDriver);
    }

    public static MobilePhonePage getInstance(WebDriver webDriver) {
        if (instance == null)
            instance = new MobilePhonePage(webDriver);
        return instance;
    }

    @FindBy(xpath = "//div[contains(text(), 'Цена')]/following-sibling::*//label[1]/input")
    private WebElement priceFromInput;

    @FindBy(xpath = "//div[contains(text(), 'Цена')]/following-sibling::*//label[2]/input")
    private WebElement priceToInput;

    @FindBy(xpath = "//span[@title = 'Android']")
    private WebElement checkBoxAndroid;

    public MobilePhonePage sendKeyToPrice(){
        wait.until(ExpectedConditions.visibilityOf(priceFromInput));
        priceFromInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        priceFromInput.sendKeys(Keys.DELETE);
        priceFromInput.sendKeys("5125");

        priceToInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        priceToInput.sendKeys(Keys.DELETE);
        priceToInput.sendKeys("10123");
        return this;
    }

    public MobilePhonePage clickOnAndroidCheckBox(){
        checkBoxAndroid.click();
        return this;
    }

    public int maxReview(){
        List<WebElement> reviewList = driver.findElements(By.xpath("//div[@class= 'review-amount']"));
        List<Integer> numbers = reviewList.stream()
                .map(element -> Integer.valueOf(element.getText()))
                .collect(Collectors.toList());
        maxReview = Collections.max(numbers);
        return maxReview;
    }

    public MobilePhonePage clickOnMaxReviewPhone(){
        getMaxReviewPhone().click();
        return this;
    }

    public WebElement getMaxReviewPhone(){
        String maxReviewPhoneXPath = String.format("//div[@class='review-amount'][contains(text(), '721')]/../../../../../../..", maxReview());
        WebElement maxReviewPhone = driver.findElement(By.xpath(maxReviewPhoneXPath));
        return maxReviewPhone;
    }

}
