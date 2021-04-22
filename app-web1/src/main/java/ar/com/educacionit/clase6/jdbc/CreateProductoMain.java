package ar.com.educacionit.clase6.jdbc;

import java.util.Scanner;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class CreateProductoMain {

	public static void main(String[] args) {
		
		//productos
		//datos de la tabla productos en bd: id,titulo,precio,codigo,idtipoproducto
		
		/*crear producto
		vamos a evitar las validaciones pertinentes a cada ingreso de datos*/
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese titulo: ");
		String titulo = teclado.next();
		
		System.out.println("Ingrese precio: ");
		Float precio = teclado.nextFloat();
		
		System.out.println("Ingrese codigo: ");
		String codigo = teclado.next();
		
		System.out.println("Ingrese el tipo producto");
		Long tipoProducto = teclado.nextLong();
		
		//Interface nombre = new clase()
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
		}finally {
			teclado.close();
		}
		

	}

}
