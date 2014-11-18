import org.junit.After;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class clarisonic-radiance-checkout {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void clarisonic-radiance-checkout() {
        wd.get("http://clarisonic.com/?hiconversion_alternate=pMrGqnJhiV&hiconversion_baseline=true&hiconversion_flicker=visibility&hiconversion_flow=UQtQuNbjHu&hiconversion_include=true&hiconversion_page=Jrjfn40ROx&hiconversion_test=true");
        if (!wd.findElement(By.tagName("html")).getText().contains("Devices")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.linkText("Devices")).click();
        wd.findElement(By.linkText("Sonic Radiance Brightening Solution")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Add to My Bag")) {
            System.out.println("verifyTextPresent failed");
        }
        wd.findElement(By.id("add_to_cart")).click();
        wd.findElement(By.cssSelector("span.mini_cart_label")).click();
        wd.findElement(By.id("add_to_cart")).click();
        wd.findElement(By.linkText("Checkout")).click();
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
