package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;
    

    protected static final Logger logger =
              LogManager.getLogger(BaseTest.class);


    @BeforeMethod
    public void setup() throws IOException {

        logger.info("Browser setup started");

        prop = new Properties();
        FileInputStream fis =
                new FileInputStream("src/test/resources/config.properties");

        prop.load(fis);

        logger.info("Configuration file loaded");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        logger.info("Chrome browser launched");

        driver.manage().window().maximize();

        driver.get(prop.getProperty("url"));

        logger.info("Navigated to URL: " +
                prop.getProperty("url"));
    }
    @AfterMethod
    public void tearDown() {

        if (driver != null) {

            logger.info("Closing browser");

            driver.quit();

            logger.info("Browser closed");
        }
    }
}