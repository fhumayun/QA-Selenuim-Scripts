package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC15_Security_ConfigureFirewall_WhiteList extends SuperHelper implements PropertiesSecurity {

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
	public void securityCreateFirewallWhiteList() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        clickButton(BTN_WHITE_CONFIGURE);
        updateMap(RETRIES);
    	
    	//Add a IP in White List
    	clickButtonAdd();
    	updateMap(RETRIES);
    	type_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.12.10");
    	type_byId(IPF_WHITE_PORT, "6070");
    	clickButtonSave();
      	updateMap(RETRIES);
      	
      	//Check IP in White List
      	checkText("10.1.12.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.12.10", TXT_PORT, "6070");
    	
    	//Add a Subnet in White List
    	clickButtonAdd();
    	updateMap(RETRIES);
    	type_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.72.0");
    	clickButtonSave();
      	updateMap(RETRIES);
    	
    	//Check Subnet in White List
      	checkText("10.1.72.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.72.0", TXT_PORT, "0");
    	
    	clickButtonSave();
    	updateMap(RETRIES);
    	
    	clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}

	@Test (priority = 1)
	public void verifySecurityFirewallWhiteListCreation() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        clickButton(BTN_WHITE_CONFIGURE);
        updateMap(RETRIES);
        
      	//Verify IP and Subnet in White List
      	checkTextIsContained_byXPathTable(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.12.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.12.10", TXT_PORT, "6070");
    	checkTextIsContained_byXPathTable(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.72.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.72.0", TXT_PORT, "0");
      
    	//Edit IP and verify fields
    	clickCheckbox_byText("10.1.12.10");
    	clickButton(BTN_WHITE_EDIT);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.12.10");
    	checkValue_byId(IPF_WHITE_PORT, "6070");
    	clickButtonCancel();
      	updateMap(RETRIES);
      	clickCheckbox_byText("10.1.12.10");
      	
    	//Edit Subnet and verify fields
    	clickCheckbox_byText("10.1.72.0");
    	clickButton(BTN_WHITE_EDIT);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.72.0");
    	checkValue_byId(IPF_WHITE_PORT, "0");
    	clickButtonCancel();
      	updateMap(RETRIES);
      	clickCheckbox_byText("10.1.72.0");
      	
    	clickButtonCancel();
    	updateMap(RETRIES);
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}

	@Test (priority = 2)
	public void securityModifyFirewallWhiteList() throws InterruptedException {

		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        clickButton(BTN_WHITE_CONFIGURE);
        updateMap(RETRIES);
        
       	//Edit IP and modify fields
    	clickCheckbox_byText("10.1.12.10");
    	clickButton(BTN_WHITE_EDIT);
    	updateMap(RETRIES);
    	type_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.12.20");
    	type_byId(IPF_WHITE_PORT, "7080");
    	clickButtonSave();
      	updateMap(RETRIES);
      	
     	//Check IP Modification
      	checkText("10.1.12.20");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.12.20", TXT_PORT, "7080");
    	
    	//Edit Subnet and modify fields
    	clickCheckbox_byText("10.1.72.0");
    	clickButton(BTN_WHITE_EDIT);
    	updateMap(RETRIES);
    	type_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.82.0");
    	type_byId(IPF_WHITE_PORT, "8090");
    	clickButtonSave();
      	updateMap(RETRIES);
      
    	//Check Subnet Modification
      	checkText("10.1.82.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.82.0", TXT_PORT, "8090");
    
    	clickButtonSave();
    	updateMap(RETRIES);
    	
        clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 3)
	public void verifySecurityFirewallWhiteListModification() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        clickButton(BTN_WHITE_CONFIGURE);
        updateMap(RETRIES);
        
      	//Verify IP and Subnet in White List
      	checkTextIsContained_byXPathTable(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.12.20");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.12.20", TXT_PORT, "7080");
    	checkTextIsContained_byXPathTable(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.82.0");
    	checkElementText_inSpecificTableColumn(TBL_LIST_WHITE_IPS_SUBNETS, "10.1.82.0", TXT_PORT, "8090");
      
    	//Edit IP and verify fields
    	clickCheckbox_byText("10.1.12.20");
    	clickButton(BTN_WHITE_EDIT);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.12.20");
    	checkValue_byId(IPF_WHITE_PORT, "7080");
    	clickButtonCancel();
      	updateMap(RETRIES);
      	clickCheckbox_byText("10.1.12.20");
      	
    	//Edit Subnet and verify fields
    	clickCheckbox_byText("10.1.82.0");
    	clickButton(BTN_WHITE_EDIT);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_WHITE_IP_ADDRESS_SUBNET, "10.1.82.0");
    	checkValue_byId(IPF_WHITE_PORT, "8090");
    	clickButtonCancel();
      	updateMap(RETRIES);
      	clickCheckbox_byText("10.1.82.0");
    	clickButtonCancel();
    	updateMap(RETRIES);
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 4)
	public void securityDeleteFirewallWhiteList() throws InterruptedException {

		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        clickButton(BTN_WHITE_CONFIGURE);
        updateMap(RETRIES);
        
       	//Delete IP and Subnet from White List
    	clickCheckbox_byText("10.1.12.20");
    	clickCheckbox_byText("10.1.82.0");
     	clickButtonDelete();
     	
    	//Check Deletion
      	checkText_NotVisible("10.1.12.20");
      	checkText_NotVisible("10.1.82.0");
       
     	clickButtonSave();
    	updateMap(RETRIES);
    	
    	clickButtonSave();
    	updateMap(RETRIES);
    	applyChangesWithConfirmation();
		setMethodState();
  
	}
	
	@Test (priority = 5)
	public void verifySecurityFirewallWhiteListDeletion() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Firewall
        clickButton(TB_FIREWALL);
        
        clickButton(BTN_WHITE_CONFIGURE);
        updateMap(RETRIES);
        
        //Verify Deletion
      	checkText_NotVisible("10.1.12.20");
      	checkText_NotVisible("10.1.82.0");

    	clickButtonCancel();
    	updateMap(RETRIES);
    	
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}
}