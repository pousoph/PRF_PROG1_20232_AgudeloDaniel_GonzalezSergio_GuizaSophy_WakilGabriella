package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaActBaloto extends JFrame {

	private PanelAgApBaloto pnActBaloto;
	private PanelBotonesActBaloto p17;

	public VentanaActBaloto() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnActBaloto = new PanelAgApBaloto();
		p17 = new PanelBotonesActBaloto();
		add(p17, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgApBaloto getPnActBaloto() {
		return pnActBaloto;
	}

	public void setPnActBaloto(PanelAgApBaloto pnActBaloto) {
		this.pnActBaloto = pnActBaloto;
	}

	public PanelBotonesActBaloto getP17() {
		return p17;
	}

	public void setP17(PanelBotonesActBaloto p17) {
		this.p17 = p17;
	}

}
