package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;

/**
 * 
 * Panel que contiene elementos para ingresar el nombre de usuario y contraseña.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelUsuario extends JPanel {

	// Atributos
	private JLabel lblNombreUsuario, lblContrasena;
	private JTextField txtNombreUsuario;
	private JPasswordField txtContrasena;
	private Image backgroundImage;

	/**
	 * Constructor de la clase PanelUsuario. Configura la disposición y los
	 * elementos del panel, como etiquetas, campos de texto y fondo de imagen.
	 */

	public PanelUsuario() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Etiqueta y campo de nombre de usuario
		lblNombreUsuario = new JLabel("Usuario: ");
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombreUsuario.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lblNombreUsuario, gbc);

		txtNombreUsuario = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(txtNombreUsuario, gbc);

		// Etiqueta y campo de contraseña
		lblContrasena = new JLabel("Contraseña: ");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContrasena.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lblContrasena, gbc);

		txtContrasena = new JPasswordField(24);
		txtContrasena.setToolTipText("Solo se admiten letras y números");
		txtContrasena.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				txtContrasena.setToolTipText("Solo se admiten letras y números");
			}

			@Override
			public void focusGained(FocusEvent e) {
				// No es necesario implementar algo aquí si no es necesario
			}
		});
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(txtContrasena, gbc);

		// Fondo de imagen
		backgroundImage = new ImageIcon("./imgs/inicioSesion.png").getImage();
	}

	/**
	 * Método para dibujar el fondo de imagen en el panel.
	 *
	 * @param g Objeto Graphics utilizado para dibujar.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Obtiene la etiqueta del nombre de usuario.
	 *
	 * @return Etiqueta del nombre de usuario.
	 */

	public JLabel getLblNombreUsuario() {
		return lblNombreUsuario;
	}

	/**
	 * Establece la etiqueta del nombre de usuario.
	 *
	 * @param lblNombreUsuario Nueva etiqueta del nombre de usuario.
	 */

	public void setLblNombreUsuario(JLabel lblNombreUsuario) {
		this.lblNombreUsuario = lblNombreUsuario;
	}

	/**
	 * Obtiene la etiqueta de la contraseña.
	 *
	 * @return Etiqueta de la contraseña.
	 */

	public JLabel getLblContrasena() {
		return lblContrasena;
	}

	/**
	 * Establece la etiqueta de la contraseña.
	 *
	 * @param lblContrasena Nueva etiqueta de la contraseña.
	 */

	public void setLblContrasena(JLabel lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	/**
	 * Obtiene el campo de texto del nombre de usuario.
	 *
	 * @return Campo de texto del nombre de usuario.
	 */

	public JTextField getTxtNombreUsuario() {
		return txtNombreUsuario;
	}

	/**
	 * Establece el campo de texto del nombre de usuario.
	 *
	 * @param txtNombreUsuario Nuevo campo de texto del nombre de usuario.
	 */

	public void setTxtNombreUsuario(JTextField txtNombreUsuario) {
		this.txtNombreUsuario = txtNombreUsuario;
	}

	/**
	 * Obtiene el campo de contraseña.
	 *
	 * @return Campo de contraseña.
	 */

	public JPasswordField getTxtContrasena() {
		return txtContrasena;
	}

	/**
	 * Establece el campo de contraseña.
	 *
	 * @param txtContrasena Nuevo campo de contraseña.
	 */

	public void setTxtContrasena(JPasswordField txtContrasena) {
		this.txtContrasena = txtContrasena;
	}

	/**
	 * Obtiene la imagen de fondo.
	 *
	 * @return Imagen de fondo.
	 */

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * Establece la imagen de fondo.
	 *
	 * @param backgroundImage Nueva imagen de fondo.
	 */

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}