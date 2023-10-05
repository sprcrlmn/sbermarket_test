package web.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import web.page.MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static web.core.CommonActions.initialisation;
import static web.webData.constants.Waiting.EXPLICIT_WAIT;

public class BaseTest {

    protected Properties property = new Properties();
    protected WebDriver driver;
    protected MainPage mainPage;
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        try {
            property.load(new FileInputStream("src/main/resources/configdata.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Файл не найден");
        }
        String URL = property.getProperty("mainURL");
        driver = initialisation();
        mainPage = MainPage.getInstance(driver);
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
    }

    //@AfterClass
    //public void tearDown() {
        //driver.close();
        //driver.quit();

    //}

}
