package ar.com.educacionit.interfaces.impl;

import ar.com.educacionit.interfaces.IIdioma;

public class Chino implements IIdioma {

	@Override
	public void decir(String palabra) {
		System.out.println("En Chino " + palabra);

	}

}
