package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaValorTotalAoxCliente extends JFrame {

	private PanelValorTotalApxApos pnTotalApxApos;
	private PanelOpcValorTotalApxCliente p32;

	public VentanaValorTotalAoxCliente() {
		setSize(800, 600);
		setTitle("Casa de Apuestas DSGS");
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pnTotalApxApos = new PanelValorTotalApxApos();
		p32 = new PanelOpcValorTotalApxCliente();
		add(p32, BorderLayout.SOUTH);
		setVisible(false);
	}

	public PanelValorTotalApxApos getPnTotalApxApos() {
		return pnTotalApxApos;
	}

	public void setPnTotalApxApos(PanelValorTotalApxApos pnTotalApxApos) {
		this.pnTotalApxApos = pnTotalApxApos;
	}

	public PanelOpcValorTotalApxCliente getP32() {
		return p32;
	}

	public void setP32(PanelOpcValorTotalApxCliente p32) {
		this.p32 = p32;
	}

}
