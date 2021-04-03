package ar.com.educacionit.clase3;

public class CasteoMain {

	public static void main(String[] args) {
		//byte < short < int < long < float < double
		
		byte b = 1;
		short s = 10;
		int a = 20;
		
		long aux = b;	//casteo implicito
		aux = s;
		aux= a;
		
		//casteo explicito
		a = (int) aux; 	//perdida de informacion
		
		float f = 150.36f;
		double x = f;

	}

}
