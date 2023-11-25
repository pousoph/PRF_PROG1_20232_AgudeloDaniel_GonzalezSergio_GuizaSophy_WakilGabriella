package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


import co.edu.unbosque.model.ChanceDTO;

/**
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 *         La clase ChanceDAO implementa las operaciones CRUD para gestionar
 *         juegos de Chance.
 */

public class ChanceDAO implements CRUDOperation {

	private ArrayList<ChanceDTO> apChance;
	private final String SERIAL_FILENAME = "apuestas-chance.dat";
	int index = 0;

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

	public void writeSerializable() {
		FileHandler.openAndWriteFileChance(SERIAL_FILENAME, apChance);
	}

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

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		int salida = apChance.size() + 1;
		apChance.add((ChanceDTO) obj);
		writeSerializable();

	}

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

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apChance.size(); i++) {
			if (apChance.get(i).getIdChance() == index) {
				salida = true;
			}
		}
		return salida;
	}

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

	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
		double valorTotal = 0;
		for (ChanceDTO chance : apChance) {
			if (chance.getCedulaAposdor() == cedulaApostador) {
				valorTotal += chance.getValorApuesta();
			}
		}
		return valorTotal;
	}

	public double calcularTotalApuestasPorSede(String sede) {
		double total = 0;
		for (ChanceDTO chance : apChance) {
			if (chance.getSedeApostador() == sede) {
				total += chance.getValorApuesta();
			}
		}
		return total;
	}

	public double calcularTotalValorApostado() {
		double total = 0;
		for (ChanceDTO chance : apChance) {
			total += chance.getValorApuesta();
		}
		return total;
	}

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
	
	public String obtenerDetalleApuestasPorSede(String nombreSede) {
        StringBuilder detalle = new StringBuilder();
        for (ChanceDTO chance : apChance) {
            if (chance.getSedeApostador().equalsIgnoreCase(nombreSede)) {
                detalle.append(chance.toString()).append("\n");
            }
        }
        return detalle.toString();
    }

	public ArrayList<ChanceDTO> getApChance() {
		return apChance;
	}

	public void setApChance(ArrayList<ChanceDTO> apChance) {
		this.apChance = apChance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}