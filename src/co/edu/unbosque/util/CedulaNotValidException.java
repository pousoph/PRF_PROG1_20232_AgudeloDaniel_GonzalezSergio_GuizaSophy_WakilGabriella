package co.edu.unbosque.util;

/**
 * 
 *         Clase de excepción personalizada para representar la situación en la
 *         que una cédula proporcionada no es válida. Extiende la clase
 *         {@code Exception}.
 *
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class CedulaNotValidException extends Exception {

	/**
	 * El UID de versión serial para la serialización/deserialización.
	 */
	private static final long serialVersionUID = 2594384579468797728L;

	/**
	 * Construye una nueva CedulaNotValidException con el número de cédula
	 * especificado.
	 *
	 * @param number El número de cédula que no es válido.
	 */
	public CedulaNotValidException(String number) {
		// TODO Auto-generated constructor stub
		super(number);
	}

}
