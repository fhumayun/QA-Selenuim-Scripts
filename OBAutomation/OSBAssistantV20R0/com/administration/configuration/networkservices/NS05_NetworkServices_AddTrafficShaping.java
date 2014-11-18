package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS05_NetworkServices_AddTrafficShaping extends SuperHelper implements PropertiesNetworkServices {
	
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

	
	@Test (priority = 0)
	public void networkServicesAddClassNoParent() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		
		//Enable Traffic shaping 
	    if(!getCheckboxStatus(CB_ENABLE_TRAFFIC))
		clickCheckbox_byID(CB_ENABLE_TRAFFIC);
		
		//Verify that the Add button becomes enabled
	    checkStatus(BTN_ADD_CLASS, "enabled", "Button Add Class");
	    
		//Click Button Add
		clickButtonAdd();
		updateMap(RETRIES);
		
		
		//Change selectors
		selectFromDropDown(SLC_LEAF_QUEUING, TXT_LEAF_QUEUING_SFQ);
		selectFromDropDown(SLC_INTERFACE, "all");
		
		//Type data
		type_byId(IPF_CLASS_ID_FIELD, "11");
		type_byId(IPF_DEFAULT_CLASS_ID_FIELD, "11");
		type_byId(IPF_DESCRIPTION, "12");
		type_byId(IPF_MTU, "13");
		type_byId(IPF_PRIORITY, "14");
		type_byId(IPF_RATE, "15");
		type_byId(IPF_CEILING_RATE, "16");
		type_byId(IPF_BURST, "17");
		type_byId(IPF_CEILING_BURST, "18");
		type_byId(IPF_SFQ_QUANTUM, "19");
		type_byId(IPF_SFQ_PERTURBATIC, "20");
		
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Class creation
		checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "11");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "12");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "all");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "15");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "SFQ");
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyNetworkServicesClassCreationNoParent() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
		
		updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		
		checkStatus(CB_ENABLE_TRAFFIC,"enabled","Checkbox Enable Traffic"); 
	    checkStatus(CB_ENABLE_TRAFFIC,"checked","Checkbox Enable Traffic"); 
	        
		//Verify Class creation
		checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "11");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "12");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "all");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "15");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "SFQ");
		
		//Edit the Class and verify all the fields
	    clickCheckbox_byText("SFQ");
	    clickButton(BTN_TRAFFIC_EDIT);
		updateMap(RETRIES);
		
	
		checkValue_byId(IPF_CLASS_ID_FIELD, "11");
		checkValue_byId(IPF_DEFAULT_CLASS_ID_FIELD, "11");
		checkValue_byId(IPF_DESCRIPTION, "12");
		checkValue_byId(IPF_MTU, "13");
		checkValue_byId(IPF_PRIORITY, "14");
		checkValue_byId(IPF_RATE, "15");
		checkValue_byId(IPF_CEILING_RATE, "16");
		checkValue_byId(IPF_BURST, "17");
		checkValue_byId(IPF_CEILING_BURST, "18");
		checkValue_byId(IPF_SFQ_QUANTUM, "19");
		checkValue_byId(IPF_SFQ_PERTURBATIC, "20");
		
		checkSelectedValue_inDropDownList(SLC_LEAF_QUEUING, "SFQ");
		checkSelectedValue_inDropDownList(SLC_INTERFACE, "all");
		
		clickButtonCancel();
	    updateMap(RETRIES);
			
	    clickButtonCancel();
	    updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void networkServicesAddClassWithParent() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		  
		//Click Button Add
		clickButtonAdd();
		updateMap(RETRIES);
		
		//Change selectors
		selectFromDropDown(SLC_LEAF_QUEUING, TXT_LEAF_QUEUING_NONE);
		selectFromDropDown(SLC_INTERFACE, "Interface1");
		
		//Type data
		type_byId(IPF_PARENT_CLASS_ID, "11");
		type_byId(IPF_DESCRIPTION, "Class with Parent");
		type_byId(IPF_CLASS_ID_FIELD, "21");
		type_byId(IPF_RATE, "25");

		
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Class creation
		checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "21");
		checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "Interface1");
		checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "Class with Parent");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "25");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "None");
	   
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyNetworkServicesClassCreationWithParent() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
		
		updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		     
		//Verify Class creation 
		checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "21");
		checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "Interface1");
		checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "Class with Parent");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "25");
	    checkTextIsContained_byXPathTable(TBL_LIST_CLASSES, "None");
	  
		//Edit the Class and verify all the fields
	    clickCheckbox_byText("None");
	    clickButton(BTN_TRAFFIC_EDIT);
		updateMap(RETRIES);
		
	
		checkValue_byId(IPF_PARENT_CLASS_ID, "11");
		checkValue_byId(IPF_DESCRIPTION, "Class with Parent");
		checkValue_byId(IPF_CLASS_ID_FIELD, "21");
		checkValue_byId(IPF_RATE, "25");

		checkSelectedValue_inDropDownList(SLC_LEAF_QUEUING, TXT_LEAF_QUEUING_NONE);
		checkSelectedValue_inDropDownList(SLC_INTERFACE, "Interface1");
		
		clickButtonCancel();
	    updateMap(RETRIES);
			
	    clickButtonCancel();
	    updateMap(RETRIES);
		setMethodState();
	}
}