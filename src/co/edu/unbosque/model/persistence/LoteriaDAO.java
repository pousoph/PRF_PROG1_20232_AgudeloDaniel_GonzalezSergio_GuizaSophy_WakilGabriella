package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


import co.edu.unbosque.model.LoteriaDTO;

/**
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 *         La clase LoteriaDAO es una implementación de la interfaz
 *         CRUDOperation y se encarga de gestionar la persistencia y operaciones
 *         relacionadas con la entidad LoteriaDTO.
 * 
 *         Esta clase utiliza una lista de LoteriaDTO para almacenar y manipular
 *         los datos de juegos de lotería.
 */

public class LoteriaDAO implements CRUDOperation {

	private ArrayList<LoteriaDTO> apLoteria;
	private final String SERIAL_FILENAME = "apuestas-loteria.dat";
	int index = 0;

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

	public void writeSerializable() {
		FileHandler.openAndWriteFileLoteria(SERIAL_FILENAME, apLoteria);
	}

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

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		int salida = apLoteria.size() + 1;
		apLoteria.add((LoteriaDTO) obj);
		writeSerializable();

	}

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		apLoteria.forEach((chance) -> {
			sb.append((chance.toString() + "\n"));
		});
		return sb.toString();
	}

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

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apLoteria.size(); i++) {
			if (apLoteria.get(i).getIdLoteria() == index) {
				salida = true;
			}
		}
		return salida;
	}

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

	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
		double valorTotal = 0;
		for (LoteriaDTO loteria : apLoteria) {
			if (loteria.getCedulaApostador() == cedulaApostador) {
				valorTotal += loteria.getValorApuesta();
			}
		}
		return valorTotal;
	}

	public double calcularTotalApuestasPorSede(String sede) {
		double total = 0;
		for (LoteriaDTO loteria : apLoteria) {
			if (loteria.getSedeApostador() == sede) {
				total += loteria.getValorApuesta();
			}
		}
		return total;
	}

	public double calcularTotalValorApostado() {
		double total = 0;
		for (LoteriaDTO loteria : apLoteria) {
			total += loteria.getValorApuesta();
		}
		return total;
	}

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

	public String obtenerDetalleApuestasPorSede(String nombreSede) {
        StringBuilder detalle = new StringBuilder();
        for (LoteriaDTO loteria : apLoteria) {
            if (loteria.getSedeApostador().equalsIgnoreCase(nombreSede)) {
                detalle.append(loteria.toString()).append("\n");
            }
        }
        return detalle.toString();
    }
	
	public ArrayList<LoteriaDTO> getApLoteria() {
		return apLoteria;
	}

	public void setApLoteria(ArrayList<LoteriaDTO> apLoteria) {
		this.apLoteria = apLoteria;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getSERIAL_FILENAME() {
		return SERIAL_FILENAME;
	}

}
