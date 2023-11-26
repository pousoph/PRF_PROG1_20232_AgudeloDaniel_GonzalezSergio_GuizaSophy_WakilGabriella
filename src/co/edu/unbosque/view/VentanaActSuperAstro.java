package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de actualización de apuestas de SuperAstro.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaActSuperAstro extends JFrame {

	private PanelAgSuperAstro pnActSuperAstro;
	private PanelOpcAgSuperAstro p26;

	/**
	 * Constructor de la clase.
	 */

	public VentanaActSuperAstro() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActSuperAstro = new PanelAgSuperAstro();
		p26 = new PanelOpcAgSuperAstro();
		add(p26, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de actualización de apuestas de SuperAstro.
	 *
	 * @return El panel de actualización de apuestas de SuperAstro.
	 */

	public PanelAgSuperAstro getPnActSuperAstro() {
		return pnActSuperAstro;
	}

	/**
	 * Establece el panel de actualización de apuestas de SuperAstro.
	 *
	 * @param pnActSuperAstro El nuevo panel de actualización de apuestas de
	 *                        SuperAstro.
	 */

	public void setPnActSuperAstro(PanelAgSuperAstro pnActSuperAstro) {
		this.pnActSuperAstro = pnActSuperAstro;
	}

	/**
	 * Obtiene el panel de opciones de actualización de apuestas de SuperAstro.
	 *
	 * @return El panel de opciones de actualización de apuestas de SuperAstro.
	 */

	public PanelOpcAgSuperAstro getP26() {
		return p26;
	}

	/**
	 * Establece el panel de opciones de actualización de apuestas de SuperAstro.
	 *
	 * @param p26 El nuevo panel de opciones de actualización de apuestas de
	 *            SuperAstro.
	 */

	public void setP26(PanelOpcAgSuperAstro p26) {
		this.p26 = p26;
	}

}