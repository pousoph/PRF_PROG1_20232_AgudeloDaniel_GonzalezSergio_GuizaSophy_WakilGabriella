package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaDepApostador extends JFrame {

	private PanelDepApostador pnDepApostador;
	private PanelOpcDepApostador p14;

	public VentanaDepApostador() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnDepApostador = new PanelDepApostador();
		p14 = new PanelOpcDepApostador();
		add(p14, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelDepApostador getPnDepApostador() {
		return pnDepApostador;
	}

	public void setPnDepApostador(PanelDepApostador pnDepApostador) {
		this.pnDepApostador = pnDepApostador;
	}

	public PanelOpcDepApostador getP14() {
		return p14;
	}

	public void setP14(PanelOpcDepApostador p14) {
		this.p14 = p14;
	}

}
