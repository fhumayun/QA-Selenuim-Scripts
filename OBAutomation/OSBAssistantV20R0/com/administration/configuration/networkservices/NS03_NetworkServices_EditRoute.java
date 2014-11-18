package com.administration.configuration.networkservices;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class NS03_NetworkServices_EditRoute extends SuperHelper implements PropertiesNetworkServices {

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
	public void networkServicesEditRoute() throws InterruptedException {
		
		
		classMethodLogger.log(); 
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to Routing tab
        clickButton(TB_ROUTING);
        
        //Edit the Route
        clickCheckbox_byText("10.11.222.10");
        clickButton(BTN_EDIT_ROUTE);
        updateMap(RETRIES);
        
        //Modify values in Route fields
        type_byId(IPF_ROUTE_DESTINATION, "10.11.222.20");
    
        
        clickButtonSave();
        updateMap(RETRIES);
        
        //Check Route Modification
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTES, "10.11.222.20");
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTES, "255.255.255.224");
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTES, "192.168.108.3");
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTES, "Interface1");
  
        clickButtonSave();
        
        updateMap(RETRIES);
        applyChangesWithConfirmation();
		setMethodState();
   
	}
	
	
	@Test (priority = 1)
	public void verifyNetworkServicesRouteModification() throws InterruptedException {
			
		methodLogger.log(); 
		checkOBStatusAfterRestart(OpenBranch);
		goToAdministrationNetworkServices();
        updateMap(RETRIES);
        
        //Go to Routing tab
        clickButton(TB_ROUTING);
        
        //Verify Route Modification
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTES, "10.11.222.20");
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTES, "255.255.255.224");
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTES, "192.168.108.3");
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTES, "Interface1");
  
        //Edit the Route
        clickCheckbox_byText("10.11.222.20");
        clickButton(BTN_EDIT_ROUTE);
        updateMap(RETRIES);
        
        //Verify values in Route fields
        checkStatus(IPF_ROUTE_DESTINATION, "enabled", "Input Field Route Destination");
        checkValue_byId(IPF_ROUTE_DESTINATION, "10.11.222.20");
        checkStatus(IPF_ROUTE_NETMASK, "enabled", "Input Field Route Netmask");
        checkValue_byId(IPF_ROUTE_NETMASK, "255.255.255.224");
        checkStatus(IPF_ROUTE_GATEWAY, "enabled", "Input Field Route Gateway");
        checkValue_byId(IPF_ROUTE_GATEWAY, "192.168.108.3");
        checkStatus(SLC_ROUTE_INTERFACE, "enabled", "Drop-Down List Route Interfaces");
        checkSelectedValue_inDropDownList(SLC_ROUTE_INTERFACE, "Interface1");
    
        clickButtonCancel();
		updateMap(RETRIES);
		
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
   
	}


}