package ar.com.educacionit.clase4.collections;

import java.util.HashSet;

public class SetMain {

	public static void main(String[] args) {

		//creacion
		HashSet <Integer> edades = new HashSet<>();
		
		//cargar
		boolean agrego = edades.add(1);
		
		if(agrego) {
			System.out.println("1 agregado");
		}
		
		agrego = edades.add(1);
		
		if(agrego) {
			System.out.println("1 agregado");
		}else {
			System.out.println("1 no se agrego");
				
		}

		//agregar varias edades
		
		edades.add(10);
		edades.add(20);
		edades.add(30);
		
		//recorrer un set
		for(Integer edad : edades) {
			System.out.println(edad);
		}
		
		//cantidad de elementos
		System.out.println("Hay " + edades.size() + " edades");
		
		
		//remover un elemento
		boolean elimino = edades.remove(30);
		System.out.println("30 " + (elimino ? "se ha eliminado" : "no se ha eliminado"));
		
		
		//verificamos el cambio en la dimension
		System.out.println("Hay " + edades.size() + " edades");
		
		//vaciar el set
		edades.clear();
		
		//verificamos el cambio en la dimension
		System.out.println("Hay " + edades.size() + " edades");
		
		//Final
		System.out.println("Fin");
		
		
		
		
	}

}
