package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaModSede extends JFrame {

	private PanelAgSede pnModSede;
	private PanelBotoneMod p10;

	public VentanaModSede() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnModSede = new PanelAgSede();
		p10 = new PanelBotoneMod();
		add(p10, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgSede getPnModSede() {
		return pnModSede;
	}

	public void setPnModSede(PanelAgSede pnModSede) {
		this.pnModSede = pnModSede;
	}

	public PanelBotoneMod getP10() {
		return p10;
	}

	public void setP10(PanelBotoneMod p10) {
		this.p10 = p10;
	}

}
