package ar.com.educacionit.interfaces;

public interface IIdioma {
	
	public void decir(String palabra);
		
	public default void noseDecir(String palabra) {
		System.out.println("no se decir..." + palabra);
	}
}
