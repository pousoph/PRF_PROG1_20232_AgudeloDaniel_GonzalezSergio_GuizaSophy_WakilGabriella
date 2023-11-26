package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana del menú para el juego de Chance.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaMenuChance extends JFrame {

	private PanelBotonesMenuChance p18;

	/**
	 * Constructor de la clase.
	 */

	public VentanaMenuChance() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p18 = new PanelBotonesMenuChance();
		setVisible(false);
	}

	/**
	 * Obtiene el panel del menú para el juego de Chance.
	 *
	 * @return El panel del menú para el juego de Chance.
	 */

	public PanelBotonesMenuChance getP18() {
		return p18;
	}

	/**
	 * Establece el panel del menú para el juego de Chance.
	 *
	 * @param p18 El nuevo panel del menú para el juego de Chance.
	 */

	public void setP18(PanelBotonesMenuChance p18) {
		this.p18 = p18;
	}

}
