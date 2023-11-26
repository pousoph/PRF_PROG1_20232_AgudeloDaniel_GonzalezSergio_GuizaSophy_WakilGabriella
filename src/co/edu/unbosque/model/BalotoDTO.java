package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * 
 * 
 *         Representa un objeto de transferencia de datos (DTO) para el juego de
 *         Baloto, que extiende JuegoDTO e implementa Serializable. Contiene
 *         información como ID, números elegidos, si es una revancha, costo y
 *         premio.
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class BalotoDTO extends ApuestaDTO implements Serializable {

	/**
	 * UID serial predeterminado para la serialización.
	 */
	private static final long serialVersionUID = -2523223150663283170L;
	private int[] numeros;
	private int idBaloto;
	private long cedulaApostador;
	private String sedeApostador;

	/**
	 * Constructor por defecto de la clase BalotoDTO.
	 */
	public BalotoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa los atributos de la apuesta de Baloto con valores
	 * proporcionados.
	 *
	 * @param numeros         Conjunto de números elegidos.
	 * @param idBaloto        Identificador único de la apuesta de Baloto.
	 * @param cedulaApostador Cédula del apostador que realizó la apuesta.
	 * @param sedeApostador   Sede en la que se realizó la apuesta.
	 */

	public BalotoDTO(int[] numeros, int idBaloto, long cedulaApostador, String sedeApostador) {
		super();
		this.numeros = numeros;
		this.idBaloto = idBaloto;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Constructor que inicializa los atributos de la apuesta de Baloto con valores
	 * proporcionados, incluyendo la fecha y el valor de la apuesta.
	 *
	 * @param dia             Fecha de la apuesta.
	 * @param valorApuesta    Valor de la apuesta.
	 * @param numeros         Conjunto de números elegidos.
	 * @param idBaloto        Identificador único de la apuesta de Baloto.
	 * @param cedulaApostador Cédula del apostador que realizó la apuesta.
	 * @param sedeApostador   Sede en la que se realizó la apuesta.
	 */

	public BalotoDTO(LocalDate dia, double valorApuesta, int[] numeros, int idBaloto, long cedulaApostador,
			String sedeApostador) {
		super(dia, valorApuesta);
		this.numeros = numeros;
		this.idBaloto = idBaloto;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Constructor que inicializa la fecha y el valor de la apuesta de Baloto con
	 * valores proporcionados.
	 *
	 * @param dia          Fecha de la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 */

	public BalotoDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el conjunto de números elegidos para la apuesta de Baloto.
	 *
	 * @return Conjunto de números elegidos.
	 */

	public int[] getNumeros() {
		return numeros;
	}

	/**
	 * Establece el conjunto de números elegidos para la apuesta de Baloto.
	 *
	 * @param numeros Nuevo conjunto de números elegidos.
	 */

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}

	/**
	 * Obtiene el identificador único de la apuesta de Baloto.
	 *
	 * @return Identificador único de la apuesta de Baloto.
	 */

	public int getIdBaloto() {
		return idBaloto;
	}

	/**
	 * Establece el identificador único de la apuesta de Baloto.
	 *
	 * @param idBaloto Nuevo identificador único de la apuesta de Baloto.
	 */

	public void setIdBaloto(int idBaloto) {
		this.idBaloto = idBaloto;
	}

	/**
	 * Obtiene la cédula del apostador que realizó la apuesta de Baloto.
	 *
	 * @return Cédula del apostador.
	 */

	public long getCedulaApostador() {
		return cedulaApostador;
	}

	/**
	 * Establece la cédula del apostador que realizó la apuesta de Baloto.
	 *
	 * @param cedulaApostador Nueva cédula del apostador.
	 */

	public void setCedulaApostador(long cedulaApostador) {
		this.cedulaApostador = cedulaApostador;
	}

	/**
	 * Obtiene la sede en la que se realizó la apuesta de Baloto.
	 *
	 * @return Sede en la que se realizó la apuesta de Baloto.
	 */

	public String getSedeApostador() {
		return sedeApostador;
	}

	/**
	 * Establece la sede en la que se realizó la apuesta de Baloto.
	 *
	 * @param sedeApostador Nueva sede en la que se realizó la apuesta de Baloto.
	 */

	public void setSedeApostador(String sedeApostador) {
		this.sedeApostador = sedeApostador;
	}

	/**
	 * Genera una representación en cadena de la apuesta de Baloto.
	 *
	 * @return Una cadena que representa la apuesta de Baloto con detalles como
	 *         identificador, cédula del apostador, sede, y conjunto de números
	 *         elegidos.
	 */

	@Override
	public String toString() {
		return "BalotoDTO{" + "idBaloto=" + idBaloto + ", cedulaApostador=" + cedulaApostador + ", sedeApostador='"
				+ sedeApostador + '\'' + ", numeros=" + Arrays.toString(numeros) + '}';
	}

}