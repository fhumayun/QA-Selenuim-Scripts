package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class JM05_JobManagement_AddImmediateTranfer extends SuperHelper implements PropertiesJobManagement {

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
	public void jobManagementAddImmediateTranfer() throws InterruptedException {
		
		classMethodLogger.log(); 
		//Add an Immediate Transfer
	    clickButtonAdd();
	    updateMap(RETRIES);
	    
	    selectFromDropDown(SLC_JOB_ACTION, TXT_TRANSFER);
	    clickButton(BTN_SELECT_ACTION_INPUT);
	    updateMap(RETRIES);
	   
	    clickRadioButton_byText(osbLoadName);
		
	    clickButtonSave();
		updateMap(RETRIES);
	
		checkValue_byId(IPF_ACTION_INPUT, osbLoadName);
		
		type_byId(IPF_NOTE, "ImTransfer3");
		
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
		
		clickButtonSave();
		updateMap(RETRIES);
	
		String row = getRow(TBL_LIST_JOBS, "ImTransfer3");
		String columnStatus = getColumn(TBL_LIST_JOBS, TXT_STATUS);
		String columnAction = getColumn(TBL_LIST_JOBS, TXT_ACTION);
		
		//Check Job Creation
		checkText_byTablePos(TBL_LIST_JOBS, "SCHEDULED",row,columnStatus);
		checkText_byTablePos(TBL_LIST_JOBS, TXT_TRANSFER, row,columnAction);
		
		//Check Job completion
		job.checkCompletion(180.0, row, columnStatus);
	   
	    setMethodState();
	
	}

}