package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS06_NetworkServices_TrafficShapingFilters extends SuperHelper implements PropertiesNetworkServices {
	
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
	public void networkServicesEditClassAddFilters() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		
		//Edit a Class
	    clickCheckbox_byText("SFQ");
	    clickButton(BTN_TRAFFIC_EDIT);
		updateMap(RETRIES);
		
		//Select Tab Rule filters
		clickButton(TB_TRAFFIC_RULE_FILTERS);
		type_byId(IPF_ADD_RULE, "10.1.252.15");
		clickButtonAdd();
		//Check creation
		checkText("10.1.252.15");
		
		type_byId(IPF_ADD_RULE, "10.1.252.147:8080");
		clickButtonAdd();
		//Check creation
		checkText("10.1.252.147:8080");
		
		sleep(2000);
		//Select Tab Mark filters
		clickButton(TB_TRAFFIC_MARK_FILTERS);
		type_byId(IPF_ADD_MARK_FIELD, "555888000");
		clickButtonAdd();
		//Check Creation
		checkText("555888000");
		
		clickButtonSave();	
		
		updateMap(RETRIES);
	
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifyNetworkServicesClassFilterCreation() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
		
		updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		
		//Edit the Class
	    clickCheckbox_byText("SFQ");
	    clickButton(BTN_TRAFFIC_EDIT);
		updateMap(RETRIES);
		
		//Select Tab Rule filters
		clickButton(TB_TRAFFIC_RULE_FILTERS);
		//Verify creation
		checkText("10.1.252.15");
		checkText("10.1.252.147:8080");
		
		sleep(2000);
		//Select Tab Mark filters
		clickButton(TB_TRAFFIC_MARK_FILTERS);
		//Verify Creation
		checkText("555888000");
		
		clickButtonCancel();
	    updateMap(RETRIES);
			
	    clickButtonCancel();
	    updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void networkServicesEditClassDeleteFilters() throws InterruptedException {
		
	    methodLogger.log(); 
		goToAdministrationNetworkServices();
		updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		  
		//Edit the Class
	    clickCheckbox_byText("SFQ");
	    clickButton(BTN_TRAFFIC_EDIT);
		updateMap(RETRIES);
		
		//Select Tab Rule filters and Delete Filters
		clickButton(TB_TRAFFIC_RULE_FILTERS);
		clickCheckbox_byText("10.1.252.15");
		clickCheckbox_byText("10.1.252.147:8080");
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible("10.1.252.15");
		checkText_NotVisible("10.1.252.147:8080");
		
		sleep(2000);
		
		//Select Tab Mark filters and Delete Filters
		clickButton(TB_TRAFFIC_MARK_FILTERS);
		clickCheckbox_byText("555888000");
		clickButtonDelete();
		//Check Deletion
		checkText_NotVisible("555888000");
		
		clickButtonSave();	
		
		updateMap(RETRIES);
	
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifyNetworkServicesClassFilterDeletion() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationNetworkServices();
		
		updateMap(RETRIES);
		
		//Select Tab Traffic Shaping
		clickButton(TB_TRAFFIC);
		     
		//Edit the Class
	    clickCheckbox_byText("SFQ");
	    clickButton(BTN_TRAFFIC_EDIT);
		updateMap(RETRIES);
		
		//Select Tab Rule filters
		clickButton(TB_TRAFFIC_RULE_FILTERS);
		//Verify deletion
		checkText_NotVisible("10.1.252.15");
		checkText_NotVisible("10.1.252.147:8080");
		
		sleep(2000);
		//Select Tab Mark filters
		clickButton(TB_TRAFFIC_MARK_FILTERS);
		//Verify Deletion
		checkText_NotVisible("555888000");
		
		clickButtonCancel();
	    updateMap(RETRIES);
			
	    clickButtonCancel();
	    updateMap(RETRIES);
		setMethodState();
	}
}