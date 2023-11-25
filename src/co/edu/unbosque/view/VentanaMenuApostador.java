package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenuApostador extends JFrame {

	private PanelBotonesMenuApostador p11;

	public VentanaMenuApostador() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p11 = new PanelBotonesMenuApostador();
		setVisible(false);
	}

	public PanelBotonesMenuApostador getP11() {
		return p11;
	}

	public void setP11(PanelBotonesMenuApostador p11) {
		this.p11 = p11;
	}

}
