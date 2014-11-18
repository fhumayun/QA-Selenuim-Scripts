package com.administration.configuration.survivability;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class SV13_Survivability_MusicOnHold extends SuperHelper implements PropertiesSurvivability {

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
	public void checkMediaServerEnable() throws InterruptedException {
		
		String CB_MS_ENABLED = "editMediaServerForm:msCheckbox";
		classMethodLogger.log(); 
		goToAdministrationMediaServer();
        updateMap(RETRIES);
        
        if(!getCheckboxStatus(CB_MS_ENABLED))
        {	
		  clickCheckbox_byID(CB_MS_ENABLED);
    	  clickButtonSave();
    	  updateMap(RETRIES);
    	  applyChangesWithConfirmation();
        }
        else
        {
          clickButtonCancel();
      	  updateMap(RETRIES);
        }
		setMethodState();
	}
	
	@Test (priority = 1)
	public void survivabilityEnableMusicOnHold() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Music On Hold
		clickButton(TB_MUSIC_ON_HOLD);
		
		if(!getCheckboxStatus(CB_ENABLE_MOH))
			clickCheckbox_byID(CB_ENABLE_MOH);
		
		//Check that checkBox Enable MOH for Subscribers becomes enabled
		checkStatus(CB_ENABLE_MOH_SUB,"enabled","Enable MOH for Subscribers"); 
	      
		//Enable MOH for Subscribers
		clickCheckbox_byID(CB_ENABLE_MOH_SUB);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 1)
	public void verifySurvivabilityMusicOnHoldEnabling() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Music On Hold
		clickButton(TB_MUSIC_ON_HOLD);
		
		//Verify Music On Hold Activation
		checkStatus(CB_ENABLE_MOH,"enabled","Checkbox Enable MOH"); 
	    checkStatus(CB_ENABLE_MOH,"checked","Checkbox Enable MOH"); 
	       
	    checkStatus(CB_ENABLE_MOH_SUB,"enabled","Enable MOH for Subscribers"); 
	    checkStatus(CB_ENABLE_MOH_SUB,"checked","Enable MOH for Subscribers"); 
	       
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
	@Test (priority = 2)
	public void survivabilityDisableMusicOnHold() throws InterruptedException {
		
		classMethodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Music On Hold
		clickButton(TB_MUSIC_ON_HOLD);
		     
		//Disable MOH for Subscribers
		clickCheckbox_byID(CB_ENABLE_MOH_SUB);
		
	    //Disable MOH
		clickCheckbox_byID(CB_ENABLE_MOH);
		
		//Check that checkBox Enable MOH for Subscribers becomes disabled
		checkStatus(CB_ENABLE_MOH_SUB,"disabled","Enable MOH for Subscribers"); 
	 
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
	}
	
	@Test (priority = 3)
	public void verifySurvivabilityMusicOnHoldDisabling() throws InterruptedException {
		
		methodLogger.log();
		goToAdministrationSurvivability();
		updateMap(RETRIES);
		
		//Select Tab Music On Hold
		clickButton(TB_MUSIC_ON_HOLD);
		
		//Verify Music On Hold De-activation
		checkStatus(CB_ENABLE_MOH,"enabled","Checkbox Enable MOH"); 
	    checkStatus(CB_ENABLE_MOH,"unchecked","Checkbox Enable MOH"); 
	       
	    checkStatus(CB_ENABLE_MOH_SUB,"disabled","Enable MOH for Subscribers"); 
	    checkStatus(CB_ENABLE_MOH_SUB,"unchecked","Enable MOH for Subscribers"); 
	       
		clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	}
	
}