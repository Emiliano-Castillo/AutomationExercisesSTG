package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;

public class BaseTest {

    protected WebDriver driver;

    protected String url;

    @BeforeSuite
    static void setupClass () {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addExtensions(new File("/Users/emiliano/Projects/AutomationExercisesSTG/src/Extensions/Ublock.crx"));

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        url = BaseURL;
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}