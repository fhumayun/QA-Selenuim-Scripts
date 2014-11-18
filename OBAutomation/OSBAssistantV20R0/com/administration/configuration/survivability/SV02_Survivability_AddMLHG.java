package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV02_Survivability_AddMLHG extends SuperHelper implements PropertiesSurvivability {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		if(navigateToAdministration()){
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
		selectFromDropDown(SLC_BRANCHOFFICE, OpenBranch);
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void initializeWindowsMap() throws InterruptedException {
		initMap();
	}
	
	@AfterMethod(alwaysRun = true)
	public void getfocusClearWindowsBeforeMethod() throws InterruptedException {
		clearWindows();
	}
	
	@DataProvider(name = "MultiLineHuntGroupsData")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {"2107778001","Pilot",	TXT_HUNT_TYPE_PARALLEL,	"3600",	"2107778002","1,2,20,15"},
				 {"2107772001","Non pilot",	TXT_HUNT_TYPE_LINEAR,	"1800",	"2107772002","2,4,21,17"},
				 {"2107775001","Non pilot",	TXT_HUNT_TYPE_CYCLIC,	"900",	"2107775002","5,1,12,14"},
				 {"2107775201","Pilot",		TXT_HUNT_TYPE_UCD,		"450",		"2107775202","19"},
		};	
	}
	
	@Test (priority = 0,dataProvider = "MultiLineHuntGroupsData")
	public void survivabilityAddMLHG(String x1,String x2,String x3,String x4,String x5,String x6) throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab MLHG
		clickButton(TB_MULTI_LINE_HG);
		
		clickButtonAdd();
		updateMap(RETRIES);
		clickCheckbox_byID(CB_MULTI_LINE_HG);
		type_byId(IPF_MULTI_LINE_HG_PILOT, x1);
		selectFromDropDown(SLC_MULTI_LINE_HG_PILOT_TYPE, x2);
		selectFromDropDown(SLC_MULTI_LINE_HG_PILOT_HUNT_TYPE, x3);
		type_byId(IPF_MULTI_LINE_HG_NO_ANSWER, x4);
		type_byId(IPF_MULTI_LINE_HG_OVERFLOW, x5);
		type_byId(IPF_MULTI_LINE_HG_MEMBERS, x6);
		
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check creation
		checkText(x1);
		checkText(x2);
		checkText(x3);
		checkText(x4);
		checkText(x5);
		checkText(x6);
		
		clickButtonSave();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 1)
	public void applyChanges() throws InterruptedException {
		methodLogger.log();
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 2)
	public void verifySurvivabilityMLHGCreation() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		//Select Tab Interfaces
		clickButton(TB_MULTI_LINE_HG);
		
		//Verify creation
		checkText("2107778001");
		checkText("2107772001");
		checkText("2107775001");
		checkText("2107775201");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107778001", TXT_LIST_MLHG_PILOT_TYPE, "Pilot");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107778001", TXT_LIST_MLHG_HUNT_TYPE, "Parallel");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107778001", TXT_LIST_MLHG_NO_ANSWER_TIMER, "3600");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107778001", "Overflow Destination", "2107778002");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107778001", TXT_LIST_MLHG_MEMBERS, "1,2,20,15");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107772001", TXT_LIST_MLHG_PILOT_TYPE, "Non pilot");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107772001", TXT_LIST_MLHG_HUNT_TYPE, "Linear");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107772001", TXT_LIST_MLHG_NO_ANSWER_TIMER, "1800");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107772001", "Overflow Destination", "2107772002");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107772001", TXT_LIST_MLHG_MEMBERS, "2,4,21,17");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775001", TXT_LIST_MLHG_PILOT_TYPE, "Non pilot");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775001", TXT_LIST_MLHG_HUNT_TYPE, "Cyclic");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775001", TXT_LIST_MLHG_NO_ANSWER_TIMER, "900");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775001", "Overflow Destination", "2107775002");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775001", TXT_LIST_MLHG_MEMBERS, "5,1,12,14");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775201", TXT_LIST_MLHG_PILOT_TYPE, "Pilot");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775201", TXT_LIST_MLHG_HUNT_TYPE, "UCD");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775201", TXT_LIST_MLHG_NO_ANSWER_TIMER, "450");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775201", "Overflow Destination", "2107775202");
		checkElementText_inSpecificTableColumn(TBL_LIST_MLHG, "2107775201", TXT_LIST_MLHG_MEMBERS, "19");
	
		
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}	
}