package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaRegistroU extends JFrame{
	
	private PanelBotonesRegistro p4;
	private PanelUsuario pnUsuario;
	
	public VentanaRegistroU() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		pnUsuario = new PanelUsuario();
		p4 = new PanelBotonesRegistro();
		add(p4, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelBotonesRegistro getP4() {
		return p4;
	}

	public void setP4(PanelBotonesRegistro p4) {
		this.p4 = p4;
	}

	public PanelUsuario getPnUsuario() {
		return pnUsuario;
	}

	public void setPnUsuario(PanelUsuario pnUsuario) {
		this.pnUsuario = pnUsuario;
	}

}
