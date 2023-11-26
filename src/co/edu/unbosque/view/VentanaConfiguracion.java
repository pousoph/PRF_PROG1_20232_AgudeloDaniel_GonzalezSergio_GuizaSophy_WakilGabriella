package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de configuración de la casa de apuestas.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaConfiguracion extends JFrame {

	private PanelBotonesConfiguracion p1;

	/**
	 * Constructor de la clase.
	 */

	public VentanaConfiguracion() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p1 = new PanelBotonesConfiguracion();
		setVisible(false);
	}

	/**
	 * Obtiene el panel de botones de configuración.
	 *
	 * @return El panel de botones de configuración.
	 */

	public PanelBotonesConfiguracion getP1() {
		return p1;
	}

	/**
	 * Establece el panel de botones de configuración.
	 *
	 * @param p1 El nuevo panel de botones de configuración.
	 */

	public void setP1(PanelBotonesConfiguracion p1) {
		this.p1 = p1;
	}

}