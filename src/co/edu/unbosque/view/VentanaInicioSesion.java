package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaInicioSesion extends JFrame {

	private PanelBotones2 p3;
	private PanelUsuario pnUsuario;

	public VentanaInicioSesion() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnUsuario = new PanelUsuario();
		p3 = new PanelBotones2();
		add(p3, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelBotones2 getP3() {
		return p3;
	}

	public void setP3(PanelBotones2 p3) {
		this.p3 = p3;
	}

	public PanelUsuario getPnUsuario() {
		return pnUsuario;
	}

	public void setPnUsuario(PanelUsuario pnUsuario) {
		this.pnUsuario = pnUsuario;
	}

}
