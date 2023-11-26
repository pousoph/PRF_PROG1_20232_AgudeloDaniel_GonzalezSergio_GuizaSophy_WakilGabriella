package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana del menú para el apostador.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaMenuApostador extends JFrame {

	private PanelBotonesMenuApostador p11;


    /**
     * Constructor de la clase.
     */
	
	public VentanaMenuApostador() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p11 = new PanelBotonesMenuApostador();
		setVisible(false);
	}
	
	  /**
     * Obtiene el panel de botones del menú para el apostador.
     *
     * @return El panel de botones del menú para el apostador.
     */

	public PanelBotonesMenuApostador getP11() {
		return p11;
	}
	
	  /**
     * Establece el panel de botones del menú para el apostador.
     *
     * @param p11 El nuevo panel de botones del menú para el apostador.
     */

	public void setP11(PanelBotonesMenuApostador p11) {
		this.p11 = p11;
	}

}