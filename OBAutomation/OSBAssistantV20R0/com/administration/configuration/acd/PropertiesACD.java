package com.administration.configuration.acd;

import com.Seleniumhelper.SeleniumWebdriver;

public interface PropertiesACD {
	
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
	 * IMG:_=Image(GIF)
	 */
	
	//ACD_GENERAL
	String TB_ACD_GENERAL_TAB = "acd:tabgeneral_tab0";	
	
	String IPF_LOG_ON_SERVICE_ACCESS_CODE = "acd:entry1";
	String IPF_LOG_OFF_SERVICE_ACCESS_CODE = "acd:entry2";
	String IPF_AGENT_TIMEOUT = "acd:entry3";
	String CB_SUPPORT_KEYSET_TOGGLE_KEY = "acd:entry7";
	String IPF_KEYSET_TOGGLE_SERVICE_ACCESS_CODE = "acd:entry8";
	String BTN_SHOW_STATUS = "acd:showButton";
	String BTN_CONFIGURE_MUSIC_ON_HOLD = "acd:configureButton1";
	String BTN_CONFIGURE_ANNOUNCEMENT = "acd:configureButton2";
	String DIV_LOG_ON_SERVICE_ACCESS_CODE_VALIDATION = "field1_messages_id1";
	String DIV_LOG_OFF_SERVICE_ACCESS_CODE_VALIDATION = "field2_messages_id1";
	String TXT_SAME_VALUES_NOT_POSSIBLE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGuiError", "common.sameValuesLogOnLogOff");

	String BTN_UPLOAD_BROWSE_BUTTON = "acdMusic:file";
	String TBL_LIST_WAV_FILES = "acdMusic:fileGrid";

	//Show Agent Status window
	String TBL_LIST_AGENT = "acd:agentsListGrid";
	
	//Texts (in list Agent) retrieved from property files
	String TXT_AGENT_ID = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "acd.id");
	String TXT_AGENT_STATUS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "acdStatus.status");
	String TXT_AGENT_PHONE_NUMBER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "acdStatus.phoneNumber");
	String TXT_AGENT_ASSIGNED_PROFILE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "acd.assignedProfile");
	
	//Queue tab
	String TB_QUEUE = "acd:queue_tab1";
	String BTN_ADD_QUEUE = "acd:queue:queueListGrid:addButton";
	String BTN_EDIT_QUEUE = "acd:queue:queueListGrid:editButton";
	String BTN_DELETE_QUEUE = "acd:queue:queueListGrid:deleteButton";
	String TBL_LIST_QUEUE = "acd:queue:queueListGrid";
	String IPF_FILTER_QUEUE = "acd:queue:queueListGrid:filterValue";
	String SLC_FILTER_QUEUE = "acd:queue:queueListGrid:filter2";
	String BTN_FILTER_QUEUE_GO = "acd:queue:queueListGrid:startFilterButton";
	String BTN_FILTER_QUEUE_CLEAR = "acd:queue:queueListGrid:clearFilterButton";
	
	
	//Texts (in list Queue) retrieved from property files
	String TXT_QUEUE_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editQueue.name");
	String TXT_QUEUE_DID = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editQueue.did");
	String TXT_DID_LIST = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "acd.didList");
    String TXT_QUEUE_DESTINATION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editQueue.overflowDestination");
    String TXT_ASSIGNED_AGENT_IDs = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "acd.assignedAgentIds");
    String TXT_OVERFLOW_TO_VOICE_MAIL_SERVER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editQueue.overflowToVoiceMail");
	
	//Add Queue window
    
    //General tab
    String TB_QUEUE_GENERAL = "editQueue:tabgeneral_tab0";
    String IPF_QUEUE_ID = "editQueue:idEntry";
    String IPF_QUEUE_NAME = "editQueue:nameEntry";
    String IPF_QUEUE_DESTINATION = "editQueue:overflowDestinationEntry";
    String CB_OVERFLOW_TO_MAIL_SERVER = "editQueue:overflowToVoiceMailEntry";
    String CB_GENERATE_DIVERSION_HEADER = "editQueue:generateDiversionHeaderEntry";
    String IPF_QUEUE_ADVANCE_TIME_OUT = "editQueue:queueAdvanceTimeOutEntry";
    String IPF_AGENT_WRAP_UP_TIME = "editQueue:agentsWrapUpTimeEntry";
    String CB_PLAY_RING_TONE = "editQueue:playRingtoneEntry";
    String SLC_MUSIC_ON_HOLD = "editQueue:musicOnHoldCombobox";
    String IPF_MAXIMUM_WAITING_TIME = "editQueue:maxWaitingTimeEntry";
    String CB_UNLIMITED = "editQueue:unlimitedEntry";
    String IPF_MAXIMUM_CALLERS = "editQueue:callersEntry";
    
    //DID tab
    String TBL_LIST_QUEUE_DID = "editQueue:queue:didGrid";
    String TB_QUEUE_DID = "editQueue:did_tab1";
    String IPF_QUEUE_DID = "editQueue:queue:didField";
    String BTN_ADD_QUEUE_DID = "editQueue:queue:addDidButton";
    String BTN_DELETE_QUEUE_DID = "editQueue:queue:didGrid:deleteButton";
    
    //Announcements tab
    String TB_QUEUE_ANNOUNCEMENTS = "editQueue:announcements_tab2";
    String SLC_QUEUE_JOIN = "editQueue:announcements:queueJoinCombobox";
    String SLC_QUEUE_WAITING = "editQueue:announcements:queueWaitingCombobox";
    String SLC_QUEUE_AGENT = "editQueue:announcements:agentCombobox";
    String IPF_POSITION_ANNOUNCEMENT_FREQUENCY = "editQueue:announcements:positionHoldTimeFrequencyEntry";
    String BTN_PLAY_QUEUE_JOIN_ANNOUNCEMENT = "editQueue:announcements:button1";
    String BTN_PLAY_QUEUE_WAITING_ANNOUNCEMENT = "editQueue:announcements:button2";
    String BTN_PLAY_QUEUE_AGENT_ANNOUNCEMENT = "editQueue:announcements:button3";
    String CB_ANNOUNCE_POSITION_TO_CALLER = "editQueue:announcements:positionToCallerCb";
    String CB_ANNOUNCE_ESTIMATED_HOLD_TIME_TO_CALLER = "editQueue:announcements:positionToCallerCb";
    String CB_ANNOUNCE_HOLD_TIME_TO_AGENT = "editQueue:announcements:holdTimeToAgentCb";
    String IPF_INTERVAL_QUEUE_JOIN_QUEUE_WAITING = "editQueue:announcements:internalBetweenEntry";
    
    
    //Profiles tab
    String TB_PROFILES = "acd:profiles_tab2";
    String BTN_ADD_PROFILE = "acd:profiles:profilesListGrid:addButton";
    String BTN_EDIT_PROFILE = "acd:profiles:profilesListGrid:editButton";
    String BTN_DELETE_PROFILE = "acd:profiles:profilesListGrid:deleteButton";
    String TBL_LIST_PROFILES = "acd:profiles:profilesListGrid";
	String IPF_FILTER_PROFILE = "acd:profiles:profilesListGrid:filterValue";
	String BTN_FILTER_PROFILE_GO = "acd:profiles:profilesListGrid:startFilterButton";
	String BTN_FILTER_PROFILE_CLEAR = "acd:profiles:profilesListGrid:clearFilterButton";
	
	//Texts (in list Profiles) retrieved from property files
	String TXT_PROFILENAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "profile.name");
	String TXT_ASSIGNED_QUEUE_ID = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "acd.assignedQueueIds");
	
	//Add Profile pop-up
	String IPF_PROFILE_NAME = "acdEditProfile:entry1";
	String IPF_ASSIGNED_QUEUE_IDs = "acdEditProfile:entry2";
 
    
	  
    //Agents tab
    String TB_AGENTS = "acd:agents_tab3";
    String BTN_ADD_AGENT = "acd:agents:agentsListGrid:addButton";
    String BTN_EDIT_AGENT = "acd:agents:agentsListGrid:editButton";
    String BTN_DELETE_AGENT = "acd:agents:agentsListGrid:deleteButton";
    String TBL_LIST_AGENTS = "acd:agents:agentsListGrid";
	String IPF_FILTER_AGENT = "acd:agents:agentsListGrid:filterValue";
	String SLC_FILTER_AGENT = "acd:agents:agentsListGrid:filter3";
	String BTN_FILTER_AGENT_GO = "acd:agents:agentsListGrid:startFilterButton";
	String BTN_FILTER_AGENT_CLEAR = "acd:agents:agentsListGrid:clearFilterButton";


	//Texts (in list Agents) retrieved from property files
    String TXT_AGENT_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editAgents.name");
    String TXT_ASSIGNED_PROFILE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "acd.assignedProfile");
    
	//Add Agent pop-up
	String IPF_AGENT_ID = "editAgentsForm:idAgentEntry";
	String IPF_AGENT_NAME = "editAgentsForm:nameAgentEntry";
	String IPF_AGENT_PASSWORD = "editAgentsForm:passwdAgentEntry";
	String IPF_AGENT_CONFIRM_PASSWORD = "editAgentsForm:passwdConfAgentEntry";
	String SLC_ASSIGNED_PROFILE = "editAgentsForm:profileAgentEntry";
 
  
    
    
    
    
    
    
}

