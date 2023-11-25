package co.edu.unbosque.model;

import java.io.Serializable;

public class ApostadorDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6508662985917168474L;
	private int id;
	private String name;
	private String sede;
	private String direccion;
	private long numberCell;
	private long cedula;

	public ApostadorDTO() {
		// TODO Auto-generated constructor stub
	}

	public ApostadorDTO(int id, String name, String sede, String direccion, long numberCell, long cedula) {
		super();
		this.id = id;
		this.name = name;
		this.sede = sede;
		this.direccion = direccion;
		this.numberCell = numberCell;
		this.cedula = cedula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getNumberCell() {
		return numberCell;
	}

	public void setNumberCell(long numberCell) {
		this.numberCell = numberCell;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: " + id + "\n");
		sb.append("Nombre: " + name + "\n");
		sb.append("Numero de documento: " + cedula + "\n");
		sb.append("Sede: " + sede + "\n");
		sb.append("Direccion: " + direccion + "\n");
		sb.append("Celular: " + numberCell + "\n");

		return sb.toString();
	}

}
