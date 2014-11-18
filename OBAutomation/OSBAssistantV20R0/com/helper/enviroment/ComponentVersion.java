package com.helper.enviroment;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.helper.enviroment.ApplicationServer;

public class ComponentVersion extends Thread{
	
	public static void CreateComponentVersions(){
	}
	
	public void run() {
	try{
		//Path save file	
		@SuppressWarnings("deprecation")
		String Path = org.testng.TestNG.getDefault().getOutputDirectory();	
		System.out.println("Components.txt file is going to be created!");
		
		// Create HTML file
		File file = new File(Path+System.getProperty("file.separator")+"Components.txt");
		
		//We'll write the string below into the file
		String data = "DVD:";
		data += ApplicationServer.getDVDversion();
		data += "\n\nCMP:";
		data += ApplicationServer.getCMPrpm();
	    data += "\n\nFramework:";
		data += ApplicationServer.getSymphoniarpm();
		data += "\n\nProvisioning:";
		data += ApplicationServer.getProvisioningrpm();
		
		System.out.println("\t\t\tComponents.txt has been created under: "+Path+System.getProperty("file.separator")+"Components.txt");
		 
		//Pass the date to the file
		FileUtils.writeStringToFile(file, data);
	}catch (IOException e){
		e.printStackTrace();
		System.out.print(e); 
	}
	}
}