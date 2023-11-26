package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

/**
 * 
 *         Clase que representa una apuesta de tipo Betplay, que extiende de la
 *         clase ApuestaDTO.
 *         <p>
 *         La apuesta de Betplay incluye información adicional, como un
 *         identificador único, el resultado de un partido, el nombre del
 *         partido, la cédula del apostador y la sede en la que se realizó la
 *         apuesta.
 *         </p>
 *         <p>
 *         Esta clase implementa la interfaz {@code Serializable} para permitir
 *         su serialización.
 *         </p>
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class BetplayDTO extends ApuestaDTO implements Serializable {

	/**
	 * UID serial predeterminado para la serialización.
	 */
	private static final long serialVersionUID = -8386853420744528669L;
	private int idBetplay;
	private String resultado;
	private String partido;
	private long cedulaApostador;
	private String sedeApostador;

	/**
	 * Constructor por defecto de la clase BetplayDTO.
	 */

	public BetplayDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa los atributos de la apuesta de Betplay con valores
	 * proporcionados.
	 *
	 * @param idBetplay       Identificador único de la apuesta de Betplay.
	 * @param resultado       Resultado de un partido asociado a la apuesta de
	 *                        Betplay.
	 * @param partido         Nombre del partido asociado a la apuesta de Betplay.
	 * @param cedulaApostador Cédula del apostador que realizó la apuesta de
	 *                        Betplay.
	 * @param sedeApostador   Sede en la que se realizó la apuesta de Betplay.
	 */

	public BetplayDTO(int idBetplay, String resultado, String partido, long cedulaApostador, String sedeApostador) {
		super();
		this.idBetplay = idBetplay;
		this.resultado = resultado;
		this.partido = partido;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Constructor que inicializa los atributos de la apuesta de Betplay con valores
	 * proporcionados, incluyendo la fecha y el valor de la apuesta.
	 *
	 * @param dia             Fecha de la apuesta.
	 * @param valorApuesta    Valor de la apuesta.
	 * @param idBetplay       Identificador único de la apuesta de Betplay.
	 * @param resultado       Resultado de un partido asociado a la apuesta de
	 *                        Betplay.
	 * @param partido         Nombre del partido asociado a la apuesta de Betplay.
	 * @param cedulaApostador Cédula del apostador que realizó la apuesta de
	 *                        Betplay.
	 * @param sedeApostador   Sede en la que se realizó la apuesta de Betplay.
	 */

	public BetplayDTO(LocalDate dia, double valorApuesta, int idBetplay, String resultado, String partido,
			long cedulaApostador, String sedeApostador) {
		super(dia, valorApuesta);
		this.idBetplay = idBetplay;
		this.resultado = resultado;
		this.partido = partido;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Constructor que inicializa la fecha y el valor de la apuesta de Betplay con
	 * valores proporcionados.
	 *
	 * @param dia          Fecha de la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 */

	public BetplayDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el identificador único de la apuesta de Betplay.
	 *
	 * @return Identificador único de la apuesta de Betplay.
	 */

	public int getIdBetplay() {
		return idBetplay;
	}

	/**
	 * Establece el identificador único de la apuesta de Betplay.
	 *
	 * @param idBetplay Nuevo identificador único de la apuesta de Betplay.
	 */

	public void setIdBetplay(int idBetplay) {
		this.idBetplay = idBetplay;
	}

	/**
	 * Obtiene el resultado de un partido asociado a la apuesta de Betplay.
	 *
	 * @return Resultado de un partido asociado a la apuesta de Betplay.
	 */

	public String getResultado() {
		return resultado;
	}

	/**
	 * Establece el resultado de un partido asociado a la apuesta de Betplay.
	 *
	 * @param resultado Nuevo resultado de un partido asociado a la apuesta de
	 *                  Betplay.
	 */

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * Obtiene el nombre del partido asociado a la apuesta de Betplay.
	 *
	 * @return Nombre del partido asociado a la apuesta de Betplay.
	 */

	public String getPartido() {
		return partido;
	}

	/**
	 * Establece el nombre del partido asociado a la apuesta de Betplay.
	 *
	 * @param partido Nuevo nombre del partido asociado a la apuesta de Betplay.
	 */

	public void setPartido(String partido) {
		this.partido = partido;
	}

	/**
	 * Obtiene la cédula del apostador que realizó la apuesta de Betplay.
	 *
	 * @return Cédula del apostador que realizó la apuesta de Betplay.
	 */

	public long getCedulaApostador() {
		return cedulaApostador;
	}

	/**
	 * Establece la cédula del apostador que realizó la apuesta de Betplay.
	 *
	 * @param cedulaApostador Nueva cédula del apostador que realizó la apuesta de
	 *                        Betplay.
	 */

	public void setCedulaApostador(long cedulaApostador) {
		this.cedulaApostador = cedulaApostador;
	}

	/**
	 * Obtiene la sede en la que se realizó la apuesta de Betplay.
	 *
	 * @return Sede en la que se realizó la apuesta de Betplay.
	 */

	public String getSedeApostador() {
		return sedeApostador;
	}

	/**
	 * Establece la sede en la que se realizó la apuesta de Betplay.
	 *
	 * @param sedeApostador Nueva sede en la que se realizó la apuesta de Betplay.
	 */

	public void setSedeApostador(String sedeApostador) {
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Genera una representación en cadena de la apuesta de Betplay.
	 *
	 * @return Una cadena que representa la apuesta de Betplay con detalles como
	 *         identificador, resultado de un partido, nombre del partido, cédula
	 *         del apostador y sede.
	 */

	@Override
	public String toString() {
		return "BetplayDTO [idBetplay=" + idBetplay + ", resultado=" + resultado + ", partido=" + partido
				+ ", cedulaApostador=" + cedulaApostador + ", sedeApostador=" + sedeApostador + "]";
	}

}