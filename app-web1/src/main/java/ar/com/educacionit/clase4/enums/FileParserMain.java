package ar.com.educacionit.clase4.enums;

import java.util.Scanner;

import ar.com.educacionit.clase4.exceptions.NoFileParserException;

public class FileParserMain {

	//consola!!
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		String tipo;
		
		do {
			System.out.println("Ingrese tipo de archivo a exportar: (CSV, TXT, XSL)");			
			tipo = teclado.next();
		}while( !(tipo.equals("CSV") || tipo.equals("TXT") || tipo.equals("XLS")) );
		
		teclado.close();
		
		Tipo unEnum = Tipo.getEnumBy(tipo);
		
		//en base a mi enum obtengo de la clase FileParserBuilder un IFileParser
		IFileParser unParser;
		try {
			unParser = FileParserBuilder.builFileParser(unEnum);
			
			if(unEnum !=null) {
				//invocar al metodo de la interface
				String resultado = unParser.parse();
				
				System.out.println("Resultado : " + resultado);
			}			
		} catch (NoFileParserException e) {
			System.err.println(e.getMessage());
		}
	}
	

}
