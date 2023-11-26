package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de agregación de apuestas para el juego de
 * Lotería.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaAgLoteria extends JFrame {

	private PanelAgLoteria pnAgLoteria;
	private PanelOpcAgLoteria p22;

	/**
	 * Constructor de la clase.
	 */

	public VentanaAgLoteria() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgLoteria = new PanelAgLoteria();
		p22 = new PanelOpcAgLoteria();
		add(p22, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de agregación de apuestas para el juego de Lotería.
	 *
	 * @return El panel de agregación de apuestas para el juego de Lotería.
	 */

	public PanelAgLoteria getPnAgLoteria() {
		return pnAgLoteria;
	}

	/**
	 * Establece el panel de agregación de apuestas para el juego de Lotería.
	 *
	 * @param pnAgLoteria El nuevo panel de agregación de apuestas para el juego de
	 *                    Lotería.
	 */

	public void setPnAgLoteria(PanelAgLoteria pnAgLoteria) {
		this.pnAgLoteria = pnAgLoteria;
	}

	/**
	 * Obtiene el panel de opciones de agregación de apuestas para el juego de
	 * Lotería.
	 *
	 * @return El panel de opciones de agregación de apuestas para el juego de
	 *         Lotería.
	 */

	public PanelOpcAgLoteria getP22() {
		return p22;
	}

	/**
	 * Establece el panel de opciones de agregación de apuestas para el juego de
	 * Lotería.
	 *
	 * @param p22 El nuevo panel de opciones de agregación de apuestas para el juego
	 *            de Lotería.
	 */

	public void setP22(PanelOpcAgLoteria p22) {
		this.p22 = p22;
	}

}