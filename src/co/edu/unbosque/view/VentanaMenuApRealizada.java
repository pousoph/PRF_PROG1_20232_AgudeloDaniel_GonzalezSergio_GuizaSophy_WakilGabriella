package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenuApRealizada extends JFrame {

	private PanelMenuApRealizada pnApRealizada;
	private PanelOpcDetalleApuesta p31;

	public VentanaMenuApRealizada() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnApRealizada = new PanelMenuApRealizada();
		p31 = new PanelOpcDetalleApuesta();
		add(p31, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelMenuApRealizada getPnApRealizada() {
		return pnApRealizada;
	}

	public void setPnApRealizada(PanelMenuApRealizada pnApRealizada) {
		this.pnApRealizada = pnApRealizada;
	}

	public PanelOpcDetalleApuesta getP31() {
		return p31;
	}

	public void setP31(PanelOpcDetalleApuesta p31) {
		this.p31 = p31;
	}

	

}
