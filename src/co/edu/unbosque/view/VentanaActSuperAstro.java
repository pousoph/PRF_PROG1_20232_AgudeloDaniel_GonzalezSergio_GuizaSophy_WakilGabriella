package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaActSuperAstro extends JFrame {

	private PanelAgSuperAstro pnActSuperAstro;
	private PanelOpcAgSuperAstro p26;

	public VentanaActSuperAstro() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActSuperAstro = new PanelAgSuperAstro();
		p26 = new PanelOpcAgSuperAstro();
		add(p26, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgSuperAstro getPnActSuperAstro() {
		return pnActSuperAstro;
	}

	public void setPnActSuperAstro(PanelAgSuperAstro pnActSuperAstro) {
		this.pnActSuperAstro = pnActSuperAstro;
	}

	public PanelOpcAgSuperAstro getP26() {
		return p26;
	}

	public void setP26(PanelOpcAgSuperAstro p26) {
		this.p26 = p26;
	}

}
