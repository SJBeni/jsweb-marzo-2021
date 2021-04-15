package ar.com.educacionit.clase4.maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import ar.com.educacionit.clase2.Auto;

public class LinkedHashMapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ojo que debe implementar comparable la clave del Map
		//crear
		Map<Auto,Integer> autosMap = new LinkedHashMap<>();
		
		Auto auto = new Auto("renault","clio","azul",220);
		autosMap.put(auto,1);
		
		auto = new Auto("ford","fiesta","azul",220);
		autosMap.put(auto,0);
		
		auto = new Auto("chery","tigo","azul",220);
		autosMap.put(auto,-5);
		
		System.out.println(autosMap);
		
	}

}
