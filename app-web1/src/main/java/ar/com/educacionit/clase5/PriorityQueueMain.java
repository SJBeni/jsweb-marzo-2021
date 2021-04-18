package ar.com.educacionit.clase5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueMain {

	public static void main(String[] args) {

		//wrapper!!
		PriorityQueue<Cliente> clientes = new PriorityQueue<>();
		
		//carga
		System.out.println("Ingrese la cantidad de clientes: ");
		Scanner teclado = new Scanner(System.in);
		
		Integer cantidad = teclado.nextInt();
		
		//proceso de carga de datos
		System.out.println("Hay " + clientes.size() + " clientes");
		for(int i=0; i<cantidad;i++) {
			
			System.out.println("Ingrese Nombre: ");
			String nombre = teclado.next();
			
			System.out.println("Ingrese Edad: ");
			Integer edad = teclado.nextInt();
			
			Long id = Long.parseLong("" + i);
			
			Cliente cliente = new Cliente(id, nombre, edad, (i==2));
			clientes.offer(cliente);
		}
		
		//System.out.println(clientes);
		//recorremos la queue con los metodos propios, obviando toString()
		while(!clientes.isEmpty()) {
			Cliente cliente = clientes.poll();
			System.out.println(cliente);
		}
		teclado.close();
		
	}

}
