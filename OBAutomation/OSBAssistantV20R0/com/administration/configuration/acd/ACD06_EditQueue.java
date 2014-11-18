package com.administration.configuration.acd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.helper.SuperHelper;

public class ACD06_EditQueue extends SuperHelper implements PropertiesACD {

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
	public void acdModifyQueueGeneralFields() throws InterruptedException {
		
		classMethodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
        
        //Edit Queue and modify fields under General Tab
        clickCheckbox_byText("1");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_QUEUE_GENERAL);
        
        type_byId(IPF_QUEUE_NAME, "Queue11");
        type_byId(IPF_QUEUE_DESTINATION, "302109753926");
        clickCheckbox_byID(CB_OVERFLOW_TO_MAIL_SERVER);
        clickCheckbox_byID(CB_GENERATE_DIVERSION_HEADER);
        type_byId(IPF_QUEUE_ADVANCE_TIME_OUT, "70");
        type_byId(IPF_AGENT_WRAP_UP_TIME, "10");
        clickCheckbox_byID(CB_PLAY_RING_TONE);
        selectFromDropDown(SLC_MUSIC_ON_HOLD, "queue-holdtime.wav");
        type_byId(IPF_MAXIMUM_WAITING_TIME, "2400");
        clickCheckbox_byID(CB_UNLIMITED);
        type_byId(IPF_MAXIMUM_CALLERS, "2147483647");
     
           
        clickButtonSave();
    	updateMap(RETRIES);
    	
        //Check Queue Modification
        checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_QUEUE_NAME, "Queue11");
        checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_QUEUE_DESTINATION, "302109753926");
        checkElement(TBL_LIST_QUEUE+":0:echoCancel");
      
      			
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		

	}
	
	@Test (priority = 1)
	public void verifyVoipQueueGeneralFieldsModification() throws InterruptedException {
		
		methodLogger.log();
        goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
     
        //Verify Queue Modification
        checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_QUEUE_NAME, "Queue11");
        checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_QUEUE_DESTINATION, "302109753926");
        checkElement(TBL_LIST_QUEUE+":0:echoCancel");
      
		//Edit Queue and verify fields
      	clickCheckbox_byText("1");
      	clickButtonEdit();
      	updateMap(RETRIES);
      	
        checkValue_byId(IPF_QUEUE_NAME, "Queue11");
        checkValue_byId(IPF_QUEUE_DESTINATION, "302109753926");
        checkStatus(CB_OVERFLOW_TO_MAIL_SERVER,"checked","Checkbox Overflow to Mail Server");
        checkStatus(CB_GENERATE_DIVERSION_HEADER,"checked","Checkbox Generate Diversion Header");
        checkValue_byId(IPF_QUEUE_ADVANCE_TIME_OUT, "70");
        checkValue_byId(IPF_AGENT_WRAP_UP_TIME, "10");
        checkStatus(CB_PLAY_RING_TONE,"unchecked","Checkbox Play Ring Tone");
        checkSelectedValue_inDropDownList(SLC_MUSIC_ON_HOLD, "queue-holdtime.wav");
        checkValue_byId(IPF_MAXIMUM_WAITING_TIME, "2400");
        checkStatus(CB_UNLIMITED,"unchecked","Checkbox Unlimited");
        checkValue_byId(IPF_MAXIMUM_CALLERS, "2147483647");
       
		clickButtonCancel();
		updateMap(RETRIES);
		
		clickButtonCancel();
		updateMap(RETRIES);
		
		setMethodState();

	}	
	
	
	@Test (priority = 2)
	public void acdModifyQueueAddDID() throws InterruptedException {
		
	    methodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
 
        //Edit Queue and add 3 more DID
        clickCheckbox_byText("1");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_QUEUE_DID);
        
        type_byId(IPF_QUEUE_DID, "17");
        clickButtonAdd();
        type_byId(IPF_QUEUE_DID, "18");
        clickButtonAdd();
        type_byId(IPF_QUEUE_DID, "19");
        clickButtonAdd();
        //Check DID creation
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE_DID, "17");
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE_DID, "18");
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE_DID, "19");
         
        clickButtonSave();
    	updateMap(RETRIES);
           
        //Check DID List column Modification
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_DID_LIST, "2106923616,17,18,19");
      			
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	@Test (priority = 3)
	public void verifyAcdQueueDIDAddition() throws InterruptedException {
		
	    methodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
        
        //Check DID List column Modification
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_DID_LIST, "2106923616,17,18,19");
     
    	//Edit Queue 
        clickCheckbox_byText("1");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_QUEUE_DID);
        
        //Verify DID creation
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE_DID, "17");
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE_DID, "18");
        checkTextIsContained_byXPathTable(TBL_LIST_QUEUE_DID, "19");
 
        clickButtonCancel();
    	updateMap(RETRIES);
           
    	clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
	@Test (priority = 4)
	public void acdModifyQueueDeleteOneDID() throws InterruptedException {
		
	    methodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
   
        //Edit Queue and delete 1 DID
        clickCheckbox_byText("1");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_QUEUE_DID);
        
        clickCheckbox_byText("17");
        clickButtonDelete();
          
        //Check DID deletion
        checkText_NotVisible("17");
      
        clickButtonSave();
    	updateMap(RETRIES);
           
        //Check DID List column Modification
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_DID_LIST, "2106923616,18,19");
      			
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	@Test (priority = 5)
	public void verifyAcdQueueOneDIDDeletion() throws InterruptedException {
		
	    methodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
        
       //Check DID List column Modification
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_DID_LIST, "2106923616,18,19");
     
    	//Edit Queue 
        clickCheckbox_byText("1");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_QUEUE_DID);
        
        //Verify DID deletion
        checkText_NotVisible("17");
        
        clickButtonCancel();
    	updateMap(RETRIES);
           
    	clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
	@Test (priority = 6)
	public void acdModifyQueueDeleteMoreDIDs() throws InterruptedException {
		
	    methodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
        
        //Edit Queue and delete 2 DIDs
        clickCheckbox_byText("1");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_QUEUE_DID);
        
        clickCheckbox_byText("18");
        clickCheckbox_byText("19");
        
        clickButtonDelete();
          
        //Check DIDs deletion
        checkText_NotVisible("18");
        checkText_NotVisible("19");
        
        clickButtonSave();
    	updateMap(RETRIES);
           
        //Check DID List column Modification
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_DID_LIST, "2106923616");
      			
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmation();
		setMethodState();
		
	}
	
	@Test (priority = 7)
	public void verifyAcdQueueMoreDIDsDeletion() throws InterruptedException {
		
	    methodLogger.log(); 
		goToAdministrationAcd();
        updateMap(RETRIES);
        
        //Queue tab
        clickButton(TB_QUEUE);
          
        //Check DID List column Modification
    	checkElementText_inSpecificTableColumn(TBL_LIST_QUEUE, "1", TXT_DID_LIST, "2106923616");
     
    	//Edit Queue 
        clickCheckbox_byText("1");
        clickButtonEdit();
        updateMap(RETRIES);
        clickButton(TB_QUEUE_DID);
        
        //Verify DIDs deletion
        checkText_NotVisible("18");
        checkText_NotVisible("19");
      
        
        clickButtonCancel();
    	updateMap(RETRIES);
           
    	clickButtonCancel();
		updateMap(RETRIES);
		setMethodState();
	
	}
	
}