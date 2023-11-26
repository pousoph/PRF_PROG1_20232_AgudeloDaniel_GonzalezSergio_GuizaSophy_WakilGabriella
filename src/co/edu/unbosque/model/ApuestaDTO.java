package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 *         Clase que representa una apuesta.
 *         <p>
 *         Una apuesta tiene información sobre la fecha en que fue realizada y
 *         el valor de la apuesta.
 *         </p>
 *         <p>
 *         Esta clase implementa la interfaz {@code Serializable} para permitir
 *         su serialización.
 *         </p>
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class ApuestaDTO implements Serializable {

	/**
	 * Número de versión de la clase para control de serialización.
	 */
	private static final long serialVersionUID = 7930421911445868811L;
	private LocalDate dia;
	private double valorApuesta;

	/**
	 * Constructor por defecto de la clase ApuestaDTO.
	 */

	public ApuestaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa los atributos de la apuesta con valores
	 * proporcionados.
	 *
	 * @param dia          Fecha de la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 */

	public ApuestaDTO(LocalDate dia, double valorApuesta) {
		super();
		this.dia = dia;
		this.valorApuesta = valorApuesta;
	}

	/**
	 * Obtiene la fecha de la apuesta.
	 *
	 * @return La fecha de la apuesta.
	 */

	public LocalDate getDia() {
		return dia;
	}

	/**
	 * Establece la fecha de la apuesta.
	 *
	 * @param dia La nueva fecha de la apuesta.
	 */

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	/**
	 * Obtiene el valor de la apuesta.
	 *
	 * @return El valor de la apuesta.
	 */

	public double getValorApuesta() {
		return valorApuesta;
	}

	/**
	 * Establece el valor de la apuesta.
	 *
	 * @param valorApuesta El nuevo valor de la apuesta.
	 */

	public void setValorApuesta(double valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

	/**
	 * Genera una representación en cadena de la apuesta.
	 *
	 * @return Una cadena que representa la apuesta con detalles como fecha y valor.
	 */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Dia: " + dia + "\n");
		sb.append("Valor de la apuesta: " + valorApuesta + "\n");

		return sb.toString();
	}

}