package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * 
 * Clase que representa la ventana de configuración de la casa de apuestas.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */
public class VentanaConfigCasaApuestas extends JFrame {

	private PanelConfiguracionCasAp pnCfCasa;
	private PanelBotonesCfgCasaApuestas p5;

	/**
	 * Constructor de la clase.
	 */

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

	/**
	 * Obtiene el panel de configuración de la casa de apuestas.
	 *
	 * @return El panel de configuración de la casa de apuestas.
	 */

	public PanelConfiguracionCasAp getPnCfCasa() {
		return pnCfCasa;
	}

	/**
	 * Establece el panel de configuración de la casa de apuestas.
	 *
	 * @param pnCfCasa El nuevo panel de configuración de la casa de apuestas.
	 */

	public void setPnCfCasa(PanelConfiguracionCasAp pnCfCasa) {
		this.pnCfCasa = pnCfCasa;
	}

	/**
	 * Obtiene el panel de botones de configuración de la casa de apuestas.
	 *
	 * @return El panel de botones de configuración de la casa de apuestas.
	 */

	public PanelBotonesCfgCasaApuestas getP5() {
		return p5;
	}

	/**
	 * Establece el panel de botones de configuración de la casa de apuestas.
	 *
	 * @param p5 El nuevo panel de botones de configuración de la casa de apuestas.
	 */

	public void setP5(PanelBotonesCfgCasaApuestas p5) {
		this.p5 = p5;
	}

}