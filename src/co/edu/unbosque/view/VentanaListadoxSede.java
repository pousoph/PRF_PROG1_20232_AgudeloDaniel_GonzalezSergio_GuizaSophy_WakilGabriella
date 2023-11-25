package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaListadoxSede extends JFrame{
	
	private PanelListadoxSede pnListadoxSede;
	private PanelOpcListadoxSede p33;
	
	public VentanaListadoxSede() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnListadoxSede = new PanelListadoxSede();
		p33 = new PanelOpcListadoxSede();
		add(p33, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelListadoxSede getPnListadoxSede() {
		return pnListadoxSede;
	}

	public void setPnListadoxSede(PanelListadoxSede pnListadoxSede) {
		this.pnListadoxSede = pnListadoxSede;
	}

	public PanelOpcListadoxSede getP33() {
		return p33;
	}

	public void setP33(PanelOpcListadoxSede p33) {
		this.p33 = p33;
	}

}
