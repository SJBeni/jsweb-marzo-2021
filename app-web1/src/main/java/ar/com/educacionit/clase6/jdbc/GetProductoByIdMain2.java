package ar.com.educacionit.clase6.jdbc;

import java.util.Scanner;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class GetProductoByIdMain2 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese el id: ");
		Long id = teclado.nextLong();

		ProductoDAO productoDao = new ProductoDAOJdbcImpl();

		try {
			Producto productoPorCodigo = productoDao.getById(id);
			System.out.println(productoPorCodigo);
		} catch (GenericException e) {
			System.err.println("No se ha encotrado el producto con id= " + id);
			System.err.println(e.getMessage());
		} finally {
			teclado.close();
		}
	}

}
