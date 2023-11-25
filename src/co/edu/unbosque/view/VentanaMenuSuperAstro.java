package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenuSuperAstro extends JFrame {

	private PanelMenuSuperAstro p24;

	public VentanaMenuSuperAstro() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p24 = new PanelMenuSuperAstro();
		setVisible(false);
	}

	public PanelMenuSuperAstro getP24() {
		return p24;
	}

	public void setP24(PanelMenuSuperAstro p24) {
		this.p24 = p24;
	}

}
