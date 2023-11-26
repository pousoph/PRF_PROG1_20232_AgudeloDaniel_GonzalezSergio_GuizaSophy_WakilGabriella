package co.edu.unbosque.util;

/**
 * 
 *         Clase de excepción personalizada para representar la situación en la
 *         que se intenta trabajar con un número negativo. Extiende la clase
 *         {@code Exception}.
 *
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class NumeroNegativoException extends Exception {

	/**
	 * El UID de versión serial para la serialización/deserialización.
	 * 
	 */
	private static final long serialVersionUID = -7020786382963043698L;

	/**
	 * Construye una nueva NumeroNegativoException con el mensaje de error
	 * especificado.
	 *
	 * @param message El mensaje que describe la presencia de un número negativo.
	 */

	public NumeroNegativoException(String message) {
		super(message);
	}

}
