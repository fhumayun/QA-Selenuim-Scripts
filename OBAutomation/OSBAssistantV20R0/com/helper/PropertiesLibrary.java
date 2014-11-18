package com.helper;

import com.Seleniumhelper.SeleniumWebdriver;

public interface PropertiesLibrary {

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

	/**
	 * GENERIC MESSAGES
	 */	
	String TEXT_USERNOPERMISSION = "This user account has no permissions for Common Management Portal usage.";	
	String TEXT_USERLOCKED = "This user account is locked. Please contact the system administrator.";	
	String TEXT_ADMINISTRATORCANNOTBEDELETED = "User \"administrator\" cannot be deleted. Action is not allowed for this user because of special administrator rights.";	
	String TEXT_VALUEISREQUIRED = "Value is required.";	
	String TEXT_USERALREADYEXISTS = "User already exists";		
	String TEXT_NAMECANNOTCONTAINSPACE = "Name cannot contain white space characters";	
	String TEXT_PASSWORDNOTWELLFORMED = "Password not well formed. Required is:\nMinimum length is 8 characters\nAt least 1 digits\nAt least 1 special characters\nAt least 1 upper case letters";
	String TEXT_PASSWORDCONFIRMATIONINCOSISTENT="Password confirmation inconsistent";
	String TEXT_TRADEMARK="The Siemens brand is used under Trademark License of Siemens AG by Siemens Enterprise Communications GmbH & Co. KG";
	String TEXT_REQUIREDFIELD="Required field";
	String TEXT_USERNAMEATDOMAIN="Use <username>@<domain>";
	String TEXT_INVALIDUSERNAMEPASSWRD="Invalid user name or password";	
	String TEXT_DE_1 = "Pflichtfeld";	
	String TEXT_DE_2 = "Benutzername oder";	// UngÎ“ÎŒltiger Benutzername oder ungÎ“ÎŒltiges Passwort.
	String TEXT_DE_3 = "Format: <Benutzername>";	// Format: <Benutzername>@<DomÎ“Â¤ne>
	
	/**
	 * LOGIN SCREEN
	 * Input field for username within login page
	 * Input field for password within login page
	 */
	String DIV_LOGINAREA="input_field";
	String IPF_NEWPASSWORD = "newPasswordInput";
	String IPF_RETYPENEWPASSWORD = "checkPasswordInput";
	String BTN_CONTINUE = "submitButton";
	String DIV_LOGIN_TRADEMARK="footer_login";
	String DIV_LOGIN_USERNAME_VALIDATION="DomainMissing";
	String DIV_LOGIN_PASSWORD_VALIDATION="passwordDisplayInputError";
	String DIV_LOGIN_VALIDATION_1="login.label.ErrorCode.2000";
	String DIV_LOGIN_VALIDATION_2="login.label.ErrorCode.2002";
	String DIV_LOGIN_VALIDATION_11="login.label.ErrorCode.11";
	String DIV_LOGIN_VALIDATION_2108="login.label.ErrorCode.2108";
	String DIV_LOGIN_NEWPASSWORD="newPasswordInputError";
	String DIV_LOGIN_RETYPENEWPASSWORD="checkPasswordInputError";
	
	/**
	 * MAIN NAVIGATION on Login page
	 */	
	String DIV_HOME_TRADEMARK="footer";
	String TB_DOMAINS = "Domains";
	String BTN_LOGOUT = "login";
	String TBL_PAGING = "pagingControl"; // Items 
	String DIV_GRID = "scrollTable"; // or "gridData_tableContainer" - All the grid, including the headers 
	
	
	/**
	 * Open Branch
	 */
	
	String SLC_SELECTPROFILE= "com_siemens_ob_selectedProfile";
	String SLC_SELECTSYSTEM	= "com_siemens_ob_selectedCommSystem";
	String SLC_BRANCHOFFICE	= "com_siemens_ob_selectedGateway";
	String TXT_NUMBER_OF_ITEMS_IN_LIST="allNumberOfItemsAcrossPagesNumberId";
	String BTN_APPLYCHANGES = "formName:outerGrid:applyChanges";
	String BTN_CANCELCHANGES = "formName:outerGrid:cancelChanges";
	String BTN_PROFILE_APPLYCHANGES = "formName:applyChanges";
	String BTN_PROFILE_CANCELCHANGES = "formName:cancelChanges";
	String BTN_REFRESH_SELECTED_OSB = "formName:openBranchGrid:updateSelected";
	String TBL_BRANCH_OFFICE_LIST = "formName:openBranchGrid";
	String TB_SYSTEM_IMPORT_EXPORT = "editUtilities:importExport_tab2";
	String BTN_IMPORT_XML = "editUtilities:importExport:importButton";
	String IPF_XML_FILE = "importConfigurationFilePopUp:Addfile";
	String TXT_STATUS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listOpenBranches.status");
	String TXT_VERSION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listOpenBranches.version");	
	String TXT_UPLOAD_COMPLETED = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGuiError", "editImportExport.importFilePlusCancel");
	String TXT_BRANCH_SBC = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "BranchSBC");
	String TXT_SBC_PROXY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "sbcProxy");
	String TXT_PROXY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Proxy");
	String TXT_PROXY_ACD = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "proxyAcd");


}
