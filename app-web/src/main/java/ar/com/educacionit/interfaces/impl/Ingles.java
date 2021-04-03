package ar.com.educacionit.interfaces.impl;

import ar.com.educacionit.interfaces.IIdioma;

public class Ingles implements IIdioma {

	@Override
	public void decir(String palabra) {
		System.out.println("In English " + palabra);

	}

}
