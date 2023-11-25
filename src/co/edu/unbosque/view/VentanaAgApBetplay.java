package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaAgApBetplay extends JFrame{
	
	private PanelAgApBetplay pnAgBetplay;
	private PanelOpcAgBetplay p28;
	
	public VentanaAgApBetplay() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgBetplay = new PanelAgApBetplay();
		p28 = new PanelOpcAgBetplay();
		add(p28, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgApBetplay getPnAgBetplay() {
		return pnAgBetplay;
	}

	public void setPnAgBetplay(PanelAgApBetplay pnAgBetplay) {
		this.pnAgBetplay = pnAgBetplay;
	}

	public PanelOpcAgBetplay getP28() {
		return p28;
	}

	public void setP28(PanelOpcAgBetplay p28) {
		this.p28 = p28;
	}

}
