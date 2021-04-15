package ar.com.educacionit.clase2;

//nombre de la clase
public class Auto implements Comparable<Auto>{
	//atributos
	private String marca;
	private String modelo;
	private String color;
	private int anio;
	private float velocidad;
	private float velocidadMaxima;
	private float combustible;
	private boolean encendido;
	
	//constructor, por defecto, no tiene parametros
	public Auto(){
		//inicializar ciertos atributos de un objeto
		encendido = false;
		combustible = 0;
		anio = 2021;
		velocidad = 0;
		velocidadMaxima = 250;
	}
	
	//constructor parametrizado
	public Auto(String marca, String modelo, String color, float velocidadMaxima){
		encendido = false;
		combustible = 0;
		anio = 2021;
		velocidad = 0;
		this.velocidadMaxima = velocidadMaxima;
		this.color = color;
		this.modelo = modelo;
		this.marca = marca;
	}
	
	//metodos
	public void encender() {
		if(!encendido) {
			encendido = true;
			System.out.println("Se ha encendido el auto");
		}else {
			System.out.println("Auto Encendido");
		}
	}
	
	public void apagar() {
		if(encendido) {
			encendido = false;
			System.out.println("Se ha apagado el auto");
		}else {
			System.out.println("Auto Apagado");
		}
		
	}
	
	public void acelerar() {
		if(encendido) {
			if(velocidad < velocidadMaxima) {
				if(combustible > 0) {
					velocidad++;
					combustible--;
				}else {
					System.out.println("No hay mas combustible");
				}
			}else {
				System.out.println("Ha llegado a Velocidad Maxima");
			}
		}
	}
	
	public float obtenerVelocidad() {
		return velocidad;
	}
	
	public void informarEstado() {
		System.out.println("Marca:" + this.marca);
		System.out.println("Modelo:" + this.modelo);
		System.out.println("Año:" + this.anio);
		System.out.println("Color:" + this.color);
		System.err.println("Encendido:" + this.encendido);
		System.out.println("Velocidad:" + this.velocidad);
		System.out.println("Velocidad Maxima:" + this.velocidadMaxima);
		System.out.println("Combustible:" + this.combustible);
	}
	
	//getters/setters
	public void setMarca (String marca) {
		if(marca != null) {
			this.marca = marca.toUpperCase();
		}else {
			System.out.println("Marca no puede ser null");
		}
	}
	
	public String getMarca() {
		return this.marca;
	}

	@Override
	public int compareTo(Auto o) {
		return this.marca.compareTo(o.getMarca());
	}

	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", anio=" + anio + "]";
	}
	
	
}
