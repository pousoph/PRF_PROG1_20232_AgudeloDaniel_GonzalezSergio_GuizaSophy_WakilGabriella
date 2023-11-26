package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de actualización de apuestas de Chance.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaActChance extends JFrame {

	private PanelAgChance pnActChance;
	private PanelOpcActApostador p20;

	/**
	 * Constructor de la clase.
	 */

	public VentanaActChance() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActChance = new PanelAgChance();
		p20 = new PanelOpcActApostador();
		add(p20, BorderLayout.SOUTH);
		setVisible(false);

	}

	/**
	 * Obtiene el panel de actualización de apuestas de Chance.
	 *
	 * @return El panel de actualización de apuestas de Chance.
	 */

	public PanelAgChance getPnActChance() {
		return pnActChance;
	}

	/**
	 * Establece el panel de actualización de apuestas de Chance.
	 *
	 * @param pnActChance El nuevo panel de actualización de apuestas de Chance.
	 */

	public void setPnActChance(PanelAgChance pnActChance) {
		this.pnActChance = pnActChance;
	}

	/**
	 * Obtiene el panel de opciones de actualización de apuestas de Chance.
	 *
	 * @return El panel de opciones de actualización de apuestas de Chance.
	 */

	public PanelOpcActApostador getP20() {
		return p20;
	}

	/**
	 * Establece el panel de opciones de actualización de apuestas de Chance.
	 *
	 * @param p20 El nuevo panel de opciones de actualización de apuestas de Chance.
	 */

	public void setP20(PanelOpcActApostador p20) {
		this.p20 = p20;
	}

}
