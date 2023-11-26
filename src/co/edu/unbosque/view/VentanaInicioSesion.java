package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de inicio de sesión.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */
public class VentanaInicioSesion extends JFrame {

	private PanelBotones2 p3;
	private PanelUsuario pnUsuario;

	/**
	 * Constructor de la clase.
	 */
	public VentanaInicioSesion() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnUsuario = new PanelUsuario();
		p3 = new PanelBotones2();
		add(p3, BorderLayout.SOUTH);
		setVisible(false);
	}

	/**
	 * Obtiene el panel de botones.
	 *
	 * @return El panel de botones.
	 */

	public PanelBotones2 getP3() {
		return p3;
	}

	/**
	 * Establece el panel de botones.
	 *
	 * @param p3 El nuevo panel de botones.
	 */

	public void setP3(PanelBotones2 p3) {
		this.p3 = p3;
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