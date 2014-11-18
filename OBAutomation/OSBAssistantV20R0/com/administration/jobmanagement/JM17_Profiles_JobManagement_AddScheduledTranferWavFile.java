package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;

public class JM17_Profiles_JobManagement_AddScheduledTranferWavFile extends SuperHelper implements PropertiesJobManagement {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		goToOpenScapeBranch();
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
	public void profileJobManagementAddImmediateTranferWavFile() throws InterruptedException {
		
		
		classMethodLogger.log(); 
		selectFromDropDown(SLC_SELECTPROFILE, "JobProfile");
		
		//Go to Profiles Management and Create scheduled Job
		goToProfilesManagement();
		
		clickButton(BTN_CREATE_JOB);
		updateMap(RETRIES);
		    
		double startTime = System.currentTimeMillis()/1000.0;	 
		selectFromDropDown(SLC_JOB_ACTION, TXT_TRANSFER_WAV_FILES);
		clickButton(BTN_SELECT_ACTION_INPUT);
		updateMap(RETRIES);
		   
	    uploadFile(IPF_UPLOAD_WAV_FILE, LocalFolder+"\\WavFiles\\queue-thankyou.wav");
			
		clickButtonSave();
	    updateMap(RETRIES);
			
			checkValue_byId(IPF_ACTION_INPUT, "queue-thankyou.wav");
			
			type_byId(IPF_NOTE, "ProfSchTranferWav");
			
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
			
			
			//Check Job Creation by going to Job Management
			goToJobManagement();
			
			String row = getRow(TBL_LIST_JOBS, "ProfSchTranferWav");
			String columnStatus = getColumn(TBL_LIST_JOBS, TXT_STATUS);
			String columnAction = getColumn(TBL_LIST_JOBS, TXT_ACTION);
			
		
			checkText_byTablePos(TBL_LIST_JOBS, "SCHEDULED",row,columnStatus);
			checkText_byTablePos(TBL_LIST_JOBS, TXT_TRANSFER_WAV_FILES, row,columnAction);
			
			//Check Job completion
			MyLogger.resultInfo("Wait for 30 seconds and Refresh Jobs List again");
			sleep(30000);
			goToJobManagement();
			
			//Check that the Job Status is still Scheduled
			MyLogger.resultInfo("Check that the Job Status is still Scheduled");
			checkText_byTablePos(TBL_LIST_JOBS, "SCHEDULED",row,columnStatus);
			
			job.checkCompletion(120.0, row, columnStatus);
		   
		    setMethodState();
		
	}

}