import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Selenium;


public class SeleniumTest {

@Test
public void method(){
WebDriver driver = new FirefoxDriver();
Selenium selen = new WebDriverBackedSelenium(driver,"https://10.1.72.10");
selen.open("/");
selen.type("usernameInput", "administrator@system");
selen.type("passwordDisplayInput", "Asd123!.");
selen.click("theButton");

selen.click("//div[.='Configuration']");
selen.click("//div[.='OpenScape Voice']");

}	


}
