package ar.com.educacionit.interfaces.entidades;

import ar.com.educacionit.exceptions.checked.NoSabeException;
import ar.com.educacionit.interfaces.IIdioma;

public class Persona {
	
	//atributos
	private String nombre;
	private String apellido;
	
	private IIdioma idiomaNativo;
	private IIdioma[] idiomas;
	
	
	//constructor
	public Persona(String nombre, String apellido, IIdioma idiomaNativo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.idiomaNativo = idiomaNativo;
		this.idiomas = new IIdioma[0];
	}
	
	public void aprender(IIdioma nuevoIdioma) {
		
		//hay que controlar que el nuevo idioma no este en la lista actual
		IIdioma[] actuales = new IIdioma[this.idiomas.length + 1];
		int i=0;
		for(IIdioma idiomaQueSabe : this.idiomas) {
			actuales[i++] = idiomaQueSabe;
		}
		actuales[i] = nuevoIdioma;
		this.idiomas = actuales;	//actualizamos el vector idiomas con el nuevo idioma cargado
		
	}
	
	public void decir(String palabra) {
		this.idiomaNativo.decir(palabra);
	}
	
	public void decir(String palabra, IIdioma unIdioma) throws NoSabeException {
		//tenemos que saber que idiomas pertenecen a la lista
		//hacemos un control con for each
		
		boolean sabeEseIdioma = false;
		for(IIdioma idiomaQueSabe : this.idiomas) {
			if(idiomaQueSabe.equals(unIdioma)) {
				sabeEseIdioma = true;
				break;
			}
		}
		if(sabeEseIdioma) {
			unIdioma.decir(palabra);
		}else {
			//unIdioma.noseDecir(palabra);
			throw new NoSabeException(this.nombre + " - " + this.apellido + " , " + palabra);
		}
	}
	
	public void traducir(String texto, IIdioma origen, IIdioma destino) throws NoSabeException, Exception {
		boolean sabeIdiomaOrigen = false;
		boolean sabeIdiomaDestino = false;
		
		for(IIdioma idiomaQueSabe : this.idiomas) {
			if(idiomaQueSabe.equals(origen)) {
				sabeIdiomaOrigen = true;
			}
			if(idiomaQueSabe.equals(destino)) {
				sabeIdiomaDestino = true;
			}
		}
		if(sabeIdiomaDestino) {
			if(sabeIdiomaOrigen) {
				System.out.println("sabe los dos idiomas");
			}else {
				throw new Exception("No sabe " + origen.getClass().getCanonicalName());
			}
		}else {
			throw new NoSabeException("No sabe ambos idiomas");
		}
	}
	
	
	
}
