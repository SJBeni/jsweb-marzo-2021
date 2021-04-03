package ar.com.educacionit.clase3;

public class CasteoObjetosMain {

	public static void main(String[] args) {

		Articulo articulo = new Libro("TONY STAR IRON MAN 01: UN...","SCOT DAN",830f,"9786076343043","PANINI");
		
		//esto se denomina down casting: voy de clase padre a clase hijo
		articulo.getAutor();
		articulo.getPrecio();
		articulo.getTitulo();
		
		//casteo entre clases
		Libro libro = (Libro)articulo;
		libro.getIsbn();
		libro.getEditorial();
		
		//------------------------
		//Musica musica = (Musica)articulo;	//no se puede, no hay referencia
		}

}
