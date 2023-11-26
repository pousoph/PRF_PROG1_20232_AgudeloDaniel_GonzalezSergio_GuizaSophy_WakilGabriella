package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * 
 * 
 *         La clase JuegoDTO representa un juego con su nombre, tipo,
 *         presupuesto e identificador.
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class JuegoDTO implements Serializable {

	/**
	 * UID serial predeterminado para la serialización.
	 */
	private static final long serialVersionUID = -5518907593188818260L;

	// Nombre del juego
	private String nombreJuego;

	// Tipo de juego
	private String tipoJuego;

	// Presupuesto del juego
	private double presupuesto;

	// Identificador del juego
	private int idJuego;

	/**
	 * Constructor de la clase JuegoDTO.
	 */

	public JuegoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase JuegoDTO que inicializa los atributos con valores
	 * proporcionados.
	 *
	 * @param nombreJuego Nombre del juego.
	 * @param tipoJuego   Tipo de juego.
	 * @param presupuesto Presupuesto asignado al juego.
	 * @param idJuego     Identificador del juego.
	 */

	public JuegoDTO(String nombreJuego, String tipoJuego, double presupuesto, int idJuego) {
		super();
		this.nombreJuego = nombreJuego;
		this.tipoJuego = tipoJuego;
		this.presupuesto = presupuesto;
		this.idJuego = idJuego;
	}

	/**
	 * Obtiene el nombre del juego.
	 *
	 * @return Nombre del juego.
	 */

	public String getNombreJuego() {
		return nombreJuego;
	}

	/**
	 * Establece el nombre del juego.
	 *
	 * @param nombreJuego Nuevo nombre del juego.
	 */

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	/**
	 * Obtiene el tipo de juego.
	 *
	 * @return Tipo de juego.
	 */

	public String getTipoJuego() {
		return tipoJuego;
	}

	/**
	 * Establece el tipo de juego.
	 *
	 * @param tipoJuego Nuevo tipo de juego.
	 */

	public void setTipoJuego(String tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	/**
	 * Obtiene el presupuesto asignado al juego.
	 *
	 * @return Presupuesto asignado al juego.
	 */

	public double getPresupuesto() {
		return presupuesto;
	}

	/**
	 * Establece el presupuesto asignado al juego.
	 *
	 * @param presupuesto Nuevo presupuesto asignado al juego.
	 */

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * Obtiene el identificador del juego.
	 *
	 * @return Identificador del juego.
	 */

	public int getIdJuego() {
		return idJuego;
	}

	/**
	 * Establece el identificador del juego.
	 *
	 * @param idJuego Nuevo identificador del juego.
	 */

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	/**
	 * Genera una representación en cadena del juego con detalles como el nombre del
	 * juego, el tipo de juego, el presupuesto y el identificador.
	 *
	 * @return Una cadena que representa el juego.
	 */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + idJuego + "\n");
		sb.append("Nombre del juego: " + nombreJuego + "\n");
		sb.append("Tipo de juego: " + tipoJuego + "\n");
		sb.append("Presupuesto: " + presupuesto + "\n");

		return sb.toString();
	}

}