package ar.com.educacionit.web.writter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileWritterMain {

	public static void main(String[] args) throws IOException {
		
		List<String> mensajes = Arrays.asList("linea1","linea2","linea3");
		
		File file = new File("C:\\Desarrollo\\educacionit\\files\\fail.csv");
		
		FileWriter fr = new FileWriter(file);
		
		//escribir
		for(String aux : mensajes) {
			fr.write(aux);
			fr.write("\n");
		}
		
		fr.close();
	}
}
