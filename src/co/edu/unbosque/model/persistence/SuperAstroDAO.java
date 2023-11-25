package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.edu.unbosque.model.SuperAstroDTO;

public class SuperAstroDAO implements CRUDOperation {

	private ArrayList<SuperAstroDTO> apSuperAstro;
	private final String SERIAL_FILENAME = "apuestas-superastro.dat";
	int index = 0;
	String exit = "";

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

	public void writeSerializable() {
		FileHandler.openAndWriteFileSuperAstro(SERIAL_FILENAME, apSuperAstro);
	}

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

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		apSuperAstro.add((SuperAstroDTO) obj);
		writeSerializable();

	}

	public SuperAstroDTO search(int index) {
		SuperAstroDTO salida = null;
		for (int i = 0; i < apSuperAstro.size(); i++) {
			if (apSuperAstro.get(i).getIdSuperAstro() == index
					&& apSuperAstro.get(i).getClass().getSimpleName().toString().equals("SuperaAstro")) {
				salida = ((SuperAstroDTO) apSuperAstro.get(i));
			}
		}
		return salida;
	}

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apSuperAstro.size(); i++) {
			if (apSuperAstro.get(i).getIdSuperAstro() == index) {
				salida = true;
			}
		}
		return salida;
	}

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		apSuperAstro.forEach((superAstro) -> {
			sb.append((superAstro.toString() + "\n"));
		});
		return sb.toString();
	}

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
					numeros[j] = Integer.parseInt(numerosStr[i]);
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

	public void mostrarReciboPorCedula(List<SuperAstroDTO> apuestasSuper, long cedula) {
		System.out.println("Recibo de apuestas Baloto para la cédula " + cedula + ":");
		mostrarApuestasPorCedula(apuestasSuper, cedula);
		System.out.println("------------------------");
	}

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

	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
		double valorTotal = 0;
		for (SuperAstroDTO sAstro : apSuperAstro) {
			if (sAstro.getCedulaApostador() == cedulaApostador) {
				valorTotal += sAstro.getValorApuesta();
			}
		}
		return valorTotal;
	}

	public double calcularTotalApuestasPorSede(String sede) {
		double total = 0;
		for (SuperAstroDTO sAstro : apSuperAstro) {
			if (sAstro.getUbicacionApostador() == sede) {
				total += sAstro.getValorApuesta();
			}
		}
		return total;
	}

	public double calcularTotalValorApostado() {
		double total = 0;
		for (SuperAstroDTO sAstro : apSuperAstro) {
			total += sAstro.getValorApuesta();
		}
		return total;
	}

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

	public String obtenerDetalleApuestasPorSede(String nombreSede) {
		StringBuilder detalle = new StringBuilder();
		for (SuperAstroDTO superastro : apSuperAstro) {
			if (superastro.getUbicacionApostador().equalsIgnoreCase(nombreSede)) {
				detalle.append(superastro.toString()).append("\n");
			}
		}
		return detalle.toString();
	}

	public ArrayList<SuperAstroDTO> getApSuperAstro() {
		return apSuperAstro;
	}

	public void setApSuperAstro(ArrayList<SuperAstroDTO> apSuperAstro) {
		this.apSuperAstro = apSuperAstro;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getExit() {
		return exit;
	}

	public void setExit(String exit) {
		this.exit = exit;
	}

	public String getSERIAL_FILENAME() {
		return SERIAL_FILENAME;
	}

}
