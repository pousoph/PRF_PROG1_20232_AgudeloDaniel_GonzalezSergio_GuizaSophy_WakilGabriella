package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * La clase MainWindow representa la ventana principal de la aplicación "Casa de
 * Apuestas DSGS". Esta ventana contiene paneles para mostrar imágenes
 * (PanelImagenes) y botones (PanelBotones).
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class MainWindow extends JFrame {

	private PanelImagenes p1;
	private PanelBotones p2;

	/**
	 * Construye una nueva instancia de MainWindow. Configura la apariencia y
	 * disposición de la ventana, así como la creación de los paneles de imágenes y
	 * botones.
	 */

	public MainWindow() {
		// TODO Auto-generated constructor stub
		setBounds(0, 0, 800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Panel de Imágenes
		p1 = new PanelImagenes();
		add(p1);

		// Panel de Botones en la parte inferior
		p2 = new PanelBotones();
		add(p2, BorderLayout.SOUTH);

		setVisible(true);
	}

	/**
	 * Obtiene el panel de imágenes.
	 *
	 * @return El panel de imágenes.
	 */

	public PanelImagenes getP1() {
		return p1;
	}

	/**
	 * Establece el panel de imágenes.
	 *
	 * @param p1 El nuevo panel de imágenes.
	 */

	public void setP1(PanelImagenes p1) {
		this.p1 = p1;
	}

	/**
	 * Obtiene el panel de botones.
	 *
	 * @return El panel de botones.
	 */

	public PanelBotones getP2() {
		return p2;
	}

	/**
	 * Establece el panel de botones.
	 *
	 * @param p2 El nuevo panel de botones.
	 */

	public void setP2(PanelBotones p2) {
		this.p2 = p2;
	}

}