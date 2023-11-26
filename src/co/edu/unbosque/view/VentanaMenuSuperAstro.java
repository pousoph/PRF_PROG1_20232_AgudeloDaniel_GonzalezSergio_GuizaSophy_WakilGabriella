package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana del menú de SuperAstro.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaMenuSuperAstro extends JFrame {

	private PanelMenuSuperAstro p24;

	/**
	 * Constructor de la clase.
	 */
	public VentanaMenuSuperAstro() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p24 = new PanelMenuSuperAstro();
		setVisible(false);
	}

	/**
	 * Obtiene el panel de menú de SuperAstro.
	 *
	 * @return El panel de menú de SuperAstro.
	 */

	public PanelMenuSuperAstro getP24() {
		return p24;
	}

	/**
	 * Establece el panel de menú de SuperAstro.
	 *
	 * @param p24 El nuevo panel de menú de SuperAstro.
	 */

	public void setP24(PanelMenuSuperAstro p24) {
		this.p24 = p24;
	}

}