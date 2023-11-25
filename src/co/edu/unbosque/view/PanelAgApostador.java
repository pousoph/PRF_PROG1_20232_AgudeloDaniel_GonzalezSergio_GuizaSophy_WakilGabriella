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

public class PanelAgApostador extends JPanel {

	private JLabel lblNombre, lblCedula, lblSede, lblDireccion, lblNumCelular;
	private JTextField txtNombre, txtCedula, txtDireccion, txtNumCelular;
	private JComboBox<String> sede;
	private Image backgroundImage;

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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblCedula() {
		return lblCedula;
	}

	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	public JLabel getLblSede() {
		return lblSede;
	}

	public void setLblSede(JLabel lblSede) {
		this.lblSede = lblSede;
	}

	public JLabel getLblDireccion() {
		return lblDireccion;
	}

	public void setLblDireccion(JLabel lblDireccion) {
		this.lblDireccion = lblDireccion;
	}

	public JLabel getLblNumCelular() {
		return lblNumCelular;
	}

	public void setLblNumCelular(JLabel lblNumCelular) {
		this.lblNumCelular = lblNumCelular;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public JTextField getTxtNumCelular() {
		return txtNumCelular;
	}

	public void setTxtNumCelular(JTextField txtNumCelular) {
		this.txtNumCelular = txtNumCelular;
	}

	public JComboBox<String> getSede() {
		return sede;
	}

	public void setSede(JComboBox<String> sede) {
		this.sede = sede;
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}
