package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Producto;

public class ConnectionMainTest {

	public static void main(String[] args) throws Exception {
		
		//comentario para actualizar branch 7
		System.out.println("Instanciando conexion");
		Connection connection = AdministradorDeConexiones.obtenerConexion();
		
		
		System.out.println("Creando producto");
		Producto p = new Producto("test",1000f,"test2",1L);
		createProducto(connection, p);
		System.out.println("------------------------------------------");
		
		
		
		//ejecutamos la consulta select
		System.out.println("Consultando registros en la base de datos");
		Collection<Producto> productos = selectAll(connection);
		
		//recorrer la coleccion
		Long id = null;
		for(Producto producto: productos) {
			System.out.println(producto);
			id = producto.getId();	//me quedo con el ultimo id
		}
		
		//ejecutamos un select where id
		System.out.println("------------------------------------------");
		Producto producto = selectById(connection,id);
		System.out.println("Producto con id = " + id + " - " + producto);
		
		//ejecutamos un select where codigo
		System.out.println("------------------------------------------");
		producto = selectByCodigo(connection, producto.getCodigo());
		System.out.println("Producto con codigo = " + producto.getCodigo() + " - " + producto);
		
		System.out.println("------------------------------------------");
		producto.setPrecio(producto.getPrecio()*1.1f);
		producto = updateProducto(connection, producto.getId(), producto);
		System.out.println("Se ha actualizado el producto id:" + producto.getId());
		
		System.out.println("Consultando registros en la base de datos");
		productos = selectAll(connection);
		//recorrer la coleccion
		for(Producto productoAux: productos) {
			System.out.println(productoAux);
		}

		System.out.println("------------------------------------------");
		producto = deleteProducto(connection, id);
		System.out.println("Se ha eliminado el producto con id: " + producto.getId());
		
		//cerramos la conexion a la db
		connection.close();
		System.out.println("Conexion exitosa");
		
	}

	public static Collection<Producto> selectAll(Connection connection) throws Exception {
		
		//armamos la sentencia sql correspondiente a select
		String sqlSelect = "select * from productos";
		
		//creacion de un statement
		Statement statement = connection.createStatement();
		
		//ahora debemos simular la ejecucion de la sentencia pulsando el boton derecho
		//ResulSet devuelve una coleccion con los registros recuperados, se debe recorrer
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		//Defino una coleccion para la devolucion del metodo
		Collection<Producto> productos = new ArrayList<Producto>();
		
		//if(resultSet.next()) {	//si encontro registros en el set para un unico registro
		while(resultSet.next()) {	//para varios registros
			Producto producto = productoFromResultSet(resultSet);
			//cargamos el producto generado con los registros dentro de la coleccion
			productos.add(producto);
		}
		
		statement.close();	//cerramos el statement
		
		return productos;	//retornamos la coleccion como indica el metodo
	}
	
	public static Producto selectById(Connection connection, Long idProducto) throws Exception {
		
		//armamos la sentencia sql correspondiente a select
		String sqlSelect = "select * from productos where id = " + idProducto;
		
		//creacion de un statement
		Statement statement = connection.createStatement();
		
		//ahora debemos simular la ejecucion de la sentencia pulsando el boton derecho
		//ResulSet devuelve una coleccion con los registros recuperados, se debe recorrer
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		//Defino una coleccion para la devolucion del metodo
		Producto producto = null;
		
		if(resultSet.next()) {	//si encontro registros en el set para un unico registro
		producto = productoFromResultSet(resultSet);
			
			//cargamos el producto generado con los registros dentro de la coleccion
			//productos.add(producto);
		}
		
		statement.close();	//cerramos el statement
		
		return producto;	//retornamos la coleccion como indica el metodo
	}
	
	public static Producto selectByCodigo(Connection connection, String codigoProducto) throws Exception {
		
		//armamos la sentencia sql correspondiente a select
		String sqlSelect = "select * from productos where codigo = '" + codigoProducto + "'";
		
		//creacion de un statement
		Statement statement = connection.createStatement();
		
		//ahora debemos simular la ejecucion de la sentencia pulsando el boton derecho
		//ResulSet devuelve una coleccion con los registros recuperados, se debe recorrer
		ResultSet resultSet = statement.executeQuery(sqlSelect);
		
		//Defino una coleccion para la devolucion del metodo
		Producto producto = null;
		
		if(resultSet.next()) {	//si encontro registros en el set para un unico registro
		//while(resultSet.next()) {	//para varios registros
			producto = productoFromResultSet(resultSet);
			
			//cargamos el producto generado con los registros dentro de la coleccion
			//productos.add(producto);
		}
		
		statement.close();	//cerramos el statement
		
		return producto;	//retornamos la coleccion como indica el metodo
	}

	public static Producto updateProducto(Connection connection, Long idProducto, Producto producto ) throws Exception{
		
		Producto productoBuscador = selectById(connection, idProducto);
		
		if(productoBuscador == null) {
			throw new Exception("No existe el producto id: "+ idProducto);
		}
		
		//armamos la sentencia sql correspondiente a update
		String sqlSelect = "Update productos " 
							+ "set titulo = '" + producto.getTitulo() + "' ,"
							+ "precio = '" + producto.getPrecio() + "' ,"
							+ "id_tipo_producto = '" + producto.getTipoProducto() + "'"
							+ "where id = '" + idProducto + "'";
				
		Statement statement = connection.createStatement();
				
		int updated = statement.executeUpdate(sqlSelect);
			
		statement.close();	//cerramos el statement
		
		if(updated != 1) {	
				throw new Exception ("No se ha podido modificar los datos del producto id " + idProducto);
		}
		
		producto = selectById(connection, idProducto);
				
		return producto;	//retornamos la coleccion como indica el metodo	
	}
	
	public static Producto deleteProducto(Connection connection, Long id) throws Exception{
		
		Producto productoBuscado = selectById(connection, id);
		
		if(productoBuscado == null) {
			throw new Exception("No existe el producto id: "+ id);
		}
		
		String sql="DELETE FROM PRODUCTOS WHERE ID =" + id;
		
		Statement statement = connection.createStatement();
		int deleted = statement.executeUpdate(sql);
		
		statement.close();
		
		if(deleted != 1) {
			throw new Exception("No se ha podido eliminar el producto con id: " + id);
		}
		
		return productoBuscado;
		
		
	}

	public static Producto createProducto(Connection connection, Producto producto) throws Exception{
		
		String sql = "INSERT INTO productos (titulo,precio,codigo, id_tipo_producto) "
		+ "VALUES ('" + producto.getTitulo() + "' , '" + producto.getPrecio() + "','" + producto.getCodigo() + "','" + producto.getTipoProducto() + "')";
		
		PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		statement.execute();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		
		if(resultSet.next()) {
			Long pk = resultSet.getLong(1);
			producto.setId(pk);
		}else {
			throw new Exception("No se ha podido obtener el id generado");
		}
		
		statement.close();
		return producto;
		
	}
	
	//construye un producto desde el resultset
 	private static Producto productoFromResultSet(ResultSet resultSet) throws SQLException {
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
}
