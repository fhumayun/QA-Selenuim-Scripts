package com.helper.enviroment;


import com.Seleniumhelper.SeleniumWebdriver;
import com.helper.SuperHelper;
import com.helper.enviroment.ApplicationServer;

public class InitializeVariables extends Thread{
	
	public static void CreateInitializeVariables(){
	}
	public void run() {
		System.out.println("Variables are going to be initialized!");
		// Create HTML file
		SuperHelper.installation_Dir = ApplicationServer.getInstalaltionPath();
		SuperHelper.Solid_Dir = ApplicationServer.getSolidDir();
		SuperHelper.ApplicationServerName = ApplicationServer.getApplicationServerName().toLowerCase();
		SuperHelper.HipathServerName = ApplicationServer.getHipathServerName();
		String rpm = ApplicationServer.getOpenBranchrpm();
		System.setProperty("org.uncommons.reportng.title",SeleniumWebdriver.getEnvVarValue("TITLE") + " -" + rpm);
		System.out.println("\t\t\tVariables have been initialized!");
	}
}