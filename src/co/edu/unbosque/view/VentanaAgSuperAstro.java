package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 * 
 *         Clase que representa la ventana de agregación de apuestas SuperAstro.
 */

public class VentanaAgSuperAstro extends JFrame {

	private PanelAgSuperAstro pnAgSuperAstro;
	private PanelOpcAgSuperAstro p25;

	/**
	 * Constructor de la clase.
	 */

	public VentanaAgSuperAstro() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgSuperAstro = new PanelAgSuperAstro();
		p25 = new PanelOpcAgSuperAstro();
		add(p25, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de agregación de apuestas SuperAstro.
	 *
	 * @return El panel de agregación de apuestas SuperAstro.
	 */

	public PanelAgSuperAstro getPnAgSuperAstro() {
		return pnAgSuperAstro;
	}

	/**
	 * Establece el panel de agregación de apuestas SuperAstro.
	 *
	 * @param pnAgSuperAstro El nuevo panel de agregación de apuestas SuperAstro.
	 */

	public void setPnAgSuperAstro(PanelAgSuperAstro pnAgSuperAstro) {
		this.pnAgSuperAstro = pnAgSuperAstro;
	}

	/**
	 * Obtiene el panel de opciones de agregación de apuestas SuperAstro.
	 *
	 * @return El panel de opciones de agregación de apuestas SuperAstro.
	 */

	public PanelOpcAgSuperAstro getP25() {
		return p25;
	}

	/**
	 * Establece el panel de opciones de agregación de apuestas SuperAstro.
	 *
	 * @param p25 El nuevo panel de opciones de agregación de apuestas SuperAstro.
	 */

	public void setP25(PanelOpcAgSuperAstro p25) {
		this.p25 = p25;
	}

}