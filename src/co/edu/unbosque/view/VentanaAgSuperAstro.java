package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaAgSuperAstro extends JFrame {

	private PanelAgSuperAstro pnAgSuperAstro;
	private PanelOpcAgSuperAstro p25;

	public VentanaAgSuperAstro() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgSuperAstro = new PanelAgSuperAstro();
		p25 = new PanelOpcAgSuperAstro();
		add(p25, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgSuperAstro getPnAgSuperAstro() {
		return pnAgSuperAstro;
	}

	public void setPnAgSuperAstro(PanelAgSuperAstro pnAgSuperAstro) {
		this.pnAgSuperAstro = pnAgSuperAstro;
	}

	public PanelOpcAgSuperAstro getP25() {
		return p25;
	}

	public void setP25(PanelOpcAgSuperAstro p25) {
		this.p25 = p25;
	}

}
