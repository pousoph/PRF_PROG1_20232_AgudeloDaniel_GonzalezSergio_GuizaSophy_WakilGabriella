package co.edu.unbosque.util;

/**
 * 
 * 
 *         Clase de excepción personalizada para representar la situación en la
 *         que un nombre proporcionado no es válido. Extiende la clase
 *         {@code Exception}.
 *
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 */
public class NombreNotValidException extends Exception {

	/**
	 * El UID de versión serial para la serialización/deserialización.
	 */
	private static final long serialVersionUID = 2455665574208572605L;

	/**
	 * Construye una nueva NombreNotValidException con el mensaje de error
	 * especificado.
	 *
	 * @param message El mensaje que describe la no validez del nombre.
	 */

	public NombreNotValidException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
