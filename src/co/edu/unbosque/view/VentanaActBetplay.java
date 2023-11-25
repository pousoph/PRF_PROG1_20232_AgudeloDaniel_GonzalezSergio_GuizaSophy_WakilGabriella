package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaActBetplay extends JFrame {

	private PanelAgApBetplay pnActBetplay;
	private PanelOpcActBetplay p29;

	public VentanaActBetplay() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActBetplay = new PanelAgApBetplay();
		p29 = new PanelOpcActBetplay();
		add(p29, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgApBetplay getPnActBetplay() {
		return pnActBetplay;
	}

	public void setPnActBetplay(PanelAgApBetplay pnActBetplay) {
		this.pnActBetplay = pnActBetplay;
	}

	public PanelOpcActBetplay getP29() {
		return p29;
	}

	public void setP29(PanelOpcActBetplay p29) {
		this.p29 = p29;
	}

}
