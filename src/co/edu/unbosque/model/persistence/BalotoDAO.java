package co.edu.unbosque.model.persistence;

import java.time.LocalDate;
import java.util.ArrayList;


import co.edu.unbosque.model.BalotoDTO;

public class BalotoDAO implements CRUDOperation {

	private ArrayList<BalotoDTO> apBalotos;
	private final String SERIAL_FILENAME = "apuestas-baloto.dat";
	int index = 0;
	String exit = "";

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

	public void writeSerializable() {
		FileHandler.openAndWriteFileBaloto(SERIAL_FILENAME, apBalotos);
	}

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

	@Override
	public void create(Object obj) {
		// TODO Auto-generated method stub
		apBalotos.add((BalotoDTO) obj);
		writeSerializable();

	}

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

	public boolean searchById(int index) {
		boolean salida = false;
		for (int i = 0; i < apBalotos.size(); i++) {
			if (apBalotos.get(i).getIdBaloto() == index) {
				salida = true;
			}
		}
		return salida;
	}

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

	public boolean buscarPorId(int idBaloto) {
		return apBalotos.stream().anyMatch(apuesta -> apuesta.getIdBaloto() == idBaloto);
	}

	public BalotoDTO buscarApuesta(int idBaloto) {
		return apBalotos.stream().filter(apuesta -> apuesta.getIdBaloto() == idBaloto).findFirst().orElse(null);
	}

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
	
	public double calcularValorTotalApostadoPorCliente(long cedulaApostador) {
	    double valorTotal = 0;
	    for (BalotoDTO baloto : apBalotos) {
	        if (baloto.getCedulaApostador() == cedulaApostador) {
	            valorTotal += baloto.getValorApuesta();
	        }
	    }
	    return valorTotal;
	}
	
	public double calcularTotalApuestasPorSede(String sede) {
        double total = 0;
        for (BalotoDTO baloto : apBalotos) {
            if (baloto.getSedeApostador() == sede) {
                total += baloto.getValorApuesta();
            }
        }
        return total;
    }

	public double calcularTotalValorApostado() {
        double total = 0;
        for (BalotoDTO baloto : apBalotos) {
            total += baloto.getValorApuesta();
        }
        return total;
    }
	
	public String obtenerDetalleApuestasPorCedula(long cedulaApostador) {
		
	    ArrayList<String> detalles = new ArrayList<>();

	    BalotoDAO balotoDAO = new BalotoDAO();
	    for (BalotoDTO baloto : balotoDAO.getApBalotos()) {
	        if (baloto.getCedulaApostador() == cedulaApostador) {
	            detalles.add("ID Baloto: " + baloto.getIdBaloto() + ", Fecha: " + baloto.getDia() + ", Valor Apuesta: " + baloto.getValorApuesta());

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
        for (BalotoDTO baloto : apBalotos) {
            if (baloto.getSedeApostador().equalsIgnoreCase(nombreSede)) {
                detalle.append(baloto.toString()).append("\n");
            }
        }
        return detalle.toString();
    }

	public ArrayList<BalotoDTO> getApBalotos() {
		return apBalotos;
	}

	public void setApBalotos(ArrayList<BalotoDTO> apBalotos) {
		this.apBalotos = apBalotos;
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
