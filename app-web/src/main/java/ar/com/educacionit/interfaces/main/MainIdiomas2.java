package ar.com.educacionit.interfaces.main;


import ar.com.educacionit.exceptions.checked.NoSabeException;
import ar.com.educacionit.interfaces.IIdioma;
import ar.com.educacionit.interfaces.entidades.Persona;
import ar.com.educacionit.interfaces.impl.Chino;
import ar.com.educacionit.interfaces.impl.Espanol;
import ar.com.educacionit.interfaces.impl.Ingles;

public class MainIdiomas2 {

	public static void main(String[] args) {

		IIdioma chino = new Chino();
		Persona carlos = new Persona("carlos", "lopez", chino);
		
		carlos.decir("hola");
		
		IIdioma ingles = new Ingles();
		carlos.aprender(ingles);
		carlos.aprender(chino);
		
		try {
			carlos.traducir("hola", chino, ingles);
		}catch(NoSabeException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Finally se ejecuta siempre");
		}
			
		System.out.println("Fin del programa");
		
		

	}

}
