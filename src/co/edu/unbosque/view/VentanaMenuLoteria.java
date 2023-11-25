package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenuLoteria extends JFrame {

	private PnMenuLoteria p21;

	public VentanaMenuLoteria() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new GridLayout(1, 1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		p21 = new PnMenuLoteria();
		setVisible(false);
	}

	public PnMenuLoteria getP21() {
		return p21;
	}

	public void setP21(PnMenuLoteria p21) {
		this.p21 = p21;
	}

}
