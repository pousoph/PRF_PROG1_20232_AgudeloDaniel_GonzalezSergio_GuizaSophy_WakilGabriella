package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.UsuarioDTO;

public class UsuarioDAO {

	private ArrayList<UsuarioDTO> listaUsuarios;
	private final String FILEURL = "Csv/usuarios.csv";
	private final String SERIAL_FILENAME = "usuario.dat";
	int index = 0;
	String exit = "";

	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
		listaUsuarios = new ArrayList<UsuarioDTO>();
		if (FileHandler.openAndReadFileUsuario(SERIAL_FILENAME) != null) {
			@SuppressWarnings("unchecked")
			ArrayList<UsuarioDTO> temp2 = FileHandler.openAndReadFileUsuario(SERIAL_FILENAME);
			listaUsuarios = temp2;
		} else {
			listaUsuarios = new ArrayList<>();
		}
	}

	/**
	 * Método para escribir los datos serializados en el archivo correspondiente.
	 */

	public void writeSerializable() {
		FileHandler.openAndWriteFileUsuario(SERIAL_FILENAME, listaUsuarios);
	}

	/**
	 * Metodo para cargar datoos desde el archivo CSV
	 */
	public void loadFromFile() {
		String content = FileHandler.openAndReadFile(FILEURL);
		if (content.equals("")) {
			return;
		}
		String[] lines = content.split("\n");
		for (int i = 0; i < lines.length; i++) {
			String[] cols = lines[i].split(";");
			String username = cols[0];
			String constrasena = cols[1];

			listaUsuarios.add(new UsuarioDTO(username, constrasena));

		}
	}

	public void writeOnFile() {
		exit = "";
		listaUsuarios.forEach((usuarios) -> {
			if (usuarios.getClass().getSimpleName().toString().equals("UsuarioDTO")) {
				exit += usuarios.getNombreUsuario() + ";";
				exit += usuarios.getContrasena() + ";";
			}
		});
		FileHandler.openAndWriteFile(FILEURL, exit);
	}

	public void crearUsuario(String usuario, String contrasena) {
		listaUsuarios.add(new UsuarioDTO(usuario, contrasena));

		System.out.println("Nuevo usuario creado: " + usuario + contrasena);

		System.out.println("Usuarios cargados desde CSV: " + listaUsuarios.size());

		writeSerializable();
		writeOnFile();
	}

	public ArrayList<UsuarioDTO> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<UsuarioDTO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
