package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * 
 * Panel que contiene un JComboBox para seleccionar una sede.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelListadoxSede extends JPanel {

	private JComboBox<String> sede;
	private Image backImage;

	/**
	 * Constructor que inicializa el panel con un JComboBox para las sedes.
	 */

	public PanelListadoxSede() {
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(80, 80, 80, 80);
		sede = new JComboBox<String>();
		setVisible(true);
		sede.setSize(1500, 75);
		sede.setName("Filtrado");
		sede.addItem("Sede");

		add(sede);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(sede, gbc);

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
	 * Obtiene el JComboBox de sedes.
	 *
	 * @return JComboBox de sedes.
	 */

	public JComboBox<String> getSede() {
		return sede;
	}

	/**
	 * Establece el JComboBox de sedes.
	 *
	 * @param sede JComboBox de sedes a establecer.
	 */

	public void setSede(JComboBox<String> sede) {
		this.sede = sede;
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