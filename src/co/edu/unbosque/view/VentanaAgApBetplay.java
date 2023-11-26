package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de agregación de apuestas de Betplay.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaAgApBetplay extends JFrame {

	private PanelAgApBetplay pnAgBetplay;
	private PanelOpcAgBetplay p28;

	/**
	 * Constructor de la clase.
	 */
	public VentanaAgApBetplay() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgBetplay = new PanelAgApBetplay();
		p28 = new PanelOpcAgBetplay();
		add(p28, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de agregación de apuestas de Betplay.
	 *
	 * @return El panel de agregación de apuestas de Betplay.
	 */

	public PanelAgApBetplay getPnAgBetplay() {
		return pnAgBetplay;
	}

	/**
	 * Establece el panel de agregación de apuestas de Betplay.
	 *
	 * @param pnAgBetplay El nuevo panel de agregación de apuestas de Betplay.
	 */

	public void setPnAgBetplay(PanelAgApBetplay pnAgBetplay) {
		this.pnAgBetplay = pnAgBetplay;
	}

	/**
	 * Obtiene el panel de opciones de agregación de apuestas de Betplay.
	 *
	 * @return El panel de opciones de agregación de apuestas de Betplay.
	 */

	public PanelOpcAgBetplay getP28() {
		return p28;
	}

	/**
	 * Establece el panel de opciones de agregación de apuestas de Betplay.
	 *
	 * @param p28 El nuevo panel de opciones de agregación de apuestas de Betplay.
	 */

	public void setP28(PanelOpcAgBetplay p28) {
		this.p28 = p28;
	}

}