package ar.com.educacionit.interfaces.impl;

import ar.com.educacionit.interfaces.ILogger;

public class HDLogger implements ILogger {

	//path
	private String path;
	private String msj;
	
	
	//constructor
	public HDLogger(String path, String msj) {
		this.path = path;
		this.msj = msj;
		
	}
	
	public void log() {
		System.out.println("Grabando log en disco...." + this.path);
		System.out.println("grabando..." + this.msj);
		System.out.println("se ha grabado exitosamente");
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
	
	
	
	

	
}
