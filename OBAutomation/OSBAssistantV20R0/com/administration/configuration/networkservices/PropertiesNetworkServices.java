package com.administration.configuration.networkservices;

import com.Seleniumhelper.SeleniumWebdriver;


public interface PropertiesNetworkServices {
	
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
	
	//TAB Interfaces
	String TB_INTERFACES = "editNetworkServices:interfaces_tab0";
	String BTN_EDIT_INTERFACE = "editNetworkServices:interfacesGrid:edit";
	
	//TAB Routing
	String TB_ROUTING = "editNetworkServices:routing_tab1";
	String IPF_DEFAULT_GATEWAY_ADDRESS = "editNetworkServices:rountingTab:gatewayIpAddressField";
	String BTN_ADD_ROUTE = "editNetworkServices:rountingTab:routingGrid:addButton";
	String BTN_EDIT_ROUTE = "editNetworkServices:rountingTab:routingGrid:editButton";
	String BTN_DELETE_ROUTE = "editNetworkServices:rountingTab:routingGrid:deleteButton";
	String IPF_ROUTE_DESTINATION = "editNetworkServiceRoutingForm:destinationField";
	String IPF_ROUTE_NETMASK = "editNetworkServiceRoutingForm:netmaskField";
	String IPF_ROUTE_GATEWAY = "editNetworkServiceRoutingForm:gatewayField";
	String SLC_ROUTE_INTERFACE = "editNetworkServiceRoutingForm:dropDownInterface";
	String TBL_LIST_ROUTES = "editNetworkServices:rountingTab:routingGrid";
	//Text Fields in table List Routes (retrieved from property file)
	String TXT_ROUTE_INTERFACE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.interface");
	String TXT_ROUTE_GATEWAY = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.gateway");
	String TXT_ROUTE_NETMASK = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.netmask");
	String TXT_ROUTE_DESTINATION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editNetworkServices.destination");	
	
	//TAB Redundancy
	String TB_REDUNDANCY = "editNetworkServices:vrrp_tab2";
	String CB_ENABLE_REDUNDANCY = "editNetworkServices:vrrpTab:enableRedudancy";
	
	//TAB Traffic
	String TRAFFIC_ITEMS = "editNetworkServices:trafficShapingTab:trafficShapingGrid:trafficShapingGrid_paging_pagingFirstElementLabel";
	String TB_TRAFFIC = "editNetworkServices:trafficShaping_tab3";
	String CB_ENABLE_TRAFFIC = "editNetworkServices:trafficShapingTab:enableTrafficShaping";
	String TBL_LIST_CLASSES = "editNetworkServices:trafficShapingTab:trafficShapingGrid";
	String BTN_ADD_CLASS = "editNetworkServices:trafficShapingTab:trafficShapingGrid:addButton";
	String BTN_EDIT_CLASS = "editNetworkServices:trafficShapingTab:trafficShapingGrid:editButton";
	String BTN_DELETE_CLASS = "editNetworkServices:trafficShapingTab:trafficShapingGrid:deleteButton";
	String IPF_PARENT_CLASS_ID = "trafficShapingPopUpForm:parentClassIdField";
	String IPF_CLASS_ID_FIELD = "trafficShapingPopUpForm:classIdField";
	String IPF_DEFAULT_CLASS_ID_FIELD = "trafficShapingPopUpForm:defaultClassIdField";
	String IPF_DESCRIPTION = "trafficShapingPopUpForm:descriptionField";
	String IPF_MTU = "trafficShapingPopUpForm:mtuField";
	String IPF_PRIORITY = "trafficShapingPopUpForm:priorityField";
	String IPF_PACKET_FIFO_LIMIT = "trafficShapingPopUpForm:packetFifoLimitField";
	String IPF_RATE = "trafficShapingPopUpForm:rateField";
	String IPF_CEILING_RATE = "trafficShapingPopUpForm:ceillingRateField";
	String IPF_BURST = "trafficShapingPopUpForm:burstField";
	String IPF_CEILING_BURST = "trafficShapingPopUpForm:ceillingBurstField";
	String IPF_SFQ_QUANTUM = "trafficShapingPopUpForm:sfqQuantumField";
	String IPF_SFQ_PERTURBATIC = "trafficShapingPopUpForm:sfqPerturbaticField";
	String IPF_BYTE_FIFO_LIMIT = "trafficShapingPopUpForm:byteFifoLimitField";
	String SLC_LEAF_QUEUING = "trafficShapingPopUpForm:dropDownleafQueueing";
	String SLC_INTERFACE = "trafficShapingPopUpForm:dropDownInterface";
	String BTN_TRAFFIC_EDIT = "editNetworkServices:trafficShapingTab:trafficShapingGrid:editButton";
	String TB_TRAFFIC_RULE_FILTERS = "trafficShapingPopUpForm:tabRuleFilter_tab1";
	String IPF_ADD_RULE = "trafficShapingPopUpForm:addRuleField";
	String TB_TRAFFIC_MARK_FILTERS = "trafficShapingPopUpForm:tabMarkFilter_tab2";
	String IPF_ADD_MARK_FIELD = "trafficShapingPopUpForm:addMarkField";
	//Texts (in Drop-Down List Leaf Queuing) retrieved from property files
	String TXT_LEAF_QUEUING_SFQ = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SFQ");
	String TXT_LEAF_QUEUING_PACKET_FIFO = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "PACKET_FIFO");
	String TXT_LEAF_QUEUING_BYTE_FIFO = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "BYTE_FIFO");
	String TXT_LEAF_QUEUING_NONE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "none");
	
	//TAB NTP
	String TB_PROFILES_NTP = "editNetworkServices:ntp_tab0";
	String TB_NTP = "editNetworkServices:ntp_tab4";
	String IPF_NTP_SERVER = "editNetworkServices:ntpTab:NTPServerField";
	String BTN_NTP_SYNCH_MANUALLY = "editNetworkServices:ntpTab:ntpSynchbutton";
	String SLC_TIME_ZONE = "editNetworkServices:ntpTab:languageCombobox";
	String CB_ENABLE_LOCAL_NTP_SERVER = "editNetworkServices:ntpTab:enableLocalNtpServerCheckBox";
	String RB_NTP_AUTO = "//table[@id='editNetworkServices:ntpTab:enableNTPRadio']/tbody/tr/td/label/input";
	String RB_NTP_MANUALLY = "//table[@id='editNetworkServices:ntpTab:manualRadio']/tbody/tr/td/label/input";
	String BTN_NTP_APPLY = "editNetworkServices:ntpTab:setTimeDatebutton";
	
	//Texts (in Drop-Down List Time Zone) retrieved from property files
	String TXT_GMT_MINUS_1200 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-1200");
	String TXT_GMT_MINUS_1100 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-1100");
	String TXT_GMT_MINUS_1000 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-1000");
	String TXT_GMT_MINUS_900 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-900");
	String TXT_GMT_MINUS_800= SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-800");
	String TXT_GMT_MINUS_700 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-700");
	String TXT_GMT_MINUS_600 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-600");
	String TXT_GMT_MINUS_500 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-500");
	String TXT_GMT_MINUS_400 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-400");
	String TXT_GMT_MINUS_330 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-330");
	String TXT_GMT_MINUS_300 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-300");
	String TXT_GMT_MINUS_200 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-200");
	String TXT_GMT_MINUS_100 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT-100");
	String TXT_GMT = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT");
	String TXT_GMT_PLUS_100 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+100");
	String TXT_GMT_PLUS_200 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+200");
	String TXT_GMT_PLUS_300 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+300");
	String TXT_GMT_PLUS_330 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+330");
	String TXT_GMT_PLUS_400 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+400");
	String TXT_GMT_PLUS_430 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+430");
	String TXT_GMT_PLUS_500 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+500");
	String TXT_GMT_PLUS_530 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+530");
	String TXT_GMT_PLUS_600 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+600");
	String TXT_GMT_PLUS_700 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+700");
	String TXT_GMT_PLUS_800 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+800");
	String TXT_GMT_PLUS_900 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+900");
	String TXT_GMT_PLUS_930 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+930");
	String TXT_GMT_PLUS_1000 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+1000");
	String TXT_GMT_PLUS_1100 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+1100");
	String TXT_GMT_PLUS_1200 = SeleniumWebdriver.readproperties("OpenBranch\\TimeZones", "GMT+1200");
	
	//TAB DNS
	String TB_PROFILES_DNS = "editNetworkServices:dns_tab1";
	String TB_DNS = "editNetworkServices:dns_tab5";
	String BTN_CONFIGURE_DNS = "editNetworkServices:dnsTab:dnsClientButton";
	String BTN_CONFIGURE_ALIAS = "editNetworkServices:dnsTab:dnsClientAliasButton";
	String BTN_DNS_SYNCH_MANUALLY = "editNetworkServices:dnsTab:dnsSynchbutton";
	String IPF_DOMAIN_NAME = "editNetworkServices:dnsTab:domainNameField";
	String IPF_ADD_DNS_FIELD = "dnsDnsServerListPopUp:addDnsField";
	String IPF_ADD_ZONE_FIELD = "systemAliasListPopUp:addZoneField";
	String CB_ENABLE_DNS = "editNetworkServices:dnsTab:enableDns";
	String BTN_DNS_FORWARD = "editNetworkServices:dnsTab:dnsForwardButton";
	String IPF_ADD_Dns_ForwardList = "systemDnsForwardListPopUp:addZoneField";
	String BTN_DNS_ADD = "editNetworkServices:dnsTab:dnsGrid:addButton";
	String BTN_DNS_EDIT = "editNetworkServices:dnsTab:dnsGrid:editButton";
	String BTN_DNS_DELETE = "editNetworkServices:dnsTab:dnsGrid:deleteButton";
	String SLC_TYPE = "systemDnsPopUp:typeCombobox";
	String IPF_ZONE_NAME = "systemDnsPopUp:nameField";
	String IPF_ZONE_IP= "systemDnsPopUp:ipAddressField";
	String IPF_ZONE_FILE = "systemDnsPopUp:fileNameField";
	String TBL_LIST_ZONES = "editNetworkServices:dnsTab:dnsGrid";
	//Texts (in Drop-Down List Zone Type) retrieved from property files
	String TXT_ZONE_TYPE_SLAVE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "SLAVE");
	String TXT_ZONE_TYPE_FORWARD = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "FORWARD");


	//TAB DHCP
	String TB_DHCP = "editNetworkServices:dhcp_tab6";
	String CB_DHCP_ENABLE_DHCP = "editNetworkServices:dhcpTab:enabled";
	String CB_DHCP_ENABLE_NTP= "editNetworkServices:dhcpTab:enabledNTP";
	String BTN_DHCP_CONFIGURE_STATIC_IP = "editNetworkServices:dhcpTab:staticIpConfiguration";
	String BTN_DHCP_CONFIGURE_DNS_SERVER_LIST = "editNetworkServices:dhcpTab:dhcpDnsButton";
	String SLC_DHCP_INTERFACE = "editNetworkServices:dhcpTab:dropDownTypesNetworkInterface";
	String SLC_DHCP_UPDATE_MODE = "editNetworkServices:dhcpTab:dropDownTypesUpdateMode";
	String IPF_DHCP_SUBNET = "editNetworkServices:dhcpTab:subnetValue";
	String IPF_DHCP_NETMASK = "editNetworkServices:dhcpTab:netmaskValue";
	String IPF_DHCP_START_RANGE = "editNetworkServices:dhcpTab:startValue";
	String IPF_DHCP_END_RANGE = "editNetworkServices:dhcpTab:endValue";
	String IPF_DHCP_EXCUSION_FROM = "editNetworkServices:dhcpTab:exclusionFromField";
	String IPF_DHCP_EXCUSION_TO = "editNetworkServices:dhcpTab:exclusionToField";
	String IPF_DHCP_LEASE_TIME_DEFAULT = "editNetworkServices:dhcpTab:defaultValue";
	String IPF_DHCP_LEASE_TIME_MAX = "editNetworkServices:dhcpTab:maxValue";
	String IPF_DHCP_BROADCAST_ADDRESS = "editNetworkServices:dhcpTab:broadcastAddressField";
	String IPF_DHCP_ROUTER = "editNetworkServices:dhcpTab:routerField";
	String IPF_DHCP_DOMAIN = "editNetworkServices:dhcpTab:domainNameField";
	String IPF_DHCP_WIN_SERVER = "editNetworkServices:dhcpTab:winsServerField";
	String IPF_DHCP_PRINT_SERVER = "editNetworkServices:dhcpTab:printServerField";
	String IPF_DHCP_DLS_SERVER = "editNetworkServices:dhcpTab:serverField";
	String IPF_DHCP_DLS_PORT = "editNetworkServices:dhcpTab:portField";
	String ITEMS_STATIC_LIST = "editUtilitiesDchpStaticIpForm:staticIpGrid:staticIpGrid_paging_pagingFirstElementLabel";
	String IPF_STATIC_IP_LIST_HOSTNAME = "dhcpStaticIpPopUpForm:hostNameField";
	String IPF_STATIC_IP_LIST_MAC = "dhcpStaticIpPopUpForm:macAddressField";
	String IPF_STATIC_IP_LIST_IP = "dhcpStaticIpPopUpForm:ipAddressField";
	String IPF_DNS_ADD = "dnsDnsServerListPopUp:addDnsField";	
	String ITEMS_DNS_LIST = "dnsDnsServerListPopUp:dnsGrid:dnsGrid_paging_pagingFirstElementLabel";
	
	//Texts (in Drop-Down List Update Zone) retrieved from property files
	String TXT_ADD_HOC = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSystemDhcpTab.itemAddHoc");
	String TXT_INTERIM = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSystemDhcpTab.itemInterim");
	String TXT_NONE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSystemDhcpTab.itemNone");
	


}
