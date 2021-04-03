package ar.com.educacionit.clase3;

public class Pasatiempo extends Articulo {

	//atributos
	private String marca;
	private String codigo;
	
	//Constructores
	public Pasatiempo(String titulo, String autor, Float precio, String marca, String codigo) {
		super(titulo, autor, precio);
		inicializar(marca, codigo);
	}

	public Pasatiempo(String titulo, Float precio, String marca, String codigo) {
		super(titulo, precio);
		inicializar(marca, codigo);
	}
	
	private void inicializar(String marca, String codigo) {
		this.marca = marca;
		this.codigo = codigo;
	}

	
	@Override
	public void displayHijo() {
		System.out.println("PASATIEMPO");
		System.out.println("Marca: " + this.marca);
		System.out.println("Codigo: " + this.codigo);
	}
	
	//metodos get y set
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	

	
}
