package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT07_AutoAttendant_CreateRouting extends SuperHelper implements PropertiesAutoAttendant {

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
	public void autoAttendantCreateRouting() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
          
        //Go to Routing tab and create Routing
        clickButton(TB_ROUTING);
       
        clickButtonAdd();
        updateMap(RETRIES);
    
        type_byId(IPF_ROUTING_NAME, "AutoRouting");
        selectFromDropDown(SLC_ROUTING_METHOD, "IP/FQDN");
        type_byId(IPF_IP_FQDN_DN, "10.1.252.13");
        selectFromDropDown(SLC_MENU1, "Auto1");
        selectFromDropDown(SLC_MENU2, "Auto22");
        selectFromDropDown(SLC_MENU3, "Auto3");
        selectFromDropDown(SLC_INITIAL_GREETING, "goodbye.wav");
        clickCheckbox_byID(CB_FORWARD_TO_ORIGINAL_DEST);
        type_byId(IPF_ROUTING_DEFAULT_DESTINATION, "11");
        type_byId(IPF_ROUTING_CODE, "21");
    	clickButtonSave();     
	    updateMap(RETRIES);
	    
	    //Check Routing Creation
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTING, "AutoRouting");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_ROUTING_METHOD, "IP/FQDN");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_IP_FQDN_DN, "10.1.252.13");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_MENU1, "Auto1");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_MENU2, "Auto22");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_MENU3, "Auto3");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_INITIAL_GREETING, "goodbye.wav");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_DEFAULT_DESTINATION, "11");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_ROUTING_CODE, "21");
	    checkElement(IMG_FORWARD_TO_ORIGINAL_DEST_ENABLED);
    
    	clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyAutoAttendantRoutingCreation() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Go to Routing tab
        clickButton(TB_ROUTING);
       
        //Verify Routing Creation
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTING, "AutoRouting");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_ROUTING_METHOD, "IP/FQDN");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_IP_FQDN_DN, "10.1.252.13");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_MENU1, "Auto1");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_MENU2, "Auto22");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_MENU3, "Auto3");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_INITIAL_GREETING, "goodbye.wav");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_DEFAULT_DESTINATION, "11");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRouting", TXT_ROUTING_CODE, "21");
	    checkElement(IMG_FORWARD_TO_ORIGINAL_DEST_ENABLED);
    
    	//Edit Routing and Verify fields
    	clickCheckbox_byText("AutoRouting");
    	clickButtonEdit();
    	updateMap(RETRIES);
    	
    	checkValue_byId(IPF_ROUTING_NAME, "AutoRouting");
        checkSelectedValue_inDropDownList(SLC_ROUTING_METHOD, "IP/FQDN");
        checkValue_byId(IPF_IP_FQDN_DN, "10.1.252.13");
        checkSelectedValue_inDropDownList(SLC_MENU1, "Auto1");
        checkSelectedValue_inDropDownList(SLC_MENU2, "Auto22");
        checkSelectedValue_inDropDownList(SLC_MENU3, "Auto3");
        checkSelectedValue_inDropDownList(SLC_INITIAL_GREETING, "goodbye.wav");
        checkStatus(CB_FORWARD_TO_ORIGINAL_DEST,"checked","Checkbox Forward to Original Destination");
        checkValue_byId(IPF_ROUTING_DEFAULT_DESTINATION, "11");
        checkValue_byId(IPF_ROUTING_CODE, "21");
      	
	    clickButtonCancel();
	    updateMap(RETRIES);
	    clickCheckbox_byText("AutoRouting");
	    
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}