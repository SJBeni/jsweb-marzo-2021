package ar.com.educacionit.clase4.generics;


public class GenericParsableMain {

	public static void main(String[] args) {

		ClaseHija claseHija = new ClaseHija("hola");
		IParseable<Long> parseableLong = claseHija.crearALgo();
		
		claseHija.saludar();
		
		Long longV = parseableLong.parse();
	}

}
