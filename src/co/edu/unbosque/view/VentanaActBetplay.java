package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de actualización de apuestas de Betplay.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaActBetplay extends JFrame {

	private PanelAgApBetplay pnActBetplay;
	private PanelOpcActBetplay p29;

	/**
	 * Constructor de la clase.
	 */

	public VentanaActBetplay() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActBetplay = new PanelAgApBetplay();
		p29 = new PanelOpcActBetplay();
		add(p29, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de actualización de apuestas de Betplay.
	 *
	 * @return El panel de actualización de apuestas de Betplay.
	 */

	public PanelAgApBetplay getPnActBetplay() {
		return pnActBetplay;
	}

	/**
	 * Establece el panel de actualización de apuestas de Betplay.
	 *
	 * @param pnActBetplay El nuevo panel de actualización de apuestas de Betplay.
	 */

	public void setPnActBetplay(PanelAgApBetplay pnActBetplay) {
		this.pnActBetplay = pnActBetplay;
	}

	/**
	 * Obtiene el panel de opciones de actualización de apuestas de Betplay.
	 *
	 * @return El panel de opciones de actualización de apuestas de Betplay.
	 */

	public PanelOpcActBetplay getP29() {
		return p29;
	}

	/**
	 * Establece el panel de opciones de actualización de apuestas de Betplay.
	 *
	 * @param p29 El nuevo panel de opciones de actualización de apuestas de
	 *            Betplay.
	 */

	public void setP29(PanelOpcActBetplay p29) {
		this.p29 = p29;
	}

}