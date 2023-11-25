package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.JuegoDTO;

/**
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 *         La clase JuegoDAO es responsable de gestionar la persistencia y
 *         operaciones CRUD de juegos.
 */

public class JuegoDAO {

	// Lista que almacena los juegos
	private ArrayList<JuegoDTO> listaJuegos;

	// Ruta del archivo CSV para guardar datos
	private final String FILEURL = "csv/juego.csv";

	// Nombre del archivo serializado
	private final String SERIAL_FILENAME = "juegos.dat";

	// Índice actual de la lista
	int index = 0;

	// Cadena de salida para escritura en archivos
	String exit = "";

	/**
	 * Constructor de la clase JuegoDAO.
	 */

	public JuegoDAO() {
		// TODO Auto-generated constructor stub
		listaJuegos = new ArrayList<JuegoDTO>();
		if (FileHandler.openAndReadFileJuego(SERIAL_FILENAME) != null) {
			@SuppressWarnings("unchecked")
			ArrayList<JuegoDTO> temp2 = FileHandler.openAndReadFileJuego(SERIAL_FILENAME);
			listaJuegos = temp2;
		} else {
			listaJuegos = new ArrayList<>();
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

	public void loadFromFile() {
		String content = FileHandler.openAndReadFile(FILEURL);
		if (content.equals("")) {
			return;
		}
		String[] lines = content.split("\n");
		for (int i = 0; i < lines.length; i++) {
			String[] strs = lines[i].split(";");
			int idJuego = Integer.parseInt(strs[0]);
			String nombreJuego = strs[1];
			String tipoJuego = strs[2];
			double presupuesto = Double.parseDouble(strs[3]);
			listaJuegos.add(new JuegoDTO(nombreJuego, tipoJuego, presupuesto, idJuego));
		}
	}

	/**
	 * Método para escribir datos en un archivo CSV.
	 */

	public void writeOnFile() {
		exit = "";
		listaJuegos.forEach((juego) -> {
			if (juego.getClass().getSimpleName().toString().equals("JuegoDTO")) {
				exit += juego.getIdJuego() + ";";
				exit += juego.getNombreJuego() + ";";
				exit += juego.getTipoJuego() + ";";
				exit += juego.getPresupuesto() + ";";

			}
		});
		FileHandler.openAndWriteFile(FILEURL, exit);
	}

	/**
	 * Crea un nuevo juego a partir de los parámetros proporcionados y lo agrega a
	 * la lista de juegos.
	 * 
	 * @param id          identificador del juego
	 * @param nombreJuego nombre del juego
	 * @param tipoJuego   tipo de juego
	 * @param Presupuesto presupuesto estimado para cada juego
	 */

	public void crearJuego(int id, String nombreJuego, String tipoJuego, double Presupuesto) {
		// TODO Auto-generated method stub
		listaJuegos.add(new JuegoDTO(nombreJuego, tipoJuego, Presupuesto, id));
		writeSerializable();
		writeOnFile();
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
	 */
	public boolean actualizarPresupuestoJuego(int idJuego, double nuevoPresupuesto) {
		for (JuegoDTO juego : listaJuegos) {
			if (juego.getIdJuego() == idJuego) {
				juego.setPresupuesto(nuevoPresupuesto);
				
				writeSerializable();
				writeOnFile();
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
	        return listaJuegos.stream()
	                .mapToInt(JuegoDTO::getIdJuego)
	                .max()
	                .orElse(0) + 1;
	    }
	}

	public ArrayList<JuegoDTO> getListaJuegos() {
		return listaJuegos;
	}

	public void setListaJuegos(ArrayList<JuegoDTO> listaJuegos) {
		this.listaJuegos = listaJuegos;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
