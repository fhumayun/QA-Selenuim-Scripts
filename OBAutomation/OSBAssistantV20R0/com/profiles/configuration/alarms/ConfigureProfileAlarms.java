package com.profiles.configuration.alarms;

import com.administration.configuration.alarms.PropertiesAlarms;
import com.helper.SuperHelper;
import com.profiles.list.PropertiesProfilesList;

public class ConfigureProfileAlarms extends SuperHelper implements PropertiesProfilesList,PropertiesAlarms {

	public void configureProfileForAlarms() throws InterruptedException {
		
	    goToProfilesAlarms();
	    
	    updateMap(RETRIES);
		
		//Go to Trap Destinations tab
		clickButton(TB_PROFILES_ALARMS_TRAP_DESTINATIONS);
		
		//Add a Blocked Trap Destination
		clickButtonAdd();
		
		updateMap(RETRIES);
		
		type_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.100");
		type_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "1;2;3");
		clickCheckbox_byID(CB_ALARMS_TRAP_DEST_BLOCKED);
		
		clickButtonSave();
		
		updateMap(RETRIES);
		
		//Check Trap Destination Creation
		checkTextIsContained_byXPathTable(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.100");
		
		//Check Port and Reporting class set column values
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.100", "Port", "162");
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.100", "Reporting class set", "1;2;3");
						
		//Check Trusted image presence
		checkElement(IMG_ALARMS_TRAP_DEST_BLOCKED);
		
		clickButtonSave();
		updateMap(RETRIES);
		applyChangesWithConfirmationProfiles();
	    
	}
	
      public void verifyProfileAlarmsConfiguration() throws InterruptedException {
	    	
	    methodLogger.log();
	    goToAdministrationAlarms();
	    updateMap(RETRIES);
			
	    //Go to Trap Destinations tab
	    clickButton(TB_ALARMS_TRAP_DESTINATIONS);
			
		//Verify Trap Destination Creation
		checkTextIsContained_byXPathTable(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.100");
			
		//Verify Port and Reporting class set column values
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.100", "Port", "162");
		checkElementText_inSpecificTableColumn(TBL_ALARMS_LIST_TRAP_DESTINATIONS, "10.11.250.100", "Reporting class set", "1;2;3");
				
		//Verify Trusted image presence
		checkElement(IMG_ALARMS_TRAP_DEST_BLOCKED);
		
		//Edit the Trap Destination
		clickCheckbox_byText("10.11.250.100");
		clickButton(BTN_ALARMS_TRAP_DEST_EDIT_BUTTON);
			
		updateMap(RETRIES);
			
		//Verify Trap Destination Input Fields values and Blocked checkBox status
		checkValue_byId(IPF_ALARMS_TRAP_DEST_IP_ADDRESS, "10.11.250.100");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_PORT, "162");
		checkValue_byId(IPF_ALARMS_TRAP_DEST_REPORTING_CLASS_SET, "1;2;3");
		checkStatus(CB_ALARMS_TRAP_DEST_BLOCKED, "checked", "Checkbox Set as active");
			
		clickButtonCancel();
		updateMap(RETRIES);
			
	    clickButtonCancel();
	    updateMap(RETRIES);
	   }
			
	
}