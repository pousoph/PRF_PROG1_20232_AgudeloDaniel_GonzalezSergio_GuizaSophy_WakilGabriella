package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.JuegoDTO;
import co.edu.unbosque.util.PresupuestoExcedidoException;

/**
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 *         La clase JuegoDAO es responsable de gestionar la persistencia y
 *         operaciones CRUD de juegos.
 */

public class JuegoDAO {

	private ConfiguracionDAO confDao;
	private ArrayList<JuegoDTO> listaJuegos;
	private final String SERIAL_FILENAME = "juegos.dat";

	public JuegoDAO() {
		listaJuegos = new ArrayList<JuegoDTO>();
		confDao = new ConfiguracionDAO(); // Initialize ConfiguracionDAO and load configuration

		if (FileHandler.openAndReadFileJuego(SERIAL_FILENAME) != null) {
			@SuppressWarnings("unchecked")
			ArrayList<JuegoDTO> temp2 = FileHandler.openAndReadFileJuego(SERIAL_FILENAME);
			listaJuegos = temp2;
		}
	}

	/**
	 * Método para escribir datos en un archivo serializado.
	 */

	public void writeSerializable() {
		FileHandler.openAndWriteFileJuego(SERIAL_FILENAME, listaJuegos);
	}

	/**
	 * Método para cargar datos desde un archivo CSV.
	 */

	/**
	 * Crea un nuevo juego a partir de los parámetros proporcionados y lo agrega a
	 * la lista de juegos.
	 * 
	 * @param id          identificador del juego
	 * @param nombreJuego nombre del juego
	 * @param tipoJuego   tipo de juego
	 * @param Presupuesto presupuesto estimado para cada juego
	 * @throws PresupuestoExcedidoException
	 */

	public void crearJuego(int id, String nombreJuego, String tipoJuego, double presupuesto)
			throws PresupuestoExcedidoException {
		if (confDao == null) {
			throw new IllegalStateException("confDao is not initialized");
		}

		double presupuestoTotalConfigurado = confDao.getConfiguracion().getPresupuestoTotal();

		if (presupuesto > presupuestoTotalConfigurado) {
			throw new PresupuestoExcedidoException(
					"El presupuesto del juego excede el límite establecido en la configuración");
		}

		listaJuegos.add(new JuegoDTO(nombreJuego, tipoJuego, presupuesto, id));
		writeSerializable();
	}

	/**
	 * Método para obtener el presupuesto de un juego por su ID.
	 *
	 * @param idJuego El ID del juego.
	 * @return El presupuesto del juego o -1 si no se encuentra.
	 */
	public double obtenerPresupuestoJuegoPorId(int idJuego) {
		for (JuegoDTO juego : listaJuegos) {
			if (juego.getIdJuego() == idJuego) {
				return juego.getPresupuesto();
			}
		}
		return -1; // Indica que no se encontró el juego
	}

	/**
	 * Método para obtener un juego por su ID.
	 *
	 * @param idJuego El ID del juego.
	 * @return El objeto JuegoDTO correspondiente al ID o null si no se encuentra.
	 */
	public JuegoDTO obtenerJuegoPorId(int idJuego) {
		for (JuegoDTO juego : listaJuegos) {
			if (juego.getIdJuego() == idJuego) {
				return juego;
			}
		}
		return null; // Indica que no se encontró el juego
	}

	/**
	 * Método para actualizar el presupuesto de un juego por su ID.
	 *
	 * @param idJuego          El ID del juego.
	 * @param nuevoPresupuesto El nuevo presupuesto para el juego.
	 * @return true si la actualización fue exitosa, de lo contrario, false.
	 * @throws PresupuestoExcedidoException
	 */
	public boolean actualizarPresupuestoJuego(int idJuego, double nuevoPresupuesto)
			throws PresupuestoExcedidoException {
		double presupuestoTotalConfigurado = confDao.getConfiguracion().getPresupuestoTotal();

		if (nuevoPresupuesto > presupuestoTotalConfigurado) {
			throw new PresupuestoExcedidoException(
					"El nuevo presupuesto del juego excede el límite establecido en la configuración");
		}

		for (JuegoDTO juego : listaJuegos) {
			if (juego.getIdJuego() == idJuego) {
				juego.setPresupuesto(nuevoPresupuesto);
				writeSerializable();
				return true;
			}
		}
		return false; // Indica que no se encontró el juego
	}

	public int obtenerProximoId() {
		if (listaJuegos.isEmpty()) {
			return 1; // Si la lista está vacía, retorna 1 como primer ID
		} else {
			// Encuentra el máximo ID actual y devuelve el siguiente
			return listaJuegos.stream().mapToInt(JuegoDTO::getIdJuego).max().orElse(0) + 1;
		}
	}

	public ArrayList<JuegoDTO> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(ArrayList<JuegoDTO> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}


}