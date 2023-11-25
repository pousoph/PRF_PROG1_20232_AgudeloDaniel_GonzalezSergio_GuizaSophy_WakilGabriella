package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 *         La clase SuperAstroDTO es una subclase de ApuestaDTO y representa un
 *         juego de Super Astro. Contiene información sobre los números
 *         asociados al juego, el signo zodiacal y un identificador único.
 */

public class SuperAstroDTO extends ApuestaDTO implements Serializable {

	private int idSuperAstro;
	private int[] numeros;
	private String signoZodiacal;
	private long cedulaApostador;
	private String ubicacionApostador;

	public SuperAstroDTO() {
		// TODO Auto-generated constructor stub
	}

	public SuperAstroDTO(int idSuperAstro, int[] numeros, String signoZodiacal, long cedulaApostador,
			String ubicacionApostador) {
		super();
		this.idSuperAstro = idSuperAstro;
		this.numeros = numeros;
		this.signoZodiacal = signoZodiacal;
		this.cedulaApostador = cedulaApostador;
		this.ubicacionApostador = ubicacionApostador;
	}

	public SuperAstroDTO(LocalDate dia, double valorApuesta, int idSuperAstro, int[] numeros, String signoZodiacal,
			long cedulaApostador, String ubicacionApostador) {
		super(dia, valorApuesta);
		this.idSuperAstro = idSuperAstro;
		this.numeros = numeros;
		this.signoZodiacal = signoZodiacal;
		this.cedulaApostador = cedulaApostador;
		this.ubicacionApostador = ubicacionApostador;
	}

	public SuperAstroDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	public int getIdSuperAstro() {
		return idSuperAstro;
	}

	public void setIdSuperAstro(int idSuperAstro) {
		this.idSuperAstro = idSuperAstro;
	}

	public int[] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}

	public String getSignoZodiacal() {
		return signoZodiacal;
	}

	public void setSignoZodiacal(String signoZodiacal) {
		this.signoZodiacal = signoZodiacal;
	}

	public long getCedulaApostador() {
		return cedulaApostador;
	}

	public void setCedulaApostador(long cedulaApostador) {
		this.cedulaApostador = cedulaApostador;
	}

	public String getUbicacionApostador() {
		return ubicacionApostador;
	}

	public void setUbicacionApostador(String ubicacionApostador) {
		this.ubicacionApostador = ubicacionApostador;
	}

	@Override
	public String toString() {
		return "SuperAstroDTO [idSuperAstro=" + idSuperAstro + ", numeros=" + Arrays.toString(numeros)
				+ ", signoZodiacal=" + signoZodiacal + ", cedulaApostador=" + cedulaApostador + ", ubicacionApostador="
				+ ubicacionApostador + "]";
	}

}
