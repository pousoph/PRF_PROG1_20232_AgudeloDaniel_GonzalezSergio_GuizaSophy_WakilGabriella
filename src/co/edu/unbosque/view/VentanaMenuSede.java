package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenuSede extends JFrame {

	private PanelBotonesMenuSede p8;

	public VentanaMenuSede() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p8 = new PanelBotonesMenuSede();
		setVisible(false);
	}

	public PanelBotonesMenuSede getP8() {
		return p8;
	}

	public void setP8(PanelBotonesMenuSede p8) {
		this.p8 = p8;
	}

}
