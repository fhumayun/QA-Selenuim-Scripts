package com.helper.enviroment;

import com.Seleniumhelper.ssh.ExecCommandGetReply;
import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;


public class ApplicationServer {

	private static ExecCommandGetReply executeCommand = new ExecCommandGetReply();
	
	public static String getDVDversion(){
		return executeCommand.execCmd("rpm -qa | grep OpenScapeUC_ProductVersion-").replace("OpenScapeUC_ProductVersion-", "V");
    }
	
	public static String getCMPrpm(){
		return executeCommand.execCmd("rpm -qa | grep scs_cmp-").replace("scs_cmp-", "V");
	}
	
	public static String getAssistantrpm(){
		return executeCommand.execCmd("rpm -qa | grep HiPath8000Assistant-").replace("HiPath8000Assistant-", "V");
    }
	
	public static String getOpenBranchrpm(){
		return executeCommand.execCmd("rpm -qa | grep OpenBranchAssistant-").replace("OpenBranchAssistant-", "V");
    }
	
	public static String getSymphoniarpm(){
        return executeCommand.execCmd("rpm -qa | grep symphonia-[0-9]\\.[0-9]").replace("symphonia-", "V");
    }
	
	public static String getDomainrpm(){
		return executeCommand.execCmd("rpm -qa | grep scs_domain_be-").replace("scs_domain_be-", "V");
    }
	
	public static String getProvisioningrpm(){
		return executeCommand.execCmd("rpm -qa | grep scs_provisioning-[0-9]").replace("scs_provisioning-", "V");  
    }
	
	public static String getLicenserpm(){
		return executeCommand.execCmd("rpm -qa | grep scs_licensing_be-").replace("scs_licensing_be-", "V");
    }
	
	public static String getContactrpm(){
		return	executeCommand.execCmd("rpm -qa | grep scs_contact").replace("scs_contacts-", "V");
    }
	
	public static String getFaultrpm(){
		return executeCommand.execCmd("rpm -qa | grep scs_faultmgmt_be").replace("scs_faultmgmt_be-", "V");
    }
	public static String getMediaServerrpm(){   
		return executeCommand.execCmd("rpm -qa  | grep mediaserver-").replace("mediaserver-", "V");
	}
	
	public static String getBcomrpm(){
		return executeCommand.execCmd("rpm -qa  | grep scs_bcom_be-").replace("scs_bcom_be-", "V");
    }
	
	public static void setPopUpsStatus (boolean popUp){
		 executeCommand.execCmd(("echo \"set catalog opensoa;"+
							"update SYMUSERPREFERENCESVALUES set PREFERENCEVALUE='"+popUp+"' where USERPREFERENCESKEY=("+
							"select UUIDKEY from SYMUSERPREFERENCES where PREFERENCENAME='PopUpsDisabled');"+
							"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba")); 
	}
	
	public static void setnumOfRowsPerList (int rows){
		 executeCommand.execCmd(("echo \"set catalog opensoa;"+
							"update SYMUSERPREFERENCESVALUES set PREFERENCEVALUE='"+rows+"' where USERPREFERENCESKEY=("+
							"select UUIDKEY from SYMUSERPREFERENCES where PREFERENCENAME='NumberOfRows');"+
							"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
		 
	}
	
	public static void setautoLogOffTime (int time){
		MyLogger.methodPrint(new Exception().getStackTrace()[0].getMethodName()+" for time in sec: "+time);	 
		String uuidkey = executeCommand.execCmd(("echo \"set catalog opensoa;"+
							"select uuidkey from symuserpreferences where preferencename='DefaultTimeOut';"+
							"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
		
		String [] array = uuidkey.split("\n");
		String reply = array[10];
		reply = reply.replace(" ", ""); 
		 
		executeCommand.execCmd(("echo \"set catalog opensoa;"+
					"update symuserpreferencesvalues set preferencevalue='"+time+"' where userpreferenceskey='"+reply+"';"+
					"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
		 
	}
	
	public static String getMediaVersion(){
		String version = executeCommand.execCmd("rpm -qa | grep mediaserver-").replace("mediaserver-", "");
		version = version.replace("\n", "V");
		version= version.replace("_", " R");
		version = version.substring(0,version.indexOf("-"));
		return version;
	}
	
	public static String getOpenScapeUCVersion(){
		String content = executeCommand.execCmd("grep SI_IS_HP8K= /etc/sysconfig/siemens/symphonia");
		  if (content.contains("0")){
		String version = executeCommand.execCmd("grep 'id=\"OpenScape\"' /opt/siemens/common/conf/DeployedApplicationList.xml");
		String uc = version.substring(version.indexOf("V"),version.indexOf(">"));
		String versionUC = uc.replace("\"", "");
		return versionUC;
		  }
		  else {
				String version = executeCommand.execCmd("grep 'id=\"OpenScape\"' /enterprise/common/conf/DeployedApplicationList.xml");
				String uc = version.substring(version.indexOf("V"),version.indexOf(">"));
				String versionUC = uc.replace("\"", "");
				return versionUC;
		      }
	}
		  
	public static String getSoftwareVersion(){
	 String softwareversion = executeCommand.execCmd(("echo \"set catalog opensoa;"+"select versioninfo from hipath8000;" + 
				"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
		 String [] version = softwareversion.split("\n");
		 String sfwversion = version[10].replace(" ", "");
		 sfwversion = sfwversion.replace("_PS", "-");
		 sfwversion = sfwversion.replace(".E", "E");
		  return sfwversion;
	}
		  
   public static String getCSTAIP(){
		 String csta = executeCommand.execCmd(("echo \"set catalog opensoa;"+"select cstasm1_vip_2 from hipath8000;" + 
						"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
		String [] cstaip = csta.split("\n");
		String cstaipnew = cstaip[10].replace(" ", "");
		return cstaipnew;	  

   }
   
   public static String getSOAPORT(){
				 String soaport = executeCommand.execCmd(("echo \"set catalog opensoa;"+"select attributevalue from SYMRESOURCEGROUPATTRIBUTEVALUES where attributetypekey='sym.attribute.resourcegroup.20';" + 
				"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
		 String [] replystring = soaport.split("\n");
		 String reply1 = replystring[10];
		 String soaportfinal = reply1.replace(" ", "");
		  return soaportfinal;	  
   }
   
	public static String  bridgenumbertoll() {
		String reply = executeCommand.execCmd("grep '\"bridgeNumberToll\" value=' "+SuperHelper.installation_Dir+"common/conf/instance*");
		String [] replystring = reply.split("\n");
		String reply1 = replystring[1];
		String value = reply1.substring(reply1.indexOf("value="),reply1.indexOf(" writable"));
		String bridgevalue = value.replace("\"", "");
		String bridgetoll = bridgevalue.replace("value=","");
		return bridgetoll;
	}	
	
	public static void deleteExpression(){
		 executeCommand.execCmd(("echo \"set catalog opensoa;"+"delete from SYMXPRNODES;" + 
			"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
	}
	
    public static void deleteColumnPickerAlterations(){
		 executeCommand.execCmd(("echo \"set catalog opensoa;"+"delete from USERSETTINGS;" + 
			"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
	}
	
	public static void deleteLdapConnection(){
			 executeCommand.execCmd(("echo \"set catalog opensoa;"+"delete from UMLDAPCONNECTION;" + 
			"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
	}
	
	public static String getApplicationServerName(){
		String reply = executeCommand.execCmd("cat "+SuperHelper.installation_Dir+"common/conf/*.xml | grep \"NodeData displayname\"");
		int index1 = reply.indexOf("\"");
		reply = reply.substring(index1+1, reply.length());
		index1 = reply.indexOf("\"");
		reply = reply.substring(0, index1);
		return reply;
	}	
	
	public static String getApplicationServerIp(){	
		String reply = executeCommand.execCmd("/sbin/ifconfig eth0 | grep 'inet addr:' | cut -d: -f2 | awk '{ print $1}'");
		return reply.replace("\n", "");
	}
	
	public static String getHipathServerName(){
		String hipathname = "";
		String reply = "";
		try{
		 hipathname = executeCommand. execCmd(("echo \"set catalog opensoa;"+"select NAME from hipath8000;" + 
							"commit work;\" | "+SuperHelper.Solid_Dir+"solsql \"tcp 16760\" dba dba"));
		 String [] hipathnamearray = hipathname.split("\n");
		 reply = hipathnamearray[10];
		 reply = reply.replace(" ", "");
		}catch(StringIndexOutOfBoundsException ex){
			System.out.println("getHipathServerName method fails ,\n" +
					" please see IP condifuration in customization.xml and \n" +
					"check if application is installed in this ip");
		}
		return reply;
	}
	
	public static String getInstalaltionPath(){
		String content = executeCommand.execCmd("grep SI_IS_HP8K= /etc/sysconfig/siemens/symphonia");
		if (content.contains("0")){
			return "/opt/siemens/";
		}
		else {
				return "/enterprise/";
		}
	}
	public static String getSolidDir(){
		String content = executeCommand.execCmd("grep SI_IS_HP8K= /etc/sysconfig/siemens/symphonia");
		if (content.contains("0")){
			return "/opt/siemens/solid/bin/";
		}
		else {
				return "/usr/local/solid45/bin/";
		}
	}
	
//	SSH access without credentials from the application server to the 4K node 
//	has to be configured before this method is functional
	public static String get_4KTrapList(String HP4K_IP){
	 return executeCommand.execCmd("ssh root@"+HP4K_IP+" 'cat /etc/srconf/agt/td.list'");
	}
	
	public static void deletePhones(String ComSystemID) {
		executeCommand.execCmd(("echo \"set catalog opensoa;"
				+ "delete from symphones where switchid='"
				+ ComSystemID + "';" + "commit work;\" | "
				+ SuperHelper.Solid_Dir + "solsql \"tcp 16760\" dba dba"));
	}
	
	public static String[] get_4KManagedNodes(String ManagerName) {
		String Nodes = executeCommand.execCmd(("echo \"set catalog opensoa;"
				+ "select NAME from SYM4KNODESDATA where MANAGINGNODE='"
				+ ManagerName + "';" + "commit work;\" | "
				+ SuperHelper.Solid_Dir + "solsql \"tcp 16760\" dba dba"));
		int indexNodes = Nodes.lastIndexOf("--");
		Nodes = Nodes.substring(indexNodes + 3);
		indexNodes = Nodes.indexOf("rows fetched");
		Nodes = Nodes.substring(0, (indexNodes - 3));
		Nodes = Nodes.trim();
		Nodes = Nodes.replace("\n", ",");
		Nodes = Nodes.replace(" ", "");
		String[] nodesMatrix;
		// Expects that the managed nodes' names will have no blanks.
		nodesMatrix = Nodes.split(",");
		return 
		nodesMatrix;
	}
	
	public static String[] get_NodeIDs(String CStype) {
		String NodesIDs = executeCommand.execCmd(("echo \"set catalog opensoa;"
				+ "select ID from SYMCOMMUNICATIONSYSTEMS where CSTYPE='"
				+ CStype + "';" + "commit work;\" | "
				+ SuperHelper.Solid_Dir + "solsql \"tcp 16760\" dba dba"));
		int indexNodes = NodesIDs.indexOf("--");
		NodesIDs = NodesIDs.substring(indexNodes + 3);
		indexNodes = NodesIDs.indexOf("rows fetched");
		NodesIDs = NodesIDs.substring(0, (indexNodes - 3));
		NodesIDs = NodesIDs.trim();
		NodesIDs = NodesIDs.replace("\n", ",");
		NodesIDs = NodesIDs.replace(" ", "");
		// Expects that the managed nodes' names will have no blanks.
		String[] NodesIDsMatrix = NodesIDs.split(",");
		return 
		NodesIDsMatrix;
	}
	
	public static String[] get_BCFederation(String CStype) {
		String[] NodesIDsMatrix = ApplicationServer.get_NodeIDs(CStype);
		int length = NodesIDsMatrix.length;
		String[] BCFedMatrix = NodesIDsMatrix;
		String ComProvIDs;
		for (int j=0 ; j<length ; j++){
			ComProvIDs = executeCommand.execCmd(("echo \"set catalog opensoa;"
					+ "select ID from SYMBCFEDERATIONS where SWITCHID='"
					+ NodesIDsMatrix[j] + "';" + "commit work;\" | "
					+ SuperHelper.Solid_Dir + "solsql \"tcp 16760\" dba dba"));
			int indexComProv = ComProvIDs.lastIndexOf("--");
			ComProvIDs = ComProvIDs.substring(indexComProv + 3);
			indexComProv = ComProvIDs.indexOf("rows fetched");
			ComProvIDs = ComProvIDs.substring(0, (indexComProv - 3));
			ComProvIDs = ComProvIDs.trim();
			ComProvIDs = ComProvIDs.replace("\n", ",");
			ComProvIDs = ComProvIDs.replace(" ", "");
			BCFedMatrix[j] = ComProvIDs; 
		}
	return 
	BCFedMatrix;
	}
	
	public static String[] get_BCFedComProvider(String CStype) {
		String[] NodesIDsMatrix = ApplicationServer.get_NodeIDs(CStype);
		int length = NodesIDsMatrix.length;
		String[] BCFedComProv= NodesIDsMatrix;
		String ComProvIDs;
		for (int j=0 ; j<length ; j++){
			ComProvIDs = executeCommand.execCmd(("echo \"set catalog opensoa;"
					+ "select COMPROVIDERRESPONSIBILITY from SYMBCFEDERATIONS where SWITCHID='"
					+ NodesIDsMatrix[j] + "';" + "commit work;\" | "
					+ SuperHelper.Solid_Dir + "solsql \"tcp 16760\" dba dba"));
			int indexComProv = ComProvIDs.lastIndexOf("--");
			ComProvIDs = ComProvIDs.substring(indexComProv + 3);
			indexComProv = ComProvIDs.indexOf("rows fetched");
			ComProvIDs = ComProvIDs.substring(0, (indexComProv - 3));
			ComProvIDs = ComProvIDs.trim();
			ComProvIDs = ComProvIDs.replace("\n", ",");
			ComProvIDs = ComProvIDs.replace(" ", "");
			BCFedComProv[j] = ComProvIDs; 
		}
	return 
	BCFedComProv;
	}
	
	public static String[] get_NodeNames(String CStype) {
		String NodesNames = executeCommand.execCmd(("echo \"set catalog opensoa;"
				+ "select NAME from SYMCOMMUNICATIONSYSTEMS where CSTYPE='"
				+ CStype + "';" + "commit work;\" | "
				+ SuperHelper.Solid_Dir + "solsql \"tcp 16760\" dba dba"));
		int indexNodes = NodesNames.lastIndexOf("--");
		NodesNames = NodesNames.substring(indexNodes + 3);
		indexNodes = NodesNames.indexOf("rows fetched");
		NodesNames = NodesNames.substring(0, (indexNodes - 3));
		NodesNames = NodesNames.trim();
		NodesNames = NodesNames.replace("\n", ",");
		NodesNames = NodesNames.replace(" ", "");
		// Expects that the managed nodes' names will have no blanks.
		String[] NodesNamesMatrix = NodesNames.split(",");
		return 
		NodesNamesMatrix;
	}
	
}
