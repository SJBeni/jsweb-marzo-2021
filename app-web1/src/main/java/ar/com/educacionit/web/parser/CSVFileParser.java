package ar.com.educacionit.web.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Producto;

public class CSVFileParser extends FileParserBase implements IFileParser {

	public CSVFileParser(String name) {
		super(name);
	}

	@Override
	public Collection<Producto> parse() throws IOException {
		
		File myFile = new File (super.name);

		Reader r = new FileReader(myFile);
		
		BufferedReader bf = new BufferedReader(r);
		
		String lineaLeida = bf.readLine();
		
		Collection<Producto> productos = new ArrayList<Producto>();
		while(lineaLeida != null) {
			lineaLeida = bf.readLine();
			if(lineaLeida != null) {
				//separo por punto y coma (;)
				String[] datos = lineaLeida.split(";");
				
				if(datos.length > 1 && !"".equals(datos[0])) {
					String titulo = datos[0];
					String codigo = datos[1];
					Float precio = Float.parseFloat(datos[2]);
					Long tipo = Long.parseLong(datos[3]);
					
					Producto producto = new Producto(titulo,precio,codigo,tipo);
					productos.add(producto);
				}
			}
		}
		
		bf.close();
		return productos;
	}
	
	

}
