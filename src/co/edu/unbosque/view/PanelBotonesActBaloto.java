package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Panel que contiene dos botones, uno para actualizar y otro para salir en el
 * contexto de Baloto.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelBotonesActBaloto extends JPanel {

	private JButton btn1, btn2;

	/**
	 * Constructor que inicializa y configura los botones de actualizar y salir.
	 */

	public PanelBotonesActBaloto() {
		// TODO Auto-generated constructor stub
		btn1 = new JButton("Actualizar");
		btn1.setActionCommand("ACTUALBALOTO");
		btn1.setBackground(new Color(134, 124, 157));
		ImageIcon temporal3 = new ImageIcon("./imgs/button_accActualizar.png");
		Image imTemporal3 = temporal3.getImage();
		int anchoD4 = 231;
		int alto4 = 54;
		Image imagenRed4 = imTemporal3.getScaledInstance(anchoD4, alto4, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(imagenRed4));
		btn1.setPreferredSize(new Dimension(231, 54));
		add(btn1);

		btn2 = new JButton("Salir");
		btn2.setActionCommand("SALIACTUALBALOTO");
		btn2.setBackground(new Color(134, 124, 157));
		ImageIcon temporal4 = new ImageIcon("./imgs/button_salir.png");
		Image imTemporal4 = temporal4.getImage();
		int anchoD5 = 180;
		int alto5 = 54;
		Image imagenRed5 = imTemporal4.getScaledInstance(anchoD5, alto5, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(imagenRed5));
		btn2.setPreferredSize(new Dimension(180, 54));
		add(btn2);
	}

	/**
	 * Obtiene el botón de actualizar.
	 *
	 * @return Botón de actualizar.
	 */

	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Establece el botón de actualizar.
	 *
	 * @param btn1 Botón de actualizar a establecer.
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	/**
	 * Obtiene el botón de salir.
	 *
	 * @return Botón de salir.
	 */

	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Establece el botón de salir.
	 *
	 * @param btn2 Botón de salir a establecer.
	 */

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

}