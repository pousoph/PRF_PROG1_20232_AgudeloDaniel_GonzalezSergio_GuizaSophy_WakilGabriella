package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.BalotoDTO;

/**
 * 
 *         La clase BalotoDAO es un objeto de acceso a datos (DAO) que gestiona
 *         las operaciones relacionadas con las apuestas en el juego de Baloto.
 *         
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class BalotoDAO implements CRUDOperation {

	private ArrayList<BalotoDTO> apBalotos;
	private final String SERIAL_FILENAME = "apuestas-baloto.dat";
	int index = 0;
	String exit = "";

	/**
	 * Constructor de la clase BalotoDAO. Inicializa la lista de apuestas de Baloto
	 * a partir de un archivo serializado, si existe.
	 */

	public BalotoDAO() {
		// TODO Auto-generated constructor stub
		apBalotos = new ArrayList<BalotoDTO>();
		if (FileHandler.openAndReadFileBaloto(SERIAL_FILENAME) != null) {
			@SuppressWarnings("unchecked")
			ArrayList<BalotoDTO> temp2 = (ArrayList<BalotoDTO>) FileHandler.openAndReadFileBaloto(SERIAL_FILENAME);
			apBalotos = temp2;
		} else {
			apBalotos = new ArrayList<>();
		}
	}

	/**
	 * Guarda la lista de apuestas de Baloto en un archivo serializado.
	 */

	public void writeSerializable() {
		FileHandler.openAndWriteFileBaloto(SERIAL_FILENAME, apBalotos);
	}

	/**
	 * Crea una nueva apuesta de Baloto a partir de los parámetros proporcionados y
	 * la agrega a la lista de apuestas.
	 *
	 * @param strs Arreglo de cadenas que contiene los datos de la apuesta de
	 *             Baloto. Se esperan los siguientes elementos: [idBaloto, dia,
	 *             cedulaApostador, sedeApostador, numeros, valorApuesta].
	 */

	@Override
	public void create(String... strs) {
		BalotoDTO nBaloto = new BalotoDTO();
		nBaloto.setIdBaloto(Integer.parseInt(strs[0]));
		nBaloto.setDia(LocalDate.parse(strs[1]));
		nBaloto.setCedulaApostador(Long.parseLong(strs[2]));
		nBaloto.setSedeApostador(strs[3]);
		String[] numerosStr = strs[4].split(",");
		int[] numeros = new int[numerosStr.length];
		for (int i = 0; i < numerosStr.length; i++) {
			numeros[i] = Integer.parseInt(numerosStr[i]);
		}
		nBaloto.setNumeros(numeros);
		nBaloto.setValorApuesta(Double.parseDouble(strs[5]));

		apBalotos.add(nBaloto);
		writeSerializable();

	}

	/**
	 * Agrega una apuesta de Baloto a la lista de apuestas y guarda la lista en un
	 * archivo serializado.
	 *
	 * @param obj Objeto BalotoDTO que representa la apuesta de Baloto a agregar.
	 */

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		apBalotos.add((BalotoDTO) obj);
		writeSerializable();

	}

	/**
	 * Busca y devuelve una apuesta de Baloto en la lista según su identificador.
	 *
	 * @param index Identificador de la apuesta de Baloto a buscar.
	 * @return Objeto BalotoDTO correspondiente al identificador proporcionado, o
	 *         null si no se encuentra.
	 */

	public BalotoDTO search(int index) {
		BalotoDTO salida = null;
		for (int i = 0; i < apBalotos.size(); i++) {
			if (apBalotos.get(i).getIdBaloto() == index
					&& apBalotos.get(i).getClass().getSimpleName().toString().equals("BalotoDTO")) {
				salida = ((BalotoDTO) apBalotos.get(i));
			}
		}
		return salida;
	}

	/**
	 * Verifica si existe una apuesta de Baloto en la lista según su identificador.
	 *
	 * @param index Identificador de la apuesta de Baloto a verificar.
	 * @return true si la apuesta de Baloto con el identificador proporcionado
	 *         existe, false de lo contrario.
	 */

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apBalotos.size(); i++) {
			if (apBalotos.get(i).getIdBaloto() == index) {
				salida = true;
			}
		}
		return salida;
	}

	/**
	 * Devuelve una representación en cadena de todas las apuestas de Baloto en la
	 * lista.
	 *
	 * @return Cadena que representa todas las apuestas de Baloto en la lista.
	 */

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		index = 0;
		StringBuilder sb = new StringBuilder();
		apBalotos.forEach((baloto) -> {

			sb.append((baloto.toString() + "\n"));
			index++;
		});
		return sb.toString();
	}

	/**
	 * Busca si existe una apuesta de Baloto en la lista según su identificador.
	 *
	 * @param idBaloto Identificador de la apuesta de Baloto a buscar.
	 * @return true si la apuesta de Baloto con el identificador proporcionado
	 *         existe, false de lo contrario.
	 */

	public boolean buscarPorId(int idBaloto) {
		return apBalotos.stream().anyMatch(apuesta -> apuesta.getIdBaloto() == idBaloto);
	}

	/**
	 * Busca y devuelve una apuesta de Baloto en la lista según su identificador.
	 *
	 * @param idBaloto Identificador de la apuesta de Baloto a buscar.
	 * @return Objeto BalotoDTO correspondiente al identificador proporcionado, o
	 *         null si no se encuentra.
	 */

	public BalotoDTO buscarApuesta(int idBaloto) {
		return apBalotos.stream().filter(apuesta -> apuesta.getIdBaloto() == idBaloto).findFirst().orElse(null);
	}

	/**
	 * Actualiza la información de una apuesta de Baloto en la lista según su
	 * identificador y guarda la lista en un archivo serializado.
	 *
	 * @param index   Identificador de la apuesta de Baloto a actualizar.
	 * @param newData Nuevos datos para la apuesta de Baloto en el siguiente orden:
	 *                fecha, cédula del apostador, sede del apostador, números
	 *                (separados por coma), valor de la apuesta.
	 * @return true si la actualización fue exitosa, false de lo contrario.
	 */

	@Override
	public boolean updateByIndex(int index, String... newData) {
		for (int i = 0; i < apBalotos.size(); i++) {
			if (apBalotos.get(i).getIdBaloto() == index
					&& apBalotos.get(i).getClass().getSimpleName().toString().equals("BalotoDTO")) {
				apBalotos.get(i).setDia(LocalDate.parse(newData[0]));
				apBalotos.get(i).setCedulaApostador(Long.parseLong(newData[1]));
				apBalotos.get(i).setSedeApostador(newData[2]);
				String[] numerosStr = newData[3].split(",");
				int[] numeros = new int[numerosStr.length];
				for (int j = 0; j < numerosStr.length; j++) {
					numeros[j] = Integer.parseInt(numerosStr[j]);
				}
				apBalotos.get(i).setNumeros(numeros);
				apBalotos.get(i).setValorApuesta(Double.parseDouble(newData[4]));

				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina una apuesta de Baloto de la lista según su identificador y guarda la
	 * lista en un archivo serializado.
	 *
	 * @param index Identificador de la apuesta de Baloto a eliminar.
	 * @return true si la eliminación fue exitosa, false de lo contrario.
	 */

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < apBalotos.size(); i++) {
			if (apBalotos.get(i).getIdBaloto() == index
					&& apBalotos.get(i).getClass().getSimpleName().toString().equals("BalotoDTO")) {
				apBalotos.remove(i);
				writeSerializable();
				return true;
			}
		}
		return false;
	}

	/**
	 * Elimina una apuesta de Baloto de la lista y guarda la lista en un archivo
	 * serializado.
	 *
	 * @param obj Objeto BalotoDTO que representa la apuesta de Baloto a eliminar.
	 * @return true si la eliminación fue exitosa, false de lo contrario.
	 */

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		BalotoDTO toDelete = ((BalotoDTO) obj);
		if (apBalotos.contains(toDelete)) {
			apBalotos.remove(index);
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Calcula el valor total apostado por un cliente en todas las apuestas de
	 * Baloto.
	 *
	 * @param cedulaApostador Cédula del apostador.
	 * @return Valor total apostado por el cliente en todas las apuestas de Baloto.
	 */

	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
		double valorTotal = 0;
		for (BalotoDTO baloto : apBalotos) {
			if (baloto.getCedulaApostador() == cedulaApostador) {
				valorTotal += baloto.getValorApuesta();
			}
		}
		return valorTotal;
	}

	/**
	 * Calcula el valor total apostado en todas las apuestas de Baloto para una sede
	 * específica.
	 *
	 * @param sede Nombre de la sede.
	 * @return Valor total apostado en todas las apuestas de Baloto para la sede
	 *         específica.
	 */

	public double calcularTotalApuestasPorSede(String sede) {
		double total = 0;
		for (BalotoDTO baloto : apBalotos) {
			if (baloto.getSedeApostador() == sede) {
				total += baloto.getValorApuesta();
			}
		}
		return total;
	}

	/**
	 * Calcula el valor total apostado en todas las apuestas de Baloto.
	 *
	 * @return Valor total apostado en todas las apuestas de Baloto.
	 */

	public double calcularTotalValorApostado() {
		double total = 0;
		for (BalotoDTO baloto : apBalotos) {
			total += baloto.getValorApuesta();
		}
		return total;
	}

	/**
	 * Obtiene un detalle de las apuestas de Baloto realizadas por un apostador
	 * según su cédula.
	 *
	 * @param cedulaApostador Cédula del apostador.
	 * @return Detalle de las apuestas de Baloto realizadas por el apostador.
	 */

	public String obtenerDetalleApuestasPorCedula(long cedulaApostador) {

		ArrayList<String> detalles = new ArrayList<>();

		BalotoDAO balotoDAO = new BalotoDAO();
		for (BalotoDTO baloto : balotoDAO.getApBalotos()) {
			if (baloto.getCedulaApostador() == cedulaApostador) {
				detalles.add("ID Baloto: " + baloto.getIdBaloto() + ", Fecha: " + baloto.getDia() + ", Valor Apuesta: "
						+ baloto.getValorApuesta());

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
	 * Obtiene un detalle de las apuestas de Baloto realizadas en una sede
	 * específica.
	 *
	 * @param nombreSede Nombre de la sede.
	 * @return Detalle de las apuestas de Baloto realizadas en la sede específica.
	 */

	public String obtenerDetalleApuestasPorSede(String nombreSede) {
		StringBuilder detalle = new StringBuilder();
		for (BalotoDTO baloto : apBalotos) {
			if (baloto.getSedeApostador().equalsIgnoreCase(nombreSede)) {
				detalle.append(baloto.toString()).append("\n");
			}
		}
		return detalle.toString();
	}

	/**
	 * Obtiene la lista de apuestas de Baloto.
	 *
	 * @return Lista de apuestas de Baloto.
	 */

	public ArrayList<BalotoDTO> getApBalotos() {
		return apBalotos;
	}

	/**
	 * Establece la lista de apuestas de Baloto.
	 *
	 * @param apBalotos Lista de apuestas de Baloto a establecer.
	 */

	public void setApBalotos(ArrayList<BalotoDTO> apBalotos) {
		this.apBalotos = apBalotos;
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