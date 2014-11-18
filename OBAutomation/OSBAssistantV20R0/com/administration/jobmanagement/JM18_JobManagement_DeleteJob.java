package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class JM18_JobManagement_DeleteJob extends SuperHelper implements PropertiesJobManagement {

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
	public void jobManagementDeleteOneJob() throws InterruptedException {
		
		classMethodLogger.log(); 
		//Delete one Job
		clickCheckbox_byText("ImTranferWav1");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("ImTranferWav1");
	    setMethodState();
	
	}

	@Test (priority = 1)
	public void jobManagementDeleteAllJobs() throws InterruptedException {
		
		methodLogger.log(); 
		//Delete all Jobs
		clickCheckbox_All();
		clickButtonDelete();
		
		//Check Deletion
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
		checkText_NotVisible("ProfImTranferWav");
		checkText_NotVisible("ProfSchTranferWav");	
		
		//Set Element per Page to 10
		selectFromDropDown(SLC_ITEMS_PER_PAGE_MAIN_LIST, "10");
		
	    setMethodState();
	
	}
	
	
	@Test (priority = 2)
	public void deleteProfileusedForJob() throws InterruptedException {
		
		methodLogger.log(); 
		goToProfilesList();
		
		//Delete all Jobs
		clickCheckbox_byText("JobProfile");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("JobProfile");
	
	    setMethodState();
	
	}
	
}