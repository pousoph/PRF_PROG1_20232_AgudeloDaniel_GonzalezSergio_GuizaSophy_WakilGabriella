package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.SedeDTO;
import co.edu.unbosque.util.SedeNoEncontradaException;

/**
 * 
 * La clase SedeDAO representa un Objeto de Acceso a Datos (DAO) para gestionar
 * objetos SedeDTO. Implementa la interfaz CRUDOperation.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class SedeDAO implements CRUDOperation {

	private ArrayList<SedeDTO> listaSedes;
	private ArrayList<ApostadorDTO> apostadores1;
	private ApostadorDAO apostadores;
	private final String SERIAL_FILENAME = "sedes.dat";
	int index = 0;

	/**
	 * Constructor de la clase SedeDAO. Inicializa la lista de sedes leyendo desde
	 * un archivo serializado.
	 */

	public SedeDAO() {
		// TODO Auto-generated constructor stub
		listaSedes = new ArrayList<SedeDTO>();
		if (FileHandler.openAndReadFileSede(SERIAL_FILENAME) != null) {
			ArrayList<SedeDTO> temp3 = FileHandler.openAndReadFileSede(SERIAL_FILENAME);
			listaSedes = temp3;
		} else {
			listaSedes = new ArrayList<>();
		}
	}

	/**
	 * Escribe la lista actual de sedes en un archivo serializado.
	 */

	public void writeSerializable() {
		FileHandler.openAndWriteFileSede(SERIAL_FILENAME, listaSedes);
	}

	/**
	 * Crea una nueva sede y la agrega a la lista.
	 *
	 * @param strs Arreglo de cadenas con la información de la nueva sede.
	 */

	@Override
	public void create(String... strs) {
		// TODO Auto-generated method stub
		SedeDTO nSede = new SedeDTO();
		nSede.setIdSede(Integer.parseInt(strs[0]));
		nSede.setUbicacion(strs[1]);
		nSede.setNumEmpleados(Integer.parseInt(strs[2]));
		listaSedes.add(nSede);
		writeSerializable();

	}

	/**
	 * Crea una nueva sede y la agrega a la lista.
	 *
	 * @param obj Objeto SedeDTO a agregar.
	 */

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		listaSedes.add((SedeDTO) obj);

	}

	/**
	 * Devuelve una cadena con la representación de todas las sedes.
	 *
	 * @return Cadena con la representación de todas las sedes.
	 */

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		listaSedes.forEach((sede) -> {
			sb.append((sede.toString() + "\n"));
		});
		return sb.toString();
	}

	/**
	 * Busca la existencia de una sede por su ID.
	 *
	 * @param index El ID de la sede a buscar.
	 * @return true si se encuentra una sede con el ID proporcionado, false en caso
	 *         contrario.
	 */

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < listaSedes.size(); i++) {
			if (listaSedes.get(i).getIdSede() == index) {
				salida = true;
			}
		}
		return salida;
	}

	/**
	 * Busca y devuelve una sede por su ID.
	 *
	 * @param index El ID de la sede a buscar.
	 * @return La sede correspondiente al ID proporcionado, o null si no se
	 *         encuentra.
	 */

	public SedeDTO search(int index) {
		SedeDTO salida = null;
		for (int i = 0; i < listaSedes.size(); i++) {
			if (listaSedes.get(i).getIdSede() == index
					&& listaSedes.get(i).getClass().getSimpleName().toString().equals("SedeDTO")) {
				salida = ((SedeDTO) listaSedes.get(i));
			}
		}
		return salida;
	}

	/**
	 * Obtiene las cédulas de los apostadores en una sede específica.
	 *
	 * @param sede La sede para la cual se desean obtener las cédulas.
	 * @return Una cadena que contiene las cédulas de los apostadores en la sede
	 *         especificada.
	 */

	public String getCedulasPorSede(String sede) {
		List<ApostadorDTO> apostadoresEnSede = ((Collection<ApostadorDTO>) apostadores).stream()
				.filter(apostador -> apostador.getSede().equalsIgnoreCase(sede)).collect(Collectors.toList());

		StringBuilder result = new StringBuilder("Cédulas en la sede " + sede + ":\n");
		apostadoresEnSede.forEach(apostador -> result.append(apostador.getCedula()).append("\n"));
		return result.toString();
	}

	/**
	 * Actualiza la información de una sede dado su índice.
	 *
	 * @param index   Índice de la sede a actualizar.
	 * @param newData Nueva información de la sede.
	 * @return True si la actualización fue exitosa, false en caso contrario.
	 */

	@Override
	public boolean updateByIndex(int index, String... newData) {
		for (int i = 0; i < listaSedes.size(); i++) {
			if (listaSedes.get(i).getIdSede() == index && listaSedes.get(i) instanceof SedeDTO) {
				((SedeDTO) listaSedes.get(i)).setUbicacion(newData[0]);
				((SedeDTO) listaSedes.get(i)).setNumEmpleados(Integer.parseInt(newData[1]));
				writeSerializable();
				return true;
			}
		}
		return false; // Devolver false si no se encuentra la sede con el índice proporcionado
	}

	/**
	 * Elimina una sede dado su índice.
	 *
	 * @param index Índice de la sede a eliminar.
	 * @return True si la eliminación fue exitosa, false en caso contrario.
	 */

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaSedes.size(); i++) {
			if (listaSedes.get(i).getIdSede() == index
					&& listaSedes.get(i).getClass().getSimpleName().toString().equals("SedeDTO")) {
				listaSedes.remove(i);
				writeSerializable();
			}
		}
		return false;
	}

	/**
	 * Elimina una sede dado el objeto SedeDTO.
	 *
	 * @param obj El objeto SedeDTO a eliminar.
	 * @return True si la eliminación fue exitosa, false en caso contrario.
	 */

	@Override
	public boolean delete(Object obj) {
		SedeDTO toDelete = ((SedeDTO) obj);
		if (listaSedes.remove(toDelete)) {
			listaSedes.remove(index);
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}

	public String obtenerSedePorNombre(String nombreSede) {
		for (SedeDTO sede : listaSedes) {
			if (sede.getUbicacion().equalsIgnoreCase(nombreSede.trim())) {
				{
					return sede.getUbicacion();
				}
			}

		}
		throw new SedeNoEncontradaException("Sede no encontrada para el nombre: " + nombreSede);

	}

	/**
	 * Obtiene la lista de sedes.
	 *
	 * @return La lista de sedes.
	 */

	public ArrayList<SedeDTO> getListaSedes() {
		return listaSedes;
	}

	/**
	 * Establece la lista de sedes.
	 *
	 * @param listaSedes La lista de sedes a establecer.
	 */

	public void setListaSedes(ArrayList<SedeDTO> listaSedes) {
		this.listaSedes = listaSedes;
	}

	/**
	 * Establece el objeto ApostadorDAO.
	 *
	 * @param nuevoApostador El nuevo objeto ApostadorDAO a establecer.
	 */

	public void setApostador(ApostadorDAO nuevoApostador) {
		this.apostadores = nuevoApostador;
	}

	/**
	 * Obtiene el objeto ApostadorDAO.
	 *
	 * @return El objeto ApostadorDAO.
	 */

	public ApostadorDAO getApostador() {
		return apostadores;
	}

	/**
	 * Obtiene la lista de apostadores.
	 *
	 * @return La lista de apostadores.
	 */

	public List<ApostadorDTO> getApostadores1() {
		return apostadores1;
	}

	/**
	 * Obtiene el índice actual.
	 *
	 * @return El índice actual.
	 */

	public int getIndex() {
		return index;
	}

	/**
	 * Establece el índice actual.
	 *
	 * @param index El índice actual a establecer.
	 */

	public void setIndex(int index) {
		this.index = index;
	}

}
