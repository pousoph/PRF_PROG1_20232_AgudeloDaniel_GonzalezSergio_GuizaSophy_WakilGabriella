package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.edu.unbosque.model.BalotoDTO;
import co.edu.unbosque.model.SuperAstroDTO;

/**
 * 
 * Clase SuperAstroDAO que implementa la interfaz CRUDOperation y se encarga de
 * administrar los datos de SuperAstroDTO.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class SuperAstroDAO implements CRUDOperation {

	private ArrayList<SuperAstroDTO> apSuperAstro;
	private final String SERIAL_FILENAME = "apuestas-superastro.dat";
	int index = 0;
	String exit = "";

	/**
	 * Constructor de la clase SuperAstroDAO. Inicializa la lista de SuperAstroDTO y
	 * carga los datos desde un archivo serializado si existe.
	 */

	public SuperAstroDAO() {
		// TODO Auto-generated constructor stub
		apSuperAstro = new ArrayList<SuperAstroDTO>();
		if (FileHandler.openAndReadFileSuperAstro(SERIAL_FILENAME) != null) {
			ArrayList<SuperAstroDTO> temp2 = FileHandler.openAndReadFileSuperAstro(SERIAL_FILENAME);
			apSuperAstro = temp2;
		} else {
			apSuperAstro = new ArrayList<>();
		}
	}

	/**
	 * Escribe los datos de SuperAstroDTO en un archivo serializado.
	 */

	public void writeSerializable() {
		FileHandler.openAndWriteFileSuperAstro(SERIAL_FILENAME, apSuperAstro);
	}

	/**
	 * Crea un nuevo objeto SuperAstroDTO a partir de los parámetros proporcionados
	 * y lo agrega a la lista de juegos Super Astro.
	 *
	 * @param strs Un arreglo de cadenas que contiene los datos del nuevo juego
	 *             Super Astro en el siguiente orden: [0] - ID [1] - Nombre del
	 *             juego [2] - Tipo de juego [3] - Presupuesto [4] - Números [5] -
	 *             Signo Zodiacal
	 */

	@Override
	public void create(String... strs) {
		// TODO Auto-generated method stub
		SuperAstroDTO nSuperAstro = new SuperAstroDTO();
		nSuperAstro.setIdSuperAstro(Integer.parseInt(strs[0]));
		nSuperAstro.setDia(LocalDate.parse(strs[1]));
		nSuperAstro.setCedulaApostador(Long.parseLong(strs[2]));
		nSuperAstro.setUbicacionApostador(strs[3]);
		String[] numerosStr = strs[4].split(",");
		int[] numeros = new int[numerosStr.length];
		for (int i = 0; i < numerosStr.length; i++) {
			numeros[i] = Integer.parseInt(numerosStr[i]);
		}
		nSuperAstro.setNumeros(numeros);
		nSuperAstro.setSignoZodiacal(strs[5]);
		nSuperAstro.setValorApuesta(Double.parseDouble(strs[6]));

		apSuperAstro.add(nSuperAstro);
		writeSerializable();

	}

	/**
	 * Agrega un objeto SuperAstroDTO a la lista de juegos Super Astro.
	 *
	 * @param obj El objeto SuperAstroDTO que se va a agregar a la lista.
	 */

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		apSuperAstro.add((SuperAstroDTO) obj);
		writeSerializable();

	}

	/**
	 * Busca una apuesta de SuperAstro por su identificador.
	 *
	 * @param index Identificador de la apuesta de SuperAstro a buscar.
	 * @return La apuesta de SuperAstro encontrada o null si no se encuentra.
	 */

	public SuperAstroDTO search(int index) {
		SuperAstroDTO salida = null;
		for (int i = 0; i < apSuperAstro.size(); i++) {
			if (apSuperAstro.get(i).getIdSuperAstro() == index
					&& apSuperAstro.get(i).getClass().getSimpleName().toString().equals("SuperAstroDTO")) {
				salida = ((SuperAstroDTO) apSuperAstro.get(i));
			}
		}
		return salida;
	}

	/**
	 * Verifica si existe una apuesta de SuperAstro con el identificador
	 * especificado.
	 *
	 * @param index Identificador de la apuesta de SuperAstro a verificar.
	 * @return true si la apuesta de SuperAstro existe, false en caso contrario.
	 */

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apSuperAstro.size(); i++) {
			if (apSuperAstro.get(i).getIdSuperAstro() == index) {
				salida = true;
			}
		}
		return salida;
	}

	/**
	 * Obtiene una representación en forma de cadena de todos los juegos Super Astro
	 * en la lista.
	 *
	 * @return Una cadena que contiene la representación de todos los juegos Super
	 *         Astro en la lista.
	 */

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		apSuperAstro.forEach((superAstro) -> {
			sb.append((superAstro.toString() + "\n"));
		});
		return sb.toString();
	}

	/**
	 * Actualiza los datos de un juego Super Astro en la lista por su ID.
	 *
	 * @param index   El ID del juego Super Astro que se va a actualizar.
	 * @param newData Un arreglo de cadenas que contiene los nuevos datos del juego
	 *                Super Astro en el siguiente orden: [0] - Nuevo nombre del
	 *                juego [1] - Nuevo tipo de juego [2] - Nuevos números
	 *                (separados por "; ") [3] - Nuevo presupuesto [4] - Nuevo signo
	 *                Zodiacal
	 * @return true si la actualización se realiza con éxito, false si no se
	 *         encuentra un juego con el ID proporcionado.
	 */

	@Override
	public boolean updateByIndex(int index, String... newData) {
		// TODO Auto-generated method stub
		for (int i = 0; i < apSuperAstro.size(); i++) {
			if (apSuperAstro.get(i).getIdSuperAstro() == index
					&& apSuperAstro.get(i).getClass().getSimpleName().toString().equals("SuperAstroDTO")) {
				apSuperAstro.get(i).setDia(LocalDate.parse(newData[0]));
				apSuperAstro.get(i).setCedulaApostador(Long.parseLong(newData[1]));
				apSuperAstro.get(i).setUbicacionApostador(newData[2]);
				String[] numerosStr = newData[3].split(",");
				int[] numeros = new int[numerosStr.length];
				for (int j = 0; j < numerosStr.length; j++) {
					numeros[j] = Integer.parseInt(numerosStr[j]);
				}
				apSuperAstro.get(i).setNumeros(numeros);
				apSuperAstro.get(i).setSignoZodiacal(newData[4]);
				apSuperAstro.get(i).setValorApuesta(Double.parseDouble(newData[5]));

				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un juego Super Astro de la lista por su ID.
	 *
	 * @param index El ID del juego Super Astro que se va a eliminar.
	 * @return true si la eliminación se realiza con éxito, false si no se encuentra
	 *         un juego con el ID proporcionado.
	 */

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < apSuperAstro.size(); i++) {
			if (apSuperAstro.get(i).getIdSuperAstro() == index
					&& apSuperAstro.get(i).getClass().getSimpleName().toString().equals("SuperAstroDTO")) {
				apSuperAstro.remove(i);
				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina un juego Super Astro de la lista por objeto.
	 *
	 * @param obj El objeto SuperAstroDTO que se va a eliminar de la lista.
	 * @return true si la eliminación se realiza con éxito, false si el objeto no se
	 *         encuentra en la lista.
	 */

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		SuperAstroDTO toDelete = ((SuperAstroDTO) obj);
		if (apSuperAstro.contains(toDelete)) {
			apSuperAstro.remove(index);
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Muestra un recibo de apuestas de SuperAstro para un apostador con la cédula
	 * especificada.
	 *
	 * @param apuestasSuper Lista de apuestas de SuperAstro.
	 * @param cedula        Cédula del apostador.
	 */

	public void mostrarReciboPorCedula(List<SuperAstroDTO> apuestasSuper, long cedula) {
		System.out.println("Recibo de apuestas Baloto para la cédula " + cedula + ":");
		mostrarApuestasPorCedula(apuestasSuper, cedula);
		System.out.println("------------------------");
	}

	/**
	 * Muestra las apuestas de SuperAstro para un apostador con la cédula
	 * especificada.
	 *
	 * @param apuestasSuper Lista de apuestas de SuperAstro.
	 * @param cedula        Cédula del apostador.
	 */

	private void mostrarApuestasPorCedula(List<SuperAstroDTO> apuestasSuper, long cedula) {
		boolean hayApuestas = false;

		for (SuperAstroDTO apuesta : apuestasSuper) {
			if (apuesta.getCedulaApostador() == cedula) {
				System.out.println(apuesta);
				hayApuestas = true;
			}
		}

		if (!hayApuestas) {
			System.out.println("No hay apuestas Baloto para la cédula " + cedula);
		}
	}

	/**
	 * Calcula el valor total apostado por un cliente con la cédula especificada.
	 *
	 * @param cedulaApostador Cédula del apostador.
	 * @return Valor total apostado por el cliente.
	 */

	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
		double valorTotal = 0;
		for (SuperAstroDTO sAstro : apSuperAstro) {
			if (sAstro.getCedulaApostador() == cedulaApostador) {
				valorTotal += sAstro.getValorApuesta();
			}
		}
		return valorTotal;
	}

	/**
	 * Calcula el total de apuestas realizadas en una sede específica.
	 *
	 * @param sede Nombre de la sede.
	 * @return Total de apuestas realizadas en la sede.
	 */

	public double calcularTotalApuestasPorSede(String sede) {
		double total = 0;
		for (SuperAstroDTO sAstro : apSuperAstro) {
			if (sAstro.getUbicacionApostador() == sede) {
				total += sAstro.getValorApuesta();
			}
		}
		return total;
	}

	/**
	 * Calcula el valor total de todas las apuestas realizadas.
	 *
	 * @return Valor total de todas las apuestas.
	 */

	public double calcularTotalValorApostado() {
		double total = 0;
		for (SuperAstroDTO sAstro : apSuperAstro) {
			total += sAstro.getValorApuesta();
		}
		return total;
	}

	/**
	 * Obtiene el detalle de las apuestas realizadas por un cliente con la cédula
	 * especificada.
	 *
	 * @param cedulaApostador Cédula del apostador.
	 * @return Detalle de las apuestas realizadas por el cliente.
	 */

	public String obtenerDetalleApuestasPorCedula(long cedulaApostador) {
		// Obtener las apuestas por la cédula del apostador utilizando tus funciones de
		// DAO
		ArrayList<String> detalles = new ArrayList<>();

		// Ejemplo para Baloto
		SuperAstroDAO superDAO = new SuperAstroDAO();
		for (SuperAstroDTO superastro : superDAO.getApSuperAstro()) {
			if (superastro.getCedulaApostador() == cedulaApostador) {
				detalles.add("ID Baloto: " + superastro.getIdSuperAstro() + ", Fecha: " + superastro.getDia()
						+ ", Sede: " + superastro.getUbicacionApostador() + ", Numeros: "
						+ Arrays.toString(superastro.getNumeros()) + ", Signo Zodiacal: "
						+ superastro.getSignoZodiacal() + ", Valor Apuesta: " + superastro.getValorApuesta());
				// Puedes agregar más detalles según tus necesidades
			}
		}

		// Agregar lógica similar para otros juegos (Lotería, SuperAstro, etc.)

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
	 * Obtiene el detalle de las apuestas realizadas en una sede específica.
	 *
	 * @param nombreSede Nombre de la sede.
	 * @return Detalle de las apuestas realizadas en la sede.
	 */

	public String obtenerDetalleApuestasPorSede(String nombreSede) {
		StringBuilder detalle = new StringBuilder();
		for (SuperAstroDTO superastro : apSuperAstro) {
			if (superastro.getUbicacionApostador().equalsIgnoreCase(nombreSede)) {
				detalle.append(superastro.toString()).append("\n");
			}
		}
		return detalle.toString();
	}

	public boolean buscarPorId(int idBaloto) {
		return apSuperAstro.stream().anyMatch(apuesta -> apuesta.getIdSuperAstro() == idBaloto);
	}

	/**
	 * Obtiene la lista de apuestas de SuperAstro.
	 *
	 * @return La lista de apuestas de SuperAstro.
	 */

	public ArrayList<SuperAstroDTO> getApSuperAstro() {
		return apSuperAstro;
	}

	/**
	 * Establece la lista de apuestas de SuperAstro.
	 *
	 * @param apSuperAstro La nueva lista de apuestas de SuperAstro.
	 */

	public void setApSuperAstro(ArrayList<SuperAstroDTO> apSuperAstro) {
		this.apSuperAstro = apSuperAstro;
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

	/**
	 * Obtiene la marca de salida.
	 *
	 * @return La marca de salida.
	 */

	public String getExit() {
		return exit;
	}

	/**
	 * Establece la marca de salida.
	 *
	 * @param exit La nueva marca de salida.
	 */

	public void setExit(String exit) {
		this.exit = exit;
	}

	/**
	 * Obtiene el nombre del archivo serializado.
	 *
	 * @return El nombre del archivo serializado.
	 */

	public String getSERIAL_FILENAME() {
		return SERIAL_FILENAME;
	}

}