package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 *         La clase JuegoDTO representa un juego con su nombre, tipo,
 *         presupuesto e identificador.
 */

public class JuegoDTO implements Serializable{

	/**
	 * 
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

	public JuegoDTO(String nombreJuego, String tipoJuego, double presupuesto, int idJuego) {
		super();
		this.nombreJuego = nombreJuego;
		this.tipoJuego = tipoJuego;
		this.presupuesto = presupuesto;
		this.idJuego = idJuego;
	}

	public String getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public String getTipoJuego() {
		return tipoJuego;
	}

	public void setTipoJuego(String tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

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