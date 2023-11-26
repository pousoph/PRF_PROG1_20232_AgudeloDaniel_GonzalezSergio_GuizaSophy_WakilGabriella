package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import co.edu.unbosque.model.LoteriaDTO;

/**
 * 
 * 
 * La clase LoteriaDAO es una implementación de la interfaz CRUDOperation y se
 * encarga de gestionar la persistencia y operaciones relacionadas con la
 * entidad LoteriaDTO.
 * 
 * Esta clase utiliza una lista de LoteriaDTO para almacenar y manipular los
 * datos de juegos de lotería.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class LoteriaDAO implements CRUDOperation {

	private ArrayList<LoteriaDTO> apLoteria;
	private final String SERIAL_FILENAME = "apuestas-loteria.dat";
	int index = 0;

	/**
	 * Constructor de la clase LoteriaDAO. Inicializa la lista de juegos de lotería
	 * y carga los datos desde archivos si están disponibles.
	 */

	public LoteriaDAO() {
		// TODO Auto-generated constructor stub
		apLoteria = new ArrayList<LoteriaDTO>();
		if (FileHandler.openAndReadFileLoteria(SERIAL_FILENAME) != null) {
			@SuppressWarnings("unchecked")
			ArrayList<LoteriaDTO> temp2 = (ArrayList<LoteriaDTO>) FileHandler.openAndReadFileLoteria(SERIAL_FILENAME);
			apLoteria = temp2;
		} else {
			apLoteria = new ArrayList<>();
		}
	}

	/**
	 * Escribe los datos de juegos de lotería en un archivo serializado.
	 */

	public void writeSerializable() {
		FileHandler.openAndWriteFileLoteria(SERIAL_FILENAME, apLoteria);
	}

	/**
	 * Crea un nuevo juego de lotería a partir de datos proporcionados.
	 * 
	 * @param strs Un arreglo de cadenas que contiene los datos del juego de lotería
	 *             a crear.
	 */

	@Override
	public void create(String... strs) {
		LoteriaDTO nLoteria = new LoteriaDTO();
		nLoteria.setIdLoteria(Integer.parseInt(strs[0]));
		nLoteria.setDia(LocalDate.parse(strs[1]));
		nLoteria.setCedulaApostador(Long.parseLong(strs[2]));
		nLoteria.setSedeApostador(strs[3]);
		nLoteria.setNombreLoteria(strs[4]);
		String[] numerosStr = strs[5].split(",");
		int[] numeros = new int[numerosStr.length];
		for (int i = 0; i < numerosStr.length; i++) {
			numeros[i] = Integer.parseInt(numerosStr[i]);
		}
		nLoteria.setNumeros(numeros);
		nLoteria.setNumSerie(Integer.parseInt(strs[6]));
		nLoteria.setValorApuesta(Double.parseDouble(strs[7]));

		apLoteria.add(nLoteria);
		writeSerializable();
	}

	/**
	 * Crea un nuevo juego de lotería a partir de un objeto LoteriaDTO.
	 * 
	 * @param obj El objeto LoteriaDTO que se creará.
	 */

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		int salida = apLoteria.size() + 1;
		apLoteria.add((LoteriaDTO) obj);
		writeSerializable();

	}

	/**
	 * Obtiene una representación en cadena de todos los juegos de lotería.
	 * 
	 * @return Una cadena que contiene la representación de todos los juegos de
	 *         lotería.
	 */

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		apLoteria.forEach((chance) -> {
			sb.append((chance.toString() + "\n"));
		});
		return sb.toString();
	}

	/**
	 * Busca una apuesta de lotería por su identificador.
	 *
	 * @param index El identificador de la apuesta de lotería.
	 * @return La apuesta de lotería encontrada o null si no se encuentra.
	 */

	public LoteriaDTO search(int index) {
		LoteriaDTO salida = null;
		for (int i = 0; i < apLoteria.size(); i++) {
			if (apLoteria.get(i).getIdLoteria() == index
					&& apLoteria.get(i).getClass().getSimpleName().toString().equals("LoteriaDTO")) {
				salida = ((LoteriaDTO) apLoteria.get(i));
			}
		}
		return salida;
	}

	/**
	 * Verifica si existe una apuesta de lotería con el identificador proporcionado.
	 *
	 * @param index El identificador de la apuesta de lotería.
	 * @return true si la apuesta de lotería existe, false de lo contrario.
	 */

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apLoteria.size(); i++) {
			if (apLoteria.get(i).getIdLoteria() == index) {
				salida = true;
			}
		}
		return salida;
	}

	/**
	 * Actualiza los datos de un juego de lotería por su índice.
	 * 
	 * @param index   El índice del juego de lotería a actualizar.
	 * @param newData Un arreglo de cadenas que contiene los nuevos datos para el
	 *                juego de lotería.
	 * @return true si la actualización fue exitosa, false si no.
	 */

	@Override
	public boolean updateByIndex(int index, String... newData) {
		for (int i = 0; i < apLoteria.size(); i++) {
			if (apLoteria.get(i).getIdLoteria() == index
					&& apLoteria.get(i).getClass().getSimpleName().toString().equals("LoteriaDTO")) {
				apLoteria.get(i).setDia(LocalDate.parse(newData[0]));
				apLoteria.get(i).setCedulaApostador(Long.parseLong(newData[1]));
				apLoteria.get(i).setSedeApostador(newData[2]);
				apLoteria.get(i).setNombreLoteria(newData[3]);
				String[] numerosStr = newData[4].split(",");
				int[] numeros = new int[numerosStr.length];
				for (int j = 0; j < numerosStr.length; j++) {
					numeros[j] = Integer.parseInt(numerosStr[i]);
				}
				apLoteria.get(i).setNumeros(numeros);
				apLoteria.get(i).setNumSerie(Integer.parseInt(newData[5]));
				apLoteria.get(i).setValorApuesta(Double.parseDouble(newData[6]));

				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un juego de lotería por su índice.
	 * 
	 * @param index El índice del juego de lotería a eliminar.
	 * @return true si la eliminación fue exitosa, false si no.
	 */

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < apLoteria.size(); i++) {
			if (apLoteria.get(i).getIdLoteria() == index
					&& apLoteria.get(i).getClass().getSimpleName().toString().equals("LoteriaDTO")) {
				apLoteria.remove(i);
				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un juego de lotería por objeto.
	 * 
	 * @param obj El objeto LoteriaDTO a eliminar.
	 * @return true si la eliminación fue exitosa, false si no.
	 */

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		LoteriaDTO toDelete = ((LoteriaDTO) obj);
		if (apLoteria.contains(toDelete)) {
			apLoteria.remove(index);
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calcula el valor total apostado por un cliente específico.
	 *
	 * @param cedulaApostador La cédula del apostador.
	 * @return El valor total apostado por el cliente.
	 */

	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
		double valorTotal = 0;
		for (LoteriaDTO loteria : apLoteria) {
			if (loteria.getCedulaApostador() == cedulaApostador) {
				valorTotal += loteria.getValorApuesta();
			}
		}
		return valorTotal;
	}

	/**
	 * Calcula el total de apuestas realizadas en una sede específica.
	 *
	 * @param sede La sede de la apuesta.
	 * @return El total de apuestas realizadas en la sede.
	 */

	public double calcularTotalApuestasPorSede(String sede) {
		double total = 0;
		for (LoteriaDTO loteria : apLoteria) {
			if (loteria.getSedeApostador() == sede) {
				total += loteria.getValorApuesta();
			}
		}
		return total;
	}

	/**
	 * Calcula el valor total apostado en todas las apuestas de lotería.
	 *
	 * @return El valor total apostado en lotería.
	 */

	public double calcularTotalValorApostado() {
		double total = 0;
		for (LoteriaDTO loteria : apLoteria) {
			total += loteria.getValorApuesta();
		}
		return total;
	}

	/**
	 * Obtiene el detalle de las apuestas realizadas por un cliente específico.
	 *
	 * @param cedulaApostador La cédula del apostador.
	 * @return Una cadena con el detalle de las apuestas del cliente.
	 */

	public String obtenerDetalleApuestasPorCedula(long cedulaApostador) {

		ArrayList<String> detalles = new ArrayList<>();

		LoteriaDAO loteriDAO = new LoteriaDAO();
		for (LoteriaDTO loteria : loteriDAO.getApLoteria()) {
			if (loteria.getCedulaApostador() == cedulaApostador) {
				detalles.add("ID Baloto: " + loteria.getIdLoteria() + ", Fecha: " + loteria.getDia() + ", Sede: "
						+ loteria.getSedeApostador() + ", Nombre Loteria: " + loteria.getNombreLoteria() + ", Numeros: "
						+ Arrays.toString(loteria.getNumeros()) + ", Numero de serie: " + loteria.getNumSerie()
						+ ", Valor Apuesta: " + loteria.getValorApuesta());

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
	 * Obtiene el detalle de las apuestas realizadas en una sede específica.
	 *
	 * @param nombreSede El nombre de la sede.
	 * @return Una cadena con el detalle de las apuestas en la sede.
	 */

	public String obtenerDetalleApuestasPorSede(String nombreSede) {
		StringBuilder detalle = new StringBuilder();
		for (LoteriaDTO loteria : apLoteria) {
			if (loteria.getSedeApostador().equalsIgnoreCase(nombreSede)) {
				detalle.append(loteria.toString()).append("\n");
			}
		}
		return detalle.toString();
	}

	/**
	 * Obtiene la lista de apuestas de lotería.
	 *
	 * @return La lista de apuestas de lotería.
	 */

	public ArrayList<LoteriaDTO> getApLoteria() {
		return apLoteria;
	}

	/**
	 * Establece la lista de apuestas de lotería con la proporcionada.
	 *
	 * @param apLoteria La nueva lista de apuestas de lotería.
	 */

	public void setApLoteria(ArrayList<LoteriaDTO> apLoteria) {
		this.apLoteria = apLoteria;
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
	 * Establece el índice con el valor proporcionado.
	 *
	 * @param index El nuevo valor del índice.
	 */

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Obtiene el nombre del archivo serial.
	 *
	 * @return El nombre del archivo serial.
	 */

	public String getSERIAL_FILENAME() {
		return SERIAL_FILENAME;
	}

}