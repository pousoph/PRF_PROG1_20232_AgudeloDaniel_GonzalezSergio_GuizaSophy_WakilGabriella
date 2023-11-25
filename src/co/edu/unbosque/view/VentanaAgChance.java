package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaAgChance extends JFrame {

	private PanelAgChance pnAgChance;
	private PanelOpcAgChance p19;

	public VentanaAgChance() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgChance = new PanelAgChance();
		p19 = new PanelOpcAgChance();
		add(p19, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgChance getPnAgChance() {
		return pnAgChance;
	}

	public void setPnAgChance(PanelAgChance pnAgChance) {
		this.pnAgChance = pnAgChance;
	}

	public PanelOpcAgChance getP19() {
		return p19;
	}

	public void setP19(PanelOpcAgChance p19) {
		this.p19 = p19;
	}

}
