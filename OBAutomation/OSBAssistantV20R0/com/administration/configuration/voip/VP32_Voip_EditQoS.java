package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP32_Voip_EditQoS extends SuperHelper implements PropertiesVoip {

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
	public void voipModifyQoS() throws InterruptedException {
		
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
        
        //Change values in DSCP for SIP and DSCP for RTP input fields
        type_byId(IPF_DSCP_FOR_SIP, "10");
        type_byId(IPF_DSCP_FOR_RTP, "20");
        
        //Modify QoS
    	clickCheckbox_byText(TXT_QOS_ALL);
		clickButtonEdit();
		updateMap(RETRIES);
        
	    selectFromDropDown(SLC_QOS_PROTOCOL, TXT_ICMP);
	    selectFromDropDown(SLC_QOS_IN_INTERFACE, TXT_INTERFACE1);
	    selectFromDropDown(SLC_QOS_OUT_INTERFACE, TXT_INTERFACE1);
	    type_byId(IPF_QOS_PORT, "5064");
	    type_byId(IPF_QOS_DSCP, "40");
	    type_byId(IPF_QOS_MARK, "1000");   
	    clickButtonSave();
        updateMap(RETRIES);
        
        
        //Check QoS Modification
        checkTextIsContained_byXPathTable(TBL_LIST_QOS, TXT_ICMP);
     	checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_IN_INTERFACE, TXT_INTERFACE1);	
 		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_OUT_INTERFACE, TXT_INTERFACE1);
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_PORT, "5064");
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_DSCP, "40");
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_MARK, "1000");
	
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	

	
	@Test (priority = 1)
	public void verifyVoipQoSModification() throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_CONFIGURE_QOS);
        updateMap(RETRIES);
		
        //Verify values in DSCP for SIP and DSCP for RTP input fields
        checkValue_byId(IPF_DSCP_FOR_SIP, "10");
        checkValue_byId(IPF_DSCP_FOR_RTP, "20");
        
		//Verify QoS Modification
        checkTextIsContained_byXPathTable(TBL_LIST_QOS, TXT_ICMP);
     	checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_IN_INTERFACE, TXT_INTERFACE1);	
 		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_OUT_INTERFACE, TXT_INTERFACE1);
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_PORT, "5064");
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_DSCP, "40");
		checkElementText_inSpecificTableColumn(TBL_LIST_QOS, TXT_ICMP, TXT_QOS_MARK, "1000");
	
		//Edit QoS and Verify fields
		clickCheckbox_byText(TXT_ICMP);
		clickButtonEdit();
		updateMap(RETRIES);
		checkSelectedValue_inDropDownList(SLC_QOS_PROTOCOL, TXT_ICMP);
		checkSelectedValue_inDropDownList(SLC_QOS_IN_INTERFACE, TXT_INTERFACE1);
		checkSelectedValue_inDropDownList(SLC_QOS_OUT_INTERFACE, TXT_INTERFACE1);
		checkValue_byId(IPF_QOS_PORT, "5064");
		checkValue_byId(IPF_QOS_DSCP, "40");
		checkValue_byId(IPF_QOS_MARK, "1000");   
		 
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
	}	

}