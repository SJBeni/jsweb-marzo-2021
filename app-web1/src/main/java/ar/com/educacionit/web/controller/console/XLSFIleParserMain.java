package ar.com.educacionit.web.controller.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ProductoServicesImpl;
import ar.com.educacionit.web.parser.CSVFileParser;
import ar.com.educacionit.web.parser.IFileParser;
import ar.com.educacionit.web.parser.XLSFileParser;

public class XLSFIleParserMain {

	public static void main(String[] args) throws IOException, ServiceException {
		
		String fileName = "C:\\Desarrollo\\educacionit\\files\\nuevos-productos.xlsx";
		
		String ext = getExt(fileName);
		
		
		IFileParser fileParser;
		
		if("csv".equals(ext.toLowerCase())) {
			fileParser = new CSVFileParser(fileName);			
		}else {
			fileParser = new XLSFileParser(fileName);						
		}
		
		Collection<Producto> productos = fileParser.parse();
		
		Collection<Producto> ok = new ArrayList<>();
		Collection<Producto> fail = new ArrayList<>();
		
		if(!productos.isEmpty()) {
			ProductoServices ps = new ProductoServicesImpl();
			
			for(Producto aux : productos) {
				try {
					Producto product = ps.nuevoProducto(aux);
					ok.add(product);
				}catch (ServiceException e) {
					fail.add(aux);
				}
					
			}
			//evaluo los ok y fail
			System.out.println("Se han procesado: " + ok.size() + " exitosamente");
			System.out.println("Se han procesado: " + fail.size() + " con errores");
		}
		
		//si hay errores, crear un archivo para esos productos
		IFileWritter fileWritter  = new ProductoWritter();
		fileWritter.write("C:\\Desarrollo\\educacionit\\files\\productos-error.csv",fail);
	}

	private static String getExt(String fileName) {
		
		int from = fileName.lastIndexOf(".") + 1;
		return fileName.substring(from,fileName.length());
	}
		

}


