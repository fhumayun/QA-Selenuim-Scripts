
import org.testng.annotations.*;

public class LoggingExample extends SuperHelperOB {
	
	@BeforeTest(alwaysRun = true)
	public void login() throws Exception {
		classMethodLogger.log();
		startSession(browser,ip);
		loginOB(username,userpwd);
		gotoLogging();
	}

	@BeforeMethod(alwaysRun = true)
	public void initializeWindowsMap() throws InterruptedException {
		methodLogger.log();
		initMap();
	}
	
	@AfterMethod(alwaysRun = true)
	public void getfocusClearWindowsBeforeMethod() throws InterruptedException {
		methodLogger.log();
		clearWindows();
	}
	
	@Test(priority=1)
	public void changeLogSize() throws Exception {
		methodLogger.log();
		type_byId("logSize", "47");
		//selectFromDropDown("openserLogLevel", "Warning");
	    applyChanges(false);
	    checkValue_byId("logSize", "47");
		setMethodState();
	}

	
	
}
