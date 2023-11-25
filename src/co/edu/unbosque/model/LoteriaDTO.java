package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 *         La clase LoteriaDTO es una subclase de JuegoDTO y representa un juego
 *         de lotería. Contiene información sobre los números asociados al juego
 *         y un identificador único.
 */

public class LoteriaDTO extends ApuestaDTO implements Serializable {

	private String nombreLoteria;
	private int idLoteria;
	private int[] numeros;
	private int numSerie;
	private long cedulaApostador;
	private String sedeApostador;

	public LoteriaDTO() {
		// TODO Auto-generated constructor stub
	}

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

	public LoteriaDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	public String getNombreLoteria() {
		return nombreLoteria;
	}

	public void setNombreLoteria(String nombreLoteria) {
		this.nombreLoteria = nombreLoteria;
	}

	public int getIdLoteria() {
		return idLoteria;
	}

	public void setIdLoteria(int idLoteria) {
		this.idLoteria = idLoteria;
	}

	public int[] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}

	public int getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public long getCedulaApostador() {
		return cedulaApostador;
	}

	public void setCedulaApostador(long cedulaApostador) {
		this.cedulaApostador = cedulaApostador;
	}

	public String getSedeApostador() {
		return sedeApostador;
	}

	public void setSedeApostador(String sedeApostador) {
		this.sedeApostador = sedeApostador;
	}

	@Override
	public String toString() {
		return "LoteriaDTO [nombreLoteria=" + nombreLoteria + ", idLoteria=" + idLoteria + ", numeros="
				+ Arrays.toString(numeros) + ", numSerie=" + numSerie + ", cedulaApostador=" + cedulaApostador
				+ ", sedeApostador=" + sedeApostador + "]";
	}

}
