package ar.com.educacionit.services;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;

public interface ProductoServices {

	Collection<Producto> findAll() throws ServiceException;
	
	public Producto getById(Long id) throws ServiceException;
	
	public Producto nuevoProducto(Producto producto) throws ServiceException;
	
	public Collection<Producto> buscarProducto(String clave) throws ServiceException;
	
	public Producto eliminarProducto(Long id) throws ServiceException;
	
	public void actualizarProducto(Producto producto) throws ServiceException;
}
