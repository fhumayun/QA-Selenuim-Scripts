package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP31_Voip_AddQoS extends SuperHelper implements PropertiesVoip {

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

	
	@DataProvider(name = "QoSData")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {TXT_QOS_ALL,TXT_QOS_ALL,TXT_QOS_ALL,"7080","",""},
				 {TXT_TCP,TXT_INTERFACE1,TXT_INTERFACE2,"0","0","0"},
				 {TXT_UDP,TXT_INTERFACE2,TXT_INTERFACE1,"65535","63","2147483647"},
		};	
	}
	
	@Test (priority = 0,dataProvider = "QoSData")
	public void voipAddQoS(String x1,String x2,String x3,String x4,String x5,String x6) throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        //Enable QoS Configuration
        if(!getCheckboxStatus(CB_ENABLE_QOS))
        clickCheckbox_byID(CB_ENABLE_QOS);
        
        clickButton(BTN_CONFIGURE_QOS);
        updateMap(RETRIES);
        
        //Create QoS (input From Data Provider)
        clickButtonAdd();
        updateMap(RETRIES);
        
        selectFromDropDown(SLC_QOS_PROTOCOL, x1);
        selectFromDropDown(SLC_QOS_IN_INTERFACE, x2);
        selectFromDropDown(SLC_QOS_OUT_INTERFACE, x3);
        type_byId(IPF_QOS_PORT, x4);
        type_byId(IPF_QOS_DSCP, x5);
        type_byId(IPF_QOS_MARK, x6);
        
        clickButtonSave();
        updateMap(RETRIES);
 
        //Check QoS Creation
        checkTextIsContained_byXPathTable(TBL_LIST_QOS, x1);
     	checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_IN_INTERFACE, x2);	
 		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_OUT_INTERFACE, x3);
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_PORT, x4);
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_DSCP, x5);
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_MARK, x6);
			
		clickButtonSave();
		updateMap(RETRIES);
		
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
	
	
	@Test (priority = 2,dataProvider = "QoSData")
	public void verifyVoipQoSCreation(String x1,String x2,String x3,String x4,String x5,String x6) throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_QOS);
        updateMap(RETRIES);
		
		//Verify QoS Creation
        checkTextIsContained_byXPathTable(TBL_LIST_QOS, x1);
     	checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_IN_INTERFACE, x2);	
 		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_OUT_INTERFACE, x3);
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_PORT, x4);
		if(x5.equals(""))
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_DSCP, "0");
		else
			checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_DSCP, x5);	
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, x1, TXT_QOS_MARK, x6);
		
		//Edit QoS and Verify fields
		clickCheckbox_byText(x1);
		clickButtonEdit();
		updateMap(RETRIES);
		checkSelectedValue_inDropDownList(SLC_QOS_PROTOCOL, x1);
		checkSelectedValue_inDropDownList(SLC_QOS_IN_INTERFACE, x2);
		checkSelectedValue_inDropDownList(SLC_QOS_OUT_INTERFACE, x3);
	    checkValue_byId(IPF_QOS_PORT, x4);
		if(x5.equals(""))
			checkValue_byId(IPF_QOS_DSCP, "0");
		else
		checkValue_byId(IPF_QOS_DSCP, x5);
	    checkValue_byId(IPF_QOS_MARK, x6);
        
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

}