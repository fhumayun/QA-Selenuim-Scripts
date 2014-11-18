package com.administration.jobmanagement;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.administration.configuration.voip.PropertiesVoip;
import com.helper.SuperHelper;
import com.profiles.configuration.alarms.ConfigureProfileAlarms;
import com.profiles.list.Profiles_GeneralMethods;

public class JM07_JobManagement_AddImmediateAssignProfile extends SuperHelper implements PropertiesJobManagement,PropertiesVoip {

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
	Profiles_GeneralMethods pr = new Profiles_GeneralMethods();
	ConfigureProfileAlarms al = new ConfigureProfileAlarms();
	
	@Test (priority = 0)
	public void jobManagementCreateProperProfile() throws InterruptedException {
		
		classMethodLogger.log(); 
		//Retrieve the Mode of the OpenBranch
		selectFromDropDown(SLC_SELECTSYSTEM, Switch);
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
		goToAdministrationVoip();
		updateMap(RETRIES);
		String obMode = selenium.getSelectedLabel(SLC_MODE);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		//Now go to profiles and create a profile with this mode
		goToProfilesList();
		pr.createProfile("JobProfile",obMode,"V2.R0");
		//Configure this Profile for alarms
		selectFromDropDown(SLC_SELECTPROFILE, "JobProfile");
		
		al.configureProfileForAlarms();
		
		setMethodState();
	
	}

	@Test (priority = 1)
	public void jobManagementAddImmediateAddignProfile() throws InterruptedException {
		
		methodLogger.log(); 
		goToJobManagement();
		//Add an Immediate Transfer Assign Profile
	    clickButtonAdd();
	    updateMap(RETRIES);
	    
	    selectFromDropDown(SLC_JOB_ACTION, TXT_ASSIGN_PROFILE);
	    clickButton(BTN_SELECT_ACTION_INPUT);
	    updateMap(RETRIES);
	   
	    clickRadioButton_byText("JobProfile");
		
	    clickButtonSave();
		updateMap(RETRIES);
	
		checkValue_byId(IPF_ACTION_INPUT, "JobProfile");
		
		type_byId(IPF_NOTE, "ImAssignProf5");
		
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
	
		String row = getRow(TBL_LIST_JOBS, "ImAssignProf5");
		String columnStatus = getColumn(TBL_LIST_JOBS, TXT_STATUS);
		String columnAction = getColumn(TBL_LIST_JOBS, TXT_ACTION);
		
		//Check Job Creation
		checkText_byTablePos(TBL_LIST_JOBS, "SCHEDULED",row,columnStatus);
		checkText_byTablePos(TBL_LIST_JOBS, TXT_ASSIGN_PROFILE, row,columnAction);
		
		//Check Job completion
		job.checkCompletion(40.0, row, columnStatus);
	   
	    setMethodState();
	
	}

	
	 @Test(priority = 2)
	 public void verifyProfileAssignment() throws InterruptedException {
	    	
		//Go to Alarms area of the OpenBranch and check that the Configuration is successful
		methodLogger.log();
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
	    al.verifyProfileAlarmsConfiguration();
		setMethodState();
	   }
}