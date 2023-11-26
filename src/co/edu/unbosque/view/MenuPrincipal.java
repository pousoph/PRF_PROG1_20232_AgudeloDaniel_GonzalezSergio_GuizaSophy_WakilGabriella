package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * La clase MenuPrincipal representa la ventana principal del menú de la
 * aplicación "Casa de Apuestas DSGS". Contiene un panel de botones
 * (PanelBotonesMenuP) para la navegación principal.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class MenuPrincipal extends JFrame {

	private PanelBotonesMenuP p5;

	/**
	 * Construye una nueva instancia de MenuPrincipal. Configura la apariencia y
	 * disposición de la ventana, así como la creación del panel de botones para el
	 * menú principal.
	 */

	public MenuPrincipal() {
		setBounds(0, 0, 800, 600);
		setBackground(Color.WHITE);
		setTitle("Casa de Apuestas DSGS");
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel contenedorPanelBotones = new JPanel(new BorderLayout());

		p5 = new PanelBotonesMenuP();
		contenedorPanelBotones.add(p5, BorderLayout.CENTER);

		add(contenedorPanelBotones);

		setVisible(false);
	}

	/**
	 * Obtiene el panel de botones del menú principal.
	 *
	 * @return El panel de botones del menú principal.
	 */

	public PanelBotonesMenuP getP5() {
		return p5;
	}

	/**
	 * Establece el panel de botones del menú principal.
	 *
	 * @param p5 El nuevo panel de botones del menú principal.
	 */

	public void setP5(PanelBotonesMenuP p5) {
		this.p5 = p5;
	}

	/**
	 * Método principal para ejecutar la aplicación.
	 *
	 * @param args Los argumentos de la línea de comandos (no se utilizan en este
	 *             caso).
	 */

	public static void main(String[] args) {
		new MenuPrincipal();
	}
}