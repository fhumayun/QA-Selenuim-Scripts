package com.administration.jobmanagement;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;

public class JM14_JobManagement_EditScheduledTranfer extends SuperHelper implements PropertiesJobManagement {

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
	public void jobManagementEditScheduledTranfer() throws InterruptedException {
		
		classMethodLogger.log(); 
		//Add an Scheduled Transfer
	    clickButtonAdd();
	    updateMap(RETRIES);
	    
	    double startTime = System.currentTimeMillis()/1000.0;	 
	   
	    selectFromDropDown(SLC_JOB_ACTION, TXT_TRANSFER);
	    clickButton(BTN_SELECT_ACTION_INPUT);
	    updateMap(RETRIES);
	   
	    clickRadioButton_byText(osbLoadName);
		
	    clickButtonSave();
		updateMap(RETRIES);
		
		checkValue_byId(IPF_ACTION_INPUT, osbLoadName);
		
		type_byId(IPF_NOTE, "EditScheduledJob");
		
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
		String row = getRow(TBL_LIST_JOBS, "EditScheduledJob");
		String columnStatus = getColumn(TBL_LIST_JOBS, TXT_STATUS);
		String columnAction = getColumn(TBL_LIST_JOBS, TXT_ACTION);
		
		//Check Job Creation
		checkText_byTablePos(TBL_LIST_JOBS, "SCHEDULED",row,columnStatus);
		checkText_byTablePos(TBL_LIST_JOBS, TXT_TRANSFER, row,columnAction);
		
		//Edit the Scheduled Job is successful before the Job is in progress
		clickCheckbox_byText("EditScheduledJob");
		clickButtonEdit();
		updateMap(RETRIES);
		
		//Verify All Fields and modify Note
		checkSelectedValue_inDropDownList(SLC_JOB_ACTION, TXT_TRANSFER);
	    checkValue_byId(IPF_ACTION_INPUT, osbLoadName);
	    checkValue_byId(IPF_NOTE, "EditScheduledJob");
		checkStatus(By.xpath(RB_IMMEDIATE), "enabled", "Radio Button Immediate");
    	checkStatus(By.xpath(RB_IMMEDIATE), "unchecked", "Radio Button Immediate");
    	checkStatus(By.xpath(RB_DATE), "enabled", "Radio Button Date");
    	checkStatus(By.xpath(RB_DATE), "checked", "Radio Button Date");
		checkTextIsContained_byXPathTable(TBL_LIST_NODES, OpenBranch);
		checkElementText_inSpecificTableColumn(TBL_LIST_NODES, OpenBranch,TXT_IP_ADDRESS,"192.168.108.4");
		checkElementText_inSpecificTableColumn(TBL_LIST_NODES, OpenBranch,TXT_BUSINESS_GROUP,"OpenBranch");
	
		type_byId(IPF_NOTE, "EditScheduledJobNew");
		clickButtonSave();
    	updateMap(RETRIES);	
		
    	//Check Job Modification
    	String newRow = getRow(TBL_LIST_JOBS, "EditScheduledJobNew");
		checkText_byTablePos(TBL_LIST_JOBS, "SCHEDULED",newRow,columnStatus);
	
		//Now Check when the Job Status becomes IN PROGRESS
		
	    for(int i=0;i<30;i++)
	    {
	    	String jobStatus = selenium.getTable(TBL_LIST_JOBS+"." + newRow  + "." + columnStatus);
	    	if((jobStatus).equals("IN_PROGRESS"))
	    	{
	    		MyLogger.resultInfo("The Job is IN PROGRESS-Check that Edit button is disabled");
	    		clickCheckbox_byText("EditScheduledJobNew");
	    		checkStatus(BTN_EDIT_JOB,"disabled","Button Edit Job");
	    		break;
	    	}
	    	if(i==29)
	    	{
	    		 MyLogger.resultError("The Job never came in status IN PROGRESS!");
		         throw new InterruptedException("The Job never came in status IN PROGRESS");   
	    	}
	    	MyLogger.resultInfo("Wait for 4 sec and Refresh Jobs List again");
	        sleep(4000);
	        goToJobManagement();
	    }
		
		job.checkCompletion(180.0, newRow, columnStatus);
	    
	    setMethodState();
	
	}

}