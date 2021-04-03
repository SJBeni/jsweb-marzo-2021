package ar.com.educacionit.clase3;

public class AtributoClaseMain {

	public static void main(String[] args) {
		
		//Clase.Atributo --> asi se accede a un atributo de clase
		String tipoA = Articulo.tipo;
		System.out.println(tipoA);
		
		Libro l = new Libro("TONY STAR IRON MAN 01: UN...","SCOT DAN",830f,"9786076343043","PANINI");
		//atributo de instancia / metodo de instancia
		//Objeto.atributo / Objeto.metodo
		String tipoL = l.tipo;
		System.out.println(tipoL);
		
		//Cambiamos el valor del atributo de clase
		Articulo.tipo = "RESULTADO";
		
		Pasatiempo p = new Pasatiempo("IRON MAN 15 CENTIMETROS -",1117.99f,"HASBRO","630509294756");
		
		String tipoP = p.tipo;
		System.out.println(tipoP);
		
		//Verificamos nuevamente el tipoL
		tipoL = l.tipo;
		System.out.println(tipoL);
		


	}

}
