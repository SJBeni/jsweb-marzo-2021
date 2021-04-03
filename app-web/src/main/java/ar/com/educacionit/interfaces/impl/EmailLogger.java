package ar.com.educacionit.interfaces.impl;

import ar.com.educacionit.interfaces.ILogger;

public class EmailLogger implements ILogger{

	//atributos
	private String destinatario;
	private String msj;
	
	//constructor
	public EmailLogger() {
		
	}
	
	public EmailLogger(String destinatario, String msj) {
		this.destinatario = destinatario;
		this.msj = msj;
	}
	
	
	
	
	
	public void log() {
			System.out.println("Enviando email a " + this.destinatario);
			System.out.println("msj: " + this.msj);
			System.out.println("enviado");
			
		}
	
	//setter
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	public void setMensaje(String msj) {
		this.msj = msj;
	}
	
	
}
