package co.edu.unbosque.util;

/**
 * 
 *         Clase de excepción personalizada para representar la situación en la
 *         que un presupuesto ha sido excedido. Extiende la clase
 *         {@code Exception}.
 *
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */
public class PresupuestoExcedidoException extends Exception {

	/**
	 * El UID de versión serial para la serialización/deserialización.
	 * 
	 */
	private static final long serialVersionUID = -2408791790775288457L;

	/**
	 * Construye una nueva PresupuestoExcedidoException con el mensaje de error
	 * especificado.
	 *
	 * @param message El mensaje que describe la situación de exceso en el
	 *                presupuesto.
	 */

	public PresupuestoExcedidoException(String message) {
		super(message);
	}

}
