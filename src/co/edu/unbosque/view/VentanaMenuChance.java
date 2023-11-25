package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenuChance extends JFrame {

	private PanelBotonesMenuChance p18;

	public VentanaMenuChance() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p18 = new PanelBotonesMenuChance();
		setVisible(false);
	}

	public PanelBotonesMenuChance getP18() {
		return p18;
	}

	public void setP18(PanelBotonesMenuChance p18) {
		this.p18 = p18;
	}

}
