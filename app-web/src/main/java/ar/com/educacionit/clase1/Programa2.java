package ar.com.educacionit.clase1;

public class Programa2 {

	public static void main(String[] args) {
		//operadores relacionales
		//<,>,==,!=
		//a>b
		
		float alturaMia = 174;
		float otraAltura = 174.1f;
		
		//OBS: por defecto, en java, los valores con decimales, son del tipo double
		
		if(alturaMia > otraAltura) {
			System.out.println("Soy mas alto");
		}else if(alturaMia == otraAltura) {
			System.out.println("Somos de la misma altura");
		}else {
			System.out.println("Soy mas bajo");
		}

	}

}
