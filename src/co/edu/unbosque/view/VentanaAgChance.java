package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de agregación de apuestas para el juego
 * Chance.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaAgChance extends JFrame {

	private PanelAgChance pnAgChance;
	private PanelOpcAgChance p19;

	/**
	 * Constructor de la clase.
	 */

	public VentanaAgChance() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgChance = new PanelAgChance();
		p19 = new PanelOpcAgChance();
		add(p19, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de agregación de apuestas para el juego Chance.
	 *
	 * @return El panel de agregación de apuestas para el juego Chance.
	 */

	public PanelAgChance getPnAgChance() {
		return pnAgChance;
	}

	/**
	 * Establece el panel de agregación de apuestas para el juego Chance.
	 *
	 * @param pnAgChance El nuevo panel de agregación de apuestas para el juego
	 *                   Chance.
	 */

	public void setPnAgChance(PanelAgChance pnAgChance) {
		this.pnAgChance = pnAgChance;
	}

	/**
	 * Obtiene el panel de opciones de agregación de apuestas para el juego Chance.
	 *
	 * @return El panel de opciones de agregación de apuestas para el juego Chance.
	 */

	public PanelOpcAgChance getP19() {
		return p19;
	}

	/**
	 * Establece el panel de opciones de agregación de apuestas para el juego
	 * Chance.
	 *
	 * @param p19 El nuevo panel de opciones de agregación de apuestas para el juego
	 *            Chance.
	 */

	public void setP19(PanelOpcAgChance p19) {
		this.p19 = p19;
	}

}