package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaCfgJuegos extends JFrame {

	private PanelBotonesCfgJuegos p6;
	private PanelCfgJuegos pnCfgJuegos;

	public VentanaCfgJuegos() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);

		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnCfgJuegos = new PanelCfgJuegos();
		p6 = new PanelBotonesCfgJuegos();
		add(p6, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelBotonesCfgJuegos getP6() {
		return p6;
	}

	public void setP6(PanelBotonesCfgJuegos p6) {
		this.p6 = p6;
	}

	public PanelCfgJuegos getPnCfgJuegos() {
		return pnCfgJuegos;
	}

	public void setPnCfgJuegos(PanelCfgJuegos pnCfgJuegos) {
		this.pnCfgJuegos = pnCfgJuegos;
	}

}
