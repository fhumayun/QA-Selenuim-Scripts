package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD04_AddQueue extends SuperHelper implements PropertiesACD {

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

	
	@DataProvider(name = "QueueData")
	public Object[][] createDataProduct() {
		return new Object[][] {
				 {"Queue1","","unchecked","unchecked","35","5","checked","","1200","checked","","2106923616"},
				 {"Queue2","2107771000","checked","checked","10","1","unchecked","num-not-valid.wav","60","unchecked","5","2610995201"},
				 {"Queue3","2610991815","unchecked","unchecked","120","60","checked","","3600","checked","","302108052266"},
		};	
	}
	
	int counter1=1;
	int counter2=1;
	String id1;
	String id2; 
	
	@Test (priority = 0,dataProvider = "QueueData")
	public void acdAddQueue(String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9,String x10,String x11,String x12) throws InterruptedException {
		
		classMethodLogger.log(); 
	    id1 = String.valueOf(counter1);
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
        
        clickButtonAdd();
        updateMap(RETRIES);
        
        //Create Queue (input From Data Provider)
        //Create Queue General tab
        clickButton(TB_QUEUE_GENERAL);
        type_byId(IPF_QUEUE_NAME, x1);
        type_byId(IPF_QUEUE_DESTINATION, x2);
        if (x3.equals("checked"))
        {
          clickCheckbox_byID(CB_OVERFLOW_TO_MAIL_SERVER);
        }
        if (x4.equals("checked"))
        {
          clickCheckbox_byID(CB_GENERATE_DIVERSION_HEADER);
        }
        type_byId(IPF_QUEUE_ADVANCE_TIME_OUT, x5);
        type_byId(IPF_AGENT_WRAP_UP_TIME, x6);
        if (x7.equals("unchecked"))
        {
          clickCheckbox_byID(CB_PLAY_RING_TONE);
          selectFromDropDown(SLC_MUSIC_ON_HOLD, x8);
        }
        type_byId(IPF_MAXIMUM_WAITING_TIME, x9);
        if (x10.equals("unchecked"))
        {
          clickCheckbox_byID(CB_UNLIMITED);
          type_byId(IPF_MAXIMUM_CALLERS, x11);
        }
        
        //Queue DID tab
        clickButton(TB_QUEUE_DID);
        type_byId(IPF_QUEUE_DID, x12);
        
        clickButtonAdd();
        
        //Check DID creation
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE_DID, x12);
        
        selenium.windowMaximize();
        
        clickButtonSave();
    	updateMap(RETRIES);
    	
        //Check Queue Creation
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE, id1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, id1, TXT_QUEUE_NAME, x1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, id1, TXT_DID_LIST, x12);
      	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, id1, TXT_QUEUE_DESTINATION, x2);
      	if (x4.equals("checked"))
         {
           checkElement(TBL_LIST_QUEUE+":"+String.valueOf(counter1-1)+":echoCancel");
         }
      			
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
	
	
	
	@Test (priority = 2,dataProvider = "QueueData")
	public void verifyAcdQueueCreation(String x1,String x2,String x3,String x4,String x5,String x6,String x7,String x8,String x9,String x10,String x11,String x12) throws InterruptedException {
		
		methodLogger.log();
		id2 = String.valueOf(counter2);
        goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
     
        //Verify Queue Creation
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE, id2);
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, id2, TXT_QUEUE_NAME, x1);
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, id2, TXT_DID_LIST, x12);
      	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, id2, TXT_QUEUE_DESTINATION, x2);
      	if (x4.equals("checked"))
         {
           checkElement(TBL_LIST_QUEUE+":"+String.valueOf(counter2-1)+":echoCancel");
         }
    
		//Edit Queue and verify fields
      	clickCheckbox_byText(id2);
      	clickButtonEdit();
      	updateMap(RETRIES);
      	
      	checkValue_byId(IPF_QUEUE_ID,id2);
        checkValue_byId(IPF_QUEUE_NAME, x1);
        checkValue_byId(IPF_QUEUE_DESTINATION, x2);
        checkStatus(CB_OVERFLOW_TO_MAIL_SERVER,x3,"Checkbox Overflow to Mail Server");
        checkStatus(CB_GENERATE_DIVERSION_HEADER,x4,"Checkbox Generate Diversion Header");
        checkValue_byId(IPF_QUEUE_ADVANCE_TIME_OUT, x5);
        checkValue_byId(IPF_AGENT_WRAP_UP_TIME, x6);
        checkStatus(CB_PLAY_RING_TONE,x7,"Checkbox Play Ring Tone");
        checkSelectedValue_inDropDownList(SLC_MUSIC_ON_HOLD, x8);
        checkValue_byId(IPF_MAXIMUM_WAITING_TIME, x9);
        checkStatus(CB_UNLIMITED,x10,"Checkbox Unlimited");
        if(x11.equals(""))
          checkValue_byId(IPF_MAXIMUM_CALLERS, "0");
        else
          checkValue_byId(IPF_MAXIMUM_CALLERS, x11);
        //Queue DID tab
        clickButton(TB_QUEUE_DID);
        
        //Verify DID creation
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE_DID, x12);

		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();
		
		counter2++;
	}	

}