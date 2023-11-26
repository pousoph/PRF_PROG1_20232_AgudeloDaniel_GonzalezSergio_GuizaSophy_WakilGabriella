package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de actualización de un apostador.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaActApostador extends JFrame {

	private PanelAgApostador pnActApostador;
	private PanelOpcActApostador p13;

	/**
	 * Constructor de la clase.
	 */

	public VentanaActApostador() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActApostador = new PanelAgApostador();
		p13 = new PanelOpcActApostador();
		add(p13, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de actualización de apostador.
	 *
	 * @return El panel de actualización de apostador.
	 */

	public PanelAgApostador getPnActApostador() {
		return pnActApostador;
	}

	/**
	 * Establece el panel de actualización de apostador.
	 *
	 * @param pnActApostador El nuevo panel de actualización de apostador.
	 */

	public void setPnActApostador(PanelAgApostador pnActApostador) {
		this.pnActApostador = pnActApostador;
	}

	/**
	 * Obtiene el panel de opciones de actualización de apostador.
	 *
	 * @return El panel de opciones de actualización de apostador.
	 */

	public PanelOpcActApostador getP13() {
		return p13;
	}

	/**
	 * Establece el panel de opciones de actualización de apostador.
	 *
	 * @param p13 El nuevo panel de opciones de actualización de apostador.
	 */

	public void setP13(PanelOpcActApostador p13) {
		this.p13 = p13;
	}

}
