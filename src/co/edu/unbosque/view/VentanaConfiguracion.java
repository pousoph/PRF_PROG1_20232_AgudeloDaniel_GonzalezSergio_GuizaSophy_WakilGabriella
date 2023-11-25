package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaConfiguracion extends JFrame {

	private PanelBotonesConfiguracion p1;

	public VentanaConfiguracion() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p1 = new PanelBotonesConfiguracion();
		setVisible(false);
	}

	public PanelBotonesConfiguracion getP1() {
		return p1;
	}

	public void setP1(PanelBotonesConfiguracion p1) {
		this.p1 = p1;
	}

}
