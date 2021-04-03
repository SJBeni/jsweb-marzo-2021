package ar.com.educacionit.codigosteoria;

public class Principal2 {

	public static void main(String[] args) {
		/**
		 * Operadorse Arimeticos
		 * (+) Suma num1 + num2
		 * (-) Resta num1 - num2
		 * (*) Multiplicacion num1 * num2
		 * (/) Division num1 / num2
		 * (%) Modulo o Resto num1 % num2
		 */
		
		System.out.println("----------Arimeticos----------");
		int num1, num2, operacion;
		
		//asignamos valores inciales a las variables
		num1 = 5;
		num2 = 3;
		
		operacion = num1 + num2;
		//imprimimos el resultado
		System.out.println("Suma:");
		System.out.println(operacion);

		operacion = num1 - num2;
		//imprimimos el resultado
		System.out.println("Resta:");
		System.out.println(operacion);
		
		operacion = num1 * num2;
		//imprimimos el resultado
		System.out.println("Multiplicacion:");
		System.out.println(operacion);
		
		operacion = num1 / num2;
		//imprimimos el resultado
		//el resultado en esta operacion devolvera un numero entero ya que operamos con enteros
		System.out.println("Division:");
		System.out.println(operacion);
		
		/**
		 * = Asignacion num1 = num2
		 * += Suma y asignacion num1 += num2 (num1 = num1 + num2)
		 * -= Resta y asignacion num1 -= num2 (num1 = num1 - num2)
		 * *= Multiplicacion y asignacion num1 *= num2 (num1 = num1 * num2)
		 * /= Division y asignacion num1 / num2 (num1 = num1 / num2)
		 * %= Modulo y asignacion num1 % num2 (num1 = num1 % num2)
		 */
		
		System.out.println("----------Asignacion-----------");
		
		//asignamos valores nuevos a las variables
		num1 = 60;
		num2 = 15;
		
		num1 = num2;
		System.out.println("Asignacion:");
		System.out.println(num1);
		
		num1 += num2;
		System.out.println("Suma:");
		System.out.println(num1);
		
		num1 -= num2;
		System.out.println("Resta:");
		System.out.println(num1);
		
		num1 *= num2;
		System.out.println("Multiplicacion:");
		System.out.println(num1);
		
		num1 /= num2;
		System.out.println("Division:");
		System.out.println(num1);
		
		num1 %= num2;
		System.out.println("Resto:");
		System.out.println(num1);
		
		/**
		 * Operadores Logicos
		 * (&&) AND op1 && op2
		 * (&) AND Inclusivo op1 & op2
		 * (||) OR op1 || op2
		 * (|) OR Inclusivo op1 | op2
		 * (!) NOT !op1
		 */
		
		System.out.println("----------Logicos----------");
		boolean op1,op2;
		//asignamos valors iniciales a las variables 
		
		op1 = true;
		op2 = false;
		
		//para verificar estos operadores los vamos a usar en la consola
		//imprimimos la operacion
		System.out.println("AND:");
		System.out.println(op1 && op2);
		
		//imprimimos la operacion
		System.out.println("OR:");
		System.out.println(op1 || op2);
		
		//imprimimos la operacion
		System.out.println("NOT:");
		System.out.println(!op1);
		System.out.println(!op2);
		
		//imprimimos la operacion
		System.out.println("AND Inclusivo:");
		System.out.println(op1 & op2);
		
		//imprimimos la operacion
		System.out.println("OR Inclusivo:");
		System.out.println(op1 | op2);
		
		/**
		 * Operadores Relacionales (Comparacion)
		 * == Igualdad num1 == num2
		 * != Distinto num1 != num2
		 * < Menor que num1 < num2
		 * > Mayor que num1 > num2
		 * <= Menor o igual que num1 <= num2
		 * >= Mayor o igual que num1 >=num2
		 */
		
		System.out.println("----------Relacionales------------");
		
		//asignamos valores nuevos a las variables
		num1 = 45;
		num2 = 43;
		
		//imprimimos la operacion
		System.out.println("Igualdad:");
		System.out.println(num1 == num2);
		
		//imprimimos la operacion
		System.out.println("Distinto:");
		System.out.println(num1 != num2);
		
		//imprimimos la operacion
		System.out.println("Mayor:");
		System.out.println(num1 > num2);
		
		//imprimimos la operacion
		System.out.println("Menor");
		System.out.println(num1 < num2);
		
		//imprimimos la operacion
		System.out.println("Mayor Igual:");
		System.out.println(num1 >= num2);
		
		//imprimimos la operacion
		System.out.println("Menor Igual:");
		System.out.println(num1 <= num2);
		
		/**
		 * Operadorse Incrementales
		 * (++) para incrementar de uno en uno
		 * (--) para disminuir de uno en uno
		 */
		
		System.out.println("----------Incrementales-----------");
		int cantidad = 0;
		
		cantidad++;
		//imprimimos la operacion
		System.out.println("Incrementar:");
		System.out.println(cantidad);
		
		//incrementar y despues usar
		System.out.println("Incrementar y despues, usar");
		System.out.println(++cantidad);
		System.out.println("cantidad = " + cantidad); 
		
		//usar y despues incrementar
		System.out.println("Usar y despues incrementar");
		System.out.println(cantidad++);
		System.out.println("cantidad = " + cantidad); 
		
		cantidad--;
		//imprimimos la operacion
		System.out.println("Disminuir:");
		System.out.println(cantidad);
		
		//disminuir y despues usar
		System.out.println("Disminuir y despues usar");
		System.out.println(--cantidad);
		System.out.println("cantidad = " + cantidad); 
		
		//usar y despues disminuir
		System.out.println("Usar y despues disminuir");
		System.out.println(cantidad--);
		System.out.println("cantidad = " + cantidad); 
		
		
	}

}
