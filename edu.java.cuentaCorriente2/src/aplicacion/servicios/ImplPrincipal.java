package aplicacion.servicios;

import java.util.Scanner;

/**
 * Implementación de la interfaz principal
 * @author frand
 *
 */
public class ImplPrincipal implements InterfazPrincipal {
	
	// Menu
	@Override
	public int Menu() {
		// Scanner
		Scanner entrada = new Scanner(System.in);
		// Imprimimos por pantalla las opciones
		System.out.println("1. Crear cuenta");
		System.out.println("2. Ingresar dinero");
		System.out.println("3. Retirar dinero");
		System.out.println("4. Mostrar información");
		System.out.println("0. Salir");
		
		int opcion = entrada.nextInt();
		
		return opcion;
	}

}
