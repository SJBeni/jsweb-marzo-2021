package ar.com.educacionit.clase1;

public class Programa4 {

	public static void main(String[] args) {
		//vectores
		
		//Generar un vector con los alumnos del curso
		
		//13 variables de tipo String
		String carlos = "carlos";
		String analia = "analia";
		String mariano = "mariano";
		
		//defino un vector (array) de String
		String[] alumnos = new String[3];
		
		//cargar valores
		alumnos[0] = carlos;
		alumnos[1] = analia;
		alumnos[2] = mariano;
		
		//recorrer un vector
		for(int i=0; i<alumnos.length; i++) {
			System.out.println(alumnos[i]);
		}

		//otro ejemplo
		boolean[] mayores20 = new boolean[6];
		
		//recorrido usando for each
		for(boolean aux : mayores20) {
			aux = true;
		}
		for(int i=0; i < mayores20.length; i++) {
			mayores20[i] = true;
		}
		
	}

}
