package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class JM16_Profiles_JobManagement_AddImmediateTranferWavFile extends SuperHelper implements PropertiesJobManagement {

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
		
		//Go to Profiles Management and Create Immediate Job
		goToProfilesManagement();
		
		//Add an Immediate Transfer Wav File
	    clickButton(BTN_CREATE_JOB);
	    updateMap(RETRIES);
	    
	    selectFromDropDown(SLC_JOB_ACTION, TXT_TRANSFER_WAV_FILES);
	    clickButton(BTN_SELECT_ACTION_INPUT);
	    updateMap(RETRIES);
	   
	    uploadFile(IPF_UPLOAD_WAV_FILE, LocalFolder+"\\WavFiles\\queue-thankyou.wav");
		
	    clickButtonSave();
		updateMap(RETRIES);
		
		checkValue_byId(IPF_ACTION_INPUT, "queue-thankyou.wav");
		
		type_byId(IPF_NOTE, "ProfImTranferWav");
		
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
		checkElementText_inSpecificTableColumn(TBL_LIST_NODES, OpenBranch,TXT_COMM_SYSTEM,Switch);
		
		clickButtonSave();
		updateMap(RETRIES);
	
		//Check Job Creation by going to Job Management
		goToJobManagement();
		
		String row = getRow(TBL_LIST_JOBS, "ProfImTranferWav");
		String columnStatus = getColumn(TBL_LIST_JOBS, TXT_STATUS);
		String columnAction = getColumn(TBL_LIST_JOBS, TXT_ACTION);
		
		
		checkText_byTablePos(TBL_LIST_JOBS, "SCHEDULED",row,columnStatus);
		checkText_byTablePos(TBL_LIST_JOBS, TXT_TRANSFER_WAV_FILES, row,columnAction);
		
		//Check Job completion
		job.checkCompletion(40.0, row, columnStatus);
	   
		//Check that the Completed Job Cannot be Edited and Canceled
		clickCheckbox_byText("ImTranferWav1");
		checkStatus(BTN_EDIT_JOB,"disabled","Button Edit Job");
		checkStatus(BTN_CANCEL_JOB,"disabled","Button Cancel Job");
		clickCheckbox_byText("ImTranferWav1");
		setMethodState();
	
	}

}