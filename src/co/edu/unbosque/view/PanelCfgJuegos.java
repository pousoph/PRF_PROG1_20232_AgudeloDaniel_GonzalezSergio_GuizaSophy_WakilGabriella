package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCfgJuegos extends JPanel {
	private JLabel lblnombreJuego, lblTipoJuego, lblPresupuesto;
	private JTextField txtPresupuesto;
	private JComboBox<String> nombreJuego;
	private JComboBox<String> tipoJuego;
	private Image backgroundImage;

	// Define el tamaño de fuente deseado
	private static final int TAMANO_FUENTE = 16;

	public PanelCfgJuegos() {
		// TODO Auto-generated constructor stub

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		nombreJuego = new JComboBox<String>();
		nombreJuego.setToolTipText("Seleccione nombre de juego.");
		nombreJuego.setName("Ingresa el nombre de juego: ");
		nombreJuego.addItem("Baloto");
		nombreJuego.addItem("Betplay");
		nombreJuego.addItem("Chance");
		nombreJuego.addItem("Loteria");
		nombreJuego.addItem("SuperAstro");
		// Aplica el tamaño de fuente
		nombreJuego.setFont(new Font("Tahoma", Font.PLAIN, TAMANO_FUENTE));
		nombreJuego.setForeground(Color.BLACK);
		nombreJuego.setBackground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel labelNombreJuego = new JLabel("Nombre del Juego:");
		labelNombreJuego.setFont(new Font("Tahoma", Font.BOLD, 18)); // Ajustar el tamaño de la fuente
		add(labelNombreJuego, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		add(nombreJuego, gbc);

		tipoJuego = new JComboBox<String>();
		tipoJuego.setToolTipText("Seleccione tipo de juego.");
		tipoJuego.setName("Ingresa el nombre de juego: ");
		tipoJuego.addItem("Baloto");
		tipoJuego.addItem("Deportivo");
		tipoJuego.addItem("Chance");
		tipoJuego.addItem("Loteria");
		tipoJuego.addItem("SuperAstro");
		// Aplica el tamaño de fuente
		tipoJuego.setFont(new Font("Tahoma", Font.PLAIN, TAMANO_FUENTE));
		tipoJuego.setForeground(Color.BLACK);
		tipoJuego.setBackground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel labelTipoJuego = new JLabel("Tipo de Juego:");
		labelTipoJuego.setFont(new Font("Tahoma", Font.BOLD, 18)); // Ajustar el tamaño de la fuente
		add(labelTipoJuego, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		add(tipoJuego, gbc);

		lblPresupuesto = new JLabel("Presupuesto del Juego: ");
		// Aplica el tamaño de fuente
		lblPresupuesto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPresupuesto.setForeground(Color.BLACK);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(lblPresupuesto, gbc);

		txtPresupuesto = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(txtPresupuesto, gbc);

		backgroundImage = new ImageIcon("./imgs/inicioSesion.png").getImage();
	}

	public JLabel getLblPresupuesto() {
		return lblPresupuesto;
	}

	public void setLblPresupuesto(JLabel lblPresupuesto) {
		this.lblPresupuesto = lblPresupuesto;
	}

	public JTextField getTxtPresupuesto() {
		return txtPresupuesto;
	}

	public void setTxtPresupuesto(JTextField txtPresupuesto) {
		this.txtPresupuesto = txtPresupuesto;
	}

	public JComboBox<String> getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(JComboBox<String> nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public JComboBox<String> getTipoJuego() {
		return tipoJuego;
	}

	public void setTipoJuego(JComboBox<String> tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}
