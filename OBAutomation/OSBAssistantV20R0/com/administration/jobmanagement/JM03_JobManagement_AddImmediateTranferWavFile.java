package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class JM03_JobManagement_AddImmediateTranferWavFile extends SuperHelper implements PropertiesJobManagement {

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
	public void jobManagementAddImmediateTranferWavFile() throws InterruptedException {
		
		classMethodLogger.log(); 
		
		//Set Element per Page to 20
		selectFromDropDown(SLC_ITEMS_PER_PAGE_MAIN_LIST, "20");
		
		//Add an Immediate Transfer Wav File
	    clickButtonAdd();
	    updateMap(RETRIES);
	    
	    selectFromDropDown(SLC_JOB_ACTION, TXT_TRANSFER_WAV_FILES);
	    clickButton(BTN_SELECT_ACTION_INPUT);
	    updateMap(RETRIES);
	   
	    uploadFile(IPF_UPLOAD_WAV_FILE, LocalFolder+"\\WavFiles\\queue-thankyou.wav");
		
	    clickButtonSave();
		updateMap(RETRIES);
		
		checkValue_byId(IPF_ACTION_INPUT, "queue-thankyou.wav");
		
		type_byId(IPF_NOTE, "ImTranferWav1");
		
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
	
		String row = getRow(TBL_LIST_JOBS, "ImTranferWav1");
		String columnStatus = getColumn(TBL_LIST_JOBS, TXT_STATUS);
		String columnAction = getColumn(TBL_LIST_JOBS, TXT_ACTION);
		
		//Check Job Creation
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