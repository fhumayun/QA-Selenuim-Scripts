package com.administration.jobmanagement;


import com.Seleniumhelper.*;

public interface PropertiesJobManagement {
	
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
	

	//Main Page
	
	String TBL_LIST_JOBS = "listSchedulesForm:listSchedulesGrid";
	
    //Buttons
	String BTN_ADD_JOB = "listSchedulesForm:listSchedulesGrid:add";
	String BTN_EDIT_JOB = "listSchedulesForm:listSchedulesGrid:edit";
	String BTN_DELETE_JOB = "listSchedulesForm:listSchedulesGrid:delete";
	String BTN_CLONE_JOB = "listSchedulesForm:listSchedulesGrid:clone";
	String BTN_CANCEL_JOB = "listSchedulesForm:listSchedulesGrid:cancel";
	String BTN_VIEW_DETAILED_STATUS_JOB = "listSchedulesForm:listSchedulesGrid:status";
	String BTN_APPLY_FILTER_JOB = "listSchedulesForm:listSchedulesGrid:start";
	String BTN_CLEAR_FILTER_JOB = "listSchedulesForm:listSchedulesGrid:clear";
	
	
	//Drop-Down menus
	String SLC_JOB_FILTER_OPTIONS = "listSchedulesForm:listSchedulesGrid:filter2";
	String SLC_ITEMS_PER_PAGE_MAIN_LIST = "listSchedulesForm:listSchedulesGrid:rowPerPageForGrid";
	
	String SLC_FILTER_STATUS = "listSchedulesForm:listSchedulesGrid:filterStatus2";
	String SLC_FILTER_ACTION = "listSchedulesForm:listSchedulesGrid:filterStatus";
	//Input Fields
	String IPF_FILTER_JOB = "listSchedulesForm:listSchedulesGrid:filterValue";
	String IPF_FILTER_JOB_START_DATE = "listSchedulesForm:listSchedulesGrid:calendarInputText";
	
	//Texts (Appeared in main List,Drop-Down Lists etc..) retrieved from property files
	String TXT_JOB_STATUS = "Status";
	String TXT_JOB_ID = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listSchedules.jobId");
	String TXT_ACTION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listSchedules.action");
	String TXT_START_DATE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listSchedules.startTime");
	String TXT_NOTE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listSchedules.note");
    
	String TXT_TRANSFER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listSchedules.transfer");
	String TXT_ACTIVATION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listSchedules.activation");
	String TXT_TRANSFER_WAV_FILES = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listSchedules.transferWavFiles");
	String TXT_ASSIGN_PROFILE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listSchedules.assignProfile");
	
	//Create Schedule pop-up
	
	String SLC_JOB_ACTION = "scheduleForm:actionCombobox";
	String IPF_ACTION_INPUT = "scheduleForm:targetVersionField";
	String BTN_SELECT_ACTION_INPUT = "scheduleForm:configureButton";
	String IPF_NOTE = "scheduleForm:noteField";
	
	String RB_IMMEDIATE = "//table[@id='immediateRadio']/tbody/tr/td/label/input";
	String RB_DATE = "//table[@id='dateRadio']/tbody/tr/td/label/input";
	
	String IPF_JOB_DATE = "scheduleForm:calendar";
	String IPF_JOB_TIME_HOUR = "scheduleForm:date.hours";
	String IPF_JOB_TIME_MINUTE = "scheduleForm:date.minutes";
	String SLC_ITEMS_PER_PAGE_NODES_LIST = "scheduleForm:openBranchGrid:rowPerPageForGrid";
	String TBL_LIST_NODES = "scheduleForm:openBranchGrid";
	String BTN_ADD_NODE = "scheduleForm:openBranchGrid:addButton";
	String BTN_DELETE_NODE = "scheduleForm:openBranchGrid:deleteButton";
	
	//Texts (Appeared in List Nodes) retrieved from property files
	String TXT_OB_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.name");
	String TXT_CURRENT_VERSION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listSchedules.currentVersion");
	String TXT_BUSINESS_GROUP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listOpenBranches.businessGroup");
	String TXT_COMM_SYSTEM = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "listOpenBranches.commSystem");
	String TXT_IP_ADDRESS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.ipaddress");
	
	String TBL_LIST_BRANCH_OFFICES = "addNodeForm:openBranchGrid";
	
	//View Detailed Status pop-up
	String IPF_VIEW_JOB_ACTION ="scheduleForm:actionField";
	String IPF_VIEW_TARGET_VERSION ="scheduleForm:targetVersionField";
	String IPF_VIEW_NOTE = "scheduleForm:noteField";
	
	//CMP
	String IPF_UPLOAD_WAV_FILE = "importConfigurationFilePopUp:Addfile";
	String TBL_CMP_LIST_REPOSITORIES = "respositoryForm:repositoryData";
	String TXT_PRODUCT_NAME = SeleniumWebdriver.readproperties("operationportlet\\Resources", "repository.application");
	String TXT_PRODUCT_VERSION = SeleniumWebdriver.readproperties("operationportlet\\Resources", "repository.version");
	
	
	//Profiles Management
	String BTN_CREATE_JOB = "formName:createJob";
	
}
