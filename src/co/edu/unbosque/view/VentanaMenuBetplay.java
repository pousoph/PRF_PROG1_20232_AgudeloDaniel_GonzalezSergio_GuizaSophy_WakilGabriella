package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenuBetplay extends JFrame {

	private PanelMenuBetplay p27;

	public VentanaMenuBetplay() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p27 = new PanelMenuBetplay();
		setVisible(false);
	}

	public PanelMenuBetplay getP27() {
		return p27;
	}

	public void setP27(PanelMenuBetplay p27) {
		this.p27 = p27;
	}

}
