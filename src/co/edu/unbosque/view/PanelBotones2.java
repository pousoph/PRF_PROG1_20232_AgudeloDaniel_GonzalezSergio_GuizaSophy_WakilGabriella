package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Panel personalizado que contiene dos botones, uno para acceder y otro para
 * registrar usuario.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelBotones2 extends JPanel {

	private JButton btn2, btn3;

	/**
	 * Constructor que inicializa y configura los botones de acceder y registrar
	 * usuario.
	 */

	public PanelBotones2() {
		// TODO Auto-generated constructor stub
		btn2 = new JButton("Acceder");
		btn2.setActionCommand("ACCEDER");
		btn2.setBackground(new Color(134, 124, 157));
		ImageIcon temporal2 = new ImageIcon("./imgs/button_acceder.png");
		Image imtemporal2 = temporal2.getImage();
		int anchoD3 = 180;
		int alto3 = 66;
		Image imagenRed3 = imtemporal2.getScaledInstance(anchoD3, alto3, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(imagenRed3));
		btn2.setPreferredSize(new Dimension(180, 66));
		add(btn2);

		btn3 = new JButton("Registrar");
		btn3.setActionCommand("REGISTRAR USUARIO");
		btn3.setBackground(new Color(134, 124, 157));
		ImageIcon temporal1 = new ImageIcon("./imgs/button_registrarse.png");
		Image imtemporal1 = temporal1.getImage();
		int anchoD2 = 180;
		int alto2 = 66;
		Image imagenRed = imtemporal1.getScaledInstance(anchoD2, alto2, Image.SCALE_SMOOTH);
		btn3.setIcon(new ImageIcon(imagenRed));
		btn3.setPreferredSize(new Dimension(180, 66));
		add(btn3);

	}

	/**
	 * Obtiene el botón para registrar usuario.
	 *
	 * @return Botón para registrar usuario.
	 */

	public JButton getBtn3() {
		return btn3;
	}

	/**
	 * Establece el botón para registrar usuario.
	 *
	 * @param btn3 Botón para registrar usuario a establecer.
	 */

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	/**
	 * Obtiene el botón para acceder.
	 *
	 * @return Botón para acceder.
	 */

	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Establece el botón para acceder.
	 *
	 * @param btn2 Botón para acceder a establecer.
	 */

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

}