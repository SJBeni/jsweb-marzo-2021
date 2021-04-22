package ar.com.educacionit.clase6.jdbc.menu;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

public class DeletePorCodigo extends AccionBase implements IAccion {

	@Override
	public void execute() {
		
		System.out.println("Ingrese el Codigo del producto a eliminar: ");
		String codigo = teclado.next();

		try {
			Producto productoEliminado = super.pDao.deleteByCodigo(codigo);
			System.out.println("Se ha eliminado el producto: " + productoEliminado);
		} catch (GenericException e) {
			System.err.println("No se ha encotrado el producto con codigo= " + codigo);
			System.err.println(e.getMessage());
		}
	}

}
