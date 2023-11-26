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

/**
 * 
 * Panel de configuración de juegos que permite ingresar información como el
 * nombre, tipo y presupuesto del juego.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelCfgJuegos extends JPanel {
	private JLabel lblnombreJuego, lblTipoJuego, lblPresupuesto;
	private JTextField txtPresupuesto;
	private JComboBox<String> nombreJuego;
	private JComboBox<String> tipoJuego;
	private Image backgroundImage;

	// Define el tamaño de fuente deseado
	private static final int TAMANO_FUENTE = 16;

	/**
	 * Constructor que inicializa el panel de configuración de juegos.
	 */

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

	/**
	 * Obtiene la etiqueta del presupuesto del juego.
	 *
	 * @return La etiqueta del presupuesto del juego.
	 */

	public JLabel getLblPresupuesto() {
		return lblPresupuesto;
	}

	/**
	 * Establece la etiqueta del presupuesto del juego.
	 *
	 * @param lblPresupuesto La nueva etiqueta del presupuesto del juego.
	 */

	public void setLblPresupuesto(JLabel lblPresupuesto) {
		this.lblPresupuesto = lblPresupuesto;
	}

	/**
	 * Obtiene el campo de texto del presupuesto del juego.
	 *
	 * @return El campo de texto del presupuesto del juego.
	 */

	public JTextField getTxtPresupuesto() {
		return txtPresupuesto;
	}

	/**
	 * Establece el campo de texto del presupuesto del juego.
	 *
	 * @param txtPresupuesto El nuevo campo de texto del presupuesto del juego.
	 */

	public void setTxtPresupuesto(JTextField txtPresupuesto) {
		this.txtPresupuesto = txtPresupuesto;
	}

	/**
	 * Obtiene el ComboBox del nombre del juego.
	 *
	 * @return El ComboBox del nombre del juego.
	 */

	public JComboBox<String> getNombreJuego() {
		return nombreJuego;
	}

	/**
	 * Establece el ComboBox del nombre del juego.
	 *
	 * @param nombreJuego El nuevo ComboBox del nombre del juego.
	 */

	public void setNombreJuego(JComboBox<String> nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	/**
	 * Obtiene el ComboBox del tipo de juego.
	 *
	 * @return El ComboBox del tipo de juego.
	 */

	public JComboBox<String> getTipoJuego() {
		return tipoJuego;
	}

	/**
	 * Establece el ComboBox del tipo de juego.
	 *
	 * @param tipoJuego El nuevo ComboBox del tipo de juego.
	 */

	public void setTipoJuego(JComboBox<String> tipoJuego) {
		this.tipoJuego = tipoJuego;
	}

	/**
	 * Obtiene la imagen de fondo del panel.
	 *
	 * @return La imagen de fondo del panel.
	 */

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * Establece la imagen de fondo del panel.
	 *
	 * @param backgroundImage La nueva imagen de fondo del panel.
	 */

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}