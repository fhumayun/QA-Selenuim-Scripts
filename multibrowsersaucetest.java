package saucetest;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceBrowserDataProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.assertEquals;
/**
 * Simple TestNG test which demonstrates being instantiated via a DataProvider in order to supply multiple browser combinations.
 *
 */
@Listeners({SauceOnDemandTestListener.class})
public class MultiWebDriverTest implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {
    /**
     * Constructs a {@link com.saucelabs.common.SauceOnDemandAuthentication} instance using the supplied user name/access key. To use the authentication
     * supplied by environment variables or from an external file, use the no-arg {@link com.saucelabs.common.SauceOnDemandAuthentication} constructor.
     */
    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication();
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private ThreadLocal<String> sessionId = new ThreadLocal<String>();
    private static final Logger logger = Logger.getLogger(MultiWebDriverTest.class.getName());
    /**
     * Simple hard-coded DataProvider that explicitly sets the browser combinations to be used.
     *
     * @param testMethod
     * @return
     */
    @DataProvider(name = "hardCodedBrowsers", parallel = true)
    public static Object[][] sauceBrowserDataProvider(Method testMethod) {
        return new Object[][]{
                new Object[]{"firefox", "36", "Windows 2003","Gopher QA: EV - Category View - EV1 - List Viewv"},
                new Object[]{"chrome", "36", "Windows 8.1","Gopher QA: EV - Category View - EV1 - List View"},
        };
    }
    /**
     * Creates a new {@link RemoteWebDriver} instance which is configured
     * @param browser
     * @param browserVersion
     * @param os
     * @param sessionName
     * @return
     * @throws MalformedURLException
     */
    private WebDriver createDriver(String browser, String browserVersion, String os, String sessionName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform",os);
        capabilities.setCapability("name", sessionName);
        webDriver.set(new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities));
        sessionId.set(((RemoteWebDriver) getWebDriver()).getSessionId().toString());
        return webDriver.get();
    }
    @Test(dataProvider = "hardCodedBrowsers")
    public void webDriver(String username, String AccessKey, String browser, String browserVersion, String os, String sessionName) throws Exception {
        /*WebDriver driver = createDriver(username, AccessKey, browser, browserVersion, os, sessionName);
        logger.log(Level.INFO, "Running test using " + browser + " " + browserVersion + " " + os + " " + sessionName);
        driver.get("http://www.gophersport.com/category/balls-dodgeballs?r=1&hiconversion_alternate=0LS54UaI9C&hiconversion_baseline=true&hiconversion_flicker=visibility&hiconversion_flow=MTZJFB1Ii5&hiconversion_include=true&hiconversion_page=wJX810ybXu&hiconversion_test=true");
        assertEquals(driver.getTitle(), "Dodgeballs");
        driver.quit();*/
    }
    public WebDriver getWebDriver() {
        System.out.println("WebDriver" + webDriver.get());
        return webDriver.get();
    }
    public String getSessionId() {
        return sessionId.get();
    }
    @Override
    public SauceOnDemandAuthentication getAuthentication() {
        return authentication;
    }
}