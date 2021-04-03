package ar.com.educacionit.exceptions;

import ar.com.educacionit.interfaces.IIdioma;
import ar.com.educacionit.interfaces.impl.Espanol;
import ar.com.educacionit.interfaces.impl.Ingles;

public class PadresHijosExceptions {

	public static void main(String[] args) {
		
		IIdioma espanol = new Espanol();
		IIdioma e = new Espanol();
		IIdioma i = new Ingles();
		
		IIdioma unIdioma = (Espanol)i;
		
		unIdioma.decir("palabra");
		
	}

}
