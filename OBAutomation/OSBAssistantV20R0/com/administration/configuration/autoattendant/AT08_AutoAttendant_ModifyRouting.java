package com.administration.configuration.autoattendant;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class AT08_AutoAttendant_ModifyRouting extends SuperHelper implements PropertiesAutoAttendant {

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
	public void autoAttendantModifyRouting() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
          
        //Go to Routing tab
        clickButton(TB_ROUTING);
       
        //Edit Routing and modify fields
    	clickCheckbox_byText("AutoRouting");
    	clickButtonEdit();
    	updateMap(RETRIES);
    
        type_byId(IPF_ROUTING_NAME, "AutoRoutingNew");
        selectFromDropDown(SLC_ROUTING_METHOD, "DN");
        type_byId(IPF_IP_FQDN_DN, "2106923616");
        selectFromDropDown(SLC_MENU1, "Auto22");
        selectFromDropDown(SLC_MENU2, "Auto1");
        selectFromDropDown(SLC_MENU3, "Auto3");
        selectFromDropDown(SLC_INITIAL_GREETING, "queue-thankyou.wav");
        checkStatus(CB_FORWARD_TO_ORIGINAL_DEST,"disabled","Checkbox Forward to Original Destination");
        type_byId(IPF_ROUTING_DEFAULT_DESTINATION, "12");
        type_byId(IPF_ROUTING_CODE, "22");
    	clickButtonSave();     
	    updateMap(RETRIES);
	    
	    //Check Routing Modification
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTING, "AutoRoutingNew");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_ROUTING_METHOD, "DN");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_IP_FQDN_DN, "2106923616");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_MENU1, "Auto22");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_MENU2, "Auto1");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_MENU3, "Auto3");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_INITIAL_GREETING, "queue-thankyou.wav");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_DEFAULT_DESTINATION, "12");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_ROUTING_CODE, "22");
	    checkElement_NotPresent(IMG_FORWARD_TO_ORIGINAL_DEST_ENABLED);
    
    	clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}

	@Test (priority = 1)
	public void verifyAutoAttendantRoutingModification() throws InterruptedException {
		
		methodLogger.log(); 
		goToAdministrationAutoAttendant();
        updateMap(RETRIES);
        
        //Go to Routing tab
        clickButton(TB_ROUTING);
       
        //Check Routing Modification
        checkTextIsContained_byXPathTable(TBL_LIST_ROUTING, "AutoRoutingNew");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_ROUTING_METHOD, "DN");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_IP_FQDN_DN, "2106923616");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_MENU1, "Auto22");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_MENU2, "Auto1");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_MENU3, "Auto3");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_INITIAL_GREETING, "queue-thankyou.wav");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_DEFAULT_DESTINATION, "12");
    	checkElementText_inSpecificTableColumn(TBL_LIST_ROUTING, "AutoRoutingNew", TXT_ROUTING_CODE, "22");
	    checkElement_NotPresent(IMG_FORWARD_TO_ORIGINAL_DEST_ENABLED);

    	//Edit Routing and Verify fields
    	clickCheckbox_byText("AutoRoutingNew");
    	clickButtonEdit();
    	updateMap(RETRIES);
    	
    	checkValue_byId(IPF_ROUTING_NAME, "AutoRoutingNew");
        checkSelectedValue_inDropDownList(SLC_ROUTING_METHOD, "DN");
        checkValue_byId(IPF_IP_FQDN_DN, "2106923616");
        checkSelectedValue_inDropDownList(SLC_MENU1, "Auto22");
        checkSelectedValue_inDropDownList(SLC_MENU2, "Auto1");
        checkSelectedValue_inDropDownList(SLC_MENU3, "Auto3");
        checkSelectedValue_inDropDownList(SLC_INITIAL_GREETING, "queue-thankyou.wav");
        checkStatus(CB_FORWARD_TO_ORIGINAL_DEST,"disabled","Checkbox Forward to Original Destination");
        checkValue_byId(IPF_ROUTING_DEFAULT_DESTINATION, "12");
        checkValue_byId(IPF_ROUTING_CODE, "22");
      	
	    clickButtonCancel();
	    updateMap(RETRIES);
	    clickCheckbox_byText("AutoRoutingNew");
	    
	    clickButtonCancel();
	    updateMap(RETRIES);
	    setMethodState();
	}
}