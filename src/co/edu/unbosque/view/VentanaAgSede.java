package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaAgSede extends JFrame {

	private PanelAgSede pnAgSede;
	private PanelOpcAgSede p9;

	public VentanaAgSede() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgSede = new PanelAgSede();
		p9 = new PanelOpcAgSede();
		add(p9, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgSede getPnAgSede() {
		return pnAgSede;
	}

	public void setPnAgSede(PanelAgSede pnAgSede) {
		this.pnAgSede = pnAgSede;
	}

	public PanelOpcAgSede getP9() {
		return p9;
	}

	public void setP9(PanelOpcAgSede p9) {
		this.p9 = p9;
	}

}
