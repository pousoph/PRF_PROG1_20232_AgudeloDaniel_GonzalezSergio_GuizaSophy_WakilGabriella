package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 *         La clase ChanceDTO es una subclase de aDTO y representa un juego de
 *         Chance. Contiene información sobre el nombre de la lotería, los
 *         números asociados al juego y un identificador único.
 */

public class ChanceDTO extends ApuestaDTO implements Serializable {

	private String nombreLoteria;
	private int idChance;
	private int[] numeros;
	private long cedulaAposdor;
	private String sedeApostador;

	public ChanceDTO() {
		// TODO Auto-generated constructor stub
	}

	public ChanceDTO(String nombreLoteria, int idChance, int[] numeros, long cedulaAposdor, String sedeApostador) {
		super();
		this.nombreLoteria = nombreLoteria;
		this.idChance = idChance;
		this.numeros = numeros;
		this.cedulaAposdor = cedulaAposdor;
		this.sedeApostador = sedeApostador;
	}

	public ChanceDTO(LocalDate dia, double valorApuesta, String nombreLoteria, int idChance, int[] numeros,
			long cedulaAposdor, String sedeApostador) {
		super(dia, valorApuesta);
		this.nombreLoteria = nombreLoteria;
		this.idChance = idChance;
		this.numeros = numeros;
		this.cedulaAposdor = cedulaAposdor;
		this.sedeApostador = sedeApostador;
	}

	public ChanceDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	public String getNombreLoteria() {
		return nombreLoteria;
	}

	public void setNombreLoteria(String nombreLoteria) {
		this.nombreLoteria = nombreLoteria;
	}

	public int getIdChance() {
		return idChance;
	}

	public void setIdChance(int idChance) {
		this.idChance = idChance;
	}

	public int[] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}

	public long getCedulaAposdor() {
		return cedulaAposdor;
	}

	public void setCedulaAposdor(long cedulaAposdor) {
		this.cedulaAposdor = cedulaAposdor;
	}

	public String getSedeApostador() {
		return sedeApostador;
	}

	public void setSedeApostador(String sedeApostador) {
		this.sedeApostador = sedeApostador;
	}

	@Override
	public String toString() {
		return "ChanceDTO [nombreLoteria=" + nombreLoteria + ", idChance=" + idChance + ", numeros="
				+ Arrays.toString(numeros) + ", cedulaAposdor=" + cedulaAposdor + ", sedeApostador=" + sedeApostador
				+ "]";
	}

}