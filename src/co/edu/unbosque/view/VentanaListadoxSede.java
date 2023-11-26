package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de la lista por sede.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaListadoxSede extends JFrame {

	private PanelListadoxSede pnListadoxSede;
	private PanelOpcListadoxSede p33;

	/**
	 * Constructor de la clase.
	 */

	public VentanaListadoxSede() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnListadoxSede = new PanelListadoxSede();
		p33 = new PanelOpcListadoxSede();
		add(p33, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de la lista por sede.
	 *
	 * @return El panel de la lista por sede.
	 */

	public PanelListadoxSede getPnListadoxSede() {
		return pnListadoxSede;
	}

	/**
	 * Establece el panel de la lista por sede.
	 *
	 * @param pnListadoxSede El nuevo panel de la lista por sede.
	 */

	public void setPnListadoxSede(PanelListadoxSede pnListadoxSede) {
		this.pnListadoxSede = pnListadoxSede;
	}

	/**
	 * Obtiene el panel de opciones de la lista por sede.
	 *
	 * @return El panel de opciones de la lista por sede.
	 */

	public PanelOpcListadoxSede getP33() {
		return p33;
	}

	/**
	 * Establece el panel de opciones de la lista por sede.
	 *
	 * @param p33 El nuevo panel de opciones de la lista por sede.
	 */

	public void setP33(PanelOpcListadoxSede p33) {
		this.p33 = p33;
	}

}