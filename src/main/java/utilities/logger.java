package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public  class logger {
	static Logger log;
	public static Logger getLogger(Class  clazz) {
		
		log=Logger.getLogger(clazz);
		 PropertyConfigurator.configure("C:\\selenium\\mavenproj\\src\\main\\java\\resources\\log4j.properties");
		return log;

	}
	

}
