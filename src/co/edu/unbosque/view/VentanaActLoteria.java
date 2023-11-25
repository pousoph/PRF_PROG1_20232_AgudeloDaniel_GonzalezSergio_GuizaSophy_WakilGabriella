package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaActLoteria extends JFrame {

	private PanelAgLoteria pnActLoteria;
	private PanelOpcActLoteria p23;

	public VentanaActLoteria() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActLoteria = new PanelAgLoteria();
		p23 = new PanelOpcActLoteria();
		add(p23, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgLoteria getPnActLoteria() {
		return pnActLoteria;
	}

	public void setPnActLoteria(PanelAgLoteria pnActLoteria) {
		this.pnActLoteria = pnActLoteria;
	}

	public PanelOpcActLoteria getP23() {
		return p23;
	}

	public void setP23(PanelOpcActLoteria p23) {
		this.p23 = p23;
	}

}
