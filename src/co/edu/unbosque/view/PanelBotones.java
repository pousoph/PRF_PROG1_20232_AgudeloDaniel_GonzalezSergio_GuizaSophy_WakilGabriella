package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Panel personalizado que contiene un botón para ingresar.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelBotones extends JPanel {

	private JButton btn;

	/**
	 * Constructor que inicializa y configura el botón de ingresar.
	 */

	public PanelBotones() {
		// TODO Auto-generated constructor stub
		btn = new JButton("Ingresar");
		btn.setActionCommand("USUARIO");
		ImageIcon temporal1 = new ImageIcon("./imgs/button_ingresar.png");
		Image imtemporal1 = temporal1.getImage();
		int anchoD = 180;
		int alto = 66;
		Image imagenRed = imtemporal1.getScaledInstance(anchoD, alto, Image.SCALE_SMOOTH);
		btn.setIcon(new ImageIcon(imagenRed));
		btn.setBackground(Color.WHITE);
		btn.setPreferredSize(new Dimension(180, 66));
		add(btn);

	}

	/**
	 * Obtiene el botón de ingresar.
	 *
	 * @return Botón de ingresar.
	 */

	public JButton getBtn() {
		return btn;
	}

	/**
	 * Establece el botón de ingresar.
	 *
	 * @param btn Botón de ingresar a establecer.
	 */

	public void setBtn(JButton btn) {
		this.btn = btn;
	}

}