package co.edu.unbosque.util;

/**
 * 
 * 
 * Excepción personalizada para representar la situación en la que no se
 * encuentra un usuario. Extiende la clase {@code Exception}.
 *
 * <p>
 * Esta excepción se lanza cuando se intenta realizar una operación relacionada
 * con un usuario que no existe.
 * </p>
 *
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class UsuarioNoEncontradoException extends Exception {

	/**
	 * El UID de versión serial para la serialización/deserialización.
	 */

	private static final long serialVersionUID = 6796189699134914061L;

	/**
	 * Constructor de la excepción que toma como parámetro el mensaje de error
	 * relacionado con el usuario no encontrado.
	 *
	 * @param message El mensaje de error que describe la razón de la excepción.
	 */
	public UsuarioNoEncontradoException(String message) {
		super(message);
	}

}