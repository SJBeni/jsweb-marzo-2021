package ar.com.educacionit.interfaces.main;

import ar.com.educacionit.interfaces.ILogger;
import ar.com.educacionit.interfaces.impl.EmailLogger;
import ar.com.educacionit.interfaces.impl.HDLogger;

public class ILoggerFactory {

	public static ILogger[] buildLogger(String dest, String msj) {
		
		EmailLogger emailLogger = new EmailLogger(dest, msj);
		emailLogger.log();
		
		HDLogger hdLogger = new HDLogger("c:/logs", "aprendiedo interfaces en java");
		hdLogger.log();
		
		//ahora creo un vector de interfaces
		ILogger[] loggers = new ILogger[2];
		loggers[0] = emailLogger;
		loggers[1] = hdLogger;
		
		return loggers;

	}
}
