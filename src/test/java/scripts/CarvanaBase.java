package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CarvanaHomePage;
import pages.CarvanaSearchCarPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CarvanaBase {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarvanaSearchCarPage carvanaSearchCarPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("appURL"));
        softAssert = new SoftAssert();
    }


    @AfterMethod
    public void teardown() {
        Driver.quitDriver();
    }
}
