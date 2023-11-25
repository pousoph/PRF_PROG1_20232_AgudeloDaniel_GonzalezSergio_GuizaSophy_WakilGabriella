package co.edu.unbosque.util;

public class UsuarioNoEncontradoException extends Exception {

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
