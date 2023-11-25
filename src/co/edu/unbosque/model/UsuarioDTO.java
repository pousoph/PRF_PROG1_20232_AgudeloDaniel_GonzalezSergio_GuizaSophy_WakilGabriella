package co.edu.unbosque.model;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8047609734135672907L;
	private String nombreUsuario;
	private String contrasena;

	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(String nombreUsuario, String contrasena) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuario: " + nombreUsuario + "\n");
		sb.append("Contraseña: " + contrasena + "\n");
		
		return sb.toString();
	}

}
