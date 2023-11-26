package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana del menú para el juego de Baloto.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaMenuBaloto extends JFrame {

	private PnBalotoMenu p15;

	/**
	 * Constructor de la clase.
	 */

	public VentanaMenuBaloto() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p15 = new PnBalotoMenu();
		setVisible(false);
	}

	/**
	 * Obtiene el panel del menú para el juego de Baloto.
	 *
	 * @return El panel del menú para el juego de Baloto.
	 */

	public PnBalotoMenu getP15() {
		return p15;
	}

	/**
	 * Establece el panel del menú para el juego de Baloto.
	 *
	 * @param p15 El nuevo panel del menú para el juego de Baloto.
	 */

	public void setP15(PnBalotoMenu p15) {
		this.p15 = p15;
	}

}