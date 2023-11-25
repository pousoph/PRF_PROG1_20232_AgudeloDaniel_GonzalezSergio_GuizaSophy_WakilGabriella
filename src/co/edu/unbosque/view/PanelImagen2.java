package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImagen2 extends JPanel {

	private BufferedImage img2;

	public PanelImagen2() {
		// TODO Auto-generated constructor stub
		try {
			img2 = ImageIO.read(new File("./imgs/inicioSesion.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int panelWidth = getWidth();
		int panelHeight = getHeight();

		// Redimensiona la imagen para que encaje en el panel
		Image imagenRedimension = img2.getScaledInstance(800, 600, Image.SCALE_SMOOTH);

		// Dibuja la imagen redimensionada en el panel
		g.drawImage(imagenRedimension, 0, 0, this);
	}

}
