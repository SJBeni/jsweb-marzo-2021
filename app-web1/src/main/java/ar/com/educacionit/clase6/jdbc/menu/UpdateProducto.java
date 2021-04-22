package ar.com.educacionit.clase6.jdbc.menu;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ProductoDAOJdbcImpl;
import ar.com.educacionit.domain.Producto;

public class UpdateProducto extends AccionBase implements IAccion {

	@Override
	public void execute() {
		
		System.out.println("Ingrese el ID del producto que desea actualizar: ");
		Long id = teclado.nextLong();

		ProductoDAO productoDao = new ProductoDAOJdbcImpl();
		try {
			
			Producto producto = productoDao.getById(id);
			
			System.out.println("Se actualizara el siguiente producto: ");
			System.out.println(producto);
			
			if(producto != null) {
				
				//actualizamos el precio
				System.out.println("Ingrese el nuevo Precio: ");
				Float precioActualizado = teclado.nextFloat();
				producto.setPrecio(precioActualizado);
				
				//actualizamos titulo
				System.out.println("Ingrese el nuevo Titulo: ");
				String nuevoTitulo = teclado.next();
				producto.setTitulo(nuevoTitulo);
				
				producto = productoDao.update(producto);
				
				System.out.println("Producto Actualizado correctamente");
				
			}else {
				System.err.println("No existe el producto con ID= " + id);
			}
			
		}catch(GenericException e){
			System.err.println(e.getMessage());
		}
	}

}
