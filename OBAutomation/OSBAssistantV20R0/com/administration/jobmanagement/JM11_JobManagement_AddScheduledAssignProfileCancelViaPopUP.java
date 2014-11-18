package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;

public class JM11_JobManagement_AddScheduledAssignProfileCancelViaPopUP extends SuperHelper implements PropertiesJobManagement {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		navigateToJobManagement();
	}

	@BeforeMethod(alwaysRun = true)
	public void initializeWindowsMap() throws InterruptedException {
		initMap();
	}
	
	@AfterMethod(alwaysRun = true)
	public void getfocusClearWindowsBeforeMethod() throws InterruptedException {
		clearWindows();
	}

	JobManagement_GeneralMethods job = new JobManagement_GeneralMethods();
	
	@Test (priority = 0)
	public void jobManagementAddScheduledTranferAssignProfileCancelViaPopUP() throws InterruptedException {
		
		classMethodLogger.log(); 
		//Add an Scheduled Assign Profile
	    clickButtonAdd();
	    updateMap(RETRIES);
	    
	    double startTime = System.currentTimeMillis()/1000.0;	 
	   
	    selectFromDropDown(SLC_JOB_ACTION, TXT_ASSIGN_PROFILE);
	    clickButton(BTN_SELECT_ACTION_INPUT);
	    updateMap(RETRIES);
	   
	    clickRadioButton_byText("JobProfile");
		
	    clickButtonSave();
		updateMap(RETRIES);
	
		checkValue_byId(IPF_ACTION_INPUT, "JobProfile");
	
		type_byId(IPF_NOTE, "SchAssignProf9");
		
	    //Add a Node
		clickButtonAdd();
		updateMap(RETRIES);
		clickCheckbox_byText(OpenBranch);
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check Node Creation
		checkTextIsContained_byXPathTable(TBL_LIST_NODES, OpenBranch);
		checkElementText_inSpecificTableColumn(TBL_LIST_NODES, OpenBranch,TXT_IP_ADDRESS,"192.168.108.4");
		checkElementText_inSpecificTableColumn(TBL_LIST_NODES, OpenBranch,TXT_BUSINESS_GROUP,"OpenBranch");
	
		clickRadioButton_ByXpath(RB_DATE);
		
		//Check Current time
		MyLogger.resultInfo("The current time is: " + selenium.getValue(IPF_JOB_TIME_HOUR)+":" +selenium.getValue(IPF_JOB_TIME_MINUTE));
		int currentHour = Integer.parseInt(selenium.getValue(IPF_JOB_TIME_HOUR));
		int currentMinute = Integer.parseInt(selenium.getValue(IPF_JOB_TIME_MINUTE));
				
		if ( currentMinute >= 58 )
		{
			type_byId(IPF_JOB_TIME_HOUR, String.valueOf(currentHour+1));
			type_byId(IPF_JOB_TIME_MINUTE, String.valueOf(currentMinute+2-60));
		}
		else
		{
			type_byId(IPF_JOB_TIME_MINUTE, String.valueOf(currentMinute+2));
		}
		
		MyLogger.resultInfo("Schedule the Job to Start in 2 minute");
		

		double stopTime = System.currentTimeMillis()/1000.0;
		clickButtonSave();
		updateMap(RETRIES);
		
		MyLogger.resultInfo("Intermediate actions took " + (stopTime-startTime) +" seconds");
		String row = getRow(TBL_LIST_JOBS, "SchAssignProf9");
		String columnStatus = getColumn(TBL_LIST_JOBS, TXT_STATUS);
		String columnAction = getColumn(TBL_LIST_JOBS, TXT_ACTION);
		
		//Check Job Creation
		checkText_byTablePos(TBL_LIST_JOBS, "SCHEDULED",row,columnStatus);
		checkText_byTablePos(TBL_LIST_JOBS, TXT_ASSIGN_PROFILE, row,columnAction);
		
		//Now Cancel the Job via View Detailed Status pop-up
		MyLogger.resultInfo("Cancel the Job via \"View Detailed Status\" pop-up");
		clickCheckbox_byText("SchAssignProf9");
		clickButton(BTN_VIEW_DETAILED_STATUS_JOB);
		updateMap(RETRIES);
		
		
		checkText_byTablePos(TBL_LIST_NODES, "SCHEDULED","1",getColumn(TBL_LIST_NODES, TXT_STATUS));
		
		clickCheckbox_byText(OpenBranch);
		clickButtonCancel();
		
		checkText_byTablePos(TBL_LIST_NODES, "CANCEL","1",getColumn(TBL_LIST_NODES, TXT_STATUS));
		 
		//Check View Detailed Status pop-up fields
		checkStatus(IPF_VIEW_JOB_ACTION, "disabled", "Input Field Job Action");
		checkValue_byId(IPF_VIEW_JOB_ACTION, TXT_ASSIGN_PROFILE);
		checkStatus(IPF_VIEW_TARGET_VERSION, "disabled", "Input Field Job Target Version");
		checkValue_byId(IPF_VIEW_TARGET_VERSION, "JobProfile");
		checkStatus(IPF_VIEW_NOTE, "disabled", "Input Field Job Note");
		checkValue_byId(IPF_VIEW_NOTE, "SchAssignProf9");
	
		clickButtonClose();
		updateMap(RETRIES);
	
		//Refresh Jobs list
		goToJobManagement();
		//Check Cloned Job Cancellation
		checkText_byTablePos(TBL_LIST_JOBS, "CANCEL",row,columnStatus);
	  
	    setMethodState();
	
	}

}