//The logging levels are TRACE, DEBUG, INFO, WARN, ERROR and FATAL

import org.testng.annotations.*;
import org.testng.log4testng.Logger;

public class LoggerExample{
	
	Logger mylog = Logger.getLogger(LoggerExample.class);
	
	@Test(priority=1)
	public void traceMethod() throws Exception {
		mylog.trace("This is a trace message");
	}
	
	@Test(priority=2)
	public void debugMethod() throws Exception {
		mylog.debug("This is a debug message");
	}
	
	@Test(priority=3)
	public void infoMethod() throws Exception {
		mylog.info("This is a info message");
	}
	
	@Test(priority=4)
	public void warnMethod() throws Exception {
		mylog.warn("This is a warn message");
	}
	
	@Test(priority=5)
	public void errorMethod() throws Exception {
		mylog.error("This is a error message");
	}
	
	@Test(priority=6)
	public void fatalMethod() throws Exception {
		mylog.fatal("This is a fatal message");
	}
}
