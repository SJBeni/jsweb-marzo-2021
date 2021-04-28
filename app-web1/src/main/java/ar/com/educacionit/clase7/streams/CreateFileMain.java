package ar.com.educacionit.clase7.streams;

import java.io.File;

public class CreateFileMain {

	public static void main(String[] args) {
		
		File myFile = new File("C:\\Desarrollo\\educacionit\\files\\files-dat");

		if(!myFile.exists()) {
			boolean created = myFile.mkdir();
			
			if(created) {
				System.out.println("Se ha creado corectamente la carpeta: " + myFile.getAbsoluteFile());
			}else {
				System.out.println("No se ha creado correctamente la carpeta: " + myFile.getAbsoluteFile());
			}
		
		}else {
			System.out.println("La carpeta: " + myFile.getAbsoluteFile() + " ya existe");
		}
	}

}
