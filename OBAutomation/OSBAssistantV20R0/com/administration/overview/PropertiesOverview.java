package com.administration.overview;


import com.Seleniumhelper.*;

public interface PropertiesOverview {
	
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
	
    //Buttons
	String BTN_MANAGE_OSB = "formName:openBranchGrid:configure";
	String BTN_LOCAL_PASSWORD_OSB = "formName:openBranchGrid:password";
	String BTN_REFRESH_ALL_OSB = "formName:openBranchGrid:updateAll";
	String BTN_ADD_OSB = "formName:openBranchGrid:add";
	String BTN_EDIT_OSB = "formName:openBranchGrid:edit";
	String BTN_DELETE_OSB = "formName:openBranchGrid:delete";
	String BTN_APPLY_FILTER_OSB = "formName:openBranchGrid:startFilterButton";
	String BTN_CLEAR_FILTER_OSB = "formName:openBranchGrid:clearFilterButton";
	
	//Drop-Down menus
	String SLC_FILTER_OPTIONS = "formName:openBranchGrid:filter2";
	String SLC_ITEMS_PER_PAGE_MAIN_LIST = "formName:openBranchGrid:rowPerPageForGrid";
	String SLC_FILTER_OPTIONS_MODE = "formName:openBranchGrid:filterMode";
	
	//Input Fields
	String IPF_FILTER_MAIN_LIST = "formName:openBranchGrid:filterValue";
	
	//Add Central SBC Branch Window
	
	//Input Fields
	String IPF_CENTRAL_SBC_NAME = "editOpenBranches:branchOfficeField";
	String IPF_CENTRAL_SBC_IP_ADDRESS = "editOpenBranches:openBranchIpAddressField";
	String IPF_CENTRAL_SBC_COMM_SYSTEM = "editOpenBranches:commSystemField";
	String IPF_CENTRAL_SBC_BG = "editOpenBranches:bussinesGroupField";
	String IPF_CENTRAL_SBC_ENDPOINT = "editOpenBranches:endpointField";

    //Buttons
	String BTN_SELECT_COMM_SYSTEM = "editOpenBranches:commSystemButton";
	String BTN_SELECT_BG = "editOpenBranches:bgButton";
	String BTN_SELECT_ENDPOINT = "editOpenBranches:epButton";

	//Drop-Down Lists
	String SLC_PROFILE_NAME = "editOpenBranches:profileCombobox";

	//Local Password window
	
	//Input Fields
	String IPF_BRANCH_USER = "passwordManagementForm:localUserField";
	String IPF_BRANCH_PASSWORD = "passwordManagementForm:localNewPasswordField";
	String IPF_BRANCH_PASSWORD_CONFIRM  = "passwordManagementForm:localConfirmNewPasswordField";
	
	//Buttons
	String BTN_CHANGE_PASSWORD = "passwordManagementForm:changePassword";
	String BTN_RESET_PASSWORD = "passwordManagementForm:resetPassword";
	
	 //Texts (Appeared in main List,Drop-Down Lists etc..) retrieved from property files
	 String TXT_BRANCH_OFFICE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listOpenBranches.branchOffice");
	 String TXT_BUSINESS_GROUP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listOpenBranches.businessGroup");
	 String TXT_COMM_SYSTEM = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listOpenBranches.commSystem");
	 String TXT_IP_ADDRESS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.ipaddress");
	 String TXT_MODE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.mode");
	 String TXT_LAST_UPDATE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listOpenBranches.lastUpdate");
	 String TXT_SYSTEM_INFO = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "branchoffice.systemInfo");
	 String TXT_STATISTICS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "branchoffice.statisticsTitle");
	 String TXT_LICENSING_INFO = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listDashboard.licensingInformation");
}
