package ar.com.educacionit.clase4.enums;

public enum Tipo {

	//valores que tiene este enum
	TXT("Texto"),
	XLS(""),
	CSV("Texto CSV");
	
	
	private String tipoTexto;
	
	//no puede ser public el constructor
	private Tipo(String tipoTexto) {
		this.tipoTexto = tipoTexto;
	}
	
	public String getTipoTexto() {
		return this.tipoTexto;
	}
}
