package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;


public class BaseTest {

    protected WebDriver driver;

    public static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<>();

    public static WebDriver getThreadLocal() {
        return THREAD_LOCAL.get();
    }

    protected String url;

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void browserSetUp(@Optional String BaseURL) throws MalformedURLException, InterruptedException {
//        driver(selectBrowser(System.getProperty("browser")));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().deleteAllCookies();
//        url = BaseURL;
//        driver.get(BaseURL);
        THREAD_LOCAL.set(selectBrowser(System.getProperty("browser")));
        THREAD_LOCAL.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        THREAD_LOCAL.get().manage().window().maximize();
        THREAD_LOCAL.get().manage().deleteAllCookies();
        getThreadLocal().get(BaseURL);
        System.out.println("Browser setup by Thread " + Thread.currentThread().getId() + " and Driver reference is : " + getThreadLocal());

//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addExtensions(new File("/Users/emiliano/Projects/AutomationExercisesSTG/src/Extensions/Ublock.crx"));
//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions options = new FirefoxOptions();
//        options.setAcceptInsecureCerts(true);
//        options.setBinary(Path.of("/Users/emiliano/Projects/AutomationExercisesSTG/src/Extensions/Ublock.crx"));
//        driver = new FirefoxDriver();
////        driver = new ChromeDriver(options);
////        Dimension d = new Dimension(300,1080);
//        driver.manage().window().maximize();
////        Path path = Paths.get("/Users/emiliano/Downloads/selenium_ide-3.17.4.xpi");
//        url = BaseURL;
//        driver.get(url);
    }

//    public WebDriver lambdaTest() throws MalformedURLException {
//        String username = "e8023240";
//        String authkey = "tTQe1rEJHtZfTM5jAvbLFgPJy3BhjoQIyNV0U1QslR9sb9OoD1";
//        String hub = "@hub.lambdatest.com/wd/hub";
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("platform", "Windows 10");
//        caps.setCapability("browserName", "Chrome");
//        caps.setCapability("version", "120.0");
//        caps.setCapability("resolution", "1024x768");
//        caps.setCapability("build", "TestNG With Java");
//        caps.setCapability("name", this.getClass().getName());
//        caps.setCapability("plugin", "git-testng");
//        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);    }

    public WebDriver selectBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "";

        switch (browser) {
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("-private");
                optionsFirefox.setPageLoadStrategy(PageLoadStrategy.EAGER);
//                FirefoxProfile profile = new FirefoxProfile();
//                profile.addExtension(new File("/Users/emiliano/Projects/QA Engineer Docs/crx Extensions/uBlock.crx"));
                return driver = new FirefoxDriver(optionsFirefox);
            case "safari":
                WebDriverManager.safaridriver().setup();
                SafariOptions optionsSafari = new SafariOptions();
                return driver = new SafariDriver(optionsSafari);
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                EdgeOptions optionsEdge = new EdgeOptions();
//                optionsEdge.addArguments("--remote-allow-origins=*");
//                return driver = new EdgeDriver(optionsEdge);
//            case "cloud":
//                return lambdaTest();
            default:
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--remote-allow-origins=*");
                optionsChrome.addExtensions(new File("/Users/emiliano/Projects/QA Engineer Docs/crx Extensions/uBlock.crx"));
                return driver = new ChromeDriver(optionsChrome);
        }
    }

    @AfterMethod
    public void tearDown() {
        THREAD_LOCAL.get().close();
        THREAD_LOCAL.remove();
    }
}