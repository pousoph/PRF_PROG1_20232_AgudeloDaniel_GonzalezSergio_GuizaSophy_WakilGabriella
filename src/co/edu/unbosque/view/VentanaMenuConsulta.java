package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenuConsulta extends JFrame {

	private PanelMenuConsultas p30;

	public VentanaMenuConsulta() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p30 = new PanelMenuConsultas();
		setVisible(false);
	}

	public PanelMenuConsultas getP30() {
		return p30;
	}

	public void setP30(PanelMenuConsultas p30) {
		this.p30 = p30;
	}

}
