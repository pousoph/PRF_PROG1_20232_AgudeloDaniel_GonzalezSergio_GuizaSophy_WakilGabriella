package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de depósito de un apostador.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaDepApostador extends JFrame {

	private PanelDepApostador pnDepApostador;
	private PanelOpcDepApostador p14;

	/**
	 * Constructor de la clase.
	 */

	public VentanaDepApostador() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnDepApostador = new PanelDepApostador();
		p14 = new PanelOpcDepApostador();
		add(p14, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de depósito del apostador.
	 *
	 * @return El panel de depósito del apostador.
	 */

	public PanelDepApostador getPnDepApostador() {
		return pnDepApostador;
	}

	/**
	 * Establece el panel de depósito del apostador.
	 *
	 * @param pnDepApostador El nuevo panel de depósito del apostador.
	 */

	public void setPnDepApostador(PanelDepApostador pnDepApostador) {
		this.pnDepApostador = pnDepApostador;
	}

	/**
	 * Obtiene el panel de opciones de depósito del apostador.
	 *
	 * @return El panel de opciones de depósito del apostador.
	 */

	public PanelOpcDepApostador getP14() {
		return p14;
	}

	/**
	 * Establece el panel de opciones de depósito del apostador.
	 *
	 * @param p14 El nuevo panel de opciones de depósito del apostador.
	 */

	public void setP14(PanelOpcDepApostador p14) {
		this.p14 = p14;
	}

}
