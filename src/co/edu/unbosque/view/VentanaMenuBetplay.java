package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana del menú para el juego de Betplay.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaMenuBetplay extends JFrame {

	private PanelMenuBetplay p27;

	/**
	 * Constructor de la clase.
	 */

	public VentanaMenuBetplay() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p27 = new PanelMenuBetplay();
		setVisible(false);
	}

	/**
	 * Obtiene el panel del menú para el juego de Betplay.
	 *
	 * @return El panel del menú para el juego de Betplay.
	 */

	public PanelMenuBetplay getP27() {
		return p27;
	}

	/**
	 * Establece el panel del menú para el juego de Betplay.
	 *
	 * @param p27 El nuevo panel del menú para el juego de Betplay.
	 */

	public void setP27(PanelMenuBetplay p27) {
		this.p27 = p27;
	}

}