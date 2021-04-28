package ar.com.educacionit.web.controller.console;

import java.io.IOException;
import java.util.Collection;

import ar.com.educacionit.domain.Producto;

public interface IFileWritter {

	void write(String name, Collection<Producto> productos) throws IOException;
}
