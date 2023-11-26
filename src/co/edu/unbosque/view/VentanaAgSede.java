package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de agregación de sedes.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaAgSede extends JFrame {

	private PanelAgSede pnAgSede;
	private PanelOpcAgSede p9;

	/**
	 * Constructor de la clase.
	 */

	public VentanaAgSede() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgSede = new PanelAgSede();
		p9 = new PanelOpcAgSede();
		add(p9, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de agregación de sedes.
	 *
	 * @return El panel de agregación de sedes.
	 */

	public PanelAgSede getPnAgSede() {
		return pnAgSede;
	}

	/**
	 * Establece el panel de agregación de sedes.
	 *
	 * @param pnAgSede El nuevo panel de agregación de sedes.
	 */

	public void setPnAgSede(PanelAgSede pnAgSede) {
		this.pnAgSede = pnAgSede;
	}

	/**
	 * Obtiene el panel de opciones de agregación de sedes.
	 *
	 * @return El panel de opciones de agregación de sedes.
	 */

	public PanelOpcAgSede getP9() {
		return p9;
	}

	/**
	 * Establece el panel de opciones de agregación de sedes.
	 *
	 * @param p9 El nuevo panel de opciones de agregación de sedes.
	 */

	public void setP9(PanelOpcAgSede p9) {
		this.p9 = p9;
	}

}