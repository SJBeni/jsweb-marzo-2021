package ar.com.educacionit.clase4.collections;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain2 {

	public static void main(String[] args) {

		//creacion
		HashSet <Integer> edades = new HashSet<>();
		
		//carga
		edades.add(10);
		edades.add(20);
		edades.add(30);
		
		/*
		//eliminar uno por uno
		for(Integer i : edades) {
			edades.remove(i);
		}
		
		*/
		/*
		while(!edades.isEmpty()) {
			edades.remove(edades);
		}
		*/
		//metodo contains
		boolean contiene = edades.contains(40);
		System.out.println("Edades: " + (contiene ? "Contiene al 40" : "No contiene al 40"));
		contiene = edades.contains(30);
		System.out.println("Edades: " + (contiene ? "Contiene al 30" : "No contiene al 30"));
		
		
		//Forma basica y segura de eliminar elementos de una coleccion
		Iterator<Integer> itEdades = edades.iterator();
		while(itEdades.hasNext()) {
			Integer valor = itEdades.next();
			itEdades.remove();
		}
		System.out.println("FIN");
	}


}
