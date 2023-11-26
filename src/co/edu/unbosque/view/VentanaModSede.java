package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de modificación de sede.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaModSede extends JFrame {

	private PanelAgSede pnModSede;
	private PanelBotoneMod p10;

	/**
	 * Constructor de la clase.
	 */

	public VentanaModSede() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnModSede = new PanelAgSede();
		p10 = new PanelBotoneMod();
		add(p10, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de modificación de sede.
	 *
	 * @return El panel de modificación de sede.
	 */

	public PanelAgSede getPnModSede() {
		return pnModSede;
	}

	/**
	 * Establece el panel de modificación de sede.
	 *
	 * @param pnModSede El nuevo panel de modificación de sede.
	 */

	public void setPnModSede(PanelAgSede pnModSede) {
		this.pnModSede = pnModSede;
	}

	/**
	 * Obtiene el panel de botones de modificación.
	 *
	 * @return El panel de botones de modificación.
	 */

	public PanelBotoneMod getP10() {
		return p10;
	}

	/**
	 * Establece el panel de botones de modificación.
	 *
	 * @param p10 El nuevo panel de botones de modificación.
	 */

	public void setP10(PanelBotoneMod p10) {
		this.p10 = p10;
	}

}
