import org.testng.annotations.Test;
import web.core.BaseTest;
import web.page.MaxReviewPhonePage;
import web.page.MobilePhonePage;

public class webTest extends BaseTest {
    @Test()
    public void marketTest() {
        MobilePhonePage mobilePhonePage = MobilePhonePage.getInstance(driver);
        MaxReviewPhonePage maxReviewPhonePage = MaxReviewPhonePage.getInstance(driver);
        mainPage.clickOnCatalog();
        mainPage.clickOnMobilePhoneCatalog();
        mobilePhonePage.sendKeyToPrice();
        mobilePhonePage.clickOnAndroidCheckBox();
        mobilePhonePage.maxReview();
        mobilePhonePage.clickOnMaxReviewPhone();
        maxReviewPhonePage.getBuyButton().isDisplayed();
        maxReviewPhonePage.getBuyButton().isEnabled();
    }

}
