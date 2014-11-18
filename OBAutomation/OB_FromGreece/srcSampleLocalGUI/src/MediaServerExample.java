
import org.testng.annotations.*;

public class MediaServerExample extends SuperHelperOB implements MediaServerProperties {
	
	@BeforeTest(alwaysRun = true)
	public void login() throws Exception {
		classMethodLogger.log();
		startSession(browser,ip);
		loginOB(username,userpwd);
		gotoMediaServer();
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
	public void enableMediaServer() throws Exception {
		
		methodLogger.log();	
		if(!getCheckboxStatus("enableMs"))
		clickCheckbox_byID("enableMs");
		
		clickButton("msAdvCellBtn");
		updateMap(RETRIES);
		
		type_byId("msAdaptTimeToLive", "303");
	    clickButton_byValue("Save");
	    updateMap(RETRIES);
	    
	    applyChanges(true);
	  
	    checkStatus("enableMs", "checked", "Checkbox Enable Local Media Server");
	    
		setMethodState();
	}

	
	@Test(priority=2)
	public void disableMediaServer() throws Exception {
		
		methodLogger.log();
		if(getCheckboxStatus("enableMs"))
		clickCheckbox_byID("enableMs");

	    applyChanges(true);
	    
	    checkStatus("enableMs", "unchecked", "Checkbox Enable Local Media Server");
	    
		setMethodState();
	}
}
