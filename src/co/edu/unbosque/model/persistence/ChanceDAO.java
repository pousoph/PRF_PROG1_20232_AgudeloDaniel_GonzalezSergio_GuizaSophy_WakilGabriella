package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.model.ChanceDTO;

/**
 * 
 *         La clase ChanceDAO implementa las operaciones CRUD para gestionar
 *         juegos de Chance.
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class ChanceDAO implements CRUDOperation {

	// Lista que almacena objetos de tipo ChanceDTO
	private ArrayList<ChanceDTO> apChance;

	// Nombre del archivo para serialización de datos
	private final String SERIAL_FILENAME = "apuestas-chance.dat";

	// Índice utilizado en el procesamiento de datos
	int index = 0;

	/**
	 * Constructor de la clase ChanceDAO. Inicializa la lista de juegos de Chance y
	 * carga datos desde la serialización si está disponible.
	 */

	public ChanceDAO() {
		// TODO Auto-generated constructor stub
		apChance = new ArrayList<ChanceDTO>();
		if (FileHandler.openAndReadFileChance(SERIAL_FILENAME) != null) {
			ArrayList<ChanceDTO> temp2 = FileHandler.openAndReadFileChance(SERIAL_FILENAME);
			apChance = temp2;
		} else {
			apChance = new ArrayList<>();
		}
	}

	/**
	 * Guarda los datos de la lista de juegos de Chance en un archivo serializado.
	 */

	public void writeSerializable() {
		FileHandler.openAndWriteFileChance(SERIAL_FILENAME, apChance);
	}

	/**
	 * Crea un nuevo juego de Chance a partir de datos proporcionados en forma de
	 * cadenas.
	 *
	 * @param strs Arreglo de cadenas con los datos del juego de Chance.
	 */

	@Override
	public void create(String... strs) {
		// TODO Auto-generated method stub
		ChanceDTO nChance = new ChanceDTO();
		nChance.setIdChance(Integer.parseInt(strs[0]));
		nChance.setDia(LocalDate.parse(strs[1]));
		nChance.setCedulaAposdor(Long.parseLong(strs[2]));
		nChance.setSedeApostador(strs[3]);
		nChance.setNombreLoteria(strs[4]);
		String[] numerosStr = strs[5].split(",");
		int[] numeros = new int[numerosStr.length];
		for (int i = 0; i < numerosStr.length; i++) {
			numeros[i] = Integer.parseInt(numerosStr[i]);
		}
		nChance.setNumeros(numeros);
		nChance.setValorApuesta(Double.parseDouble(strs[6]));

		apChance.add(nChance);
		writeSerializable();

	}

	/**
	 * Crea un nuevo juego de Chance a partir de un objeto.
	 *
	 * @param obj Objeto ChanceDTO que representa el juego de Chance.
	 */

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		int salida = apChance.size() + 1;
		apChance.add((ChanceDTO) obj);
		writeSerializable();

	}

	/**
	 * Obtiene una representación en forma de cadena de todos los juegos de Chance.
	 *
	 * @return Cadena con la información de los juegos de Chance.
	 */

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		index = 0;
		StringBuilder sb = new StringBuilder();
		apChance.forEach((chance) -> {

			sb.append((chance.toString() + "\n"));
			index++;
		});
		return sb.toString();
	}

	/**
	 * Busca la existencia de una apuesta de Chance por su identificador.
	 *
	 * @param index Identificador de la apuesta de Chance a buscar.
	 * @return true si se encuentra la apuesta de Chance con el identificador dado,
	 *         false en caso contrario.
	 */

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apChance.size(); i++) {
			if (apChance.get(i).getIdChance() == index) {
				salida = true;
			}
		}
		return salida;
	}

	/**
	 * Busca y retorna una apuesta de Chance por su identificador.
	 *
	 * @param index Identificador de la apuesta de Chance a buscar.
	 * @return Objeto ChanceDTO si se encuentra la apuesta de Chance con el
	 *         identificador dado, null en caso contrario.
	 */

	public ChanceDTO search(int index) {
		ChanceDTO salida = null;
		for (int i = 0; i < apChance.size(); i++) {
			if (apChance.get(i).getIdChance() == index
					&& apChance.get(i).getClass().getSimpleName().toString().equals("ChanceDTO")) {
				salida = ((ChanceDTO) apChance.get(i));
			}
		}
		return salida;
	}

	/**
	 * Actualiza los datos de un juego de Chance en la lista por su índice.
	 *
	 * @param index   Índice del juego de Chance a actualizar.
	 * @param newData Nuevos datos del juego de Chance en forma de cadenas.
	 * @return true si se actualizó correctamente, false en caso contrario.
	 */

	@Override
	public boolean updateByIndex(int index, String... newData) {
		for (int i = 0; i < apChance.size(); i++) {
			if (apChance.get(i).getIdChance() == index
					&& apChance.get(i).getClass().getSimpleName().toString().equals("ChanceDTO")) {
				apChance.get(i).setDia(LocalDate.parse(newData[0]));
				apChance.get(i).setCedulaAposdor(Long.parseLong(newData[1]));
				apChance.get(i).setSedeApostador(newData[2]);
				apChance.get(i).setNombreLoteria(newData[3]);
				String[] numerosStr = newData[4].split(",");
				int[] numeros = new int[numerosStr.length];
				for (int j = 0; j < numerosStr.length; j++) {
					numeros[j] = Integer.parseInt(numerosStr[j]);
				}
				apChance.get(i).setNumeros(numeros);
				apChance.get(i).setValorApuesta(Double.parseDouble(newData[5]));

				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un juego de Chance de la lista por su índice.
	 *
	 * @param index Índice del juego de Chance a eliminar.
	 * @return true si se eliminó correctamente, false en caso contrario.
	 */

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < apChance.size(); i++) {
			if (apChance.get(i).getIdChance() == index
					&& apChance.get(i).getClass().getSimpleName().toString().equals("ChanceDTO")) {
				apChance.remove(i);
				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un juego de Chance de la lista por su objeto.
	 *
	 * @param obj Objeto ChanceDTO que representa el juego de Chance a eliminar.
	 * @return true si se eliminó correctamente, false en caso contrario.
	 */

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		ChanceDTO toDelete = ((ChanceDTO) obj);
		if (apChance.contains(toDelete)) {
			apChance.remove(index);
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calcula el valor total apostado por un cliente en apuestas de Chance.
	 *
	 * @param cedulaApostador Número de cédula del apostador.
	 * @return Valor total apostado por el cliente en apuestas de Chance.
	 */

	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
		double valorTotal = 0;
		for (ChanceDTO chance : apChance) {
			if (chance.getCedulaAposdor() == cedulaApostador) {
				valorTotal += chance.getValorApuesta();
			}
		}
		return valorTotal;
	}

	/**
	 * Calcula el valor total apostado en apuestas de Chance por una sede
	 * específica.
	 *
	 * @param sede Nombre de la sede.
	 * @return Valor total apostado en apuestas de Chance por la sede.
	 */

	public double calcularTotalApuestasPorSede(String sede) {
		double total = 0;
		for (ChanceDTO chance : apChance) {
			if (chance.getSedeApostador() == sede) {
				total += chance.getValorApuesta();
			}
		}
		return total;
	}

	/**
	 * Calcula el valor total apostado en todas las apuestas de Chance.
	 *
	 * @return Valor total apostado en todas las apuestas de Chance.
	 */

	public double calcularTotalValorApostado() {
		double total = 0;
		for (ChanceDTO chance : apChance) {
			total += chance.getValorApuesta();
		}
		return total;
	}

	/**
	 * Obtiene el detalle de las apuestas realizadas por un cliente en apuestas de
	 * Chance.
	 *
	 * @param cedulaApostador Número de cédula del apostador.
	 * @return Detalle de las apuestas del cliente en apuestas de Chance.
	 */

	public String obtenerDetalleApuestasPorCedula(long cedulaApostador) {

		ArrayList<String> detalles = new ArrayList<>();

		ChanceDAO chanceDAO = new ChanceDAO();
		for (ChanceDTO chance : chanceDAO.getApChance()) {
			if (chance.getCedulaAposdor() == cedulaApostador) {
				detalles.add("ID Baloto: " + chance.getIdChance() + ", Fecha: " + chance.getDia() + ", Sede:"
						+ chance.getSedeApostador() + ", Numeros: " + Arrays.toString(chance.getNumeros())
						+ ", Valor Apuesta: " + chance.getValorApuesta());
			}
		}

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
	 * Obtiene el detalle de las apuestas realizadas en apuestas de Chance por una
	 * sede específica.
	 *
	 * @param nombreSede Nombre de la sede.
	 * @return Detalle de las apuestas realizadas en apuestas de Chance por la sede.
	 */

	public String obtenerDetalleApuestasPorSede(String nombreSede) {
		StringBuilder detalle = new StringBuilder();
		for (ChanceDTO chance : apChance) {
			if (chance.getSedeApostador().equalsIgnoreCase(nombreSede)) {
				detalle.append(chance.toString()).append("\n");
			}
		}
		return detalle.toString();
	}

	/**
	 * Obtiene la lista de apuestas de Chance.
	 *
	 * @return Lista de apuestas de Chance.
	 */

	public ArrayList<ChanceDTO> getApChance() {
		return apChance;
	}

	/**
	 * Establece la lista de apuestas de Chance.
	 *
	 * @param apChance Nueva lista de apuestas de Chance.
	 */

	public void setApChance(ArrayList<ChanceDTO> apChance) {
		this.apChance = apChance;
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
	 * @param index Nuevo índice.
	 */

	public void setIndex(int index) {
		this.index = index;
	}

}