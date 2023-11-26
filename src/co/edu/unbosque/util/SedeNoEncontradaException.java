package co.edu.unbosque.util;

/**
 * 
 *         Excepción de tiempo de ejecución personalizada para representar la
 *         situación en la que no se encuentra una sede. Extiende la clase
 *         {@code RuntimeException}.
 *
 *         Esta excepción se lanza cuando se intenta acceder a una sede que no
 *         existe.
 *
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 */

public class SedeNoEncontradaException extends RuntimeException {

	/**
	 * El UID de versión serial para la serialización/deserialización.
	 * 
	 */
	private static final long serialVersionUID = -7033942737599145085L;

	/**
	 * Construye una nueva SedeNoEncontradaException con el mensaje de error
	 * especificado.
	 *
	 * @param message El mensaje que describe la situación de no encontrar la sede.
	 */

	public SedeNoEncontradaException(String message) {
		super(message);
	}
}
