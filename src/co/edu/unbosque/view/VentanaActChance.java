package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaActChance extends JFrame {

	private PanelAgChance pnActChance;
	private PanelOpcActApostador p20;

	public VentanaActChance() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActChance = new PanelAgChance();
		p20 = new PanelOpcActApostador();
		add(p20, BorderLayout.SOUTH);
		setVisible(false);

	}

	public PanelAgChance getPnActChance() {
		return pnActChance;
	}

	public void setPnActChance(PanelAgChance pnActChance) {
		this.pnActChance = pnActChance;
	}

	public PanelOpcActApostador getP20() {
		return p20;
	}

	public void setP20(PanelOpcActApostador p20) {
		this.p20 = p20;
	}

}
