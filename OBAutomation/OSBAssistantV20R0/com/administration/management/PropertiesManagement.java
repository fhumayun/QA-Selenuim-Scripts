package com.administration.management;

import com.Seleniumhelper.SeleniumWebdriver;


public interface PropertiesManagement {
	
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
	
	String BTN_SHOW_REGISTERED_SUBSCRIBERS = "//*/table[2]/tbody/tr[1]/td[2]//*/input[contains(@id,'formName:outerGrid:0:_')]";
	String BTN_SHOW_LINK_STATUS = "//*/table[2]/tbody/tr[2]/td[2]//*/input[contains(@id,'formName:outerGrid:0:_')]";
	String BTN_REFRESH_LISENCES = "formName:outerGrid:0:licenseListGrid:refreshLicenses";
	String BTN_DEVICE_LICENSE_UPDATE = "formName:outerGrid:0:licenseListGrid:deviceLicenseRefresh";
	String BTN_CONFIGURE_LICENSES = "formName:outerGrid:0:licenseListGrid:configureLicense";
	//Texts (in Show backup Link Status pop-up) retrieved from property files
	String TXT_BACKUP_LINK_CLIENT_STATUS= SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "backupLinkStatus.client");
	String TXT_BACKUP_LINK_SERVER_STATUS= SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "backupLinkStatus.server");
	String TXT_REGISTERED_SUBSCRIBERS= SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "registeredSubscribers.title");
	String TXT_CONTACT= SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "registeredSubscribers.contact");
	String TXT_EXPIRES= SeleniumWebdriver.readproperties("OpenBranch\\OpenBranchGui", "registeredSubscribers.expires");
	
	
}
