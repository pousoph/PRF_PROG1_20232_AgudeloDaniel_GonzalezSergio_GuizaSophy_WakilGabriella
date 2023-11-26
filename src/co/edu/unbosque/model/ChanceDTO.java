package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * 
 * 
 *         La clase ChanceDTO es una subclase de aDTO y representa un juego de
 *         Chance. Contiene información sobre el nombre de la lotería, los
 *         números asociados al juego y un identificador único.
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class ChanceDTO extends ApuestaDTO implements Serializable {

	/**
	 * 
	 * UID serial predeterminado para la serialización.
	 * 
	 */
	private static final long serialVersionUID = -4985508615110433387L;
	private String nombreLoteria;
	private int idChance;
	private int[] numeros;
	private long cedulaAposdor;
	private String sedeApostador;

	/**
	 * Constructor por defecto de la clase ChanceDTO.
	 */

	public ChanceDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa los atributos de la apuesta de Chance con valores
	 * proporcionados.
	 *
	 * @param nombreLoteria Nombre de la lotería asociada a la apuesta de Chance.
	 * @param idChance      Identificador único de la apuesta de Chance.
	 * @param numeros       Lista de números asociados a la apuesta de Chance.
	 * @param cedulaAposdor Cédula del apostador que realizó la apuesta de Chance.
	 * @param sedeApostador Sede en la que se realizó la apuesta de Chance.
	 */

	public ChanceDTO(String nombreLoteria, int idChance, int[] numeros, long cedulaAposdor, String sedeApostador) {
		super();
		this.nombreLoteria = nombreLoteria;
		this.idChance = idChance;
		this.numeros = numeros;
		this.cedulaAposdor = cedulaAposdor;
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Constructor que inicializa los atributos de la apuesta de Chance con valores
	 * proporcionados, incluyendo la fecha y el valor de la apuesta.
	 *
	 * @param dia           Fecha de la apuesta.
	 * @param valorApuesta  Valor de la apuesta.
	 * @param nombreLoteria Nombre de la lotería asociada a la apuesta de Chance.
	 * @param idChance      Identificador único de la apuesta de Chance.
	 * @param numeros       Lista de números asociados a la apuesta de Chance.
	 * @param cedulaAposdor Cédula del apostador que realizó la apuesta de Chance.
	 * @param sedeApostador Sede en la que se realizó la apuesta de Chance.
	 */

	public ChanceDTO(LocalDate dia, double valorApuesta, String nombreLoteria, int idChance, int[] numeros,
			long cedulaAposdor, String sedeApostador) {
		super(dia, valorApuesta);
		this.nombreLoteria = nombreLoteria;
		this.idChance = idChance;
		this.numeros = numeros;
		this.cedulaAposdor = cedulaAposdor;
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Constructor que inicializa la fecha y el valor de la apuesta de Chance con
	 * valores proporcionados.
	 *
	 * @param dia          Fecha de la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 */

	public ChanceDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el nombre de la lotería asociada a la apuesta de Chance.
	 *
	 * @return Nombre de la lotería asociada a la apuesta de Chance.
	 */

	public String getNombreLoteria() {
		return nombreLoteria;
	}

	/**
	 * Establece el nombre de la lotería asociada a la apuesta de Chance.
	 *
	 * @param nombreLoteria Nuevo nombre de la lotería asociada a la apuesta de
	 *                      Chance.
	 */

	public void setNombreLoteria(String nombreLoteria) {
		this.nombreLoteria = nombreLoteria;
	}

	/**
	 * Obtiene el identificador único de la apuesta de Chance.
	 *
	 * @return Identificador único de la apuesta de Chance.
	 */

	public int getIdChance() {
		return idChance;
	}

	/**
	 * Establece el identificador único de la apuesta de Chance.
	 *
	 * @param idChance Nuevo identificador único de la apuesta de Chance.
	 */

	public void setIdChance(int idChance) {
		this.idChance = idChance;
	}

	/**
	 * Obtiene la lista de números asociados a la apuesta de Chance.
	 *
	 * @return Lista de números asociados a la apuesta de Chance.
	 */

	public int[] getNumeros() {
		return numeros;
	}

	/**
	 * Establece la lista de números asociados a la apuesta de Chance.
	 *
	 * @param numeros Nueva lista de números asociados a la apuesta de Chance.
	 */

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}

	/**
	 * Obtiene la cédula del apostador que realizó la apuesta de Chance.
	 *
	 * @return Cédula del apostador que realizó la apuesta de Chance.
	 */

	public long getCedulaAposdor() {
		return cedulaAposdor;
	}

	/**
	 * Establece la cédula del apostador que realizó la apuesta de Chance.
	 *
	 * @param cedulaAposdor Nueva cédula del apostador que realizó la apuesta de
	 *                      Chance.
	 */

	public void setCedulaAposdor(long cedulaAposdor) {
		this.cedulaAposdor = cedulaAposdor;
	}

	/**
	 * Obtiene la sede en la que se realizó la apuesta de Chance.
	 *
	 * @return Sede en la que se realizó la apuesta de Chance.
	 */

	public String getSedeApostador() {
		return sedeApostador;
	}

	/**
	 * Establece la sede en la que se realizó la apuesta de Chance.
	 *
	 * @param sedeApostador Nueva sede en la que se realizó la apuesta de Chance.
	 */

	public void setSedeApostador(String sedeApostador) {
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Genera una representación en cadena de la apuesta de Chance.
	 *
	 * @return Una cadena que representa la apuesta de Chance con detalles como el
	 *         nombre de la lotería, identificador único, lista de números, cédula
	 *         del apostador y sede.
	 */

	@Override
	public String toString() {
		return "ChanceDTO [nombreLoteria=" + nombreLoteria + ", idChance=" + idChance + ", numeros="
				+ Arrays.toString(numeros) + ", cedulaAposdor=" + cedulaAposdor + ", sedeApostador=" + sedeApostador
				+ "]";
	}

}
