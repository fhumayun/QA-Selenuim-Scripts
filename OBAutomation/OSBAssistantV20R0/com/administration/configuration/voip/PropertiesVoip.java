package com.administration.configuration.voip;

import com.Seleniumhelper.SeleniumWebdriver;

public interface PropertiesVoip {
	
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
	String TB_GENERAL = "editVoipForm:voip_tab0";
	String SLC_MODE = "editVoipForm:openbranchCombobox";
	String BTN_MANIPULATION = "editVoipForm:configure";
	String BTN_ROUTING = "editVoipForm:routing";
	String BTN_ERROR_CODES = "editVoipForm:errorCodes";
	String BTN_CALL_FORWARD = "editVoipForm:callForwardButton";
	String IPF_LISTENING_PORT_TCP = "editVoipForm:tcpvalue";
	String IPF_LISTENING_PORT_UDP = "editVoipForm:udpvalue";
	String IPF_LISTENING_PORT_TLS = "editVoipForm:tlsvalue";
	String IPF_OPTIONS_SOURCE_PORT = "editVoipForm:optDestPortvalue";
	String IPF_RTP_PORTS_MIN = "editVoipForm:minvalue1";
	String IPF_RTP_PORTS_MAX = "editVoipForm:maxvalue1";
	String IPF_TIME_TO_LIVE = "editVoipForm:timevalue1";
	String IPF_SIP_PORTS_MIN = "editVoipForm:minvalue2";
	String IPF_SIP_PORTS_MAX = "editVoipForm:maxvalue2";
	String BTN_SHOW_PORT_MAPPING = "editVoipForm:portMappingButton";
	String BTN_CLEAR_PORT_MAPPING = "editVoipForm:clearPortMappingButton";
    String SLC_BACKUP_LINK_MODE = "editVoipForm:backuLinkModeCombobox";
    String BTN_CONFIGURE_BACKUP_LINK_MODE = "editVoipForm:configureBackupLinkButton";
	String CB_ENABLE_GATEWAYS = "editVoipForm:gatewaysCheck";
    String BTN_CONFIGURE_GATEWAYS = "editVoipForm:gatewayConfigure";
    String BTN_SIP_SERVICE_PROVIDER_PROFILES = "editVoipForm:gatewayprofileConfigure";
    String IPF_DNS_DYNAMIC_REFRESH_INTERVAL = "editVoipForm:dnsRefreshIntervalEntry";
    String CB_ROUTING_SUPERVISION_TIMER = "editVoipForm:extendAltRoutingTimerEntry";
    String SLC_ROUTING_SUPERVISION_TIMER = "editVoipForm:AltRoutingTimerValue";
	String CB_ENABLE_QOS = "editVoipForm:qosCheck";
	String BTN_CONFIGURE_QOS = "editVoipForm:qosConfigure";
	//Options (in Drop-Down Lists Mode and Backup Link Mode)
//	String TXT_BRANCH_SBC = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "BranchSBC");
//	String TXT_SBC_PROXY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "sbcProxy");
//	String TXT_PROXY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Proxy");
//	String TXT_PROXY_ACD = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "proxyAcd");
	String TXT_NONE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.None");
	String TXT_CLIENT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.modeBLC");
	String TXT_SERVER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.modeBLS");
	//SIP Manipulation pop-up
	String BTN_MOVE_UP_SIP_MANIPULATION = "voipConfigure:configureGrid:nav_configure_4";
	String BTN_MOVE_DOWN_SIP_MANIPULATION = "voipConfigure:configureGrid:nav_configure_5";
	String BTN_MOVE_ADD_SIP_MANIPULATION = "voipConfigure:configureGrid:addButton";
	String BTN_MOVE_EDIT_SIP_MANIPULATION = "voipConfigure:configureGrid:addButton";
	String BTN_MOVE_DELETE_SIP_MANIPULATION = "voipConfigure:configureGrid:deleteButton";
	String TBL_LIST_SIP_MANIPULATION = "voipConfigure:configureGrid";
	//Texts (in list SIP Manipulation) retrieved from property files
	String TXT_MATCH_DIGITS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipConfigure.matchDigits");
	String TXT_MATCH_POSITION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipConfigure.startMatch");
	String TXT_HEADER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipConfigure.header");
	String TXT_DELETE_INSERT_POSITION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipConfigure.deleteFrom");
	String TXT_NUMBER_OF_DIGITS_TO_DELETE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipConfigure.numberDigitsDelete");
	String TXT_INSERT_DIGITS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipConfigure.appendDigits");
	String TXT_ADD_PREFIX = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipConfigure.addPrefix");
	String TXT_REPLACE_ALL_WITH = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipConfigure.replaceAll");
	String TXT_CALL_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipConfigure.callType");
    //Add SIP manipulation pop-up
	String IPF_MATCH_DIGITS = "editConfigureForm:matchDigitsvalue";
	String IPF_MATCH_POSITION = "editConfigureForm:startMatchFromvalue";
	String SLC_HEADER = "editConfigureForm:headerConfigurevalue";
	String IPF_DELETE_INSERT_POSITION = "editConfigureForm:deleteFromValue";
	String IPF_NUMBER_OF_DIGITS_TO_DELETE = "editConfigureForm:deleteDigitsvalue";
	String IPF_INSERT_DIGITS = "editConfigureForm:appendDigitsvalue";
	String IPF_ADD_PREFIX = "editConfigureForm:addPrefixvalue";
	String IPF_REPLACE_ALL_WITH = "editConfigureForm:replaceDigitsvalue";
	String SLC_CALL_TYPE = "editConfigureForm:callTypeConfigureCombo";
	//Options (in Drop-Down Lists Header and Call Type) retrieved from property files
	String TXT_R_URI = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "R-URI");
	String TXT_FROM = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "FROM");
	String TXT_P_ASSERTED_IDENTITY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "P-AssertedIdentity");
	String TXT_P_PREFERRED_IDENTITY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "P-PreferredIdentity");
	String TXT_DIVERSION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Diversion");
	String TXT_ALL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "All");
	String TXT_PSTN_SIP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "PSTN-SIP");
	String TXT_SIP_PSTN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SIP-PSTN");
	String TXT_SIP_SIP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SIP-SIP");
	//SIP Routing pop-up
	String BTN_MOVE_ADD_SIP_ROUTING = "voipRouting:routingGrid:addButton";
	String BTN_MOVE_EDIT_SIP_ROUTING = "voipRouting:routingGrid:editButton";
	String BTN_MOVE_DELETE_SIP_ROUTING = "voipRouting:routingGrid:deleteButton";
	String TBL_LIST_SIP_ROUTING = "voipRouting:routingGrid";
	//Texts (in list SIP Routing) retrieved from property files
	String TXT_SOURCE_IP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipRouting.sourceIp");
	String TXT_CONDITION_ERROR_CODES = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipRouting.condition");
	String TXT_DESTINATION_IP_FQDN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipRouting.destinationIpFqdn");
	String TXT_DESTINATION_PORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipRouting.destinationPort");
	String TXT_DESTINATION_TRANSPORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipRouting.destinationTransport");
	String TXT_DESTINATION_TAG = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipRouting.destinationTag");
	String TXT_DESTINATION_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipRouting.destinationType");
	//Add SIP Routing pop-up
    String IPF_SOURCE_IP = "editRoutingForm:sourceIpvalue";
    String IPF_CONDITION_ERROR_CODES = "editRoutingForm:conditionvalue";
    String IPF_DESTINATION_IP_FQDN = "editRoutingForm:destinationIpvalue";
    String IPF_DESTINATION_PORT = "editRoutingForm:destinationPortvalue";
    String SLC_DESTINATION_TRANSPORT = "editRoutingForm:destinationTransportvalue";
    String IPF_DESTINATION_TAG = "editRoutingForm:destinationTagvalue";
    String SLC_DESTINATION_TYPE = "editRoutingForm:destinationTypevalue";
	//Options (in Drop-Down Destination Transport and Destination Type) retrieved from property files
	String TXT_TCP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "TCP");
	String TXT_UDP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "UDP");
	String TXT_TLS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "TLS");
	String TXT_GATEWAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "GATEWAY");
	String TXT_OTHER_SIP_EP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "OTHERSIPEP");
	String TXT_VOICE_MAIL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "VOICEMAIL");
	//Error Codes pop-up
	String BTN_ENABLE_ALL_SURVIVABLE_MODE = "errorCodesPopUp:enableSurvivableMode";
	String BTN_DISABLE_ALL_SURVIVABLE_MODE = "errorCodesPopUp:disableSurvivableMode";
	String BTN_ENABLE_ALL_NORMAL_MODE = "errorCodesPopUp:enableNoramlMode";
	String BTN_DISABLE_ALL_NORMAL_MODE = "errorCodesPopUp:disableNormalMode";
	String BTN_EDIT_ERROR_CODE = "errorCodesPopUp:errorCodesGrid:edit";
	String TBL_LIST_ERROR_CODES = "errorCodesPopUp:errorCodesGrid";
	String SLC_ERROR_CODES_ITEMS_PER_PAGE = "errorCodesPopUp:errorCodesGrid:rowPerPageForGrid";
	String TXT_ERROR_CODES_ALL_ITEMS = "allNumberOfItemsAcrossPagesNumberId";
	
	//Texts (in list Error Codes) retrieved from property files
	String TXT_CODE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.errorcode");
	String TXT_ENABLE_REROUTING_SURVIVABLE_MODE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.reroutingEnabled");
	String TXT_ENABLE_REROUTING_NORMAL_MODE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.enabledStandAlone");
	//String TXT_DESCRIPTION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "");
    //Edit Error Code pop-up
	String IPF_ERROR_CODE = "errorCodesPopUpEdit:entry2";
	String CB_ENABLE_REROUTING_SURVIVABLE_MODE= "errorCodesPopUpEdit:enabled";
	String CB_ENABLE_REROUTING_NORMAL_MODE = "errorCodesPopUpEdit:enabledStandAlone";
	//Call Forward pop-up
	String CB_ACTIVATE_CALL_FW_NO_REPLY = "callForwardPopUp:noReplyActivateEntry";
	String IPF_CALL_FW_NO_REPLY_REDIRECT_NUMBER = "callForwardPopUp:noReplyNumberEntry";
	String IPF_CALL_FW_NO_REPLY_RING_DURATION = "callForwardPopUp:noReplyRingDurationEntry";
	String IPF_CALL_FW_NO_REPLY_SOUCE_IP = "callForwardPopUp:noreplyIpEntry";
	String CB_ACTIVATE_CALL_FW_ON_BUSY = "callForwardPopUp:onBusyActivateEntry";
	String IPF_CALL_FW_ON_BUSY_REDIRECT_NUMBER = "callForwardPopUp:onBusyNumberEntry";
	String IPF_CALL_FW_ON_BUSY_SOUCE_IP = "callForwardPopUp:onBusyIpEntry";
	String CB_ACTIVATE_CALL_FW_DO_NOT_DISTURB = "callForwardPopUp:onDeclineActivateEntry";
	String IPF_CALL_FW_DO_NOT_DISTURB_REDIRECT_NUMBER = "callForwardPopUp:onDeclineNumberEntry";
	String IPF_CALL_FW_DO_NOT_DISTURB_SOUCE_IP = "callForwardPopUp:onDeclineIpEntry";
	String CB_ACTIVATE_CALL_FW_ON_ERROR = "callForwardPopUp:onErrorActivateEntry";
	String IPF_CALL_FW_ON_ERROR_REDIRECT_NUMBER = "callForwardPopUp:onErrorNumberEntry";
	String IPF_CALL_FW_ON_ERROR_SOUCE_IP = "callForwardPopUp:onErrorSourceIpEntry";
	String BTN_CALL_FW_ON_ERROR_ERROR_CODES = "callForwardPopUp:callForwardCodecPopUp";
	//Add Error Code pop-up
	String SLC_ERROR_CODE = "callForwardCodecsPopUp:onErrorCodeListGrid:onErrorCodeListField";
	
	//Show Port Mapping pop-up
	String TBL_LIST_PORT_MAPPING = "serviceStatusPopUp:portMappingGrid";
	//Texts (in list Port Mapping) retrieved from property files
	String TXT_CONTACT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "portMappingPopUp.contact");
	String TXT_INTERNAL_IP= SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "portMappingPopUp.internalIp");
	String TXT_INTERNAL_PORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "portMappingPopUp.internalPort");
	String TXT_EXTERNAL_IP= SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "portMappingPopUp.externalIp");
	String TXT_EXTERNAL_PORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "portMappingPopUp.externalPort");
	String TXT_EXPIRE_TIME_FROM_SERVER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "portMappingPopUp.expTime");
	String TXT_MAP_TIME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "portMappingPopUp.mapTime");
	//Configure backup Link Mode pop-up Client Mode
	String TB_CLIENT_MODE_GENERAL_XPATH = "//*/tbody/tr[@id='graphicalTabBar_1']/td[1]/div";
	String TB_CLIENT_MODE_ROUTING_XPATH = "//*/tbody/tr[@id='graphicalTabBar_1']/td[2]/div";
    String IPF_PRIMARY_DID_NUMBER = "backLinkForm:blc:primaryDid";
    String IPF_SECONDARY_DID_NUMBER  = "backLinkForm:blc:secondaryDid";
    String IPF_CONGESTION_DELAY = "backLinkForm:blc:congestionDelay";
    String SLC_BLC_PPP_AUTHENTICATION = "backLinkForm:blc:pppAuth";
    String IPF_BLC_PPP_USER_NAME = "backLinkForm:blc:username";
    String IPF_BLC_PPP_PASSWORD = "backLinkForm:blc:password";
	String SLC_CLIENT_MODE_PACKETIZATION_INTERVAL = "backLinkForm:blc:packetizationInterval";
	String IPF_CLIENT_MODE_RTP_PORT_MIN = "backLinkForm:blc:rtpPortMin";
	String IPF_CLIENT_MODE_RTP_PORT_MAX = "backLinkForm:blc:rtpPortMax";
	String IPF_MINIMUM_NUMBER_B_CHANNELS = "backLinkForm:blc:minBChannelField";
	String IPF_MAXIMUM_NUMBER_B_CHANNELS = "backLinkForm:blc:maxBChannelField";
	String IPF_INITIAL_NUMBER_B_CHANNELS = "backLinkForm:blc:initBChannelField";
	String IPF_HIGH_WATERMARK = "backLinkForm:blc:highWatermarkField";
	String IPF_LOW_WATERMARK = "backLinkForm:blc:lowWatermarkField";
	String IPF_MINIMUM_BANDWIDTH = "backLinkForm:blc:minBandwidthField";
	String IPF_MAXIMUM_BANDWIDTH = "backLinkForm:blc:maxBandwidthField";
	String IPF_INITIAL_BANDWIDTH = "backLinkForm:blc:initBandwidthField";
	String IPF_HIGH_WATERMARK_DETECTION_WINDOW = "backLinkForm:blc:highWatermarkDetectionField";
	String IPF_LOW_WATERMARK_DETECTION_WINDOW = "backLinkForm:blc:lowWatermarkDetectionField";
    String TBL_LIST_ROUTING = "backLinkForm:routingList:routingIpListGrid";
    String BTN_ADD_ROUTING = "backLinkForm:routingList:routingIpListGrid:addButton";
    String BTN_DELETE_ROUTING = "backLinkForm:routingList:routingIpListGrid:deleteButton";
    //Add Routing pop-up
    String IPF_ROUTING_IP = "addRoutingDataForm:ipAddressEntry";
    String IPF_ROUTING_DESRIPTION = "addRoutingDataForm:descriptionEntry";
	
    //Configure backup Link Mode pop-up Server Mode
    String TB_SERVER_MODE_GENERAL_XPATH = "//*/tbody/tr[@id='graphicalTabBar_1']/td[1]/div";
	String TB_SERVER_MODE_CLIENTS_XPATH = "//*/tbody/tr[@id='graphicalTabBar_1']/td[2]/div";
	String TB_SERVER_MODE_ROUTING_XPATH = "//*/tbody/tr[@id='graphicalTabBar_1']/td[3]/div";
    String IPF_MAX_BACKUP_LINKS = "backLinkForm:bls:maxBackupLinks";
    String IPF_MAX_NUMBER_B_CHANNELS = "backLinkForm:bls:maxBlsBChannel";
    String IPF_PPP_SUBNET_IP_NETMASK_BITS = "backLinkForm:bls:pppSubnet";
    String IPF_OSV_LSM_IP_ADDRESS = "backLinkForm:bls:lsmIpAddr";
    String SLC_SERVER_MODE_PACKETIZATION_INTERVAL = "backLinkForm:bls:blspacketizationInterval";
	String IPF_SERVER_MODE_RTP_PORT_MIN = "backLinkForm:bls:blsRtpPortMin";
	String IPF_SERVER_MODE_RTP_PORT_MAX = "backLinkForm:bls:blsRtpPortMax";
	String TBL_LIST_CLIENTS = "backLinkForm:blsClients:blsClientsGrid";
	String BTN_ADD_CLIENT = "backLinkForm:blsClients:blsClientsGrid:addButton";
	String BTN_EDIT_CLIENT = "backLinkForm:blsClients:blsClientsGrid:editButton";
	String BTN_DELETE_CLIENT = "backLinkForm:blsClients:blsClientsGrid:deleteButton";
	//Texts (in list Clients) retrieved from property files
	String TXT_BLS_CLIENT_TUNNEL_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.tunnelName");
	String TXT_BLC_HOST_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.blcHostname");
	String TXT_BLS_CLIENT_PRIORITY= SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.priority");
	String TXT_RETRY_AFTER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.retryAfter");
    //Add Client pop-up
	String IPF_BLS_CLIENT_TUNNEL_NAME= "editBlsClientDataForm:tunnelName";
	String IPF_BLC_HOST_NAME = "editBlsClientDataForm:blcHostname";
	String IPF_BLS_CLIENT_PRIORITY = "editBlsClientDataForm:priority";
	String SLC_BLS_CLIENT_PPP_AUTHENTICATION = "editBlsClientDataForm:pppAuth";
    String IPF_BLS_CLIENT_PPP_USER_NAME = "editBlsClientDataForm:username";
	String IPF_BLS_CLIENT_PPP_PASSWORD = "editBlsClientDataForm:password";
	String IPF_RETRY_AFTER = "editBlsClientDataForm:retryAfter";
	//Add Routing
	String SLC_TUNNEL_NAME = "addRoutingDataForm:tunnelNameEntry";
	String TXT_TUNNEL_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.tunnelName");

	//Configure Gateways pop-up
	String BTN_ADD_GATEWAY = "voipGateways:gatewaysGrid:addButton";
	String BTN_EDIT_GATEWAY = "voipGateways:gatewaysGrid:editButton";
	String BTN_DELETE_GATEWAY = "voipGateways:gatewaysGrid:deleteButton";
	String TBL_LIST_GATEWAYS = "voipGateways:gatewaysGrid";
	//Texts (in list Gateways) retrieved from property files
	String TXT_SIGNALING_ADDRESS_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipGateways.SignalingTypeSet");
	String TXT_GATEWAY_IP_ADDRESS_FQDN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.ipaddress")+"/FQDN";
	String TXT_GATEWAY_PORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Port");
	String TXT_GATEWAY_INTERFACE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.interface");
	String TXT_GATEWAY_TRANSPORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.transport");
	String TXT_GATEWAY_ROUTING_PREFIX_FQDN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipGateways.routingPrefix")+"/FQDN";
	String TXT_GATEWAY_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.type");
	String TXT_FUNCTIONAL_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipGateways.functionalType");
	String TXT_TRUNK_PROFILE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipGateways.trunkProfile");
	String TXT_OUTPUT_DIGIT_STRIP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipGateways.outputDigitStrip");
	String TXT_OUTPUT_DIGIT_ADD = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipGateways.outputDigitAdd");
	String TXT_PRIORITY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.priority");
	//Add Gateways pop-up
	String SLC_SIGNALING_ADDRESS_TYPE = "editGatewaysForm:signalingTypeSetvalue";
	String IPF_GATEWAY_IP_ADDRESS_FQDN = "editGatewaysForm:ipvalue";
	String IPF_GATEWAY_PORT = "editGatewaysForm:portvalue";
	String SLC_GATEWAY_INTERFACE = "editGatewaysForm:interfacevalue";
	String SLC_GATEWAY_TRANSPORT = "editGatewaysForm:transportvalue";
	String IPF_GATEWAY_ROUTING_PREFIX_FQDN = "editGatewaysForm:routingprefixvalue";
	String SLC_GATEWAY_TYPE = "editGatewaysForm:gwtypevalue";
	String SLC_FUNCTIONAL_TYPE = "editGatewaysForm:typevalue";
	String SLC_TRUNK_PROFILE = "editGatewaysForm:truckProfilevalue";
	String IPF_OUTPUT_DIGIT_STRIP = "editGatewaysForm:outputdigitstripvalue";
	String IPF_OUTPUT_DIGIT_ADD = "editGatewaysForm:outputdigitaddvalue";
	String SLC_PRIORITY = "editGatewaysForm:priorityvalue";
	//Options (in Drop-Down lists Signaling Address Type,Interface,Transport,Type,Functional Type and Trunk Profile) retrieved from property files
	String TXT_IP_ADDRESS_OR_FQDN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "IP_ADDRESS_OR_FQDN");
	String TXT_DNS_SRV = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "DNS_SRV");
	String TXT_LAN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "LAN");
	String TXT_WAN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "WAN");
	String TXT_3K_4K = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "3K4K");
	String TXT_RG = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "RG");
	String TXT_MEDIATRIX = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "MEDIATRIX");
	String TXT_PEER_OSB = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "PEER_OSB");
	String TXT_SIP_TRUNK = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SIP_TRUNK");
	String TXT_INTEGRATED_GATEWAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Integrated_Gateway");
	String TXT_BACKUP_LINK_SERVER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Backup_Link_Server");
	String TXT_OTHERS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "OTHERS");
	String TXT_ALL_MODES_EGRESS_INGRESS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "ALL_EGRESS_INGRESS");
	String TXT_ALL_MODES_INGRESS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "ALL_INGRESS");
	String TXT_NORMAL_MODE_EGRESS_INGRESS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "NORMAL_EGRESS_INGRESS");
	String TXT_SURVIVABILITY_MODE_EGRESS_INGRESS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SURVIVABILITY_EGRESS_INGRESS");
	String TXT_EMERGENCY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "EMERGENCY");
	//SIP Service Provider Profiles pop-up
	String BTN_ADD_SIP_SERVICE_PROVIDER_PROFILE = "sipServiceProviderProfileList:sipServiceProviderProfileGrid:addButton";
	String BTN_EDIT_SIP_SERVICE_PROVIDER_PROFILE = "sipServiceProviderProfileList:sipServiceProviderProfileGrid:editButton";
	String BTN_DELETE_SIP_SERVICE_PROVIDER_PROFILE = "sipServiceProviderProfileList:sipServiceProviderProfileGrid:deleteButton";
	String TBL_LIST_SIP_SERVICE_PROVIDER_PROFILES = "sipServiceProviderProfileList:sipServiceProviderProfileGrid";
	//Texts (in list SIP Service Provider Profiles) retrieved from property files
	String TXT_DEFAULT_HOME_DN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "sipServiceProviderProfileEdit.defaultHomeDn");
	String TXT_REGISTRATION_REQUIRED = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "sipServiceProviderProfileEdit.regrequired");
	String TXT_REGISTRATION_INTERVAL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "sipServiceProviderProfileEdit.regInterval");
	//Add Service Provider Profiles pop-up
	String TB_SIP_SERVICE_PROVIDER_PROFILE_BASIC = "sipServiceProviderProfileEdit:basicGroups_tab0";
	String TB_SIP_SERVICE_PROVIDER_PROFILE_OPTIONS = "sipServiceProviderProfileEdit:sipProviderProfileOptions_tab1";
	String TB_SIP_SERVICE_PROVIDER_PROFILE_FLAGS = "sipServiceProviderProfileEdit:sipProviderProfileflags_tab2";
	String TB_SIP_SERVICE_PROVIDER_PROFILE_SIP_MANIPULATION = "sipServiceProviderProfileEdit:sipService_tab3";
	String IPF_SIP_SERVICE_PROVIDER_PROFILE_NAME = "sipServiceProviderProfileEdit:profileNameEntry";
	String SLC_DEFAULT_SSP_PROFILE = "sipServiceProviderProfileEdit:defaultProfileEntry";
	String SLC_PRIVACY_SUPPORT = "sipServiceProviderProfileEdit:privacySupportEntry";
	String CB_MANDATORY_DEFAULT_HOME_DN = "sipServiceProviderProfileEdit:checkboxEntry8";
	String IPF_DEFAULT_HOME_DN = "sipServiceProviderProfileEdit:defaultHomeDNEntry";
	String CB_USE_SIP_SERVICE_ADDRESS = "sipServiceProviderProfileEdit:useSipServiceAddressEntry";
	String IPF_SIP_SERVICE_ADDRESS = "sipServiceProviderProfileEdit:sipServiceAddressEntry";
	String CB_REGISTRATION_REQUIRED = "sipServiceProviderProfileEdit:checkboxEntry9";
	String IPF_INTERVAL = "sipServiceProviderProfileEdit:registrationIntervalEntry";
	String CB_BUSINESS_IDENTITY_REQUIRED = "sipServiceProviderProfileEdit:businessIdentityEntry";
	String IPF_BUSINESS_IDENTITY_DN = "sipServiceProviderProfileEdit:businessIdentityDnEntry";
	String CB_DIGEST_AUTHENTICATION_SUPPORTED = "sipServiceProviderProfileEdit:checkboxEntry10";
	String IPF_REALM = "sipServiceProviderProfileEdit:digestAuthenticationRealmEntry";
	String IPF_USER_ID = "sipServiceProviderProfileEdit:digestAuthenticationUserIDEntry";
	String IPF_USER_PASSWORD = "sipServiceProviderProfileEdit:digestAuthenticationPasswordEntry";
	//Options (in Drop-Down list Privacy Support:) retrieved from property files
	String TXT_BASIC = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "basic");
	String TXT_FULL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "full");
	String TXT_FULL_SEND = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "fullSend");
	String TXT_FULL_RECEIVE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "fullReceive");
	
	String CB_ALLOW_SENDING_OF_INSECURE_REFFERED_BY_HEADER = "sipServiceProviderProfileEdit:optionsTab:checkboxEntry1";
	String CB_SEND_P_PREFFERED_IDENTITY = "sipServiceProviderProfileEdit:optionsTab:checkboxEntry2";
	String CB_DO_NOT_SEND_DIVERSION_HEADER = "sipServiceProviderProfileEdit:optionsTab:checkboxEntry3";
	String CB_SEND_URI_IN_TELEPHONE_SUBSCRIBER_FORMAT = "sipServiceProviderProfileEdit:optionsTab:checkboxEntry4";
	String CB_SEND_AUTH_NUMBER_IN_DIVERSION_HEADER = "sipServiceProviderProfileEdit:optionsTab:checkboxEntry5";
	String CB_SEND_AUTH_NUMBER_IN_P_ASSERTED_IDENTITY_HEADER = "sipServiceProviderProfileEdit:optionsTab:checkbox6Entry";
	String CB_SEND_AUTH_NUMBER_IN_FROM_HEADER = "sipServiceProviderProfileEdit:optionsTab:checkboxEntry7";
	String CB_INCLUDE_RESTRICTED_NUMBER_IN_FROM_HEADER = "sipServiceProviderProfileEdit:optionsTab:checkboxEntry8";
    String SLC_CERTIFICATE_FILES = "sipServiceProviderProfileEdit:optionsTab:certificate1";
	String SLC_CA_CERTIFICATES = "sipServiceProviderProfileEdit:optionsTab:certificate2";
	String SLC_KEY_FILES = "sipServiceProviderProfileEdit:optionsTab:certificate3";
	String CB_FQDN_IN_REQUEST_TO_URI = "sipServiceProviderProfileEdit:flagsTab:fqdnRequestUriEntry";
	String CB_FQDN_TO_HEADER_SSP = "sipServiceProviderProfileEdit:flagsTab:fqdnToHeaderSSPEntry";
	String CB_REFER_SUPPORTED_SSP = "sipServiceProviderProfileEdit:flagsTab:referSupportedSSPEntry";
	String CB_SPARE_FLAG1 = "sipServiceProviderProfileEdit:flagsTab:flag1Entry";
	String CB_SPARE_FLAG2 = "sipServiceProviderProfileEdit:flagsTab:flag2Entry";
	String CB_SPARE_FLAG3 = "sipServiceProviderProfileEdit:flagsTab:flag3Entry";	
	String CB_SPARE_FLAG4 = "sipServiceProviderProfileEdit:flagsTab:flag14Entry";
	String CB_SPARE_FLAG5 = "sipServiceProviderProfileEdit:flagsTab:flag15Entry";
	String CB_SPARE_FLAG6 = "sipServiceProviderProfileEdit:flagsTab:flag16Entry";
	String CB_SPARE_FLAG7 = "sipServiceProviderProfileEdit:flagsTab:flag7Entry";
	String CB_SPARE_FLAG8 = "sipServiceProviderProfileEdit:flagsTab:flag8Entry";	
	String CB_SPARE_FLAG9 = "sipServiceProviderProfileEdit:flagsTab:flag9Entry";
	String CB_SPARE_FLAG10 = "sipServiceProviderProfileEdit:flagsTab:flag10Entry";
	//SIP Manipulation pop-up
	String CB_INSERT_ANONYMOUS_CALLER_ID = "sipServiceProviderProfileEdit:SipServiceTab:insertAnonymousCallerIdEntry";
	String BTN_MOVE_UP_SSPP_SIP_MANIPULATION = "sipServiceProviderProfileEdit:SipServiceTab:sipManipulationListGrid:nav_configure_4";
	String BTN_MOVE_DOWN_SSPP_SIP_MANIPULATION = "sipServiceProviderProfileEdit:SipServiceTab:sipManipulationListGrid:nav_configure_5";
	String BTN_MOVE_ADD_SSPP_SIP_MANIPULATION = "sipServiceProviderProfileEdit:SipServiceTab:sipManipulationListGrid:addButton";
	String BTN_MOVE_EDIT_SSPP_SIP_MANIPULATION = "sipServiceProviderProfileEdit:SipServiceTab:sipManipulationListGrid:editButton";
	String BTN_MOVE_DELETE_SSPP_SIP_MANIPULATION = "sipServiceProviderProfileEdit:SipServiceTab:sipManipulationListGrid:deleteButton";
	String TBL_LIST_SIP_SSPP_MANIPULATION = "sipServiceProviderProfileEdit:SipServiceTab:sipManipulationListGrid";
    //Add SIP manipulation pop-up
	String IPF_SSPP_MATCH_DIGITS = "editManipulationForm:matchDigitsvalue";
	String IPF_SSPP_MATCH_POSITION = "editManipulationForm:startMatchFromvalue";
	String SLC_SSPP_HEADER = "editManipulationForm:headerConfigurevalue";
	String IPF_SSPP_DELETE_INSERT_POSITION = "editManipulationForm:deleteFromValue";
	String IPF_SSPP_NUMBER_OF_DIGITS_TO_DELETE = "editManipulationForm:deleteDigitsvalue";
	String IPF_SSPP_INSERT_DIGITS = "editManipulationForm:appendDigitsvalue";
	String IPF_SSPP_ADD_PREFIX = "editManipulationForm:addPrefixvalue";
	String IPF_SSPP_REPLACE_ALL_WITH = "editManipulationForm:replaceDigitsvalue";
	String SLC_SSPP_CALL_TYPE = "editManipulationForm:callTypeConfigureCombo";
	//Configure QOS pop-up
	String BTN_ADD_QOS = "voipQos:qosGrid:addButton";
	String BTN_EDIT_QOS = "voipQos:qosGrid:editButton";
	String BTN_DELETE_QOS = "voipQos:qosGrid:deleteButton";
	String TBL_LIST_QOS = "voipQos:qosGrid";
	String IPF_DSCP_FOR_SIP = "voipQos:e1"; 
	String IPF_DSCP_FOR_RTP = "voipQos:e2"; 
	//Texts (in list QOS) retrieved from property files
	String TXT_QOS_IN_INTERFACE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipQos.inInterface");
	String TXT_QOS_OUT_INTERFACE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipQos.outInterface");
	String TXT_QOS_DSCP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipQos.dscp");
	String TXT_QOS_MARK = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "voipQos.mark");
	String TXT_QOS_PORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.port");
	//Add COS pop-up
	String SLC_QOS_PROTOCOL = "editQosForm:protocolvalue";
	String SLC_QOS_IN_INTERFACE = "editQosForm:inInterfacevalue";
	String SLC_QOS_OUT_INTERFACE = "editQosForm:outInterfacevalue";
	String IPF_QOS_DSCP = "editQosForm:dscpvalue";
	String IPF_QOS_PORT = "editQosForm:portvalue";
	String IPF_QOS_MARK = "editQosForm:markvalue";
	//Options (in Drop-Down lists Protocol, In Interface and Out Interface) retrieved from property files
	String TXT_QOS_ALL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "ALL");
	String TXT_ICMP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "ICMP");
	String TXT_INTERFACE1 = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "INTERFACE1");
	String TXT_INTERFACE2 = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "INTERFACE2");

	

	//TAB COMM SYSTEM
	String TB_COMM_SYSTEM = "editVoipForm:sipConfiguration_tab1";
	String SLC_COMM_SYSTEM_TYPE = "editVoipForm:sipConfiguration:hipathCombobox";
	String BTN_CONFIGURE_TRUSTED_ADDRESS = "editVoipForm:sipConfiguration:geoSeperatedButton";
	String CB_ENABLE_OUTBOUND_PROXY = "editVoipForm:sipConfiguration:outboundProxyEnabledEntry";
	String IPF_OUTBOUND_PROXY = "editVoipForm:sipConfiguration:outboundProxyEntry";
	String IPF_OUTBOUND_PROXY_PORT = "editVoipForm:sipConfiguration:outboundProxyPortEntry";
	String CB_ENABLE_PATH_TAGGING = "editVoipForm:sipConfiguration:pathTaggingEnabledEntry";
	String CB_BRANCH_BEHIND_SBC = "editVoipForm:sipConfiguration:branchBehindSBCEntry";
	String SLC_NODE1_TARGET_TYPE = "editVoipForm:sipConfiguration:target1Combobox";
	String IPF_NODE1_PRIMARY_SERVER = "editVoipForm:sipConfiguration:priServerIp1value";
	String SLC_NODE1_PRIMARY_SERVER_TRANSPORT = "editVoipForm:sipConfiguration:priTransport1Combobox";
	String IPF_NODE1_PRIMARY_SERVER_PORT = "editVoipForm:sipConfiguration:priPort1value";
	String IPF_NODE1_SECONDARY_SERVER = "editVoipForm:sipConfiguration:secServerIp1value";
	String SLC_NODE1_SECONDARY_SERVER_TRANSPORT = "editVoipForm:sipConfiguration:secTransport1Combobox";
	String IPF_NODE1_SECONDARY_SERVER_PORT = "editVoipForm:sipConfiguration:secPort1value";
	String IPF_NODE1_SRV_RECORD = "editVoipForm:sipConfiguration:srvRecordIp1value";
	String SLC_NODE1_SRV_RECORD_TRANSPORT = "editVoipForm:sipConfiguration:transportRecord1Combobox";
	String SLC_NODE2_TARGET_TYPE = "editVoipForm:sipConfiguration:target2Combobox";
	String IPF_NODE2_PRIMARY_SERVER = "editVoipForm:sipConfiguration:priServerIp2value";
	String SLC_NODE2_PRIMARY_SERVER_TRANSPORT = "editVoipForm:sipConfiguration:priTransport2Combobox";
	String IPF_NODE2_PRIMARY_SERVER_PORT = "editVoipForm:sipConfiguration:priPort2value";
	String IPF_NODE2_SECONDARY_SERVER = "editVoipForm:sipConfiguration:secServerIp2value";
	String SLC_NODE2_SECONDARY_SERVER_TRANSPORT = "editVoipForm:sipConfiguration:secTransport2Combobox";
	String IPF_NODE2_SECONDARY_SERVER_PORT = "editVoipForm:sipConfiguration:secPort2value";
	String IPF_NODE2_SRV_RECORD = "editVoipForm:sipConfiguration:srvRecordIp2value";
	String SLC_NODE2_SRV_RECORD_TRANSPORT = "editVoipForm:sipConfiguration:transportRecord2Combobox";
	//Options (in Drop-Down list Comm System Type and Target type) retrieved from property files
	String TXT_SIMPLEX = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.simplex");
	String TXT_COLLOCATED = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.collocated");
	String TXT_GEO_SEPERATED = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.geoseparated");
	String TXT_SRV_RECORD = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.srvRecord");
	String TXT_BINDING = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.binding");
	//Tab Configure Trusted Addresses
	String BTN_ADD_TRUSTED_ADDRESS = "geoSeperatedPage:geoSeperatedGrid:addButton";
	String BTN_EDIT_TRUSTED_ADDRESS = "geoSeperatedPage:geoSeperatedGrid:editButton";
	String BTN_DELETE_TRUSTED_ADDRESS = "geoSeperatedPage:geoSeperatedGrid:deleteButton";
	String TBL_LIST_TRUSTED_ADDRESS = "geoSeperatedPage:geoSeperatedGrid";
	//Texts (in list Trusted Addresses) retrieved from property files
	String TXT_TRUSTED_ADDRESS_PORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "Port");
	String TXT_TRUSTED_ADDRESS_TRANSPORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVoip.transport");
	
	String IPF_TRUSTED_IP = "geoSeperatedPage:ipvalue";
	String IPF_TRUSTED_PORT = "geoSeperatedPage:portvalue";
	String SLC_TRUSTED_TRANSPORT = "geoSeperatedPage:transportvalue";
	
	//TAB TIMER AND THRESHOLDS
	String TB_PROFILES_TIMER_AND_THRESHOLDS = "editVoipForm:timerThresholds_tab1";
	String TB_TIMER_AND_THRESHOLDS = "editVoipForm:timerThresholds_tab2";
	String IPF_FAILURE_THRESHOLD = "editVoipForm:timersThresholdsTab:failuervalue2";
	String IPF_SUCCESS_THRESHOLD = "editVoipForm:timersThresholdsTab:successThersholdsvalue1";
	String IPF_TRASITION_MODE_THRESHOLD = "editVoipForm:timersThresholdsTab:transitionThresholdvalue1";
	String IPF_OPTIONS_INTERVAL = "editVoipForm:timersThresholdsTab:intervalsvalue2";
	String IPF_OPTIONS_REQUEST_TIMEOUT = "editVoipForm:timersThresholdsTab:timeoutvalue2";
	String IPF_SUCCESS_NOTIFICATION_RATE = "editVoipForm:timersThresholdsTab:notificationRatevalue1";
	
	//TAB CODECS
	String TB_CODECS = "editVoipForm:b2bua_tab3";
	String SLC_SELECT_CODEC = "editVoipForm:b2buaTab:codecCombobox";
	String BTN_ADD_CODEC = "editVoipForm:b2buaTab:addButton";
	String BTN_DELETE_CODEC = "editVoipForm:b2buaTab:grid:deleteButton";
	String BTN_MOVE_UP_CODEC = "editVoipForm:b2buaTab:grid:nav_configure_4";
	String BTN_MOVE_DOWN_CODEC = "editVoipForm:b2buaTab:grid:nav_configure_5";
	String TBL_LIST_CODECS = "editVoipForm:b2buaTab:grid";
	//TAB RTP
	String TB_RTP = "editVoipForm:rtpData_tab4"; 
	
}
