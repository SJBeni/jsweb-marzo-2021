package ar.com.educacionit.clase4.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMain {

	public static void main(String[] args) {

		TreeSet<Integer> alturas = new TreeSet<>();
		
		alturas.add(172);
		alturas.add(173);
		alturas.add(170);
		alturas.add(169);
		alturas.add(171);
		
		//Orden que deberia mostrar 169 170 171 172 173
		System.out.println(alturas);
		
		//java11 ----> opcion de creacion mas sencilla 
		Set<String> nombres2 = Set.of("Fernando", "Leonardo", "Sebastian", "Carlos", "Oliden", "Francisco");
		//LinkedHashSet<String> nombresLHS = new LinkedHashSet<>(nombres2);
		HashSet<String> nombresHash = new HashSet<>(nombres2);	//Orden impredecible
		TreeSet<String> nombres = new TreeSet<>(nombres2);	//Aseguramos el orden, esta implementado Comparable
		
		//System.out.println(nombresLHS);
		System.out.println(nombresHash);
		System.out.println(nombres);
		
	}

}
