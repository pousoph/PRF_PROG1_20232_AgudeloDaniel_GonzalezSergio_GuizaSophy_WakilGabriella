package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * 
 * 
 *         La clase SuperAstroDTO es una subclase de ApuestaDTO y representa un
 *         juego de Super Astro. Contiene información sobre los números
 *         asociados al juego, el signo zodiacal y un identificador único.
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class SuperAstroDTO extends ApuestaDTO implements Serializable {

	// Identificador del juego SuperAstro
	private int idSuperAstro;

	// Números seleccionados en la apuesta
	private int[] numeros;

	// Signo zodiacal asociado a la apuesta
	private String signoZodiacal;

	// Cédula del apostador
	private long cedulaApostador;

	// Ubicación del apostador
	private String ubicacionApostador;

	/**
	 * Constructor de la clase SuperAstroDTO que inicializa algunos atributos con
	 * valores predeterminados.
	 */

	public SuperAstroDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase SuperAstroDTO que inicializa los atributos con
	 * valores proporcionados.
	 *
	 * @param idSuperAstro       Identificador del juego SuperAstro.
	 * @param numeros            Números seleccionados en la apuesta.
	 * @param signoZodiacal      Signo zodiacal asociado a la apuesta.
	 * @param cedulaApostador    Cédula del apostador.
	 * @param ubicacionApostador Ubicación del apostador.
	 */

	public SuperAstroDTO(int idSuperAstro, int[] numeros, String signoZodiacal, long cedulaApostador,
			String ubicacionApostador) {
		super();
		this.idSuperAstro = idSuperAstro;
		this.numeros = numeros;
		this.signoZodiacal = signoZodiacal;
		this.cedulaApostador = cedulaApostador;
		this.ubicacionApostador = ubicacionApostador;
	}

	/**
	 * Constructor de la clase SuperAstroDTO que inicializa algunos atributos con
	 * valores proporcionados, incluyendo atributos heredados de la clase
	 * ApuestaDTO.
	 *
	 * @param dia                Fecha de la apuesta.
	 * @param valorApuesta       Valor de la apuesta.
	 * @param idSuperAstro       Identificador del juego SuperAstro.
	 * @param numeros            Números seleccionados en la apuesta.
	 * @param signoZodiacal      Signo zodiacal asociado a la apuesta.
	 * @param cedulaApostador    Cédula del apostador.
	 * @param ubicacionApostador Ubicación del apostador.
	 */

	public SuperAstroDTO(LocalDate dia, double valorApuesta, int idSuperAstro, int[] numeros, String signoZodiacal,
			long cedulaApostador, String ubicacionApostador) {
		super(dia, valorApuesta);
		this.idSuperAstro = idSuperAstro;
		this.numeros = numeros;
		this.signoZodiacal = signoZodiacal;
		this.cedulaApostador = cedulaApostador;
		this.ubicacionApostador = ubicacionApostador;
	}

	/**
	 * Constructor de la clase SuperAstroDTO que inicializa algunos atributos con
	 * valores predeterminados, incluyendo atributos heredados de la clase
	 * ApuestaDTO.
	 *
	 * @param dia          Fecha de la apuesta.
	 * @param valorApuesta Valor de la apuesta.
	 */

	public SuperAstroDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene el identificador del juego SuperAstro.
	 *
	 * @return Identificador del juego SuperAstro.
	 */

	public int getIdSuperAstro() {
		return idSuperAstro;
	}

	/**
	 * Establece el identificador del juego SuperAstro.
	 *
	 * @param idSuperAstro Nuevo identificador del juego SuperAstro.
	 */

	public void setIdSuperAstro(int idSuperAstro) {
		this.idSuperAstro = idSuperAstro;
	}

	/**
	 * Obtiene los números seleccionados en la apuesta.
	 *
	 * @return Números seleccionados en la apuesta.
	 */

	public int[] getNumeros() {
		return numeros;
	}

	/**
	 * Establece los números seleccionados en la apuesta.
	 *
	 * @param numeros Nuevos números seleccionados en la apuesta.
	 */

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}

	/**
	 * Obtiene el signo zodiacal asociado a la apuesta.
	 *
	 * @return Signo zodiacal asociado a la apuesta.
	 */

	public String getSignoZodiacal() {
		return signoZodiacal;
	}

	/**
	 * Establece el signo zodiacal asociado a la apuesta.
	 *
	 * @param signoZodiacal Nuevo signo zodiacal asociado a la apuesta.
	 */

	public void setSignoZodiacal(String signoZodiacal) {
		this.signoZodiacal = signoZodiacal;
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
	 * Obtiene la ubicación del apostador.
	 *
	 * @return Ubicación del apostador.
	 */

	public String getUbicacionApostador() {
		return ubicacionApostador;
	}

	/**
	 * Establece la ubicación del apostador.
	 *
	 * @param ubicacionApostador Nueva ubicación del apostador.
	 */

	public void setUbicacionApostador(String ubicacionApostador) {
		this.ubicacionApostador = ubicacionApostador;
	}

	/**
	 * Genera una representación en cadena de la apuesta SuperAstro con detalles
	 * como el identificador, los números seleccionados, el signo zodiacal, la
	 * cédula del apostador y la ubicación del apostador.
	 *
	 * @return Una cadena que representa la apuesta SuperAstro.
	 */

	@Override
	public String toString() {
		return "SuperAstroDTO [idSuperAstro=" + idSuperAstro + ", numeros=" + Arrays.toString(numeros)
				+ ", signoZodiacal=" + signoZodiacal + ", cedulaApostador=" + cedulaApostador + ", ubicacionApostador="
				+ ubicacionApostador + "]";
	}

}