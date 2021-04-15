package ar.com.educacionit.clase4.enums;

import java.util.HashMap;
import java.util.Map;

import javax.management.NotificationFilterSupport;

import ar.com.educacionit.clase4.exceptions.NoFileParserException;

public class FileParserBuilder {

	//agregamos un atributo de clase
	private static Map<Tipo,IFileParser> mapFileParsers;
	
	//bloque static
	static {
		mapFileParsers = new HashMap<>();
		
		mapFileParsers.put(Tipo.CSV, new CSVFileParser());
		mapFileParsers.put(Tipo.TXT, new TXTFileParser());
		mapFileParsers.put(Tipo.XLS, new XLSFileParser());
	}
	//Utilizamos un metodo estatico
	public static IFileParser buildFIleParser(Tipo tipo) throws NoFileParserException{
		
		IFileParser fileParser;
		
		if(mapFileParsers.containsKey(tipo)) {
			fileParser = mapFileParsers.get(tipo);
		}else {
			throw new NoFileParserException("No Existe Parser asociado a " + tipo);
		}
		
		return fileParser;
	}
}
