package ar.com.educacionit.clase6.jdbc;

import java.util.Scanner;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class DeleteProductoByIdMain {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese el ID del producto a eliminar: ");
		Long id = teclado.nextLong();

		ProductoDAO productoDao = new ProductoDAOJdbcImpl();

		try {
			Producto productoEliminado = productoDao.deleteById(id);
			System.out.println("Se ha eliminado el producto: " + productoEliminado);
		} catch (GenericException e) {
			System.err.println("No se ha encotrado el producto con id= " + id);
			System.err.println(e.getMessage());
		} finally {
			teclado.close();
		}
	}

}
