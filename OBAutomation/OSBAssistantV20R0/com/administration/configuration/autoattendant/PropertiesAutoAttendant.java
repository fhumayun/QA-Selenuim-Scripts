package com.administration.configuration.autoattendant;

import com.Seleniumhelper.SeleniumWebdriver;


public interface PropertiesAutoAttendant {
	
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
	
	//TAB General
	String TB_GENERAL = "form:voip_tab0";
	String CB_ENABLE_AUTO_ATTENDANT = "form:checkbox";
	String IPF_DATE_INFO = "form:e1";
	String IPF_DAY_INFO = "form:e2";
	String IPF_TIME_INFO = "form:e3";
	String IPF_INTERDIGIT_TIMER = "form:e4";
	String IPF_WAIT_TO_GO_TO_MENU = "form:e5";
	String IPF_RECORD_ACCESS_CODE = "form:e7";
    String TBL_LIST_ANNOUNCEMENT_FILES = "form:fileGrid";
    String BTN_UPLOAD_BROWSE_BUTTON="form:file";
    String BTN_ADD_ANNOUNCEMENT="form:addButton";
    String BTN_DELETE_ANNOUNCEMENT="form:fileGrid:deleteButton";
	
	//TAB Routing
	String TB_ROUTING = "form:routing_tab1";
	String BTN_ADD_ROUTING = "form:routing:grid:addButton";
	String BTN_EDIT_ROUTING = "form:routing:grid:editButton";
	String BTN_DELETE_ROUTING = "form:routing:grid:deleteButton";
	String TBL_LIST_ROUTING = "form:routing:grid";
	//Texts (in list Routing) retrieved from property files
	String TXT_ROUTING_METHOD = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.routingMethod");
	String TXT_IP_FQDN_DN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.FQDNorDN");
	String TXT_MENU1 = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.menu")+"1";
	String TXT_MENU2 = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.menu")+"2";
	String TXT_MENU3 = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.menu")+"3";
	String TXT_INITIAL_GREETING = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.initialGreeting");
	String TXT_FORWARD_TO_ORIGINAL_DEST = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.forwardDest");
	String TXT_DEFAULT_DESTINATION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.defaultDest");
	String TXT_ROUTING_CODE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.routingCode");
	String IMG_FORWARD_TO_ORIGINAL_DEST_ENABLED = "form:routing:grid:0:enabledImage";
	//Add Routing pop-up
	String IPF_ROUTING_NAME = "form:e1";
	String SLC_ROUTING_METHOD = "form:e2";
	String IPF_IP_FQDN_DN = "form:e3";
	String SLC_MENU1 = "form:e4";
	String SLC_MENU2 = "form:e5";
	String SLC_MENU3 = "form:e6";
	String SLC_INITIAL_GREETING = "form:e7";
	String CB_FORWARD_TO_ORIGINAL_DEST = "form:e8";
	String IPF_ROUTING_DEFAULT_DESTINATION = "form:e9";
	String IPF_ROUTING_CODE = "form:routing";
		

	//TAB Menus
	String TB_MENUS	= "form:menuPage_tab2";
	String BTN_ADD_MENU = "form:menus:aaMenusGrid:addButton";
	String BTN_EDIT_MENU = "form:menus:aaMenusGrid:editButton";
	String BTN_DELETE_MENU = "form:menus:aaMenusGrid:deleteButton";
	String TBL_LIST_MENU = "form:menus:aaMenusGrid";
	//Texts (in list Menu) retrieved from property files
	String TXT_MENU_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.name");
	String TXT_ACTIVATION_MODE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.activationMode");
	String TXT_DAY_START = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.dayStart");
	String TXT_DAY_STOP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.dayStop");
	String TXT_TIME1_START = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.time1start");
	String TXT_TIME1_STOP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.time1stop");
    //Add menu pop-up
	//General tab in Menus
	String TB_MENUS_GENERAL = "form:voip_tab0";
	String IPF_MENU_NAME = "form:e01";
	String IPF_MENU_TIME_OUT = "form:e02";
	String SLC_ACTIVATION_MODE = "form:e03";
	String SLC_DAY_START = "form:e04";
	String SLC_DAY_STOP = "form:e05";
	String SLC_TIME1_START_HOUR = "form:e61";
	String SLC_TIME1_START_MINUTE = "form:e62";
	String SLC_TIME1_STOP_HOUR = "form:e71";
	String SLC_TIME1_STOP_MINUTE = "form:e72";
	String SLC_TIME2_START_HOUR = "form:e81";
	String SLC_TIME2_START_MINUTE = "form:e82";
	String SLC_TIME2_STOP_HOUR = "form:e91";
	String SLC_TIME2_STOP_MINUTE = "form:e92";
	String IPF_ACTIVATION_CODE = "form:e10";
	String IPF_DEACTIVATION_CODE = "form:e11";
	String SLC_DESTINATION_SELECTION_GREETING_FILE = "form:e12";
	String SLC_FAILURE_PROMPT_FILE = "form:e13";
	String SLC_DEFAULT_DESTINATION_PROMPT_FILE = "form:e14";
	String SLC_FINAL_PROMPT_FILE = "form:e15";
	String SLC_TRANSFER_PROMPT_FILE = "form:e16";
	String SLC_DIAL_METHOD = "form:e17";
	String IPF_MENU_DEFAULT_DESTINATION = "form:e18";
	//Options (in Drop-Down Lists Activation Mode,Day Start,Day Stop and Dial Method) retrieved from property files
	String TXT_BOTH = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Both");
	String TXT_AUTOMATIC = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Automatic");
	String TXT_MANUAL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Manual");
	String TXT_EXTENSION_DIALING = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.extension");
	String TXT_DIGIT_SELECTION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "attendant.digitSelection");
	String TXT_MONDAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Monday");
	String TXT_TUESDAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Tuesday");
	String TXT_WEDNESDAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Wednesday");
	String TXT_THURSDAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Thursday");
	String TXT_FRIDAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Friday");
	String TXT_SATURDAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Saturday");
	String TXT_SUNDAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Sunday");
	  
	//Digit tab in Menus
	String TB_MENUS_DIGIT = "form:digits_tab1";
	String BTN_EDIT_DIGIT = "form:digits:digitsGrid:editButton";
}
