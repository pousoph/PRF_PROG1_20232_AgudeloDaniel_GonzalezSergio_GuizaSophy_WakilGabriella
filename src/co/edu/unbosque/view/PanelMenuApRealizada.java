package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * 
 * Panel que contiene un JComboBox para seleccionar entre apostadores y sedes.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelMenuApRealizada extends JPanel {

	private JComboBox<String> apuesta;
	private Image backImage;

	/**
	 * Constructor que inicializa el panel con un JComboBox para apostadores y
	 * sedes.
	 */

	public PanelMenuApRealizada() {
		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(80, 80, 80, 80);
		apuesta = new JComboBox<String>();
		setVisible(true);
		apuesta.setSize(1500, 75);
		apuesta.setName("Filtrado");
		apuesta.addItem("Apostador");
		apuesta.addItem("Sede");

		add(apuesta);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(apuesta, gbc);

		backImage = new ImageIcon("./imgs/vConsultas.png").getImage();
		revalidate();
		repaint();
	}

	/**
	 * Sobrescribe el método paintComponent para dibujar una imagen de fondo en el
	 * panel.
	 *
	 * @param g El contexto de gráficos en el que se dibujará la imagen de fondo.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (backImage != null) {
			g.drawImage(backImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Obtiene el JComboBox de apuestas.
	 *
	 * @return JComboBox de apuestas.
	 */

	public JComboBox<String> getApuesta() {
		return apuesta;
	}

	/**
	 * Establece el JComboBox de apuestas.
	 *
	 * @param apuesta JComboBox de apuestas a establecer.
	 */

	public void setApuesta(JComboBox<String> apuesta) {
		this.apuesta = apuesta;
	}

	/**
	 * Obtiene la imagen de fondo.
	 *
	 * @return Imagen de fondo.
	 */

	public Image getBackImage() {
		return backImage;
	}

	/**
	 * Establece la imagen de fondo.
	 *
	 * @param backImage Imagen de fondo a establecer.
	 */

	public void setBackImage(Image backImage) {
		this.backImage = backImage;
	}

}