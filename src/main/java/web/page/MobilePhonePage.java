package web.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import web.core.BasePage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MobilePhonePage extends BasePage {

    private static MobilePhonePage instance;

    private MobilePhonePage(WebDriver webDriver) {
        super(webDriver);
    }

    public static MobilePhonePage getInstance(WebDriver webDriver) {
        if (instance == null)
            instance = new MobilePhonePage(webDriver);
        return instance;
    }
    Actions actions = new Actions(driver);

    @FindBy(xpath = "//div[contains(text(), 'Цена')]/following-sibling::*//label[1]/input")
    private WebElement priceFromInput;

    @FindBy(xpath = "//div[contains(text(), 'Цена')]/following-sibling::*//label[2]/input")
    private WebElement priceToInput;

    @FindBy(xpath = "//span[@title = 'Android']")
    private WebElement checkBoxAndroid;

    @FindAll({
            @FindBy(xpath = "//div[@class= 'review-amount']")
    })
    private List<WebElement> reviewList;

    public MobilePhonePage sendKeyToPrice(){
        priceFromInput.clear();
        priceFromInput.sendKeys("5125");
        priceToInput.clear();
        priceToInput.sendKeys("10123");
        return this;
    }
    public MobilePhonePage clickOnAndroidCheckBox(){
        checkBoxAndroid.click();
        return this;
    }

    public MobilePhonePage maxReview(){
        List<Integer> numbers = reviewList.stream()
                .map(element -> Integer.valueOf(element.getText()))
                .collect(Collectors.toList());
        System.out.println(Collections.max(numbers));
        return this;
    }
    public MobilePhonePage clickOnMaxReviewPhone(){
        getMaxReviewPhone().click();
        return this;
    }
    public WebElement getMaxReviewPhone() {
        WebElement maxReviewPhone = reviewList.stream()
                .max(Comparator.comparingInt(element -> Integer.parseInt(element.getText())))
                .get();
        return maxReviewPhone;
    }

}
