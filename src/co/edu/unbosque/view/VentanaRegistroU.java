package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de registro de usuario.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaRegistroU extends JFrame {

	private PanelBotonesRegistro p4;
	private PanelUsuario pnUsuario;

	/**
	 * Constructor de la clase.
	 */

	public VentanaRegistroU() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnUsuario = new PanelUsuario();
		p4 = new PanelBotonesRegistro();
		add(p4, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de botones de registro.
	 *
	 * @return El panel de botones de registro.
	 */

	public PanelBotonesRegistro getP4() {
		return p4;
	}

	/**
	 * Establece el panel de botones de registro.
	 *
	 * @param p4 El nuevo panel de botones de registro.
	 */

	public void setP4(PanelBotonesRegistro p4) {
		this.p4 = p4;
	}

	/**
	 * Obtiene el panel de usuario.
	 *
	 * @return El panel de usuario.
	 */

	public PanelUsuario getPnUsuario() {
		return pnUsuario;
	}

	/**
	 * Establece el panel de usuario.
	 *
	 * @param pnUsuario El nuevo panel de usuario.
	 */

	public void setPnUsuario(PanelUsuario pnUsuario) {
		this.pnUsuario = pnUsuario;
	}

}