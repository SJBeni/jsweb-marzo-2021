package ar.com.educacionit.interfaces.main;

import ar.com.educacionit.interfaces.ILogger;
//import ar.com.educacionit.interfaces.impl.EmailLogger;
//import ar.com.educacionit.interfaces.impl.HDLogger;

public class MainInterfaces {

	public static void main(String[] args) {
		
		String msj = args[0];
		String dest = args[1];
		
		//crear
		ILogger[] loggers = ILoggerFactory.buildLogger(dest, msj);
		
		//recorrer
		for(ILogger logger : loggers) {
			logger.log();
			logger.log1();
		}

	}

}
