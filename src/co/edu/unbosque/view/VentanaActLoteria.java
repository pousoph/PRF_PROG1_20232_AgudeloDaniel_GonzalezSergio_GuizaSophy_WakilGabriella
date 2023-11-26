package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de actualización de apuestas de Lotería.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaActLoteria extends JFrame {

	private PanelAgLoteria pnActLoteria;
	private PanelOpcActLoteria p23;

	/**
	 * Constructor de la clase.
	 */

	public VentanaActLoteria() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActLoteria = new PanelAgLoteria();
		p23 = new PanelOpcActLoteria();
		add(p23, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de actualización de apuestas de Lotería.
	 *
	 * @return El panel de actualización de apuestas de Lotería.
	 */

	public PanelAgLoteria getPnActLoteria() {
		return pnActLoteria;
	}

	/**
	 * Establece el panel de actualización de apuestas de Lotería.
	 *
	 * @param pnActLoteria El nuevo panel de actualización de apuestas de Lotería.
	 */

	public void setPnActLoteria(PanelAgLoteria pnActLoteria) {
		this.pnActLoteria = pnActLoteria;
	}

	/**
	 * Obtiene el panel de opciones de actualización de apuestas de Lotería.
	 *
	 * @return El panel de opciones de actualización de apuestas de Lotería.
	 */

	public PanelOpcActLoteria getP23() {
		return p23;
	}

	/**
	 * Establece el panel de opciones de actualización de apuestas de Lotería.
	 *
	 * @param p23 El nuevo panel de opciones de actualización de apuestas de
	 *            Lotería.
	 */

	public void setP23(PanelOpcActLoteria p23) {
		this.p23 = p23;
	}

}