package web.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import static web.core.CommonActions.initialisation;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = initialisation();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Установите максимальное время ожидания в секундах

    }

    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
