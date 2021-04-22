package ar.com.educacionit.clase6.jdbc.menu;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class BuscarPorID extends AccionBase implements IAccion {

	@Override
	public void execute() {
		
		System.out.println("Ingrese el id: ");
		Long id = teclado.nextLong();
		
		ProductoDAO productoDao = new ProductoDAOJdbcImpl();
		
		try {
			Producto productoPorID = productoDao.getById(id);
			System.out.println(productoPorID);
		} catch (GenericException e) {
			System.err.println("No se ha encotrado el producto con id= " + id);
			System.err.println(e.getMessage());
		}
	}

}
