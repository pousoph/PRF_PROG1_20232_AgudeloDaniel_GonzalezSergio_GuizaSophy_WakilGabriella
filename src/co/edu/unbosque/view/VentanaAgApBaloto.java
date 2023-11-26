package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de agregación de apuestas de Baloto.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaAgApBaloto extends JFrame {

	private PanelAgApBaloto pnAgApBaloto;
	private PanelBotonesAgBaloto p16;

	/**
	 * Constructor de la clase.
	 */

	public VentanaAgApBaloto() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgApBaloto = new PanelAgApBaloto();
		p16 = new PanelBotonesAgBaloto();
		add(p16, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de agregación de apuestas de Baloto.
	 *
	 * @return El panel de agregación de apuestas de Baloto.
	 */

	public PanelAgApBaloto getPnAgApBaloto() {
		return pnAgApBaloto;
	}

	/**
	 * Establece el panel de agregación de apuestas de Baloto.
	 *
	 * @param pnAgApBaloto El nuevo panel de agregación de apuestas de Baloto.
	 */

	public void setPnAgApBaloto(PanelAgApBaloto pnAgApBaloto) {
		this.pnAgApBaloto = pnAgApBaloto;
	}

	/**
	 * Obtiene el panel de botones de agregación de apuestas de Baloto.
	 *
	 * @return El panel de botones de agregación de apuestas de Baloto.
	 */

	public PanelBotonesAgBaloto getP16() {
		return p16;
	}

	/**
	 * Establece el panel de botones de agregación de apuestas de Baloto.
	 *
	 * @param p16 El nuevo panel de botones de agregación de apuestas de Baloto.
	 */

	public void setP16(PanelBotonesAgBaloto p16) {
		this.p16 = p16;
	}

}