package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class BalotoDTO extends ApuestaDTO implements Serializable {

	private int[] numeros;
	private int idBaloto;
	private long cedulaApostador;
	private String sedeApostador;

	public BalotoDTO() {
		// TODO Auto-generated constructor stub
	}

	public BalotoDTO(int[] numeros, int idBaloto, long cedulaApostador, String sedeApostador) {
		super();
		this.numeros = numeros;
		this.idBaloto = idBaloto;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	public BalotoDTO(LocalDate dia, double valorApuesta, int[] numeros, int idBaloto, long cedulaApostador,
			String sedeApostador) {
		super(dia, valorApuesta);
		this.numeros = numeros;
		this.idBaloto = idBaloto;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	public BalotoDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	public int[] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}

	public int getIdBaloto() {
		return idBaloto;
	}

	public void setIdBaloto(int idBaloto) {
		this.idBaloto = idBaloto;
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
		return "BalotoDTO{" + "idBaloto=" + idBaloto + ", cedulaApostador=" + cedulaApostador + ", sedeApostador='"
				+ sedeApostador + '\'' + ", numeros=" + Arrays.toString(numeros) + '}';
	}

}
