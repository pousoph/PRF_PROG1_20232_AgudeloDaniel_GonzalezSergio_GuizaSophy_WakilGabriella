package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana del menú de sede.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaMenuSede extends JFrame {

	private PanelBotonesMenuSede p8;

	/**
	 * Constructor de la clase.
	 */

	public VentanaMenuSede() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p8 = new PanelBotonesMenuSede();
		setVisible(false);
	}

	/**
	 * Obtiene el panel de botones del menú de sede.
	 *
	 * @return El panel de botones del menú de sede.
	 */

	public PanelBotonesMenuSede getP8() {
		return p8;
	}

	/**
	 * Establece el panel de botones del menú de sede.
	 *
	 * @param p8 El nuevo panel de botones del menú de sede.
	 */

	public void setP8(PanelBotonesMenuSede p8) {
		this.p8 = p8;
	}

}