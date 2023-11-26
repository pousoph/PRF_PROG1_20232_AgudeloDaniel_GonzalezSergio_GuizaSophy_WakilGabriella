package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de configuración de juegos.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaCfgJuegos extends JFrame {

	private PanelBotonesCfgJuegos p6;
	private PanelCfgJuegos pnCfgJuegos;

	/**
	 * Constructor de la clase.
	 */

	public VentanaCfgJuegos() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);

		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnCfgJuegos = new PanelCfgJuegos();
		p6 = new PanelBotonesCfgJuegos();
		add(p6, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de botones de configuración de juegos.
	 *
	 * @return El panel de botones de configuración de juegos.
	 */

	public PanelBotonesCfgJuegos getP6() {
		return p6;
	}

	/**
	 * Establece el panel de botones de configuración de juegos.
	 *
	 * @param p6 El nuevo panel de botones de configuración de juegos.
	 */

	public void setP6(PanelBotonesCfgJuegos p6) {
		this.p6 = p6;
	}

	/**
	 * Obtiene el panel de configuración de juegos.
	 *
	 * @return El panel de configuración de juegos.
	 */

	public PanelCfgJuegos getPnCfgJuegos() {
		return pnCfgJuegos;
	}

	/**
	 * Establece el panel de configuración de juegos.
	 *
	 * @param pnCfgJuegos El nuevo panel de configuración de juegos.
	 */

	public void setPnCfgJuegos(PanelCfgJuegos pnCfgJuegos) {
		this.pnCfgJuegos = pnCfgJuegos;
	}

}
