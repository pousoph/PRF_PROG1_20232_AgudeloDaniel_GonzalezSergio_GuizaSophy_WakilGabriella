package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana del menú de lotería.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaMenuLoteria extends JFrame {

	private PnMenuLoteria p21;

	/**
	 * Constructor de la clase.
	 */

	public VentanaMenuLoteria() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p21 = new PnMenuLoteria();
		setVisible(false);
	}

	/**
	 * Obtiene el panel del menú de lotería.
	 *
	 * @return El panel del menú de lotería.
	 */

	public PnMenuLoteria getP21() {
		return p21;
	}

	/**
	 * Establece el panel del menú de lotería.
	 *
	 * @param p21 El nuevo panel del menú de lotería.
	 */

	public void setP21(PnMenuLoteria p21) {
		this.p21 = p21;
	}

}