package com.administration.configuration.voip;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class VP21_Voip_AddSIPServiceProviderProfile extends SuperHelper implements PropertiesVoip {

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

	
	@DataProvider(name = "SIPServiceProviderProfileData")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {"AutoProvider1","",TXT_FULL,"unchecked","","unchecked","","unchecked","","unchecked","","unchecked","","",""},
				 {"AutoProvider2","BT",TXT_BASIC,"checked","2106923616","unchecked","","checked","1800","unchecked","","unchecked","","",""},
				 {"AutoProvider3","Orange",TXT_FULL_SEND,"checked","2106923617","unchecked","","checked","60","checked","2106923618","unchecked","","",""},
				 {"AutoProvider4","Qwest",TXT_FULL_RECEIVE,"checked","2106923619","unchecked","","checked","7200","checked","2106923620","checked","172.25.2.93","AutoUser","Asd123!."},
		};	
	}
	
	int counter1=0;
	int counter2=0;
	
	@Test (priority = 0,dataProvider = "SIPServiceProviderProfileData")
	public void voipAddSIPServiceProviderProfile(String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9,String x10,String x11,String x12,String x13,String x14,String x15) throws InterruptedException {
		
		classMethodLogger.log(); 
	
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
        
        //Create SIP Service Provider Profile (input From Data Provider)
        clickButtonAdd();
        updateMap(RETRIES);
        
        selectFromDropDown(SLC_DEFAULT_SSP_PROFILE, x2);
        type_byId(IPF_SIP_SERVICE_PROVIDER_PROFILE_NAME, x1);
        selectFromDropDown(SLC_PRIVACY_SUPPORT, x3);
        if (x4.equals("checked"))
        {
          clickCheckbox_byID(CB_MANDATORY_DEFAULT_HOME_DN);
          type_byId(IPF_DEFAULT_HOME_DN, x5);
        }
        if (x6.equals("checked"))
        {
          type_byId(IPF_SIP_SERVICE_ADDRESS, x7);
        }
        if (x8.equals("checked"))
        {
          clickCheckbox_byID(CB_REGISTRATION_REQUIRED);
          type_byId(IPF_INTERVAL, x9);
        }
        if (x10.equals("checked"))
        {
          clickCheckbox_byID(CB_BUSINESS_IDENTITY_REQUIRED);
          type_byId(IPF_BUSINESS_IDENTITY_DN, x11);
        }
        if (x10.equals("checked")&& x2.equals("Skype-IP Auth"))
        {
          clickCheckbox_byID(CB_BUSINESS_IDENTITY_REQUIRED);
          type_byId(IPF_BUSINESS_IDENTITY_DN, x11);
        }
        
        if (x12.equals("checked"))
        {
          clickCheckbox_byID(CB_DIGEST_AUTHENTICATION_SUPPORTED);
          type_byId(IPF_REALM, x13);
          type_byId(IPF_USER_ID, x14);
          type_byId(IPF_USER_PASSWORD, x15);
        }
        
        
        clickButtonSave();
        updateMap(RETRIES);
        
        //Check SIP Service Provider Profile Creation
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, x1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, x1, TXT_DEFAULT_HOME_DN, x5);
    	if (x8.equals("checked"))
    	{	
    	  checkElement(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES+":"+counter1+":enabledImage");	
		  checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, x1, TXT_REGISTRATION_INTERVAL, x9);
    	}
		else
		  checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, x1, TXT_REGISTRATION_INTERVAL, "3600");
			
		clickButtonSave();
		updateMap(RETRIES);
		
		clickButtonSave();
		updateMap(RETRIES);
		setMethodState();
		
		counter1++;
	}
	
	@Test (priority = 1)
	public void applyChanges() throws InterruptedException {
		methodLogger.log();
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	
	@Test (priority = 2,dataProvider = "SIPServiceProviderProfileData")
	public void verifyVoipSIPServiceProviderProfileCreation(String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9,String x10,String x11,String x12,String x13,String x14,String x15) throws InterruptedException {
		
		methodLogger.log();
		
		goToAdministrationVoip();
        updateMap(RETRIES);
        
        //General tab
        clickButton(TB_GENERAL);
        
        clickButton(BTN_SIP_SERVICE_PROVIDER_PROFILES);
        updateMap(RETRIES);
		
		//Verify SIP Service Provider Profile Creation
        checkTextIsContained_byXPathTable(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, x1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, x1, TXT_DEFAULT_HOME_DN, x5);
    	if (x8.equals("checked"))
    	{	
    	  checkElement(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES+":"+counter2+":enabledImage");	
		  checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, x1, TXT_REGISTRATION_INTERVAL, x9);
    	}
		else
		  checkElementText_inSpecificTableColumn(TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES, x1, TXT_REGISTRATION_INTERVAL, "3600");
	
		//Edit SIP Service Provider Profile and Verify fields
		clickCheckbox_byText(x1);
		clickButtonEdit();
		updateMap(RETRIES);
		
		checkValue_byId(IPF_SIP_SERVICE_PROVIDER_PROFILE_NAME, x1);
		checkSelectedValue_inDropDownList(SLC_DEFAULT_SSP_PROFILE, x2);
		checkSelectedValue_inDropDownList(SLC_PRIVACY_SUPPORT, x3);
	    checkStatus(CB_MANDATORY_DEFAULT_HOME_DN,x4,"Checkbox");
	    checkValue_byId(IPF_DEFAULT_HOME_DN, x5);
	    checkStatus(CB_USE_SIP_SERVICE_ADDRESS,x6,"Checkbox");
	    checkValue_byId(IPF_SIP_SERVICE_ADDRESS, x7);
	    if (x8.equals("checked"))
	    {
	      checkStatus(CB_REGISTRATION_REQUIRED,x8,"Checkbox");
	      checkValue_byId(IPF_INTERVAL, x9);
	     }
	     else
	     {
	       checkStatus(CB_REGISTRATION_REQUIRED,x8,"Checkbox");
		   checkValue_byId(IPF_INTERVAL, "3600");
	     }
	    
	    checkStatus(CB_BUSINESS_IDENTITY_REQUIRED,x10,"Checkbox");
	    checkValue_byId(IPF_BUSINESS_IDENTITY_DN, x11);
	    checkStatus(CB_DIGEST_AUTHENTICATION_SUPPORTED,x12,"Checkbox");
	    checkValue_byId(IPF_REALM, x13);
	    checkValue_byId(IPF_USER_ID, x14);
	    checkValue_byId(IPF_USER_PASSWORD, x15);
	   
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
		
		counter2++;
	}	

}