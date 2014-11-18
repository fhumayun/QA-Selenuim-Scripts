package com.profiles.list;

import com.helper.SuperHelper;

public class Profiles_GeneralMethods extends SuperHelper implements PropertiesProfilesList {
 	
   public void createProfile(String name,String mode,String version) throws InterruptedException 
   {		
	 clickButtonAdd();
	 updateMap(RETRIES);
			
	 type_byId(IPF_PROFILE_NAME, name);
	 selectFromDropDown(SLC_MODE, mode);
	 selectFromDropDown(SLC_VERSION, version);
			
	 clickButtonSave();
	 updateMap(RETRIES);
			
	 //Check Creation
	 checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, name);
	 //checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, name, TXT_PROFILE_MODE, mode);
	 //checkElementText_inSpecificTableColumn(TBL_LIST_PROFILES, name, TXT_PROFILE_VERSION, version);	
   }

   public void modifyProfile(String oldName,String newName) throws InterruptedException 
   {
			
		clickCheckbox_byText(oldName);
		clickButtonEdit();
		updateMap(RETRIES);
		
		type_byId(IPF_PROFILE_NAME, newName);
	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check Modification
		checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, newName);
    }
 
   public void cloneProfile(String profileToCloned,String newProfile) throws InterruptedException 
   {
			
		clickCheckbox_byText(profileToCloned);
		clickButtonClone();
		updateMap(RETRIES);
		
		type_byId(IPF_PROFILE_NAME, newProfile);
	
		clickButtonSave();
		updateMap(RETRIES);
		
		//Check Clone
		checkTextIsContained_byXPathTable(TBL_LIST_PROFILES, newProfile);
    }
   
   
   public void deleteProfile(String name) throws InterruptedException 
   {	
	    clickCheckbox_byText(name);
		clickButtonDelete();
		
		//Check Deletion
		checkText_NotVisible(name);
   }
 
   public void assignProfile(String name) throws InterruptedException 
   {
	goToBranchOfficeList();		
	clickCheckbox_byText(OpenBranch);
	clickButtonEdit();
	updateMap(RETRIES);
	selectFromDropDown(SLC_PROFILE_NAME, name);
	clickButtonSave();
	updateMap(160);
   }
 
}