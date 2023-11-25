package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaActApostador extends JFrame {

	private PanelAgApostador pnActApostador;
	private PanelOpcActApostador p13;

	public VentanaActApostador() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActApostador = new PanelAgApostador();
		p13 = new PanelOpcActApostador();
		add(p13, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgApostador getPnActApostador() {
		return pnActApostador;
	}

	public void setPnActApostador(PanelAgApostador pnActApostador) {
		this.pnActApostador = pnActApostador;
	}

	public PanelOpcActApostador getP13() {
		return p13;
	}

	public void setP13(PanelOpcActApostador p13) {
		this.p13 = p13;
	}

}
