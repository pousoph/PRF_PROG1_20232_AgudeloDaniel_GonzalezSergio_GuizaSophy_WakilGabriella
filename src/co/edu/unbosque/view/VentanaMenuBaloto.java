package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenuBaloto extends JFrame {

	private PnBalotoMenu p15;

	public VentanaMenuBaloto() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p15 = new PnBalotoMenu();
		setVisible(false);
	}

	public PnBalotoMenu getP15() {
		return p15;
	}

	public void setP15(PnBalotoMenu p15) {
		this.p15 = p15;
	}

}
