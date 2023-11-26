package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Panel que contiene un botón para realizar la búsqueda de clientes por sede.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelOpcListadoxSede extends JPanel {

	private JButton btn1;

	/**
	 * Constructor de la clase PanelOpcListadoxSede. Configura el diseño del panel y
	 * agrega un botón con la funcionalidad de buscar clientes por sede.
	 */

	public PanelOpcListadoxSede() {
		btn1 = new JButton("Buscar");
		btn1.setActionCommand("BUSCARCLIENTE");
		btn1.setBackground(new Color(134, 124, 157));
		ImageIcon temporal3 = new ImageIcon("./imgs/button_accBuscar.png");
		Image imTemporal3 = temporal3.getImage();
		int anchoD4 = 231;
		int alto4 = 54;
		Image imagenRed4 = imTemporal3.getScaledInstance(anchoD4, alto4, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(imagenRed4));
		btn1.setPreferredSize(new Dimension(231, 54));
		add(btn1);

	}

	/**
	 * Obtiene el botón del panel.
	 *
	 * @return JButton que representa el botón del panel.
	 */

	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Establece el botón del panel.
	 *
	 * @param btn1 Nuevo JButton que se establecerá como el botón del panel.
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

}