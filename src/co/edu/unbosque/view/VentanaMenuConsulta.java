package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana del menú de consultas.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaMenuConsulta extends JFrame {

	private PanelMenuConsultas p30;

	/**
	 * Constructor de la clase.
	 */

	public VentanaMenuConsulta() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p30 = new PanelMenuConsultas();
		setVisible(false);
	}

	/**
	 * Obtiene el panel del menú de consultas.
	 *
	 * @return El panel del menú de consultas.
	 */

	public PanelMenuConsultas getP30() {
		return p30;
	}

	/**
	 * Establece el panel del menú de consultas.
	 *
	 * @param p30 El nuevo panel del menú de consultas.
	 */

	public void setP30(PanelMenuConsultas p30) {
		this.p30 = p30;
	}

}