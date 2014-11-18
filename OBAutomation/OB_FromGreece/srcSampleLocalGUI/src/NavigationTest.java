
import org.testng.annotations.*;

public class NavigationTest extends SuperHelperOB {
	
	@BeforeTest(alwaysRun = true)
	public void login() throws Exception {
		classMethodLogger.log();
		startSession(browser,ip);
		loginOB(username,userpwd);
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
	public void testNavigation() throws Exception {
		
		methodLogger.log();
		gotoBackupRestore();
	    gotoAlarms();
	    gotoLogging();
	    gotoMediaServer();
	    gotoNetworkServices();
	    gotoSecurity();
	    gotoSurvivability();
	    gotoSystem();
	    gotoVOIP();
	    gotoMaintenceAndDiagnostics();
	}

}
