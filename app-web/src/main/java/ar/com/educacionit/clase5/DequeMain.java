package ar.com.educacionit.clase5;

import java.util.Deque;
import java.util.LinkedList;

public class DequeMain {

	public static void main(String[] args) {
		
		
		Deque<String> nombres = new LinkedList<>();
		
		nombres.add("carlos");	//collection
		
		//metodos propios de la Queue
		nombres.offer("Sergio");
		nombres.offerFirst("Francisco");
		
		while(!nombres.isEmpty()) {
			String siguienteNombre = nombres.peek();
			System.out.println("El siguiente es: " + siguienteNombre);
			
			//quitamos de la lista
			siguienteNombre = nombres.poll();
			System.out.println(siguienteNombre + " Atendido!");
		}
		
		System.out.println("Fila vacia");
	}

}
