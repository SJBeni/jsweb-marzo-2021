package ar.com.educacionit.clase4.maps;

import java.util.HashMap;
import java.util.Map;

public class MapaWrapperMain {

	public static void main(String[] args) {

		//crea
		Map<Integer, String> diasSemana = new HashMap<>();
		
		//carga
		diasSemana.put(1, "Lunes");
		diasSemana.put(2, "Martes");
		diasSemana.put(3, "Miercoles");
		diasSemana.put(4, "Jueves");
		diasSemana.put(5, "Viernes");
		diasSemana.put(6, "Sabado");
		diasSemana.put(7, "Domingo");
		
		//como obtener un dia de la semana
		//metodo get(K):V
		if(diasSemana.containsKey(5)) {
			String dia = diasSemana.get(8);
			System.out.println(dia);
		}
		
		//eliminar un elemento del mapa
		//metodo contains(K): boolean
		//metodo removeKey(K)
		//metodo removeValue(K)
		String diaEliminado = diasSemana.remove(7);
		
		//eliminar por clave y valor
		boolean diaEliminadoPorClaveYValor = diasSemana.remove(4, "Jueves");
		
		System.out.println(diasSemana);
		
		
		
	}

}
