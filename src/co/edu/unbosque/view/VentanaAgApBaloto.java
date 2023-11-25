package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaAgApBaloto extends JFrame {
	
	private PanelAgApBaloto pnAgApBaloto;
	private PanelBotonesAgBaloto p16;
	
	public VentanaAgApBaloto() {
		// TODO Auto-generated constructor stub
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnAgApBaloto = new PanelAgApBaloto();
		p16 = new PanelBotonesAgBaloto();
		add(p16, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelAgApBaloto getPnAgApBaloto() {
		return pnAgApBaloto;
	}

	public void setPnAgApBaloto(PanelAgApBaloto pnAgApBaloto) {
		this.pnAgApBaloto = pnAgApBaloto;
	}

	public PanelBotonesAgBaloto getP16() {
		return p16;
	}

	public void setP16(PanelBotonesAgBaloto p16) {
		this.p16 = p16;
	}

}
