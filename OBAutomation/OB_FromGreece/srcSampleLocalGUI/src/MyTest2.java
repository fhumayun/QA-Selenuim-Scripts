

import com.Seleniumhelper.SuperHelperSelenium;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.testng.annotations.*;
import java.util.regex.Pattern;

public class MyTest2 extends SuperHelperSelenium {
	@BeforeTest
	public void setUp() throws Exception {
		startSession(browser,ip);
		loginOB(username,userpwd);
	}

	@Test
	public void testTest2() throws Exception {
		
		sleep(3000);
//		clickButton_ByXpath("//div[@id='netSvcTdiv']/table/tbody/tr/td[2]/div/table/tbody/tr/td/div");
//		checkValue_byId("eth0IpNode1", "192.168.108.98");
//		checkSelectedValue_inDropDownList("eth0Speed", "Auto");
		selectFromDropDown("eth0Speed", "100 Mbps");
		setMethodState();
	}

}
