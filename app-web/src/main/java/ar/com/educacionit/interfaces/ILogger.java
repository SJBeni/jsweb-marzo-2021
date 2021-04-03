package ar.com.educacionit.interfaces;

public interface ILogger {
	//definir el contrato
	public void log();
		
	//salvo que sea estrictamente necesario, definir un metodo por defecto
	public default void log1() {
		System.out.println("hola soy el metodo por defecto ILogger");
	}
	
}
