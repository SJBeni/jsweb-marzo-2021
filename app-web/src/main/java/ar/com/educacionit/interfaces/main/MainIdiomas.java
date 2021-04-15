package ar.com.educacionit.interfaces.main;


import ar.com.educacionit.exceptions.checked.NoSabeException;
import ar.com.educacionit.interfaces.IIdioma;
import ar.com.educacionit.interfaces.entidades.Persona;
import ar.com.educacionit.interfaces.impl.Espanol;
import ar.com.educacionit.interfaces.impl.Ingles;

public class MainIdiomas {

	public static void main(String[] args) {

		IIdioma espanol = new Espanol();
		Persona carlos = new Persona("carlos", "lopez", espanol);
		
		carlos.decir("hola");
		
		IIdioma ingles = new Ingles();
		carlos.aprender(ingles);
		
		
		try {
			carlos.traducir("hola", espanol, ingles);
		}catch(NoSabeException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Finally se ejecuta siempre");
		}
			
		System.out.println("Fin del programa");
		
		

	}

}
