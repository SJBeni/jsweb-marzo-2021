package ar.com.educacionit.clase1;

public class Programa1 {

	public static void main(String[] args) {
		//comentario
		
		//sumar dos numeros y mostrar su valor
		
		//definir una variable
		//tipo_dato nombre
		int valor1;	//definir una variable
		valor1 = 10;	//asignando un valor a la variable valor1
		
		int valor2 = 10;	//definir y asignar - sintaxis
		
		
		//operadores MATEMATICOS -,+,*,/,%
		int resultado = valor1 + valor2;  
		
		//estructura de control de flujo IF/ELSE
		//operador de negacion !
		if (valor2 != 0) {
			float resDiv = valor1 / valor2;
			System.out.println(resDiv);
		}else {
			System.out.println("No se puede dividir por 0");
		}
	}

}
