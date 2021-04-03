package ar.com.educacionit.clase1;

public class Programa3 {

	public static void main(String[] args) {
		//operadores logicos
		//&& es AND
		//|| es OR
		//^ es XOR (OR Exclusiva)
		//! operador negacion (NOT)
		
		//uso de operador negacion
		boolean hoyEsSabado = true;
		hoyEsSabado = !hoyEsSabado;
		
		//Uso de operador XOR
		boolean c = false;
		boolean d = true;
		
		boolean xor = c ^ d;	//esto deberia arrojar true
		System.out.println(xor);

	}

}
