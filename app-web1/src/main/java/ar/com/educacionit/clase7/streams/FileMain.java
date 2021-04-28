package ar.com.educacionit.clase7.streams;

import java.io.File;

public class FileMain {

	public static void main(String[] args) {
		
		File myFile = new File("C:\\Desarrollo\\educacionit\\files\\imagen.dat");
		
		boolean isDirectory = myFile.isDirectory();
		
		if(isDirectory) {
			File[] files = myFile.listFiles();
			for(File aux: files) {
				System.out.println(aux.getName());
			} 
		}else {
			if(myFile.isFile()) {
				System.out.println(myFile.getName());
			}
		}
			
		

	}

}
