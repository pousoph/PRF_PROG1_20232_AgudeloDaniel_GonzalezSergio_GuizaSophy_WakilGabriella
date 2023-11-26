package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * 
 *         /** Clase que representa un objeto ApostadorDTO para almacenar
 *         información de un apostador. Implementa la interfaz Serializable para
 *         permitir la serialización.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class ApostadorDTO implements Serializable {

	/**
	 * Número de versión de la clase para control de serialización.
	 * 
	 */
	private static final long serialVersionUID = -6508662985917168474L;

	/** Identificador único del apostador. */
	private int id;

	/** Nombre del apostador. */
	private String name;

	/** Sede a la que pertenece el apostador. */
	private String sede;

	/** Dirección del apostador. */
	private String direccion;

	/** Número de celular del apostador. */
	private long numberCell;

	/** Número de cédula del apostador. */
	private long cedula;

	/**
	 * Constructor por defecto de la clase ApostadorDTO.
	 */

	public ApostadorDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con parámetros de la clase ApostadorDTO.
	 * 
	 * @param id         El identificador del apostador.
	 * @param name       El nombre del apostador.
	 * @param sede       La sede del apostador.
	 * @param direccion  La dirección del apostador.
	 * @param numberCell El número de celular del apostador.
	 * @param cedula     El número de cédula del apostador.
	 */

	public ApostadorDTO(int id, String name, String sede, String direccion, long numberCell, long cedula) {
		super();
		this.id = id;
		this.name = name;
		this.sede = sede;
		this.direccion = direccion;
		this.numberCell = numberCell;
		this.cedula = cedula;
	}

	/**
	 * Obtiene el identificador del apostador.
	 * 
	 * @return El identificador del apostador.
	 */

	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador del apostador.
	 * 
	 * @param id El identificador del apostador.
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del apostador.
	 * 
	 * @return El nombre del apostador.
	 */

	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del apostador.
	 * 
	 * @param name El nombre del apostador.
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene la sede del apostador.
	 * 
	 * @return La sede del apostador.
	 */

	public String getSede() {
		return sede;
	}

	/**
	 * Establece la sede del apostador.
	 * 
	 * @param sede La sede del apostador.
	 */

	public void setSede(String sede) {
		this.sede = sede;
	}

	/**
	 * Obtiene la dirección del apostador.
	 * 
	 * @return La dirección del apostador.
	 */

	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección del apostador.
	 * 
	 * @param direccion La dirección del apostador.
	 */

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene el número de celular del apostador.
	 * 
	 * @return El número de celular del apostador.
	 */

	public long getNumberCell() {
		return numberCell;
	}

	/**
	 * Establece el número de celular del apostador.
	 * 
	 * @param numberCell El número de celular del apostador.
	 */

	public void setNumberCell(long numberCell) {
		this.numberCell = numberCell;
	}

	/**
	 * Obtiene el número de cédula del apostador.
	 * 
	 * @return El número de cédula del apostador.
	 */

	public long getCedula() {
		return cedula;
	}

	/**
	 * Establece el número de cédula del apostador.
	 * 
	 * @param cedula El número de cédula del apostador.
	 */

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	/**
	 * Devuelve una representación de cadena del objeto ApostadorDTO.
	 * 
	 * @return Una representación de cadena del objeto ApostadorDTO.
	 */

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