import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class JavaSample {

  public static final String QA_LINK = "http://www.gophersport.com/category/balls-dodgeballs?r=1&hiconversion_alternate=0LS54UaI9C&hiconversion_baseline=true&hiconversion_flicker=visibility&hiconversion_flow=MTZJFB1Ii5&hiconversion_include=true&hiconversion_page=wJX810ybXu&hiconversion_test=true";
  public static final String USERNAME = "faisalhumayun1";
  public static final String AUTOMATE_KEY = "18CxiwTD8SzxvqRrUkGJ";
  public static final String URL = "http://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

  public static void main(String[] args) throws Exception {
    
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "IE");
    caps.setCapability("browser_version", "7.0");
    caps.setCapability("os", "Windows");
    caps.setCapability("os_version", "XP");
    caps.setCapability("browserstack.debug", "true");

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get(QA_LINK);
    
    System.out.println(driver.getTitle());
    driver.quit();

  }
}