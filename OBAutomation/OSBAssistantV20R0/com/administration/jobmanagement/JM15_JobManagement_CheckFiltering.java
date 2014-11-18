package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;

public class JM15_JobManagement_CheckFiltering extends SuperHelper implements PropertiesJobManagement {

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
	

	
	@Test (priority = 0)
	public void jobManagementFilterByID() throws InterruptedException {
		
		classMethodLogger.log(); 
	
		//Filter by job ID
		//First Retrieve the Job ID of ImTranferWav1 Job
		String row = getRow(TBL_LIST_JOBS, "ImTranferWav1");
		String columnJobID = getColumn(TBL_LIST_JOBS, TXT_JOB_ID);
		
	    String jobID = selenium.getTable(TBL_LIST_JOBS + "." + row + "." + columnJobID);
	    MyLogger.resultInfo("The ID if Job ImTranferWav1 is: " + jobID);
	    
	    //Now Filter
	    selectFromDropDown(SLC_JOB_FILTER_OPTIONS, TXT_JOB_ID);
	    type_byId(IPF_FILTER_JOB, jobID);
	    clickButton(BTN_APPLY_FILTER_JOB);
	    
	    //Check Filtering
	    checkText("ImTranferWav1");
		checkText_NotVisible("ClonedImTransferWav2");
		checkText_NotVisible("ImTransfer3");
		checkText_NotVisible("ClonedImTransfer4");
		checkText_NotVisible("ImAssignProf5");
		checkText_NotVisible("ClonedImAssignProf6");
		checkText_NotVisible("SchTranferWav7");
		checkText_NotVisible("SchTranfer8");
		checkText_NotVisible("SchAssignProf9");
		checkText_NotVisible("EditImJobFails");
		checkText_NotVisible("EditScheduledJobNew");
	
		//Clear Filtering
		clickButton(BTN_CLEAR_FILTER_JOB);
		checkText("ImTranferWav1");
		checkText("ClonedImTransferWav2");
		checkText("ImTransfer3");
		checkText("ClonedImTransfer4");
		checkText("ImAssignProf5");
		checkText("ClonedImAssignProf6");
		checkText("SchTranferWav7");
		checkText("SchTranfer8");
		checkText("SchAssignProf9");
		checkText("EditImJobFails");
		checkText("EditScheduledJobNew");
		
	    setMethodState();
	
	}

	@Test (priority = 1)
	public void jobManagementFilterByStatus() throws InterruptedException {
		
		methodLogger.log(); 
	
		//Filter by job Status
		selectFromDropDown(SLC_JOB_FILTER_OPTIONS, TXT_STATUS);
		selectFromDropDown(SLC_FILTER_STATUS, "CANCEL");
	    clickButton(BTN_APPLY_FILTER_JOB);
	    
	    //Check Filtering
	    checkText("ClonedImAssignProf6");
	    checkText("SchAssignProf9");
	    checkText_NotVisible("ImTranferWav1");
	    checkText_NotVisible("ClonedImTransferWav2");
	    checkText_NotVisible("SchTranferWav7");
		checkText_NotVisible("ImTransfer3");
		checkText_NotVisible("ClonedImTransfer4");
		checkText_NotVisible("ImAssignProf5");
		checkText_NotVisible("SchTranfer8");
		checkText_NotVisible("EditImJobFails");
		checkText_NotVisible("EditScheduledJobNew");
	
		//Clear Filtering
		clickButton(BTN_CLEAR_FILTER_JOB);
	
	    setMethodState();
	
	}
	
	@Test (priority = 2)
	public void jobManagementFilterByAction() throws InterruptedException {
		
		methodLogger.log(); 
	
		//Filter by job Action
		selectFromDropDown(SLC_JOB_FILTER_OPTIONS, TXT_ACTION);
		selectFromDropDown(SLC_FILTER_ACTION, TXT_TRANSFER_WAV_FILES);
	    clickButton(BTN_APPLY_FILTER_JOB);
	    
	    sleep(2000);
	    //Check Filtering
	    checkText("ImTranferWav1");
		checkText("ClonedImTransferWav2");
		checkText("SchTranferWav7");
		checkText_NotVisible("ImTransfer3");
		checkText_NotVisible("ClonedImTransfer4");
		checkText_NotVisible("ImAssignProf5");
		checkText_NotVisible("ClonedImAssignProf6");
		checkText_NotVisible("SchTranfer8");
		checkText_NotVisible("SchAssignProf9");
		checkText_NotVisible("EditImJobFails");
		checkText_NotVisible("EditScheduledJobNew");
		
	
		//Clear Filtering
		clickButton(BTN_CLEAR_FILTER_JOB);
	
	    setMethodState();
	
	}
	
	@Test (priority = 3)
	public void jobManagementFilterByNote() throws InterruptedException {
		
		methodLogger.log(); 
	
		//Filter by job Note
		selectFromDropDown(SLC_JOB_FILTER_OPTIONS, TXT_NOTE);
		type_byId(IPF_FILTER_JOB, "ImTranferWav1");
	    clickButton(BTN_APPLY_FILTER_JOB);
	    
	    //Check Filtering
	    checkText("ImTranferWav1");
		checkText_NotVisible("ClonedImTransferWav2");
		checkText_NotVisible("ImTransfer3");
		checkText_NotVisible("ClonedImTransfer4");
		checkText_NotVisible("ImAssignProf5");
		checkText_NotVisible("ClonedImAssignProf6");
		checkText_NotVisible("SchTranferWav7");
		checkText_NotVisible("SchTranfer8");
		checkText_NotVisible("SchAssignProf9");
		checkText_NotVisible("EditImJobFails");
		checkText_NotVisible("EditScheduledJobNew");
	
		//Clear Filtering
		clickButton(BTN_CLEAR_FILTER_JOB);
	
	    setMethodState();
	
	}
	
}