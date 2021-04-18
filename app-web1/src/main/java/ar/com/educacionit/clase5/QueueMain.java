package ar.com.educacionit.clase5;

import java.util.LinkedList;

public class QueueMain {

	public static void main(String[] args) {
		//Basado en estructuras FIFO (colas)
		
		//ejemplo mas simple
		LinkedList<String> nombres = new LinkedList<>();
		
		nombres.add("carlos");	//corresponde a collections
		
		//metodos propios de Queue
		nombres.offer("Sergio");
		nombres.offerFirst("Francisco");
		
		System.out.println("La fila esta compuesta por: " + nombres);
		
		while(!nombres.isEmpty()) {
			//Estas lineas simulan la pregunta en un cola sobre quien sigue?
			String siguienteNombre = nombres.peek();
			System.out.println("El siguiente es: " + siguienteNombre);
			
			//Ahora vamos a simular la atencion de la persona
			//el metodo a usar obtiene el elemento y lo elimina de la cola
			siguienteNombre = nombres.poll();
			System.out.println(siguienteNombre + " atendido!");
		}
		
		System.out.println("Fila Vacia!");
	}

}
