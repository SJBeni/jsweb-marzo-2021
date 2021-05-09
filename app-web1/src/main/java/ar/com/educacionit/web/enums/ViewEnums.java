package ar.com.educacionit.web.enums;

public enum ViewEnums {
	LOGIN("/login.jsp"),
	UPLOAD("/upload.jsp"),
	LISTADO_GENERAL("/listadoGeneral.jsp"),
	NUEVO_PRODUCTO("/nuevo.jsp");
	
	private String view;
	
	private ViewEnums(String view) {
		this.view = view;
	}
}
