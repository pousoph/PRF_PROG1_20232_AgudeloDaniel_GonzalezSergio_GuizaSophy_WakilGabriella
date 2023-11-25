package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame {

	private PanelBotonesMenuP p5;

	public MenuPrincipal() {
		setBounds(0, 0, 800, 600);
		setBackground(Color.WHITE);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Crear un JPanel para contener el PanelBotonesMenuP y centrarlo
		JPanel contenedorPanelBotones = new JPanel(new BorderLayout());

		p5 = new PanelBotonesMenuP();
		contenedorPanelBotones.add(p5, BorderLayout.CENTER);

		// Usar un GridLayout en la ventana principal
		setLayout(new GridLayout(1, 1));
		add(contenedorPanelBotones);

		setVisible(false);
	}

	public PanelBotonesMenuP getP5() {
		return p5;
	}

	public void setP5(PanelBotonesMenuP p5) {
		this.p5 = p5;
	}

	public static void main(String[] args) {
		new MenuPrincipal();
	}
}
