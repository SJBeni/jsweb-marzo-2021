package ar.com.educacionit.clase7.streams;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileMain {

	public static void main(String[] args) throws IOException {
		
		File myFile = new File ("C:\\Desarrollo\\educacionit\\files\\files-dat\\1.txt");

		//abrir el archivo
		FileReader fr = new FileReader(myFile);
		int letra;
		
		//mientras existan datos
		while((letra = fr.read()) != -1) {
			//leer
			System.out.print((char)letra);
		}
		
		//cerrar archivo/lector
		fr.close();
		

	}

}