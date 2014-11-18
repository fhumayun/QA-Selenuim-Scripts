package com.administration.configuration.security;

import com.Seleniumhelper.SeleniumWebdriver;


public interface PropertiesSecurity {
	
	/*
	 * BTN_ := Button ID
	 * IPF_ := Input Field ID 
	 * TB_:= Tab ID
	 * CB_:= Checkbox ID
	 * SLC_:= Selector ID
	 * TEXT_:= Generic Error messages
	 * TEXTBOX: = Box Contain Value
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
	String TB_GENERAL = "editSecurity:tabGeneral_tab0";
	String SLC_X509_CERTIFICATE = "editSecurity:caFiled1";
	String SLC_CA_CERTIFICATES = "editSecurity:caFiled2";
	String SLC_KEY_FILE = "editSecurity:caFiled3";
	String SLC_SHARE_SECRET_FILES = "editSecurity:caFiled4";
	String BTN_GENERAL_TLS_CERTS_CONFIGURE_BUTTON="editSecurity:select3";
	String BTN_GENERAL_ADD_TLS_CERTS_BUTTON="securityCertificatePopUp:certificateGrid:addButton";
	String IPF_GENERAL_ADD_TLS_CERTS_NAME="securityAddCertificatePopUp:name";
	String BTN_GENERAL_SHARED_SECRET_FILES_CONFIGURE_BUTTON="editSecurity:select4";
	String BTN_GENERAL_ADD_SHARED_SECRET_FILES_BUTTON="securityCertificatePopUp:certificateGrid:addButton";
	String IPF_GENERAL_ADD_SHARED_SECRET_FILES_NAME="securityAddCertificatePopUp:name";
	String BTN_GENERAL_DELETE_TLS_CERTIFICATES="securityCertificatePopUp:certificateGrid:deleteButton";
	String BTN_GENERAL_DELETE_SHARED_SECRET_FILES="securityCertificatePopUp:certificateGrid:deleteButton";
	String BTN_GENERAL_UPLOAD_BROWSE_BUTTON="securityAddCertificatePopUp:AddfileCertificate";
	String SLC_GENERAL_UPLOAD_CERTIFICATES="tlsField";
	String TBL_LIST_CERTIFICATES = "securityCertificatePopUp:certificateGrid";
	String RB_UPLOAD_CERTIFICATE = "securityAddCertificatePopUp:enableUpdateRadio";
	//Texts (in list TLS and Secret Key File Certificates) retrieved from property files
	String TXT_LIST_CERTIFICATE_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.Certificate");
	String TXT_LIST_CERTIFICATE_TYPE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.type");
	//Texts (in drop-down list Upload TLS Certificates) retrieved from property files
	String TXT_CA_CERTIFICATE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.caCertificate");
	String TXT_KEY_FILE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.keyFile");
	String TXT_X509_CERTIFICATE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.x509Certificate");
	String TXT_SHARED_SECRET_FILE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.sharedSecretFile");
	
	//TAB SNORT
	String TB_PROFILES_SNORT = "editSecurity:tabSnort_tab0";
	String TB_SNORT = "editSecurity:tabSnort_tab1";
	String CB_ENABLE_SNORT = "editSecurity:snortTab:enableSnort";
	String IPF_MESG_RATE_THRESHOLD = "editSecurity:snortTab:msgThreshHoldField";
	String IPF_BLOCK_PERIOD = "editSecurity:snortTab:blockPeriodField";
	String IPF_IP_ADDRESS = "editSecurity:snortTab:addZoneField";
	String BTN_ADD_IP_ADDRESS = "editSecurity:snortTab:addIpButton";
	String BTN_DELETE_IP_ADDRESS = "editSecurity:snortTab:deleteButtonSnort";
	
	
	
	//TAB Firewall
	String TB_PROFILES_FIREWALL = "editSecurity:tabFirewall_tab1";
	String TB_FIREWALL = "editSecurity:tabFirewall_tab2";
	String CB_ENABLE_MASQUERADING = "editSecurity:masquerading";
	//TAB Firewall - Incoming/Outgoing WAN Network Connections
	String CB_DNS = "editSecurity:dns";
	String CB_SNMP = "editSecurity:snmp";
	String CB_FTP = "editSecurity:ftp";
	String CB_HTTPS = "editSecurity:https";
	String CB_SSH = "editSecurity:ssh";
	String CB_PING = "editSecurity:ping";
	String CB_TELNET = "editSecurity:telnet";
	String CB_NTP = "editSecurity:ntp";
	String CB_ALLOW_ALL_WAN = "editSecurity:outgoingConnections";
	// TAB Firewall - Incoming WAN VoIP Connections
	String CB_SIP = "editSecurity:sip";
	String CB_RTP_sRTP = "editSecurity:rtp";
	String CB_TLS = "editSecurity:tls";
	String CB_MGCP = "editSecurity:mgcp";
	// TAB Firewall - Black Configuration
	String BTN_BLACK_CONFIGURE = "editSecurity:blackListButton";
	String BTN_BLACK_ADD = "editSecurityFirewallBlackList:blackListGrid:addButton";
	String BTN_BLACK_EDIT = "editSecurityFirewallBlackList:blackListGrid:editButton";
	String BTN_BLACK_DELETE = "editSecurityFirewallBlackList:blackListGrid:deleteButton";
	String IPF_BLACK_IP_ADDRESS_SUBNET = "firewallBlackListPopUp:ipvalue";
	String IPF_BLACK_PORT = "firewallBlackListPopUp:portvalue";
	String TBL_LIST_BLACK_IPS_SUBNETS= "editSecurityFirewallBlackList:blackListGrid";
	String TXT_PORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.port");
	String TXT_BLACK_LIST_ADDRESS = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "firewallBlackList.ipaddress");
	
	// TAB Firewall - White Configuration
	String BTN_WHITE_CONFIGURE = "editSecurity:whiteListButton";
	String BTN_WHITE_ADD = "editSecurityFirewallWhiteList:whiteListGrid:addButton";
	String BTN_WHITE_EDIT = "editSecurityFirewallWhiteList:whiteListGrid:editButton";
	String BTN_WHITE_DELETE = "editSecurityFirewallWhiteList:whiteListGrid:deleteButton";
	String IPF_WHITE_IP_ADDRESS_SUBNET = "firewallWhiteListPopUp:ipvalue";
	String IPF_WHITE_PORT = "firewallWhiteListPopUp:portvalue";
	String TBL_LIST_WHITE_IPS_SUBNETS = "editSecurityFirewallWhiteList:whiteListGrid";

	//TAB PortFW
	String TB_PORT_FW = "editSecurity:snmpTab_tab3";
	String CB_ENABLE_PORT_FW = "editSecurity:portFwTab:enablePortForeword";
	String BTN_ADD_PORT_FW = "editSecurity:portFwTab:portGrid:addButton";
	String BTN_EDIT_PORT_FW = "editSecurity:portFwTab:portGrid:editButton";
	String BTN_DELETE_PORT_FW = "editSecurity:portFwTab:portGrid:deleteButton";
	String IPF_PORT_FW_ADD_IP_ADDRESS = "securityPortFwPopUp:ipAddressField"; 
	String IPF_PORT_FW_ADD_IN_PORT = "securityPortFwPopUp:inEntry";
	String IPF_PORT_FW_ADD_OUT_PORT = "securityPortFwPopUp:outFiled";
	String SLC_PORT_FW_PROTOCOL = "securityPortFwPopUp:protocolFiled";
	String TBL_LIST_PORT_FW = "editSecurity:portFwTab:portGrid";
	//Texts (in list Port FW) retrieved from property files
	String TXT_LIST_PORT_FW_IN = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.in");
	String TXT_LIST_PORT_FW_OUT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.out");
	String TXT_LIST_PORT_FW_PROTOCOL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.protocol");
	//Texts (in drop down list Protocol) retrieved from property files
	String TXT_PORT_FW_TCP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "TCP");
	String TXT_PORT_FW_UDP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "UDP");
	String TXT_PORT_FW_ALL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "All");
	
	
	//TAB OpenVPN
	String TB_OpenVPN = "editSecurity:vpn_tab4";
	String BTN_ADD_OpenVPN = "editSecurity:vpnTab:vpnGrid:addButton";
	String BTN_EDIT_OpenVPN = "editSecurity:vpnTab:vpnGrid:editButton";
	String BTN_DELETE_OpenVPN = "editSecurity:vpnTab:vpnGrid:deleteButton";
	String IPF_OpenVPN_NAME = "vpnPopUp:nameField";
	String IPF_OpenVPN_ROUTING = "vpnPopUp:routingField";
	String IPF_OpenVPN_PARTNER = "vpnPopUp:partnerField";
	String IPF_OpenVPN_ROUTING_MASK = "vpnPopUp:routingMaskField";
	String IPF_OpenVPN_LOCAL_IP = "vpnPopUp:localIpField";
	String IPF_OpenVPN_REMOTE_IP = "vpnPopUp:remoteIpField";
	String IPF_OpenVPN_PORT = "vpnPopUp:portIpField";
	String SLC_OpenVPN_AUTHENTICATION_TYPE = "vpnPopUp:typeCombobox";
	String SLC_OpenVPN_SECRET_KEY_FILE = "vpnPopUp:secretKeyFileCombobox";
	String SLC_OpenVPN_CA_FILE = "vpnPopUp:caFileCombobox";
	String SLC_OpenVPN_CERTIFICATION_FILE = "vpnPopUp:certFileCombobox";
	String SLC_OpenVPN_CERTIFICATION_KEY = "vpnPopUp:certKeyCombobox";
	String CB_OpenVPN_LZO_COMPRESSION = "vpnPopUp:enableLZOCompression";
	String TBL_LIST_OpenVPN = "editSecurity:vpnTab:vpnGrid";
	//Texts (in list OpenVPN) retrieved from property files
	String TXT_LIST_OpenVPN_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.name");
	String TXT_LIST_OpenVPN_ROUTING_MASK = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVpnTab.routingMask");
	String TXT_LIST_OpenVPN_LOCAL_IP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVpnTab.localIp");
	String TXT_LIST_OpenVPN_REMOTE_IP = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editVpnTab.remoteIp");
	String TXT_LIST_OpenVPN_ROUTING = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.routing");
	String TXT_LIST_OpenVPN_PORT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "common.port");
	//Texts (in Drop-down list Authentication Type) retrieved from property files
	String TXT_OpenVPN_AUTH_TYPE_SECRET = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "vpnPopUp.secret");
	String TXT_OpenVPN_AUTH_TYPE_X509_CLIENT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "vpnPopUp.x509Client");
	String TXT_OpenVPN_AUTH_TYPE_X509_SERVER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "vpnPopUp.x509Server");
	String TXT_NO_SELECTION = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editSecurity.tlsNoSelection");
	
	
	//TAB IPSEC
	String TB_IPsec = "editSecurity:ipSec_tab5";
	String BTN_ADD_IPsec = "editSecurity:ipSecTab:ipSecGrid:addButton";
	String BTN_EDIT_IPsec = "editSecurity:ipSecTab:ipSecGrid:editButton";
	String BTN_DELETE_IPsec = "editSecurity:ipSecTab:ipSecGrid:deleteButton";
	String IPF_IPsec_NAME = "ipSecPopUp:nameField";
	String IPF_IPsec_PARTNER = "ipSecPopUp:partnerField";
	String IPF_IPsec_PARTNER_NETWORK = "ipSecPopUp:partnerNetField";
	String IPF_IPsec_PARTNER_NETMASK = "ipSecPopUp:partnerNetMaskField";
	String IPF_IPsec_LOCAL_NETWORK = "ipSecPopUp:localNetField";
	String IPF_IPsec_LOCAL_NETMASK = "ipSecPopUp:localNetMaskField";
	String IPF_IPsec_SECRET_KEY_FILE = "ipSecPopUp:secretKeyFileCombobox";
	String SLC_IPsec_SIDE = "ipSecPopUp:sideCombobox";
	String SLC_IPsec_AUTHENTICATION_TYPE = "ipSecPopUp:typeCombobox";
	String SLC_IPsec_CERTIFICATION_FILE = "ipSecPopUp:certFileCombobox";
	String SLC_IPsec_CERTIFICATION_KEY = "ipSecPopUp:certKeyCombobox";
	String CB_IPsec_ENABLE_COMPRESSION = "ipSecPopUp:enableCompression";
	String CB_IPsec_ENABLE_PFS = "ipSecPopUp:pfs";
	String TBL_LIST_IPsec = "editSecurity:ipSecTab:ipSecGrid";
	//Texts (in list IPSEC) retrieved from property files
	String TXT_LIST_IPsec_CONNECTION_NAME = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editIpSecTab.connectionName");
	String TXT_LIST_IPsec_PARTNER = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editIpSecTab.partner");
	String TXT_LIST_IPsec_PARTNER_NETWORK = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editIpSecTab.partenerNet");
	String TXT_LIST_IPsec_PARTNER_NETMASK = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editIpSecTab.partenerNetMask");
	String TXT_LIST_IPsec_SIDE = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editIpSecTab.side");
	String TXT_LIST_IPsec_LOCAL = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editIpSecTab.local");
	String TXT_LIST_IPsec_LOCAL_NETWORK = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editIpSecTab.localNet");
	String TXT_LIST_IPsec_LOCAL_NETMASK = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "editIpSecTab.localNetMask");
	//Texts (in Drop-down lists Authentication Type and Side) retrieved from property files
	String TXT_IPsec_AUTH_TYPE_SECRET = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "vpnPopUp.secret");
	String TXT_IPsec_AUTH_TYPE_X509 = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "ipSecPopUp.x509");
	String TXT_IPsec_SIDE_LEFT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "ipSecPopUp.left");
	String TXT_IPsec_SIDE_RIGHT = SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "ipSecPopUp.right");
	
}
