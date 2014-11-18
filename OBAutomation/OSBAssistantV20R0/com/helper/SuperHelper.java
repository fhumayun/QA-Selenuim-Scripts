package com.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Seleniumhelper.*;
import com.Seleniumhelper.enviroment.ApplicationServer;
import com.Seleniumhelper.ssh.ExecCommandGetReply;
import com.Seleniumhelper.superscripts.Core;
import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.enviroment.ComponentVersion;
import com.helper.enviroment.InitializeVariables;


public class SuperHelper extends SuperHelperSelenium implements PropertiesLibrary {
	
	public static String Switch = getEnvVarValue("Switch");
	public static String browser = getEnvVarValue("BROWSER");
	public static String administrator_loginName = getEnvVarValue("AdminUser");
	public static String administrator_password = getEnvVarValue("AdminPass");
	public static String OpenBranch = getEnvVarValue("BranchSelector");
	public static String OpenBranchMode = getEnvVarValue("ModeSelector");
	public static String OpenBranchVersion = getEnvVarValue("BranchVersion");
	public static String ip = getEnvVarValue("IP");
	public static String installation_Dir = "";
	public static String Solid_Dir =  "";
	public static String ApplicationServerName =  "";
	public static String HipathServerName =  "";
	public static String LocalFolder = getEnvVarValue("LOCALFOLDER") + System.getProperty("file.separator");
	public static String reportSettings = setSystempropertiesForReporterNG();
	
		// Set system properties for REPORTERNG and get componets rpms
		public static String setSystempropertiesForReporterNG() {
			String rpm = ApplicationServer.getOpenBranchAssistantrpm();
			System.setProperty("org.uncommons.reportng.title" ,getEnvVarValue("TITLE")+" -"+rpm);
			ComponentVersion components = new ComponentVersion();
			InitializeVariables variables = new InitializeVariables();
			components.start();
			variables.start();
			return "";
		}

//		public boolean checkErrorPage() throws InterruptedException{
//			
//			if(selenium.isTextPresent("Error Page"))
//			{
//				 MyLogger.resultInfo("The Error page appeared!");
//				 MyLogger.resultInfo("Go to OpenScape Branch again");
//				 goToOpenScapeBranch();
//				 return true;
//			}
//			return false;
//		}
		
				
		public String osbLoadName = new ExecCommandGetReply().execCmd("ls /repository/OpenScape\\ Branch*/").replace("\n", "");
		
		public void checkOBStatusAfterRestart(String desiredOB) throws InterruptedException
		{ 
			String obStatus;
			goToBranchOfficeList();
			MyLogger.resultInfo("Wait for 20 sec and Refresh the selected OpenBranch");
			sleep(20000);
			for(int i=0; i<15; i++)
			{	
	          clickCheckbox_byText(OpenBranch);
	          clickButton(BTN_REFRESH_SELECTED_OSB);
	          obStatus = getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB2LAN", TXT_STATUS);
	          if (!obStatus.equals("Unreachable")&&!obStatus.equals("Unknown")){
	        	 MyLogger.resultInfo("The OpenBranch is up and running!");
	        	 selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
	        	 break;
	          }
	          MyLogger.resultInfo("Wait for 20 sec and try again");
	          sleep(20000);
	          if(i==14)
	          {
	        	 MyLogger.resultError("The OpenBranch never came up after the reboot!");
	        	 throw new InterruptedException("The OpenBranch never came up after the reboot!"); 
	          }
		   }
		}
			
		
		public void importXMLFile(String file) throws InterruptedException 
		{
			goToAdministrationSystem();
			updateMap(RETRIES);
			clickButton(TB_SYSTEM_IMPORT_EXPORT);
			clickButton(BTN_IMPORT_XML);
			updateMap(RETRIES);
			uploadFile(IPF_XML_FILE, file);
			clickButtonSave();
			core.selectWindow_ByTitle(readproperties("messagehandlingportlet\\MessageHandling","displayMessages.warningWindowTitle"), selenium, driver);
			checkText(TXT_UPLOAD_COMPLETED.replace("'", ""));
			clickButtonClose();
			getMainWindowFocus();
			applyChangesWithConfirmation();
		}
		
		
		public String getRow(String tableId,String text) throws InterruptedException{
			
			for (int second = 0;; second++) {
				if (second >= 2) {
					break;
				}
			    try
			    {
			       int rowsNumber = driver.findElements(By.xpath("//table[@id='"+tableId+"']/tbody/tr")).size();
				   for (int i=1; i<=rowsNumber; i++)
				   {
					  int columnsPerRow = driver.findElements(By.xpath("//table[@id='"+tableId+"']/tbody/tr["+i+"]/td[@class='column' or @class='columnHidden']")).size();
	                  for(int j=1;j<=columnsPerRow;j++)
	                  {
	                	 if(selenium.getTable(tableId + "." + i + "." + j).equals(text)){
	                	 MyLogger.resultInfo("The " + text + " was found in row " + i );
	                	 return String.valueOf(i);
	                	 }
	                  }
				   }
				
			   }
			   catch(Exception ex){
			   }
			     Thread.sleep(500);
			     SeleniumWebdriver.LOGGER.warn("\tTries: "+ second);
		   }
			MyLogger.resultError("The " + text + " was not found in any row!");
			throw new InterruptedException("The " + text + " was not found in any row!"); 
		}
		
       public ArrayList<String> getAllItemsInSpecificColumn(String tableId,String columnNumber) throws InterruptedException{
			
    	    ArrayList<String> allItems = new ArrayList<String>();
    	    String item = "";
			    try
			    {
			       int rowsNumber = driver.findElements(By.xpath("//table[@id='"+tableId+"']/tbody/tr")).size();
				   for (int i=1; i<=rowsNumber; i++)
				   {
					  item = selenium.getTable(tableId + "." + i + "." + columnNumber);
					  MyLogger.resultInfo(item + " was found in row " + i );
					  allItems.add(item);
	                 }
				   }
				
			   catch(Exception ex){
			   }
			return allItems;
		}
			
		
		public List<String> getAllRows(String tableId,String text) throws InterruptedException{
			
			List<String> rows= new ArrayList<String>();
			    try
			    {
				   int rowsNumber = driver.findElements(By.xpath("//table[@id='"+tableId+"']/tbody/tr")).size();
				   for (int i=1; i<=rowsNumber; i++)
				   {
					  int columnsPerRow = driver.findElements(By.xpath("//table[@id='"+tableId+"']/tbody/tr["+i+"]/td[@class='column' or @class='columnHidden']")).size();
	                  for(int j=1;j<=columnsPerRow;j++)
	                  {
	                	 if(selenium.getTable(tableId + "." + i + "." + j).equals(text)){
	                	 MyLogger.resultInfo("The " + text + " was found in row " + i );
	                	 rows.add(String.valueOf(i));
	                	 }
	                  }
				   }
				
			   }
			   catch(Exception ex){
			   }
			return rows;
		}
		
		public String getColumn(String tableId,String headerText) throws InterruptedException{
			
			for (int second = 0;; second++) {
				if (second >= 2) {
					break;
				}
			    try
			    {
				   List<WebElement> headers = driver.findElements(By.xpath("//table[@id='"+tableId+"']/thead/tr/th[@class='columnHeader' or @class='columnHidden' or @class='lastColumnHeader']"));
				   for (int i=0;i<headers.size();i++)
				   {
					  if (headers.get(i).getText().equals(headerText)){
						  MyLogger.resultInfo("The header with title " + headerText + " was found in column " + String.valueOf(i+1) );
						  return String.valueOf(i+1);
					  }
						  
				   }
				
			   }
			   catch(Exception ex){
			   }
			     Thread.sleep(500);
			     SeleniumWebdriver.LOGGER.warn("\tTries: "+ second);
		   }
			return null;
		}
		
		
		/**
		 * Clear all inactive windows except Main window
		 * 
		 * @throws InterruptedException
		 */
		//
		public static void clearWindows() throws InterruptedException {
			MyLogger.methodPrint(new Exception().getStackTrace()[0].getMethodName());
			String status="nok";
			failed = false; // reset the variable to default state
			failedAction = false; // reset the variable to default state
			retriesToCloseWindows = 1;
			int openWindows=0;
			sleep(2000);
			while (retriesToCloseWindows < 3) {
				try {
					Set<String> windowHandles = driver.getWindowHandles();
					Object[] windowHandlesinArray = windowHandles.toArray();
					if(windowHandlesinArray.length==1){
						status="ok";
						break;
					}
					else{
						for(int i=0;i<windowHandlesinArray.length;i++){
							driver.switchTo().window(windowHandlesinArray[i].toString());
							if(!windowHandlesinArray[i].equals(Main)){
								String title=driver.getTitle();
								MyLogger.resultErrornoScreenShot("Found an open window with title : '"+ title + "'");
								getSingleScreenShot();
								if(selenium.isTextPresent(readproperties("OpenBranch\\OpenBranchGuiError","ob.connection.Error"))){ 
									MyLogger.resultError("The OpenBranch is possibly down - Logout and login again and proceed to next test");
								    closeBrowser();
								    startSession(browser, ip);
									loginCMP(administrator_loginName, administrator_password);
									goToOpenScapeBranch();
									selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
									selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
									break;
								
								 }
								openWindows++;
								Core.closeSelectedWindow(selenium, driver);
								MyLogger.resultInfo("Window with title : '" + title+"' was closed");
							}
						}
						status="ok";
						break;
					}
				} 
				catch (Exception ex) {
					MyLogger.resultErrornoScreenShot(ex.getMessage());
				}
				retriesToCloseWindows++;
			}
			if (status.equals("nok")){
				MyLogger.resultErrornoScreenShot("No window handles could be found!");	
				SeleniumWebdriver.closeBrowser();
				throw new InterruptedException("Selenium is terminated since window handles cannot be found!");
			}
			else 
				if (openWindows>0){
					MyLogger.resultErrornoScreenShot("There were found and closed '" + openWindows+"' not expected open windows in total! Please examine this!");
				}
				else
					MyLogger.resultInfo("There was found no window to be cleared. Great!");
			
			Core.selectWindowMain(Main, selenium, driver);
			Core.initWindows(driver);
		}
		
		
		
		
		//VARIABLES FOR POP-UP WINDOWS HANDLING
		//public HashMap<String, Long> Core.windowHandlersTimestamp = new HashMap<String, Long>();
        public static final int RETRIES = 120;
        public static int executions =1;
        
		//Call in the beginning of every @Test method in order to initialize the pop-up windows pool 
		public void initMap(){
		  Core.windowHandlersTimestamp.clear();
		  Core.windowHandlersTimestamp.put(driver.getWindowHandle(), System.currentTimeMillis());
		}
		 
		 public String getTitle(WebDriver wd){    //optional method in order to get title
		  return ((WebElement)wd.findElement(By.xpath("//div[@id='portlet_Label']"))).getAttribute("innerHTML");
		 }
		 
		 
		 //This method is used in order the selenium web driver to switch between pop-up windows
		 public void updateMap(int timetowait) throws InterruptedException {
		  HashSet<String> handles = (HashSet<String>)driver.getWindowHandles();
		  String windowTitle;
		  	  
		  //Wait for window to open or to close!!! Maximum time to wait=RETRIES*250 ms
		  int times = timetowait;
		  try{
		   while(times > 0){
		    if(handles.size() != Core.windowHandlersTimestamp.size())
		    
		    {
		    	times = -1; //exit from while loop since the number of windows has changed
		    }
		    
		    Thread.sleep(250);
		    --times;
		    handles = (HashSet<String>)driver.getWindowHandles();	//be carefull: parallel tests will not work on this method
		   
		   }  //end while loop
		   
		  }catch(Exception e){ 
			  MyLogger.resultInfo("Problem in getWindowHandles");
		  }
		   
		  if(times == 0 && executions == 2){
			  MyLogger.resultError("The action had no effect, time of " +String.valueOf(timetowait*0.25)+" sec expired in second try,check Logs");
		      throw new InterruptedException("The action had no effect, time of " +String.valueOf(timetowait*0.25)+" sec expired in second try,check Logs");
		  }
		  
		  //Case that an action for opening or closing a window has no effect(action is reexecuted)
		  if(times == 0) {
		      MyLogger.resultInfo("The action had no effect, time of " +String.valueOf(timetowait*0.25)+" sec expired,try once more!!");
		      executions ++;
              Core.reExecuteLastClick(selenium, driver);
              updateMap(timetowait);
              return;
		  }	  
		  
		  String mostrecent = null;
		  Long recenttime = 0L;
		  boolean window_found = false;
		  
		  //2 controls contained inside this for-statement
		  for(String handle:handles){
		  
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
		  
		  
		  if(!window_found)
		  {
		   //Check if current window is removed
		    for(Map.Entry<String, Long> key : Core.windowHandlersTimestamp.entrySet()){   
			 if(!handles.contains(key.getKey())){	
			    driver.switchTo().window(mostrecent);
			    //Switch to previous window and return control to caller method
		        MyLogger.resultInfo("Switch to previous page");
		        waitForPageToLoad("30000");
		        Core.windowHandlersTimestamp.remove(key.getKey());
		        executions =1;
		        return;
	          }
	         }		  
           } //end no window found check
		  
		  //switch to new opened window
		  driver.switchTo().window(mostrecent);
		  MyLogger.resultInfo("A new window was loaded!!");
		  waitForPageToLoad("30000");
		  windowTitle = driver.getTitle();
		  MyLogger.resultInfo("The " + windowTitle + " window pop up was selected!"); 
		  executions =1;
		 }
		 
		 
		public void goBack(){
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			selenium.goBack();
		}
		
		public static void goToOpenScapeBranch() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			//goToMenu(readproperties("OpenBranch\\pageLocalization", "Applications.OpenBranch.folder.title"));
			if(getEnvVarValue("VERSION").equals("V6")){ //If V6 
			goToMenu(readproperties("operationportlet\\pageLocalization","Applications.Operation.folder.title")); //Navigate to Configuration first 
			
			} // Then navigate to OpenScape Branch tab.
			goToMenu(readproperties("OpenBranch\\pageLocalization", "Applications.OpenBranch.folder.title"));
		}
				
	
		public void goToGeneral() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			goToMenu(readproperties("OpenBranch\\pageLocalization", "Applications.OpenBranch.administration.folder.title"));
		}
		
		public void goToList() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			goToMenu(readproperties("OpenBranch\\pageLocalization", "Applications.OpenBranch.administration.listProfiles.title"));
		}
	
		public void goToBranchOfficeList() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			goToMenu("Branch Office list");
		}
		
		public void goToManagement() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.administration_profile_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration_profile_styleSwitch']/table/tbody/tr/td[3]/div","");
			}
		}

		
		public void goToManagementDashboard() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.administration_dashboard_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration_dashboard_styleSwitch']/table/tbody/tr/td[3]/div","");
			}
		}
		
		public void goToProfilesConfiguration() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			goToXpath("//div[@id='sideNavig']/table/tbody/tr[4]/td/div/div/div[1]/table/tbody/tr/td[2]/div", "");
		}
		
		public void goToProfilesList() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			goToXpath("//div[@id='Applications.Operation.OpenBranch_listProfiles_styleSwitch']", "");
		}


		
		public void goToProfilesManagement() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			goToXpath("//div[@id='Applications.Operation.OpenBranch_profile_styleSwitch']/table/tbody/tr/td[3]/div", "");
		}
		
		public void goToAdministrationConfiguration() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			goToXpath("//div[@id='sideNavig']/table/tbody/tr[11]/td/div/div/div[1]/table/tbody/tr/td[2]/div", "");
		}
		
		
		public void goToProfilesAlarms() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configurationProfiles_alarmSettings_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configurationProfiles_alarmSettings_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}	

		public void goToAdministrationAlarms() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_alarmSettings_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_alarmSettings_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
				
		public void goToProfilesLogging() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configurationProfiles_logging_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configurationProfiles_logging_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToAdministrationLogging() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_logging_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{			
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_logging_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}	
		
		public void goToProfilesMediaServer() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configurationProfiles_mediaServer_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configurationProfiles_mediaServer_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToAdministrationMediaServer() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_mediaServer_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_mediaServer_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}	
		
		public void goToProfilesNetworkServices() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configurationProfiles_networkServices_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{			
				goToXpath("//div[@id='Applications.OpenBranch.administration.configurationProfiles_networkServices_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToAdministrationNetworkServices() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_networkServices_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{	
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_networkServices_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToProfilesSecurity() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configurationProfiles_security_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configurationProfiles_security_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToAdministrationSecurity() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_security_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_security_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToProfilesSurvivability() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configurationProfiles_survivability_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configurationProfiles_survivability_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToAdministrationSurvivability() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_survivability_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_survivability_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToProfilesSystem() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configurationProfiles_system_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configurationProfiles_system_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToAdministrationSystem() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_system_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_system_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToProfilesVoip() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configurationProfiles_voip_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configurationProfiles_voip_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToAdministrationVoip() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_voip_styleSwitch']/table/tbody/tr/td[3]/div", "//div[@id='Applications.Operation.OpenBranch.configuration_voip_styleSwitch']/table/tbody/tr/td[3]/div");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_voip_styleSwitch']/table/tbody/tr/td[3]/div", "//div[@id='Applications.Operation.OpenBranch.configuration_voip_styleSwitch']/table/tbody/tr/td[3]/div");
			}
		}
		
		public void goToAdministrationAcd() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_acd_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_acd_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToAdministrationAutoAttendant() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_autoAttendant_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_autoAttendant_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToAdministrationIntegratedGateways() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			if(getEnvVarValue("VERSION").equals("V6")){
				goToXpath("//div[@id='Applications.Operation.OpenBranch.configuration_integratedGateways_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
			else{
				goToXpath("//div[@id='Applications.OpenBranch.administration.configuration_integratedGateways_styleSwitch']/table/tbody/tr/td[3]/div", "");
			}
		}
		
		public void goToJobManagement() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			goToMenu(readproperties("OpenBranch\\pageLocalization", "Applications.OpenBranch.administration.schedules.title"));
		}
		
		public void goToOverview() throws InterruptedException {
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			goToMenu(readproperties("OpenBranch\\pageLocalization", "Applications.OpenBranch.administration.1_Administration.title"));
		}
		
		public void ConfirmationWindow() throws InterruptedException{
			//A pop window is displayed , click ok and continue
			selectWindow_byContainingTitleNoException("Confirmation");
			clickButton_byValue("OK");
		}
		
		public void goToConfiguration() throws InterruptedException{
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			try{
				goToMenu(readproperties("HP8KAssistant\\pageLocalization", "Applications.Operation.folder.title"));
			}
			catch (InterruptedException ex){
				LOGGER.info("Page was not loaded properly - try once more");
				goToMenu(readproperties("HP8KAssistant\\pageLocalization", "Applications.Operation.folder.title"));
			}
		}
		
		
		
		//CMP areas
		public void goToMaintenance() throws InterruptedException {
			MyLogger.methodPrint(new Exception().getStackTrace()[0].getMethodName());
		
			int i=0;
			while(i<=4){
				if (navigationTextIsVisible(readproperties("operationportlet\\pageLocalization","Applications.Maintenance.Inventory.folder.title"))&&(i==0)){
					MyLogger.resultInfo("No need for navigation");
					break;
				} 	
				if (navigationTextIsVisible(readproperties("operationportlet\\pageLocalization","Applications.Maintenance.Inventory.folder.title"))){
					MyLogger.resultInfo("Navigation was successful!");
					break;
				} 
				else{
					goToMenu(readproperties("operationportlet\\pageLocalization","Applications.Maintenance.folder.title"));
					i++;
				}
			}
			}
		
		
		public void goToInventory() throws InterruptedException {
			MyLogger.methodPrint(new Exception().getStackTrace()[0].getMethodName());
			goToMenu(readproperties("operationportlet\\pageLocalization","Applications.Maintenance.Inventory.folder.title"));
		}
		

		public void goToRepository() throws InterruptedException {
			MyLogger.methodPrint(new Exception().getStackTrace()[0].getMethodName());
			goToMenu(readproperties("operationportlet\\pageLocalization",
					"Applications.Maintenance.Inventory.Overview.Repository.title"));
		}
		
		public void goToNodes() throws InterruptedException {
			MyLogger.methodPrint(new Exception().getStackTrace()[0].getMethodName());
			goToMenu(readproperties("operationportlet\\pageLocalization",
					"Applications.Maintenance.Inventory.Overview.SystemStatus.title"));
		}
		
		public void navigateToNodes() throws InterruptedException {
			MyLogger.methodPrint(new Exception().getStackTrace()[0].getMethodName());
			if (!navigationTextIsVisible(readproperties("operationportlet\\Resources", "SystemStatus.Description"))) {
				goToMaintenance();
				goToInventory();
				goToNodes();
			}
		}
		
		public void applyChanges() throws InterruptedException{
			getMainWindowFocus();
			clickButton(BTN_APPLYCHANGES);
			sleep(6000);
			waitForPageToLoad("60000");
			checkStatus(BTN_APPLYCHANGES, "disabled", "button");
		}
		public void applyChangesWithConfirmation() throws InterruptedException{
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			selenium.setTimeout("35000");
			clickButton(BTN_APPLYCHANGES);
			waitForPageToLoad("20000");
			try{
				ConfirmationWindow();
			}
			catch(InterruptedException ex){
				LOGGER.trace("\tMethod : " + ex);
			}
			getMainWindowFocus();
			checkStatus(BTN_APPLYCHANGES, "disabled", "button");
		}
		
		public void applyChangesWithConfirmationProfiles() throws InterruptedException{
			LOGGER.trace("\tMethod : " + new Exception().getStackTrace()[0].getMethodName());
			selenium.setTimeout("35000");
			clickButton(BTN_PROFILE_APPLYCHANGES);
			waitForPageToLoad("20000");
			try{
				ConfirmationWindow();
			}
			catch(InterruptedException ex){
				LOGGER.trace("\tMethod : " + ex);
			}
			getMainWindowFocus();
			checkStatus(BTN_PROFILE_APPLYCHANGES, "disabled", "button");
		}
		
		//Full navigation methods
		public boolean navigateToAdministration() throws InterruptedException {
			if(!selenium.isTextPresent(readproperties("OpenBranch\\pageLocalization","Applications.OpenBranch.administration.folder.title")+" - "+Switch+" - "+OpenBranch)){
			 goToOpenScapeBranch();
			 return true;
			}
			else{
			 return false;	
			}
		}

	
		public boolean navigateToBranchOfficeList() throws InterruptedException {
			if(!selenium.isTextPresent(readproperties("OpenBranch\\pageLocalization","Applications.OpenBranch.folder.title")+" "+readproperties("OpenBranch\\pageLocalization","Applications.OpenBranch.administration.1_Administration.title")+" - "+Switch)){
			 goToOpenScapeBranch();
			 goToBranchOfficeList();
			 return true;
			}
			else{
			 return false;	
			}
		}
		
		
		public boolean navigateToOpenScapeBranch() throws InterruptedException {
			if(!selenium.isTextPresent(readproperties("OpenBranch\\pageLocalization","Applications.OpenBranch.folder.title"))){
			 goToOpenScapeBranch();
			 return true;
			}
			else{
			 return false;	
			}
		}
		
		public boolean navigateToJobManagement() throws InterruptedException {
			if(!selenium.isTextPresent(readproperties("OpenBranch\\OpenBranchGui","listSchedules.jobs"))){
			 goToOpenScapeBranch();
			 goToJobManagement();
			 return true;
			}
			else{
			 return false;	
			}
		}
		
		public void navigateToProfilesList() throws InterruptedException {
			if(!selenium.isTextPresent(readproperties("OpenBranch\\OpenBranchGui","profile.description"))){
			 goToOpenScapeBranch();
			 goToProfilesList();
			}
			else{
			}
		}
}