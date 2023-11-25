package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ApuestaDTO implements Serializable {

	private LocalDate dia;
	private double valorApuesta;

	public ApuestaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ApuestaDTO(LocalDate dia, double valorApuesta) {
		super();
		this.dia = dia;
		this.valorApuesta = valorApuesta;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public double getValorApuesta() {
		return valorApuesta;
	}

	public void setValorApuesta(double valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Dia: " + dia + "\n");
		sb.append("Valor de la apuesta: " + valorApuesta + "\n");

		return sb.toString();
	}

}
