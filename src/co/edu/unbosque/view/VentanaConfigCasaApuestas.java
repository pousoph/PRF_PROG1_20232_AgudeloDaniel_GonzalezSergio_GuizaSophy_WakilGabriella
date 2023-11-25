package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaConfigCasaApuestas extends JFrame {

	private PanelConfiguracionCasAp pnCfCasa;
	private PanelBotonesCfgCasaApuestas p5;

	public VentanaConfigCasaApuestas() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);

		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnCfCasa = new PanelConfiguracionCasAp();
		p5 = new PanelBotonesCfgCasaApuestas();
		add(p5, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelConfiguracionCasAp getPnCfCasa() {
		return pnCfCasa;
	}

	public void setPnCfCasa(PanelConfiguracionCasAp pnCfCasa) {
		this.pnCfCasa = pnCfCasa;
	}

	public PanelBotonesCfgCasaApuestas getP5() {
		return p5;
	}

	public void setP5(PanelBotonesCfgCasaApuestas p5) {
		this.p5 = p5;
	}

}
