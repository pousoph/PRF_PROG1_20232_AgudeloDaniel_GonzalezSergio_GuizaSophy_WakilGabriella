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
 * Panel que contiene un JComboBox para seleccionar el tipo de filtro y una
 * imagen de fondo.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelValorTotalApxApos extends JPanel {

	private JComboBox<String> apostador;
	private Image backImage;

	/**
	 * Constructor de la clase PanelValorTotalApxApos. Configura la disposición y
	 * los elementos del panel, como el JComboBox y la imagen de fondo.
	 */

	public PanelValorTotalApxApos() {
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(80, 80, 80, 80);
		apostador = new JComboBox<String>();
		setVisible(true);
		apostador.setSize(1500, 75);
		apostador.setName("Filtrado");
		apostador.addItem("Apostador");
		apostador.addItem("Sede");
		apostador.addItem("Tipo Juego");

		add(apostador);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(apostador, gbc);

		backImage = new ImageIcon("./imgs/vConsultas.png").getImage();
		revalidate();
		repaint();
	}

	/**
	 * Método para dibujar la imagen de fondo en el panel.
	 *
	 * @param g Objeto Graphics utilizado para dibujar.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (backImage != null) {
			g.drawImage(backImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Obtiene el JComboBox de apostadores.
	 *
	 * @return JComboBox de apostadores.
	 */

	public JComboBox<String> getApostador() {
		return apostador;
	}

	/**
	 * Establece el JComboBox de apostadores.
	 *
	 * @param apostador Nuevo JComboBox de apostadores.
	 */

	public void setApostador(JComboBox<String> apostador) {
		this.apostador = apostador;
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
	 * @param backImage Nueva imagen de fondo.
	 */

	public void setBackImage(Image backImage) {
		this.backImage = backImage;
	}

}