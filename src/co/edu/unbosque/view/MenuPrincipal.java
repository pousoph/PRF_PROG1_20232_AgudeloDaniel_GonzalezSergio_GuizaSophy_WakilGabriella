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
		setLayout(new BorderLayout());
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel contenedorPanelBotones = new JPanel(new BorderLayout());

		p5 = new PanelBotonesMenuP();
		contenedorPanelBotones.add(p5, BorderLayout.CENTER);

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
