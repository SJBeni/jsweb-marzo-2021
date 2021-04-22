package ar.com.educacionit.clase6.jdbc.menu;

import java.util.Collection;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class ListarPorTitulo extends AccionBase implements IAccion {

	@Override
	public void execute() {
		System.out.println("Ingrese el titulo: ");
		String titulo = super.teclado.next();
		try {
			Collection<Producto> productos = super.pDao.findAllByTitulo(titulo);
			if(!productos.isEmpty()) {
				System.out.println("Se han encontrado: " + productos.size() + " productos");
				System.out.println(productos);
			}else {
				System.out.println("No se han encontrado productos");
			}
		} catch (GenericException e) {
			e.printStackTrace();
		}
		
		
	}

}
