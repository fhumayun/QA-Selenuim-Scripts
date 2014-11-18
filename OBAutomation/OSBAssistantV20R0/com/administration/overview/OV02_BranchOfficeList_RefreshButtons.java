package com.administration.overview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;

public class OV02_BranchOfficeList_RefreshButtons extends SuperHelper implements PropertiesOverview {

	@BeforeTest(alwaysRun = true)
	public void act_StartBrowser_LoginCMPasAdministrator() throws InterruptedException {
		startSession(browser, ip);
		loginCMP(administrator_loginName, administrator_password);
		if(navigateToBranchOfficeList()){
	    selectFromDropDown(SLC_SELECTSYSTEM, Switch);	
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
	public void checkRefreshAllButton() throws InterruptedException {
		
		classMethodLogger.log(); 
	   
	   String[] timesBeforeRefresh = { getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB1LAN", TXT_LAST_UPDATE),
			                    getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB2LAN", TXT_LAST_UPDATE),
			                    getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB3WAN", TXT_LAST_UPDATE),
			                    getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB4WANPRI", TXT_LAST_UPDATE),
			                    getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB5WANFXO", TXT_LAST_UPDATE),
			                    getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB6WANBRI", TXT_LAST_UPDATE),
			                    getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB8LANCSBC", TXT_LAST_UPDATE)
			                    };
	   
	   clickButton(BTN_REFRESH_ALL_OSB);
	   
	   waitForPageToLoad("20000");
	   
	   String[] timesAfterRefresh = { getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB1LAN", TXT_LAST_UPDATE),
               getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB2LAN", TXT_LAST_UPDATE),
               getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB3WAN", TXT_LAST_UPDATE),
               getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB4WANPRI", TXT_LAST_UPDATE),
               getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB5WANFXO", TXT_LAST_UPDATE),
               getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB6WANBRI", TXT_LAST_UPDATE),
               getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB8LANCSBC", TXT_LAST_UPDATE)
               };
	   
	   if(timesBeforeRefresh.equals(timesAfterRefresh))
	   {
		   MyLogger.resultError("The Refresh All failed");
		   throw new InterruptedException("The Refresh All failed");
	   }
	   else{
		   
		   MyLogger.resultInfo("The Refresh All was successful");
	   }
	   setMethodState();
	}
	
	
	@Test (priority = 1)
	public void checkRefreshSelectedButton() throws InterruptedException {
		
		methodLogger.log(); 
		
	    String timeBeforeRefresh = getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB2LAN", TXT_LAST_UPDATE);
			                  
        clickCheckbox_byText("OB2LAN");
		
		clickButton(BTN_REFRESH_SELECTED_OSB);
	   
	   waitForPageToLoad("20000");
	   
	   String timeAfterRefresh = getElementText_inSpecificTableColumn(TBL_BRANCH_OFFICE_LIST, "OB2LAN", TXT_LAST_UPDATE);
    
	   if(timeBeforeRefresh.equals(timeAfterRefresh))
	   {
		   MyLogger.resultError("The Refresh Selected failed");
		   throw new InterruptedException("The Refresh Selected failed");
	   }
	   else{
		   
		   MyLogger.resultInfo("The Refresh Selected was successful");
	   }
	   setMethodState();
	}
}