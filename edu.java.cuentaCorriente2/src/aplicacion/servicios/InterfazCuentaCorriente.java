package aplicacion.servicios;

import java.util.List;

import aplicacion.entidades.CuentaCorriente;

/**
 * Interfaz que define los métodos que dan servicio a la cuenta corriente
 * @author frand
 *
 */
public interface InterfazCuentaCorriente {
	// Cabecera
	
	// Crear cuenta
	/**
	 * Devuelve un objeto de tipo CuentaCorriente
	 * @return
	 * @param El dni y el nombre del titular de la cuenta
	 */
	public CuentaCorriente crearCuenta(String dni, String nombreTitular);
	
	// Ingresar dinero
	/**
	 * Ingresa dinero (saldo) al objeto de tipo CuentaCorriente
	 * @param cantidad a ingresar
	 */
	public List<CuentaCorriente> ingresarDinero(List<CuentaCorriente> listaBD, float cantIngresar);
	
	// Mostrar información
	/**
	 * Muestra la información de la CuentaCorriente
	 */
	public void mostrarInformacion(List<CuentaCorriente> listaBD);
	
	// Sacar dinero
	/**
	 * Devolverá el saldo restante, si se ha podido sacar, si no se puede sacar devolverá saldo insuficiente
	 * @param cantidad de dinero a sacar
	 */
	public List<CuentaCorriente> sacarDinero(List<CuentaCorriente> listaBD, float cantSacar);
}
