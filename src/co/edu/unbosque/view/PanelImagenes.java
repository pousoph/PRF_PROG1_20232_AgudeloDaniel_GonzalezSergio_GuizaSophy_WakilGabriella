package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImagenes extends JPanel {

	private BufferedImage img1;

	/**
	 * Constructor de la clase PanelImagenes. Carga una imagen desde un archivo y la
	 * almacena en una variable para su posterior visualización.
	 */

	public PanelImagenes() {
		try {
			img1 = ImageIO.read(new File("./imgs/vInicial.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sobreescribe el método paintComponent para dibujar la imagen en el panel.
	 *
	 * @param g Objeto Graphics utilizado para dibujar la imagen en el panel.
	 */

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int panelWidth = getWidth();
		int panelHeight = getHeight();

		// Redimensiona la imagen para que encaje en el panel
		Image imagenRedimension = img1.getScaledInstance(800, 600, Image.SCALE_SMOOTH);

		// Dibuja la imagen redimensionada en el panel
		g.drawImage(imagenRedimension, 0, 0, this);
	}

}
