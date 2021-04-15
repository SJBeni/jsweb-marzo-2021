package ar.com.educacionit.clase4.collections;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<String> nombres = new LinkedHashSet<>();
		
		nombres.add("Fernando");
		nombres.add("Francisco");
		nombres.add("Leonardo");
		nombres.add("Sebastian");
		nombres.add("Oliden");
		
		//realizamos un eliminacion
		nombres.remove("Sebastian");
		
		
		Iterator<String> itNombres = nombres.iterator();
		while(itNombres.hasNext()) {
			String nombre = itNombres.next();
			System.out.println(nombre);
		}
		
		
		
	}

}
