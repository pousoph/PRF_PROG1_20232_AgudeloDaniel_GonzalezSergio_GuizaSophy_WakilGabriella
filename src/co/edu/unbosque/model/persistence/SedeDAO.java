package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.SedeDTO;
import co.edu.unbosque.util.SedeNoEncontradaException;

public class SedeDAO implements CRUDOperation {

	private ArrayList<SedeDTO> listaSedes;
	private ArrayList<ApostadorDTO> apostadores1;
	private ApostadorDAO apostadores;
	private final String SERIAL_FILENAME = "sedes.dat";
	int index = 0;

	public SedeDAO() {
		// TODO Auto-generated constructor stub
		listaSedes = new ArrayList<SedeDTO>();
		if (FileHandler.openAndReadFileSede(SERIAL_FILENAME) != null) {
			ArrayList<SedeDTO> temp3 = FileHandler.openAndReadFileSede(SERIAL_FILENAME);
			listaSedes = temp3;
		} else {
			listaSedes = new ArrayList<>();
		}
	}

	public void writeSerializable() {
		FileHandler.openAndWriteFileSede(SERIAL_FILENAME, listaSedes);
	}

	@Override
	public void create(String... strs) {
		// TODO Auto-generated method stub
		SedeDTO nSede = new SedeDTO();
		nSede.setIdSede(Integer.parseInt(strs[0]));
		nSede.setUbicacion(strs[1]);
		nSede.setNumEmpleados(Integer.parseInt(strs[2]));
		listaSedes.add(nSede);
		writeSerializable();

	}

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		listaSedes.add((SedeDTO) obj);

	}

	@Override
	public String readAll() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		listaSedes.forEach((sede) -> {
			sb.append((sede.toString() + "\n"));
		});
		return sb.toString();
	}

	/**
	 * Busca un militar en la lista por su ID.
	 *
	 * @param index ID del militar a buscar.
	 * @return true si se encuentra un militar con el ID dado, false en caso
	 *         contrario.
	 */

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < listaSedes.size(); i++) {
			if (listaSedes.get(i).getIdSede() == index) {
				salida = true;
			}
		}
		return salida;
	}

	public SedeDTO search(int index) {
		SedeDTO salida = null;
		for (int i = 0; i < listaSedes.size(); i++) {
			if (listaSedes.get(i).getIdSede() == index
					&& listaSedes.get(i).getClass().getSimpleName().toString().equals("SedeDTO")) {
				salida = ((SedeDTO) listaSedes.get(i));
			}
		}
		return salida;
	}

	public String getCedulasPorSede(String sede) {
		List<ApostadorDTO> apostadoresEnSede = ((Collection<ApostadorDTO>) apostadores).stream()
				.filter(apostador -> apostador.getSede().equalsIgnoreCase(sede)).collect(Collectors.toList());

		StringBuilder result = new StringBuilder("Cédulas en la sede " + sede + ":\n");
		apostadoresEnSede.forEach(apostador -> result.append(apostador.getCedula()).append("\n"));
		return result.toString();
	}

	@Override
	public boolean updateByIndex(int index, String... newData) {
		for (int i = 0; i < listaSedes.size(); i++) {
			if (listaSedes.get(i).getIdSede() == index && listaSedes.get(i) instanceof SedeDTO) {
				((SedeDTO) listaSedes.get(i)).setUbicacion(newData[0]);
				((SedeDTO) listaSedes.get(i)).setNumEmpleados(Integer.parseInt(newData[1]));
				writeSerializable();
				return true;
			}
		}
		return false; // Devolver false si no se encuentra la sede con el índice proporcionado
	}

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaSedes.size(); i++) {
			if (listaSedes.get(i).getIdSede() == index
					&& listaSedes.get(i).getClass().getSimpleName().toString().equals("SedeDTO")) {
				listaSedes.remove(i);
				writeSerializable();
			}
		}
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		SedeDTO toDelete = ((SedeDTO) obj);
		if (listaSedes.remove(toDelete)) {
			listaSedes.remove(index);
			writeSerializable();
			return true;
		} else {
			return false;
		}
	}

	public String obtenerSedePorNombre(String nombreSede) {
		for (SedeDTO sede : listaSedes) {
			if (sede.getUbicacion().equalsIgnoreCase(nombreSede.trim())) {
				{
					return sede.getUbicacion();
				}
			}

		}
		throw new SedeNoEncontradaException("Sede no encontrada para el nombre: " + nombreSede);

	}

	public ArrayList<SedeDTO> getListaSedes() {
		return listaSedes;
	}

	public void setListaSedes(ArrayList<SedeDTO> listaSedes) {
		this.listaSedes = listaSedes;
	}

	public void setApostador(ApostadorDAO nuevoApostador) {
		this.apostadores = nuevoApostador;
	}

	public ApostadorDAO getApostador() {
		return apostadores;
	}

	public List<ApostadorDTO> getApostadores1() {
		return apostadores1;
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
