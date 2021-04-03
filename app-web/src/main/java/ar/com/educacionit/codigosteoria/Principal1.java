package ar.com.educacionit.codigosteoria;

public class Principal1 {

	public static void main(String[] args) {
		//Variables Primitivas en JAVA
		
		/**
		 * Numericos Enteros
		 */
		//byte: 8 bits de almacenamiento | valores en el rango [-128,127]
		byte miByte = 5;
		System.out.println("miByte = " + miByte);
		
		//short: 2 bytes de almacenamiento | valores en el rango [-32768,32767]
		short miShort = 12596;
		System.out.println("miShort = " + miShort);
		
		//int: 4 bytes de almacenamiento | valores en el rango [-2E31,(2E31)-1]
		int miInt = 10;
		System.out.println("miInt = " + miInt);
		
		//long: 8 bytes de almacenamiento | valores en el rango [-2E63,(2E63)-1]
		long miLong = 1000000000;
		System.out.println("miLong = " + miLong);
		
		/**
		 * Numericos de punto flotante
		 */
		
		//float: 4 bytes de almacenamiento | valores en el rango [1.4E-45,3.4028235E38]
		float miFloat = 10.58f;
		System.out.println("miFloat = " + miFloat);
		
		//double: 8 bytes de almacenamiento | valores en el rango [4.9E-324,1.7976931348623157E308]
		double miDouble = 10.58;
		System.out.println("miDouble = " + miDouble);
		
		/**
		 * Booleanos y caracteres
		 */
		
		//boolean: 1 byte de almacenamiento | valores posibles [true,false]
		boolean miBoolean = false;
		System.out.println("miBoolean = " + miBoolean);
		
		//char: 2 bytes de almacenamiento | valores posibles [caracteres simples]
		char miChar = 'P';
		System.out.println("miChar = " + miChar);
		
		/**
		 * Datos Estructurados
		 */
		
		//String: cadena de caracteres
		String miString = "Hola Mundo";
		System.out.println("miString = " + miString);
		
		/**
		 * Constantes
		 */
		/**
		 * Un vez asignado el valor inicial no se puede cambiar durante la ejecucion
		 * del programa
		 * simplemente se usan todos los tipos de variables anteponiendo la plalabra
		 * reservada final
		 */
		
		final String VERSION = "Version 1.0";
		System.out.println("VERSION = " + VERSION);
		
		final double IVA = 21.0;
		System.out.println("IVA = " + IVA);
		
	}

}
