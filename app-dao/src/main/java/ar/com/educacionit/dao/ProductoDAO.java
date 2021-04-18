package ar.com.educacionit.dao;

import java.util.Collection;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Producto;

/**
 * METODO CRUD PARA PRODUCTO
 * @author Sergio
 *
 */
public interface ProductoDAO {

	public Producto create(Producto producto) throws DuplicatedException, GenericException;
	public Collection<Producto> findAll() throws GenericException;	//representa el selectAll
	public Producto getById(Long id) throws GenericException;	//representa selectById
	public Producto getByCodigo(String codigo) throws GenericException;	//representa selectByCodigo
	public Producto update(Producto producto) throws GenericException;
	public Producto deleteById(Long id) throws GenericException;	
	public Producto deleteByCodigo(String codigo) throws GenericException;	
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException;
	
}
