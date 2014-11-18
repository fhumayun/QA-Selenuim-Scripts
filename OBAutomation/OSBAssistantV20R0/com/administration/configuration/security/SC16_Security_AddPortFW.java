package com.administration.configuration.security;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SC16_Security_AddPortFW extends SuperHelper implements PropertiesSecurity {

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

	@DataProvider(name = "PortFW")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {"10.1.72.10","7000","7100",TXT_PORT_FW_TCP,},
				 {"10.1.82.10","8000","8100",TXT_PORT_FW_UDP},
				 {"10.1.92.10","9000","9100",TXT_PORT_FW_ALL},
				
		};	
	}
	
	@Test (priority = 0,dataProvider = "PortFW")
	public void securityAddPortFW(String x1,String x2,String x3,String x4) throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Port FW
        clickButton(TB_PORT_FW);
        
        //Enable port FW
        if (!getCheckboxStatus(CB_ENABLE_PORT_FW))
            clickCheckbox_byID(CB_ENABLE_PORT_FW);
          
        //Check that the Button Add Port FW becomes enabled
        checkStatus(BTN_ADD_PORT_FW,"enabled","Button Add Port FW"); 
      
        //Add 3 Port FW with different protocols
        clickButtonAdd();
        updateMap(RETRIES);
        type_byId(IPF_PORT_FW_ADD_IP_ADDRESS,x1);
        type_byId(IPF_PORT_FW_ADD_IN_PORT, x2);
        type_byId(IPF_PORT_FW_ADD_OUT_PORT, x3);
        selectFromDropDown(SLC_PORT_FW_PROTOCOL, x4);
    	clickButtonSave();
    	updateMap(RETRIES);
    	
    	//check Port FW creation
    	checkText(x1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, x1, TXT_LIST_PORT_FW_IN, x2);
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, x1, TXT_LIST_PORT_FW_OUT, x3);
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, x1, TXT_LIST_PORT_FW_PROTOCOL, x4);
        
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
	public void verifySecurityPortFWCreation() throws InterruptedException {
	
		methodLogger.log(); 
		goToAdministrationSecurity();
        updateMap(RETRIES);
        
        //Go to Tab Port FW
        clickButton(TB_PORT_FW);
    
        //Verify Port FW Enabling
        checkStatus(CB_ENABLE_PORT_FW,"checked","Checkbox Enable Port Forwarding"); 
        
        //Verify Port FW creation
        checkText("10.1.72.10");
        checkText("10.1.82.10");
        checkText("10.1.92.10");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.1.72.10", TXT_LIST_PORT_FW_IN, "7000");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.1.72.10", TXT_LIST_PORT_FW_OUT, "7100");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.1.72.10", TXT_LIST_PORT_FW_PROTOCOL, TXT_PORT_FW_TCP);
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.1.82.10", TXT_LIST_PORT_FW_IN, "8000");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.1.82.10", TXT_LIST_PORT_FW_OUT, "8100");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.1.82.10", TXT_LIST_PORT_FW_PROTOCOL, TXT_PORT_FW_UDP);
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.1.92.10", TXT_LIST_PORT_FW_IN, "9000");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.1.92.10", TXT_LIST_PORT_FW_OUT, "9100");
    	checkElementText_inSpecificTableColumn(TBL_LIST_PORT_FW, "10.1.92.10", TXT_LIST_PORT_FW_PROTOCOL, TXT_PORT_FW_ALL);
       
        //Edit 1 Port FW and verify fields
    	clickCheckbox_byText("10.1.72.10");
    	clickButton(BTN_EDIT_PORT_FW);
    	updateMap(RETRIES);
    	checkValue_byId(IPF_PORT_FW_ADD_IP_ADDRESS,"10.1.72.10");
    	checkValue_byId(IPF_PORT_FW_ADD_IN_PORT, "7000");
    	checkValue_byId(IPF_PORT_FW_ADD_OUT_PORT, "7100");
        checkSelectedValue_inDropDownList(SLC_PORT_FW_PROTOCOL, TXT_PORT_FW_TCP);
    	clickButtonCancel();
    	updateMap(RETRIES);
    	clickCheckbox_byText("10.1.72.10");
    	
    	clickButtonCancel();
    	updateMap(RETRIES);
		setMethodState();
	}

}