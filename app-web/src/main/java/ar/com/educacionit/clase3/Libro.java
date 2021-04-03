package ar.com.educacionit.clase3;

public class Libro extends Articulo {
	
	//atributos
	private String isbn;
	private String editorial;
	
	//El constructor tiene que llamar al constructor del padre
	public Libro(String titulo, Float precio, String isbn, String editorial) {
		//tiene que nacer el padre
		super(titulo,precio);	//llama al constructor de la clase padre
		
		//seteo los atributos de la clase hijo
		inicializar(isbn, editorial);
	}
	
	public Libro(String titulo, String autor, Float precio, String isbn, String editorial) {
		super(titulo, autor, precio);
		
		inicializar(isbn, editorial);
	}
	

	private void inicializar(String isbn, String editorial) {
		this.editorial = editorial;
		this.isbn = isbn;
	}  
	
	@Override
	public void displayHijo() {
		System.out.println("LIBRO");
		System.out.println("ISBN: " + this.isbn);
		System.out.println("Editorial: " + this.editorial);
	}
	
	//metodos get y set
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}


	
	
}
