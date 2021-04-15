package ar.com.educacionit.clase4.enums;
import java.util.Scanner;

import ar.com.educacionit.clase4.exceptions.NoFileParserException;

public class FileParserMain {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String tipo;
		
		do {
			System.out.println("Ingrese un tipo de archivo a exportar: (CSV, TXT, XLS)");
			tipo = teclado.next();
		}while(!(tipo.equals("CSV") || tipo.equals("TXT") || tipo.equals("XLS")));
		teclado.close();
		
		Tipo unEnum = Tipo.valueOf(tipo);
		
		//En base a mi enum ,obtengo de la clase FileParserBuilder, un IFileParser
		IFileParser unParser;
		try {
			unParser = FileParserBuilder.buildFIleParser(unEnum);
			String resultado;
			if(unEnum != null) {
				//invocar al metodo de la interface
				resultado = unParser.parse();
				System.out.println("Resultado: " + resultado);
			}
		} catch (NoFileParserException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		
		
			
			
		
	}

}