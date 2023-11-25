package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.unbosque.model.ApostadorDTO;

public class ApostadorDAO implements CRUDOperation {

	private ArrayList<ApostadorDTO> apostadores;
	private final String SERIAL_FILENAME = "apostadores.dat";
	int index = 0;

	public ApostadorDAO() {
		apostadores = new ArrayList<ApostadorDTO>();
		if (FileHandler.openAndReadFileApostador(SERIAL_FILENAME) != null) {
			ArrayList<ApostadorDTO> temp2 = FileHandler.openAndReadFileApostador(SERIAL_FILENAME);
			apostadores = temp2;
		} else {
			apostadores = new ArrayList<>();
		}
	}

	public void writeSerializable() {
		FileHandler.openAndWriteFileApostador(SERIAL_FILENAME, apostadores);
	}

	@Override
	public void create(String... strs) {
		// TODO Auto-generated method stub
		ApostadorDTO newApostador = new ApostadorDTO();
		newApostador.setId(Integer.parseInt(strs[0]));
		newApostador.setName(strs[1]);
		newApostador.setCedula(Long.parseLong(strs[2]));
		newApostador.setSede(strs[3]);
		newApostador.setDireccion(strs[4]);
		newApostador.setNumberCell(Long.parseLong(strs[5]));

		apostadores.add(newApostador);
		writeSerializable();

	}

	public String depurar(int ops, Object bus) {
		String salida = "";
		// Depurar por nombre
		if (ops == 1) {
			String name = (String) bus;
			for (int i = 0; i < apostadores.size(); i++) {
				if (apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")
						&& ((ApostadorDTO) apostadores.get(i)).getName().toLowerCase().contains(name.toLowerCase())) {
					salida += ((ApostadorDTO) apostadores.get(i)).toString() + "\n";
				}

			}
			// Depurar por cedula
		} else if (ops == 2) {
			for (int i = 0; i < apostadores.size(); i++) {
				Long cedula = Long.parseLong(bus + "");
				if (apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")) {
					String aux = ((ApostadorDTO) apostadores.get(i)).getCedula() + "";
					if (aux.contains(cedula + "")) {
						salida += ((ApostadorDTO) apostadores.get(i)).toString() + "\n";
					}
				}
			}
			// Depurar sede
		} else if (ops == 3) {
			for (int i = 0; i < apostadores.size(); i++) {
				String sede = (String) bus;
				if (apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")
						&& ((ApostadorDTO) apostadores.get(i)).getSede().toLowerCase().contains(sede.toLowerCase())) {
					salida += ((ApostadorDTO) apostadores.get(i)).toString() + "\n";
				}
			}
		}
		return salida;
	}

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getId() == index) {
				salida = true;
			}
		}
		return salida;
	}

	public ApostadorDTO search(int index) {
		ApostadorDTO salida = null;
		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getId() == index
					&& apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")) {
				salida = ((ApostadorDTO) apostadores.get(i));
			}
		}
		return salida;
	}

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		apostadores.add((ApostadorDTO) obj);
		writeSerializable();

	}

	@Override
	public String readAll() {
		StringBuilder sb = new StringBuilder();
		apostadores.forEach((apostador) -> {
			sb.append((apostador.toString() + "\n"));
		});
		return sb.toString();
	}

	public List<Long> getCedulasPorSede(String sede) {
		List<ApostadorDTO> apostadoresEnSede = apostadores.stream()
				.filter(apostador -> apostador.getSede().equalsIgnoreCase(sede)).collect(Collectors.toList());

		return apostadoresEnSede.stream().map(ApostadorDTO::getCedula).collect(Collectors.toList());
	}
	
	public List<ApostadorDTO> getApostadoresPorSede(String sede) {
	    // Filtrar la lista de apostadores por la sede proporcionada
	    List<ApostadorDTO> apostadoresEnSede = apostadores.stream()
	            .filter(apostador -> apostador.getSede().equalsIgnoreCase(sede))
	            .collect(Collectors.toList());

	    return apostadoresEnSede;
	}

	@Override
	public boolean updateByIndex(int index, String... newData) {
		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getId() == index
					&& apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")) {
				apostadores.get(i).setName(newData[0]);
				apostadores.get(i).setCedula(Long.parseLong(newData[1]));
				apostadores.get(i).setSede(newData[2]);
				apostadores.get(i).setDireccion(newData[3]);
				apostadores.get(i).setNumberCell(Long.parseLong(newData[4]));

				writeSerializable();
				return true;
			}
		}
		return true;
	}

	@Override
	public boolean delete(int index) {
		for (int i = 0; i < apostadores.size(); i++) {
			if (apostadores.get(i).getId() == index
					&& apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")) {
				apostadores.remove(i);
				writeSerializable();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		ApostadorDTO toDelete = ((ApostadorDTO) obj);
		if (apostadores.contains(toDelete)) {
			apostadores.remove(index);
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<ApostadorDTO> getApostadores() {
		return apostadores;
	}

	public void setApostadores(ArrayList<ApostadorDTO> apostadores) {
		this.apostadores = apostadores;
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

}
