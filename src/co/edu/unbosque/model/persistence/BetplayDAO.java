package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.BetplayDTO;

/**
 * Clase que representa un DAO (Data Access Object) para gestionar operaciones relacionadas con BetplayDTO.
 */
public class BetplayDAO implements CRUDOperation {

	// Lista que almacena objetos BetplayDTO
	private ArrayList<BetplayDTO> apBetplay;
	// Nombre del archivo serializado
	private final String SERIAL_FILENAME = "apuestas-betplay.dat";
	// Índice para operaciones específicas
	private int index = 0;
	// Variable de salida para operaciones específicas
	private String exit = "";

	/**
	 * Constructor de la clase BetplayDAO. Inicializa la lista y carga datos desde el archivo serializado si existe.
	 */
	public BetplayDAO() {
		apBetplay = new ArrayList<BetplayDTO>();
		if (FileHandler.openAndReadFileBetplay(SERIAL_FILENAME) != null) {
			@SuppressWarnings("unchecked")
			ArrayList<BetplayDTO> temp2 = (ArrayList<BetplayDTO>) FileHandler.openAndReadFileBetplay(SERIAL_FILENAME);
			apBetplay = temp2;
		} else {
			apBetplay = new ArrayList<>();
		}
	}

	/**
	 * Método para escribir la lista serializada en el archivo.
	 */
	public void writeSerializable() {
		FileHandler.openAndWriteFileBetplay(SERIAL_FILENAME, apBetplay);
	}

	/**
	 * Crea un nuevo objeto BetplayDTO y lo agrega a la lista.
	 *
	 * @param strs Arreglo de cadenas con la información del nuevo objeto
	 *             BetplayDTO.
	 */
	
	@Override
	public void create(String... strs) {
		// TODO Auto-generated method stub
		BetplayDTO nBetplay = new BetplayDTO();
		nBetplay.setIdBetplay(Integer.parseInt(strs[0]));
		nBetplay.setDia(LocalDate.parse(strs[1]));
		nBetplay.setCedulaApostador(Long.parseLong(strs[2]));
		nBetplay.setSedeApostador(strs[3]);
		nBetplay.setPartido(strs[4]);
		nBetplay.setResultado(strs[5]);
		nBetplay.setValorApuesta(Double.parseDouble(strs[6]));
		apBetplay.add(nBetplay);
		writeSerializable();
	}
	/**
	 * Crea un nuevo objeto BetplayDTO y lo agrega a la lista.
	 *
	 * @param obj Objeto BetplayDTO a agregar.
	 */
	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		int salida = apBetplay.size() + 1;
		apBetplay.add((BetplayDTO) obj);
		writeSerializable();
	}
	/**
	 * Devuelve una cadena con la representación de todos los objetos BetplayDTO.
	 *
	 * @return Cadena con la representación de todos los objetos BetplayDTO.
	 */
	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		apBetplay.forEach((betplay) -> {
			sb.append((betplay.toString() + "\n"));
		});
		return sb.toString();
	}

	/**
	 * Busca una apuesta de Betplay por su identificador.
	 *
	 * @param index Identificador de la apuesta de Betplay a buscar.
	 * @return Objeto BetplayDTO si se encuentra, null de lo contrario.
	 */

	public BetplayDTO search(int index) {
		BetplayDTO salida = null;
		for (int i = 0; i < apBetplay.size(); i++) {
			if (apBetplay.get(i).getIdBetplay() == index
					&& apBetplay.get(i).getClass().getSimpleName().toString().equals("BetplayDTO")) {
				salida = ((BetplayDTO) apBetplay.get(i));
			}
		}
		return salida;
	}

	/**
	 * Verifica si existe una apuesta de Betplay con un identificador específico.
	 *
	 * @param index Identificador de la apuesta de Betplay a buscar.
	 * @return true si la apuesta existe, false de lo contrario.
	 */

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apBetplay.size(); i++) {
			if (apBetplay.get(i).getIdBetplay() == index) {
				salida = true;
			}
		}
		return salida;
	}

	/**
	 * Actualiza la información de un objeto BetplayDTO dado su índice.
	 *
	 * @param index   Índice del objeto BetplayDTO a actualizar.
	 * @param newData Nueva información del objeto BetplayDTO.
	 * @return True si la actualización fue exitosa, false en caso contrario.
	 */

	@Override
	public boolean updateByIndex(int index, String... newData) {
		for (int i = 0; i < apBetplay.size(); i++) {
			if (apBetplay.get(i).getIdBetplay() == index
					&& apBetplay.get(i).getClass().getSimpleName().toString().equals("BetplayDTO")) {
				apBetplay.get(i).setDia(LocalDate.parse(newData[0]));
				apBetplay.get(i).setCedulaApostador(Long.parseLong(newData[1]));
				apBetplay.get(i).setSedeApostador(newData[2]);
				apBetplay.get(i).setPartido(newData[3]);
				apBetplay.get(i).setResultado(newData[4]);
				apBetplay.get(i).setValorApuesta(Double.parseDouble(newData[5]));

				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un objeto BetplayDTO dado su índice.
	 *
	 * @param index Índice del objeto BetplayDTO a eliminar.
	 * @return True si la eliminación fue exitosa, false en caso contrario.
	 */

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < apBetplay.size(); i++) {
			if (apBetplay.get(i).getIdBetplay() == index
					&& apBetplay.get(i).getClass().getSimpleName().toString().equals("BetplayDTO")) {
				apBetplay.remove(i);
				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un objeto BetplayDTO dado el objeto BetplayDTO.
	 *
	 * @param obj El objeto BetplayDTO a eliminar.
	 * @return True si la eliminación fue exitosa, false en caso contrario.
	 */

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		BetplayDTO toDelete = ((BetplayDTO) obj);
		if (apBetplay.contains(toDelete)) {
			apBetplay.remove(index);
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calcula el valor total apostado por un cliente en todas las apuestas de
	 * Betplay.
	 *
	 * @param cedulaApostador Cédula del apostador.
	 * @return Valor total apostado por el cliente en todas las apuestas de Betplay.
	 */

	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
		double valorTotal = 0;
		for (BetplayDTO betplay : apBetplay) {
			if (betplay.getCedulaApostador() == cedulaApostador) {
				valorTotal += betplay.getValorApuesta();
			}
		}
		return valorTotal;
	}

	/**
	 * Calcula el valor total apostado en todas las apuestas de Betplay para una
	 * sede específica.
	 *
	 * @param sede Nombre de la sede.
	 * @return Valor total apostado en todas las apuestas de Betplay para la sede
	 *         específica.
	 */

	public double calcularTotalApuestasPorSede(String sede) {
		double total = 0;
		for (BetplayDTO betplay : apBetplay) {
			if (betplay.getSedeApostador() == sede) {
				total += betplay.getValorApuesta();
			}
		}
		return total;
	}

	/**
	 * Calcula el valor total apostado en todas las apuestas de Betplay.
	 *
	 * @return Valor total apostado en todas las apuestas de Betplay.
	 */

	public double calcularTotalValorApostado() {
		double total = 0;
		for (BetplayDTO betplay : apBetplay) {
			total += betplay.getValorApuesta();
		}
		return total;
	}

	/**
	 * Obtiene un detalle de las apuestas de Betplay realizadas por un apostador
	 * según su cédula.
	 *
	 * @param cedulaApostador Cédula del apostador.
	 * @return Detalle de las apuestas de Betplay realizadas por el apostador.
	 */

	public String obtenerDetalleApuestasPorCedula(long cedulaApostador) {

		ArrayList<String> detalles = new ArrayList<>();

		BetplayDAO betDAO = new BetplayDAO();
		for (BetplayDTO betplay : betDAO.getApBetplay()) {
			if (betplay.getCedulaApostador() == cedulaApostador) {
				detalles.add("ID Baloto: " + betplay.getIdBetplay() + ", Fecha: " + betplay.getDia() + ", Partido: "
						+ betplay.getPartido() + ", Resultado: " + betplay.getResultado() + ", Valor Apuesta: "
						+ betplay.getValorApuesta());
			}
		}

		// Construir la cadena de detalle
		StringBuilder detalleBuilder = new StringBuilder();
		if (!detalles.isEmpty()) {
			detalleBuilder.append("Detalle de apuestas para la cédula ").append(cedulaApostador).append(":\n");
			for (String detalle : detalles) {
				detalleBuilder.append(detalle).append("\n");
			}
		} else {
			detalleBuilder.append("No se encontraron apuestas para la cédula ").append(cedulaApostador).append(".");
		}

		return detalleBuilder.toString();
	}

	/**
	 * Obtiene un detalle de las apuestas de Betplay realizadas en una sede
	 * específica.
	 *
	 * @param nombreSede Nombre de la sede.
	 * @return Detalle de las apuestas de Betplay realizadas en la sede específica.
	 */

	public String obtenerDetalleApuestasPorSede(String nombreSede) {
		StringBuilder detalle = new StringBuilder();
		for (BetplayDTO betplay : apBetplay) {
			if (betplay.getSedeApostador().equalsIgnoreCase(nombreSede)) {
				detalle.append(betplay.toString()).append("\n");
			}
		}
		return detalle.toString();
	}

	/**
	 * Obtiene la lista de apuestas de Betplay.
	 *
	 * @return Lista de apuestas de Betplay.
	 */

	public ArrayList<BetplayDTO> getApBetplay() {
		return apBetplay;
	}

	/**
	 * Establece la lista de apuestas de Betplay.
	 *
	 * @param apBetplay Lista de apuestas de Betplay a establecer.
	 */

	public void setApBetplay(ArrayList<BetplayDTO> apBetplay) {
		this.apBetplay = apBetplay;
	}

	/**
	 * Obtiene el índice actual.
	 *
	 * @return Índice actual.
	 */

	public int getIndex() {
		return index;
	}

	/**
	 * Establece el índice actual.
	 *
	 * @param index Índice a establecer.
	 */

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Obtiene la cadena de salida.
	 *
	 * @return Cadena de salida.
	 */

	public String getExit() {
		return exit;
	}

	/**
	 * Establece la cadena de salida.
	 *
	 * @param exit Cadena de salida a establecer.
	 */

	public void setExit(String exit) {
		this.exit = exit;
	}

	/**
	 * Obtiene el nombre del archivo serializado.
	 *
	 * @return Nombre del archivo serializado.
	 */

	public String getSERIAL_FILENAME() {
		return SERIAL_FILENAME;
	}

}