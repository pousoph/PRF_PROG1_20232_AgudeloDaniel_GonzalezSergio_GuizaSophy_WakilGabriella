package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaAgLoteria extends JFrame {

	private PanelAgLoteria pnAgLoteria;
	private PanelOpcAgLoteria p22;

	public VentanaAgLoteria() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgLoteria = new PanelAgLoteria();
		p22 = new PanelOpcAgLoteria();
		add(p22, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgLoteria getPnAgLoteria() {
		return pnAgLoteria;
	}

	public void setPnAgLoteria(PanelAgLoteria pnAgLoteria) {
		this.pnAgLoteria = pnAgLoteria;
	}

	public PanelOpcAgLoteria getP22() {
		return p22;
	}

	public void setP22(PanelOpcAgLoteria p22) {
		this.p22 = p22;
	}

}
