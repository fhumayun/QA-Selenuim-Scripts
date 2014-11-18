package com.profiles.configuration.survivability;

import com.administration.configuration.mediaserver.PropertiesMediaServer;
import com.administration.configuration.survivability.PropertiesSurvivability;
import com.helper.SuperHelper;
import com.profiles.list.PropertiesProfilesList;

public class ConfigureProfileSurvivability extends SuperHelper implements PropertiesProfilesList,PropertiesSurvivability,PropertiesMediaServer{

	
    public void configureProfileForSurvivability() throws InterruptedException {
		
	    goToProfilesSurvivability();
	    
	    updateMap(RETRIES);
	    
	   //Select Tab Call Detail Records
		clickButton(TB_PROFILES_CALL_DETAILED_RECORDS);
		
		if(!getCheckboxStatus(CB_TICKET_GENERATION))
			clickCheckbox_byID(CB_TICKET_GENERATION);
	 
		selectFromDropDown(SLC_TRANSFER_METHOD, TXT_TRANSFER_METHOD_PULL);
		
		//Check that the Primary ,Secondary Billing Server fields and the Re-attempt timer field become disabled
	    checkStatus(IPF_PRIMARY_HOSTNAME,"disabled","Input Field Primary Billing Server Hostname"); 
	    checkStatus(IPF_PRIMARY_USERNAME,"disabled","Input Field Primary Billing Server Username"); 
	    checkStatus(IPF_PRIMARY_PASSWORD,"disabled","Input Field Primary Billing Server Password"); 
	    checkStatus(IPF_PRIMARY_CONFIRM_PASSWORD,"disabled","Input Field Primary Billing Confirm Password"); 
	    checkStatus(IPF_SECOND_HOSTNAME,"disabled","Input Field Secondary Billing Server Hostname"); 
	    checkStatus(IPF_SECOND_USERNAME,"disabled","Input Field Secondary Billing Server Username"); 
	    checkStatus(IPF_SECOND_PASSWORD,"disabled","Input Field Secondary Billing Server Password"); 
	    checkStatus(IPF_SECOND_CONFIRM_PASSWORD,"disabled","Input Field Secondary Billing Server Confirm Password"); 
	    checkStatus(IPF_RE_ATTEMPT,"disabled","Input Field Re-attempt timer"); 
       
		type_byId(IPF_MAX_RECORD_VALUE, "999");
		type_byId(IPF_MAX_TIME_INTERVAL, "6");
		type_byId(IPF_MAX_FILE_SIZE, "200");
		type_byId(IPF_PORT, "23");
		clickCheckbox_byID(CB_ALLOW_OVERWRITE);
		
//		//Select Tab Music On Hold
//		clickButton(TB_PROFILES_MUSIC_ON_HOLD);
//		
//		if(!getCheckboxStatus(CB_ENABLE_MOH))
//			clickCheckbox_byID(CB_ENABLE_MOH);
//		
//		//Check that checkBox Enable MOH for Subscribers becomes enabled
//		checkStatus(CB_ENABLE_MOH_SUB,"enabled","Enable MOH for Subscribers"); 
//	      
//		//Enable MOH for Subscribers
//		clickCheckbox_byID(CB_ENABLE_MOH_SUB);
	
	    clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmationProfiles();
	    
	}
	
      public void verifyProfileSurvivabilityConfiguration(String mode) throws InterruptedException {
	    	
	    methodLogger.log();
	    
		goToAdministrationSurvivability();
    
		updateMap(RETRIES);
		
		//Select Tab Call Detail Records
		if(mode.equals(TXT_SBC_PROXY)||mode.equals(TXT_BRANCH_SBC)||mode.equals(TXT_PROXY)){
		  clickButton(TB_CALL_DETAILED_RECORDS);
		}
		if (mode.equals(TXT_PROXY_ACD)){
		  clickButton(TB_CALL_DETAILED_RECORDS_ACDmode);
		}
		
		
		checkStatus(IPF_PRIMARY_HOSTNAME,"disabled","Input Field Primary Billing Server Hostname"); 
		checkStatus(IPF_PRIMARY_USERNAME,"disabled","Input Field Primary Billing Server Username"); 
		checkStatus(IPF_PRIMARY_PASSWORD,"disabled","Input Field Primary Billing Server Password"); 
		checkStatus(IPF_PRIMARY_CONFIRM_PASSWORD,"disabled","Input Field Primary Billing Confirm Password"); 
		checkStatus(IPF_SECOND_HOSTNAME,"disabled","Input Field Secondary Billing Server Hostname"); 
		checkStatus(IPF_SECOND_USERNAME,"disabled","Input Field Secondary Billing Server Username"); 
		checkStatus(IPF_SECOND_PASSWORD,"disabled","Input Field Secondary Billing Server Password"); 
		checkStatus(IPF_SECOND_CONFIRM_PASSWORD,"disabled","Input Field Secondary Billing Server Confirm Password"); 
		checkStatus(IPF_RE_ATTEMPT,"disabled","Input Field Re-attempt timer"); 

		checkValue_byId(IPF_MAX_RECORD_VALUE, "999");
		checkValue_byId(IPF_MAX_TIME_INTERVAL, "6");
		checkValue_byId(IPF_MAX_FILE_SIZE, "200");
		checkSelectedValue_inDropDownList(SLC_TRANSFER_METHOD, TXT_TRANSFER_METHOD_PULL);
		checkValue_byId(IPF_PORT, "23");
		checkStatus(CB_ALLOW_OVERWRITE,"checked","Checkbox Allow file overwrite"); 
	 
//		//Select Tab Music On Hold
//		clickButton(TB_MUSIC_ON_HOLD);
//		
//		//Verify Music On Hold Activation
//		checkStatus(CB_ENABLE_MOH,"enabled","Checkbox Enable MOH"); 
//	    checkStatus(CB_ENABLE_MOH,"checked","Checkbox Enable MOH"); 
//	       
//	    checkStatus(CB_ENABLE_MOH_SUB,"enabled","Enable MOH for Subscribers"); 
//	    checkStatus(CB_ENABLE_MOH_SUB,"checked","Enable MOH for Subscribers"); 
	    
		clickButtonCancel();
		updateMap(RETRIES);
	   }
			
	
}