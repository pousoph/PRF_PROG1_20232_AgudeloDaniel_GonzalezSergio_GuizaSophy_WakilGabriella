package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de valor total apostado por cliente.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class VentanaValorTotalAoxCliente extends JFrame {

	private PanelValorTotalApxApos pnTotalApxApos;
	private PanelOpcValorTotalApxCliente p32;

	/**
	 * Constructor de la clase.
	 */

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

	/**
	 * Obtiene el panel de valor total apostado por apuesta.
	 *
	 * @return El panel de valor total apostado por apuesta.
	 */

	public PanelValorTotalApxApos getPnTotalApxApos() {
		return pnTotalApxApos;
	}

	/**
	 * Establece el panel de valor total apostado por apuesta.
	 *
	 * @param pnTotalApxApos El nuevo panel de valor total apostado por apuesta.
	 */

	public void setPnTotalApxApos(PanelValorTotalApxApos pnTotalApxApos) {
		this.pnTotalApxApos = pnTotalApxApos;
	}

	/**
	 * Obtiene el panel de opciones de valor total apostado por cliente.
	 *
	 * @return El panel de opciones de valor total apostado por cliente.
	 */

	public PanelOpcValorTotalApxCliente getP32() {
		return p32;
	}

	/**
	 * Establece el panel de opciones de valor total apostado por cliente.
	 *
	 * @param p32 El nuevo panel de opciones de valor total apostado por cliente.
	 */

	public void setP32(PanelOpcValorTotalApxCliente p32) {
		this.p32 = p32;
	}

}