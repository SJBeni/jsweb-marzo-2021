package ar.com.educacionit.web.controller.console;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import ar.com.educacionit.domain.Producto;

public class ProductoWritter implements IFileWritter {

	@Override
	public void write(String name, Collection<Producto> productos) throws IOException {
		
		File file = new File(name);
		
		FileWriter fr = new FileWriter(file);
		
		//titulo
		fr.write("titulo;codigo;precio;tipo\n");
		//escribir
		for(Producto aux : productos) {
			fr.write(aux.toCSV());
			fr.write("\n");
		}
		
		fr.close();
		
	}

}
