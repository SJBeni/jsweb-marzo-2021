package ar.com.educacionit.clase4.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapaWrapperMain3 {

	public static void main(String[] args) {

		//crea
		Map<Integer, String> diasSemana = new HashMap<>();
		
		//carga
		diasSemana.put(1, "Lunes");
		diasSemana.put(2, "Martes");
		diasSemana.put(2, "Martes");	//No puedo agregar duplicados por clave
		diasSemana.put(3, "Miercoles");
		diasSemana.put(4, "Jueves");
		diasSemana.put(5, "Viernes");
		diasSemana.put(6, "Sabado");
		diasSemana.put(7, "Domingo");
		
		//obtengo solo los valores del mapa
		Collection<String> valores = diasSemana.values();
		
		for(String valor : valores) {
			System.out.println(valor);
		}
		
	}

}
