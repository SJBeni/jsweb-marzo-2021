package ar.com.educacionit.clase3.laboratorio;

import java.util.Scanner;

public class LaboratorioMain {

	public static void main(String[] args) {

		Persona[] personas = DataEntry.cargarPersonas();
		
		for(Persona persona : personas) {
			System.out.println(persona);
		}

	}

}
