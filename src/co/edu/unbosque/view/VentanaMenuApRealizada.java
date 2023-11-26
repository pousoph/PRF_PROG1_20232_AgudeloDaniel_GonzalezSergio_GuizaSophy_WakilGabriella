package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana del menú para apuestas realizadas.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaMenuApRealizada extends JFrame {

	private PanelMenuApRealizada pnApRealizada;
	private PanelOpcDetalleApuesta p31;

	/**
	 * Constructor de la clase.
	 */

	public VentanaMenuApRealizada() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnApRealizada = new PanelMenuApRealizada();
		p31 = new PanelOpcDetalleApuesta();
		add(p31, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel del menú para apuestas realizadas.
	 *
	 * @return El panel del menú para apuestas realizadas.
	 */

	public PanelMenuApRealizada getPnApRealizada() {
		return pnApRealizada;
	}

	/**
	 * Establece el panel del menú para apuestas realizadas.
	 *
	 * @param pnApRealizada El nuevo panel del menú para apuestas realizadas.
	 */

	public void setPnApRealizada(PanelMenuApRealizada pnApRealizada) {
		this.pnApRealizada = pnApRealizada;
	}

	/**
	 * Obtiene el panel de opciones de detalle de apuesta.
	 *
	 * @return El panel de opciones de detalle de apuesta.
	 */

	public PanelOpcDetalleApuesta getP31() {
		return p31;
	}

	/**
	 * Establece el panel de opciones de detalle de apuesta.
	 *
	 * @param p31 El nuevo panel de opciones de detalle de apuesta.
	 */

	public void setP31(PanelOpcDetalleApuesta p31) {
		this.p31 = p31;
	}

}
