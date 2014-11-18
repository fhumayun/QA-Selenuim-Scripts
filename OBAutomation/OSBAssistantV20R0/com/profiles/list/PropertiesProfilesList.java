package com.profiles.list;

import com.Seleniumhelper.SeleniumWebdriver;

public interface PropertiesProfilesList {
	
	/*
	 * BTN_ := Button ID
	 * IPF_ := Input Field ID 
	 * TB_:= Tab ID
	 * CB_:= Checkbox ID
	 * SLC_:= Selector ID
	 * TEXT_:= Generic Error messages
	 * ARW_:= Arrow ID
	 * LBL_:= Label ID
	 * BD_:= Body ID
	 * TBL_:= Table ID
	 * DIV_ := Div ID
	 * FRN_ := Frame Name
	 * IFR_ := IFrame ID
	 * TD_ := Tabel td ID
	 * XPATH_ := XPath
	 * INF_:= Info Bar
	 * CLM_ := Column Name
	 * TBN:_=Table Name
	 */
	
	String TBL_LIST_PROFILES = "formName:grid";
	String BTN_ADD_PROFILE = "formName:grid:add";
	String BTN_EDIT_PROFILE = "formName:grid:edit";
	String BTN_DELETE_PROFILE = "formName:grid:delete";
	String BTN_CLONE_PROFILE = "formName:grid:clone";
	String BTN_NEXT_PAGE = "//img[@id='formName:grid:grid_paging_nextbutton']";
	String BTN_PREVIOUS_PAGE = "//img[@id='formName:grid:grid_paging_previousbutton']";
	String BTN_LAST_PAGE = "//img[@id='formName:grid:grid_paging_lastbutton']";
	String BTN_FIRST_PAGE = "//img[@id='formName:grid:grid_paging_firstbutton']";
	String IPF_FILTER_PROFILE = "formName:grid:filterName";
	String SLC_FILTER_PROFILE = "formName:grid:filter2";
	String SLC_FILTER_PROFILE_MODE = "formName:grid:filterMode";
	String SLC_FILTER_PROFILE_VERSION = "formName:grid:filterVersion";
	String SLC_ITEMS_PER_PAGE = "formName:grid:rowPerPageForGrid";
	String SLC_PAGING = "formName:grid:grid_paging_pagingDropDown";
	String BTN_FILTER_PROFILE_GO = "formName:grid:startFilterButton";
	String BTN_FILTER_PROFILE_CLEAR = "formName:grid:clearFilterButton";
	
	//Texts (in list Profiles) retrieved from property files
	String TXT_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.name");
	String TXT_PROFILE_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "profile.name");
	String TXT_PROFILE_MODE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.mode");
	String TXT_PROFILE_VERSION  = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listOpenBranches.version");
 
	//Add Profile pop-up
	String IPF_PROFILE_NAME = "profileForm:nameField";
	String SLC_MODE = "profileForm:modeCombobox";
	String SLC_VERSION = "profileForm:filterVersion";
	
	//Options (in Drop-Down List Mode)
//	String TXT_BRANCH_SBC = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "BranchSBC");
//	String TXT_SBC_PROXY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "sbcProxy");
//	String TXT_PROXY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Proxy");
//	String TXT_PROXY_ACD = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "proxyAcd");

	//Drop-Down List Profile Name in Branchoffice List
	String SLC_PROFILE_NAME = "editOpenBranches:profileCombobox";
}
