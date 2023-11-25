package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

public class BetplayDTO extends ApuestaDTO implements Serializable {

	private int idBetplay;
	private String resultado;
	private String partido;
	private long cedulaApostador;
	private String sedeApostador;

	public BetplayDTO() {
		// TODO Auto-generated constructor stub
	}

	public BetplayDTO(int idBetplay, String resultado, String partido, long cedulaApostador, String sedeApostador) {
		super();
		this.idBetplay = idBetplay;
		this.resultado = resultado;
		this.partido = partido;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	public BetplayDTO(LocalDate dia, double valorApuesta, int idBetplay, String resultado, String partido,
			long cedulaApostador, String sedeApostador) {
		super(dia, valorApuesta);
		this.idBetplay = idBetplay;
		this.resultado = resultado;
		this.partido = partido;
		this.cedulaApostador = cedulaApostador;
		this.sedeApostador = sedeApostador;
	}

	public BetplayDTO(LocalDate dia, double valorApuesta) {
		super(dia, valorApuesta);
		// TODO Auto-generated constructor stub
	}

	public int getIdBetplay() {
		return idBetplay;
	}

	public void setIdBetplay(int idBetplay) {
		this.idBetplay = idBetplay;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
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
		return "BetplayDTO [idBetplay=" + idBetplay + ", resultado=" + resultado + ", partido=" + partido
				+ ", cedulaApostador=" + cedulaApostador + ", sedeApostador=" + sedeApostador + "]";
	}

	

}
