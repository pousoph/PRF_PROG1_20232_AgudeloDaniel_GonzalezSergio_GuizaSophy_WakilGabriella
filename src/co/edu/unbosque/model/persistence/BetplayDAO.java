package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.unbosque.model.BetplayDTO;

public class BetplayDAO implements CRUDOperation {

	private ArrayList<BetplayDTO> apBetplay;
	private final String SERIAL_FILENAME = "apuestas-betplay.dat";
	int index = 0;
	String exit = "";

	public BetplayDAO() {
		// TODO Auto-generated constructor stub
		apBetplay = new ArrayList<BetplayDTO>();
		if (FileHandler.openAndReadFileBetplay(SERIAL_FILENAME) != null) {
			@SuppressWarnings("unchecked")
			ArrayList<BetplayDTO> temp2 = (ArrayList<BetplayDTO>) FileHandler.openAndReadFileBetplay(SERIAL_FILENAME);
			apBetplay = temp2;
		} else {
			apBetplay = new ArrayList<>();
		}
	}

	public void writeSerializable() {
		FileHandler.openAndWriteFileBetplay(SERIAL_FILENAME, apBetplay);
	}

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

	}

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		int salida = apBetplay.size() + 1;
		apBetplay.add((BetplayDTO) obj);
		writeSerializable();
	}

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		apBetplay.forEach((betplay) -> {
			sb.append((betplay.toString() + "\n"));
		});
		return sb.toString();
	}

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

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apBetplay.size(); i++) {
			if (apBetplay.get(i).getIdBetplay() == index) {
				salida = true;
			}
		}
		return salida;
	}

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

	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
		double valorTotal = 0;
		for (BetplayDTO betplay : apBetplay) {
			if (betplay.getCedulaApostador() == cedulaApostador) {
				valorTotal += betplay.getValorApuesta();
			}
		}
		return valorTotal;
	}

	public double calcularTotalApuestasPorSede(String sede) {
		double total = 0;
		for (BetplayDTO betplay : apBetplay) {
			if (betplay.getSedeApostador() == sede) {
				total += betplay.getValorApuesta();
			}
		}
		return total;
	}

	public double calcularTotalValorApostado() {
		double total = 0;
		for (BetplayDTO betplay : apBetplay) {
			total += betplay.getValorApuesta();
		}
		return total;
	}

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

	public String obtenerDetalleApuestasPorSede(String nombreSede) {
		StringBuilder detalle = new StringBuilder();
		for (BetplayDTO betplay : apBetplay) {
			if (betplay.getSedeApostador().equalsIgnoreCase(nombreSede)) {
				detalle.append(betplay.toString()).append("\n");
			}
		}
		return detalle.toString();
	}

	public ArrayList<BetplayDTO> getApBetplay() {
		return apBetplay;
	}

	public void setApBetplay(ArrayList<BetplayDTO> apBetplay) {
		this.apBetplay = apBetplay;
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
