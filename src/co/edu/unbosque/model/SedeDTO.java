package co.edu.unbosque.model;

import java.io.Serializable;

public class SedeDTO implements Serializable{

	private String ubicacion;
	private int numEmpleados;
	private int idSede;

	public SedeDTO() {
		// TODO Auto-generated constructor stub
	}

	public SedeDTO(String ubicacion, int numEmpleados, int idSede) {
		super();
		this.ubicacion = ubicacion;
		this.numEmpleados = numEmpleados;
		this.idSede = idSede;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getNumEmpleados() {
		return numEmpleados;
	}

	public void setNumEmpleados(int numEmpleados) {
		this.numEmpleados = numEmpleados;
	}

	public int getIdSede() {
		return idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + idSede + "\n");
		sb.append("Ubicacion(Localidad): " + ubicacion + "\n");
		sb.append("Numero de empleados: " + numEmpleados + "\n");

		return sb.toString();

	}

}
