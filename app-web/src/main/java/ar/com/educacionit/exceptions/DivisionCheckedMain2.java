package ar.com.educacionit.exceptions;

import ar.com.educacionit.exceptions.checked.DivisionPorCeroException;

public class DivisionCheckedMain2 {
	//aqui se indica que este metodo lanza un DivisionPorCeroException
	public static void main(String[] args) throws DivisionPorCeroException{
		int a = 10;
		int b = 0;
		
		Calculadora.dividir(a, b);
		//si no quiero controlar el error con try catch, agregar el throws en el metodo

	}

}
