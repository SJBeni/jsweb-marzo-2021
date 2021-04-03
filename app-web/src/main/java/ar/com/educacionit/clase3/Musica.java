package ar.com.educacionit.clase3;

import java.util.Arrays;

public class Musica extends Articulo {
	
	//atributos
	private String sello;
	private String[] temas;
	
	//constructores
	public Musica(String titulo, String autor, Float precio, String sello, String[] temas) {
		super(titulo, autor, precio);
		inicializar(sello, temas);
	}

	public Musica(String titulo, Float precio, String sello, String[] temas) {
		super(titulo, precio);
		inicializar(sello, temas);
	}
	
	private void inicializar(String sello, String[] temas) {
		this.sello = sello;
		this.temas = temas;
	}

	public void displayHijo() {
		System.out.println("MUSICA");
		System.out.println("Sello: " + this.sello);
		System.out.println("Temas: " + Arrays.toString(this.temas));
	}
	//metodos get y set
	public String getSello() {
		return sello;
	}

	public void setSello(String sello) {
		this.sello = sello;
	}

	public String[] getTemas() {
		return temas;
	}

	public void setTemas(String[] temas) {
		this.temas = temas;
	}

	

}
