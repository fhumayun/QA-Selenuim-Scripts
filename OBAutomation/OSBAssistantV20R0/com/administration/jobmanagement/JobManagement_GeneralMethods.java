package com.administration.jobmanagement;

import com.Seleniumhelper.superscripts.MyLogger;
import com.helper.SuperHelper;

public class JobManagement_GeneralMethods extends SuperHelper implements PropertiesJobManagement {
 	
   public void checkCompletion(double completionTime,String jobRowNumber,String jobColumnNumber) throws InterruptedException 
   {		
	   double startTime = System.currentTimeMillis()/1000.0;	 
	    String jobStatus = ""; 
	    boolean check=true;   
		do
		{	
          goToJobManagement();
          jobStatus = selenium.getTable(TBL_LIST_JOBS+"." + jobRowNumber + "." + jobColumnNumber);
          if (jobStatus.equals("COMPLETED")){
        	 MyLogger.resultInfo("The Job has been completed!");
        	 break;
          }
          if (jobStatus.equals("FAILED")){
         	 MyLogger.resultError("The Job has failed!");
         	 throw new InterruptedException("The Job has failed!");   
           }
          
          MyLogger.resultInfo("The Job status is still " + jobStatus);
          MyLogger.resultInfo("Wait for 5 sec and Refresh Jobs List again");
          sleep(5000);
        
          double stopTime = System.currentTimeMillis()/1000.0;
          if(stopTime-startTime > completionTime)
          {
        	 MyLogger.resultError("The Job was not completed in the desired time!");
	         throw new InterruptedException("The Job was not completed in the desired time!");   
          }                                         
		}
		while(check);
			
    }

}