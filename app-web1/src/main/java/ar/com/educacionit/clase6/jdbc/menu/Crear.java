package ar.com.educacionit.clase6.jdbc.menu;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class Crear extends AccionBase implements IAccion {

	@Override
	public void execute() {
		System.out.println("Ingrese titulo: ");
		String titulo = teclado.next();
		
		System.out.println("Ingrese precio: ");
		Float precio = teclado.nextFloat();
		
		System.out.println("Ingrese codigo: ");
		String codigo = teclado.next();
		
		System.out.println("Ingrese el tipo producto");
		Long tipoProducto = teclado.nextLong();
		
		ProductoDAO productoDAO = new ProductoDAOJdbcImpl();
		//creo el producto
		Producto nuevoProducto = new Producto(titulo,precio,codigo,tipoProducto);
		
		try {
			nuevoProducto = productoDAO.create(nuevoProducto);	//viene con el id
			System.out.println("Se ha creado el producto: ID= " + nuevoProducto.getId());
		} catch (DuplicatedException e) {
			System.err.println(e.getMessage());
		} catch (GenericException e) {
			System.err.println(e.getMessage());
		}
	}

}
