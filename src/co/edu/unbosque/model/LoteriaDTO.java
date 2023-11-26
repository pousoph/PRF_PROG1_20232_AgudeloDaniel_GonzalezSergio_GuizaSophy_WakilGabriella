package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * 
 * 
 *         La clase LoteriaDTO es una subclase de JuegoDTO y representa un juego
 *         de lotería. Contiene información sobre los números asociados al juego
 *         y un identificador único.
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class LoteriaDTO extends ApuestaDTO implements Serializable {

	/**
	 * UID serial predeterminado para la serialización.
	 */
	private static final long serialVersionUID = -2762631600481725137L;

	// Nombre de la lotería
	private String nombreLoteria;

	// Identificador de la lotería
	private int idLoteria;

	// Números seleccionados
	private int[] numeros;

	// Número de serie
	private int numSerie;

	// Cédula del apostador
	private long cedulaApostador;

	// Sede del apostador
	private String sedeApostador;

	/**
	 * Constructor de la clase
	 */

	public LoteriaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase LoteriaDTO que inicializa los atributos con valores
	 * proporcionados.
	 *
	 * @param nombreLoteria   Nombre de la lotería.
	 * @param idLoteria       Identificador de la lotería.
	 * @param numeros         Números seleccionados.
	 * @param numSerie        Número de serie.
	 * @param cedulaApostador Cédula del apostador.
	 * @param sedeApostador   Sede del apostador.
	 */

	public LoteriaDTO(String nombreLoteria, int idLoteria, int[] numeros, int numSerie, long cedulaApostador,
			String sedeApostador) {
		super();
		this.nombreLoteria = nombreLoteria;
		this.idLoteria = idLoteria;
		this.numeros = numeros;
		this.numSerie = numSerie;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Constructor de la clase LoteriaDTO que inicializa algunos atributos con
	 * valores proporcionados y otros con valores predeterminados.
	 *
	 * @param dia             Día de la apuesta.
	 * @param valorApuesta    Valor de la apuesta.
	 * @param nombreLoteria   Nombre de la lotería.
	 * @param idLoteria       Identificador de la lotería.
	 * @param numeros         Números seleccionados.
	 * @param numSerie        Número de serie.
	 * @param cedulaApostador Cédula del apostador.
	 * @param sedeApostador   Sede del apostador.
	 */

	public LoteriaDTO(LocalDate dia, double valorApuesta, String nombreLoteria, int idLoteria, int[] numeros,
			int numSerie, long cedulaApostador, String sedeApostador) {
		super(dia, valorApuesta);
		this.nombreLoteria = nombreLoteria;
		this.idLoteria = idLoteria;
		this.numeros = numeros;
		this.numSerie = numSerie;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Constructor de la clase LoteriaDTO que inicializa algunos atributos con
	 * valores predeterminados.
	 *
	 * @param dia          Día de la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 */

	public LoteriaDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el nombre de la lotería.
	 *
	 * @return Nombre de la lotería.
	 */

	public String getNombreLoteria() {
		return nombreLoteria;
	}

	/**
	 * Establece el nombre de la lotería.
	 *
	 * @param nombreLoteria Nuevo nombre de la lotería.
	 */

	public void setNombreLoteria(String nombreLoteria) {
		this.nombreLoteria = nombreLoteria;
	}

	/**
	 * Obtiene el identificador de la lotería.
	 *
	 * @return Identificador de la lotería.
	 */

	public int getIdLoteria() {
		return idLoteria;
	}

	/**
	 * Establece el identificador de la lotería.
	 *
	 * @param idLoteria Nuevo identificador de la lotería.
	 */

	public void setIdLoteria(int idLoteria) {
		this.idLoteria = idLoteria;
	}

	/**
	 * Obtiene los números seleccionados.
	 *
	 * @return Números seleccionados.
	 */

	public int[] getNumeros() {
		return numeros;
	}

	/**
	 * Establece los números seleccionados.
	 *
	 * @param numeros Nuevos números seleccionados.
	 */

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}

	/**
	 * Obtiene el número de serie.
	 *
	 * @return Número de serie.
	 */

	public int getNumSerie() {
		return numSerie;
	}

	/**
	 * Establece el número de serie.
	 *
	 * @param numSerie Nuevo número de serie.
	 */

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	/**
	 * Obtiene la cédula del apostador.
	 *
	 * @return Cédula del apostador.
	 */

	public long getCedulaApostador() {
		return cedulaApostador;
	}

	/**
	 * Establece la cédula del apostador.
	 *
	 * @param cedulaApostador Nueva cédula del apostador.
	 */

	public void setCedulaApostador(long cedulaApostador) {
		this.cedulaApostador = cedulaApostador;
	}

	/**
	 * Obtiene la sede del apostador.
	 *
	 * @return Sede del apostador.
	 */

	public String getSedeApostador() {
		return sedeApostador;
	}

	/**
	 * Establece la sede del apostador.
	 *
	 * @param sedeApostador Nueva sede del apostador.
	 */

	public void setSedeApostador(String sedeApostador) {
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Genera una representación en cadena de la apuesta de lotería con detalles
	 * como el nombre de la lotería, el identificador de la lotería, los números
	 * seleccionados, el número de serie, la cédula del apostador y la sede del
	 * apostador.
	 *
	 * @return Una cadena que representa la apuesta de lotería.
	 */

	@Override
	public String toString() {
		return "LoteriaDTO [nombreLoteria=" + nombreLoteria + ", idLoteria=" + idLoteria + ", numeros="
				+ Arrays.toString(numeros) + ", numSerie=" + numSerie + ", cedulaApostador=" + cedulaApostador
				+ ", sedeApostador=" + sedeApostador + "]";
	}

}