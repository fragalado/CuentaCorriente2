package aplicacion.servicios;

import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.CuentaCorriente;

/**
 * Implementación de la interfaz cuenta corriente
 * @author frand
 *
 */
public class ImplCuentaCorriente implements InterfazCuentaCorriente{
	
	// Crear cuenta
	@Override
	public CuentaCorriente crearCuenta(String dni, String nombreTitular) {
		 
		// Inicializamos una variable de tipo CuentaCorriente
		// que será la que devolvamos al final del método
		CuentaCorriente cuenta = new CuentaCorriente();
		
		// Le añadimos a la variable cuenta los valores de dni y nombreTitular
		cuenta.setDni(dni);
		cuenta.setNombreTitular(nombreTitular);
		
		// Le añadimos también el saldo en 0
		cuenta.setSaldo(0);
		
		// Devolvemos el objeto de tipo CuentaCorriente
		return cuenta;
	}
	
	// Ingresar dinero
	@Override
	public List<CuentaCorriente> ingresarDinero(List<CuentaCorriente> listaBD, float cantIngresar) {
		
		// Scanner para pedir los valores
		Scanner sc = new Scanner(System.in);
		
		// Buscamos el objeto correspondiente
		CuentaCorriente cuentaUsuario = buscarObjetoPorDni(listaBD);
		
		// Una vez que tenemos el objeto que contiene el dni del usuario
		// Le añadimos el saldo al objeto
		cuentaUsuario.setSaldo(cantIngresar + cuentaUsuario.getSaldo());
		
		// Devolvemos la lista
		return listaBD;		
	}
	
	// Mostrar información
	@Override
	public void mostrarInformacion(List<CuentaCorriente> listaBD) {
		// 
		// Scanner para pedir los valores
		Scanner sc2 = new Scanner(System.in);
		
		// Buscamos el objeto correspondiente
		CuentaCorriente cuentaUsuario = buscarObjetoPorDni(listaBD);
		
		// Una vez que tenemos el objeto que contiene el dni del usuario
		// Mostramos los datos
		System.out.println("DNI: " + cuentaUsuario.getDni() + "; Nombre Titular: " + cuentaUsuario.getNombreTitular() 
								+ "; Saldo: " + cuentaUsuario.getSaldo());
	}
	
	// Sacar dinero
	@Override
	public List<CuentaCorriente> sacarDinero(List<CuentaCorriente> listaBD, float cantSacar) {
		
		// Scanner para pedir los valores
		Scanner sc3 = new Scanner(System.in);
		
		// Buscamos el objeto correspondiente
		CuentaCorriente cuentaUsuario = buscarObjetoPorDni(listaBD);
		
		// Una vez que tenemos el objeto que contiene el dni del usuario
		// Comprobamos que tenga saldo suficiente para realizar la operación
		// Si no tiene saldo suficiente se mostrará un mensaje de saldo insuficiente
		if(cantSacar > cuentaUsuario.getSaldo())
			System.err.println("No hay suficiente saldo");
		else {
			// Si puede sacar el dinero
			// Actualizamos el valor del saldo
			cuentaUsuario.setSaldo(cuentaUsuario.getSaldo() - cantSacar);
		}
		return listaBD;
	}
	
	/**
	 * Busca el objeto correspondiente por el dni del usuario y lo devuelve
	 * @param listaBD
	 * @return Devuelve un objeto CuentaCorriente
	 */
	private CuentaCorriente buscarObjetoPorDni(List<CuentaCorriente> listaBD) {
		
		// Scanner para pedir los valores
		Scanner sc4 = new Scanner(System.in);
		
		// Pedimos el dni
		System.out.println("Introduzca su dni:");
		String dniUsuario = sc4.next();
		
		// Ahora buscamos el dni del usuario en nuestra base de datos y nos quedamos con el objeto que lo contiene
		CuentaCorriente res = new CuentaCorriente();
		for (CuentaCorriente aux : listaBD) {
			if(aux.getDni().equals(dniUsuario)) {
				res = aux;
				break;
			}	
		}
		return res;
	}
		
}
