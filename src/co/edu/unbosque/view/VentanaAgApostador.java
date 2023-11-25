package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaAgApostador extends JFrame {

	private PanelAgApostador pnAgApostador;
	private PanelOpcAgApostador p12;

	public VentanaAgApostador() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgApostador = new PanelAgApostador();
		p12 = new PanelOpcAgApostador();
		add(p12, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgApostador getPnAgApostador() {
		return pnAgApostador;
	}

	public void setPnAgApostador(PanelAgApostador pnAgApostador) {
		this.pnAgApostador = pnAgApostador;
	}

	public PanelOpcAgApostador getP12() {
		return p12;
	}

	public void setP12(PanelOpcAgApostador p12) {
		this.p12 = p12;
	}

}
