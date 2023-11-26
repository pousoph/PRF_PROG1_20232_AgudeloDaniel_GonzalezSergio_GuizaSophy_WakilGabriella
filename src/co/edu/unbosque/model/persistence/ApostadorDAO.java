package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.unbosque.model.ApostadorDTO;

/**
 * 
 *         Clase que implementa la interfaz CRUDOperation para la gestión de
 *         apostadores. Utiliza un ArrayList para almacenar los objetos
 *         ApostadorDTO y proporciona métodos para realizar operaciones CRUD
 *         (Crear, Leer, Actualizar, Eliminar).
 *
 *         <p>
 *         La clase también utiliza la clase FileHandler para la manipulación de
 *         archivos serializables.
 *         </p>
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class ApostadorDAO implements CRUDOperation {

	private ArrayList<ApostadorDTO> apostadores;
	private final String SERIAL_FILENAME = "apostadores.dat";
	int index = 0;

	/**
	 * Constructor que inicializa la lista de apostadores. Si hay datos
	 * serializables previos, los carga; de lo contrario, crea una lista vacía.
	 */

	public ApostadorDAO() {
		apostadores = new ArrayList<ApostadorDTO>();
		if (FileHandler.openAndReadFileApostador(SERIAL_FILENAME) != null) {
			ArrayList<ApostadorDTO> temp2 = FileHandler.openAndReadFileApostador(SERIAL_FILENAME);
			apostadores = temp2;
		} else {
			apostadores = new ArrayList<>();
		}
	}

	/**
	 * Método para escribir la lista de apostadores en un archivo serializable.
	 */

	public void writeSerializable() {
		FileHandler.openAndWriteFileApostador(SERIAL_FILENAME, apostadores);
	}

	/**
	 * Implementación del método de creación de la interfaz CRUDOperation. Crea un
	 * nuevo objeto ApostadorDTO con los datos proporcionados y lo agrega a la
	 * lista.
	 *
	 * @param strs Arreglo de strings con los datos del apostador.
	 */

	@Override
	public void create(String... strs) {
		// TODO Auto-generated method stub
		ApostadorDTO newApostador = new ApostadorDTO();
		newApostador.setId(Integer.parseInt(strs[0]));
		newApostador.setName(strs[1]);
		newApostador.setCedula(Long.parseLong(strs[2]));
		newApostador.setSede(strs[3]);
		newApostador.setDireccion(strs[4]);
		newApostador.setNumberCell(Long.parseLong(strs[5]));

		apostadores.add(newApostador);
		writeSerializable();

	}

	/**
	 * Realiza la depuración de la lista de apostadores según el criterio
	 * especificado.
	 * 
	 * @param ops El criterio de depuración (1 para nombre, 2 para cédula, 3 para
	 *            sede).
	 * @param bus El valor a utilizar como filtro de depuración.
	 * @return Una cadena con la representación de los apostadores que cumplen con
	 *         el criterio de depuración.
	 */

	public String depurar(int ops, Object bus) {
		String salida = "";
		// Depurar por nombre
		if (ops == 1) {
			String name = (String) bus;
			for (int i = 0; i < apostadores.size(); i++) {
				if (apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")
						&& ((ApostadorDTO) apostadores.get(i)).getName().toLowerCase().contains(name.toLowerCase())) {
					salida += ((ApostadorDTO) apostadores.get(i)).toString() + "\n";
				}

			}
			// Depurar por cedula
		} else if (ops == 2) {
			for (int i = 0; i < apostadores.size(); i++) {
				Long cedula = Long.parseLong(bus + "");
				if (apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")) {
					String aux = ((ApostadorDTO) apostadores.get(i)).getCedula() + "";
					if (aux.contains(cedula + "")) {
						salida += ((ApostadorDTO) apostadores.get(i)).toString() + "\n";
					}
				}
			}
			// Depurar sede
		} else if (ops == 3) {
			for (int i = 0; i < apostadores.size(); i++) {
				String sede = (String) bus;
				if (apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")
						&& ((ApostadorDTO) apostadores.get(i)).getSede().toLowerCase().contains(sede.toLowerCase())) {
					salida += ((ApostadorDTO) apostadores.get(i)).toString() + "\n";
				}
			}
		}
		return salida;
	}

	/**
	 * Verifica si existe un apostador con el ID proporcionado.
	 * 
	 * @param index El ID a buscar.
	 * @return true si se encuentra un apostador con el ID especificado, false en
	 *         caso contrario.
	 */

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getId() == index) {
				salida = true;
			}
		}
		return salida;
	}

	/**
	 * Busca un apostador por su ID.
	 * 
	 * @param index El ID del apostador a buscar.
	 * @return El objeto ApostadorDTO correspondiente al ID proporcionado, o null si
	 *         no se encuentra.
	 */

	public ApostadorDTO search(int index) {
		ApostadorDTO salida = null;
		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getId() == index
					&& apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")) {
				salida = ((ApostadorDTO) apostadores.get(i));
			}
		}
		return salida;
	}

	/**
	 * Crea un nuevo apostador a partir de un objeto y lo agrega a la lista.
	 *
	 * @param obj El objeto ApostadorDTO a agregar.
	 */

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		apostadores.add((ApostadorDTO) obj);
		writeSerializable();

	}

	/**
	 * Devuelve una cadena con la representación de todos los apostadores.
	 *
	 * @return Cadena con la representación de todos los apostadores.
	 */

	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		apostadores.forEach((apostador) -> {
			sb.append((apostador.toString() + "\n"));
		});
		return sb.toString();
	}

	/**
	 * Obtiene la lista de cédulas de apostadores para una sede específica.
	 *
	 * @param sede La sede para la cual se desea obtener las cédulas.
	 * @return Lista de cédulas de los apostadores en la sede especificada.
	 */

	public List<Long> getCedulasPorSede(String sede) {
		List<ApostadorDTO> apostadoresEnSede = apostadores.stream()
				.filter(apostador -> apostador.getSede().equalsIgnoreCase(sede)).collect(Collectors.toList());

		return apostadoresEnSede.stream().map(ApostadorDTO::getCedula).collect(Collectors.toList());
	}

	/**
	 * Obtiene la lista de apostadores para una sede específica.
	 *
	 * @param sede La sede para la cual se desea obtener la lista de apostadores.
	 * @return Lista de apostadores en la sede especificada.
	 */

	public List<ApostadorDTO> getApostadoresPorSede(String sede) {
		// Filtrar la lista de apostadores por la sede proporcionada
		List<ApostadorDTO> apostadoresEnSede = apostadores.stream()
				.filter(apostador -> apostador.getSede().equalsIgnoreCase(sede)).collect(Collectors.toList());

		return apostadoresEnSede;
	}

	/**
	 * Actualiza la información de un apostador dado su índice.
	 *
	 * @param index   Índice del apostador a actualizar.
	 * @param newData Nueva información del apostador.
	 * @return True si la actualización fue exitosa, false en caso contrario.
	 */

	@Override
	public boolean updateByIndex(int index, String... newData) {
		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getId() == index
					&& apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")) {
				apostadores.get(i).setName(newData[0]);
				apostadores.get(i).setCedula(Long.parseLong(newData[1]));
				apostadores.get(i).setSede(newData[2]);
				apostadores.get(i).setDireccion(newData[3]);
				apostadores.get(i).setNumberCell(Long.parseLong(newData[4]));

				writeSerializable();
				return true;
			}
		}
		return true;
	}

	/**
	 * Elimina un apostador dado su índice.
	 *
	 * @param index Índice del apostador a eliminar.
	 * @return True si la eliminación fue exitosa, false en caso contrario.
	 */

	@Override
	public boolean delete(int index) {
		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getId() == index
					&& apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")) {
				apostadores.remove(i);
				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un apostador dado el objeto ApostadorDTO.
	 *
	 * @param obj El objeto ApostadorDTO a eliminar.
	 * @return True si la eliminación fue exitosa, false en caso contrario.
	 */

	@Override
	public boolean delete(Object obj) {
		ApostadorDTO toDelete = ((ApostadorDTO) obj);
		if (apostadores.contains(toDelete)) {
			apostadores.remove(index);
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Obtiene la lista de apostadores.
	 *
	 * @return La lista de apostadores.
	 */

	public ArrayList<ApostadorDTO> getApostadores() {
		return apostadores;
	}

	/**
	 * Establece la lista de apostadores.
	 *
	 * @param apostadores La lista de apostadores a establecer.
	 */

	public void setApostadores(ArrayList<ApostadorDTO> apostadores) {
		this.apostadores = apostadores;
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