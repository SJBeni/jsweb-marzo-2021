package ar.com.educacionit.clase4.generics;

public abstract class ClaseBase<T> {
	//Atributos
	private String saludo;
	
	//constructor
	public ClaseBase(String saludo) {
		this.saludo = saludo;
	}
	
	public void saludar() {
		System.out.println(saludo);
	}

	public abstract T crearALgo();
}
