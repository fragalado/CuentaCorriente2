package aplicacion.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.CuentaCorriente;
import aplicacion.servicios.ImplCuentaCorriente;
import aplicacion.servicios.ImplPrincipal;
import aplicacion.servicios.InterfazCuentaCorriente;
import aplicacion.servicios.InterfazPrincipal;

public class Principal {

	public static void main(String[] args) {
		 
		// Inicializamos la interfaz de repostaje y principal
		InterfazCuentaCorriente intCuenta = new ImplCuentaCorriente();
		InterfazPrincipal intP = new ImplPrincipal();
		
		// Creamos una lista que contendrá los objetos de tipo CuentaCorriente (base de datos)
		List<CuentaCorriente> listaBD = new ArrayList<>();
		
		// Imprimimos el menú por consola
		Scanner entradaValores = new Scanner(System.in);
		int opcion;
		float cantidad;
		String entradaDNI, entradaNombre;
		do {
			opcion = intP.Menu();
			
			// Según la opción seleccionada haremos una cosa u otra
			switch (opcion) {
			case 1:
				// Crear cuenta
				// Pedimos el dni del usuario
				System.out.println("Introduzca su dni:");
				entradaDNI = entradaValores.next();
				
				// Pedimos el nombre del usuario
				System.out.println("Introduzca su nombre:");
				entradaNombre = entradaValores.next();
				
				// Pasamos los valores como parametros a crearCuenta y la cuenta creada la guardamos en la base de datos
				listaBD.add(intCuenta.crearCuenta(entradaDNI, entradaNombre));
				break;
			case 2:
				// Ingresar dinero
				// Pedimos la cantidad a ingresar
				System.out.println("Introduzca la cantidad a ingresar:");
				cantidad = entradaValores.nextFloat();
				
				// Llamamos al metodo ingresarDinero
				// Nos devuelve la lista actualizada
				listaBD = intCuenta.ingresarDinero(listaBD, cantidad);
				break;
			case 3:
				// Retirar Dinero
				System.out.println("Introduzca la cantidad a retirar:");
				cantidad = entradaValores.nextFloat();
				
				// Llamamos al metodo sacarDinero
				// Nos devuelve la lista actualizada
				listaBD = intCuenta.sacarDinero(listaBD, cantidad);
				break;
			case 4:
				// Mostrar información
				intCuenta.mostrarInformacion(listaBD);
				break;
			}
		} while (opcion != 0);
		
		// Cerramos la variable Scanner
		entradaValores.close();		
	}

}
