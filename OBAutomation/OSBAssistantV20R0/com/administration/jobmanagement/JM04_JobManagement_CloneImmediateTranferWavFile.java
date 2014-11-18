package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class JM04_JobManagement_CloneImmediateTranferWavFile extends SuperHelper implements PropertiesJobManagement {

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
	public void jobManagementCloneImmediateTranferWavFile() throws InterruptedException {
		
		classMethodLogger.log(); 
		clickCheckbox_byText("ImTranferWav1");
		
		clickButtonClone();
		
		//Clone the Job
	    updateMap(RETRIES);
	    
		//Check Clone Schedule pop-up
	    checkSelectedValue_inDropDownList(SLC_JOB_ACTION, TXT_TRANSFER_WAV_FILES);
		checkValue_byId(IPF_ACTION_INPUT, "queue-thankyou.wav");
		checkTextIsContained_byXPathTable(TBL_LIST_NODES, OpenBranch);
		checkElementText_inSpecificTableColumn(TBL_LIST_NODES, OpenBranch,TXT_IP_ADDRESS,"192.168.108.4");
		checkElementText_inSpecificTableColumn(TBL_LIST_NODES, OpenBranch,TXT_BUSINESS_GROUP,"OpenBranch");
		
		type_byId(IPF_NOTE, "ClonedImTransferWav2");
		
		clickButtonSave();
		updateMap(RETRIES);
	

		String row = getRow(TBL_LIST_JOBS, "ClonedImTransferWav2");
		String columnStatus = getColumn(TBL_LIST_JOBS, TXT_STATUS);
		String columnAction = getColumn(TBL_LIST_JOBS, TXT_ACTION);
		
		//Check Cloned Job Creation
		checkText_byTablePos(TBL_LIST_JOBS, "SCHEDULED",row,columnStatus);
		checkText_byTablePos(TBL_LIST_JOBS, TXT_TRANSFER_WAV_FILES, row,columnAction);
		
		//Check Cloned Job completion
		job.checkCompletion(40.0, row, columnStatus);
	   
	    setMethodState();
	
	}

}