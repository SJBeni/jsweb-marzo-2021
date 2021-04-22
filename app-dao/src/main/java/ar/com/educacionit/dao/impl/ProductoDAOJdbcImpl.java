package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.dao.ProductoDAO;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.domain.Producto;

public class ProductoDAOJdbcImpl implements ProductoDAO {


	public Collection<Producto> findAll() throws GenericException {
		
		Collection<Producto> productos = new ArrayList<Producto>();// Defino una coleccion para la devolucion del
		// metodo
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "select * from productos";//armamos la sentencia sql correspondiente a select
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlSelect);// creacion de un statement

			ResultSet resultSet = statement.executeQuery(sqlSelect);// ahora debemos simular la ejecucion de la
																	// sentencia pulsando el boton derecho
																	// ResulSet devuelve una coleccion con los registros
																	// recuperados, se debe recorrer

			// if(resultSet.next()) { //si encontro registros en el set para un unico
			// registro
			while (resultSet.next()) { // para varios registros
				Producto producto = productoFromResultSet(resultSet);
				productos.add(producto);// cargamos el producto generado con los registros dentro de la coleccion
			}

			statement.close(); // cerramos el statement
			return productos;	//retornamos la coleccion como indica el metodo
		} catch (SQLException e) {
			throw new GenericException ("No se ha podido crear el producto",e);
		}finally {
			try {
				connection.close();
			}catch(SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verifique en la base de datos",e1);
			}
		}
		
	}
	
	public Producto getById(Long idProducto) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		String sqlSelect = "select * from productos where id = " + idProducto;// armamos la sentencia sql
		
		try {

			PreparedStatement statement = connection.prepareStatement(sqlSelect);// creacion de un statement
			//statement.setLong(1, idProducto);
			ResultSet resultSet = statement.executeQuery(sqlSelect);// ResulSet devuelve una coleccion con los registros
																	// recuperados, se debe recorrer

			Producto producto = null;

			if (resultSet.next()) { // si encontro registros en el set para un unico registro
				producto = productoFromResultSet(resultSet);
			}

			statement.close(); // cerramos el statement

			return producto; // retornamos la coleccion como indica el metodo
		} catch (SQLException e) {
			throw new GenericException ("No se ha podido obtener el producto",e);
		} finally {
			try {
				connection.close();
			}catch(SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verifique en la base de datos",e1);
			}
		}
	}

	public Producto getByCodigo(String codigoProducto) throws GenericException {
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "select * from productos where codigo = '" + codigoProducto + "'";//armamos la sentencia sql correspondiente a select
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlSelect);//creacion de un statement
			//statement.setString(3,codigoProducto);
			ResultSet resultSet = statement.executeQuery(sqlSelect);//ResulSet devuelve una coleccion con los registros recuperados, se debe recorrer
			
			Producto producto = null;
			
			if(resultSet.next()) {	//si encontro registros en el set para un unico registro
				producto = productoFromResultSet(resultSet);
			}
			
			statement.close();	//cerramos el statement
			
			return producto;	//retornamos la coleccion como indica el metodo
		} catch (SQLException e) {
			throw new GenericException ("No se ha podido obtener el producto",e);
		} finally {
			try {
				connection.close();
			}catch(SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verifique en la base de datos",e1);
			}
		}
	}

	public Producto update(Producto producto ) throws GenericException{
		
		Producto productoBuscador = this.getById(producto.getId());
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if(productoBuscador == null) {
			throw new GenericException("No existe el producto id: "+ producto.getId(),null);
		}
		
		//armamos la sentencia sql correspondiente a update
		/*String sqlSelect = "Update productos " 
							+ "set titulo = '" + producto.getTitulo() + "' ,"
							+ "precio = '" + producto.getPrecio() + "' ,"
							+ "id_tipo_producto = '" + producto.getTipoProducto() + "'"
							+ "where id = '" + producto.getId() + "'";*/
		String sqlSelect = "UPDATE productos " 
							+ " set titulo = ? ,"
							+ " precio = ? ," 
							+ " id_tipo_producto = ?" 
							+ " WHERE id = ?";
		try {		
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			
			statement.setString(1, producto.getTitulo());
			statement.setFloat(2, producto.getPrecio());
			statement.setLong(3, producto.getTipoProducto());
			statement.setLong(4, producto.getId());
			
					
			int updated = statement.executeUpdate();
				
			statement.close();	//cerramos el statement
			
			if(updated != 1) {	
					throw new GenericException ("No se ha podido modificar los datos del producto id " + producto.getId(),null);
			}
			
			producto = this.getById(producto.getId());
					
			return producto;	//retornamos la coleccion como indica el metodo	
		}catch (Exception e) {
			throw new GenericException ("No se ha podido actualizar el producto",e);
		} finally {
			try {
				connection.close();
			}catch(SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verifique en la base de datos",e1);
			}
		}
	}
	
	public Producto deleteById(Long id) throws GenericException{
		
		Producto producto = this.getById(id);
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if(producto == null) {
			throw new GenericException("No existe el producto id: "+ id,null);
		}
		
		String sql="DELETE FROM PRODUCTOS WHERE ID = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1,id);
			
			int deleted = statement.executeUpdate();
			
			statement.close();
			
			if(deleted != 1) {
				throw new GenericException("No se ha podido eliminar el producto con id: " + id,null);
			}
			
			
		}catch (SQLException e) {
			throw new GenericException ("No se ha podido eliminar el producto",e);
		} finally {
			try {
				connection.close();
			}catch(SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verifique en la base de datos",e1);
			}
		}	
		return producto;
	}
	
	public Producto deleteByCodigo(String codigo) throws GenericException{
		
		Producto producto = this.getByCodigo(codigo);
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		if(producto == null) {
			throw new GenericException("No existe el producto codigo: "+ codigo,null);
		}
		
		String sql="DELETE FROM PRODUCTOS WHERE CODIGO = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,codigo);
			
			int deleted = statement.executeUpdate();
			
			statement.close();
			
			if(deleted != 1) {
				throw new GenericException("No se ha podido eliminar el producto con codigo: " + codigo,null);
			}
			
			
		}catch (SQLException e) {
			throw new GenericException ("No se ha podido eliminar el producto",e);
		} finally {
			try {
				connection.close();
			}catch(SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verifique en la base de datos",e1);
			}
		}	
		return producto;
	}

	public Producto create(Producto producto) throws DuplicatedException, GenericException{
		
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		//String sql = "INSERT INTO productos (titulo,precio,codigo, id_tipo_producto) "
		//+ "VALUES ('" + producto.getTitulo() + "' , '" + producto.getPrecio() + "','" + producto.getCodigo() + "','" + producto.getTipoProducto() + "')";
		String sql ="INSERT INTO productos (titulo,precio,codigo, id_tipo_producto) " + "VALUES (?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, producto.getTitulo());
			statement.setFloat(2, producto.getPrecio());
			statement.setString(3, producto.getCodigo());
			statement.setLong(4, producto.getTipoProducto());
			
			statement.execute();

			ResultSet resultSet = statement.getGeneratedKeys();

			if (resultSet.next()) {
				Long pk = resultSet.getLong(1);
				producto.setId(pk);
			}else {
				throw new GenericException("No se ha podido obtener el id generado",null);
			}

			statement.close();
		} catch (SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("Clave duplicada, no se ha registrado el producto", e);
			}
			throw new GenericException("No se ha podido crear el producto", e);
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new GenericException("Problema cerrando la conexion, verifique la base de datos", e);
			}
		}
		return producto;
		
	}
	
	//construye un producto desde el resultset
 	private Producto productoFromResultSet(ResultSet resultSet) throws SQLException {
		Producto producto;
		Long id = resultSet.getLong(1);	//id
		String titulo = resultSet.getString(2);	//titulo
		Float precio = resultSet.getFloat(3);	//precio
		String codigo = resultSet.getString(4);	//codigo
		Long tipoProducto = resultSet.getLong(5);	//id_tipo_producto
		
		//necesito una clase para contener los registros recuperados de la consulta
		producto = new Producto(id,titulo,precio,codigo,tipoProducto);
		return producto;
	}

	@Override
	public Collection<Producto> findAllByTitulo(String titulo) throws GenericException {
		
		Collection<Producto> productos = new ArrayList<Producto>();// Defino una coleccion para la devolucion del
		// metodo
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		String sqlSelect = "select * from productos where upper(titulo) like '%" + titulo +"% '";//armamos la sentencia sql correspondiente a select
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlSelect);// creacion de un statement
			//setear los parametros
			//8statement.setString(1, titulo);
			ResultSet resultSet = statement.executeQuery();// ahora debemos simular la ejecucion de la
																	// sentencia pulsando el boton derecho
																	// ResulSet devuelve una coleccion con los registros
																	// recuperados, se debe recorrer
			while (resultSet.next()) { // para varios registros
				Producto producto = productoFromResultSet(resultSet);
				productos.add(producto);// cargamos el producto generado con los registros dentro de la coleccion
			}

			statement.close(); // cerramos el statement
			return productos;	//retornamos la coleccion como indica el metodo
		} catch (SQLException e) {
			throw new GenericException ("No se ha podido crear el producto",e);
		}finally {
			try {
				connection.close();
			}catch(SQLException e1) {
				throw new GenericException("Problema cerrando la conexion, verifique en la base de datos",e1);
			}
		}
		
	}
}
