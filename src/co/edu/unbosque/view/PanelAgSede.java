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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class PanelAgSede extends JPanel {

	private JLabel lblUbicacion, lblNumEmpleados;
	private JTextField txtNumEmpleados;
	private JComboBox<String> ubicacion;
	private Image backgroundImage;

	public PanelAgSede() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		// Etiqueta y campo de Ubicación
		ubicacion = new JComboBox<String>();
		ubicacion.setToolTipText("Seleccione ubicacion de la sede.");
		ubicacion.setName("Ingresa ubicacion de sede");
		ubicacion.addItem("Usaquen");
		ubicacion.addItem("Chapinero");
		ubicacion.addItem("Santa Fe");
		ubicacion.addItem("Tunjuelito");
		ubicacion.addItem("Bosa");
		ubicacion.addItem("Kennedy");
		ubicacion.addItem("Fontibon");
		ubicacion.addItem("Engativa");
		ubicacion.addItem("Suba");
		ubicacion.addItem("Barrios Unidos");
		ubicacion.addItem("Teusaquillo");
		ubicacion.addItem("Los Martires");
		ubicacion.addItem("Antonio Nariño");
		ubicacion.addItem("Puente Aranda");
		ubicacion.addItem("Candelaria");
		ubicacion.addItem("Rafael Uribe Uribe");
		ubicacion.addItem("Ciudad Bolivar");
		ubicacion.addItem("Sumapaz");
		ubicacion.setForeground(Color.BLACK);
		ubicacion.setBackground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel labelUbicacion = new JLabel("Ubicacion:");
		labelUbicacion.setFont(new Font("Tahoma", Font.BOLD, 18)); // Ajustar el tamaño de la fuente
		add(labelUbicacion, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		add(ubicacion, gbc);

		// Etiqueta y campo de número de empleados
		lblNumEmpleados = new JLabel("Número de Empleados: ");
		lblNumEmpleados.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumEmpleados.setForeground(Color.black);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lblNumEmpleados, gbc);

		txtNumEmpleados = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(txtNumEmpleados, gbc);

		// Fondo de imagen
		backgroundImage = new ImageIcon("./imgs/vSedesLlenar.png").getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	// Métodos getters y setters

	public JTextField getTxtNumEmpleados() {
		return txtNumEmpleados;
	}

	public JLabel getLblUbicacion() {
		return lblUbicacion;
	}

	public void setLblUbicacion(JLabel lblUbicacion) {
		this.lblUbicacion = lblUbicacion;
	}

	public JLabel getLblNumEmpleados() {
		return lblNumEmpleados;
	}

	public void setLblNumEmpleados(JLabel lblNumEmpleados) {
		this.lblNumEmpleados = lblNumEmpleados;
	}

	public JComboBox<String> getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(JComboBox<String> ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setTxtNumEmpleados(JTextField txtNumEmpleados) {
		this.txtNumEmpleados = txtNumEmpleados;
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
}
