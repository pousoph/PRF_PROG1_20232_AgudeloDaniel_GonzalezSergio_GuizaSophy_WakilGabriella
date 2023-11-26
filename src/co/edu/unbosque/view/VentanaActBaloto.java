package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de actualización de apuestas de Baloto.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaActBaloto extends JFrame {

	private PanelAgApBaloto pnActBaloto;
	private PanelBotonesActBaloto p17;

	/**
	 * Constructor de la clase.
	 */

	public VentanaActBaloto() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActBaloto = new PanelAgApBaloto();
		p17 = new PanelBotonesActBaloto();
		add(p17, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de actualización de apuestas de Baloto.
	 *
	 * @return El panel de actualización de apuestas de Baloto.
	 */

	public PanelAgApBaloto getPnActBaloto() {
		return pnActBaloto;
	}

	/**
	 * Establece el panel de actualización de apuestas de Baloto.
	 *
	 * @param pnActBaloto El nuevo panel de actualización de apuestas de Baloto.
	 */

	public void setPnActBaloto(PanelAgApBaloto pnActBaloto) {
		this.pnActBaloto = pnActBaloto;
	}

	/**
	 * Obtiene el panel de botones de actualización de apuestas de Baloto.
	 *
	 * @return El panel de botones de actualización de apuestas de Baloto.
	 */

	public PanelBotonesActBaloto getP17() {
		return p17;
	}

	/**
	 * Establece el panel de botones de actualización de apuestas de Baloto.
	 *
	 * @param p17 El nuevo panel de botones de actualización de apuestas de Baloto.
	 */

	public void setP17(PanelBotonesActBaloto p17) {
		this.p17 = p17;
	}

}