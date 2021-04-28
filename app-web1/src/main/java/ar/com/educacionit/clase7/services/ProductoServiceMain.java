package ar.com.educacionit.clase7.services;

import java.util.Collection;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ProductoServicesImpl;

public class ProductoServiceMain {

	public static void main(String[] args) throws ServiceException {
		
		//ProductoDAO pDao = new ProductoDAOJdbcImpl();
		//pDao.findAll();
		
		ProductoServices ps = new ProductoServicesImpl();
		Collection<Producto> productos = ps.findAll();
		
		System.out.println(productos);

	}

}
