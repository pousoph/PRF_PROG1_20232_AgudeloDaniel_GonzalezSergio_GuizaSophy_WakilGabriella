package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * 
 * Clase que representa a un usuario con detalles como el nombre de usuario y la
 * contraseña.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class UsuarioDTO implements Serializable {

	/**
	 * UID serial predeterminado para la serialización.
	 */
	private static final long serialVersionUID = -8047609734135672907L;

	// Nombre de usuario
	private String nombreUsuario;

	// Contraseña del usuario
	private String contrasena;

	/**
	 * Constructor de la clase UsuarioDTO que inicializa algunos atributos con
	 * valores predeterminados.
	 */

	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase UsuarioDTO que inicializa los atributos con valores
	 * proporcionados.
	 *
	 * @param nombreUsuario Nombre de usuario.
	 * @param contrasena    Contraseña del usuario.
	 */

	public UsuarioDTO(String nombreUsuario, String contrasena) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	/**
	 * Obtiene el nombre de usuario.
	 *
	 * @return Nombre de usuario.
	 */

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Establece el nombre de usuario.
	 *
	 * @param nombreUsuario Nuevo nombre de usuario.
	 */

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 *
	 * @return Contraseña del usuario.
	 */

	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Establece la contraseña del usuario.
	 *
	 * @param contrasena Nueva contraseña del usuario.
	 */

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Genera una representación en cadena del usuario con detalles como el nombre
	 * de usuario y la contraseña.
	 *
	 * @return Una cadena que representa al usuario.
	 */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuario: " + nombreUsuario + "\n");
		sb.append("Contraseña: " + contrasena + "\n");

		return sb.toString();
	}

}