import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import web.core.BaseTest;
import web.page.MainPage;
import web.page.MaxReviewPhonePage;
import web.page.MobilePhonePage;

public class webTest extends BaseTest {
    @Test()
    public void marketTest() {
        try {
            driver.get("https://megamarket.ru/");
        } catch (TimeoutException ignore) {
        }

        MainPage mainPage = MainPage.getInstance(driver);
        mainPage.clickOnCatalog();
        mainPage.clickOnMobilePhoneCatalog();
        MobilePhonePage mobilePhonePage = MobilePhonePage.getInstance(driver);
        mobilePhonePage.sendKeyToPrice();
        mobilePhonePage.clickOnAndroidCheckBox();
        try {
            Thread.sleep(8000); // Приостановить выполнение на 2 секунды
        } catch (InterruptedException e) {
            // Обработка исключения, если поток был прерван
        }
        System.out.println(mobilePhonePage.maxReview());
        mobilePhonePage.clickOnMaxReviewPhone();
        try {
            Thread.sleep(5000); // Приостановить выполнение на 2 секунды
        } catch (InterruptedException e) {
            // Обработка исключения, если поток был прерван
        }
        MaxReviewPhonePage maxReviewPhonePage = MaxReviewPhonePage.getInstance(driver);

        maxReviewPhonePage.getBuyButton().isDisplayed();
        maxReviewPhonePage.getBuyButton().isEnabled();
    }

}
