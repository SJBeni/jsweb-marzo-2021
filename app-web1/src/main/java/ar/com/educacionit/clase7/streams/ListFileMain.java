package ar.com.educacionit.clase7.streams;
import java.io.File;

public class ListFileMain {

	public static void main(String[] args) {
		
		File myFile = new File ("C:\\Desarrollo\\educacionit\\files\\files-dat");
		
		if(myFile.exists()) {
			if(myFile.isDirectory()) {
				File[] files = myFile.listFiles();
				listFilesNames(files);
			}
		}else {
			System.err.println("La carpeta: " + myFile.getAbsoluteFile() + " no existe");
		}
	}
	
	//metodo recursivo
	private static void listFilesNames(File[] files) {
		
		if(files == null || files.length == 0) {
			return;
		}
		
		//caso base
		for(File aux : files) {
			if(aux.isDirectory()) {
				File[] filesInDirectory = aux.listFiles();
				
				//invocacion recursiva
				listFilesNames(filesInDirectory);
			}else {
				System.out.println(aux.getName());
			}
		}
	}

}