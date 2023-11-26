package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * La clase `PanelAgApostador` representa un panel para agregar apostadores en
 * la aplicación. Proporciona interfaces gráficas para ingresar información como
 * nombre, cédula, sede, dirección y número de celular.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelAgApostador extends JPanel {

	// Atributos
	private JLabel lblNombre, lblCedula, lblSede, lblDireccion, lblNumCelular;
	private JTextField txtNombre, txtCedula, txtDireccion, txtNumCelular;
	private JComboBox<String> sede;
	private Image backgroundImage;

	/**
	 * Constructor de la clase `PanelAgApostador`. Inicializa y configura los
	 * componentes gráficos del panel.
	 */

	public PanelAgApostador() {
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Etiqueta y campo de Nombre
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setForeground(Color.black);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lblNombre, gbc);

		txtNombre = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(txtNombre, gbc);

		// Etiqueta y campo de Cedula
		lblCedula = new JLabel("Cedula: ");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCedula.setForeground(Color.black);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lblCedula, gbc);

		txtCedula = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(txtCedula, gbc);

		// Etiqueta y campo de Sede
		lblSede = new JLabel("Sede: ");
		lblSede.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSede.setForeground(Color.black);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(lblSede, gbc);

		sede = new JComboBox<String>();
		sede.setToolTipText("Seleccione sede.");
		sede.setName("Ingresa sede");
		sede.addItem("Usaquen");
		sede.addItem("Chapinero");
		sede.addItem("Santa Fe");
		sede.addItem("Tunjuelito");
		sede.addItem("Bosa");
		sede.addItem("Kennedy");
		sede.addItem("Fontibon");
		sede.addItem("Engativa");
		sede.addItem("Suba");
		sede.addItem("Barrios Unidos");
		sede.addItem("Teusaquillo");
		sede.addItem("Los Martires");
		sede.addItem("Antonio Nariño");
		sede.addItem("Puente Aranda");
		sede.addItem("Candelaria");
		sede.addItem("Rafael Uribe Uribe");
		sede.addItem("Ciudad Bolivar");
		sede.addItem("Sumapaz");
		sede.setForeground(Color.black);
		sede.setBackground(Color.white);
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(sede, gbc);

		// Etiqueta y campo de Direccion
		lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDireccion.setForeground(Color.black);
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(lblDireccion, gbc);

		txtDireccion = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 3;
		add(txtDireccion, gbc);

		// Etiqueta y campo de Numero de Celular
		lblNumCelular = new JLabel("Número de Celular: ");
		lblNumCelular.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumCelular.setForeground(Color.black);
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(lblNumCelular, gbc);

		txtNumCelular = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 4;
		add(txtNumCelular, gbc);

		// Fondo de imagen
		backgroundImage = new ImageIcon("./imgs/vApostadores.png").getImage();
	}

	/**
	 * Sobrescribe el método paintComponent de JPanel para dibujar la imagen de
	 * fondo.
	 *
	 * @param g El contexto gráfico en el que se dibuja la imagen de fondo.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Obtiene la etiqueta que muestra el nombre en el perfil de usuario.
	 *
	 * @return La etiqueta del nombre.
	 */

	public JLabel getLblNombre() {
		return lblNombre;
	}

	/**
	 * Establece la etiqueta que muestra el nombre en el perfil de usuario.
	 *
	 * @param lblNombre La nueva etiqueta del nombre.
	 */

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	/**
	 * Obtiene la etiqueta que muestra la cédula en el perfil de usuario.
	 *
	 * @return La etiqueta de la cédula.
	 */

	public JLabel getLblCedula() {
		return lblCedula;
	}

	/**
	 * Establece la etiqueta que muestra la cédula en el perfil de usuario.
	 *
	 * @param lblCedula La nueva etiqueta de la cédula.
	 */

	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	/**
	 * Obtiene la etiqueta que muestra la sede en el perfil de usuario.
	 *
	 * @return La etiqueta de la sede.
	 */

	public JLabel getLblSede() {
		return lblSede;
	}

	/**
	 * Establece la etiqueta que muestra la sede en el perfil de usuario.
	 *
	 * @param lblSede La nueva etiqueta de la sede.
	 */

	public void setLblSede(JLabel lblSede) {
		this.lblSede = lblSede;
	}

	/**
	 * Obtiene la etiqueta que muestra la dirección en el perfil de usuario.
	 *
	 * @return La etiqueta de la dirección.
	 */

	public JLabel getLblDireccion() {
		return lblDireccion;
	}

	/**
	 * Establece la etiqueta que muestra la dirección en el perfil de usuario.
	 *
	 * @param lblDireccion La nueva etiqueta de la dirección.
	 */

	public void setLblDireccion(JLabel lblDireccion) {
		this.lblDireccion = lblDireccion;
	}

	/**
	 * Obtiene la etiqueta que muestra el número de celular en el perfil de usuario.
	 *
	 * @return La etiqueta del número de celular.
	 */

	public JLabel getLblNumCelular() {
		return lblNumCelular;
	}

	/**
	 * Establece la etiqueta que muestra el número de celular en el perfil de
	 * usuario.
	 *
	 * @param lblNumCelular La nueva etiqueta del número de celular.
	 */

	public void setLblNumCelular(JLabel lblNumCelular) {
		this.lblNumCelular = lblNumCelular;
	}

	/**
	 * Obtiene el campo de texto para ingresar o mostrar el nombre del usuario.
	 *
	 * @return El campo de texto del nombre.
	 */

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * Establece el campo de texto para ingresar o mostrar el nombre del usuario.
	 *
	 * @param txtNombre El nuevo campo de texto del nombre.
	 */

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	/**
	 * Obtiene el campo de texto para ingresar o mostrar la cédula del usuario.
	 *
	 * @return El campo de texto de la cédula.
	 */

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	/**
	 * Establece el campo de texto para ingresar o mostrar la cédula del usuario.
	 *
	 * @param txtCedula El nuevo campo de texto de la cédula.
	 */

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	/**
	 * Obtiene el campo de texto para ingresar o mostrar la dirección del usuario.
	 *
	 * @return El campo de texto de la dirección.
	 */

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	/**
	 * Establece el campo de texto para ingresar o mostrar la dirección del usuario.
	 *
	 * @param txtDireccion El nuevo campo de texto de la dirección.
	 */

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	/**
	 * Obtiene el campo de texto para ingresar o mostrar el número de celular del
	 * usuario.
	 *
	 * @return El campo de texto del número de celular.
	 */

	public JTextField getTxtNumCelular() {
		return txtNumCelular;
	}

	/**
	 * Establece el campo de texto para ingresar o mostrar el número de celular del
	 * usuario.
	 *
	 * @param txtNumCelular El nuevo campo de texto del número de celular.
	 */

	public void setTxtNumCelular(JTextField txtNumCelular) {
		this.txtNumCelular = txtNumCelular;
	}

	/**
	 * Obtiene el cuadro desplegable que almacena opciones de sedes como cadenas de
	 * texto.
	 *
	 * @return El cuadro desplegable de sedes.
	 */

	public JComboBox<String> getSede() {
		return sede;
	}

	/**
	 * Establece el cuadro desplegable que almacena opciones de sedes como cadenas
	 * de texto.
	 *
	 * @param sede El nuevo cuadro desplegable de sedes.
	 */

	public void setSede(JComboBox<String> sede) {
		this.sede = sede;
	}

	/**
	 * Obtiene la imagen de fondo para la interfaz gráfica del perfil de usuario.
	 *
	 * @return La imagen de fondo.
	 */

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * Establece la imagen de fondo para la interfaz gráfica del perfil de usuario.
	 *
	 * @param backgroundImage La nueva imagen de fondo.
	 */

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}