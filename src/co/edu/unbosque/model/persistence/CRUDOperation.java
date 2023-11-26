package co.edu.unbosque.model.persistence;

import java.time.LocalDate;

/**
 * 
 * La interfaz CRUDOperation define operaciones básicas de creación, lectura,
 * actualización y eliminación (CRUD).
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public interface CRUDOperation {

	/**
	 * Crea un nuevo objeto utilizando los valores proporcionados.
	 *
	 * @param strs Arreglo de cadenas que contiene los valores necesarios para la
	 *             creación del objeto.
	 */

	public void create(String... strs);

	/**
	 * Crea un nuevo objeto utilizando otro objeto como parámetro.
	 *
	 * @param obj Objeto que se utilizará para crear un nuevo objeto.
	 */

	public void create(Object obj);

	/**
	 * Devuelve una cadena que representa todos los objetos existentes.
	 *
	 * @return Cadena que contiene la representación de todos los objetos
	 *         existentes.
	 */

	public String readAll();

	/**
	 * Actualiza un objeto existente mediante la modificación de sus datos con
	 * nuevos valores.
	 *
	 * @param index   Índice del objeto que se va a actualizar.
	 * @param newData Nuevos valores que se utilizarán para actualizar el objeto.
	 * @return true si la actualización fue exitosa, false si no se pudo realizar la
	 *         actualización.
	 */

	public boolean updateByIndex(int index, String... newData);

	/**
	 * Elimina un objeto existente según su índice.
	 *
	 * @param index Índice del objeto que se va a eliminar.
	 * @return true si la eliminación fue exitosa, false si no se pudo realizar la
	 *         eliminación.
	 */

	public boolean delete(int index);

	/**
	 * Elimina un objeto existente mediante la comparación con otro objeto.
	 *
	 * @param obj Objeto que se va a eliminar.
	 * @return true si la eliminación fue exitosa, false si no se pudo realizar la
	 *         eliminación.
	 */

	public boolean delete(Object obj);

}