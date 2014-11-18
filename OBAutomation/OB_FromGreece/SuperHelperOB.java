import java.util.HashSet;
import java.util.Map;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Seleniumhelper.SeleniumPropertiesLibrary;
import com.Seleniumhelper.SuperHelperSelenium;
import com.Seleniumhelper.superscripts.Core;
import com.Seleniumhelper.superscripts.MyLogger;


public class SuperHelperOB extends SuperHelperSelenium implements SeleniumPropertiesLibrary{

	
    //Locator variables (XPATH expressions) for all the tabs of the OpenBranch - no ids available for those components
	String TB_Maintenace = "//div[@id='md']//div[contains(text(),'Maintenance') and contains(text(),'Diagnostics')]";
	String TB_Backup_Restore = "//div[@id='backupTdiv']//div[.='Backup/Restore']";
	String TB_Alarms = "//div[@id='alarmTdiv']//div[.='Alarms']";
	String TB_Logging = "//div[@id='logTdiv']//div[.='Logging']";
	String TB_Media_Server = "//div[@id='msTdiv']//div[contains(text(),'Media') and contains(text(),'Server')]";
	String TB_Network_Services = "//div[@id='netSvcTdiv']//div[contains(text(),'Network') and contains(text(),'Services')]";
	String TB_Security = "//div[@id='securityTdiv']//div[.='Security']";
	String TB_Survivability = "//div[@id='survTdiv']//div[.='Survivability']";
	String TB_System = "//div[@id='systemTdiv']//div[.='System']";
	String TB_VOIP = "//div[@id='voipTdiv']//div[.='VOIP']";
	
	//Info messages locators in the OpenBranch tabs
	String Info_Maintenace_Diagnostics = "//div[.='Maintenance & diagnostics provisioning.']";
	String Info_Backup_Restore = "//div[.='Backup/Restore provisioning.']";
	String Info_Alarms = "//div[.='Alarm configuration.']";
	String Info_Logging = "//div[.='Logging configuration.']";
	String Info_Media_Server = "//div[.='Media server configuration.']";
	String Info_Network_Services = "//div[.='Network services provisioning.']";
	String Info_Security = "//div[.='Security provisioning.']";
	String Info_Survivability = "//div[.='Survivability features provisioning.']";
	String Info_System = "//div[.='System configuration.']";
	String Info_VOIP = "//div[.='VOIP data provisioning.']";
	
	String BTN_Apply_Changes = "applyChangesBtn";
	String BTN_Cancel_Changes = "//input[@value='Cancel Changes']";
	
	public void applyChanges(boolean isProcessRestart) throws InterruptedException {
		
		clickButton(BTN_Apply_Changes);
		
		Alert firstAlert = waitForAlert(driver,60);
		String alertText = firstAlert.getText();
		
			if(isProcessRestart){
				if(alertText.equals("The current config.xml and the file saved have exactly the same settings.")){
					firstAlert.accept();
					MyLogger.resultFailnoScreenShot(alertText + " Check your test scenario!!!");
					failed = true;
				}
				if(alertText.contains("Do you want to proceed")){
					MyLogger.resultInfo(alertText);
					MyLogger.resultInfo("Proceed with action accept");
					firstAlert.accept();
					Alert actionConfirm = waitForAlert(driver,60);
					checklogs("Configuration saved successfully.", actionConfirm.getText());
					MyLogger.resultInfo("Proceed with action accept");
					actionConfirm.accept();
				}
				else{
					MyLogger.resultErrornoScreenShot("No correct alert message was displayed,the message is: "+alertText);
				    failed = true;		
				}
			}else{
				
				if(alertText.contains("Do you want to proceed")){
					MyLogger.resultFailnoScreenShot(alertText + " message appeared, Check your test scenario!!!");
					MyLogger.resultInfo("Proceed with action accept");
					firstAlert.accept();
					failed = true;
				}
				
				if(alertText.equals("The current config.xml and the file saved have exactly the same settings.")){
					firstAlert.accept();
					MyLogger.resultFailnoScreenShot(alertText + " Check your test scenario!!!");
					failed = true;
				}
				else{
					checklogs("Configuration saved successfully.", alertText);
					MyLogger.resultInfo("Proceed with action accept");
					firstAlert.accept();
				}
			}
	}
	
	/*
	public void waitOBMainWindow(long msec) throws InterruptedException{
		boolean loaded = false;
		long timestart;
		long timeEnd;
		long duration;
		WebElement progressBar;
		timestart = System.currentTimeMillis();
		selenium.waitForPageToLoad(String.valueOf(msec));
		do{
		  try{
			 progressBar = driver.findElement(By.id(("progressBar")));
			 String style=progressBar.getAttribute("style").toLowerCase();
			 
			 timeEnd = System.currentTimeMillis();
			 duration = timeEnd-timestart;
			 
			 if (style.contains("display: none; z-index: 1000") || style.contains("z-index: 1000; display: none") || style.equals("") || style.contains("display: none;")){
				MyLogger.resultInfo("Main window was loaded after Apply Changes in: " + duration/1000 + " sec");
				break;
			 }
			
			 Thread.sleep(500);
			 MyLogger.resultInfo("Still loading...");
			
			 if(duration > msec){
				MyLogger.resultError("Main window was not loaded after Apply Changes");
				break;
			 }
			
		  }
		  catch(NoSuchElementException e){
				timeEnd = System.currentTimeMillis();
				duration = timeEnd-timestart;
				MyLogger.resultInfo("Main window was loaded after Apply Changes in: " + duration/1000 + " sec");
				break;
		  }
		  
		  catch(UnhandledAlertException e){
				alert_handle("ok");
				timeEnd = System.currentTimeMillis();
				duration = timeEnd-timestart;	
				MyLogger.resultInfo("Unhandled Alert Exception happened!!!");
				MyLogger.resultInfo("Main window was loaded after Apply Changes in: " + duration/1000 + " sec");
				break;
			}
		  
		}
		while(!loaded);
	}
	*/
	public static Alert waitForAlert(WebDriver driver, int seconds) throws InterruptedException{
		Wait<WebDriver> wait = new WebDriverWait(driver, seconds);
		Alert al = null;
	    try {
			al = wait.until(new AlertAvailable());
		} catch (TimeoutException e) {
			MyLogger.resultErrornoScreenShot("No alert appeared within the desire time of " + seconds +" seconds");
			throw new InterruptedException("No alert appeared within the desire time of " + seconds +" seconds");
		}
	    return al;
	}

	private static class AlertAvailable implements ExpectedCondition<Alert> {
	    private Alert alert = null;
	    public Alert apply(WebDriver driver) {
	        Alert result = null;
	        if (null == alert) {
	            alert = driver.switchTo().alert();
	        }
	        try {
	            result = alert;
	        } catch (NullPointerException npe) {
	        }
	        return result;
	    }
	}

	
	public void cancelChanges() throws InterruptedException{
		javaScriptConfirmation("ok");
		clickButton_ByXpath(BTN_Cancel_Changes);
		alert_verifyTextAndHandle("cancel","Changes were cancelled. Page will be reloaded.");
		waitForPageToLoad();
	}
	
	//Go to methods
	public void gotoMaintenceAndDiagnostics() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_Maintenace_Diagnostics)){
			clickButton_ByXpath(TB_Maintenace);
			  waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to Maintenance & Diagnostics failed! " + e.getMessage());
			throw new InterruptedException();
		}
		
	}
	
	public void gotoBackupRestore() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_Backup_Restore)){
			  clickButton_ByXpath(TB_Backup_Restore);
			  waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to Backup/Restore failed! " + e.getMessage());
			throw new InterruptedException();
		}
	}
	
	public void gotoAlarms() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_Alarms)){
			  clickButton_ByXpath(TB_Alarms);
			  waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to Alarms failed! " + e.getMessage());
			throw new InterruptedException();
		}
	}
	
	public void gotoLogging() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_Logging)){
				clickButton_ByXpath(TB_Logging);	
				waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to Logging failed! " + e.getMessage());
			throw new InterruptedException();
		}
	}
	
	public void gotoMediaServer() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_Media_Server)){
			   clickButton_ByXpath(TB_Media_Server);
			   waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to Media Server failed! " + e.getMessage());
			throw new InterruptedException();
		}
	}
	
	public void gotoNetworkServices() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_Network_Services)){
			  clickButton_ByXpath(TB_Network_Services);
			  waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to Network Services failed! " + e.getMessage());
			throw new InterruptedException();
		}
	}
	
	public void gotoSecurity() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_Security)){
			   clickButton_ByXpath(TB_Security);
			   waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to Security failed! " + e.getMessage());
			throw new InterruptedException();
		}
	}
	
	public void gotoSurvivability() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_Survivability)){
			   clickButton_ByXpath(TB_Survivability);
			   waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to Survivability failed! " + e.getMessage());
			throw new InterruptedException();
		}
	}
	
	public void gotoSystem() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_System)){
			  clickButton_ByXpath(TB_System);
			  waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to System failed! " + e.getMessage());
			throw new InterruptedException();
		}
	}
	
	public void gotoVOIP() throws InterruptedException{
		LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
		try {
			if(!selenium.isVisible(Info_VOIP)){
			  clickButton_ByXpath(TB_VOIP);
			  waitForPageToLoad();
			}
		} catch (Exception e) {
			MyLogger.resultError("Navigation to VOIP failed! " + e.getMessage());
			throw new InterruptedException();
		}
	}

	
	//VARIABLES FOR POP-UP WINDOWS HANDLING
    public static final int RETRIES = 250;
    public static int executions =1;
    
	//Call in the beginning of every @Test method in order to initialize the pop-up windows pool 
	public void initMap() {
	  Core.windowHandlersTimestamp.clear();
	  Core.windowHandlersTimestamp.put(driver.getWindowHandle(), System.currentTimeMillis());
	}
	 
	//This method is used in order the selenium web driver to switch between pop-up windows
	public void updateMap(int timetowait) throws InterruptedException {
    HashSet<String> handles = (HashSet<String>)driver.getWindowHandles();
    String windowTitle;

     //Wait for window to open or to close!!! Maximum time to wait=RETRIES*250 ms
     int times = timetowait;
     double actionDuration = 0.0;
     try{

	 while(times > 0)
	 {
          if(handles.size() != Core.windowHandlersTimestamp.size())
         {
         actionDuration = (timetowait-times)*0.25;
	     times = -1; //exit from while loop since the number of windows has changed

	     }


	 Thread.sleep(250);
     --times;
     handles = (HashSet<String>)driver.getWindowHandles(); //be carefull: parallel tests will not work on this method


	 } //end while loop


	 }catch(Exception e){MyLogger.resultInfo("Problem in getWindowHandles");}


	 //If the execution of last action is not fixed the problem throw exception to end test
	 if(times == 0 && executions == 2){
        MyLogger.resultError("The action had no effect, time of " +String.valueOf(timetowait*0.25)+" sec expired in second try,check Logs");
        throw new InterruptedException("The action had no effect, time of " +String.valueOf(timetowait*0.25)+" sec expired in second try,check Logs");
        }


	 //Case that an action for opening or closing a window has no effect(action is re-executed)
     if(times == 0 && Core.windowHandlersTimestamp.size() != 1) {
        MyLogger.resultInfo("The action had no effect, time of " +String.valueOf(timetowait*0.25)+" sec expired,try once more!!");
        executions ++;
        Core.reExecuteLastClick(selenium, driver);
        //call the updateMap for the second time
	    updateMap(timetowait);

	    return;

	   } 
     
     //for actions in main window that not open a new window re-execute the entire test 
      if(times == 0 && Core.windowHandlersTimestamp.size() == 1)
      {
         
    	 MyLogger.resultError("The action had no effect in main window had no effect so reexecute the test!!");
         Core.noSuchWindow = true;
         throw new InterruptedException("The action had no effect in main window had no effect so reexecute the test!!");

       }

	 String mostrecent = null;
     Long recenttime = 0L;
     boolean window_found = false;


	 //2 controls contained inside this for-statement

	 for(String handle:handles)
	 
	 {

	       if(Core.windowHandlersTimestamp.get(handle) == null){

	        //new window found
             Long ct = System.currentTimeMillis();
             Core.windowHandlersTimestamp.put(handle, ct);
             window_found = true;
                  
             //preserve most recent object and its timestamp
             recenttime = ct;
              mostrecent = handle;

	         } 

	      //find most recent id
           Long t = Core.windowHandlersTimestamp.get(handle);
           if(recenttime < t){
               recenttime = t;
	           mostrecent = handle;

	       }

	 } //end for loop

	 if(!window_found){

	 //Check if current window is removed

	 for(Map.Entry<String, Long> key : Core.windowHandlersTimestamp.entrySet()){ 

	         if(!handles.contains(key.getKey())){ 

	            driver.switchTo().window(mostrecent);
	            waitForPageToLoad();
	            //Switch to previous window and return control to caller method
                MyLogger.resultInfo("Switch to previous page in " + String.valueOf(actionDuration)+ " sec!");
                Core.windowHandlersTimestamp.remove(key.getKey());
                //initialize variable for re-executions
                executions =1;
                return;

	          }//end if loop

	 }//end for loop

	 } //end no window found check

	  
	 //switch to new opened window
	 driver.switchTo().window(mostrecent);
	 waitForPageToLoad();
	 MyLogger.resultInfo("A new window was loaded in " + String.valueOf(actionDuration)+ " sec!");
	 windowTitle = driver.getTitle(); 
	 MyLogger.resultInfo("The " + windowTitle + " window pop up was selected!"); 
		  
	 //initialize variable for reexecutions
	 executions =1;  
	  
	 }//end updateMap
	  
	
	
	
	//Navigation Methods
	
	
	
	
	
	
	
	
	
}
