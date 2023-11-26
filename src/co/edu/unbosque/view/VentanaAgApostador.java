package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de agregación de apostadores.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaAgApostador extends JFrame {

	private PanelAgApostador pnAgApostador;
	private PanelOpcAgApostador p12;

	/**
	 * Constructor de la clase.
	 */

	public VentanaAgApostador() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgApostador = new PanelAgApostador();
		p12 = new PanelOpcAgApostador();
		add(p12, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de agregación de apostadores.
	 *
	 * @return El panel de agregación de apostadores.
	 */

	public PanelAgApostador getPnAgApostador() {
		return pnAgApostador;
	}

	/**
	 * Establece el panel de agregación de apostadores.
	 *
	 * @param pnAgApostador El nuevo panel de agregación de apostadores.
	 */

	public void setPnAgApostador(PanelAgApostador pnAgApostador) {
		this.pnAgApostador = pnAgApostador;
	}

	/**
	 * Obtiene el panel de opciones de agregación de apostadores.
	 *
	 * @return El panel de opciones de agregación de apostadores.
	 */

	public PanelOpcAgApostador getP12() {
		return p12;
	}

	/**
	 * Establece el panel de opciones de agregación de apostadores.
	 *
	 * @param p12 El nuevo panel de opciones de agregación de apostadores.
	 */

	public void setP12(PanelOpcAgApostador p12) {
		this.p12 = p12;
	}

}